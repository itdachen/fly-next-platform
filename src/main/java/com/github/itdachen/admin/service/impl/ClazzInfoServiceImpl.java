package com.github.itdachen.admin.service.impl;

import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiExpHelper;
import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiImpHelper;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.ExpParamsSettings;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.handler.IWriteWorkBook;
import com.github.itdachen.boot.oplog.ooxml.poi.exp.utils.ExcelExpUtils;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.IReadWorkBookHandler;
import com.github.itdachen.boot.oplog.ooxml.poi.imp.ImpParamsSettings;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.ClazzInfo;
import com.github.itdachen.admin.sdk.dto.ClazzInfoDTO;
import com.github.itdachen.admin.sdk.query.ClazzInfoQuery;
import com.github.itdachen.admin.sdk.vo.ClazzInfoVO;
import com.github.itdachen.admin.mapper.IClazzInfoMapper;
import com.github.itdachen.admin.service.IClazzInfoService;
import com.github.itdachen.admin.convert.ClazzInfoConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 岗位信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
@Service
public class ClazzInfoServiceImpl extends BizServiceImpl<IClazzInfoMapper, ClazzInfo, ClazzInfoDTO, ClazzInfoVO, ClazzInfoQuery, String> implements IClazzInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ClazzInfoServiceImpl.class);
    private static final ClazzInfoConvert bizConvert = new ClazzInfoConvert();
    private static final List<String> EXP_FIELDS = new ArrayList<>();

    public ClazzInfoServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("部门职能代码");
        EXP_FIELDS.add("部门职能名称");
        EXP_FIELDS.add("所属层级等级");
        EXP_FIELDS.add("所属层级名称");
        EXP_FIELDS.add("岗位类型ID");
        EXP_FIELDS.add("岗位类型");
        EXP_FIELDS.add("岗位代码");
        EXP_FIELDS.add("岗位名称");
        EXP_FIELDS.add("有效标志");
    }


    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.clazzInfoVo>
     */
    @Override
    public TableData<ClazzInfoVO> page(ClazzInfoQuery params) throws Exception {
        params.setRemoveFlag(YesOrNotConstant.N);
        params.setTenantId(BizContextHandler.getTenantId());
        Page<ClazzInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ClazzInfoVO> list = bizMapper.list(params);
        return new TableData<ClazzInfoVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/5/9 22:51
     * @param clazzInfoDTO clazzInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClazzInfoVO saveInfo(ClazzInfoDTO clazzInfoDTO) throws Exception {
        String clazzCode = "1" + clazzInfoDTO.getThatLevelCode()  + clazzInfoDTO.getDeptFuncCode() + clazzInfoDTO.getClazzFuncCode();

        ClazzInfoQuery params = ClazzInfoQuery.builder()
                .tenantId(BizContextHandler.getTenantId())
                .clazzCode(clazzCode)
                .build();
        List<ClazzInfoVO> list = bizMapper.list(params);

        AssertUtils.isTrue(!list.isEmpty(), "该岗位已经存在！");


        ClazzInfo clazzInfo = bizConvert.toJavaObject(clazzInfoDTO);
        String clazzTitle = clazzInfo.getThatLevelTitle() + "-" + clazzInfo.getDeptFuncTitle() + "-" + clazzInfo.getClazzFuncTitle();

        clazzInfo.setClazzCode(clazzCode);
        clazzInfo.setClazzTitle(clazzTitle);

        EntityUtils.setCreatAndUpdateInfo(clazzInfo);
        clazzInfo.setId(clazzCode);
        clazzInfo.setRemoveFlag(YesOrNotConstant.N);
        bizMapper.insertSelective(clazzInfo);
        return bizConvert.toJavaObjectVO(clazzInfo);
    }

    /***
     * 编辑/不允许修改
     *
     * @author 王大宸
     * @date 2024/5/9 22:51
     * @param clazzInfoDTO clazzInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClazzInfoVO updateInfo(ClazzInfoDTO clazzInfoDTO) throws Exception {
//        ClazzInfo clazzInfo = bizConvert.toJavaObject(clazzInfoDTO);
//        EntityUtils.setUpdatedInfo(clazzInfo);
//        bizMapper.updateByPrimaryKeySelective(clazzInfo);
//        return bizConvert.toJavaObjectVO(clazzInfo);

        return null;
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2025/9/19 22:57
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        ClazzInfo clazzInfo = new ClazzInfo();
        clazzInfo.setId(id);
        clazzInfo.setRemoveFlag(YesOrNotConstant.Y);
        EntityUtils.setUpdatedInfo(clazzInfo);
        bizMapper.updateByPrimaryKeySelective(clazzInfo);
        return 1;
    }

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/25 23:03
     * @param id id
     * @param checked checked
     * @return void
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        ClazzInfo clazzInfo = bizMapper.selectByPrimaryKey(id);
        clazzInfo.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        EntityUtils.setUpdatedInfo(clazzInfo);
        bizMapper.updateByPrimaryKeySelective(clazzInfo);
    }

    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-09-19 21:58:19
     * @param params com.github.itdachen.admin.sdk.query.ClazzInfoQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        ClazzInfoQuery params) throws Exception {

        new OOXmlPoiExpHelper<ClazzInfoVO, ClazzInfoQuery>()
                .settings(new ExpParamsSettings<ClazzInfoQuery>(request, response,
                        BizContextHandler.getUserDetails(), "岗位信息", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<ClazzInfoVO, ClazzInfoQuery>() {

                    @Override
                    public Long total(ClazzInfoQuery params) {
                        return bizMapper.list_COUNT(params);
                    }

                    @Override
                    public List<ClazzInfoVO> data(ClazzInfoQuery params, Integer page, Integer limit) {
                        PageHelper.startPage(page, limit);
                        return bizMapper.list(params);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<ClazzInfoVO> list, boolean hasRowNum) {
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
        new OOXmlPoiImpHelper<ClazzInfo>()
                .settings(new ImpParamsSettings(request, response,
                        BizContextHandler.getUserDetails(),
                        "岗位信息", 2
                ))
                .workBookFile(file)
                .readWorkBook(
                        new IReadWorkBookHandler<ClazzInfo>() {
                            @Override
                            public void readRows(UserInfoDetails userDetails, List<ClazzInfo> list, Row row, int index, String sheetName) {
                                readWorkBook(userDetails, list, row, index, sheetName);
                            }

                            @Override
                            public void handler(List<ClazzInfo> list) {
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
    private void readWorkBook(UserInfoDetails userDetails, List<ClazzInfo> list, Row row, int index, String sheetName) {
        ClazzInfo clazzInfo = new ClazzInfo();
        clazzInfo.setId(EntityUtils.getId());
        clazzInfo.setTenantId(userDetails.getTenantId());
        clazzInfo.setCreateTime(LocalDateTime.now());
        clazzInfo.setCreateUserId(userDetails.getId());
        clazzInfo.setCreateUser(userDetails.getNickName());
        clazzInfo.setUpdateTime(LocalDateTime.now());
        clazzInfo.setUpdateUserId(userDetails.getId());
        clazzInfo.setUpdateUser(userDetails.getNickName());

        // 其他数据操作

        list.add(clazzInfo);

    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-09-19 21:58:19
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<ClazzInfoVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        ClazzInfoVO clazzInfoVO = new ClazzInfoVO();
        for (int i = 0; i < list.size(); i++) {
            clazzInfoVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, clazzInfoVO.getDeptFuncCode(), textCellStyle); // 部门职能代码
            ExcelExpUtils.setCellValue(row, 2, clazzInfoVO.getDeptFuncTitle(), textCellStyle); // 部门职能名称
            ExcelExpUtils.setCellValue(row, 3, clazzInfoVO.getThatLevelCode(), textCellStyle); // 所属层级等级
            ExcelExpUtils.setCellValue(row, 4, clazzInfoVO.getThatLevelTitle(), textCellStyle); // 所属层级名称
            ExcelExpUtils.setCellValue(row, 5, clazzInfoVO.getClazzFuncCode(), textCellStyle); // 岗位类型ID
            ExcelExpUtils.setCellValue(row, 6, clazzInfoVO.getClazzFuncTitle(), textCellStyle); // 岗位类型
            ExcelExpUtils.setCellValue(row, 7, clazzInfoVO.getClazzCode(), textCellStyle); // 岗位代码
            ExcelExpUtils.setCellValue(row, 8, clazzInfoVO.getClazzTitle(), textCellStyle); // 岗位名称
            ExcelExpUtils.setCellValue(row, 9, clazzInfoVO.getValidFlag(), textCellStyle); // 有效标志: Y-是;N-否
        }
    }

}
