package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 职工身份
 *
 * @author 王大宸
 * @date 2023-05-17 21:20:37
 */
@Table(name = "sys_worker_identity")
public class WorkerIdentity implements Serializable{
    private static final long serialVersionUID=1L;

    /** 主键唯一标识(身份ID) */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户标识 */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 职工ID */
    @Column(name = "worker_id")
    private String workerId;

    /** 身份名称 */
    @Column(name = "title")
    private String title;

    /** 部门ID */
    @Column(name = "dept_id")
    private String deptId;

    /** 部门名称 */
    @Column(name = "dept_title")
    private String deptTitle;

    /** 是否有效: 1-有效;0-无效 */
    @Column(name = "status")
    private String status;

    /** 是否主身份标识(1-是,0-不是) */
    @Column(name = "is_primary")
    private String isPrimary;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人ID */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人ID */
    @Column(name = "update_user_id")
    private String updateUserId;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;


    public WorkerIdentity(){}


    public WorkerIdentity(    String id,     String tenantId,     String workerId,     String title,     String deptId,     String deptTitle,     String status,     String isPrimary,     String remarks,     LocalDateTime createTime,     String createUserId,     String createUser,     LocalDateTime updateTime,     String updateUserId,     String updateUser){
        this.id = id;
        this.tenantId = tenantId;
        this.workerId = workerId;
        this.title = title;
        this.deptId = deptId;
        this.deptTitle = deptTitle;
        this.status = status;
        this.isPrimary = isPrimary;
        this.remarks = remarks;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.updateUser = updateUser;
    }

    public static WorkerIdentityBuilder builder(){
        return new WorkerIdentityBuilder();
    }

    public static class WorkerIdentityBuilder {
        private String id;
        private String tenantId;
        private String workerId;
        private String title;
        private String deptId;
        private String deptTitle;
        private String status;
        private String isPrimary;
        private String remarks;
        private LocalDateTime createTime;
        private String createUserId;
        private String createUser;
        private LocalDateTime updateTime;
        private String updateUserId;
        private String updateUser;

        public WorkerIdentityBuilder() {
        }

        /* 主键唯一标识(身份ID) */
        public WorkerIdentityBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 租户标识 */
        public WorkerIdentityBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 职工ID */
        public WorkerIdentityBuilder workerId(String workerId) {
            this.workerId = workerId;
            return this;
        }
        /* 身份名称 */
        public WorkerIdentityBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 部门ID */
        public WorkerIdentityBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }
        /* 部门名称 */
        public WorkerIdentityBuilder deptTitle(String deptTitle) {
            this.deptTitle = deptTitle;
            return this;
        }
        /* 是否有效: 1-有效;0-无效 */
        public WorkerIdentityBuilder status(String status) {
            this.status = status;
            return this;
        }
        /* 是否主身份标识(1-是,0-不是) */
        public WorkerIdentityBuilder isPrimary(String isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }
        /* 备注 */
        public WorkerIdentityBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 创建时间 */
        public WorkerIdentityBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人ID */
        public WorkerIdentityBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建人 */
        public WorkerIdentityBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 更新时间 */
        public WorkerIdentityBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人ID */
        public WorkerIdentityBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }
        /* 更新人 */
        public WorkerIdentityBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

        public WorkerIdentity build() {
            return new WorkerIdentity(            id,
                    tenantId,
                    workerId,
                    title,
                    deptId,
                    deptTitle,
                    status,
                    isPrimary,
                    remarks,
                    createTime,
                    createUserId,
                    createUser,
                    updateTime,
                    updateUserId,
                    updateUser
            );
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

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    public String getDeptTitle() {
        return deptTitle;
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

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("workerId", getWorkerId())
                .append("title", getTitle())
                .append("deptId", getDeptId())
                .append("deptTitle", getDeptTitle())
                .append("status", getStatus())
                .append("isPrimary", getIsPrimary())
                .append("remarks", getRemarks())
                .append("createTime", getCreateTime())
                .append("createUserId", getCreateUserId())
                .append("createUser", getCreateUser())
                .append("updateTime", getUpdateTime())
                .append("updateUserId", getUpdateUserId())
                .append("updateUser", getUpdateUser())
                .toString();
    }


}
