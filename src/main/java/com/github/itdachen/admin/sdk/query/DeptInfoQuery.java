package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 部门信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public class DeptInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户标识/公司标识
     */
    private String tenantId;

    /**
     * 上级ID
     */
    private String parentId;

    /**
     * 部门名称
     */
    private String title;

    /**
     * 部门简称
     */
    private String titleAs;

    /**
     * 部门类型ID
     */
    private String typeId;

    /**
     * 部门类型
     */
    private String typeTitle;

    /**
     * 部门标志: Y-是;N-否
     */
    private String deptFlag;

    /**
     * 是否管理本级: Y-是;N-否
     */
    private String thatLevel;

    /**
     * 部门级次: 00-总部/10-省级/20-市州级/30-区县级/40-乡村级
     */
    private String deptLevel;

    /**
     * 职能代码(暂时不用)
     */
    private String funcCode;

    /**
     * 所属省级ID
     */
    private String provId;

    /**
     * 所属省级名称
     */
    private String provTitle;

    /**
     * 所属市州
     */
    private String cityId;

    /**
     * 所属市州名称
     */
    private String cityTitle;

    /**
     * 所属区县
     */
    private String countyId;

    /**
     * 所属区县名称
     */
    private String countyTitle;

    /**
     * 有效标志: Y-是;N-否
     */
    private String validFlag;


    public DeptInfoQuery() {
    }

    public DeptInfoQuery(int page, int limit, String tenantId, String parentId, String title, String titleAs, String typeId, String typeTitle, String deptFlag, String thatLevel, String deptLevel, String funcCode, String provId, String provTitle, String cityId, String cityTitle, String countyId, String countyTitle, String validFlag) {
        super(page, limit);
        this.tenantId = tenantId;
        this.parentId = parentId;
        this.title = title;
        this.titleAs = titleAs;
        this.typeId = typeId;
        this.typeTitle = typeTitle;
        this.deptFlag = deptFlag;
        this.thatLevel = thatLevel;
        this.deptLevel = deptLevel;
        this.funcCode = funcCode;
        this.provId = provId;
        this.provTitle = provTitle;
        this.cityId = cityId;
        this.cityTitle = cityTitle;
        this.countyId = countyId;
        this.countyTitle = countyTitle;
        this.validFlag = validFlag;
    }

    public static DeptInfoQueryBuilder builder() {
        return new DeptInfoQueryBuilder();
    }

    public static class DeptInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String parentId;
        private String title;
        private String titleAs;
        private String typeId;
        private String typeTitle;
        private String deptFlag;
        private String thatLevel;
        private String deptLevel;
        private String funcCode;
        private String provId;
        private String provTitle;
        private String cityId;
        private String cityTitle;
        private String countyId;
        private String countyTitle;
        private String validFlag;

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

        /* 租户标识/公司标识 */
        public DeptInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 上级ID */
        public DeptInfoQueryBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /* 部门名称 */
        public DeptInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 部门简称 */
        public DeptInfoQueryBuilder titleAs(String titleAs) {
            this.titleAs = titleAs;
            return this;
        }

        /* 部门类型ID */
        public DeptInfoQueryBuilder typeId(String typeId) {
            this.typeId = typeId;
            return this;
        }

        /* 部门类型 */
        public DeptInfoQueryBuilder typeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
            return this;
        }

        /* 部门标志: Y-是;N-否 */
        public DeptInfoQueryBuilder deptFlag(String deptFlag) {
            this.deptFlag = deptFlag;
            return this;
        }

        /* 是否管理本级: Y-是;N-否 */
        public DeptInfoQueryBuilder thatLevel(String thatLevel) {
            this.thatLevel = thatLevel;
            return this;
        }

        /* 部门级次: 00-总部/10-省级/20-市州级/30-区县级/40-乡村级 */
        public DeptInfoQueryBuilder deptLevel(String deptLevel) {
            this.deptLevel = deptLevel;
            return this;
        }

        /* 职能代码(暂时不用) */
        public DeptInfoQueryBuilder funcCode(String funcCode) {
            this.funcCode = funcCode;
            return this;
        }

        /* 所属省级ID */
        public DeptInfoQueryBuilder provId(String provId) {
            this.provId = provId;
            return this;
        }

        /* 所属省级名称 */
        public DeptInfoQueryBuilder provTitle(String provTitle) {
            this.provTitle = provTitle;
            return this;
        }

        /* 所属市州 */
        public DeptInfoQueryBuilder cityId(String cityId) {
            this.cityId = cityId;
            return this;
        }

        /* 所属市州名称 */
        public DeptInfoQueryBuilder cityTitle(String cityTitle) {
            this.cityTitle = cityTitle;
            return this;
        }

        /* 所属区县 */
        public DeptInfoQueryBuilder countyId(String countyId) {
            this.countyId = countyId;
            return this;
        }

        /* 所属区县名称 */
        public DeptInfoQueryBuilder countyTitle(String countyTitle) {
            this.countyTitle = countyTitle;
            return this;
        }

        /* 有效标志: Y-是;N-否 */
        public DeptInfoQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        public DeptInfoQuery build() {
            return new DeptInfoQuery(page, limit, tenantId, parentId, title, titleAs, typeId, typeTitle, deptFlag, thatLevel, deptLevel, funcCode, provId, provTitle, cityId, cityTitle, countyId, countyTitle, validFlag);
        }

    }


    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitleAs(String titleAs) {
        this.titleAs = titleAs;
    }

    public String getTitleAs() {
        return titleAs;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setDeptFlag(String deptFlag) {
        this.deptFlag = deptFlag;
    }

    public String getDeptFlag() {
        return deptFlag;
    }

    public void setThatLevel(String thatLevel) {
        this.thatLevel = thatLevel;
    }

    public String getThatLevel() {
        return thatLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvTitle(String provTitle) {
        this.provTitle = provTitle;
    }

    public String getProvTitle() {
        return provTitle;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyTitle(String countyTitle) {
        this.countyTitle = countyTitle;
    }

    public String getCountyTitle() {
        return countyTitle;
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
                .append("parentId", getParentId())
                .append("title", getTitle())
                .append("titleAs", getTitleAs())
                .append("typeId", getTypeId())
                .append("typeTitle", getTypeTitle())
                .append("deptFlag", getDeptFlag())
                .append("thatLevel", getThatLevel())
                .append("deptLevel", getDeptLevel())
                .append("funcCode", getFuncCode())
                .append("provId", getProvId())
                .append("provTitle", getProvTitle())
                .append("cityId", getCityId())
                .append("cityTitle", getCityTitle())
                .append("countyId", getCountyId())
                .append("countyTitle", getCountyTitle())
                .append("validFlag", getValidFlag())
                .toString();
    }

}
