package com.github.itdachen.ooxml.poi;

import com.github.itdachen.ooxml.poi.imp.DefaultWorkBookImpFileUpload;
import com.github.itdachen.ooxml.poi.imp.IWorkBookImpFileUploadHandler;
import com.github.itdachen.ooxml.poi.imp.ImpParamsSettings;
import com.github.itdachen.ooxml.poi.utils.ReplyResponseMsgUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * OOXmlPoiImpHelper
 *
 * @author 王大宸
 * @date 2025-07-25 15:58
 */
public class OOXmlPoiImpHelper<T> {


    /**
     * 从第几行还是读取
     */
    private int firstRowNum = 2;

    /**
     * 导入参数设置
     */
    private ImpParamsSettings settings;

    /**
     * 文件上传处理方法, 默认实现
     */
    private IWorkBookImpFileUploadHandler uploadHandler = new DefaultWorkBookImpFileUpload();

    /**
     * 从第几行开始读取
     */
    public OOXmlPoiImpHelper<T> firstRowNum(int firstRowNum) {
        this.firstRowNum = firstRowNum;
        return this;
    }

    /***
     * 文件上传处理方法
     *
     * @author 王大宸
     * @date 2025/7/25 17:22
     * @param uploadHandler uploadHandler
     * @return com.github.itdachen.ooxml.poi.OOXmlPoiImpHelper<T>
     */
    public OOXmlPoiImpHelper<T> uploadHandler(IWorkBookImpFileUploadHandler uploadHandler) {
        this.uploadHandler = uploadHandler;
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
