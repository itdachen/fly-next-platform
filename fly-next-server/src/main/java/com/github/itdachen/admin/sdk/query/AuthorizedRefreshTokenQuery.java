package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 授权方的刷新令牌 查询参数
 *
 * @author 王大宸
 * @date 2023-04-16 17:39:59
 */
public class AuthorizedRefreshTokenQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 第三方平台id(服务提供商)
     */
    private String appId;

    /**
     * 授权方appid(userId, openId)
     */
    private String authorizerAppid;

    /**
     * 是否停止授权 1是 0否
     */
    private String isCancel;


    public AuthorizedRefreshTokenQuery() {
    }

    public AuthorizedRefreshTokenQuery(int page, int limit, String appId, String authorizerAppid, String isCancel) {
        super(page, limit);
        this.appId = appId;
        this.authorizerAppid = authorizerAppid;
        this.isCancel = isCancel;
    }

    public static AuthorizedRefreshTokenQueryBuilder builder() {
        return new AuthorizedRefreshTokenQueryBuilder();
    }

    public static class AuthorizedRefreshTokenQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String appId;
        private String authorizerAppid;
        private String isCancel;

        public AuthorizedRefreshTokenQueryBuilder() {
        }

        public AuthorizedRefreshTokenQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AuthorizedRefreshTokenQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 第三方平台id(服务提供商) */
        public AuthorizedRefreshTokenQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 授权方appid(userId, openId) */
        public AuthorizedRefreshTokenQueryBuilder authorizerAppid(String authorizerAppid) {
            this.authorizerAppid = authorizerAppid;
            return this;
        }

        /* 是否停止授权 1是 0否 */
        public AuthorizedRefreshTokenQueryBuilder isCancel(String isCancel) {
            this.isCancel = isCancel;
            return this;
        }

        public AuthorizedRefreshTokenQuery build() {
            return new AuthorizedRefreshTokenQuery(page, limit, appId, authorizerAppid, isCancel);
        }

    }


    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    public String getIsCancel() {
        return isCancel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("appId", getAppId())
                .append("authorizerAppid", getAuthorizerAppid())
                .append("isCancel", getIsCancel())
                .toString();
    }

}
