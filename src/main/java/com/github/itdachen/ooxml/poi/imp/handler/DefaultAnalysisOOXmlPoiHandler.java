package com.github.itdachen.ooxml.poi.imp.handler;


import com.github.itdachen.boot.oss.entity.FileInfo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import com.github.itdachen.ooxml.poi.imp.utils.ExcelImpUtils;
import com.github.itdachen.ooxml.poi.imp.IReadWorkBookHandler;
import com.github.itdachen.ooxml.poi.imp.ImpParamsSettings;
import com.github.itdachen.ooxml.poi.msg.OOXmlPoiMsgHandler;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
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
    private static final Logger logger = LoggerFactory.getLogger(DefaultAnalysisOOXmlPoiHandler.class);

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
                "=========== 开始导入 ===========",
                settings.getTitle(),
                settings.getUserDetails()
        );
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            String workBookFilename = workBookFile.getOriginalFilename();
            OOXmlPoiMsgHandler.appendContent(msgId, "正在校验文件校验格式是否正确，文件名为《" + workBookFilename + "》!");
            boolean validateExcel = ExcelImpUtils.validateExcel(workBookFilename);
            if (!validateExcel) {
                OOXmlPoiMsgHandler.appendContent(msgId, "文件校验格式不正确，数据文件格式错误，不是标准的 xls 或 xlsx 文件，导入强制终止!");
                throw new BizException("数据文件格式错误，不是标准的 xls 或 xlsx 文件！");
            }

            OOXmlPoiMsgHandler.appendContent(msgId, "文件格式校验完成，开始上传文件至服务器!");
            /* 文件上传 */
            FileInfo upload = fileUploadHandler.toUpload(workBookFile);
            OOXmlPoiMsgHandler.appendContent(msgId, "文件已上传至服务器保存，开始读取文件信息!");

            Workbook workbook = new XSSFWorkbook(workBookFile.getInputStream()); //情况1
            //   Workbook workbook = ExcelImpUtils.getWorkbook(path); // 情况2, 根据文件上传地址获取表格数据
            /* 获取该表格有几个 Sheet */
            int workbookSheetNumber = ExcelImpUtils.getWorkbookSheetNumber(workbook);

            OOXmlPoiMsgHandler.appendContent(msgId, "已从文件中获取 " + workbookSheetNumber + " 个 sheet 表格数据！<br>");

            Sheet sheet;
            int rows;
            Row row;
            List<T> list = new ArrayList<>();
            long dataTotal = 0L;
            for (int i = 0; i < workbookSheetNumber; i++) {
                list = new ArrayList<>(); // 存放数据
                sheet = ExcelImpUtils.getSheet(workbook, i);

                OOXmlPoiMsgHandler.appendContent(msgId, "正在读取第 " + i + 1 + " 个 sheet 表格数据，sheet 名称为《" + sheet.getSheetName() + "》！");

                /* 获取表格行数 */
                rows = sheet.getPhysicalNumberOfRows();
                /* 解析行 */
                for (int i1 = settings.getFirstRowNum(); i1 < rows; i1++) {
                    row = sheet.getRow(i1);

                    /* 解析列, 交给调用方自动实现  cells = row.getPhysicalNumberOfCells(); */
                    readWorkBook.readRows(list, row, i, sheet.getSheetName());

                }
                OOXmlPoiMsgHandler.appendContent(msgId, "读取第 " + i + 1 + " 个 sheet 表格数据完成，该 sheet 共计 " + list.size() + " 条数据，正在对数据进行入库处理！");

                /* 数据处理, 交给调用方处理, 数据入库 */
                readWorkBook.handler(list);

                OOXmlPoiMsgHandler.appendContent(msgId, "第 " + i + 1 + " 个 sheet 表格数据入库处理完成！<br>");

                dataTotal += list.size();
            }

            OOXmlPoiMsgHandler.appendContent(msgId, "数据读取完成，本次导入共计 " + dataTotal + " 条数据！");

            /* 计时结束 */
            stopWatch.stop();


            PoiUploadInfo uploadInfo = new PoiUploadInfo(settings.getTitle(), dataTotal, 1L);
            uploadInfo.setFileSize(upload.getSize());
            uploadInfo.setFileUri(upload.getUrl());
            uploadInfo.setFileDiskUri(upload.getUrl());
            uploadInfo.setTakeUpTime(stopWatch.getTotalTimeSeconds() + "");

            OOXmlPoiMsgHandler.appendContent(msgId, "正在记录导入日志！");
            /* 导入日志入库 */
            OOXmlPoiImpLogHandler.saveLog(settings, msgId, uploadInfo);
            OOXmlPoiMsgHandler.appendContent(msgId, "导入日志记录完成，本次导入共用时 " + stopWatch.getTotalTimeSeconds() + " 秒！");
            OOXmlPoiMsgHandler.appendContent(msgId, "=========== 导入完成 ===========");
        } catch (Exception e) {
            logger.error("{} 数据导入失败: ", settings.getTitle(), e);
            OOXmlPoiMsgHandler.appendContent(msgId, "=========== 导入失败 ===========");
            OOXmlPoiMsgHandler.appendContent(msgId, "失败原因：" + e.getMessage());
        }


    }


}
