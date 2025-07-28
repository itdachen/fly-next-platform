package com.github.itdachen.oplog.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 导入日志 DTO
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
public class OplogPoiImpDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键唯一标识 */
        private String id;

        /** 租户ID/公司ID */
        private String tenantId;

        /** 租户名称/公司名称 */
 @NotBlank(message = "租户名称/公司名称不能为空")
        private String tenantTitle;

        /** 平台ID */
 @NotBlank(message = "平台ID不能为空")
        private String platId;

        /** 平台名称 */
 @NotBlank(message = "平台名称不能为空")
        private String platTitle;

        /** 应用ID */
 @NotBlank(message = "应用ID不能为空")
        private String appId;

        /** 应用名称 */
 @NotBlank(message = "应用名称不能为空")
        private String appTitle;

        /** 应用版本号 */
 @NotBlank(message = "应用版本号不能为空")
        private String appVersion;

        /** 用户ID */
 @NotBlank(message = "用户ID不能为空")
        private String userId;

        /** 昵称 */
 @NotBlank(message = "昵称不能为空")
        private String nickName;

        /** 身份ID */
 @NotBlank(message = "身份ID不能为空")
        private String roleId;

        /** 身份名称 */
 @NotBlank(message = "身份名称不能为空")
        private String roleName;

        /** 省代码 */
 @NotBlank(message = "省代码不能为空")
        private String provId;

        /** 省名称 */
 @NotBlank(message = "省名称不能为空")
        private String provTitle;

        /** 市/州代码 */
 @NotBlank(message = "市/州代码不能为空")
        private String cityId;

        /** 市/州名称 */
 @NotBlank(message = "市/州名称不能为空")
        private String cityTitle;

        /** 区/县代码 */
 @NotBlank(message = "区/县代码不能为空")
        private String countyId;

        /** 区/县名称 */
 @NotBlank(message = "区/县名称不能为空")
        private String countyTitle;

        /** 部门ID */
 @NotBlank(message = "部门ID不能为空")
        private String deptId;

        /** 部门名称 */
 @NotBlank(message = "部门名称不能为空")
        private String deptTitle;

        /** 部门等级 */
 @NotBlank(message = "部门等级不能为空")
        private String deptLevel;

        /** 上级部门代码 */
 @NotBlank(message = "上级部门代码不能为空")
        private String deptParentId;

        /** 消息表ID */
 @NotBlank(message = "消息表ID不能为空")
        private String msgId;

        /** 功能ID/菜单ID(备用) */
 @NotBlank(message = "功能ID/菜单ID(备用)不能为空")
        private String funcId;

        /** 功能名称(备用) */
 @NotBlank(message = "功能名称(备用)不能为空")
        private String funcTitle;

        /** 操作IP地址 */
 @NotBlank(message = "操作IP地址不能为空")
        private String hostIp;

        /** 操作地址 */
 @NotBlank(message = "操作地址不能为空")
        private String hostAddress;

        /** 操作系统 */
 @NotBlank(message = "操作系统不能为空")
        private String hostOs;

        /** 操作浏览器 */
 @NotBlank(message = "操作浏览器不能为空")
        private String hostBrowser;

        /** 用户代理 */
 @NotBlank(message = "用户代理不能为空")
        private String hostUserAgent;

        /** 请求ID */
 @NotBlank(message = "请求ID不能为空")
        private String requestId;

        /** 请求URI */
 @NotBlank(message = "请求URI不能为空")
        private String requestUri;

        /** 请求方式: POST, PUT, GET, DELETE */
 @NotBlank(message = "请求方式: POST, PUT, GET, DELETE不能为空")
        private String requestMethod;

        /** 请求参数 */
 @NotBlank(message = "请求参数不能为空")
        private String requestParams;

        /** 数据总量 */
 @NotBlank(message = "数据总量不能为空")
        private String dataTotal;

        /** 导入文件名称 */
 @NotBlank(message = "导入文件名称不能为空")
        private String fileName;

        /** 文件地址 */
 @NotBlank(message = "文件地址不能为空")
        private String fileUrl;

        /** 文件大小 */
 @NotBlank(message = "文件大小不能为空")
        private String fileSize;

        /** 文件数量 */
 @NotBlank(message = "文件数量不能为空")
        private String fileTotal;

        /** 异常信息 */
 @NotBlank(message = "异常信息不能为空")
        private String exInfo;

        /** 备注 */
        private String remarks;

        /** 服务端处理耗时 */
 @NotBlank(message = "服务端处理耗时不能为空")
        private String executeTime;

        /** 年份 */
 @NotBlank(message = "年份不能为空")
        private String yearly;

        /** 月份 */
 @NotBlank(message = "月份不能为空")
        private String monthly;





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
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                .toString();
    }

}
