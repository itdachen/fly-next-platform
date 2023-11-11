package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 权限下发 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class PermsAuthDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;


    /**
     * 用户id
     */
    private String userId;


    /**
     * 菜单id
     */
    private String menuId;


    /**
     * 客户端
     */
    private String clientId;


    public PermsAuthDto() {
    }

    public PermsAuthDto(String id, String userId, String menuId, String clientId) {
        this.id = id;
        this.userId = userId;
        this.menuId = menuId;
        this.clientId = clientId;
    }

    public static PermsAuthDtoBuilder builder() {
        return new PermsAuthDtoBuilder();
    }

    public static class PermsAuthDtoBuilder {
        private String id;
        private String userId;
        private String menuId;
        private String clientId;

        public PermsAuthDtoBuilder() {
        }

        /* 主键id */
        public PermsAuthDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 用户id */
        public PermsAuthDtoBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 菜单id */
        public PermsAuthDtoBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 客户端 */
        public PermsAuthDtoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public PermsAuthDto build() {
            return new PermsAuthDto(id, userId, menuId, clientId);
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
