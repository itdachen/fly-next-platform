package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 职工身份 查询参数
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
public class WorkerIdentityQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

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


    public WorkerIdentityQuery() {
    }

    public WorkerIdentityQuery(int page, int limit, String tenantId, String workerId, String title, String deptId, String status, String isPrimary) {
        super(page, limit);
        this.tenantId = tenantId;
        this.workerId = workerId;
        this.title = title;
        this.deptId = deptId;
        this.status = status;
        this.isPrimary = isPrimary;
    }

    public static WorkerIdentityQueryBuilder builder() {
        return new WorkerIdentityQueryBuilder();
    }

    public static class WorkerIdentityQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String workerId;
        private String title;
        private String deptId;
        private String status;
        private String isPrimary;

        public WorkerIdentityQueryBuilder() {
        }

        public WorkerIdentityQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public WorkerIdentityQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户标识 */
        public WorkerIdentityQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 职工ID */
        public WorkerIdentityQueryBuilder workerId(String workerId) {
            this.workerId = workerId;
            return this;
        }

        /* 身份名称 */
        public WorkerIdentityQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 部门ID */
        public WorkerIdentityQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 是否有效: 1-有效;0-无效 */
        public WorkerIdentityQueryBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 是否主身份标识(1-是,0-不是) */
        public WorkerIdentityQueryBuilder isPrimary(String isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public WorkerIdentityQuery build() {
            return new WorkerIdentityQuery(page, limit, tenantId, workerId, title, deptId, status, isPrimary);
        }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("workerId", getWorkerId())
                .append("title", getTitle())
                .append("deptId", getDeptId())
                .append("status", getStatus())
                .append("isPrimary", getIsPrimary())
                .toString();
    }

}
