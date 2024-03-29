package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 菜单角色 Vo
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleMenuVo implements Serializable {
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


    public RoleMenuVo() {
    }

    public RoleMenuVo(String id, String roleId, String menuId, String clientId) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
        this.clientId = clientId;
    }

    public static RoleMenuVoBuilder builder() {
        return new RoleMenuVoBuilder();
    }

    public static class RoleMenuVoBuilder {
        private String id;
        private String roleId;
        private String menuId;
        private String clientId;

        public RoleMenuVoBuilder() {
        }

        /* 数据唯一标识 */
        public RoleMenuVoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 用户id */
        public RoleMenuVoBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        /* 菜单id */
        public RoleMenuVoBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 客户端 */
        public RoleMenuVoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public RoleMenuVo build() {
            return new RoleMenuVo(id,
                    roleId,
                    menuId,
                    clientId
            );
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
