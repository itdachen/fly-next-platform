package com.github.itdachen.oplog.service.impl;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.itdachen.ooxml.poi.exp.ExcelExpUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.oplog.entity.OplogPoiTest;
import com.github.itdachen.oplog.sdk.dto.OplogPoiTestDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiTestQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiTestVO;
import com.github.itdachen.oplog.mapper.IOplogPoiTestMapper;
import com.github.itdachen.oplog.service.IOplogPoiTestService;
import com.github.itdachen.oplog.convert.OplogPoiTestConvert;
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
 * 导入导出测试 业务实现
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
@Service
public class OplogPoiTestServiceImpl extends BizServiceImpl<IOplogPoiTestMapper, OplogPoiTest, OplogPoiTestDTO, OplogPoiTestVO, OplogPoiTestQuery, String> implements IOplogPoiTestService {
    private static final Logger logger = LoggerFactory.getLogger(OplogPoiTestServiceImpl.class);
    private static final OplogPoiTestConvert bizConvert = new OplogPoiTestConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();

    public OplogPoiTestServiceImpl() {
        super(bizConvert);
        EXP_FIELDS.add("租户名称/公司名称");
        EXP_FIELDS.add("日志标题: 用户管理, 菜单管理等");
        EXP_FIELDS.add("日志类型: button, uri");
        EXP_FIELDS.add("操作IP地址");
        EXP_FIELDS.add("操作地址");
        EXP_FIELDS.add("操作系统");
        EXP_FIELDS.add("操作浏览器");
        EXP_FIELDS.add("用户代理");
        EXP_FIELDS.add("服务端处理耗时");
        EXP_FIELDS.add("创建时间");
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.oplog.sdk.vo.oplogPoiTestVo>
     */
    @Override
    public TableData<OplogPoiTestVO> page(OplogPoiTestQuery params) throws Exception {
        Page<OplogPoiTestVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<OplogPoiTestVO> list = bizMapper.list(params);
        return new TableData<OplogPoiTestVO>(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param params com.github.itdachen.oplog.sdk.query.OplogPoiTestQuery
     * @return void
     */
    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               OplogPoiTestQuery params) throws Exception {
        List<LinkedHashMap<String, String>> list = bizMapper.selectOplogPoiTestExpData(params);
        WorkBookUtils.export(request, response)
                .params(params)
                .title("导入导出测试")
                .rowNum(true)
                .fields(EXP_FIELDS)
                .data(list)
                .execute();
    }


    /***
     * 数据写入表格具体实现
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param workbook workbook
     * @param sheet sheet
     * @param list      需要写入表格的数据
     * @param hasRowNum 是否添加序号
     * @return void
     */
    private void writeToWorkBook(XSSFWorkbook workbook, Sheet sheet, List<OplogPoiTestVO> list, boolean hasRowNum) {
        Row row;
        XSSFCellStyle textCellStyle = ExcelExpUtils.setTextXSSFCellStyle(workbook);
        OplogPoiTestVO oplogPoiTestVO = new OplogPoiTestVO();
        for (int i = 0; i < list.size(); i++) {
            oplogPoiTestVO = list.get(i);
            row = sheet.createRow(i + 2);
            row.setHeight(Short.parseShort("500"));

            if (hasRowNum) {
                /* 序号 */
                ExcelExpUtils.setCellValue(row, 0, String.valueOf(i + 1), textCellStyle);
            }
            ExcelExpUtils.setCellValue(row, 1, oplogPoiTestVO.getTenantTitle(), textCellStyle); // 租户名称/公司名称
            ExcelExpUtils.setCellValue(row, 2, oplogPoiTestVO.getTitle(), textCellStyle); // 日志标题: 用户管理, 菜单管理等
            ExcelExpUtils.setCellValue(row, 3, oplogPoiTestVO.getType(), textCellStyle); // 日志类型: button, uri
            ExcelExpUtils.setCellValue(row, 4, oplogPoiTestVO.getHostIp(), textCellStyle); // 操作IP地址
            ExcelExpUtils.setCellValue(row, 5, oplogPoiTestVO.getHostAddress(), textCellStyle); // 操作地址
            ExcelExpUtils.setCellValue(row, 6, oplogPoiTestVO.getHostOs(), textCellStyle); // 操作系统
            ExcelExpUtils.setCellValue(row, 7, oplogPoiTestVO.getHostBrowser(), textCellStyle); // 操作浏览器
            ExcelExpUtils.setCellValue(row, 8, oplogPoiTestVO.getUserAgent(), textCellStyle); // 用户代理
            ExcelExpUtils.setCellValue(row, 9, oplogPoiTestVO.getExecuteTime(), textCellStyle); // 服务端处理耗时
            ExcelExpUtils.setCellValue(row, 10, oplogPoiTestVO.getCreateTime() + "", textCellStyle); // 创建时间
        }
    }

}
