package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 部门岗位关联表
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
@Table(name = "ta_fly_auth_clazz_dept")
public class ClazzDept implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 租户ID
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 应用ID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private String deptId;

    /**
     * 岗位ID
     */
    @Column(name = "clazz_id")
    private String clazzId;

    /**
     * 岗位名称
     */
    @Column(name = "clazz_title")
    private String clazzTitle;

    /**
     * 有效标志: Y-是;N-否
     */
    @Column(name = "valid_flag")
    private String validFlag;


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
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("deptId", getDeptId())
                .append("clazzId", getClazzId())
                .append("clazzTitle", getClazzTitle())
                .append("validFlag", getValidFlag())
                .toString();
    }


}
