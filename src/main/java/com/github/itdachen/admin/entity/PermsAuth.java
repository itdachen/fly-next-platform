package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 权限下发
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Table(name = "sys_perms_auth")
public class PermsAuth implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 菜单id
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 客户端
     */
    @Column(name = "client_id")
    private String clientId;


    public PermsAuth() {
    }


    public PermsAuth(String id, String userId, String menuId, String clientId) {
        this.id = id;
        this.userId = userId;
        this.menuId = menuId;
        this.clientId = clientId;
    }

    public static PermsAuthBuilder builder() {
        return new PermsAuthBuilder();
    }

    public static class PermsAuthBuilder {
        private String id;
        private String userId;
        private String menuId;
        private String clientId;

        public PermsAuthBuilder() {
        }

        /* 主键id */
        public PermsAuthBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 用户id */
        public PermsAuthBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 菜单id */
        public PermsAuthBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 客户端 */
        public PermsAuthBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public PermsAuth build() {
            return new PermsAuth(id, userId, menuId, clientId
            );
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
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
                .append("userId", getUserId())
                .append("menuId", getMenuId())
                .append("clientId", getClientId())
                .toString();
    }

}
