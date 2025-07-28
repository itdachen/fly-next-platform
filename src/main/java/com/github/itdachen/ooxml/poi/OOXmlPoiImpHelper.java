package com.github.itdachen.ooxml.poi;

import com.github.itdachen.ooxml.poi.imp.*;
import com.github.itdachen.ooxml.poi.imp.handler.DefaultAnalysisOOXmlPoiHandler;
import com.github.itdachen.ooxml.poi.imp.handler.DefaultOOXmlPoiImpFileUploadHandler;
import com.github.itdachen.ooxml.poi.imp.handler.IAnalysisOOXmlPoiHandler;
import com.github.itdachen.ooxml.poi.imp.handler.IOOXmlPoiImpFileUploadHandler;
import com.github.itdachen.ooxml.poi.utils.ReplyResponseMsgUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * OOXmlPoiImpHelper
 *
 * @author 王大宸
 * @date 2025-07-25 15:58
 */
public class OOXmlPoiImpHelper<T> {

    /**
     * 导入参数设置
     */
    private ImpParamsSettings settings;

    /**
     * 读取数据
     */
    private IReadWorkBookHandler<T> readWorkBook;

    /**
     * 解析表格
     */
    private IAnalysisOOXmlPoiHandler<T> analysisWorkBook = new DefaultAnalysisOOXmlPoiHandler<>();

    /**
     * 需要导入的文件
     */
    private MultipartFile workBookFile;

    /***
     * 文件上传接口, 可以自定义实现
     */
    private IOOXmlPoiImpFileUploadHandler fileUploadHandler = new DefaultOOXmlPoiImpFileUploadHandler();

    /**
     * 需要导入的文件
     */
    public OOXmlPoiImpHelper<T> workBookFile(MultipartFile workBookFile) {
        this.workBookFile = workBookFile;
        return this;
    }

    /**
     * 导入参数设置
     */
    public OOXmlPoiImpHelper<T> settings(ImpParamsSettings settings) {
        this.settings = settings;
        return this;
    }

    /***
     * 读取数据
     *
     * @author 王大宸
     * @date 2025/7/25 22:57
     * @param readWorkBook readWorkBook
     * @return com.github.itdachen.ooxml.poi.OOXmlPoiImpHelper<T>
     */
    public OOXmlPoiImpHelper<T> readWorkBook(IReadWorkBookHandler<T> readWorkBook) {
        this.readWorkBook = readWorkBook;
        return this;
    }

    /**
     * 解析表格
     */
    public OOXmlPoiImpHelper<T> analysisWorkBook(IAnalysisOOXmlPoiHandler<T> analysisWorkBook) {
        this.analysisWorkBook = analysisWorkBook;
        return this;
    }


    /**
     * 文件上传接口, 可以自定义实现
     */
    public OOXmlPoiImpHelper<T> fileUploadHandler(IOOXmlPoiImpFileUploadHandler fileUploadHandler) {
        this.fileUploadHandler = fileUploadHandler;
        return this;
    }


    /***
     * 导入
     *
     * @author 王大宸
     * @date 2025/7/25 16:03
     * @return com.github.itdachen.ooxml.poi.OOXmlPoiImpHelper<T>
     */
    public OOXmlPoiImpHelper<T> execute() throws Exception {
        analysisWorkBook.analysisWorkBook(workBookFile, settings, readWorkBook, fileUploadHandler);
        return this;
    }


    /***
     * 执行导入, 返回给前端消息
     *
     * @author 王大宸
     * @date 2025/7/25 22:52
     * @return com.github.itdachen.ooxml.poi.OOXmlPoiImpHelper<T>
     */
    public OOXmlPoiImpHelper<T> reply() throws IOException {
        ReplyResponseMsgUtils.reply(settings.getResponse(), "数据正在导入，请刷新【消息中心】信息！");
        return this;
    }


}
