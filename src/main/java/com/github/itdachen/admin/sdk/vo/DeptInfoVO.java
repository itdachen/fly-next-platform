package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;
import java.util.List;


/**
 * 部门信息 VO
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public class DeptInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键唯一标识 */
    private String id;

    /** 租户标识/公司标识 */
    private String tenantId;

    /** 上级ID */
    private String parentId;

    /** 部门名称 */
    private String title;

    /** 部门简称 */
    private String titleAs;

    /** 部门类型ID */
    private String typeId;

    /** 部门类型 */
    private String typeTitle;

    /** 部门标志: Y-是;N-否 */
    private String deptFlag;

    /** 是否管理本级: Y-是;N-否 */
    private String thatLevel;

    /** 部门级次: 00-总部/10-省级/20-市州级/30-区县级/40-乡村级 */
    private String deptLevel;

    /** 联系电话 */
    private String telephone;

    /** 电子邮箱 */
    private String mailBox;

    /** 传真 */
    private String facsimile;

    /** 职能代码(暂时不用) */
    private String funcCode;

    /** 所属省级ID */
    private String provId;

    /** 所属省级名称 */
    private String provTitle;

    /** 所属市州 */
    private String cityId;

    /** 所属市州名称 */
    private String cityTitle;

    /** 所属区县 */
    private String countyId;

    /** 所属区县名称 */
    private String countyTitle;

    /** 有效标志: Y-是;N-否 */
    private String validFlag;

    /** 备注 */
    private String remarks;

    private List<DeptInfoVO> children;



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

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitleAs(String titleAs) {
        this.titleAs = titleAs;
    }

    public String getTitleAs() {
        return titleAs;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setDeptFlag(String deptFlag) {
        this.deptFlag = deptFlag;
    }

    public String getDeptFlag() {
        return deptFlag;
    }

    public void setThatLevel(String thatLevel) {
        this.thatLevel = thatLevel;
    }

    public String getThatLevel() {
        return thatLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }

    public String getFacsimile() {
        return facsimile;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvTitle(String provTitle) {
        this.provTitle = provTitle;
    }

    public String getProvTitle() {
        return provTitle;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyTitle(String countyTitle) {
        this.countyTitle = countyTitle;
    }

    public String getCountyTitle() {
        return countyTitle;
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

    public List<DeptInfoVO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptInfoVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tenantId", getTenantId())
                .append("parentId", getParentId())
                .append("title", getTitle())
                .append("titleAs", getTitleAs())
                .append("typeId", getTypeId())
                .append("typeTitle", getTypeTitle())
                .append("deptFlag", getDeptFlag())
                .append("thatLevel", getThatLevel())
                .append("deptLevel", getDeptLevel())
                .append("telephone", getTelephone())
                .append("mailBox", getMailBox())
                .append("facsimile", getFacsimile())
                .append("funcCode", getFuncCode())
                .append("provId", getProvId())
                .append("provTitle", getProvTitle())
                .append("cityId", getCityId())
                .append("cityTitle", getCityTitle())
                .append("countyId", getCountyId())
                .append("countyTitle", getCountyTitle())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .toString();
    }

}
