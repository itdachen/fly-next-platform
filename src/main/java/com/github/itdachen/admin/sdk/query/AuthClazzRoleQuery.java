package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 身份岗位管理表 查询参数
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:14
 */
public class AuthClazzRoleQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 岗位ID
     */
    private String clazzId;

    /**
     * 身份ID
     */
    private String roleId;


    public AuthClazzRoleQuery() {
    }

    public AuthClazzRoleQuery(int page, int limit, String tenantId, String appId, String clazzId, String roleId) {
        super(page, limit);
        this.tenantId = tenantId;
        this.appId = appId;
        this.clazzId = clazzId;
        this.roleId = roleId;
    }

    public static AuthClazzRoleQueryBuilder builder() {
        return new AuthClazzRoleQueryBuilder();
    }

    public static class AuthClazzRoleQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String appId;
        private String clazzId;
        private String roleId;

        public AuthClazzRoleQueryBuilder() {
        }

        public AuthClazzRoleQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AuthClazzRoleQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public AuthClazzRoleQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 应用ID */
        public AuthClazzRoleQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 岗位ID */
        public AuthClazzRoleQueryBuilder clazzId(String clazzId) {
            this.clazzId = clazzId;
            return this;
        }

        /* 身份ID */
        public AuthClazzRoleQueryBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public AuthClazzRoleQuery build() {
            return new AuthClazzRoleQuery(page, limit, tenantId, appId, clazzId, roleId);
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

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("clazzId", getClazzId())
                .append("roleId", getRoleId())
                .toString();
    }

}
