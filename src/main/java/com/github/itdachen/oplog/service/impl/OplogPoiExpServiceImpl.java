package com.github.itdachen.oplog.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.itdachen.ooxml.poi.exp.ExcelExpUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.oplog.entity.OplogPoiExp;
import com.github.itdachen.oplog.sdk.dto.OplogPoiExpDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiExpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiExpVO;
import com.github.itdachen.oplog.mapper.IOplogPoiExpMapper;
import com.github.itdachen.oplog.service.IOplogPoiExpService;
import com.github.itdachen.oplog.convert.OplogPoiExpConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 导出日志 业务实现
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
@Service
public class OplogPoiExpServiceImpl extends BizServiceImpl<IOplogPoiExpMapper, OplogPoiExp, OplogPoiExpDTO, OplogPoiExpVO, OplogPoiExpQuery, String> implements IOplogPoiExpService {
    private static final Logger logger = LoggerFactory.getLogger(OplogPoiExpServiceImpl.class);
    private static final OplogPoiExpConvert bizConvert = new OplogPoiExpConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();

    public OplogPoiExpServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("应用名称");
        EXP_FIELDS.add("昵称");
        EXP_FIELDS.add("身份名称");
        EXP_FIELDS.add("省名称");
        EXP_FIELDS.add("市/州名称");
        EXP_FIELDS.add("区/县名称");
        EXP_FIELDS.add("部门名称");
        EXP_FIELDS.add("功能名称");
        EXP_FIELDS.add("操作IP地址");
        EXP_FIELDS.add("数据总量");
        EXP_FIELDS.add("文件数量");
        EXP_FIELDS.add("服务端处理耗时");
        EXP_FIELDS.add("年份");
        EXP_FIELDS.add("月份");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.oplog.sdk.vo.oplogPoiExpVo>
     */
    @Override
    public TableData<OplogPoiExpVO> page(OplogPoiExpQuery params) throws Exception {
        params.setTenantId(BizContextHandler.getTenantId());
        Page<OplogPoiExpVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<OplogPoiExpVO> list = bizMapper.list(params);
        return new TableData<OplogPoiExpVO>(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param params com.github.itdachen.oplog.sdk.query.OplogPoiExpQuery
     * @return void
     */
    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               OplogPoiExpQuery params) throws Exception {
        List<LinkedHashMap<String, String>> list = bizMapper.selectOplogPoiExpExpData(params);
        WorkBookUtils.export(request, response)
                .params(params)
                .title("导出日志")
                .rowNum(true)
                .fields(EXP_FIELDS)
                .data(list)
                .execute();
    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<OplogPoiExpVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        OplogPoiExpVO oplogPoiExpVO = new OplogPoiExpVO();
        for (int i = 0; i < list.size(); i++) {
            oplogPoiExpVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, oplogPoiExpVO.getAppTitle(), textCellStyle); // 应用名称
            ExcelExpUtils.setCellValue(row, 2, oplogPoiExpVO.getNickName(), textCellStyle); // 昵称
            ExcelExpUtils.setCellValue(row, 3, oplogPoiExpVO.getRoleName(), textCellStyle); // 身份名称
            ExcelExpUtils.setCellValue(row, 4, oplogPoiExpVO.getProvTitle(), textCellStyle); // 省名称
            ExcelExpUtils.setCellValue(row, 5, oplogPoiExpVO.getCityTitle(), textCellStyle); // 市/州名称
            ExcelExpUtils.setCellValue(row, 6, oplogPoiExpVO.getCountyTitle(), textCellStyle); // 区/县名称
            ExcelExpUtils.setCellValue(row, 7, oplogPoiExpVO.getDeptTitle(), textCellStyle); // 部门名称
            ExcelExpUtils.setCellValue(row, 8, oplogPoiExpVO.getFuncTitle(), textCellStyle); // 功能名称
            ExcelExpUtils.setCellValue(row, 9, oplogPoiExpVO.getHostIp(), textCellStyle); // 操作IP地址
            ExcelExpUtils.setCellValue(row, 10, oplogPoiExpVO.getDataTotal(), textCellStyle); // 数据总量
            ExcelExpUtils.setCellValue(row, 11, oplogPoiExpVO.getFileTotal(), textCellStyle); // 文件数量
            ExcelExpUtils.setCellValue(row, 12, oplogPoiExpVO.getExecuteTime(), textCellStyle); // 服务端处理耗时
            ExcelExpUtils.setCellValue(row, 13, oplogPoiExpVO.getYearly(), textCellStyle); // 年份
            ExcelExpUtils.setCellValue(row, 14, oplogPoiExpVO.getMonthly(), textCellStyle); // 月份
        }
    }

}
