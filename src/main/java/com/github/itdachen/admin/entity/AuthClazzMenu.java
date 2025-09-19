package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 岗位菜单
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
@Table(name = "ta_fly_auth_clazz_menu")
public class AuthClazzMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id = "-";

    /**
     * 租户ID
     */
    @Column(name = "tenant_id")
    private String tenantId = "-";

    /**
     * 应用ID
     */
    @Column(name = "app_id")
    private String appId = "-";

    /**
     * 岗位代码
     */
    @Column(name = "clazz_code")
    private String clazzCode = "-";

    /**
     * 岗位名称
     */
    @Column(name = "clazz_title")
    private String clazzTitle = "-";

    /**
     * 菜单ID/资源ID
     */
    @Column(name = "func_id")
    private String funcId = "-";

    /**
     * 资源名称
     */
    @Column(name = "func_title")
    private String funcTitle = "-";

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser = "-";

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId = "-";

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime = LocalDateTime.now();

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser = "-";

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId = "-";


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

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("clazzCode", getClazzCode())
                .append("clazzTitle", getClazzTitle())
                .append("funcId", getFuncId())
                .append("funcTitle", getFuncTitle())
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }

}
