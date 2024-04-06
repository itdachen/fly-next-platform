package com.github.itdachen.admin_v1.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 岗位信息
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
@Table(name = "sys_position_info")
public class PositionInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户标识 */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 岗位名称 */
    @Column(name = "title")
    private String title;

    /** 岗位标识 */
    @Column(name = "position_code")
    private String positionCode;

    /** 所属部门 */
    @Column(name = "dept_id")
    private String deptId;

    /** 状态 */
    @Column(name = "status")
    private String status;

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


public PositionInfo(){}


public PositionInfo(    String id,     String tenantId,     String title,     String positionCode,     String deptId,     String status,     String remarks,     LocalDateTime createTime,     String createUserId,     String createUser,     LocalDateTime updateTime,     String updateUserId,     String updateUser){
            this.id = id;
            this.tenantId = tenantId;
            this.title = title;
            this.positionCode = positionCode;
            this.deptId = deptId;
            this.status = status;
            this.remarks = remarks;
            this.createTime = createTime;
            this.createUserId = createUserId;
            this.createUser = createUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
            this.updateUser = updateUser;
}

public static PositionInfoBuilder builder(){
        return new PositionInfoBuilder();
        }

public static class PositionInfoBuilder {
        private String id;
        private String tenantId;
        private String title;
        private String positionCode;
        private String deptId;
        private String status;
        private String remarks;
        private LocalDateTime createTime;
        private String createUserId;
        private String createUser;
        private LocalDateTime updateTime;
        private String updateUserId;
        private String updateUser;

    public PositionInfoBuilder() {
    }

        /* 主键唯一标识 */
        public PositionInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 租户标识 */
        public PositionInfoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 岗位名称 */
        public PositionInfoBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 岗位标识 */
        public PositionInfoBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }
        /* 所属部门 */
        public PositionInfoBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }
        /* 状态 */
        public PositionInfoBuilder status(String status) {
            this.status = status;
            return this;
        }
        /* 备注 */
        public PositionInfoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 创建时间 */
        public PositionInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人ID */
        public PositionInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建人 */
        public PositionInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 更新时间 */
        public PositionInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人ID */
        public PositionInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }
        /* 更新人 */
        public PositionInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

    public PositionInfo build() {
        return new PositionInfo(            id, 
            tenantId, 
            title, 
            positionCode, 
            deptId, 
            status, 
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

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }

            public void setPositionCode(String positionCode) {
                this.positionCode = positionCode;
            }

            public String getPositionCode() {
                return positionCode;
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
                    .append("title", getTitle())
                    .append("positionCode", getPositionCode())
                    .append("deptId", getDeptId())
                    .append("status", getStatus())
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
