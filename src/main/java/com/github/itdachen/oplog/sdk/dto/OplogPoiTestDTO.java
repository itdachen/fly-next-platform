package com.github.itdachen.oplog.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 导入导出测试 DTO
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
public class OplogPoiTestDTO implements Serializable {
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
     * 日志标题: 用户管理, 菜单管理等
     */
    @NotBlank(message = "日志标题: 用户管理, 菜单管理等不能为空")
    private String title;

    /**
     * 日志类型: button, uri
     */
    @NotBlank(message = "日志类型: button, uri不能为空")
    private String type;

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
    private String userAgent;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 服务端处理耗时
     */
    @NotBlank(message = "服务端处理耗时不能为空")
    private String executeTime;

    /**
     * 删除标记:Y-未删除;N-已删除
     */
    private String delFlag;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
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

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
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
                .append("title", getTitle())
                .append("type", getType())
                .append("hostIp", getHostIp())
                .append("hostAddress", getHostAddress())
                .append("hostOs", getHostOs())
                .append("hostBrowser", getHostBrowser())
                .append("userAgent", getUserAgent())
                .append("remarks", getRemarks())
                .append("executeTime", getExecuteTime())
                .append("delFlag", getDelFlag())
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .toString();
    }

}
