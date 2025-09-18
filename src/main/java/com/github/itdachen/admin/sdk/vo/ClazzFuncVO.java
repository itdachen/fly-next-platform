package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 岗位职能管理 VO
 *
 * @author 王大宸
 * @date 2025-09-18 22:27:28
 */
public class ClazzFuncVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID/类型代码: 例如:100,200,300
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 岗位职能编码, 例如: 001-主管领导岗;002-业务岗
     */
    private String funcCode;

    /**
     * 岗位职能标题, 例如: 001-主管领导岗;002-业务岗
     */
    private String funcTitle;

    /**
     * 有效标志: Y-有效;N-无效
     */
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

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
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
                .append("funcCode", getFuncCode())
                .append("funcTitle", getFuncTitle())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .toString();
    }

}
