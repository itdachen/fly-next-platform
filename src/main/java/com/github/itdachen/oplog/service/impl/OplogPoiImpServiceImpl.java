package com.github.itdachen.oplog.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.itdachen.ooxml.poi.exp.ExcelExpUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.oplog.entity.OplogPoiImp;
import com.github.itdachen.oplog.sdk.dto.OplogPoiImpDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiImpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiImpVO;
import com.github.itdachen.oplog.mapper.IOplogPoiImpMapper;
import com.github.itdachen.oplog.service.IOplogPoiImpService;
import com.github.itdachen.oplog.convert.OplogPoiImpConvert;
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
 * 导入日志 业务实现
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
@Service
public class OplogPoiImpServiceImpl extends BizServiceImpl<IOplogPoiImpMapper, OplogPoiImp, OplogPoiImpDTO, OplogPoiImpVO, OplogPoiImpQuery, String> implements IOplogPoiImpService {
    private static final Logger logger = LoggerFactory.getLogger(OplogPoiImpServiceImpl.class);
    private static final OplogPoiImpConvert bizConvert = new OplogPoiImpConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();

    public OplogPoiImpServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("部门名称");
        EXP_FIELDS.add("功能名称(备用)");
        EXP_FIELDS.add("操作IP地址");
        EXP_FIELDS.add("操作地址");
        EXP_FIELDS.add("操作系统");
        EXP_FIELDS.add("操作浏览器");
        EXP_FIELDS.add("数据总量");
        EXP_FIELDS.add("导入文件名称");
        EXP_FIELDS.add("备注");
        EXP_FIELDS.add("服务端处理耗时");
        EXP_FIELDS.add("年份");
        EXP_FIELDS.add("月份");
        EXP_FIELDS.add("创建时间");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.oplog.sdk.vo.oplogPoiImpVo>
     */
    @Override
    public TableData<OplogPoiImpVO> page(OplogPoiImpQuery params) throws Exception {
        params.setTenantId(BizContextHandler.getTenantId());
        Page<OplogPoiImpVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<OplogPoiImpVO> list = bizMapper.list(params);
        return new TableData<OplogPoiImpVO>(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param params com.github.itdachen.oplog.sdk.query.OplogPoiImpQuery
     * @return void
     */
    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               OplogPoiImpQuery params) throws Exception {
        List<LinkedHashMap<String, String>> list = bizMapper.selectOplogPoiImpExpData(params);
        WorkBookUtils.export(request, response)
                .params(params)
                .title("导入日志")
                .rowNum(true)
                .fields(EXP_FIELDS)
                .data(list)
                .execute();
    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<OplogPoiImpVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        OplogPoiImpVO oplogPoiImpVO = new OplogPoiImpVO();
        for (int i = 0; i < list.size(); i++) {
            oplogPoiImpVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, oplogPoiImpVO.getDeptTitle(), textCellStyle); // 部门名称
            ExcelExpUtils.setCellValue(row, 2, oplogPoiImpVO.getFuncTitle(), textCellStyle); // 功能名称(备用)
            ExcelExpUtils.setCellValue(row, 3, oplogPoiImpVO.getHostIp(), textCellStyle); // 操作IP地址
            ExcelExpUtils.setCellValue(row, 4, oplogPoiImpVO.getHostAddress(), textCellStyle); // 操作地址
            ExcelExpUtils.setCellValue(row, 5, oplogPoiImpVO.getHostOs(), textCellStyle); // 操作系统
            ExcelExpUtils.setCellValue(row, 6, oplogPoiImpVO.getHostBrowser(), textCellStyle); // 操作浏览器
            ExcelExpUtils.setCellValue(row, 7, oplogPoiImpVO.getDataTotal(), textCellStyle); // 数据总量
            ExcelExpUtils.setCellValue(row, 8, oplogPoiImpVO.getFileName(), textCellStyle); // 导入文件名称
            ExcelExpUtils.setCellValue(row, 9, oplogPoiImpVO.getRemarks(), textCellStyle); // 备注
            ExcelExpUtils.setCellValue(row, 10, oplogPoiImpVO.getExecuteTime(), textCellStyle); // 服务端处理耗时
            ExcelExpUtils.setCellValue(row, 11, oplogPoiImpVO.getYearly(), textCellStyle); // 年份
            ExcelExpUtils.setCellValue(row, 12, oplogPoiImpVO.getMonthly(), textCellStyle); // 月份
            ExcelExpUtils.setCellValue(row, 13, oplogPoiImpVO.getCreateTime() + "", textCellStyle); // 创建时间
        }
    }

}
