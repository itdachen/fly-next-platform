package com.github.itdachen.ooxml.poi.imp;


import com.github.itdachen.framework.context.exception.BizException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析数据, 默认实现
 *
 * @author 王大宸
 * @date 2025/7/25 22:23
 */
public class DefaultAnalysisWorkBook<T> implements IAnalysisWorkBook<T> {

    @Override
    public void analysis(String path, ImpParamsSettings settings, IReadWorkBook<T> readWorkBook) {
        boolean validateExcel = ExcelImpUtils.validateExcel(path);

        if (!validateExcel){
            throw new BizException("数据文件格式错误，不是标准的 xls 或 xlsx 文件！");
        }
       // System.err.println("是否是 Excel: " + b);

        Workbook workbook = ExcelImpUtils.getWorkbook(path);

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
