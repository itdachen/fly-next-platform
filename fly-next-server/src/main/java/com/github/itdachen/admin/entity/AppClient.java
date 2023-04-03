package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 应用
 *
 * @author 王大宸
 * @date 2022-08-20 22:27:58
 */
@Table(name = "sys_app_client")
public class AppClient implements Serializable {
    private static final long serialVersionUID = 1034077933277916648L;

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 应用名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 应用标识码
     */
    @Column(name = "app_code")
    private String appCode;

    /**
     * 应用类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 互联网访问地址
     */
    @Column(name = "home_url")
    private String homeUrl;

    /**
     * 内网访问地址
     */
    @Column(name = "intranet_url")
    private String intranetUrl;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 是否启用1-是;0-否
     */
    @Column(name = "state")
    private String state;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 是否可删除
     */
    @Column(name = "can_del")
    private String canDel;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setIntranetUrl(String intranetUrl) {
        this.intranetUrl = intranetUrl;
    }

    public String getIntranetUrl() {
        return intranetUrl;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getCanDel() {
        return canDel;
    }

    public void setCanDel(String canDel) {
        this.canDel = canDel;
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
                .append("name", getName())
                .append("appCode", getAppCode())
                .append("type", getType())
                .append("homeUrl", getHomeUrl())
                .append("intranetUrl", getIntranetUrl())
                .append("icon", getIcon())
                .append("state", getState())
                .append("remark", getRemark())
                .append("canDel", getCanDel())
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
