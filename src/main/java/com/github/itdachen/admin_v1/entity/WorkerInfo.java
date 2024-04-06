package com.github.itdachen.admin_v1.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 员工信息
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
@Table(name = "sys_worker_info")
public class WorkerInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户标识 */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 职工编号 */
    @Column(name = "worker_no")
    private String workerNo;

    /** 职工姓名 */
    @Column(name = "worker_name")
    private String workerName;

    /** 性别 */
    @Column(name = "sex")
    private String sex;

    /** 头像 */
    @Column(name = "avatar")
    private String avatar;

    /** 生日 */
    @Column(name = "birthday")
    private String birthday;

    /** 电话号码 */
    @Column(name = "telephone")
    private String telephone;

    /** 电子邮箱 */
    @Column(name = "email")
    private String email;

    /** 状态: 正常;离职;休假 */
    @Column(name = "status")
    private String status;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 入职日期 */
    @Column(name = "entry_day")
    private String entryDay;

    /** 离职日期 */
    @Column(name = "depart_day")
    private String departDay;

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


public WorkerInfo(){}


public WorkerInfo(    String id,     String tenantId,     String workerNo,     String workerName,     String sex,     String avatar,     String birthday,     String telephone,     String email,     String status,     String remarks,     String entryDay,     String departDay,     LocalDateTime createTime,     String createUserId,     String createUser,     LocalDateTime updateTime,     String updateUserId,     String updateUser){
            this.id = id;
            this.tenantId = tenantId;
            this.workerNo = workerNo;
            this.workerName = workerName;
            this.sex = sex;
            this.avatar = avatar;
            this.birthday = birthday;
            this.telephone = telephone;
            this.email = email;
            this.status = status;
            this.remarks = remarks;
            this.entryDay = entryDay;
            this.departDay = departDay;
            this.createTime = createTime;
            this.createUserId = createUserId;
            this.createUser = createUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
            this.updateUser = updateUser;
}

public static WorkerInfoBuilder builder(){
        return new WorkerInfoBuilder();
        }

public static class WorkerInfoBuilder {
        private String id;
        private String tenantId;
        private String workerNo;
        private String workerName;
        private String sex;
        private String avatar;
        private String birthday;
        private String telephone;
        private String email;
        private String status;
        private String remarks;
        private String entryDay;
        private String departDay;
        private LocalDateTime createTime;
        private String createUserId;
        private String createUser;
        private LocalDateTime updateTime;
        private String updateUserId;
        private String updateUser;

    public WorkerInfoBuilder() {
    }

        /* 主键唯一标识 */
        public WorkerInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 租户标识 */
        public WorkerInfoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 职工编号 */
        public WorkerInfoBuilder workerNo(String workerNo) {
            this.workerNo = workerNo;
            return this;
        }
        /* 职工姓名 */
        public WorkerInfoBuilder workerName(String workerName) {
            this.workerName = workerName;
            return this;
        }
        /* 性别 */
        public WorkerInfoBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }
        /* 头像 */
        public WorkerInfoBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }
        /* 生日 */
        public WorkerInfoBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }
        /* 电话号码 */
        public WorkerInfoBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }
        /* 电子邮箱 */
        public WorkerInfoBuilder email(String email) {
            this.email = email;
            return this;
        }
        /* 状态: 正常;离职;休假 */
        public WorkerInfoBuilder status(String status) {
            this.status = status;
            return this;
        }
        /* 备注 */
        public WorkerInfoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 入职日期 */
        public WorkerInfoBuilder entryDay(String entryDay) {
            this.entryDay = entryDay;
            return this;
        }
        /* 离职日期 */
        public WorkerInfoBuilder departDay(String departDay) {
            this.departDay = departDay;
            return this;
        }
        /* 创建时间 */
        public WorkerInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人ID */
        public WorkerInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建人 */
        public WorkerInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 更新时间 */
        public WorkerInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人ID */
        public WorkerInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }
        /* 更新人 */
        public WorkerInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

    public WorkerInfo build() {
        return new WorkerInfo(            id, 
            tenantId, 
            workerNo, 
            workerName, 
            sex, 
            avatar, 
            birthday, 
            telephone, 
            email, 
            status, 
            remarks, 
            entryDay, 
            departDay, 
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

            public void setWorkerNo(String workerNo) {
                this.workerNo = workerNo;
            }

            public String getWorkerNo() {
                return workerNo;
            }

            public void setWorkerName(String workerName) {
                this.workerName = workerName;
            }

            public String getWorkerName() {
                return workerName;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSex() {
                return sex;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getEmail() {
                return email;
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

            public void setEntryDay(String entryDay) {
                this.entryDay = entryDay;
            }

            public String getEntryDay() {
                return entryDay;
            }

            public void setDepartDay(String departDay) {
                this.departDay = departDay;
            }

            public String getDepartDay() {
                return departDay;
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
                    .append("workerNo", getWorkerNo())
                    .append("workerName", getWorkerName())
                    .append("sex", getSex())
                    .append("avatar", getAvatar())
                    .append("birthday", getBirthday())
                    .append("telephone", getTelephone())
                    .append("email", getEmail())
                    .append("status", getStatus())
                    .append("remarks", getRemarks())
                    .append("entryDay", getEntryDay())
                    .append("departDay", getDepartDay())
                    .append("createTime", getCreateTime())
                    .append("createUserId", getCreateUserId())
                    .append("createUser", getCreateUser())
                    .append("updateTime", getUpdateTime())
                    .append("updateUserId", getUpdateUserId())
                    .append("updateUser", getUpdateUser())
                .toString();
    }


}
