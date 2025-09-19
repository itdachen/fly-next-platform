package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 岗位信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
public class ClazzInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 部门职能代码
     */
    private String deptFuncCode;

    /**
     * 所属层级等级
     */
    private String thatLevelCode;

    /**
     * 岗位类型ID
     */
    private String clazzFuncCode;

    /**
     * 岗位代码
     */
    private String clazzCode;

    /**
     * 岗位名称
     */
    private String clazzTitle;

    /**
     * 有效标志: Y-是;N-否
     */
    private String validFlag;

    /**
     * 删除标志: Y-已删除;N-未删除
     */
    private String removeFlag;


    public ClazzInfoQuery() {
    }

    public ClazzInfoQuery(int page, int limit, String tenantId, String deptFuncCode, String thatLevelCode, String clazzFuncCode, String clazzCode, String clazzTitle, String validFlag, String removeFlag) {
        super(page, limit);
        this.tenantId = tenantId;
        this.deptFuncCode = deptFuncCode;
        this.thatLevelCode = thatLevelCode;
        this.clazzFuncCode = clazzFuncCode;
        this.clazzCode = clazzCode;
        this.clazzTitle = clazzTitle;
        this.validFlag = validFlag;
        this.removeFlag = removeFlag;
    }

    public static ClazzInfoQueryBuilder builder() {
        return new ClazzInfoQueryBuilder();
    }

    public static class ClazzInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String deptFuncCode;
        private String thatLevelCode;
        private String clazzFuncCode;
        private String clazzCode;
        private String clazzTitle;
        private String validFlag;
        private String removeFlag;

        public ClazzInfoQueryBuilder() {
        }

        public ClazzInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public ClazzInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public ClazzInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 部门职能代码 */
        public ClazzInfoQueryBuilder deptFuncCode(String deptFuncCode) {
            this.deptFuncCode = deptFuncCode;
            return this;
        }

        /* 所属层级等级 */
        public ClazzInfoQueryBuilder thatLevelCode(String thatLevelCode) {
            this.thatLevelCode = thatLevelCode;
            return this;
        }

        /* 岗位类型ID */
        public ClazzInfoQueryBuilder clazzFuncCode(String clazzFuncCode) {
            this.clazzFuncCode = clazzFuncCode;
            return this;
        }

        /* 岗位代码 */
        public ClazzInfoQueryBuilder clazzCode(String clazzCode) {
            this.clazzCode = clazzCode;
            return this;
        }

        /* 岗位名称 */
        public ClazzInfoQueryBuilder clazzTitle(String clazzTitle) {
            this.clazzTitle = clazzTitle;
            return this;
        }

        /* 有效标志: Y-是;N-否 */
        public ClazzInfoQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        /* 删除标志: Y-已删除;N-未删除 */
        public ClazzInfoQueryBuilder removeFlag(String removeFlag) {
            this.removeFlag = removeFlag;
            return this;
        }

        public ClazzInfoQuery build() {
            return new ClazzInfoQuery(page, limit, tenantId, deptFuncCode, thatLevelCode, clazzFuncCode, clazzCode, clazzTitle, validFlag, removeFlag);
        }

    }


    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setDeptFuncCode(String deptFuncCode) {
        this.deptFuncCode = deptFuncCode;
    }

    public String getDeptFuncCode() {
        return deptFuncCode;
    }

    public void setThatLevelCode(String thatLevelCode) {
        this.thatLevelCode = thatLevelCode;
    }

    public String getThatLevelCode() {
        return thatLevelCode;
    }

    public void setClazzFuncCode(String clazzFuncCode) {
        this.clazzFuncCode = clazzFuncCode;
    }

    public String getClazzFuncCode() {
        return clazzFuncCode;
    }

    public void setClazzCode(String clazzCode) {
        this.clazzCode = clazzCode;
    }

    public String getClazzCode() {
        return clazzCode;
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

    public void setRemoveFlag(String removeFlag) {
        this.removeFlag = removeFlag;
    }

    public String getRemoveFlag() {
        return removeFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("deptFuncCode", getDeptFuncCode())
                .append("thatLevelCode", getThatLevelCode())
                .append("clazzFuncCode", getClazzFuncCode())
                .append("clazzCode", getClazzCode())
                .append("clazzTitle", getClazzTitle())
                .append("validFlag", getValidFlag())
                .append("removeFlag", getRemoveFlag())
                .toString();
    }

}