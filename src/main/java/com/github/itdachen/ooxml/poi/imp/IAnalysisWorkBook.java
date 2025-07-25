package com.github.itdachen.ooxml.poi.imp;

import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * 解析表格
 *
 * @author 王大宸
 * @date 2025/7/25 22:05
 */
public interface IAnalysisWorkBook<T> {


    /***
     * 解析表格
     *
     * @author 王大宸
     * @date 2025/7/25 22:27
     * @param path path
     * @return void
     */
    void analysis(String path, ImpParamsSettings settings, IReadWorkBook<T> readWorkBook);

}
