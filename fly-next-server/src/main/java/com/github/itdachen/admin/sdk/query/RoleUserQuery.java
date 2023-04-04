package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 用户角色 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleUserQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 用户id */
            private String userId;

            /** 角色id */
            private String roleId;


    public RoleUserQuery() {
    }

    public RoleUserQuery(int page, int limit, String userId, String roleId) {
        super(page, limit);
            this.userId = userId;
            this.roleId = roleId;
    }

    public static RoleUserQueryBuilder builder() {
        return new RoleUserQueryBuilder();
    }

    public static class RoleUserQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String userId;
            private String roleId;

        public RoleUserQueryBuilder() {
        }

        public RoleUserQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public RoleUserQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 用户id */
            public RoleUserQueryBuilder userId(String userId) {
                this.userId = userId;
                return this;
            }
            /* 角色id */
            public RoleUserQueryBuilder roleId(String roleId) {
                this.roleId = roleId;
                return this;
            }

        public RoleUserQuery build() {
            return new RoleUserQuery(page, limit, userId, roleId);
        }

    }




        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
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
                    .append("userId", getUserId())
                    .append("roleId", getRoleId())
                .toString();
    }

}
