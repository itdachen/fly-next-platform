package com.github.itdachen.ooxml.poi.exp;


/**
 * 创建表格
 *
 * @author 王大宸
 * @date 2025/7/11 23:39
 */
public interface ICreateWorkBook<T, Q> {

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
    void createWorkBook(ParameterSettings<Q> settings, IWriteWorkBook<T, Q> handler, int bookNum, String msgId,    IWorkBookExpFileUpload fileUploadHandler);


}
