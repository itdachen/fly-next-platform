package com.github.itdachen.admin.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 身份信息 DTO
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public class UserRoleInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 身份ID
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 姓名
     */
    private String nickName;

    /**
     * 身份名称
     */
    @NotBlank(message = "身份名称不能为空")
    private String roleName;

    /**
     * 是否主身份
     */
    @NotBlank(message = "是否主身份不能为空")
    private String roleFlag;

    /**
     * 有效标志
     */
    @NotBlank(message = "有效标志不能为空")
    private String validFlag;

    /**
     * 身份部门ID
     */
    private String deptId;

    /**
     * 身份部门名称
     */
    private String deptTitle;

    /**
     * 身份有效期起
     */
    private String startTime;

    /**
     * 身份有效期止
     */
    private String endTime;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 备注
     */
    private String remarks;


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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("roleName", getRoleName())
                .append("roleFlag", getRoleFlag())
                .append("validFlag", getValidFlag())
                .append("deptId", getDeptId())
                .append("deptTitle", getDeptTitle())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("orderNum", getOrderNum())
                .append("remarks", getRemarks())
                .toString();
    }


}
