package com.github.itdachen.ooxml.poi.imp;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 导入参数设置
 *
 * @author 王大宸
 * @date 2025/7/25 22:18
 */
public class ImpParamsSettings {

    /**
     * 请求信息
     */
    private HttpServletRequest request;

    /**
     * 相应信息
     */
    private HttpServletResponse response;


    /**
     * 用户信息
     */
    private UserInfoDetails userDetails = BizContextHandler.getUserDetails();


    /**
     * 标题
     */
    private String title = "导入文件";

    /**
     * 是否存服务器
     */
    private Boolean uploadFile = true;

    /**
     * 是否添加序号
     */
    private Boolean addIndexNum = true;

    /**
     * 是否保存日志
     */
    private Boolean saveLog = true;

    /**
     * 是否推送执行完成的消息消息
     */
    private Boolean sendMsg = true;

    /**
     * 从第几行还是读取
     */
    private int firstRowNum = 2;


    public ImpParamsSettings(HttpServletRequest request,
                             HttpServletResponse response,
                             UserInfoDetails userDetails) {
        this.request = request;
        this.response = response;
        this.userDetails = userDetails;
    }

    public ImpParamsSettings(HttpServletRequest request,
                             HttpServletResponse response,
                             UserInfoDetails userDetails,
                             String title) {
        this.request = request;
        this.response = response;
        this.userDetails = userDetails;
        this.title = title;
    }


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public UserInfoDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserInfoDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(Boolean uploadFile) {
        this.uploadFile = uploadFile;
    }

    public Boolean getAddIndexNum() {
        return addIndexNum;
    }

    public void setAddIndexNum(Boolean addIndexNum) {
        this.addIndexNum = addIndexNum;
    }

    public Boolean getSaveLog() {
        return saveLog;
    }

    public void setSaveLog(Boolean saveLog) {
        this.saveLog = saveLog;
    }

    public Boolean getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(Boolean sendMsg) {
        this.sendMsg = sendMsg;
    }

    public int getFirstRowNum() {
        return firstRowNum;
    }

    public void setFirstRowNum(int firstRowNum) {
        this.firstRowNum = firstRowNum;
    }
}
