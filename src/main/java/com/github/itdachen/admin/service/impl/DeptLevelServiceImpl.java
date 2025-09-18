package com.github.itdachen.admin.service.impl;

import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiImpHelper;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiExpHelper;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.ExpParamsSettings;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.handler.IWriteWorkBook;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.utils.ExcelExpUtils;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.IReadWorkBookHandler;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.ImpParamsSettings;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.utils.ExcelImpUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DeptLevel;
import com.github.itdachen.admin.sdk.dto.DeptLevelDTO;
import com.github.itdachen.admin.sdk.query.DeptLevelQuery;
import com.github.itdachen.admin.sdk.vo.DeptLevelVO;
import com.github.itdachen.admin.mapper.IDeptLevelMapper;
import com.github.itdachen.admin.service.IDeptLevelService;
import com.github.itdachen.admin.convert.DeptLevelConvert;
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
 * 部门等级 业务实现
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
@Service
public class DeptLevelServiceImpl extends BizServiceImpl<IDeptLevelMapper, DeptLevel, DeptLevelDTO, DeptLevelVO, DeptLevelQuery, String> implements IDeptLevelService {
    private static final Logger logger = LoggerFactory.getLogger(DeptLevelServiceImpl.class);
    private static final DeptLevelConvert bizConvert = new DeptLevelConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();

    public DeptLevelServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("层级代码");
        EXP_FIELDS.add("层级名称");
        EXP_FIELDS.add("有效标志");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.deptLevelVo>
     */
    @Override
    public TableData<DeptLevelVO> page(DeptLevelQuery params) throws Exception {
        params.setRemoveFlag(YesOrNotConstant.N);
        params.setTenantId(BizContextHandler.getTenantId());
        Page<DeptLevelVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptLevelVO> list = bizMapper.list(params);
        return new TableData<DeptLevelVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2025/9/18 22:14
     * @param deptLevelDTO deptLevelDTO
     * @return com.github.itdachen.admin.sdk.vo.DeptLevelVO
     */
    @Override
    public DeptLevelVO saveInfo(DeptLevelDTO deptLevelDTO) throws Exception {
        DeptLevelVO deptLevelVO = bizMapper.selectDeptLevelVO(deptLevelDTO.getLevelCode());
        AssertUtils.isTrue(null != deptLevelVO, "该等级代码已经存在！");
        DeptLevel deptLevel = bizConvert.toJavaObject(deptLevelDTO);
        EntityUtils.setCreatAndUpdateInfo(deptLevel);
        deptLevel.setId(deptLevel.getLevelCode());
        deptLevel.setRemoveFlag(YesOrNotConstant.N);
        bizMapper.insertSelective(deptLevel);
        return bizConvert.toJavaObjectVO(deptLevel);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2025/9/18 22:14
     * @param deptLevelDTO deptLevelDTO
     * @return com.github.itdachen.admin.sdk.vo.DeptLevelVO
     */
    @Override
    public DeptLevelVO updateInfo(DeptLevelDTO deptLevelDTO) throws Exception {
        DeptLevelVO deptLevelVO = bizMapper.selectDeptLevelVO(deptLevelDTO.getLevelCode());
        AssertUtils.isTrue(null != deptLevelVO, "该等级代码已经存在！");

        DeptLevel deptLevel = bizConvert.toJavaObject(deptLevelDTO);
        EntityUtils.setUpdatedInfo(deptLevel);
        deptLevel.setRemoveFlag(YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(deptLevel);
        return bizConvert.toJavaObjectVO(deptLevel);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2025/9/18 22:14
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        DeptLevel deptLevel = new DeptLevel();
        deptLevel.setId(id);
        EntityUtils.setUpdatedInfo(deptLevel);
        deptLevel.setRemoveFlag(YesOrNotConstant.Y);
        bizMapper.updateByPrimaryKeySelective(deptLevel);
        return 1;
    }

    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param params com.github.itdachen.admin.sdk.query.DeptLevelQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        DeptLevelQuery params) throws Exception {

        new OOXmlPoiExpHelper<DeptLevelVO, DeptLevelQuery>()
                .settings(new ExpParamsSettings<DeptLevelQuery>(request, response,
                        BizContextHandler.getUserDetails(), "部门等级", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<DeptLevelVO, DeptLevelQuery>() {

                    @Override
                    public Long total(DeptLevelQuery params) {
                        return bizMapper.list_COUNT(params);
                    }

                    @Override
                    public List<DeptLevelVO> data(DeptLevelQuery params, Integer page, Integer limit) {
                        PageHelper.startPage(page, limit);
                        return bizMapper.list(params);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<DeptLevelVO> list, boolean hasRowNum) {
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
        new OOXmlPoiImpHelper<DeptLevel>()
                .settings(new ImpParamsSettings(request, response,
                        BizContextHandler.getUserDetails(),
                        "部门等级", 2
                ))
                .workBookFile(file)
                .readWorkBook(
                        new IReadWorkBookHandler<DeptLevel>() {
                            @Override
                            public void readRows(UserInfoDetails userDetails, List<DeptLevel> list, Row row, int index, String sheetName) {
                                readWorkBook(userDetails, list, row, index, sheetName);
                            }

                            @Override
                            public void handler(List<DeptLevel> list) {
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
    private void readWorkBook(UserInfoDetails userDetails, List<DeptLevel> list, Row row, int index, String sheetName) {
        DeptLevel deptLevel = new DeptLevel();
        deptLevel.setId(EntityUtils.getId());
        deptLevel.setTenantId(userDetails.getTenantId());
        deptLevel.setCreateTime(LocalDateTime.now());
        deptLevel.setCreateUserId(userDetails.getId());
        deptLevel.setCreateUser(userDetails.getNickName());
        deptLevel.setUpdateTime(LocalDateTime.now());
        deptLevel.setUpdateUserId(userDetails.getId());
        deptLevel.setUpdateUser(userDetails.getNickName());

        // 其他数据操作

        list.add(deptLevel);

    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<DeptLevelVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        DeptLevelVO deptLevelVO = new DeptLevelVO();
        for (int i = 0; i < list.size(); i++) {
            deptLevelVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, deptLevelVO.getLevelCode(), textCellStyle); // 层级代码
            ExcelExpUtils.setCellValue(row, 2, deptLevelVO.getLevelTitle(), textCellStyle); // 层级名称,例如: 00-总部; 10-省级部门; 20-市州级部门; 30-区县级;40-乡镇级;50-社区/街道/村
            ExcelExpUtils.setCellValue(row, 3, deptLevelVO.getValidFlag(), textCellStyle); // 有效标志: Y-是;N-否
        }
    }

}
