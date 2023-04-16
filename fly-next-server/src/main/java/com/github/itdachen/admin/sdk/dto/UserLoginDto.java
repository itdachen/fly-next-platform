package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 第三方登录信息关联(用户登录表) 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-16 17:39:59
 */
public class UserLoginDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键唯一标识(userId)
     */
    private String id;


    /**
     * 系统用户ID(第三方关联时,系统的用户ID)
     */
    private String userId;


    /**
     * 租户ID
     */
    private String tenantId;


    /**
     * 服务提供商提供的id,例如: 微信,系统,支付宝,抖音等
     */
    private String appId;


    /**
     * 服务提供商提供的用户id, 例如: openid,unionid, username等
     */
    private String openId;


    /**
     * 登录账号
     */
    private String username;


    /**
     * 登录密码
     */
    private String password;


    /**
     * 用户状态(1-正常;0-冻结)
     */
    private String status;


    /**
     * 用户类型
     */
    private String userType;


    /**
     * 昵称(用户姓名)
     */
    private String nickName;


    /**
     * 配置地址
     */
    private String profileUrl;


    /**
     * 头像地址
     */
    private String avatar;


    /**
     * 删除标志(1-已删除;0-未删除)
     */
    private String delFlag;


    /**
     * 是否可删除(0-不可删除;1-可删除)
     */
    private String canDel;


    /**
     * 过期时间(密码过期时间, 有些系统需要定期更新账号的密码)
     */
    private LocalDateTime expireTime;


    /**
     * 创建日期
     */
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    public UserLoginDto() {
    }

    public UserLoginDto(String id, String userId, String tenantId, String appId, String openId, String username, String password, String status, String userType, String nickName, String profileUrl, String avatar, String delFlag, String canDel, LocalDateTime expireTime, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.userId = userId;
        this.tenantId = tenantId;
        this.appId = appId;
        this.openId = openId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.userType = userType;
        this.nickName = nickName;
        this.profileUrl = profileUrl;
        this.avatar = avatar;
        this.delFlag = delFlag;
        this.canDel = canDel;
        this.expireTime = expireTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public static UserLoginDtoBuilder builder() {
        return new UserLoginDtoBuilder();
    }

    public static class UserLoginDtoBuilder {
        private String id;
        private String userId;
        private String tenantId;
        private String appId;
        private String openId;
        private String username;
        private String password;
        private String status;
        private String userType;
        private String nickName;
        private String profileUrl;
        private String avatar;
        private String delFlag;
        private String canDel;
        private LocalDateTime expireTime;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;

        public UserLoginDtoBuilder() {
        }

        /* 主键唯一标识(userId) */
        public UserLoginDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 系统用户ID(第三方关联时,系统的用户ID) */
        public UserLoginDtoBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 租户ID */
        public UserLoginDtoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 服务提供商提供的id,例如: 微信,系统,支付宝,抖音等 */
        public UserLoginDtoBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 服务提供商提供的用户id, 例如: openid,unionid, username等 */
        public UserLoginDtoBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        /* 登录账号 */
        public UserLoginDtoBuilder username(String username) {
            this.username = username;
            return this;
        }

        /* 登录密码 */
        public UserLoginDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        /* 用户状态(1-正常;0-冻结) */
        public UserLoginDtoBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 用户类型 */
        public UserLoginDtoBuilder userType(String userType) {
            this.userType = userType;
            return this;
        }

        /* 昵称(用户姓名) */
        public UserLoginDtoBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        /* 配置地址 */
        public UserLoginDtoBuilder profileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
            return this;
        }

        /* 头像地址 */
        public UserLoginDtoBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        /* 删除标志(1-已删除;0-未删除) */
        public UserLoginDtoBuilder delFlag(String delFlag) {
            this.delFlag = delFlag;
            return this;
        }

        /* 是否可删除(0-不可删除;1-可删除) */
        public UserLoginDtoBuilder canDel(String canDel) {
            this.canDel = canDel;
            return this;
        }

        /* 过期时间(密码过期时间, 有些系统需要定期更新账号的密码) */
        public UserLoginDtoBuilder expireTime(LocalDateTime expireTime) {
            this.expireTime = expireTime;
            return this;
        }

        /* 创建日期 */
        public UserLoginDtoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        /* 更新时间 */
        public UserLoginDtoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public UserLoginDto build() {
            return new UserLoginDto(id, userId, tenantId, appId, openId, username, password, status, userType, nickName, profileUrl, avatar, delFlag, canDel, expireTime, createTime, updateTime);
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setCanDel(String canDel) {
        this.canDel = canDel;
    }

    public String getCanDel() {
        return canDel;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("openId", getOpenId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("status", getStatus())
                .append("userType", getUserType())
                .append("nickName", getNickName())
                .append("profileUrl", getProfileUrl())
                .append("avatar", getAvatar())
                .append("delFlag", getDelFlag())
                .append("canDel", getCanDel())
                .append("expireTime", getExpireTime())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
