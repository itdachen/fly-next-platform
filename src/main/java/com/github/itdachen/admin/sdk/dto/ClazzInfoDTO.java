package com.github.itdachen.admin.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 岗位信息 DTO
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
public class ClazzInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键唯一标识
     */
    private String id = "-";

    /**
     * 租户ID
     */
    private String tenantId = "-";

    /**
     * 部门职能代码
     */
    @NotBlank(message = "请选择部门职能")
    private String deptFuncCode;

    /**
     * 部门职能名称
     */
    // @NotBlank(message = "部门职能名称不能为空")
    private String deptFuncTitle;

    /**
     * 所属层级等级
     */
    @NotBlank(message = "请选择所属层级")
    private String thatLevelCode;

    /**
     * 所属层级名称
     */
    //  @NotBlank(message = "所属层级名称不能为空")
    private String thatLevelTitle;

    /**
     * 岗位类型ID
     */
    @NotBlank(message = "请选择岗位职能")
    private String clazzFuncCode;

    /**
     * 岗位类型
     */
  //  @NotBlank(message = "岗位类型不能为空")
    private String clazzFuncTitle;

    /**
     * 岗位代码
     */
    // @NotBlank(message = "岗位代码不能为空")
    private String clazzCode;

    /**
     * 岗位名称
     */
    // @NotBlank(message = "岗位名称不能为空")
    private String clazzTitle;

    /**
     * 有效标志: Y-是;N-否
     */
    @NotBlank(message = "有效标志不能为空")
    private String validFlag;

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
                .toString();
    }

}