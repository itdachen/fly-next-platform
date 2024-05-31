package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 身份信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public class UserRoleInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId = BizContextHandler.getTenantId();

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 身份名称
     */
    private String roleName;

    /**
     * 是否主身份
     */
    private String roleFlag;

    /**
     * 有效标志
     */
    private String validFlag;

    /**
     * 身份部门ID
     */
    private String deptId;


    public UserRoleInfoQuery() {
    }

    public UserRoleInfoQuery(int page, int limit, String tenantId, String userId, String roleName, String roleFlag, String validFlag, String deptId) {
        super(page, limit);
        this.tenantId = tenantId;
        this.userId = userId;
        this.roleName = roleName;
        this.roleFlag = roleFlag;
        this.validFlag = validFlag;
        this.deptId = deptId;
    }

    public static UserRoleInfoQueryBuilder builder() {
        return new UserRoleInfoQueryBuilder();
    }

    public static class UserRoleInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String userId;
        private String roleName;
        private String roleFlag;
        private String validFlag;
        private String deptId;

        public UserRoleInfoQueryBuilder() {
        }

        public UserRoleInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public UserRoleInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public UserRoleInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 用户ID */
        public UserRoleInfoQueryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 身份名称 */
        public UserRoleInfoQueryBuilder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        /* 是否主身份 */
        public UserRoleInfoQueryBuilder roleFlag(String roleFlag) {
            this.roleFlag = roleFlag;
            return this;
        }

        /* 有效标志 */
        public UserRoleInfoQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        /* 身份部门ID */
        public UserRoleInfoQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public UserRoleInfoQuery build() {
            return new UserRoleInfoQuery(page, limit, tenantId, userId, roleName, roleFlag, validFlag, deptId);
        }

    }


    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("userId", getUserId())
                .append("roleName", getRoleName())
                .append("roleFlag", getRoleFlag())
                .append("validFlag", getValidFlag())
                .append("deptId", getDeptId())
                .toString();
    }

}
