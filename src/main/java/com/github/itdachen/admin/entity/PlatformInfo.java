package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 平台信息
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
@Table(name = "ta_fly_platform_info")
public class PlatformInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 平台ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 平台名称
     */
    @Column(name = "title")
    private String title;

    /**
     * 图标
     */
    @Column(name = "icon_ico")
    private String iconIco;

    /**
     * 职能代码
     */
    @Column(name = "func_code")
    private String funcCode;

    /**
     * 职能名称
     */
    @Column(name = "func_title")
    private String funcTitle;

    /**
     * 是否可删除: Y-是;N-否
     */
    @Column(name = "valid_del")
    private String validDel;

    /**
     * 有效标志: Y-是;N-否
     */
    @Column(name = "valid_flag")
    private String validFlag;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setIconIco(String iconIco) {
        this.iconIco = iconIco;
    }

    public String getIconIco() {
        return iconIco;
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
                .append("title", getTitle())
                .append("iconIco", getIconIco())
                .append("funcCode", getFuncCode())
                .append("funcTitle", getFuncTitle())
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
