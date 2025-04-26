package com.github.itdachen.auth.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 第三方登录信息表
 *
 * @author 王大宸
 * @date 2025-04-27 00:15:47
 */
@Table(name = "ta_fly_login_connection")
public class LoginConnection implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 系统用户ID(第三方关联时,系统的用户ID)
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 服务提供商提供的id,例如: 微信小程序
     */
    @Column(name = "provider_id")
    private String providerId;

    /**
     * 服务提供商提供的用户id(openId)
     */
    @Column(name = "provider_user_id")
    private String providerUserId;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 配置地址
     */
    @Column(name = "profile_url")
    private String profileUrl;

    /**
     * 头像地址
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 秘钥
     */
    @Column(name = "secret_key")
    private String secretKey;

    /**
     * 接口访问凭证
     */
    @Column(name = "access_token")
    private String accessToken;

    /**
     * 刷新令牌
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 过期时间
     */
    @Column(name = "expire_time")
    private LocalDateTime expireTime;


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

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("providerId", getProviderId())
                .append("providerUserId", getProviderUserId())
                .append("nickname", getNickname())
                .append("profileUrl", getProfileUrl())
                .append("imageUrl", getImageUrl())
                .append("secretKey", getSecretKey())
                .append("accessToken", getAccessToken())
                .append("refreshToken", getRefreshToken())
                .append("expireTime", getExpireTime())
                .toString();
    }


}
