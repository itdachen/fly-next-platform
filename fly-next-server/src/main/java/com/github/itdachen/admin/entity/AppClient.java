package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 应用管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
@Table(name = "sys_app_client")
public class AppClient implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 应用标识码
     */
    @Column(name = "app_code")
    private String appCode;

    /**
     * 应用类型
     */
    @Column(name = "app_type")
    private String appType;

    /**
     * 应用名称
     */
    @Column(name = "app_title")
    private String appTitle;

    /**
     * 互联网访问地址
     */
    @Column(name = "ask_uri")
    private String askUri;

    /**
     * 内网访问地址
     */
    @Column(name = "lan_uri")
    private String lanUri;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 是否启用1-是;0-否
     */
    @Column(name = "status")
    private String status;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

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


    public AppClient() {
    }


    public AppClient(String id, String appCode, String appType, String appTitle, String askUri, String lanUri, String icon, String status, String remarks, String canDel, LocalDateTime createTime, String createUser, String createUserId, LocalDateTime updateTime, String updateUser, String updateUserId) {
        this.id = id;
        this.appCode = appCode;
        this.appType = appType;
        this.appTitle = appTitle;
        this.askUri = askUri;
        this.lanUri = lanUri;
        this.icon = icon;
        this.status = status;
        this.remarks = remarks;
        this.canDel = canDel;
        this.createTime = createTime;
        this.createUser = createUser;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.updateUserId = updateUserId;
    }

    public static AppClientBuilder builder() {
        return new AppClientBuilder();
    }

    public static class AppClientBuilder {
        private String id;
        private String appCode;
        private String appType;
        private String appTitle;
        private String askUri;
        private String lanUri;
        private String icon;
        private String status;
        private String remarks;
        private String canDel;
        private LocalDateTime createTime;
        private String createUser;
        private String createUserId;
        private LocalDateTime updateTime;
        private String updateUser;
        private String updateUserId;

        public AppClientBuilder() {
        }

        /* 主键 */
        public AppClientBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 应用标识码 */
        public AppClientBuilder appCode(String appCode) {
            this.appCode = appCode;
            return this;
        }

        /* 应用类型 */
        public AppClientBuilder appType(String appType) {
            this.appType = appType;
            return this;
        }

        /* 应用名称 */
        public AppClientBuilder appTitle(String appTitle) {
            this.appTitle = appTitle;
            return this;
        }

        /* 互联网访问地址 */
        public AppClientBuilder askUri(String askUri) {
            this.askUri = askUri;
            return this;
        }

        /* 内网访问地址 */
        public AppClientBuilder lanUri(String lanUri) {
            this.lanUri = lanUri;
            return this;
        }

        /* 图标 */
        public AppClientBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        /* 是否启用1-是;0-否 */
        public AppClientBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 备注 */
        public AppClientBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        /* 是否可删除 */
        public AppClientBuilder canDel(String canDel) {
            this.canDel = canDel;
            return this;
        }

        /* 创建时间 */
        public AppClientBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        /* 创建人 */
        public AppClientBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }

        /* 创建人id */
        public AppClientBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        /* 更新时间 */
        public AppClientBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        /* 更新人 */
        public AppClientBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

        /* 更新人id */
        public AppClientBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

        public AppClient build() {
            return new AppClient(id, appCode, appType, appTitle, askUri, lanUri, icon, status, remarks, canDel, createTime, createUser, createUserId, updateTime, updateUser, updateUserId);
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAskUri(String askUri) {
        this.askUri = askUri;
    }

    public String getAskUri() {
        return askUri;
    }

    public void setLanUri(String lanUri) {
        this.lanUri = lanUri;
    }

    public String getLanUri() {
        return lanUri;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCanDel(String canDel) {
        this.canDel = canDel;
    }

    public String getCanDel() {
        return canDel;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("appCode", getAppCode()).append("appType", getAppType()).append("appTitle", getAppTitle()).append("askUri", getAskUri()).append("lanUri", getLanUri()).append("icon", getIcon()).append("status", getStatus()).append("remarks", getRemarks()).append("canDel", getCanDel()).append("createTime", getCreateTime()).append("createUser", getCreateUser()).append("createUserId", getCreateUserId()).append("updateTime", getUpdateTime()).append("updateUser", getUpdateUser()).append("updateUserId", getUpdateUserId()).toString();
    }


}
