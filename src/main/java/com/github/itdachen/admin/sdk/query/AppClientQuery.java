package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 应用管理 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
public class AppClientQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 应用标识码
     */
    private String appCode;

    /**
     * 应用类型
     */
    private String appType;

    /**
     * 应用名称
     */
    private String appTitle;

    /**
     * 是否启用1-是;0-否
     */
    private String status;

    /**
     * 是否可删除
     */
    private String canDel;


    public AppClientQuery() {
    }

    public AppClientQuery(int page, int limit, String appCode, String appType, String appTitle, String status, String canDel) {
        super(page, limit);
        this.appCode = appCode;
        this.appType = appType;
        this.appTitle = appTitle;
        this.status = status;
        this.canDel = canDel;
    }

    public static AppClientQueryBuilder builder() {
        return new AppClientQueryBuilder();
    }

    public static class AppClientQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String appCode;
        private String appType;
        private String appTitle;
        private String status;
        private String canDel;

        public AppClientQueryBuilder() {
        }

        public AppClientQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AppClientQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 应用标识码 */
        public AppClientQueryBuilder appCode(String appCode) {
            this.appCode = appCode;
            return this;
        }

        /* 应用类型 */
        public AppClientQueryBuilder appType(String appType) {
            this.appType = appType;
            return this;
        }

        /* 应用名称 */
        public AppClientQueryBuilder appTitle(String appTitle) {
            this.appTitle = appTitle;
            return this;
        }

        /* 是否启用1-是;0-否 */
        public AppClientQueryBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 是否可删除 */
        public AppClientQueryBuilder canDel(String canDel) {
            this.canDel = canDel;
            return this;
        }

        public AppClientQuery build() {
            return new AppClientQuery(page, limit, appCode, appType, appTitle, status, canDel);
        }

    }


    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCanDel(String canDel) {
        this.canDel = canDel;
    }

    public String getCanDel() {
        return canDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("appCode", getAppCode())
                .append("appType", getAppType())
                .append("appTitle", getAppTitle())
                .append("status", getStatus())
                .append("canDel", getCanDel())
                .toString();
    }

}
