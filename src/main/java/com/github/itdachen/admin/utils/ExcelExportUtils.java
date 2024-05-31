package com.github.itdachen.admin.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.lang.Boolean;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * excel 导出工具类
 *
 * @author 王大宸
 * @date 2024-01-24 15:46
 */
public class ExcelExportUtils {
    private static final Logger logger = LoggerFactory.getLogger(ExcelExportUtils.class);

    private static final String FILE_NAME_FORMAT = ".xlsx";

    /***
     * 通用导出方法
     *
     * @author 王大宸
     * @date 2024/1/25 10:08
     * @param request request
     * @param response response
     * @param fields     导出标题集合
     * @param list       导出数据
     * @param fileName   导出文件名
     * @param hasRowNum  是否显示序号
     * @return void
     */
    public static void exportExcel(HttpServletRequest request,
                                   HttpServletResponse response,
                                   List<String> fields,
                                   List<LinkedHashMap<String, String>> list,
                                   String fileName,
                                   Boolean hasRowNum) {
        exportExcelHandler(request, response, fields, list, fileName, hasRowNum);
    }


    /***
     * 通用导出方法
     *
     * @author 王大宸
     * @date 2024/1/24 15:48
     * @param request request
     * @param response response
     * @param fields     导出标题集合
     * @param list       导出数据
     * @param fileName   导出文件名
     * @return void
     */
    public static void exportExcel(HttpServletRequest request,
                                   HttpServletResponse response,
                                   List<String> fields,
                                   List<LinkedHashMap<String, String>> list,
                                   String fileName) {
        exportExcelHandler(request, response, fields, list, fileName, false);
    }


    /***
     * 数据导出, 处理方法
     *
     * @author 王大宸
     * @date 2024/1/25 10:23
     * @param request request
     * @param response response
     * @param fields     导出标题集合
     * @param list       导出数据
     * @param fileName   导出文件名
     * @param hasRowNum  是否显示序号
     * @return void
     */
    private static void exportExcelHandler(HttpServletRequest request,
                                           HttpServletResponse response,
                                           List<String> fields,
                                           List<LinkedHashMap<String, String>> list,
                                           String fileName,
                                           Boolean hasRowNum) {

        String localDateTime = getLocalDateTime();
        String[] s = localDateTime.split(" ");
        String expFileName = fileName + "_" + s[0].replace("-", "");

        /* 使用 sheet 序号 */
        int rowSheetNum = 1;

        WritableWorkbook wwb = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            // excel 文件的 MIME 类型
            response.setContentType("application/msexcel");
            //在导出前对名称根据浏览器做下处理
            String agent = request.getHeader("USER-AGENT").toLowerCase();
            response.setContentType("application/vnd.ms-excel");
            //***************很重要


            //文件名中文乱码
            if (agent.contains("firefox")) {
                response.setCharacterEncoding("utf-8");
                response.setHeader("content-disposition", "attachment;filename=" + new String(expFileName.getBytes(), "ISO8859-1") + FILE_NAME_FORMAT);
            } else {
                String codedFileName = java.net.URLEncoder.encode(expFileName, "UTF-8");
                response.setHeader("content-disposition", "attachment;filename=" + codedFileName + FILE_NAME_FORMAT);
            }


           // Workbook.

            wwb = jxl.Workbook.createWorkbook(os);
            /* Sheet 名称, Sheet 序号 */
            WritableSheet ws = wwb.createSheet(fileName, rowSheetNum); // 创建一个工作表
            /* 设置默认列宽度和行高 */
            ws.getSettings().setDefaultColumnWidth(25);
            ws.getSettings().setDefaultRowHeight(300);

            /* 设置表头 */
            setTitleCell(ws, fields, fileName, hasRowNum);

            // 设置内容数据单元格的文字格式
            WritableFont cellFont = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            WritableCellFormat cellFontFormat = new WritableCellFormat(cellFont);
            cellFontFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE); //垂直居中
            cellFontFormat.setAlignment(jxl.format.Alignment.CENTRE); //文字对齐方式


            LinkedHashMap<String, String> map;
            String value;
            int dateColumn = 0;
            int index;
            if (!list.isEmpty()) {
                index = 2;
                int rowNum = 1;
                for (Iterator<LinkedHashMap<String, String>> var = list.iterator(); var.hasNext(); ++index) {
                    map = var.next();
                    dateColumn = 0;

                    if (hasRowNum) {
                        dateColumn = 1;
                        /* 添加序号 */
                        ws.addCell(new Label(0, index, String.valueOf(rowNum), cellFontFormat));
                        rowNum++;
                    }

                    for (Iterator<String> varMap = map.values().iterator(); varMap.hasNext(); ++dateColumn) {
                        value = String.valueOf(varMap.next());
                        if (value == null || "null".equals(value) || org.apache.commons.lang3.StringUtils.isEmpty(value)) {
                            value = "";
                        }
                        /* 设置表数据信息,  Label: 第几列, 第几行, 数据信息, 单元格样式  */
                        ws.addCell(new Label(dateColumn, index, value, cellFontFormat));
                    }
                }
            }




            wwb.write();
        } catch (Exception e) {
            logger.error("数据导出失败: {} ", e.getMessage(), e);
        } finally {
            try {
                if (wwb != null) {
                    wwb.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                logger.error("数据导出, 关闭输出流失败: {} ", e.getMessage(), e);
            }
        }


    }


    /***
     * 设置表头
     *
     * @author 王大宸
     * @date 2024/1/25 9:17
     * @param ws ws
     * @param fields fields
     * @param fileName fileName
     * @return void
     */
    public static void setTitleCell(WritableSheet ws, List<String> fields, String fileName, Boolean hasRowNum) throws WriteException {
        // 标题设置
        WritableFont titleFont = new WritableFont(WritableFont.createFont("宋体"), 24, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat titleFontFormat = new WritableCellFormat(titleFont);
        titleFontFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        titleFontFormat.setAlignment(jxl.format.Alignment.CENTRE);

        int endColumnNum = fields.size() - 1;
        if (hasRowNum) {
            endColumnNum = fields.size();
        }

        /* 设置表头,  Label: 第几列, 第几行, 数据信息, 单元格样式  */
        ws.addCell(new Label(0, 0, fileName, titleFontFormat));  // 第一个参数为: 第几列，第二个参数为: 第几行
        /* 合并表头单元格: 合并开始列, 合并开始行, 合并结束列, 合并结束行 */
        ws.mergeCells(0, 0, endColumnNum, 0);


        // 字段标题设置
        WritableFont subTitleFont = new WritableFont(WritableFont.createFont("宋体"), 16, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat subTitleFontFormat = new WritableCellFormat(subTitleFont);
        subTitleFontFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        subTitleFontFormat.setAlignment(jxl.format.Alignment.CENTRE);

        int columnNum = 0;
        if (hasRowNum) {
            ws.addCell(new Label(0, 1, "序号", subTitleFontFormat));
            columnNum = 1;
        }

        for (String field : fields) {
            ws.addCell(new Label(columnNum, 1, field, subTitleFontFormat));
            columnNum++;
        }

        /* 设置高度: 行号, 高度 */
        ws.setRowView(0, 1000);
        ws.setRowView(1, 500);
    }

    public static String getLocalDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
