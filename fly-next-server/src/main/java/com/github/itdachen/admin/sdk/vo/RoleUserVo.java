package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 用户角色 Vo
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleUserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据唯一标识
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 客户端
     */
    private String clientId;


    public RoleUserVo() {
    }

    public RoleUserVo(String id, String userId, String roleId, String clientId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.clientId = clientId;
    }

    public static RoleUserVoBuilder builder() {
        return new RoleUserVoBuilder();
    }

    public static class RoleUserVoBuilder {
        private String id;
        private String userId;
        private String roleId;
        private String clientId;

        public RoleUserVoBuilder() {
        }

        /* 数据唯一标识 */
        public RoleUserVoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 用户id */
        public RoleUserVoBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 角色id */
        public RoleUserVoBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        /* 客户端 */
        public RoleUserVoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public RoleUserVo build() {
            return new RoleUserVo(id,
                    userId,
                    roleId,
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
                .append("roleId", getRoleId())
                .append("clientId", getClientId())
                .toString();
    }

}
