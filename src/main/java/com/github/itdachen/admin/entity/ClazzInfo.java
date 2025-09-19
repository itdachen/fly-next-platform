package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 岗位信息
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
@Table(name = "ta_fly_clazz_info")
public class ClazzInfo implements Serializable {
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
     * 部门职能代码
     */
    @Column(name = "dept_func_code")
    private String deptFuncCode = "-";

    /**
     * 部门职能名称
     */
    @Column(name = "dept_func_title")
    private String deptFuncTitle = "-";

    /**
     * 所属层级等级
     */
    @Column(name = "that_level_code")
    private String thatLevelCode = "-";

    /**
     * 所属层级名称
     */
    @Column(name = "that_level_title")
    private String thatLevelTitle = "-";

    /**
     * 岗位类型ID
     */
    @Column(name = "clazz_func_code")
    private String clazzFuncCode = "-";

    /**
     * 岗位类型
     */
    @Column(name = "clazz_func_title")
    private String clazzFuncTitle = "-";

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
     * 删除标志: Y-已删除;N-未删除
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

    public void setDeptFuncCode(String deptFuncCode) {
        this.deptFuncCode = deptFuncCode;
    }

    public String getDeptFuncCode() {
        return deptFuncCode;
    }

    public void setDeptFuncTitle(String deptFuncTitle) {
        this.deptFuncTitle = deptFuncTitle;
    }

    public String getDeptFuncTitle() {
        return deptFuncTitle;
    }

    public void setThatLevelCode(String thatLevelCode) {
        this.thatLevelCode = thatLevelCode;
    }

    public String getThatLevelCode() {
        return thatLevelCode;
    }

    public void setThatLevelTitle(String thatLevelTitle) {
        this.thatLevelTitle = thatLevelTitle;
    }

    public String getThatLevelTitle() {
        return thatLevelTitle;
    }

    public void setClazzFuncCode(String clazzFuncCode) {
        this.clazzFuncCode = clazzFuncCode;
    }

    public String getClazzFuncCode() {
        return clazzFuncCode;
    }

    public void setClazzFuncTitle(String clazzFuncTitle) {
        this.clazzFuncTitle = clazzFuncTitle;
    }

    public String getClazzFuncTitle() {
        return clazzFuncTitle;
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
                .append("deptFuncCode", getDeptFuncCode())
                .append("deptFuncTitle", getDeptFuncTitle())
                .append("thatLevelCode", getThatLevelCode())
                .append("thatLevelTitle", getThatLevelTitle())
                .append("clazzFuncCode", getClazzFuncCode())
                .append("clazzFuncTitle", getClazzFuncTitle())
                .append("clazzCode", getClazzCode())
                .append("clazzTitle", getClazzTitle())
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