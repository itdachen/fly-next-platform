package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 部门管理 Vo
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DeptInfoVo implements Serializable {
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
     * 部门名称
     */
    private String title;

    /**
     * 上级id
     */
    private String parentId;

    /**
     * 部门类型
     */
    private String deptType;

    /** 部门级次 */
    private String deptLevel;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否可删除: 1-可删除;0-不可删
     */
    private String isCanDel;

    /**
     * 负责人
     */
    private String personCharge;

    private List<DeptInfoVo> children = new ArrayList<>();

    public DeptInfoVo() {
    }

    public DeptInfoVo(String id, String tenantId, String title, String parentId,
                      String deptType, String deptLevel,
                      String remarks, String isCanDel,
                      String personCharge, List<DeptInfoVo> children) {
        this.id = id;
        this.tenantId = tenantId;
        this.title = title;
        this.parentId = parentId;
        this.deptType = deptType;
        this.remarks = remarks;
        this.isCanDel = isCanDel;
        this.personCharge = personCharge;
        this.children = children;
        this.deptLevel=deptLevel;
    }

    public static DeptInfoVoBuilder builder() {
        return new DeptInfoVoBuilder();
    }

    public static class DeptInfoVoBuilder {
        private String id;
        private String tenantId;
        private String title;
        private String parentId;
        private String deptType;
        private String deptLevel;
        private String remarks;
        private String isCanDel;
        private String personCharge;
        private List<DeptInfoVo> children;

        public DeptInfoVoBuilder() {
        }

        /* 主键唯一标识 */
        public DeptInfoVoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 租户标识 */
        public DeptInfoVoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 部门名称 */
        public DeptInfoVoBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 上级id */
        public DeptInfoVoBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /* 部门类型 */
        public DeptInfoVoBuilder deptType(String deptType) {
            this.deptType = deptType;
            return this;
        }
        public DeptInfoVoBuilder deptLevel(String deptLevel) {
            this.deptLevel = deptLevel;
            return this;
        }

        /* 备注 */
        public DeptInfoVoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        /* 是否可删除: 1-可删除;0-不可删 */
        public DeptInfoVoBuilder isCanDel(String isCanDel) {
            this.isCanDel = isCanDel;
            return this;
        }

        /* 负责人 */
        public DeptInfoVoBuilder personCharge(String personCharge) {
            this.personCharge = personCharge;
            return this;
        }
        public DeptInfoVoBuilder children(List<DeptInfoVo>  children) {
            this.children = children;
            return this;
        }


        public DeptInfoVo build() {
            return new DeptInfoVo(id,
                    tenantId,
                    title,
                    parentId,
                    deptType,
                    deptLevel,
                    remarks,
                    isCanDel,
                    personCharge,
                    children
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

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setIsCanDel(String isCanDel) {
        this.isCanDel = isCanDel;
    }

    public String getIsCanDel() {
        return isCanDel;
    }

    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge;
    }

    public String getPersonCharge() {
        return personCharge;
    }

    public List<DeptInfoVo> getChildren() {
        return children;
    }

    public void setChildren(List<DeptInfoVo> children) {
        this.children = children;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("title", getTitle())
                .append("parentId", getParentId())
                .append("deptType", getDeptType())
                .append("deptLevel", getDeptLevel())
                .append("remarks", getRemarks())
                .append("isCanDel", getIsCanDel())
                .append("personCharge", getPersonCharge())
                .append("children", getChildren())
                .toString();
    }

}
