package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 部门等级
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
@Table(name = "ta_fly_dept_level")
public class DeptLevel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
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
     * 层级代码
     */
    @Column(name = "level_code")
    private String levelCode = "-";

    /**
     * 层级名称,例如: 00-总部; 10-省级部门; 20-市州级部门; 30-区县级;40-乡镇级;50-社区/街道/村
     */
    @Column(name = "level_title")
    private String levelTitle = "-";

    /**
     * 有效标志: Y-是;N-否
     */
    @Column(name = "valid_flag")
    private String validFlag = "-";

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks = "-";

    /**
     * 删除标志:  Y-已删除;N-未删除
     */
    @Column(name = "remove_flag")
    private String removeFlag = "-";

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

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelTitle(String levelTitle) {
        this.levelTitle = levelTitle;
    }

    public String getLevelTitle() {
        return levelTitle;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemoveFlag(String removeFlag) {
        this.removeFlag = removeFlag;
    }

    public String getRemoveFlag() {
        return removeFlag;
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
                .append("levelCode", getLevelCode())
                .append("levelTitle", getLevelTitle())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .append("removeFlag", getRemoveFlag())
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }

}
