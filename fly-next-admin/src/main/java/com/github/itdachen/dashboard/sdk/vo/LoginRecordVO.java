package com.github.itdachen.dashboard.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 登录日志 VO
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public class LoginRecordVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 访问ID
     */
    private String id;

    /**
     * 会话id
     */
    private String sessionId;

    /**
     * 客户端
     */
    private String clientId;

    /**
     * 登陆者姓名
     */
    private String nickname;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 登录IP地址
     */
    private String ip;

    /**
     * 登录地点
     */
    private String accessAddress;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 登录状态（0成功 1失败）
     */
    private String status;

    /**
     * 提示消息
     */
    private String msg;

    private LocalDateTime createTime;

    public LoginRecordVO() {
    }

    public LoginRecordVO(String id, String sessionId, String clientId, String nickname, String username, String ip, String accessAddress, String browser, String os, String status, String msg) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.nickname = nickname;
        this.username = username;
        this.ip = ip;
        this.accessAddress = accessAddress;
        this.browser = browser;
        this.os = os;
        this.status = status;
        this.msg = msg;
    }

    public static LoginRecordVOBuilder builder() {
        return new LoginRecordVOBuilder();
    }

    public static class LoginRecordVOBuilder {
        private String id;
        private String sessionId;
        private String clientId;
        private String nickname;
        private String username;
        private String ip;
        private String accessAddress;
        private String browser;
        private String os;
        private String status;
        private String msg;

        public LoginRecordVOBuilder() {
        }

        /* 访问ID */
        public LoginRecordVOBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 会话id */
        public LoginRecordVOBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /* 客户端 */
        public LoginRecordVOBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /* 登陆者姓名 */
        public LoginRecordVOBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        /* 登录账号 */
        public LoginRecordVOBuilder username(String username) {
            this.username = username;
            return this;
        }

        /* 登录IP地址 */
        public LoginRecordVOBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        /* 登录地点 */
        public LoginRecordVOBuilder accessAddress(String accessAddress) {
            this.accessAddress = accessAddress;
            return this;
        }

        /* 浏览器类型 */
        public LoginRecordVOBuilder browser(String browser) {
            this.browser = browser;
            return this;
        }

        /* 操作系统 */
        public LoginRecordVOBuilder os(String os) {
            this.os = os;
            return this;
        }

        /* 登录状态（0成功 1失败） */
        public LoginRecordVOBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 提示消息 */
        public LoginRecordVOBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public LoginRecordVO build() {
            return new LoginRecordVO(id,
                    sessionId,
                    clientId,
                    nickname,
                    username,
                    ip,
                    accessAddress,
                    browser,
                    os,
                    status,
                    msg
            );
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setAccessAddress(String accessAddress) {
        this.accessAddress = accessAddress;
    }

    public String getAccessAddress() {
        return accessAddress;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sessionId", getSessionId())
                .append("clientId", getClientId())
                .append("nickname", getNickname())
                .append("username", getUsername())
                .append("ip", getIp())
                .append("accessAddress", getAccessAddress())
                .append("browser", getBrowser())
                .append("os", getOs())
                .append("status", getStatus())
                .append("msg", getMsg())
                .append("createTime", getCreateTime())
                .toString();
    }

}
