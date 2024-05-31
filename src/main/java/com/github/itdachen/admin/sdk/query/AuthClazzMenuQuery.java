package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 岗位菜单 查询参数
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public class AuthClazzMenuQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 租户ID */
    private String tenantId;

    /** 应用ID */
    private String appId;

    /** 岗位ID */
    private String clazzId;

    /** 菜单ID/资源ID */
    private String meniId;



    public AuthClazzMenuQuery() {
    }

    public AuthClazzMenuQuery(int page, int limit, String tenantId, String appId, String clazzId, String meniId) {
        super(page, limit);
        this.tenantId = tenantId;
        this.appId = appId;
        this.clazzId = clazzId;
        this.meniId = meniId;
    }

    public static AuthClazzMenuQueryBuilder builder() {
        return new AuthClazzMenuQueryBuilder();
    }

    public static class AuthClazzMenuQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String appId;
        private String clazzId;
        private String meniId;

        public AuthClazzMenuQueryBuilder() {
        }

        public AuthClazzMenuQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AuthClazzMenuQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public AuthClazzMenuQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 应用ID */
        public AuthClazzMenuQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }
        /* 岗位ID */
        public AuthClazzMenuQueryBuilder clazzId(String clazzId) {
            this.clazzId = clazzId;
            return this;
        }
        /* 菜单ID/资源ID */
        public AuthClazzMenuQueryBuilder meniId(String meniId) {
            this.meniId = meniId;
            return this;
        }

        public AuthClazzMenuQuery build() {
            return new AuthClazzMenuQuery(page, limit, tenantId, appId, clazzId, meniId);
        }

    }



    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setMeniId(String meniId) {
        this.meniId = meniId;
    }

    public String getMeniId() {
        return meniId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("clazzId", getClazzId())
                .append("meniId", getMeniId())
                .toString();
    }

}
