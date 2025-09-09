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
 * 页面访问日志
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
@Table(name = "ta_fly_oplog_page_view")
public class OplogPageView implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键 */
    @Id
    @Column(name = "id")
    private String id = "-";

    /** 平台ID */
    @Column(name = "plat_id")
    private String platId = "-";

    /** 平台名称 */
    @Column(name = "plat_title")
    private String platTitle = "-";

    /** 应用ID */
    @Column(name = "app_id")
    private String appId = "-";

    /** 应用名称 */
    @Column(name = "app_title")
    private String appTitle = "-";

    /** 应用版本号 */
    @Column(name = "app_version")
    private String appVersion = "-";

    /** 租户ID/公司ID */
    @Column(name = "tenant_id")
    private String tenantId = "-";

    /** 租户名称/公司名称 */
    @Column(name = "tenant_title")
    private String tenantTitle = "-";

    /** 省代码 */
    @Column(name = "prov_code")
    private String provCode = "-";

    /** 省名称 */
    @Column(name = "prov_name")
    private String provName = "-";

    /** 市/州代码 */
    @Column(name = "city_code")
    private String cityCode = "-";

    /** 市州名称 */
    @Column(name = "city_name")
    private String cityName = "-";

    /** 区/县代码 */
    @Column(name = "county_code")
    private String countyCode = "-";

    /** 区县名称 */
    @Column(name = "county_name")
    private String countyName = "-";

    /** 乡镇/街道办代码 */
    @Column(name = "town_code")
    private String townCode = "-";

    /** 乡镇/街道办名称 */
    @Column(name = "town_name")
    private String townName = "-";

    /** 部门ID */
    @Column(name = "dept_id")
    private String deptId = "-";

    /** 部门名称 */
    @Column(name = "dept_title")
    private String deptTitle = "-";

    /** 部门等级 */
    @Column(name = "dept_level")
    private String deptLevel = "-";

    /** 上级部门代码 */
    @Column(name = "dept_parent_id")
    private String deptParentId = "-";

    /** 操作人ID */
    @Column(name = "user_id")
    private String userId = "-";

    /** 操作人姓名 */
    @Column(name = "nick_name")
    private String nickName = "-";

    /** 菜单名称 */
    @Column(name = "menu_title")
    private String menuTitle = "-";

    /** 菜单ID */
    @Column(name = "menu_id")
    private String menuId = "-";

    /** 操作类型: SAVE,UPDATE,JUMP,REMOVE */
    @Column(name = "op_code")
    private String opCode = "-";

    /** 操作类型: 新增, 修改, 删除, 查看 */
    @Column(name = "op_title")
    private String opTitle = "-";

    /** 版本号 */
    @Column(name = "op_version")
    private String opVersion = "-";

    /** 操作时间 */
    @Column(name = "op_time")
    private LocalDateTime opTime = LocalDateTime.now();

    /** 操作IP地址 */
    @Column(name = "host_ip")
    private String hostIp = "-";

    /** 操作地址 */
    @Column(name = "host_address")
    private String hostAddress = "-";

    /** 操作系统 */
    @Column(name = "host_os")
    private String hostOs = "-";

    /** 操作浏览器 */
    @Column(name = "host_browser")
    private String hostBrowser = "-";

    /** 用户代理 */
    @Column(name = "user_agent")
    private String userAgent = "-";

    /** 请求ID */
    @Column(name = "request_id")
    private String requestId = "-";

    /** 请求URI */
    @Column(name = "request_uri")
    private String requestUri = "-";

    /** 请求方式: POST, PUT, GET, DELETE */
    @Column(name = "request_method")
    private String requestMethod = "-";

    /** 异常信息 */
    @Column(name = "ex_info")
    private String exInfo = "-";

    /** 备注 */
    @Column(name = "remarks")
    private String remarks = "-";

    /** 服务端处理耗时 */
    @Column(name = "execute_time")
    private String executeTime = "-";

    /** 删除标记:N-未删除;Y-已删除 */
    @Column(name = "remove_flag")
    private String removeFlag = "-";

    /** 年份 */
    @Column(name = "yearly")
    private String yearly = "-";

    /** 月份 */
    @Column(name = "monthly")
    private String monthly = "-";

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser = "-";

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId = "-";

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime = LocalDateTime.now();

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser = "-";

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId = "-";





            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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

            public void setProvCode(String provCode) {
                this.provCode = provCode;
            }

            public String getProvCode() {
                return provCode;
            }

            public void setProvName(String provName) {
                this.provName = provName;
            }

            public String getProvName() {
                return provName;
            }

            public void setCityCode(String cityCode) {
                this.cityCode = cityCode;
            }

            public String getCityCode() {
                return cityCode;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCountyCode(String countyCode) {
                this.countyCode = countyCode;
            }

            public String getCountyCode() {
                return countyCode;
            }

            public void setCountyName(String countyName) {
                this.countyName = countyName;
            }

            public String getCountyName() {
                return countyName;
            }

            public void setTownCode(String townCode) {
                this.townCode = townCode;
            }

            public String getTownCode() {
                return townCode;
            }

            public void setTownName(String townName) {
                this.townName = townName;
            }

            public String getTownName() {
                return townName;
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

            public void setMenuTitle(String menuTitle) {
                this.menuTitle = menuTitle;
            }

            public String getMenuTitle() {
                return menuTitle;
            }

            public void setMenuId(String menuId) {
                this.menuId = menuId;
            }

            public String getMenuId() {
                return menuId;
            }

            public void setOpCode(String opCode) {
                this.opCode = opCode;
            }

            public String getOpCode() {
                return opCode;
            }

            public void setOpTitle(String opTitle) {
                this.opTitle = opTitle;
            }

            public String getOpTitle() {
                return opTitle;
            }

            public void setOpVersion(String opVersion) {
                this.opVersion = opVersion;
            }

            public String getOpVersion() {
                return opVersion;
            }

            public void setOpTime(LocalDateTime opTime) {
                this.opTime = opTime;
            }

            public LocalDateTime getOpTime() {
                return opTime;
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

            public void setUserAgent(String userAgent) {
                this.userAgent = userAgent;
            }

            public String getUserAgent() {
                return userAgent;
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
                    .append("platId", getPlatId())
                    .append("platTitle", getPlatTitle())
                    .append("appId", getAppId())
                    .append("appTitle", getAppTitle())
                    .append("appVersion", getAppVersion())
                    .append("tenantId", getTenantId())
                    .append("tenantTitle", getTenantTitle())
                    .append("provCode", getProvCode())
                    .append("provName", getProvName())
                    .append("cityCode", getCityCode())
                    .append("cityName", getCityName())
                    .append("countyCode", getCountyCode())
                    .append("countyName", getCountyName())
                    .append("townCode", getTownCode())
                    .append("townName", getTownName())
                    .append("deptId", getDeptId())
                    .append("deptTitle", getDeptTitle())
                    .append("deptLevel", getDeptLevel())
                    .append("deptParentId", getDeptParentId())
                    .append("userId", getUserId())
                    .append("nickName", getNickName())
                    .append("menuTitle", getMenuTitle())
                    .append("menuId", getMenuId())
                    .append("opCode", getOpCode())
                    .append("opTitle", getOpTitle())
                    .append("opVersion", getOpVersion())
                    .append("opTime", getOpTime())
                    .append("hostIp", getHostIp())
                    .append("hostAddress", getHostAddress())
                    .append("hostOs", getHostOs())
                    .append("hostBrowser", getHostBrowser())
                    .append("userAgent", getUserAgent())
                    .append("requestId", getRequestId())
                    .append("requestUri", getRequestUri())
                    .append("requestMethod", getRequestMethod())
                    .append("exInfo", getExInfo())
                    .append("remarks", getRemarks())
                    .append("executeTime", getExecuteTime())
                    .append("removeFlag", getRemoveFlag())
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
