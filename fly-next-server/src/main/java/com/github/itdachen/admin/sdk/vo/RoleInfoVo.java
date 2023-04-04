package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 角色 Vo
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class RoleInfoVo implements Serializable {
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


    public RoleInfoVo() {
    }

    public RoleInfoVo(String id, String deptId, String title, String remarks, String clientId) {
            this.id = id;
            this.deptId = deptId;
            this.title = title;
            this.remarks = remarks;
            this.clientId = clientId;
    }

    public static RoleInfoVoBuilder builder() {
        return new RoleInfoVoBuilder();
    }

    public static class RoleInfoVoBuilder {
            private String id;
            private String deptId;
            private String title;
            private String remarks;
            private String clientId;

        public   RoleInfoVoBuilder() {
        }

            /* 主键id */
            public RoleInfoVoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 部门id */
            public RoleInfoVoBuilder deptId(String deptId) {
                this.deptId = deptId;
                return this;
            }
            /* 角色名称 */
            public RoleInfoVoBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 描述 */
            public RoleInfoVoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }
            /* 客户端 */
            public RoleInfoVoBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }

        public RoleInfoVo build() {
            return new RoleInfoVo(                id, 
                deptId, 
                title, 
                remarks, 
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
