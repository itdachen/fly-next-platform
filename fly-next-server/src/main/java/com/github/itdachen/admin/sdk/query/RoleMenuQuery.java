package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 菜单角色 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleMenuQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 用户id */
            private String roleId;

            /** 菜单id */
            private String menuId;


    public RoleMenuQuery() {
    }

    public RoleMenuQuery(int page, int limit, String roleId, String menuId) {
        super(page, limit);
            this.roleId = roleId;
            this.menuId = menuId;
    }

    public static RoleMenuQueryBuilder builder() {
        return new RoleMenuQueryBuilder();
    }

    public static class RoleMenuQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String roleId;
            private String menuId;

        public RoleMenuQueryBuilder() {
        }

        public RoleMenuQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public RoleMenuQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 用户id */
            public RoleMenuQueryBuilder roleId(String roleId) {
                this.roleId = roleId;
                return this;
            }
            /* 菜单id */
            public RoleMenuQueryBuilder menuId(String menuId) {
                this.menuId = menuId;
                return this;
            }

        public RoleMenuQuery build() {
            return new RoleMenuQuery(page, limit, roleId, menuId);
        }

    }




        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setMenuId(String menuId) {
            this.menuId = menuId;
        }

        public String getMenuId() {
            return menuId;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("roleId", getRoleId())
                    .append("menuId", getMenuId())
                .toString();
    }

}
