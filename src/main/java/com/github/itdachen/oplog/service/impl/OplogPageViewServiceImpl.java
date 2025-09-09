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
import com.github.itdachen.oplog.entity.OplogPageView;
import com.github.itdachen.oplog.sdk.dto.OplogPageViewDTO;
import com.github.itdachen.oplog.sdk.query.OplogPageViewQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPageViewVO;
import com.github.itdachen.oplog.mapper.IOplogPageViewMapper;
import com.github.itdachen.oplog.service.IOplogPageViewService;
import com.github.itdachen.oplog.convert.OplogPageViewConvert;
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
 * 页面访问日志 业务实现
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
@Service
public class OplogPageViewServiceImpl extends BizServiceImpl<IOplogPageViewMapper, OplogPageView, OplogPageViewDTO, OplogPageViewVO, OplogPageViewQuery, String> implements IOplogPageViewService {
    private static final Logger logger = LoggerFactory.getLogger(OplogPageViewServiceImpl.class);
    private static final OplogPageViewConvert bizConvert = new OplogPageViewConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();

    public OplogPageViewServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("省名称");
        EXP_FIELDS.add("市州名称");
        EXP_FIELDS.add("区县名称");
        EXP_FIELDS.add("乡镇/街道办名称");
        EXP_FIELDS.add("部门名称");
        EXP_FIELDS.add("操作人ID");
        EXP_FIELDS.add("操作人姓名");
        EXP_FIELDS.add("菜单名称");
        EXP_FIELDS.add("操作类型: 新增, 修改, 删除, 查看");
        EXP_FIELDS.add("操作时间");
        EXP_FIELDS.add("操作IP地址");
        EXP_FIELDS.add("操作系统");
        EXP_FIELDS.add("操作浏览器");
        EXP_FIELDS.add("服务端处理耗时");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.oplog.sdk.vo.oplogPageViewVo>
     */
    @Override
    public TableData<OplogPageViewVO> page(OplogPageViewQuery params) throws Exception {
        Page<OplogPageViewVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<OplogPageViewVO> list = bizMapper.list(params);
        return new TableData<OplogPageViewVO>(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param params com.github.itdachen.oplog.sdk.query.OplogPageViewQuery
     * @return void
     */
    @Override
    public void expInfo(HttpServletRequest request,
                        HttpServletResponse response,
                        OplogPageViewQuery params) throws Exception {

        new OOXmlPoiExpHelper<OplogPageViewVO, OplogPageViewQuery>()
                .settings(new ExpParamsSettings<OplogPageViewQuery>(request, response,
                        BizContextHandler.getUserDetails(), "页面访问日志", EXP_FIELDS, params)
                )
                .writeWorkBook(new IWriteWorkBook<OplogPageViewVO, OplogPageViewQuery>() {

                    @Override
                    public Long total(OplogPageViewQuery params) {
                        return bizMapper.list_COUNT(params);
                    }

                    @Override
                    public List<OplogPageViewVO> data(OplogPageViewQuery params, Integer page, Integer limit) {
                        PageHelper.startPage(page, limit);
                        return bizMapper.list(params);
                    }

                    @Override
                    public void writeWorkBook(XSSFWorkbook workbook, Sheet sheet,
                                              List<OplogPageViewVO> list, boolean hasRowNum) {
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
        new OOXmlPoiImpHelper<OplogPageView>()
                .settings(new ImpParamsSettings(request, response,
                        BizContextHandler.getUserDetails(),
                        "页面访问日志", 2
                ))
                .workBookFile(file)
                .readWorkBook(
                        new IReadWorkBookHandler<OplogPageView>() {
                            @Override
                            public void readRows(UserInfoDetails userDetails, List<OplogPageView> list, Row row, int index, String sheetName) {
                                readWorkBook(userDetails, list, row, index, sheetName);
                            }

                            @Override
                            public void handler(List<OplogPageView> list) {
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
    private void readWorkBook(UserInfoDetails userDetails, List<OplogPageView> list, Row row, int index, String sheetName) {
        OplogPageView oplogPageView = new OplogPageView();
        oplogPageView.setId(EntityUtils.getId());
        oplogPageView.setTenantId(userDetails.getTenantId());
        oplogPageView.setTenantTitle(userDetails.getTenantTitle());
        oplogPageView.setCreateTime(LocalDateTime.now());
        oplogPageView.setCreateUserId(userDetails.getId());
        oplogPageView.setCreateUser(userDetails.getNickName());
        oplogPageView.setUpdateTime(LocalDateTime.now());
        oplogPageView.setUpdateUserId(userDetails.getId());
        oplogPageView.setUpdateUser(userDetails.getNickName());

        // 其他数据操作

        list.add(oplogPageView);

    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<OplogPageViewVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        OplogPageViewVO oplogPageViewVO = new OplogPageViewVO();
        for (int i = 0; i < list.size(); i++) {
            oplogPageViewVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, oplogPageViewVO.getProvName(), textCellStyle); // 省名称
            ExcelExpUtils.setCellValue(row, 2, oplogPageViewVO.getCityName(), textCellStyle); // 市州名称
            ExcelExpUtils.setCellValue(row, 3, oplogPageViewVO.getCountyName(), textCellStyle); // 区县名称
            ExcelExpUtils.setCellValue(row, 4, oplogPageViewVO.getTownName(), textCellStyle); // 乡镇/街道办名称
            ExcelExpUtils.setCellValue(row, 5, oplogPageViewVO.getDeptTitle(), textCellStyle); // 部门名称
            ExcelExpUtils.setCellValue(row, 6, oplogPageViewVO.getUserId(), textCellStyle); // 操作人ID
            ExcelExpUtils.setCellValue(row, 7, oplogPageViewVO.getNickName(), textCellStyle); // 操作人姓名
            ExcelExpUtils.setCellValue(row, 8, oplogPageViewVO.getMenuTitle(), textCellStyle); // 菜单名称
            ExcelExpUtils.setCellValue(row, 9, oplogPageViewVO.getOpTitle(), textCellStyle); // 操作类型: 新增, 修改, 删除, 查看
            ExcelExpUtils.setCellValue(row, 10, oplogPageViewVO.getOpTime() + "", textCellStyle); // 操作时间
            ExcelExpUtils.setCellValue(row, 11, oplogPageViewVO.getHostIp(), textCellStyle); // 操作IP地址
            ExcelExpUtils.setCellValue(row, 12, oplogPageViewVO.getHostOs(), textCellStyle); // 操作系统
            ExcelExpUtils.setCellValue(row, 13, oplogPageViewVO.getHostBrowser(), textCellStyle); // 操作浏览器
            ExcelExpUtils.setCellValue(row, 14, oplogPageViewVO.getExecuteTime(), textCellStyle); // 服务端处理耗时
        }
    }

}
