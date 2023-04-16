package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 授权方的刷新令牌 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-16 17:39:59
 */
public class AuthorizedRefreshTokenDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 主键唯一标识 */
        private String id;


        /** 第三方平台id(服务提供商) */
        private String appId;


        /** 授权方appid(userId, openId) */
        private String authorizerAppid;


        /** 授权方令牌 */
        private String authorizerAccessToken;


        /** 有效期，单位：秒 */
        private Integer expiresIn;


        /** token过期时间 */
        private LocalDateTime expireTime;


        /** 授权方的刷新令牌 */
        private String authorizerRefreshToken;


        /** 秘钥 */
        private String secretKey;


        /** 权限集(希望重新建一张表存储) */
        private String funcInfo;


        /** 是否停止授权 1是 0否 */
        private String isCancel;


        /** 创建日期 */
        private LocalDateTime createTime;


        /** 更新时间 */
        private LocalDateTime updateTime;


    public AuthorizedRefreshTokenDto() {}

    public AuthorizedRefreshTokenDto(String id, String appId, String authorizerAppid, String authorizerAccessToken, Integer expiresIn, LocalDateTime expireTime, String authorizerRefreshToken, String secretKey, String funcInfo, String isCancel, LocalDateTime createTime, LocalDateTime updateTime) {
            this.id = id;
            this.appId = appId;
            this.authorizerAppid = authorizerAppid;
            this.authorizerAccessToken = authorizerAccessToken;
            this.expiresIn = expiresIn;
            this.expireTime = expireTime;
            this.authorizerRefreshToken = authorizerRefreshToken;
            this.secretKey = secretKey;
            this.funcInfo = funcInfo;
            this.isCancel = isCancel;
            this.createTime = createTime;
            this.updateTime = updateTime;
    }

    public static AuthorizedRefreshTokenDtoBuilder builder() {
        return new AuthorizedRefreshTokenDtoBuilder();
    }

    public static class AuthorizedRefreshTokenDtoBuilder {
            private String id;
            private String appId;
            private String authorizerAppid;
            private String authorizerAccessToken;
            private Integer expiresIn;
            private LocalDateTime expireTime;
            private String authorizerRefreshToken;
            private String secretKey;
            private String funcInfo;
            private String isCancel;
            private LocalDateTime createTime;
            private LocalDateTime updateTime;

        public AuthorizedRefreshTokenDtoBuilder() {}

            /* 主键唯一标识 */
            public AuthorizedRefreshTokenDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 第三方平台id(服务提供商) */
            public AuthorizedRefreshTokenDtoBuilder appId(String appId) {
                this.appId = appId;
                return this;
            }
            /* 授权方appid(userId, openId) */
            public AuthorizedRefreshTokenDtoBuilder authorizerAppid(String authorizerAppid) {
                this.authorizerAppid = authorizerAppid;
                return this;
            }
            /* 授权方令牌 */
            public AuthorizedRefreshTokenDtoBuilder authorizerAccessToken(String authorizerAccessToken) {
                this.authorizerAccessToken = authorizerAccessToken;
                return this;
            }
            /* 有效期，单位：秒 */
            public AuthorizedRefreshTokenDtoBuilder expiresIn(Integer expiresIn) {
                this.expiresIn = expiresIn;
                return this;
            }
            /* token过期时间 */
            public AuthorizedRefreshTokenDtoBuilder expireTime(LocalDateTime expireTime) {
                this.expireTime = expireTime;
                return this;
            }
            /* 授权方的刷新令牌 */
            public AuthorizedRefreshTokenDtoBuilder authorizerRefreshToken(String authorizerRefreshToken) {
                this.authorizerRefreshToken = authorizerRefreshToken;
                return this;
            }
            /* 秘钥 */
            public AuthorizedRefreshTokenDtoBuilder secretKey(String secretKey) {
                this.secretKey = secretKey;
                return this;
            }
            /* 权限集(希望重新建一张表存储) */
            public AuthorizedRefreshTokenDtoBuilder funcInfo(String funcInfo) {
                this.funcInfo = funcInfo;
                return this;
            }
            /* 是否停止授权 1是 0否 */
            public AuthorizedRefreshTokenDtoBuilder isCancel(String isCancel) {
                this.isCancel = isCancel;
                return this;
            }
            /* 创建日期 */
            public AuthorizedRefreshTokenDtoBuilder createTime(LocalDateTime createTime) {
                this.createTime = createTime;
                return this;
            }
            /* 更新时间 */
            public AuthorizedRefreshTokenDtoBuilder updateTime(LocalDateTime updateTime) {
                this.updateTime = updateTime;
                return this;
            }

        public AuthorizedRefreshTokenDto build() {
            return new AuthorizedRefreshTokenDto(id, appId, authorizerAppid, authorizerAccessToken, expiresIn, expireTime, authorizerRefreshToken, secretKey, funcInfo, isCancel, createTime, updateTime);
        }

    }



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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
            public void setAuthorizerAccessToken(String authorizerAccessToken) {
                this.authorizerAccessToken = authorizerAccessToken;
            }

            public String getAuthorizerAccessToken() {
                return authorizerAccessToken;
            }
            public void setExpiresIn(Integer expiresIn) {
                this.expiresIn = expiresIn;
            }

            public Integer getExpiresIn() {
                return expiresIn;
            }
            public void setExpireTime(LocalDateTime expireTime) {
                this.expireTime = expireTime;
            }

            public LocalDateTime getExpireTime() {
                return expireTime;
            }
            public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
                this.authorizerRefreshToken = authorizerRefreshToken;
            }

            public String getAuthorizerRefreshToken() {
                return authorizerRefreshToken;
            }
            public void setSecretKey(String secretKey) {
                this.secretKey = secretKey;
            }

            public String getSecretKey() {
                return secretKey;
            }
            public void setFuncInfo(String funcInfo) {
                this.funcInfo = funcInfo;
            }

            public String getFuncInfo() {
                return funcInfo;
            }
            public void setIsCancel(String isCancel) {
                this.isCancel = isCancel;
            }

            public String getIsCancel() {
                return isCancel;
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
                    .append("appId", getAppId())
                    .append("authorizerAppid", getAuthorizerAppid())
                    .append("authorizerAccessToken", getAuthorizerAccessToken())
                    .append("expiresIn", getExpiresIn())
                    .append("expireTime", getExpireTime())
                    .append("authorizerRefreshToken", getAuthorizerRefreshToken())
                    .append("secretKey", getSecretKey())
                    .append("funcInfo", getFuncInfo())
                    .append("isCancel", getIsCancel())
                    .append("createTime", getCreateTime())
                    .append("updateTime", getUpdateTime())
                .toString();
    }

}
