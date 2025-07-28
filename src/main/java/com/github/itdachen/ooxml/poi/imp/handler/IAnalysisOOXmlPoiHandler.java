package com.github.itdachen.ooxml.poi.imp.handler;

import com.github.itdachen.ooxml.poi.imp.IReadWorkBookHandler;
import com.github.itdachen.ooxml.poi.imp.ImpParamsSettings;
import org.springframework.web.multipart.MultipartFile;

/**
 * 解析表格
 *
 * @author 王大宸
 * @date 2025/7/25 22:05
 */
public interface IAnalysisOOXmlPoiHandler<T> {


    /***
     * 解析表格
     *
     * @author 王大宸
     * @date 2025/7/28 9:42
     * @param workBookFile workBookFile
     * @param settings settings
     * @param readWorkBook readWorkBook
     * @return void
     */
    void analysisWorkBook(MultipartFile workBookFile,
                          ImpParamsSettings settings,
                          IReadWorkBookHandler<T> readWorkBook,
                          IOOXmlPoiImpFileUploadHandler fileUploadHandler) throws Exception;


}
