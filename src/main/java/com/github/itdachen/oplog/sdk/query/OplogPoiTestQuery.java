package com.github.itdachen.oplog.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 导入导出测试 查询参数
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
public class OplogPoiTestQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 服务端处理耗时
     */
    private String executeTime;

    /**
     * 年份
     */
    private String yearly;

    /**
     * 月份
     */
    private String monthly;


    public OplogPoiTestQuery() {
    }

    public OplogPoiTestQuery(int page, int limit, String tenantId, String tenantTitle, String title, String type, String hostIp, String hostAddress, String hostOs, String hostBrowser, String userAgent, String executeTime, String yearly, String monthly) {
        super(page, limit);
        this.tenantId = tenantId;
        this.tenantTitle = tenantTitle;
        this.title = title;
        this.type = type;
        this.hostIp = hostIp;
        this.hostAddress = hostAddress;
        this.hostOs = hostOs;
        this.hostBrowser = hostBrowser;
        this.userAgent = userAgent;
        this.executeTime = executeTime;
        this.yearly = yearly;
        this.monthly = monthly;
    }

    public static OplogPoiTestQueryBuilder builder() {
        return new OplogPoiTestQueryBuilder();
    }

    public static class OplogPoiTestQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String tenantTitle;
        private String title;
        private String type;
        private String hostIp;
        private String hostAddress;
        private String hostOs;
        private String hostBrowser;
        private String userAgent;
        private String executeTime;
        private String yearly;
        private String monthly;

        public OplogPoiTestQueryBuilder() {
        }

        public OplogPoiTestQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public OplogPoiTestQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID/公司ID */
        public OplogPoiTestQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 租户名称/公司名称 */
        public OplogPoiTestQueryBuilder tenantTitle(String tenantTitle) {
            this.tenantTitle = tenantTitle;
            return this;
        }

        /* 日志标题: 用户管理, 菜单管理等 */
        public OplogPoiTestQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 日志类型: button, uri */
        public OplogPoiTestQueryBuilder type(String type) {
            this.type = type;
            return this;
        }

        /* 操作IP地址 */
        public OplogPoiTestQueryBuilder hostIp(String hostIp) {
            this.hostIp = hostIp;
            return this;
        }

        /* 操作地址 */
        public OplogPoiTestQueryBuilder hostAddress(String hostAddress) {
            this.hostAddress = hostAddress;
            return this;
        }

        /* 操作系统 */
        public OplogPoiTestQueryBuilder hostOs(String hostOs) {
            this.hostOs = hostOs;
            return this;
        }

        /* 操作浏览器 */
        public OplogPoiTestQueryBuilder hostBrowser(String hostBrowser) {
            this.hostBrowser = hostBrowser;
            return this;
        }

        /* 用户代理 */
        public OplogPoiTestQueryBuilder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        /* 服务端处理耗时 */
        public OplogPoiTestQueryBuilder executeTime(String executeTime) {
            this.executeTime = executeTime;
            return this;
        }

        /* 年份 */
        public OplogPoiTestQueryBuilder yearly(String yearly) {
            this.yearly = yearly;
            return this;
        }

        /* 月份 */
        public OplogPoiTestQueryBuilder monthly(String monthly) {
            this.monthly = monthly;
            return this;
        }

        public OplogPoiTestQuery build() {
            return new OplogPoiTestQuery(page, limit, tenantId, tenantTitle, title, type, hostIp, hostAddress, hostOs, hostBrowser, userAgent, executeTime, yearly, monthly);
        }

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
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("tenantTitle", getTenantTitle())
                .append("title", getTitle())
                .append("type", getType())
                .append("hostIp", getHostIp())
                .append("hostAddress", getHostAddress())
                .append("hostOs", getHostOs())
                .append("hostBrowser", getHostBrowser())
                .append("userAgent", getUserAgent())
                .append("executeTime", getExecuteTime())
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .toString();
    }

}
