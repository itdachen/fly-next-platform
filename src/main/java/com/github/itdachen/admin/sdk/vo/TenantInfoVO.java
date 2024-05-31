package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 租户/公司信息 VO
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
public class TenantInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键唯一标识
     */
    private String id;

    /**
     * 上级ID
     */
    private String parentId;

    /**
     * 上级名称
     */
    private String parentTitle;

    /**
     * 行业代码
     */
    private String typeId;

    /**
     * 行业名称
     */
    private String typeTitle;

    /**
     * 名称
     */
    private String title;

    /**
     * 简称
     */
    private String titleAs;

    /**
     * 所属省级ID
     */
    private String provId;

    /**
     * 所属省级名称
     */
    private String provTitle;

    /**
     * 所属市州
     */
    private String cityId;

    /**
     * 所属市州名称
     */
    private String cityTitle;

    /**
     * 所属区县
     */
    private String countyId;

    /**
     * 所属区县名称
     */
    private String countyTitle;

    /**
     * 图标
     */
    private String homeIcon;

    /**
     * 官网/访问地址
     */
    private String homeUri;

    /**
     * 拥有者ID
     */
    private String ownerId;

    /**
     * 拥有者昵称
     */
    private String ownerNickName;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 电子邮箱
     */
    private String eMailBox;

    /**
     * 传真
     */
    private String facsimile;

    /**
     * 职能代码
     */
    private String funcCode;

    /**
     * 是否可删除: Y-是;N-否
     */
    private String validDel;

    /**
     * 有效标志: Y-是;N-否
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

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public String getParentTitle() {
        return parentTitle;
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

    public void setHomeIcon(String homeIcon) {
        this.homeIcon = homeIcon;
    }

    public String getHomeIcon() {
        return homeIcon;
    }

    public void setHomeUri(String homeUri) {
        this.homeUri = homeUri;
    }

    public String getHomeUri() {
        return homeUri;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerNickName(String ownerNickName) {
        this.ownerNickName = ownerNickName;
    }

    public String getOwnerNickName() {
        return ownerNickName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void seteMailBox(String eMailBox) {
        this.eMailBox = eMailBox;
    }

    public String geteMailBox() {
        return eMailBox;
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

    public void setValidDel(String validDel) {
        this.validDel = validDel;
    }

    public String getValidDel() {
        return validDel;
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
                .append("parentId", getParentId())
                .append("parentTitle", getParentTitle())
                .append("typeId", getTypeId())
                .append("typeTitle", getTypeTitle())
                .append("title", getTitle())
                .append("titleAs", getTitleAs())
                .append("provId", getProvId())
                .append("provTitle", getProvTitle())
                .append("cityId", getCityId())
                .append("cityTitle", getCityTitle())
                .append("countyId", getCountyId())
                .append("countyTitle", getCountyTitle())
                .append("homeIcon", getHomeIcon())
                .append("homeUri", getHomeUri())
                .append("ownerId", getOwnerId())
                .append("ownerNickName", getOwnerNickName())
                .append("telephone", getTelephone())
                .append("eMailBox", geteMailBox())
                .append("facsimile", getFacsimile())
                .append("funcCode", getFuncCode())
                .append("validDel", getValidDel())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .toString();
    }

}
