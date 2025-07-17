package com.github.itdachen.msg.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDateTime;



/**
 * 消息池
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
@Table(name = "ta_fly_msg_pool")
public class MsgPool implements Serializable{
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

    /** 市/州代码 */
    @Column(name = "city_id")
    private String cityId;

    /** 区/县代码 */
    @Column(name = "county_id")
    private String countyId;

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

    /** 消息标题 */
    @Column(name = "msg_title")
    private String msgTitle;

    /** 消息内容 */
    @Column(name = "content")
    private String content;

    /** 阅读标志 */
    @Column(name = "read_flag")
    private String readFlag;

    /** 阅读时间 */
    @Column(name = "read_time")
    private LocalDateTime readTime;

    /** 删除标志 */
    @Column(name = "remove_flag")
    private String removeFlag;

    /** 删除时间 */
    @Column(name = "remove_time")
    private LocalDateTime removeTime;

    /** 删除人ID */
    @Column(name = "remove_user_id")
    private String removeUserId;

    /** 删除人昵称 */
    @Column(name = "remove_nick_name")
    private String removeNickName;

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

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCountyId(String countyId) {
                this.countyId = countyId;
            }

            public String getCountyId() {
                return countyId;
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

            public void setMsgTitle(String msgTitle) {
                this.msgTitle = msgTitle;
            }

            public String getMsgTitle() {
                return msgTitle;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getContent() {
                return content;
            }

            public void setReadFlag(String readFlag) {
                this.readFlag = readFlag;
            }

            public String getReadFlag() {
                return readFlag;
            }

            public void setReadTime(LocalDateTime readTime) {
                this.readTime = readTime;
            }

            public LocalDateTime getReadTime() {
                return readTime;
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

            public void setRemoveNickName(String removeNickName) {
                this.removeNickName = removeNickName;
            }

            public String getRemoveNickName() {
                return removeNickName;
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
                    .append("cityId", getCityId())
                    .append("countyId", getCountyId())
                    .append("deptId", getDeptId())
                    .append("deptTitle", getDeptTitle())
                    .append("deptLevel", getDeptLevel())
                    .append("deptParentId", getDeptParentId())
                    .append("hostIp", getHostIp())
                    .append("hostAddress", getHostAddress())
                    .append("hostOs", getHostOs())
                    .append("hostBrowser", getHostBrowser())
                    .append("hostUserAgent", getHostUserAgent())
                    .append("msgTitle", getMsgTitle())
                    .append("content", getContent())
                    .append("readFlag", getReadFlag())
                    .append("readTime", getReadTime())
                    .append("removeFlag", getRemoveFlag())
                    .append("removeTime", getRemoveTime())
                    .append("removeUserId", getRemoveUserId())
                    .append("removeNickName", getRemoveNickName())
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
