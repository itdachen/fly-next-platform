package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 角色 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 主键id */
        private String id;


        /** 部门id */
        private String deptId;


        /** 角色名称 */
        private String title;


        /** 描述 */
        private String remarks;


        /** 客户端 */
        private String clientId;


    public RoleInfoDto() {}

    public RoleInfoDto(String id, String deptId, String title, String remarks, String clientId) {
            this.id = id;
            this.deptId = deptId;
            this.title = title;
            this.remarks = remarks;
            this.clientId = clientId;
    }

    public static RoleInfoDtoBuilder builder() {
        return new RoleInfoDtoBuilder();
    }

    public static class RoleInfoDtoBuilder {
            private String id;
            private String deptId;
            private String title;
            private String remarks;
            private String clientId;

        public RoleInfoDtoBuilder() {}

            /* 主键id */
            public RoleInfoDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 部门id */
            public RoleInfoDtoBuilder deptId(String deptId) {
                this.deptId = deptId;
                return this;
            }
            /* 角色名称 */
            public RoleInfoDtoBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 描述 */
            public RoleInfoDtoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }
            /* 客户端 */
            public RoleInfoDtoBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }

        public RoleInfoDto build() {
            return new RoleInfoDto(id, deptId, title, remarks, clientId);
        }

    }



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }
            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDeptId() {
                return deptId;
            }
            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }
            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
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
                    .append("deptId", getDeptId())
                    .append("title", getTitle())
                    .append("remarks", getRemarks())
                    .append("clientId", getClientId())
                .toString();
    }

}
