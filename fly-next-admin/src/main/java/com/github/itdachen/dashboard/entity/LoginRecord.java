package com.github.itdachen.dashboard.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 登录日志
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
@Table(name = "sys_login_record")
public class LoginRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 访问ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 会话id
     */
    @Column(name = "session_id")
    private String sessionId;

    /**
     * 客户端
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * 登陆者姓名
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 登录放肆
     */
    @Column(name = "sign_method")
    private String signMethod;

    /**
     * 登录账号
     */
    @Column(name = "username")
    private String username;

    /**
     * 登录IP地址
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 登录地点
     */
    @Column(name = "access_address")
    private String accessAddress;

    /**
     * 浏览器类型
     */
    @Column(name = "browser")
    private String browser;

    /**
     * 操作系统
     */
    @Column(name = "os")
    private String os;

    /**
     * 登录状态（0成功 1失败）
     */
    @Column(name = "status")
    private String status;

    /**
     * 提示消息
     */
    @Column(name = "msg")
    private String msg;

    /**
     * 访问时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;


    public LoginRecord() {
    }


    public LoginRecord(String id, String sessionId, String clientId, String nickname, String signMethod, String username, String ip, String accessAddress, String browser, String os, String status, String msg, LocalDateTime createTime) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.nickname = nickname;
        this.signMethod = signMethod;
        this.username = username;
        this.ip = ip;
        this.accessAddress = accessAddress;
        this.browser = browser;
        this.os = os;
        this.status = status;
        this.msg = msg;
        this.createTime = createTime;
    }

    public static LoginRecordBuilder builder() {
        return new LoginRecordBuilder();
    }

    public static class LoginRecordBuilder {
        private String id;
        private String sessionId;
        private String clientId;
        private String nickname;
        private String signMethod;
        private String username;
        private String ip;
        private String accessAddress;
        private String browser;
        private String os;
        private String status;
        private String msg;
        private LocalDateTime createTime;

        public LoginRecordBuilder() {
        }

        /* 访问ID */
        public LoginRecordBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 会话id */
        public LoginRecordBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /* 客户端 */
        public LoginRecordBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /* 登陆者姓名 */
        public LoginRecordBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        /* 登录放肆 */
        public LoginRecordBuilder signMethod(String signMethod) {
            this.signMethod = signMethod;
            return this;
        }

        /* 登录账号 */
        public LoginRecordBuilder username(String username) {
            this.username = username;
            return this;
        }

        /* 登录IP地址 */
        public LoginRecordBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        /* 登录地点 */
        public LoginRecordBuilder accessAddress(String accessAddress) {
            this.accessAddress = accessAddress;
            return this;
        }

        /* 浏览器类型 */
        public LoginRecordBuilder browser(String browser) {
            this.browser = browser;
            return this;
        }

        /* 操作系统 */
        public LoginRecordBuilder os(String os) {
            this.os = os;
            return this;
        }

        /* 登录状态（0成功 1失败） */
        public LoginRecordBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 提示消息 */
        public LoginRecordBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        /* 访问时间 */
        public LoginRecordBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        public LoginRecord build() {
            return new LoginRecord(id,
                    sessionId,
                    clientId,
                    nickname,
                    signMethod,
                    username,
                    ip,
                    accessAddress,
                    browser,
                    os,
                    status,
                    msg,
                    createTime
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

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getSignMethod() {
        return signMethod;
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

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sessionId", getSessionId())
                .append("clientId", getClientId())
                .append("nickname", getNickname())
                .append("signMethod", getSignMethod())
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
