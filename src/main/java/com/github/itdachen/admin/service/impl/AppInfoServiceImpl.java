package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.AppInfoConvert;
import com.github.itdachen.admin.utils.XSSFWorkBookExpHelper;
import com.github.itdachen.boot.autoconfigure.oss.properties.OssLocalAutoconfigureProperties;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
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


    @Autowired
    private OssLocalAutoconfigureProperties ossLocalAutoconfigureProperties;

    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               AppInfoQuery params) throws Exception {

        List<String> fields = new ArrayList<>();
        fields.add("平台ID");
        fields.add("平台名称");
        fields.add("应用秘钥");
        fields.add("应用标识");
        fields.add("应用名称");
        fields.add("类型编码");
        fields.add("类型名称");
        fields.add("访问地址");
        fields.add("图标");
        fields.add("只能代码");
        fields.add("智能代码名称");
        fields.add("删除标志");
        fields.add("有效标志");

        List<LinkedHashMap<String, String>> list = bizMapper.selectAppInfoExpData(params);

        XSSFWorkBookExpHelper helper = new XSSFWorkBookExpHelper(ossLocalAutoconfigureProperties,
                true, true);
        helper.exportExcel(request, response, fields, list, "应用信息");

        String fileDiskUri = helper.getFileDiskUri();
        String fileName = helper.getFileName();
        String fileUri = helper.getFileUri();
        Long fileSize = helper.getFileSize();
        System.err.println(fileUri);

    }


    /***
     * 设置表头
     *
     * @author 王大宸
     * @date 2024/5/28 10:22
     * @param workbook workbook
     * @param sheet sheet
     * @param fields     二级标题
     * @param title      一级标题
     * @param hasRowNum  是否显示序号
     * @return void
     */
    private static void setTitleCell(XSSFWorkbook workbook, Sheet sheet, String title, List<String> fields, boolean hasRowNum) throws WriteException {
        /* 标题 */
        XSSFCellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中

        XSSFFont headerXssfFont = workbook.createFont();
        headerXssfFont.setBold(true); //粗体显示
        headerXssfFont.setFontName("仿宋_GB2312");
        headerXssfFont.setFontHeightInPoints((short) 24);
        headerCellStyle.setFont(headerXssfFont);


        int endColumnNum = fields.size() - 1;
        if (hasRowNum) {
            endColumnNum = fields.size();
        }

        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, endColumnNum);
        sheet.addMergedRegion(cellRangeAddress);

        Row headerRow = sheet.createRow(0);
        headerRow.setHeight(Short.parseShort("800"));
        Cell cell = headerRow.createCell(0);
        cell.setCellValue(title);
        cell.setCellStyle(headerCellStyle);


        /* 二级表头 */
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中
        XSSFFont xssfFont = workbook.createFont();
        xssfFont.setBold(true); //粗体显示
        xssfFont.setFontName("仿宋_GB2312");
        xssfFont.setFontHeightInPoints((short) 16);
        cellStyle.setFont(xssfFont);

        Row row = sheet.createRow(1);
        row.setHeight(Short.parseShort("700"));


        int columnNum = 0;
        if (hasRowNum) {
            cell = row.createCell(columnNum);
            cell.setCellValue("序号");
            cell.setCellStyle(cellStyle);
            columnNum = 1;
        }

        for (String field : fields) {
            cell = row.createCell(columnNum);
            cell.setCellValue(field);
            cell.setCellStyle(cellStyle);
            columnNum++;
        }


//        for (int i = 0; i < fields.size(); i++) {
//            cell = row.createCell(i);
//            cell.setCellValue(fields.get(i));
//            cell.setCellStyle(cellStyle);
//        }


    }

    public static String getLocalDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
