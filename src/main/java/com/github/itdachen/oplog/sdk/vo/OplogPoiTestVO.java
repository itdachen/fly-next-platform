package com.github.itdachen.oplog.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 导入导出测试 VO
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
public class OplogPoiTestVO implements Serializable {
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
     * 日志标题: 用户管理, 菜单管理等
     */
    private String title;

    /**
     * 日志类型: button, uri
     */
    private String type;

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
    private String userAgent;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 服务端处理耗时
     */
    private String executeTime;

    /**
     * 删除标记:Y-未删除;N-已删除
     */
    private String delFlag;

    /**
     * 年份
     */
    private String yearly;

    /**
     * 月份
     */
    private String monthly;

    /**
     * 创建时间
     */
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

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
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
                .append("createTime", getCreateTime())
                .toString();
    }

}
