package com.github.itdachen.admin_v1.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 * Description: ExcelUtils
 * Created by 王大宸 on 2023-10-17 16:12
 * Created with IntelliJ IDEA.
 */
public class ExcelUtils {


    /**
     * 创建标题样式
     *
     * @param wb
     * @return
     */
    private static HSSFCellStyle createTitleCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        // 创建字体样式
        HSSFFont headerFont1 = (HSSFFont) wb.createFont();
        //字体加粗
        headerFont1.setBold(true);
        // 设置字体类型
        headerFont1.setFontName("黑体");
        // 设置字体大小
        headerFont1.setFontHeightInPoints((short) 15);
        // 为标题样式设置字体样式
        cellStyle.setFont(headerFont1);

        return cellStyle;
    }

    /**
     * 创建表头样式
     *
     * @param wb
     * @return
     */
    private static HSSFCellStyle createHeadCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        // 设置自动换行
        cellStyle.setWrapText(true);
        //背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        //下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        //右边框
        cellStyle.setBorderRight(BorderStyle.THIN);
        //上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 创建字体样式
        HSSFFont headerFont = (HSSFFont) wb.createFont();
        //字体加粗
        headerFont.setBold(true);
        // 设置字体类型
        headerFont.setFontName("黑体");
        // 设置字体大小
        headerFont.setFontHeightInPoints((short) 12);
        // 为标题样式设置字体样式
        cellStyle.setFont(headerFont);

        return cellStyle;
    }


}
