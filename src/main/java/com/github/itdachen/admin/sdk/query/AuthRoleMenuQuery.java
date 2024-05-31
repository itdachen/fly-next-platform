package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 人员身份菜单 查询参数
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
public class AuthRoleMenuQuery extends BizQuery implements Serializable {
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
     * 人员身份ID
     */
    private String roleId;

    /**
     * 菜单ID/资源ID
     */
    private String meniId;


    public AuthRoleMenuQuery() {
    }

    public AuthRoleMenuQuery(int page, int limit, String tenantId, String appId, String roleId, String meniId) {
        super(page, limit);
        this.tenantId = tenantId;
        this.appId = appId;
        this.roleId = roleId;
        this.meniId = meniId;
    }

    public static AuthRoleMenuQueryBuilder builder() {
        return new AuthRoleMenuQueryBuilder();
    }

    public static class AuthRoleMenuQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String appId;
        private String roleId;
        private String meniId;

        public AuthRoleMenuQueryBuilder() {
        }

        public AuthRoleMenuQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AuthRoleMenuQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public AuthRoleMenuQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 应用ID */
        public AuthRoleMenuQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 人员身份ID */
        public AuthRoleMenuQueryBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        /* 菜单ID/资源ID */
        public AuthRoleMenuQueryBuilder meniId(String meniId) {
            this.meniId = meniId;
            return this;
        }

        public AuthRoleMenuQuery build() {
            return new AuthRoleMenuQuery(page, limit, tenantId, appId, roleId, meniId);
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

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
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
                .append("roleId", getRoleId())
                .append("meniId", getMeniId())
                .toString();
    }

}
