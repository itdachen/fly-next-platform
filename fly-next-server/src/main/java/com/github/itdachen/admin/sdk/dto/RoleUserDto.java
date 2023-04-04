package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 用户角色 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleUserDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 数据唯一标识 */
        private String id;


        /** 用户id */
        private String userId;


        /** 角色id */
        private String roleId;


    public RoleUserDto() {}

    public RoleUserDto(String id, String userId, String roleId) {
            this.id = id;
            this.userId = userId;
            this.roleId = roleId;
    }

    public static RoleUserDtoBuilder builder() {
        return new RoleUserDtoBuilder();
    }

    public static class RoleUserDtoBuilder {
            private String id;
            private String userId;
            private String roleId;

        public RoleUserDtoBuilder() {}

            /* 数据唯一标识 */
            public RoleUserDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 用户id */
            public RoleUserDtoBuilder userId(String userId) {
                this.userId = userId;
                return this;
            }
            /* 角色id */
            public RoleUserDtoBuilder roleId(String roleId) {
                this.roleId = roleId;
                return this;
            }

        public RoleUserDto build() {
            return new RoleUserDto(id, userId, roleId);
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("userId", getUserId())
                    .append("roleId", getRoleId())
                .toString();
    }

}
