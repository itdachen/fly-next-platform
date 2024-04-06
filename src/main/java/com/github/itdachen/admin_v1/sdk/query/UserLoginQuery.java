package com.github.itdachen.admin_v1.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 第三方登录信息关联(用户登录表) 查询参数
 *
 * @author 王大宸
 * @date 2023-04-16 17:39:59
 */
public class UserLoginQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 删除标志(1-已删除;0-未删除)
     */
    private String delFlag;

    /**
     * 是否可删除(0-不可删除;1-可删除)
     */
    private String canDel;


    public UserLoginQuery() {
    }

    public UserLoginQuery(int page, int limit, String userId, String tenantId, String appId, String openId, String username, String status, String userType, String nickName, String delFlag, String canDel) {
        super(page, limit);
        this.userId = userId;
        this.tenantId = tenantId;
        this.appId = appId;
        this.openId = openId;
        this.username = username;
        this.status = status;
        this.userType = userType;
        this.nickName = nickName;
        this.delFlag = delFlag;
        this.canDel = canDel;
    }

    public static UserLoginQueryBuilder builder() {
        return new UserLoginQueryBuilder();
    }

    public static class UserLoginQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String userId;
        private String tenantId;
        private String appId;
        private String openId;
        private String username;
        private String status;
        private String userType;
        private String nickName;
        private String delFlag;
        private String canDel;

        public UserLoginQueryBuilder() {
        }

        public UserLoginQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public UserLoginQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 系统用户ID(第三方关联时,系统的用户ID) */
        public UserLoginQueryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 租户ID */
        public UserLoginQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 服务提供商提供的id,例如: 微信,系统,支付宝,抖音等 */
        public UserLoginQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 服务提供商提供的用户id, 例如: openid,unionid, username等 */
        public UserLoginQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        /* 登录账号 */
        public UserLoginQueryBuilder username(String username) {
            this.username = username;
            return this;
        }

        /* 用户状态(1-正常;0-冻结) */
        public UserLoginQueryBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 用户类型 */
        public UserLoginQueryBuilder userType(String userType) {
            this.userType = userType;
            return this;
        }

        /* 昵称(用户姓名) */
        public UserLoginQueryBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        /* 删除标志(1-已删除;0-未删除) */
        public UserLoginQueryBuilder delFlag(String delFlag) {
            this.delFlag = delFlag;
            return this;
        }

        /* 是否可删除(0-不可删除;1-可删除) */
        public UserLoginQueryBuilder canDel(String canDel) {
            this.canDel = canDel;
            return this;
        }

        public UserLoginQuery build() {
            return new UserLoginQuery(page, limit, userId, tenantId, appId, openId, username, status, userType, nickName, delFlag, canDel);
        }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("userId", getUserId())
                .append("tenantId", getTenantId())
                .append("appId", getAppId())
                .append("openId", getOpenId())
                .append("username", getUsername())
                .append("status", getStatus())
                .append("userType", getUserType())
                .append("nickName", getNickName())
                .append("delFlag", getDelFlag())
                .append("canDel", getCanDel())
                .toString();
    }

}
