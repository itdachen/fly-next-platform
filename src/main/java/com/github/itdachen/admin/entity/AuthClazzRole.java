package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



/**
 * 身份岗位管理表
 *
 * @author 王大宸
 * @date 2024-05-15 21:28:55
 */
@Table(name = "ta_fly_auth_clazz_role")
public class AuthClazzRole implements Serializable{
private static final long serialVersionUID=1L;

    /** ID */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户ID */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 应用ID */
    @Column(name = "app_id")
    private String appId;

    /** 岗位ID */
    @Column(name = "clazz_id")
    private String clazzId;

    /** 身份ID */
    @Column(name = "role_id")
    private String roleId;





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

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("clazzId", getClazzId())
                .append("roleId", getRoleId())
                .toString();
    }

}
