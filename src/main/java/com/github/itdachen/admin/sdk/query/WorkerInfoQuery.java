package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 员工信息 查询参数
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
public class WorkerInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

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


    public WorkerInfoQuery() {
    }

    public WorkerInfoQuery(int page, int limit, String tenantId, String workerNo, String workerName, String sex, String telephone, String email, String status) {
        super(page, limit);
        this.tenantId = tenantId;
        this.workerNo = workerNo;
        this.workerName = workerName;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
    }

    public static WorkerInfoQueryBuilder builder() {
        return new WorkerInfoQueryBuilder();
    }

    public static class WorkerInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String workerNo;
        private String workerName;
        private String sex;
        private String telephone;
        private String email;
        private String status;

        public WorkerInfoQueryBuilder() {
        }

        public WorkerInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public WorkerInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户标识 */
        public WorkerInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 职工编号 */
        public WorkerInfoQueryBuilder workerNo(String workerNo) {
            this.workerNo = workerNo;
            return this;
        }

        /* 职工姓名 */
        public WorkerInfoQueryBuilder workerName(String workerName) {
            this.workerName = workerName;
            return this;
        }

        /* 性别 */
        public WorkerInfoQueryBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        /* 电话号码 */
        public WorkerInfoQueryBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        /* 电子邮箱 */
        public WorkerInfoQueryBuilder email(String email) {
            this.email = email;
            return this;
        }

        /* 状态: 正常;离职;休假 */
        public WorkerInfoQueryBuilder status(String status) {
            this.status = status;
            return this;
        }

        public WorkerInfoQuery build() {
            return new WorkerInfoQuery(page, limit, tenantId, workerNo, workerName, sex, telephone, email, status);
        }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("workerNo", getWorkerNo())
                .append("workerName", getWorkerName())
                .append("sex", getSex())
                .append("telephone", getTelephone())
                .append("email", getEmail())
                .append("status", getStatus())
                .toString();
    }

}
