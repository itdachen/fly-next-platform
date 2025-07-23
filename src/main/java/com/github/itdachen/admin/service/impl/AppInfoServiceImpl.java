package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.AppInfoConvert;
import com.github.itdachen.admin.utils.XSSFWorkBookExpHelper;
import com.github.itdachen.boot.autoconfigure.oss.properties.OssLocalAutoconfigureProperties;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.ooxml.poi.OOXmlPoiExpHelper;
import com.github.itdachen.ooxml.poi.exp.ExcelExpUtils;
import com.github.itdachen.ooxml.poi.exp.IWriteWorkBook;
import com.github.itdachen.ooxml.poi.exp.ParameterSettings;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AppInfo;
import com.github.itdachen.admin.sdk.dto.AppInfoDTO;
import com.github.itdachen.admin.sdk.query.AppInfoQuery;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.admin.mapper.IAppInfoMapper;
import com.github.itdachen.admin.service.IAppInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jxl.write.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Boolean;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 应用信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-19 21:22:54
 */
@Service
public class AppInfoServiceImpl extends BizServiceImpl<IAppInfoMapper, AppInfo, AppInfoDTO, AppInfoVO, AppInfoQuery, String> implements IAppInfoService {
    private static final Logger logger = LoggerFactory.getLogger(AppInfoServiceImpl.class);
    private static final AppInfoConvert bizConvert = new AppInfoConvert();

    public AppInfoServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.appInfoVo>
     */
    @Override
    public TableData<AppInfoVO> page(AppInfoQuery params) throws Exception {
        Page<AppInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AppInfoVO> list = bizMapper.list(params);
        return new TableData<AppInfoVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/4/20 13:07
     * @param appInfoDTO appInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.AppInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppInfoVO saveInfo(AppInfoDTO appInfoDTO) throws Exception {
        if (StringUtils.isEmpty(appInfoDTO.getAppCode())) {
            throw new BizException("应用标识不能为空！");
        }
        AppInfoVO appInfoByAppCode = bizMapper.findAppInfoByAppCode(appInfoDTO.getAppCode());
        if (null != appInfoByAppCode) {
            throw new BizException("应用标识【" + appInfoDTO.getAppCode() + "】已经存在！");
        }
        AppInfo appInfo = bizConvert.toJavaObject(appInfoDTO);
        EntityUtils.setCreatAndUpdateInfo(appInfo);
        if (StringUtils.isEmpty(appInfo.getAppSecret())) {
            appInfo.setAppSecret(IdUtils.guid());
        }
        appInfo.setValidDel(YesOrNotConstant.Y);
        bizMapper.insertSelective(appInfo);
        return bizConvert.toJavaObjectVO(appInfo);
    }


    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2024/4/20 13:07
     * @param appInfoDTO appInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.AppInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppInfoVO updateInfo(AppInfoDTO appInfoDTO) throws Exception {
        if (StringUtils.isEmpty(appInfoDTO.getAppCode())) {
            throw new BizException("应用标识不能为空！");
        }
        AppInfoVO appInfoByAppCode = bizMapper.findAppInfoByAppCode(appInfoDTO.getAppCode());
        if (null != appInfoByAppCode && !appInfoDTO.getId().equals(appInfoByAppCode.getId())) {
            throw new BizException("应用标识【" + appInfoDTO.getAppCode() + "】已经存在！");
        }
        AppInfo appInfo = bizConvert.toJavaObject(appInfoDTO);
        EntityUtils.setUpdatedInfo(appInfo);
        if (StringUtils.isEmpty(appInfo.getAppSecret())) {
            appInfo.setAppSecret(IdUtils.guid());
        }
        appInfo.setValidDel(YesOrNotConstant.Y);
        bizMapper.updateByPrimaryKeySelective(appInfo);
        return bizConvert.toJavaObjectVO(appInfo);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) throws Exception {
        AppInfoVO appInfoVO = bizMapper.selectAppInfoVO(id);
        if (YesOrNotConstant.N.equals(appInfoVO.getValidDel())) {
            throw new BizException("该应用无法被删除");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        AppInfoVO appInfoVO = bizMapper.selectAppInfoVO(id);
        if (YesOrNotConstant.N.equals(appInfoVO.getValidDel())) {
            throw new BizException("不能修改该应用状态！");
        }
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(appInfo);
    }

    @Override
    public List<AppInfoVO> findAppInfoList() throws Exception {
        AppInfoQuery params = new AppInfoQuery();
        params.setValidFlag(YesOrNotConstant.Y);
        return bizMapper.list(params);
    }

    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               AppInfoQuery params) throws Exception {

        List<String> EXP_FIELDS = new ArrayList<>();
        EXP_FIELDS.add("appID");
        EXP_FIELDS.add("app秘钥");
        EXP_FIELDS.add("应用标识");
        EXP_FIELDS.add("应用名称");
        EXP_FIELDS.add("应用类型");
        EXP_FIELDS.add("访问地址");
        EXP_FIELDS.add("职能代码");
        EXP_FIELDS.add("职能名称");
        EXP_FIELDS.add("是否可删除: Y-是;N-否");
        EXP_FIELDS.add("有效标志: Y-是;N-否");

        new OOXmlPoiExpHelper<AppInfoVO, AppInfoQuery>()
                .settings(new ParameterSettings<AppInfoQuery>(request, response,
                        BizContextHandler.getUserDetails(), "应用管理", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<AppInfoVO, AppInfoQuery>() {

                    @Override
                    public Long total(AppInfoQuery params) {
                        return 831000L;
                    }

                    @Override
                    public List<AppInfoVO> data(AppInfoQuery params, Integer page, Integer limit) {
//                        PageHelper.startPage(page, limit);
//                        return bizMapper.page(params);

                        /* 测试数据 */
                        return findTestData(page, limit);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<AppInfoVO> list, boolean hasRowNum) {
                        writeToWorkBook(workbook, sheet, list, hasRowNum);
                    }
                })
                .execute()
                .reply();
    }


    private List<AppInfoVO> findTestData(Integer page, Integer limit) {
        List<AppInfoVO> list = new ArrayList<>();

        int start = (page - 1) * limit;
        int end = (page - 1) * limit + limit;

        AppInfoVO appClientVo = new AppInfoVO();
        for (int i = start; i < end; i++) {
            appClientVo = new AppInfoVO();
            appClientVo.setId("应用标识_" + i);
            appClientVo.setAppSecret("app秘钥_" + i);
            appClientVo.setAppCode("应用标识_" + i);
            appClientVo.setAppTitle("应用名称_" + i);
            appClientVo.setTypeTitle("应用类型_" + i);
            appClientVo.setAskUri("访问地址_" + i);
            appClientVo.setFuncCode("123_" + i);
            appClientVo.setFuncTitle("123_" + i);
            appClientVo.setValidDel("N_" + i);
            appClientVo.setValidFlag("Y_" + i);
            list.add(appClientVo);
        }

        return list;
    }

    /***
     * 数据写入表格具体实现
     *
     * @author <请填写开发者姓名>
     * @date 2025-07-23 15:23:38
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<AppInfoVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        AppInfoVO appInfoVO = new AppInfoVO();
        for (int i = 0; i < list.size(); i++) {
            appInfoVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, appInfoVO.getId(), textCellStyle); // appID
            ExcelExpUtils.setCellValue(row, 2, appInfoVO.getAppSecret(), textCellStyle); // app秘钥
            ExcelExpUtils.setCellValue(row, 3, appInfoVO.getAppCode(), textCellStyle); // 应用标识
            ExcelExpUtils.setCellValue(row, 4, appInfoVO.getAppTitle(), textCellStyle); // 应用名称
            ExcelExpUtils.setCellValue(row, 5, appInfoVO.getTypeTitle(), textCellStyle); // 应用类型
            ExcelExpUtils.setCellValue(row, 6, appInfoVO.getAskUri(), textCellStyle); // 访问地址
            ExcelExpUtils.setCellValue(row, 7, appInfoVO.getFuncCode(), textCellStyle); // 职能代码
            ExcelExpUtils.setCellValue(row, 8, appInfoVO.getFuncTitle(), textCellStyle); // 职能名称
            ExcelExpUtils.setCellValue(row, 9, appInfoVO.getValidDel(), textCellStyle); // 是否可删除: Y-是;N-否
            ExcelExpUtils.setCellValue(row, 10, appInfoVO.getValidFlag(), textCellStyle); // 有效标志: Y-是;N-否
        }
    }


}
