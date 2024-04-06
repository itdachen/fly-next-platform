package com.github.itdachen.admin_v1.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 部门管理 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DeptInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;



    /** 租户标识 */
    private String tenantId;

    /** 部门名称 */
    private String title;

    /** 上级id */
    private String parentId;

    /** 部门类型 */
    private String deptType;

    /** 部门级次 */
    private String deptLevel;


    public DeptInfoQuery() {
    }

    public DeptInfoQuery(int page, int limit, String tenantId, String title, String parentId, String deptType, String deptLevel) {
        super(page, limit);
        this.tenantId = tenantId;
        this.title = title;
        this.parentId = parentId;
        this.deptType = deptType;
        this.deptLevel = deptLevel;
    }

    public static DeptInfoQueryBuilder builder() {
        return new DeptInfoQueryBuilder();
    }

    public static class DeptInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String title;
        private String parentId;
        private String deptType;
        private String deptLevel;

        public DeptInfoQueryBuilder() {
        }

        public DeptInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DeptInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户标识 */
        public DeptInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 部门名称 */
        public DeptInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 上级id */
        public DeptInfoQueryBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }
        /* 部门类型 */
        public DeptInfoQueryBuilder deptType(String deptType) {
            this.deptType = deptType;
            return this;
        }
        /* 部门级次 */
        public DeptInfoQueryBuilder deptLevel(String deptLevel) {
            this.deptLevel = deptLevel;
            return this;
        }

        public DeptInfoQuery build() {
            return new DeptInfoQuery(page, limit, tenantId, title, parentId, deptType, deptLevel);
        }

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

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("title", getTitle())
                .append("parentId", getParentId())
                .append("deptType", getDeptType())
                .append("deptLevel", getDeptLevel())
                .toString();
    }


}
