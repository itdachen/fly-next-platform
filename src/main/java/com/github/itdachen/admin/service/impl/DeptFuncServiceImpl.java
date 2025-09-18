package com.github.itdachen.admin.service.impl;

import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiImpHelper;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiExpHelper;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.ExpParamsSettings;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.handler.IWriteWorkBook;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.utils.ExcelExpUtils;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.IReadWorkBookHandler;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.ImpParamsSettings;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DeptFunc;
import com.github.itdachen.admin.sdk.dto.DeptFuncDTO;
import com.github.itdachen.admin.sdk.query.DeptFuncQuery;
import com.github.itdachen.admin.sdk.vo.DeptFuncVO;
import com.github.itdachen.admin.mapper.IDeptFuncMapper;
import com.github.itdachen.admin.service.IDeptFuncService;
import com.github.itdachen.admin.convert.DeptFuncConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 部门职能管理 业务实现
 *
 * @author 王大宸
 * @date 2025-09-18 23:03:17
 */
@Service
public class DeptFuncServiceImpl extends BizServiceImpl<IDeptFuncMapper, DeptFunc, DeptFuncDTO, DeptFuncVO, DeptFuncQuery, String> implements IDeptFuncService {
    private static final Logger logger = LoggerFactory.getLogger(DeptFuncServiceImpl.class);
    private static final DeptFuncConvert bizConvert = new DeptFuncConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();
    private static final Integer DEPT_FUNC_START = 100;

    public DeptFuncServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("部门职能编码");
        EXP_FIELDS.add("职能标题");
        EXP_FIELDS.add("职能简称");
        EXP_FIELDS.add("有效标志");
        EXP_FIELDS.add("备注");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.deptFuncVo>
     */
    @Override
    public TableData<DeptFuncVO> page(DeptFuncQuery params) throws Exception {
        Page<DeptFuncVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptFuncVO> list = bizMapper.list(params);
        return new TableData<DeptFuncVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2025/9/18 23:18
     * @param deptFuncDTO deptFuncDTO
     * @return com.github.itdachen.admin.sdk.vo.DeptFuncVO
     */
    @Override
    public DeptFuncVO saveInfo(DeptFuncDTO deptFuncDTO) throws Exception {
        DeptFuncVO deptFuncByTitle = bizMapper.findDeptFuncByTitle(BizContextHandler.getTenantId(), deptFuncDTO.getTitle());
        AssertUtils.isTrue(null != deptFuncByTitle, "该职能名称已经存在！");


        DeptFuncQuery query = DeptFuncQuery.builder()
                .tenantId(BizContextHandler.getTenantId())
                .build();
        Long total = bizMapper.list_COUNT(query);

        if (null == total) {
            total = 0L;
        }
        total++;

        String funcCode = String.valueOf(DEPT_FUNC_START + total);

        DeptFunc deptFunc = bizConvert.toJavaObject(deptFuncDTO);
        deptFunc.setFuncCode(funcCode);
        EntityUtils.setCreatAndUpdateInfo(deptFunc);
        deptFunc.setId(funcCode);
        deptFunc.setRemoveFlag(YesOrNotConstant.N);

        if (StringUtils.isEmpty(deptFunc.getTitleAs())) {
            deptFunc.setTitleAs(deptFunc.getTitle());
        }

        bizMapper.insertSelective(deptFunc);
        return bizConvert.toJavaObjectVO(deptFunc);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2025/9/18 23:19
     * @param deptFuncDTO deptFuncDTO
     * @return com.github.itdachen.admin.sdk.vo.DeptFuncVO
     */
    @Override
    public DeptFuncVO updateInfo(DeptFuncDTO deptFuncDTO) throws Exception {
        DeptFuncVO deptFuncByTitle = bizMapper.findDeptFuncByTitle(BizContextHandler.getTenantId(), deptFuncDTO.getTitle());
        AssertUtils.isTrue(null != deptFuncByTitle && !deptFuncDTO.getId().equals(deptFuncByTitle.getId()), "该职能名称已经存在！");
        return super.updateInfo(deptFuncDTO);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2025/9/18 23:19
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        DeptFunc deptFunc = new DeptFunc();
        deptFunc.setId(id);
        deptFunc.setRemoveFlag(YesOrNotConstant.Y);
        EntityUtils.setUpdatedInfo(deptFunc);
        bizMapper.updateByPrimaryKeySelective(deptFunc);
        return 1;
    }

    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param params com.github.itdachen.admin.sdk.query.DeptFuncQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        DeptFuncQuery params) throws Exception {

        new OOXmlPoiExpHelper<DeptFuncVO, DeptFuncQuery>()
                .settings(new ExpParamsSettings<DeptFuncQuery>(request, response,
                        BizContextHandler.getUserDetails(), "部门职能管理", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<DeptFuncVO, DeptFuncQuery>() {

                    @Override
                    public Long total(DeptFuncQuery params) {
                        return bizMapper.list_COUNT(params);
                    }

                    @Override
                    public List<DeptFuncVO> data(DeptFuncQuery params, Integer page, Integer limit) {
                        PageHelper.startPage(page, limit);
                        return bizMapper.list(params);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<DeptFuncVO> list, boolean hasRowNum) {
                        writeToWorkBook(workbook, sheet, list, hasRowNum);
                    }
                })
                .execute()
                .reply();
    }

    /***
     * 导入
     *
     * @author 王大宸
     * @date 2025/7/29 9:55
     * @param request request
     * @param response response
     * @param file file
     * @return void
     */
    @Override
    public void impInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        MultipartFile file) throws Exception {
        new OOXmlPoiImpHelper<DeptFunc>()
                .settings(new ImpParamsSettings(request, response,
                        BizContextHandler.getUserDetails(),
                        "部门职能管理", 2
                ))
                .workBookFile(file)
                .readWorkBook(
                        new IReadWorkBookHandler<DeptFunc>() {
                            @Override
                            public void readRows(UserInfoDetails userDetails, List<DeptFunc> list, Row row, int index, String sheetName) {
                                readWorkBook(userDetails, list, row, index, sheetName);
                            }

                            @Override
                            public void handler(List<DeptFunc> list) {
                                bizMapper.batchSave(list);
                            }
                        }
                )
                .execute()
                .reply();


    }


    /***
     * 读取表格数据
     *
     * @author 王大宸
     * @date 2025/7/29 10:03
     * @param list list
     * @param row row
     * @param index index
     * @param sheetName sheetName
     * @return void
     */
    private void readWorkBook(UserInfoDetails userDetails, List<DeptFunc> list, Row row, int index, String sheetName) {
        DeptFunc deptFunc = new DeptFunc();
        deptFunc.setId(EntityUtils.getId());
        deptFunc.setTenantId(userDetails.getTenantId());
        deptFunc.setCreateTime(LocalDateTime.now());
        deptFunc.setCreateUserId(userDetails.getId());
        deptFunc.setCreateUser(userDetails.getNickName());
        deptFunc.setUpdateTime(LocalDateTime.now());
        deptFunc.setUpdateUserId(userDetails.getId());
        deptFunc.setUpdateUser(userDetails.getNickName());

        // 其他数据操作

        list.add(deptFunc);

    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<DeptFuncVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        DeptFuncVO deptFuncVO = new DeptFuncVO();
        for (int i = 0; i < list.size(); i++) {
            deptFuncVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, deptFuncVO.getFuncCode(), textCellStyle); // 部门职能编码, 例如: 001-销售;002-研发
            ExcelExpUtils.setCellValue(row, 2, deptFuncVO.getTitle(), textCellStyle); // 职能标题
            ExcelExpUtils.setCellValue(row, 3, deptFuncVO.getTitleAs(), textCellStyle); // 职能简称
            ExcelExpUtils.setCellValue(row, 4, deptFuncVO.getValidFlag(), textCellStyle); // 有效标志: Y-有效;N-无效
            ExcelExpUtils.setCellValue(row, 5, deptFuncVO.getRemarks(), textCellStyle); // 备注
        }
    }

}
