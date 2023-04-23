package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 角色 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String title;

    /**
     * 客户端
     */
    private String clientId;


    public RoleInfoQuery() {
    }

    public RoleInfoQuery(int page, int limit, String deptId, String roleCode, String title, String clientId) {
        super(page, limit);
        this.deptId = deptId;
        this.roleCode = roleCode;
        this.title = title;
        this.clientId = clientId;
    }

    public static RoleInfoQueryBuilder builder() {
        return new RoleInfoQueryBuilder();
    }

    public static class RoleInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String deptId;
        private String roleCode;
        private String title;
        private String clientId;

        public RoleInfoQueryBuilder() {
        }

        public RoleInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public RoleInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 部门id */
        public RoleInfoQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 角色编码 */
        public RoleInfoQueryBuilder roleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        /* 角色名称 */
        public RoleInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 客户端 */
        public RoleInfoQueryBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public RoleInfoQuery build() {
            return new RoleInfoQuery(page, limit, deptId, roleCode, title, clientId);
        }

    }


    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("deptId", getDeptId())
                .append("roleCode", getRoleCode())
                .append("title", getTitle())
                .append("clientId", getClientId())
                .toString();
    }

}
