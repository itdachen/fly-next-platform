package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 员工信息 请求参数数据
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
public class WorkerInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键唯一标识
     */
    private String id;


    /**
     * 租户标识
     */
    private String tenantId;


    /**
     * 职工编号
     */
    private String workerNo;


    /**
     * 职工姓名
     */
    private String workerName;


    /**
     * 性别
     */
    private String sex;


    /**
     * 头像
     */
    private String avatar;


    /**
     * 生日
     */
    private String birthday;


    /**
     * 电话号码
     */
    private String telephone;


    /**
     * 电子邮箱
     */
    private String email;


    /**
     * 状态: 正常;离职;休假
     */
    private String status;


    /**
     * 备注
     */
    private String remarks;


    /**
     * 入职日期
     */
    private String entryDay;


    /**
     * 离职日期
     */
    private String departDay;


    public WorkerInfoDto() {
    }

    public WorkerInfoDto(String id, String tenantId, String workerNo, String workerName, String sex, String avatar, String birthday, String telephone, String email, String status, String remarks, String entryDay, String departDay) {
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
    }

    public static WorkerInfoDtoBuilder builder() {
        return new WorkerInfoDtoBuilder();
    }

    public static class WorkerInfoDtoBuilder {
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

        public WorkerInfoDtoBuilder() {
        }

        /* 主键唯一标识 */
        public WorkerInfoDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 租户标识 */
        public WorkerInfoDtoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 职工编号 */
        public WorkerInfoDtoBuilder workerNo(String workerNo) {
            this.workerNo = workerNo;
            return this;
        }

        /* 职工姓名 */
        public WorkerInfoDtoBuilder workerName(String workerName) {
            this.workerName = workerName;
            return this;
        }

        /* 性别 */
        public WorkerInfoDtoBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        /* 头像 */
        public WorkerInfoDtoBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        /* 生日 */
        public WorkerInfoDtoBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        /* 电话号码 */
        public WorkerInfoDtoBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        /* 电子邮箱 */
        public WorkerInfoDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        /* 状态: 正常;离职;休假 */
        public WorkerInfoDtoBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 备注 */
        public WorkerInfoDtoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        /* 入职日期 */
        public WorkerInfoDtoBuilder entryDay(String entryDay) {
            this.entryDay = entryDay;
            return this;
        }

        /* 离职日期 */
        public WorkerInfoDtoBuilder departDay(String departDay) {
            this.departDay = departDay;
            return this;
        }

        public WorkerInfoDto build() {
            return new WorkerInfoDto(id, tenantId, workerNo, workerName, sex, avatar, birthday, telephone, email, status, remarks, entryDay, departDay);
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
                .toString();
    }

}
