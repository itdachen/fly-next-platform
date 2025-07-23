package com.github.itdachen.ooxml.poi.exp;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.autoconfigure.AppHelper;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.framework.core.utils.LocalDateUtils;
import com.github.itdachen.ooxml.poi.entity.MsgFileModel;
import com.github.itdachen.ooxml.poi.entity.PoiUploadInfo;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * 创建表格默认实现方式
 *
 * @author 王大宸
 * @date 2025/7/11 23:44
 */
public class DefaultCreateWorkBook<T, Q> implements ICreateWorkBook<T, Q> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultCreateWorkBook.class);


    /***
     * 创建表格
     *
     * @author 王大宸
     * @date 2025/7/22 15:18
     * @param settings settings
     * @param handler handler
     * @param bookNum  第几个表格
     * @param msgId    导出消息ID
     * @return void
     */
    @Override
    public void createWorkBook(ParameterSettings<Q> settings,
                               IWriteWorkBook<T, Q> handler,
                               int bookNum, String msgId) {


        final String localDate = LocalDateUtils.getLocalDate().replaceAll("-", "");
        final String fileTitle = settings.getTitle() + bookNum + "_" + localDate + settings.getFileFormat();

        String msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》文件开始导出！";
        appendMessageContent(msgId, msgContent, settings.getSendMsg());


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        XSSFWorkbook workbook = new XSSFWorkbook();
        try {
            /* 查询可导出的数据 */
            Integer limit = Integer.parseInt(String.valueOf(settings.getSheetRowNum()));
            List<T> dataList = handler.data(settings.getParams(), bookNum, limit);

            msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》获取数据成功，共 " + dataList.size() + " 条数据！";
            appendMessageContent(msgId, msgContent, settings.getSendMsg());

            /* 创建 sheet */
            Sheet sheet = workbook.createSheet(settings.getTitle() + bookNum);
            sheet.setDefaultColumnWidth(30); // 设置默认宽度

            /* 表头设置 */
            //两个方法区别在有自定义表头标题
            ExcelExpUtils.setTableTitleCell(workbook, sheet, settings.getTitle(), settings.getFields(), settings.getAddIndexNum());

            if (!dataList.isEmpty()) {

                msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》文件数据开始写入表格！";
                appendMessageContent(msgId, msgContent, settings.getSendMsg());

                /* 数据写入表格, 根据调用方情况自定义 */
                handler.writeWorkBook(workbook, sheet, dataList, settings.getAddIndexNum());

                msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》文件数据写入结束表格！";
                appendMessageContent(msgId, msgContent, settings.getSendMsg());

            }

            dataList = null;

            PoiUploadInfo uploadInfo = new PoiUploadInfo();

            /* 导出是否保存到服务器 */
            if (settings.getUploadFile()) {
                msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》导出结果开始上传到服务器！";
                appendMessageContent(msgId, msgContent, settings.getSendMsg());


                WorkBookExpFileUploadHandler.setUploadToFolder(workbook, uploadInfo);


                msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》导出结果上传到服务器结束！";
                appendMessageContent(msgId, msgContent, settings.getSendMsg());
            }


            /* 下载文件消息入库: 能推送消息, 能上传文件 */
            if (settings.getSendMsg() && settings.getUploadFile()) {
                MsgFileModel messageFile = MsgFileModel.builder()
                        .id(IdUtils.getId())
                        .msgId(msgId)
                        .appId(AppHelper.app().properties().getAppId())
                        .fileFormat(settings.getFileFormat())
                        .fileTitle(fileTitle)
                        .fileUrl(uploadInfo.getFileUri())
                        .fileSize(uploadInfo.getFileSize() + "")
                        .build();
                AppContextHelper.getBean(IOplogMsgClient.class).saveMsgFile(messageFile);
            }


            msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》导出完成！";
            appendMessageContent(msgId, msgContent, settings.getSendMsg());

        } catch (Exception e) {
            logger.error("数据 " + fileTitle + " 导出失败: {} ", e.getMessage(), e);
            msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》导出失败：" + e.getMessage();
            appendMessageContent(msgId, msgContent, settings.getSendMsg());
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }

                /* 计时结束 */
                stopWatch.stop();

                msgContent = "【" + LocalDateUtils.getLocalDateTime() + "】《" + fileTitle + "》导出记录开始保存到数据库，本次导出共用时 " + stopWatch.getTotalTimeSeconds() + " 秒！导出记录保存到数据库结束！<br>";
                appendMessageContent(msgId, msgContent, settings.getSendMsg());

                stopWatch = null;
            } catch (Exception e) {
                logger.error("数据导出, 关闭输出流失败: {} ", e.getMessage(), e);
            }

        }


    }


    /***
     * 消息追加统一处理
     *
     * @author 王大宸
     * @date 2025/7/11 23:58
     * @param msgId       消息ID
     * @param msgContent  追加消息内容
     * @param sendMessage 是否添加消息
     * @return void
     */
    private void appendMessageContent(String msgId, String msgContent, boolean sendMessage) {
        if (sendMessage) {
            WorkBookExpMessageHandler.appendContent(msgId, msgContent);
        }
    }


}
