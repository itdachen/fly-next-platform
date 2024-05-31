package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 租户/公司信息
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
@Table(name = "ta_fly_tenant_info")
public class TenantInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 上级ID */
    @Column(name = "parent_id")
    private String parentId;

    /** 上级名称 */
    @Column(name = "parent_title")
    private String parentTitle;

    /** 行业代码 */
    @Column(name = "type_id")
    private String typeId;

    /** 行业名称 */
    @Column(name = "type_title")
    private String typeTitle;

    /** 名称 */
    @Column(name = "title")
    private String title;

    /** 简称 */
    @Column(name = "title_as")
    private String titleAs;

    /** 所属省级ID */
    @Column(name = "prov_id")
    private String provId;

    /** 所属省级名称 */
    @Column(name = "prov_title")
    private String provTitle;

    /** 所属市州 */
    @Column(name = "city_id")
    private String cityId;

    /** 所属市州名称 */
    @Column(name = "city_title")
    private String cityTitle;

    /** 所属区县 */
    @Column(name = "county_id")
    private String countyId;

    /** 所属区县名称 */
    @Column(name = "county_title")
    private String countyTitle;

    /** 图标 */
    @Column(name = "home_icon")
    private String homeIcon;

    /** 官网/访问地址 */
    @Column(name = "home_uri")
    private String homeUri;

    /** 拥有者ID */
    @Column(name = "owner_id")
    private String ownerId;

    /** 拥有者昵称 */
    @Column(name = "owner_nick_name")
    private String ownerNickName;

    /** 联系电话 */
    @Column(name = "telephone")
    private String telephone;

    /** 电子邮箱 */
    @Column(name = "e_mail_box")
    private String eMailBox;

    /** 传真 */
    @Column(name = "facsimile")
    private String facsimile;

    /** 职能代码 */
    @Column(name = "func_code")
    private String funcCode;

    /** 是否可删除: Y-是;N-否 */
    @Column(name = "valid_del")
    private String validDel;

    /** 有效标志: Y-是;N-否 */
    @Column(name = "valid_flag")
    private String validFlag;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId;





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
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
