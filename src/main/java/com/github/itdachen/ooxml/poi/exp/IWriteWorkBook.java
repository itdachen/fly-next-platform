package com.github.itdachen.ooxml.poi.exp;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * 数据写入表格
 *
 * @author 王大宸
 * @date 2025/7/11 23:39
 */
public interface IWriteWorkBook<T,Q> {



    /***
     * 查询数据总行数
     *
     * @author 王大宸
     * @date 2025/7/8 17:26
     * @param params 查询参数
     * @return java.lang.Long
     */
    Long total(Q params);

    /***
     * 获取数据
     *
     * @author 王大宸
     * @date 2025/7/8 16:15
     * @param params 查询参数
     * @param page   当前查询页数
     * @param limit  查询多少条
     * @return java.util.List<T>
     */
    List<T> data(Q params, Integer page, Integer limit);

    /***
     * 导出处理方法, 这里提供一个默认的处理方法, 也可以从写这个方法实现自己的导出方式
     *
     * @author 王大宸
     * @date 2025/7/11 23:47
     * @param workbook workbook
     * @param sheet sheet
     * @param list list
     * @param hasRowNum hasRowNum
     * @return void
     */
    void writeWorkBook(XSSFWorkbook workbook, Sheet sheet, List<T> list, boolean hasRowNum);

}
