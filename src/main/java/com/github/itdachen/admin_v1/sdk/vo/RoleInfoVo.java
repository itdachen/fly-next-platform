package com.github.itdachen.admin_v1.sdk.vo;

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

    /**
     * 主键id
     */
    private String id;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String title;

    /**
     * 客户端
     */
    private String clientId;

    /**
     * 描述
     */
    private String remarks;


    public RoleInfoVo() {
    }

    public RoleInfoVo(String id, String deptId, String roleCode, String title, String clientId, String remarks) {
        this.id = id;
        this.deptId = deptId;
        this.roleCode = roleCode;
        this.title = title;
        this.clientId = clientId;
        this.remarks = remarks;
    }

    public static RoleInfoVoBuilder builder() {
        return new RoleInfoVoBuilder();
    }

    public static class RoleInfoVoBuilder {
        private String id;
        private String deptId;
        private String roleCode;
        private String title;
        private String clientId;
        private String remarks;

        public RoleInfoVoBuilder() {
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

        /* 角色编码 */
        public RoleInfoVoBuilder roleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        /* 角色名称 */
        public RoleInfoVoBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 客户端 */
        public RoleInfoVoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /* 描述 */
        public RoleInfoVoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public RoleInfoVo build() {
            return new RoleInfoVo(id,
                    deptId,
                    roleCode,
                    title,
                    clientId,
                    remarks
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

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("deptId", getDeptId())
                .append("roleCode", getRoleCode())
                .append("title", getTitle())
                .append("clientId", getClientId())
                .append("remarks", getRemarks())
                .toString();
    }

}
