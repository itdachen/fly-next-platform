package com.github.itdachen.oplog.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 导入导出测试
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
@Table(name = "ta_fly_oplog_poi_test")
public class OplogPoiTest implements Serializable{
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

    /** 日志标题: 用户管理, 菜单管理等 */
    @Column(name = "title")
    private String title;

    /** 日志类型: button, uri */
    @Column(name = "type")
    private String type;

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
    @Column(name = "user_agent")
    private String userAgent;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 服务端处理耗时 */
    @Column(name = "execute_time")
    private String executeTime;

    /** 删除标记:Y-未删除;N-已删除 */
    @Column(name = "del_flag")
    private String delFlag;

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
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateTime", getUpdateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
