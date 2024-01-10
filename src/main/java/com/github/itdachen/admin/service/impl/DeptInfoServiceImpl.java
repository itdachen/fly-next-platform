package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IDeptInfoConvert;
import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.mapper.IDeptInfoMapper;
import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.admin.service.IDeptInfoService;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jxl.CellView;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;

/**
 * 部门管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class DeptInfoServiceImpl extends BizServiceImpl<IDeptInfoMapper, IDeptInfoConvert, DeptInfo, DeptInfoDto, DeptInfoVo, DeptInfoQuery, String> implements IDeptInfoService {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:10
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.DeptInfoVo>
     */
    @Override
    public TableData<DeptInfoVo> page(DeptInfoQuery params) throws Exception {
        Page<DeptInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptInfoVo> list = bizMapper.page(params);
        return new TableData<DeptInfoVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/5 0:46
     * @param deptInfoDto deptInfoDto
     * @return com.github.itdachen.admin.entity.DeptInfo
     */
    @Override
    public DeptInfoVo saveInfo(DeptInfoDto deptInfoDto) throws Exception {
        DeptInfo deptInfo = bizConvert.toJavaObject(deptInfoDto);
        deptInfo.setIsCanDel(YesOrNotConstant.YES);
        EntityUtils.setCreatAndUpdateInfo(deptInfo);
        bizMapper.insertSelective(deptInfo);
        return bizConvert.toJavaObjectVo(deptInfo);
    }

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023/4/5 0:46
     * @param deptInfoDto deptInfoDto
     * @return com.github.itdachen.admin.entity.DeptInfo
     */
    @Override
    public DeptInfoVo updateInfo(DeptInfoDto deptInfoDto) throws Exception {
        DeptInfo deptInfo = bizConvert.toJavaObject(deptInfoDto);
        DeptInfo dbDept = bizMapper.selectByPrimaryKey(deptInfo.getId());
        if (YesOrNotConstant.NOT.equals(dbDept.getIsCanDel())) {
            if (YesOrNotConstant.YES.equals(deptInfo.getIsCanDel())) {
                throw new BizException("非法操作");
            }
        }
        EntityUtils.setUpdatedInfo(deptInfo);
        bizMapper.updateByPrimaryKeySelective(deptInfo);
        return bizConvert.toJavaObjectVo(deptInfo);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2023/4/5 0:48
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        DeptInfo dept = bizMapper.selectByPrimaryKey(id);
        if (null == dept) {
            return 0;
        }
        if (YesOrNotConstant.NOT.equals(dept.getIsCanDel())) {
            throw new BizException("该部门不能删除");
        }
        Integer integer = bizMapper.hasChildren(id);
        if (null != integer) {
            throw new BizException("该部门存在子部门, 请先删除子部门");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }


    /***
     * 获取部门树
     *
     * @author 王大宸
     * @date 2023/4/4 23:46
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> zTree() throws BizException {
        ZTreeNode rootDept = bizMapper.findRootDept();
        if (null == rootDept) {
            rootDept = new ZTreeNode.Builder()
                    .id("0")
                    .name("FLY-NEXT")
                    .parentId("ROOT")
                    .build();
        }
        rootDept.setOpen(true);
        rootDept.setIconOpen(ZTreeNode.zTreeBuMenIcon);
        rootDept.setIconClose(ZTreeNode.zTreeJiGuoIcon);

        List<ZTreeNode> zTreeNode = bizMapper.zTree();
        zTreeNode.forEach(item -> {
            item.setOpen(true);
            item.setIconOpen(ZTreeNode.zTreeOpenIcon);
            item.setIconClose(ZTreeNode.zTreeCloseIcon);
        });
        zTreeNode.add(rootDept);

        return zTreeNode;
    }

    /***
     * 获取集合
     *
     * @author 王大宸
     * @date 2023/5/14 22:34
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.DeptInfoVo>
     */
    @Override
    public List<DeptInfoVo> apiDeptInfoList() throws Exception {
        return bizMapper.apiDeptInfoList();
    }

    @Override
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int rowSheetNum = 0;
        List<DeptInfoVo> deptInfoList = bizMapper.findDeptInfoList("root");
        List<DeptInfoVo> childrenData;
        for (DeptInfoVo deptInfoVo : deptInfoList) {
            childrenData = bizMapper.findDeptInfoList(deptInfoVo.getId());
            rowSheetNum += childrenData.size();
            deptInfoVo.setChildren(childrenData);
        }


        WritableWorkbook wwb = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            // excel 文件的 MIME 类型
            response.setContentType("application/msexcel");
            //在导出前对名称根据浏览器做下处理
            String agent = request.getHeader("USER-AGENT").toLowerCase();
            response.setContentType("application/vnd.ms-excel");
            //***************很重要
            String fileName = "部门信息";//文件名中文乱码
            String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            if (agent.contains("firefox")) {
                response.setCharacterEncoding("utf-8");
                response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
            } else {
                response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
            }

            wwb = jxl.Workbook.createWorkbook(os);
            /* Sheet 名称, 表格多少行 */
            WritableSheet ws = wwb.createSheet("部门信息", rowSheetNum); // 创建一个工作表

            // 设置标题单元格的文字格式
            WritableFont titleFont = new WritableFont(WritableFont.createFont("宋体"), 12,
                    WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            WritableCellFormat titleFontFormat = new WritableCellFormat(titleFont);
            titleFontFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            titleFontFormat.setAlignment(Alignment.CENTRE);
            titleFontFormat.setBackground(Colour.LIGHT_TURQUOISE);

            // 设置内容数据单元格的文字格式
            WritableFont cellFont = new WritableFont(WritableFont.createFont("宋体"), 12,
                    WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            WritableCellFormat cellFontFormat = new WritableCellFormat(cellFont);
            cellFontFormat.setVerticalAlignment(VerticalAlignment.CENTRE); //垂直居中
            cellFontFormat.setAlignment(Alignment.CENTRE); //文字对齐方式

            ws.getSettings().setDefaultColumnWidth(18);
            ws.getSettings().setDefaultRowHeight(300);

            CellView cellView = new CellView();
            cellView.setAutosize(true); //设置自动大小
            /*======= 设置列宽 =====*/
            ws.setColumnView(0, 30); //根据内容自动设置列宽
            ws.setColumnView(1, 30);
            ws.setColumnView(2, 30);
            ws.setColumnView(3, 24);

            /* 设置表头 */
            ws.addCell(new Label(0, 0, "部门信息", titleFontFormat));  // 第一个参数为: 第几列，第二个参数为: 第几行
            /* 合并表头单元格 */
            ws.mergeCells(0, 0, 3, 0);

            //ws.mergeCells(0, 0, 3, 0);//合并单元格 第一个参数从哪个列开始合并，第二个参数为第几行，第三个参数为到那一列结束，第四个参数为合并几行
            /*======= 填充标题 =====*/
            /* Label: 第几列, 第几行, 数据信息, 单元格样式 */
            ws.addCell(new Label(0, 1, "一级部门", titleFontFormat));
            ws.addCell(new Label(1, 1, "一级部门备注", titleFontFormat));
            ws.addCell(new Label(2, 1, "二级部门", titleFontFormat));
            ws.addCell(new Label(3, 1, "二级部门备注", titleFontFormat));

            int rowNum = 2;
            DeptInfoVo deptInfoVo;
            List<DeptInfoVo> children;
            for (int i = 0; i < deptInfoList.size(); i++) {
                deptInfoVo = deptInfoList.get(i);
                /* Label: 第几列, 第几行, 数据信息, 单元格样式 */
                ws.addCell(new Label(0, rowNum, deptInfoVo.getTitle(), cellFontFormat));
                ws.addCell(new Label(1, rowNum, deptInfoVo.getRemarks(), cellFontFormat));

                children = deptInfoVo.getChildren();
                int index = 0;
                for (DeptInfoVo child : children) {
                    ws.addCell(new Label(2, rowNum + index, child.getTitle(), cellFontFormat));
                    ws.addCell(new Label(3, rowNum + index, child.getRemarks(), cellFontFormat));
                    index++;
                }

                //合并节单元格: 开始: 第几列, 第几行  --> 结束: 第几列, 第几行
                ws.mergeCells(0, rowNum, 0, rowNum + deptInfoVo.getChildren().size() - 1);
                ws.mergeCells(1, rowNum, 1, rowNum + deptInfoVo.getChildren().size() - 1);


                rowNum += deptInfoVo.getChildren().size();
            }

            ws.toString();
            wwb.write();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wwb != null) {
                    wwb.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
