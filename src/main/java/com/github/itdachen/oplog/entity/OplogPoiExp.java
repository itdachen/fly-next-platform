package com.github.itdachen.oplog.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDateTime;



/**
 * 导出日志
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
@Table(name = "ta_fly_oplog_poi_exp")
public class OplogPoiExp implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户ID/公司ID */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 租户名称/公司名称 */
    @Column(name = "tenant_title")
    private String tenantTitle;

    /** 平台ID */
    @Column(name = "plat_id")
    private String platId;

    /** 平台名称 */
    @Column(name = "plat_title")
    private String platTitle;

    /** 应用ID */
    @Column(name = "app_id")
    private String appId;

    /** 应用名称 */
    @Column(name = "app_title")
    private String appTitle;

    /** 应用版本号 */
    @Column(name = "app_version")
    private String appVersion;

    /** 用户ID */
    @Column(name = "user_id")
    private String userId;

    /** 昵称 */
    @Column(name = "nick_name")
    private String nickName;

    /** 身份ID */
    @Column(name = "role_id")
    private String roleId;

    /** 身份名称 */
    @Column(name = "role_name")
    private String roleName;

    /** 省代码 */
    @Column(name = "prov_id")
    private String provId;

    /** 省名称 */
    @Column(name = "prov_title")
    private String provTitle;

    /** 市/州代码 */
    @Column(name = "city_id")
    private String cityId;

    /** 市/州名称 */
    @Column(name = "city_title")
    private String cityTitle;

    /** 区/县代码 */
    @Column(name = "county_id")
    private String countyId;

    /** 区/县名称 */
    @Column(name = "county_title")
    private String countyTitle;

    /** 部门ID */
    @Column(name = "dept_id")
    private String deptId;

    /** 部门名称 */
    @Column(name = "dept_title")
    private String deptTitle;

    /** 部门等级 */
    @Column(name = "dept_level")
    private String deptLevel;

    /** 上级部门代码 */
    @Column(name = "dept_parent_id")
    private String deptParentId;

    /** 消息表ID */
    @Column(name = "msg_id")
    private String msgId;

    /** 功能ID/菜单ID(备用) */
    @Column(name = "func_id")
    private String funcId;

    /** 功能名称 */
    @Column(name = "func_title")
    private String funcTitle;

    /** 操作IP地址 */
    @Column(name = "host_ip")
    private String hostIp;

    /** 操作地址 */
    @Column(name = "host_address")
    private String hostAddress;

    /** 操作系统 */
    @Column(name = "host_os")
    private String hostOs;

    /** 操作浏览器 */
    @Column(name = "host_browser")
    private String hostBrowser;

    /** 用户代理 */
    @Column(name = "host_user_agent")
    private String hostUserAgent;

    /** 请求ID */
    @Column(name = "request_id")
    private String requestId;

    /** 请求URI */
    @Column(name = "request_uri")
    private String requestUri;

    /** 请求方式: POST, PUT, GET, DELETE */
    @Column(name = "request_method")
    private String requestMethod;

    /** 请求参数 */
    @Column(name = "request_params")
    private String requestParams;

    /** 数据总量 */
    @Column(name = "data_total")
    private String dataTotal;

    /** 导出文件名称 */
    @Column(name = "file_name")
    private String fileName;

    /** 文件地址 */
    @Column(name = "file_url")
    private String fileUrl;

    /** 文件大小 */
    @Column(name = "file_size")
    private String fileSize;

    /** 文件数量 */
    @Column(name = "file_total")
    private String fileTotal;

    /** 异常信息 */
    @Column(name = "ex_info")
    private String exInfo;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 服务端处理耗时 */
    @Column(name = "execute_time")
    private String executeTime;

    /** 删除标记:N-未删除;Y-已删除 */
    @Column(name = "remove_flag")
    private String removeFlag;

    /** 删除时间 */
    @Column(name = "remove_time")
    private LocalDateTime removeTime;

    /** 删除人ID */
    @Column(name = "remove_user_id")
    private String removeUserId;

    /** 删除人昵称 */
    @Column(name = "remove_user")
    private String removeUser;

    /** 年份 */
    @Column(name = "yearly")
    private String yearly;

    /** 月份 */
    @Column(name = "monthly")
    private String monthly;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId;





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

            public void setRemoveFlag(String removeFlag) {
                this.removeFlag = removeFlag;
            }

            public String getRemoveFlag() {
                return removeFlag;
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

            public void setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setUpdateTime(LocalDateTime updateTime) {
                this.updateTime = updateTime;
            }

            public LocalDateTime getUpdateTime() {
                return updateTime;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUserId() {
                return updateUserId;
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
                    .append("removeFlag", getRemoveFlag())
                    .append("removeTime", getRemoveTime())
                    .append("removeUserId", getRemoveUserId())
                    .append("removeUser", getRemoveUser())
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                    .append("createTime", getCreateTime())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateTime", getUpdateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
