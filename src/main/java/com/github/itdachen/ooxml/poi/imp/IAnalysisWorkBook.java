package com.github.itdachen.ooxml.poi.imp;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    void analysisWorkBook(MultipartFile workBookFile, ImpParamsSettings settings, IReadWorkBook<T> readWorkBook) throws IOException;


}
