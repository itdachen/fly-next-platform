package com.github.itdachen.ooxml.poi.imp;

import com.github.itdachen.framework.context.exception.BizException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 导出执行
 *
 * @author 王大宸
 * @date 2025/7/25 22:43
 */
public class WorkBookImpHelper<T> {


    /**
     * 导入参数设置
     */
    private ImpParamsSettings settings;
    /**
     * 读取数据
     */
    private IReadWorkBook<T> readWorkBook;

    private IAnalysisWorkBook<T> analysisWorkBook;

    private MultipartFile multipartFile;

    public WorkBookImpHelper(ImpParamsSettings settings,
                             IReadWorkBook<T> readWorkBook,
                             IAnalysisWorkBook<T> analysisWorkBook,
                             MultipartFile multipartFile) {
        this.settings = settings;
        this.readWorkBook = readWorkBook;
        this.analysisWorkBook = analysisWorkBook;
        this.multipartFile = multipartFile;
    }


    public void execute() throws IOException {

        analysisWorkBook.analysisWorkBook(multipartFile, settings, readWorkBook);

    }


}
