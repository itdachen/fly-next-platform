package com.github.itdachen.ooxml.poi.imp.handler;


import com.github.itdachen.boot.oss.entity.FileInfo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.ooxml.poi.imp.utils.ExcelImpUtils;
import com.github.itdachen.ooxml.poi.imp.IReadWorkBookHandler;
import com.github.itdachen.ooxml.poi.imp.ImpParamsSettings;
import com.github.itdachen.ooxml.poi.msg.OOXmlPoiMsgHandler;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析数据, 默认实现
 *
 * @author 王大宸
 * @date 2025/7/25 22:23
 */
public class DefaultAnalysisOOXmlPoiHandler<T> implements IAnalysisOOXmlPoiHandler<T> {

    /***
     * 文件解析
     *
     * @author 王大宸
     * @date 2025/7/25 23:18
     * @param workBookFile workBookFile
     * @param settings     settings
     * @param readWorkBook readWorkBook
     * @return void
     */
    @Override
    public void analysisWorkBook(MultipartFile workBookFile,
                                 ImpParamsSettings settings,
                                 IReadWorkBookHandler<T> readWorkBook,
                                 IOOXmlPoiImpFileUploadHandler fileUploadHandler) throws Exception {
        final String msgId = IdUtils.getId();

        /* 添加消息 */
        OOXmlPoiMsgHandler.saveImpMsgInfo(
                settings.getRequest(),
                msgId,
                settings.getTitle() + "开始导入!",
                settings.getTitle(),
                settings.getUserDetails()
        );


        String workBookFilename = workBookFile.getOriginalFilename();
        boolean validateExcel = ExcelImpUtils.validateExcel(workBookFilename);

        if (!validateExcel) {
            throw new BizException("数据文件格式错误，不是标准的 xls 或 xlsx 文件！");
        }



        /* 文件上传 */

        FileInfo upload = fileUploadHandler.toUpload(workBookFile);


        Workbook workbook = new XSSFWorkbook(workBookFile.getInputStream()); //情况1
        //   Workbook workbook = ExcelImpUtils.getWorkbook(path); // 情况2, 根据文件上传地址获取表格数据

        /* 获取该表格有几个 Sheet */
        int workbookSheetNumber = ExcelImpUtils.getWorkbookSheetNumber(workbook);


        Sheet sheet;
        int rows;
        Row row;
        List<T> list = new ArrayList<>();
        for (int i = 0; i < workbookSheetNumber; i++) {
            list = new ArrayList<>(); // 存放数据

            sheet = ExcelImpUtils.getSheet(workbook, i);

            rows = sheet.getPhysicalNumberOfRows();//getPhysicalNumberOfRows 获取所有行数
            System.out.println("行数是: " + rows);


            /* 解析行 */
            for (int i1 = settings.getFirstRowNum(); i1 < rows; i1++) {
                row = sheet.getRow(i1);

                /* 解析列, 交给调用方自动实现  cells = row.getPhysicalNumberOfCells(); */
                readWorkBook.readRows(list, row, i, sheet.getSheetName());

            }

            /* 数据处理, 交给调用方处理, 数据入库 */
            readWorkBook.handler(list);


        }
    }


}
