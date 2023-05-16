package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 职工身份 请求参数数据
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
public class WorkerIdentityDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键唯一标识(身份ID)
     */
    private String id;

    /**
     * 租户标识
     */
    private String tenantId;


    /**
     * 职工ID
     */
    private String workerId;


    /**
     * 身份名称
     */
    private String title;


    /**
     * 部门ID
     */
    private String deptId;


    /**
     * 是否有效: 1-有效;0-无效
     */
    private String status;


    /**
     * 是否主身份标识(1-是,0-不是)
     */
    private String isPrimary;


    /**
     * 备注
     */
    private String remarks;


    public WorkerIdentityDto() {
    }

    public WorkerIdentityDto(String id, String tenantId, String workerId, String title, String deptId, String status, String isPrimary, String remarks) {
        this.id = id;
        this.tenantId = tenantId;
        this.workerId = workerId;
        this.title = title;
        this.deptId = deptId;
        this.status = status;
        this.isPrimary = isPrimary;
        this.remarks = remarks;
    }

    public static WorkerIdentityDtoBuilder builder() {
        return new WorkerIdentityDtoBuilder();
    }

    public static class WorkerIdentityDtoBuilder {
        private String id;
        private String tenantId;
        private String workerId;
        private String title;
        private String deptId;
        private String status;
        private String isPrimary;
        private String remarks;

        public WorkerIdentityDtoBuilder() {
        }

        /* 主键唯一标识(身份ID) */
        public WorkerIdentityDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 租户标识 */
        public WorkerIdentityDtoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 职工ID */
        public WorkerIdentityDtoBuilder workerId(String workerId) {
            this.workerId = workerId;
            return this;
        }

        /* 身份名称 */
        public WorkerIdentityDtoBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 部门ID */
        public WorkerIdentityDtoBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 是否有效: 1-有效;0-无效 */
        public WorkerIdentityDtoBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 是否主身份标识(1-是,0-不是) */
        public WorkerIdentityDtoBuilder isPrimary(String isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        /* 备注 */
        public WorkerIdentityDtoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public WorkerIdentityDto build() {
            return new WorkerIdentityDto(id, tenantId, workerId, title, deptId, status, isPrimary, remarks);
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getIsPrimary() {
        return isPrimary;
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
                .append("tenantId", getTenantId())
                .append("workerId", getWorkerId())
                .append("title", getTitle())
                .append("deptId", getDeptId())
                .append("status", getStatus())
                .append("isPrimary", getIsPrimary())
                .append("remarks", getRemarks())
                .toString();
    }

}
