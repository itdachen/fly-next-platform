package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.DeptFunc;
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
import com.github.itdachen.boot.oplog.ooxml.poi.imp.utils.ExcelImpUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.ClazzFunc;
import com.github.itdachen.admin.sdk.dto.ClazzFuncDTO;
import com.github.itdachen.admin.sdk.query.ClazzFuncQuery;
import com.github.itdachen.admin.sdk.vo.ClazzFuncVO;
import com.github.itdachen.admin.mapper.IClazzFuncMapper;
import com.github.itdachen.admin.service.IClazzFuncService;
import com.github.itdachen.admin.convert.ClazzFuncConvert;
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
 * 岗位职能管理 业务实现
 *
 * @author 王大宸
 * @date 2025-09-18 22:27:28
 */
@Service
public class ClazzFuncServiceImpl extends BizServiceImpl<IClazzFuncMapper, ClazzFunc, ClazzFuncDTO, ClazzFuncVO, ClazzFuncQuery, String> implements IClazzFuncService {
    private static final Logger logger = LoggerFactory.getLogger(ClazzFuncServiceImpl.class);
    private static final ClazzFuncConvert bizConvert = new ClazzFuncConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();
    private static final Integer CLAZZ_START_START = 100;

    public ClazzFuncServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("岗位职能编码");
        EXP_FIELDS.add("岗位职能标题");
        EXP_FIELDS.add("有效标志");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.clazzFuncVo>
     */
    @Override
    public TableData<ClazzFuncVO> page(ClazzFuncQuery params) throws Exception {
        params.setRemoveFlag(YesOrNotConstant.N);
        params.setTenantId(BizContextHandler.getTenantId());
        Page<ClazzFuncVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ClazzFuncVO> list = bizMapper.list(params);
        return new TableData<ClazzFuncVO>(page.getTotal(), list);
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2025/9/18 22:33
     * @param clazzFuncDTO clazzFuncDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzFuncVO
     */
    @Override
    public ClazzFuncVO saveInfo(ClazzFuncDTO clazzFuncDTO) throws Exception {


        ClazzFuncVO clazzFuncVO = bizMapper.findClazzFuncByTitle(BizContextHandler.getTenantId(), clazzFuncDTO.getFuncTitle());
        AssertUtils.isTrue(null != clazzFuncVO, "该岗位职能名称已经存在！");

        ClazzFuncQuery query = ClazzFuncQuery.builder()
                .tenantId(BizContextHandler.getTenantId())
                .build();
        Long total = bizMapper.list_COUNT(query);

        if (null == total) {
            total = 0L;
        }
        total++;

        String funcCode = String.valueOf(CLAZZ_START_START + total);

        ClazzFunc clazzFunc = bizConvert.toJavaObject(clazzFuncDTO);
        clazzFunc.setFuncCode(funcCode);
        EntityUtils.setCreatAndUpdateInfo(clazzFunc);
        clazzFunc.setId(funcCode);
        clazzFunc.setRemoveFlag(YesOrNotConstant.N);
        bizMapper.insertSelective(clazzFunc);
        return bizConvert.toJavaObjectVO(clazzFunc);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2025/9/18 22:33
     * @param clazzFuncDTO clazzFuncDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzFuncVO
     */
    @Override
    public ClazzFuncVO updateInfo(ClazzFuncDTO clazzFuncDTO) throws Exception {
        ClazzFuncVO clazzFuncVO = bizMapper.findClazzFuncByTitle(BizContextHandler.getTenantId(), clazzFuncDTO.getFuncTitle());
        AssertUtils.isTrue(null != clazzFuncVO && !clazzFuncDTO.getId().equals(clazzFuncVO.getId()), "该岗位职能名称已经存在！");

        ClazzFunc clazzFunc = bizConvert.toJavaObject(clazzFuncDTO);
        EntityUtils.setUpdatedInfo(clazzFunc);
        bizMapper.updateByPrimaryKeySelective(clazzFunc);
        return bizConvert.toJavaObjectVO(clazzFunc);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2025/9/18 22:33
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        ClazzFunc clazzFunc = new ClazzFunc();
        clazzFunc.setId(id);
        clazzFunc.setRemoveFlag(YesOrNotConstant.Y);
        EntityUtils.setUpdatedInfo(clazzFunc);
        bizMapper.updateByPrimaryKeySelective(clazzFunc);
        return 1;
    }

    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param params com.github.itdachen.admin.sdk.query.ClazzFuncQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        ClazzFuncQuery params) throws Exception {

        new OOXmlPoiExpHelper<ClazzFuncVO, ClazzFuncQuery>()
                .settings(new ExpParamsSettings<ClazzFuncQuery>(request, response,
                        BizContextHandler.getUserDetails(), "岗位职能管理", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<ClazzFuncVO, ClazzFuncQuery>() {

                    @Override
                    public Long total(ClazzFuncQuery params) {
                        return bizMapper.list_COUNT(params);
                    }

                    @Override
                    public List<ClazzFuncVO> data(ClazzFuncQuery params, Integer page, Integer limit) {
                        PageHelper.startPage(page, limit);
                        return bizMapper.list(params);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<ClazzFuncVO> list, boolean hasRowNum) {
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
        new OOXmlPoiImpHelper<ClazzFunc>()
                .settings(new ImpParamsSettings(request, response,
                        BizContextHandler.getUserDetails(),
                        "岗位职能管理", 2
                ))
                .workBookFile(file)
                .readWorkBook(
                        new IReadWorkBookHandler<ClazzFunc>() {
                            @Override
                            public void readRows(UserInfoDetails userDetails, List<ClazzFunc> list, Row row, int index, String sheetName) {
                                readWorkBook(userDetails, list, row, index, sheetName);
                            }

                            @Override
                            public void handler(List<ClazzFunc> list) {
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
    private void readWorkBook(UserInfoDetails userDetails, List<ClazzFunc> list, Row row, int index, String sheetName) {
        ClazzFunc clazzFunc = new ClazzFunc();
        clazzFunc.setId(EntityUtils.getId());
        clazzFunc.setTenantId(userDetails.getTenantId());
        clazzFunc.setCreateTime(LocalDateTime.now());
        clazzFunc.setCreateUserId(userDetails.getId());
        clazzFunc.setCreateUser(userDetails.getNickName());
        clazzFunc.setUpdateTime(LocalDateTime.now());
        clazzFunc.setUpdateUserId(userDetails.getId());
        clazzFunc.setUpdateUser(userDetails.getNickName());

        // 其他数据操作

        list.add(clazzFunc);

    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<ClazzFuncVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        ClazzFuncVO clazzFuncVO = new ClazzFuncVO();
        for (int i = 0; i < list.size(); i++) {
            clazzFuncVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, clazzFuncVO.getFuncCode(), textCellStyle); // 岗位职能编码, 例如: 001-主管领导岗;002-业务岗
            ExcelExpUtils.setCellValue(row, 2, clazzFuncVO.getFuncTitle(), textCellStyle); // 岗位职能标题, 例如: 001-主管领导岗;002-业务岗
            ExcelExpUtils.setCellValue(row, 3, clazzFuncVO.getValidFlag(), textCellStyle); // 有效标志: Y-有效;N-无效
        }
    }

}
