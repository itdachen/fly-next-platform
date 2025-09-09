package com.github.itdachen.oplog.service.impl;

import com.github.itdachen.boot.oplog.ooxml.poi.OOXmlPoiImpHelper;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
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
import com.github.itdachen.oplog.entity.OplogInfo;
import com.github.itdachen.oplog.sdk.dto.OplogInfoDTO;
import com.github.itdachen.oplog.sdk.query.OplogInfoQuery;
import com.github.itdachen.oplog.sdk.vo.OplogInfoVO;
import com.github.itdachen.oplog.mapper.IOplogInfoMapper;
import com.github.itdachen.oplog.service.IOplogInfoService;
import com.github.itdachen.oplog.convert.OplogInfoConvert;
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
 * 操作日志 业务实现
 *
 * @author 王大宸
 * @date 2025-09-09 17:52:15
 */
@Service
public class OplogInfoServiceImpl extends BizServiceImpl<IOplogInfoMapper, OplogInfo, OplogInfoDTO, OplogInfoVO, OplogInfoQuery, String> implements IOplogInfoService {
    private static final Logger logger = LoggerFactory.getLogger(OplogInfoServiceImpl.class);
    private static final OplogInfoConvert bizConvert = new OplogInfoConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();

    public OplogInfoServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("省名称");
        EXP_FIELDS.add("市州名称");
        EXP_FIELDS.add("区县名称");
        EXP_FIELDS.add("乡镇/街道办名称");
        EXP_FIELDS.add("部门名称");
        EXP_FIELDS.add("操作人工号");
        EXP_FIELDS.add("操作人姓名");
        EXP_FIELDS.add("日志标题");
        EXP_FIELDS.add("操作类型");
        EXP_FIELDS.add("操作时间");
        EXP_FIELDS.add("操作IP地址");
        EXP_FIELDS.add("操作地址");
        EXP_FIELDS.add("操作系统");
        EXP_FIELDS.add("操作浏览器");
        EXP_FIELDS.add("操作状态");
        EXP_FIELDS.add("返回消息");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.oplog.sdk.vo.oplogInfoVo>
     */
    @Override
    public TableData<OplogInfoVO> page(OplogInfoQuery params) throws Exception {
        Page<OplogInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<OplogInfoVO> list = bizMapper.list(params);
        return new TableData<OplogInfoVO>(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param params com.github.itdachen.oplog.sdk.query.OplogInfoQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        OplogInfoQuery params) throws Exception {

        new OOXmlPoiExpHelper<OplogInfoVO, OplogInfoQuery>()
                .settings(new ExpParamsSettings<OplogInfoQuery>(request, response,
                        BizContextHandler.getUserDetails(), "操作日志", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<OplogInfoVO, OplogInfoQuery>() {

                    @Override
                    public Long total(OplogInfoQuery params) {
                        return bizMapper.list_COUNT(params);
                    }

                    @Override
                    public List<OplogInfoVO> data(OplogInfoQuery params, Integer page, Integer limit) {
                        PageHelper.startPage(page, limit);
                        return bizMapper.list(params);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<OplogInfoVO> list, boolean hasRowNum) {
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
        new OOXmlPoiImpHelper<OplogInfo>()
                .settings(new ImpParamsSettings(request, response,
                        BizContextHandler.getUserDetails(),
                        "操作日志", 2
                ))
                .workBookFile(file)
                .readWorkBook(
                        new IReadWorkBookHandler<OplogInfo>() {
                            @Override
                            public void readRows(UserInfoDetails userDetails, List<OplogInfo> list, Row row, int index, String sheetName) {
                                readWorkBook(userDetails, list, row, index, sheetName);
                            }

                            @Override
                            public void handler(List<OplogInfo> list) {
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
    private void readWorkBook(UserInfoDetails userDetails, List<OplogInfo> list, Row row, int index, String sheetName) {
        OplogInfo oplogInfo = new OplogInfo();
        oplogInfo.setId(EntityUtils.getId());
        oplogInfo.setTenantId(userDetails.getTenantId());
        oplogInfo.setTenantTitle(userDetails.getTenantTitle());
        oplogInfo.setCreateTime(LocalDateTime.now());
        oplogInfo.setCreateUserId(userDetails.getId());
        oplogInfo.setCreateUser(userDetails.getNickName());
        oplogInfo.setUpdateTime(LocalDateTime.now());
        oplogInfo.setUpdateUserId(userDetails.getId());
        oplogInfo.setUpdateUser(userDetails.getNickName());

        // 其他数据操作

        list.add(oplogInfo);

    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<OplogInfoVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        OplogInfoVO oplogInfoVO = new OplogInfoVO();
        for (int i = 0; i < list.size(); i++) {
            oplogInfoVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, oplogInfoVO.getProvName(), textCellStyle); // 省名称
            ExcelExpUtils.setCellValue(row, 2, oplogInfoVO.getCityName(), textCellStyle); // 市州名称
            ExcelExpUtils.setCellValue(row, 3, oplogInfoVO.getCountyName(), textCellStyle); // 区县名称
            ExcelExpUtils.setCellValue(row, 4, oplogInfoVO.getTownName(), textCellStyle); // 乡镇/街道办名称
            ExcelExpUtils.setCellValue(row, 5, oplogInfoVO.getDeptTitle(), textCellStyle); // 部门名称
            ExcelExpUtils.setCellValue(row, 6, oplogInfoVO.getUserId(), textCellStyle); // 操作人ID
            ExcelExpUtils.setCellValue(row, 7, oplogInfoVO.getNickName(), textCellStyle); // 操作人姓名
            ExcelExpUtils.setCellValue(row, 8, oplogInfoVO.getMenuTitle(), textCellStyle); // 日志标题: 用户管理, 菜单管理等
            ExcelExpUtils.setCellValue(row, 9, oplogInfoVO.getOpTitle(), textCellStyle); // 操作类型: 新增, 修改, 删除, 查看
            ExcelExpUtils.setCellValue(row, 10, oplogInfoVO.getOpTime() + "", textCellStyle); // 操作时间
            ExcelExpUtils.setCellValue(row, 11, oplogInfoVO.getHostIp(), textCellStyle); // 操作IP地址
            ExcelExpUtils.setCellValue(row, 12, oplogInfoVO.getHostAddress(), textCellStyle); // 操作地址
            ExcelExpUtils.setCellValue(row, 13, oplogInfoVO.getHostOs(), textCellStyle); // 操作系统
            ExcelExpUtils.setCellValue(row, 14, oplogInfoVO.getHostBrowser(), textCellStyle); // 操作浏览器
            ExcelExpUtils.setCellValue(row, 15, oplogInfoVO.getResponseStatus(), textCellStyle); // 操作状态: 成功, 失败, 异常
            ExcelExpUtils.setCellValue(row, 16, oplogInfoVO.getResponseMsg(), textCellStyle); // 返回消息
        }
    }
}
