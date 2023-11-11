package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 岗位信息 查询参数
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
public class PositionInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户标识
     */
    private String tenantId;

    /**
     * 岗位名称
     */
    private String title;

    /**
     * 所属部门
     */
    private String deptId;

    /**
     * 状态
     */
    private String status;


    public PositionInfoQuery() {
    }

    public PositionInfoQuery(int page, int limit, String tenantId, String title, String deptId, String status) {
        super(page, limit);
        this.tenantId = tenantId;
        this.title = title;
        this.deptId = deptId;
        this.status = status;
    }

    public static PositionInfoQueryBuilder builder() {
        return new PositionInfoQueryBuilder();
    }

    public static class PositionInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String title;
        private String deptId;
        private String status;

        public PositionInfoQueryBuilder() {
        }

        public PositionInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public PositionInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户标识 */
        public PositionInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 岗位名称 */
        public PositionInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 所属部门 */
        public PositionInfoQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 状态 */
        public PositionInfoQueryBuilder status(String status) {
            this.status = status;
            return this;
        }

        public PositionInfoQuery build() {
            return new PositionInfoQuery(page, limit, tenantId, title, deptId, status);
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("title", getTitle())
                .append("deptId", getDeptId())
                .append("status", getStatus())
                .toString();
    }

}
