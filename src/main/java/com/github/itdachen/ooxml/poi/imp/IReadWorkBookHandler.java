package com.github.itdachen.ooxml.poi.imp;

import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * 读取表格
 *
 * @author 王大宸
 * @date 2025-07-25 15:17
 */
public interface IReadWorkBookHandler<T> {

    /***
     * 读取行
     *
     * @author 王大宸
     * @date 2025/7/25 22:16
     * @param list      存放数据的集合
     * @param row       表格行数据
     * @param index     行数
     * @param sheetName 表格名称
     * @return void
     */
    void readRows(List<T> list, Row row, int index, String sheetName);

    /***
     * 最终数据处理, 数据入库
     *
     * @author 王大宸
     * @date 2025/7/25 15:36
     * @param list list
     * @return void
     */
    void handler(List<T> list);


}
