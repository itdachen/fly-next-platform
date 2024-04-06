package com.github.itdachen.admin_v1.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 菜单角色 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleMenuDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 数据唯一标识
     */
    private String id;


    /**
     * 用户id
     */
    private String roleId;


    /**
     * 菜单id
     */
    private String menuId;


    /**
     * 客户端
     */
    private String clientId;


    public RoleMenuDto() {
    }

    public RoleMenuDto(String id, String roleId, String menuId, String clientId) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
        this.clientId = clientId;
    }

    public static RoleMenuDtoBuilder builder() {
        return new RoleMenuDtoBuilder();
    }

    public static class RoleMenuDtoBuilder {
        private String id;
        private String roleId;
        private String menuId;
        private String clientId;

        public RoleMenuDtoBuilder() {
        }

        /* 数据唯一标识 */
        public RoleMenuDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 用户id */
        public RoleMenuDtoBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        /* 菜单id */
        public RoleMenuDtoBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 客户端 */
        public RoleMenuDtoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public RoleMenuDto build() {
            return new RoleMenuDto(id, roleId, menuId, clientId);
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("roleId", getRoleId())
                .append("menuId", getMenuId())
                .append("clientId", getClientId())
                .toString();
    }

}
