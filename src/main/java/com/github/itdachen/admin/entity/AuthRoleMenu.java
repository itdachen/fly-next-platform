package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;



/**
 * 人员身份菜单
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
@Table(name = "ta_fly_auth_role_menu")
public class AuthRoleMenu implements Serializable{
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

    /** 人员身份ID */
    @Column(name = "role_id")
    private String roleId;

    /** 菜单ID/资源ID */
    @Column(name = "meni_id")
    private String meniId;





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

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

            public String getRoleId() {
                return roleId;
            }

            public void setMeniId(String meniId) {
                this.meniId = meniId;
            }

            public String getMeniId() {
                return meniId;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("tenantId", getTenantId())
                    .append("appId", getAppId())
                    .append("roleId", getRoleId())
                    .append("meniId", getMeniId())
                .toString();
    }


}
