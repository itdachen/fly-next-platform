package com.github.itdachen.oplog.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 导出日志 VO
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
public class OplogPoiExpVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    private String id;

    /**
     * 租户ID/公司ID
     */
    private String tenantId;

    /**
     * 租户名称/公司名称
     */
    private String tenantTitle;

    /**
     * 平台ID
     */
    private String platId;

    /**
     * 平台名称
     */
    private String platTitle;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appTitle;

    /**
     * 应用版本号
     */
    private String appVersion;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 身份ID
     */
    private String roleId;

    /**
     * 身份名称
     */
    private String roleName;

    /**
     * 省代码
     */
    private String provId;

    /**
     * 省名称
     */
    private String provTitle;

    /**
     * 市/州代码
     */
    private String cityId;

    /**
     * 市/州名称
     */
    private String cityTitle;

    /**
     * 区/县代码
     */
    private String countyId;

    /**
     * 区/县名称
     */
    private String countyTitle;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptTitle;

    /**
     * 部门等级
     */
    private String deptLevel;

    /**
     * 上级部门代码
     */
    private String deptParentId;

    /**
     * 消息表ID
     */
    private String msgId;

    /**
     * 功能ID/菜单ID(备用)
     */
    private String funcId;

    /**
     * 功能名称
     */
    private String funcTitle;

    /**
     * 操作IP地址
     */
    private String hostIp;

    /**
     * 操作地址
     */
    private String hostAddress;

    /**
     * 操作系统
     */
    private String hostOs;

    /**
     * 操作浏览器
     */
    private String hostBrowser;

    /**
     * 用户代理
     */
    private String hostUserAgent;

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 请求方式: POST, PUT, GET, DELETE
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 数据总量
     */
    private String dataTotal;

    /**
     * 导出文件名称
     */
    private String fileName;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件数量
     */
    private String fileTotal;

    /**
     * 异常信息
     */
    private String exInfo;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 服务端处理耗时
     */
    private String executeTime;

    /**
     * 删除时间
     */
    private LocalDateTime removeTime;

    /**
     * 删除人ID
     */
    private String removeUserId;

    /**
     * 删除人昵称
     */
    private String removeUser;

    /**
     * 年份
     */
    private String yearly;

    /**
     * 月份
     */
    private String monthly;

    private LocalDateTime createTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantTitle(String tenantTitle) {
        this.tenantTitle = tenantTitle;
    }

    public String getTenantTitle() {
        return tenantTitle;
    }

    public void setPlatId(String platId) {
        this.platId = platId;
    }

    public String getPlatId() {
        return platId;
    }

    public void setPlatTitle(String platTitle) {
        this.platTitle = platTitle;
    }

    public String getPlatTitle() {
        return platTitle;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvTitle(String provTitle) {
        this.provTitle = provTitle;
    }

    public String getProvTitle() {
        return provTitle;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyTitle(String countyTitle) {
        this.countyTitle = countyTitle;
    }

    public String getCountyTitle() {
        return countyTitle;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptParentId(String deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getDeptParentId() {
        return deptParentId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostOs(String hostOs) {
        this.hostOs = hostOs;
    }

    public String getHostOs() {
        return hostOs;
    }

    public void setHostBrowser(String hostBrowser) {
        this.hostBrowser = hostBrowser;
    }

    public String getHostBrowser() {
        return hostBrowser;
    }

    public void setHostUserAgent(String hostUserAgent) {
        this.hostUserAgent = hostUserAgent;
    }

    public String getHostUserAgent() {
        return hostUserAgent;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setDataTotal(String dataTotal) {
        this.dataTotal = dataTotal;
    }

    public String getDataTotal() {
        return dataTotal;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileTotal(String fileTotal) {
        this.fileTotal = fileTotal;
    }

    public String getFileTotal() {
        return fileTotal;
    }

    public void setExInfo(String exInfo) {
        this.exInfo = exInfo;
    }

    public String getExInfo() {
        return exInfo;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setRemoveTime(LocalDateTime removeTime) {
        this.removeTime = removeTime;
    }

    public LocalDateTime getRemoveTime() {
        return removeTime;
    }

    public void setRemoveUserId(String removeUserId) {
        this.removeUserId = removeUserId;
    }

    public String getRemoveUserId() {
        return removeUserId;
    }

    public void setRemoveUser(String removeUser) {
        this.removeUser = removeUser;
    }

    public String getRemoveUser() {
        return removeUser;
    }

    public void setYearly(String yearly) {
        this.yearly = yearly;
    }

    public String getYearly() {
        return yearly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getMonthly() {
        return monthly;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("tenantTitle", getTenantTitle())
                .append("platId", getPlatId())
                .append("platTitle", getPlatTitle())
                .append("appId", getAppId())
                .append("appTitle", getAppTitle())
                .append("appVersion", getAppVersion())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("roleId", getRoleId())
                .append("roleName", getRoleName())
                .append("provId", getProvId())
                .append("provTitle", getProvTitle())
                .append("cityId", getCityId())
                .append("cityTitle", getCityTitle())
                .append("countyId", getCountyId())
                .append("countyTitle", getCountyTitle())
                .append("deptId", getDeptId())
                .append("deptTitle", getDeptTitle())
                .append("deptLevel", getDeptLevel())
                .append("deptParentId", getDeptParentId())
                .append("msgId", getMsgId())
                .append("funcId", getFuncId())
                .append("funcTitle", getFuncTitle())
                .append("hostIp", getHostIp())
                .append("hostAddress", getHostAddress())
                .append("hostOs", getHostOs())
                .append("hostBrowser", getHostBrowser())
                .append("hostUserAgent", getHostUserAgent())
                .append("requestId", getRequestId())
                .append("requestUri", getRequestUri())
                .append("requestMethod", getRequestMethod())
                .append("requestParams", getRequestParams())
                .append("dataTotal", getDataTotal())
                .append("fileName", getFileName())
                .append("fileUrl", getFileUrl())
                .append("fileSize", getFileSize())
                .append("fileTotal", getFileTotal())
                .append("exInfo", getExInfo())
                .append("remarks", getRemarks())
                .append("executeTime", getExecuteTime())
                .append("removeTime", getRemoveTime())
                .append("removeUserId", getRemoveUserId())
                .append("removeUser", getRemoveUser())
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .append("createTime", getCreateTime())
                .toString();
    }

}
