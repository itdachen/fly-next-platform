package com.github.itdachen.msg.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 消息池 DTO
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgPoolDTO implements Serializable {
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
    @NotBlank(message = "租户名称/公司名称不能为空")
    private String tenantTitle;

    /**
     * 平台ID
     */
    @NotBlank(message = "平台ID不能为空")
    private String platId;

    /**
     * 平台名称
     */
    @NotBlank(message = "平台名称不能为空")
    private String platTitle;

    /**
     * 应用ID
     */
    @NotBlank(message = "应用ID不能为空")
    private String appId;

    /**
     * 应用名称
     */
    @NotBlank(message = "应用名称不能为空")
    private String appTitle;

    /**
     * 应用版本号
     */
    @NotBlank(message = "应用版本号不能为空")
    private String appVersion;

    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空")
    private String userId;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 身份ID
     */
    @NotBlank(message = "身份ID不能为空")
    private String roleId;

    /**
     * 身份名称
     */
    @NotBlank(message = "身份名称不能为空")
    private String roleName;

    /**
     * 省代码
     */
    @NotBlank(message = "省代码不能为空")
    private String provId;

    /**
     * 省名称
     */
    @NotBlank(message = "省名称不能为空")
    private String provTitle;

    /**
     * 市/州代码
     */
    @NotBlank(message = "市/州代码不能为空")
    private String cityId;

    /**
     * 市/州名称
     */
    @NotBlank(message = "市/州名称不能为空")
    private String cityTitle;

    /**
     * 区/县代码
     */
    @NotBlank(message = "区/县代码不能为空")
    private String countyId;

    /**
     * 区县名称
     */
    @NotBlank(message = "区县名称不能为空")
    private String countyTitle;

    /**
     * 部门ID
     */
    @NotBlank(message = "部门ID不能为空")
    private String deptId;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    private String deptTitle;

    /**
     * 部门等级
     */
    @NotBlank(message = "部门等级不能为空")
    private String deptLevel;

    /**
     * 上级部门代码
     */
    @NotBlank(message = "上级部门代码不能为空")
    private String deptParentId;

    /**
     * 操作IP地址
     */
    @NotBlank(message = "操作IP地址不能为空")
    private String hostIp;

    /**
     * 操作地址
     */
    @NotBlank(message = "操作地址不能为空")
    private String hostAddress;

    /**
     * 操作系统
     */
    @NotBlank(message = "操作系统不能为空")
    private String hostOs;

    /**
     * 操作浏览器
     */
    @NotBlank(message = "操作浏览器不能为空")
    private String hostBrowser;

    /**
     * 用户代理
     */
    @NotBlank(message = "用户代理不能为空")
    private String hostUserAgent;

    /**
     * 消息类型
     */
    @NotBlank(message = "消息类型不能为空")
    private String msgType;

    /**
     * 消息类型名称
     */
    @NotBlank(message = "消息类型名称不能为空")
    private String msgTypeTitle;

    /**
     * 消息分类
     */
    @NotBlank(message = "消息分类不能为空")
    private String clazzType;

    /**
     * 消息分类名称
     */
    @NotBlank(message = "消息分类名称不能为空")
    private String clazzTitle;

    /**
     * 消息标题
     */
    @NotBlank(message = "消息标题不能为空")
    private String title;

    /**
     * 消息内容
     */
    @NotBlank(message = "消息内容不能为空")
    private String content;

    /**
     * 阅读标志
     */
    @NotBlank(message = "阅读标志不能为空")
    private String readFlag;

    /**
     * 阅读时间
     */
    @NotNull(message = "阅读时间不能为空")
    private LocalDateTime readTime;

    /**
     * 删除时间
     */
    @NotNull(message = "删除时间不能为空")
    private LocalDateTime removeTime;

    /**
     * 删除人ID
     */
    @NotBlank(message = "删除人ID不能为空")
    private String removeUserId;

    /**
     * 删除人昵称
     */
    @NotBlank(message = "删除人昵称不能为空")
    private String removeNickName;

    /**
     * 年份
     */
    @NotBlank(message = "年份不能为空")
    private String yearly;

    /**
     * 月份
     */
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

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgTypeTitle(String msgTypeTitle) {
        this.msgTypeTitle = msgTypeTitle;
    }

    public String getMsgTypeTitle() {
        return msgTypeTitle;
    }

    public void setClazzType(String clazzType) {
        this.clazzType = clazzType;
    }

    public String getClazzType() {
        return clazzType;
    }

    public void setClazzTitle(String clazzTitle) {
        this.clazzTitle = clazzTitle;
    }

    public String getClazzTitle() {
        return clazzTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
                .append("hostIp", getHostIp())
                .append("hostAddress", getHostAddress())
                .append("hostOs", getHostOs())
                .append("hostBrowser", getHostBrowser())
                .append("hostUserAgent", getHostUserAgent())
                .append("msgType", getMsgType())
                .append("msgTypeTitle", getMsgTypeTitle())
                .append("clazzType", getClazzType())
                .append("clazzTitle", getClazzTitle())
                .append("title", getTitle())
                .append("content", getContent())
                .append("readFlag", getReadFlag())
                .append("readTime", getReadTime())
                .append("removeTime", getRemoveTime())
                .append("removeUserId", getRemoveUserId())
                .append("removeNickName", getRemoveNickName())
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .toString();
    }

}
