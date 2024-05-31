package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 部门岗位关联表 查询参数
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
public class ClazzDeptQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId = BizContextHandler.getTenantId();

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 岗位ID
     */
    private String clazzId;

    /**
     * 岗位名称
     */
    private String clazzTitle;

    /**
     * 有效标志: Y-是;N-否
     */
    private String validFlag;


    public ClazzDeptQuery() {
    }

    public ClazzDeptQuery(int page, int limit, String tenantId, String appId, String deptId, String clazzId, String clazzTitle, String validFlag) {
        super(page, limit);
        this.tenantId = tenantId;
        this.appId = appId;
        this.deptId = deptId;
        this.clazzId = clazzId;
        this.clazzTitle = clazzTitle;
        this.validFlag = validFlag;
    }

    public static ClazzDeptQueryBuilder builder() {
        return new ClazzDeptQueryBuilder();
    }

    public static class ClazzDeptQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String appId;
        private String deptId;
        private String clazzId;
        private String clazzTitle;
        private String validFlag;

        public ClazzDeptQueryBuilder() {
        }

        public ClazzDeptQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public ClazzDeptQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public ClazzDeptQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 应用ID */
        public ClazzDeptQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 部门ID */
        public ClazzDeptQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 岗位ID */
        public ClazzDeptQueryBuilder clazzId(String clazzId) {
            this.clazzId = clazzId;
            return this;
        }

        /* 岗位名称 */
        public ClazzDeptQueryBuilder clazzTitle(String clazzTitle) {
            this.clazzTitle = clazzTitle;
            return this;
        }

        /* 有效标志: Y-是;N-否 */
        public ClazzDeptQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        public ClazzDeptQuery build() {
            return new ClazzDeptQuery(page, limit, tenantId, appId, deptId, clazzId, clazzTitle, validFlag);
        }

    }


    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzTitle(String clazzTitle) {
        this.clazzTitle = clazzTitle;
    }

    public String getClazzTitle() {
        return clazzTitle;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("deptId", getDeptId())
                .append("clazzId", getClazzId())
                .append("clazzTitle", getClazzTitle())
                .append("validFlag", getValidFlag())
                .toString();
    }

}
