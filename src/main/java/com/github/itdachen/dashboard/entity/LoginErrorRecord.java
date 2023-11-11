package com.github.itdachen.dashboard.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 登录错误日志
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
@Table(name = "sys_login_error_record")
public class LoginErrorRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 错误类型
     */
    @Column(name = "error_type")
    private String errorType;

    /**
     * 会话ID(sessionId)
     */
    @Column(name = "session_id")
    private String sessionId;

    /**
     * 登录账号
     */
    @Column(name = "username")
    private String username;

    /**
     * 错误密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 验证码
     */
    @Column(name = "verification_code")
    private String verificationCode;

    /**
     * 访问IP
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 错误消息
     */
    @Column(name = "message")
    private String message;

    /**
     * 请求ID
     */
    @Column(name = "request_id")
    private String requestId;

    /**
     * 操作系统
     */
    @Column(name = "os")
    private String os;

    /**
     * 访问地址
     */
    @Column(name = "access_address")
    private String accessAddress;

    /**
     * 浏览器
     */
    @Column(name = "browser")
    private String browser;

    /**
     * 客户端
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * 访问时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;


    public LoginErrorRecord() {
    }


    public LoginErrorRecord(String id, String errorType, String sessionId, String username, String password, String verificationCode, String ip, String message, String requestId, String os, String accessAddress, String browser, String clientId, LocalDateTime createTime) {
        this.id = id;
        this.errorType = errorType;
        this.sessionId = sessionId;
        this.username = username;
        this.password = password;
        this.verificationCode = verificationCode;
        this.ip = ip;
        this.message = message;
        this.requestId = requestId;
        this.os = os;
        this.accessAddress = accessAddress;
        this.browser = browser;
        this.clientId = clientId;
        this.createTime = createTime;
    }

    public static LoginErrorRecordBuilder builder() {
        return new LoginErrorRecordBuilder();
    }

    public static class LoginErrorRecordBuilder {
        private String id;
        private String errorType;
        private String sessionId;
        private String username;
        private String password;
        private String verificationCode;
        private String ip;
        private String message;
        private String requestId;
        private String os;
        private String accessAddress;
        private String browser;
        private String clientId;
        private LocalDateTime createTime;

        public LoginErrorRecordBuilder() {
        }

        /* 主键唯一标识 */
        public LoginErrorRecordBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 错误类型 */
        public LoginErrorRecordBuilder errorType(String errorType) {
            this.errorType = errorType;
            return this;
        }

        /* 会话ID(sessionId) */
        public LoginErrorRecordBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /* 登录账号 */
        public LoginErrorRecordBuilder username(String username) {
            this.username = username;
            return this;
        }

        /* 错误密码 */
        public LoginErrorRecordBuilder password(String password) {
            this.password = password;
            return this;
        }

        /* 验证码 */
        public LoginErrorRecordBuilder verificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        /* 访问IP */
        public LoginErrorRecordBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        /* 错误消息 */
        public LoginErrorRecordBuilder message(String message) {
            this.message = message;
            return this;
        }

        /* 请求ID */
        public LoginErrorRecordBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /* 操作系统 */
        public LoginErrorRecordBuilder os(String os) {
            this.os = os;
            return this;
        }

        /* 访问地址 */
        public LoginErrorRecordBuilder accessAddress(String accessAddress) {
            this.accessAddress = accessAddress;
            return this;
        }

        /* 浏览器 */
        public LoginErrorRecordBuilder browser(String browser) {
            this.browser = browser;
            return this;
        }

        /* 客户端 */
        public LoginErrorRecordBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /* 访问时间 */
        public LoginErrorRecordBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        public LoginErrorRecord build() {
            return new LoginErrorRecord(id,
                    errorType,
                    sessionId,
                    username,
                    password,
                    verificationCode,
                    ip,
                    message,
                    requestId,
                    os,
                    accessAddress,
                    browser,
                    clientId,
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

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
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

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
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

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
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
                .append("errorType", getErrorType())
                .append("sessionId", getSessionId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("verificationCode", getVerificationCode())
                .append("ip", getIp())
                .append("message", getMessage())
                .append("requestId", getRequestId())
                .append("os", getOs())
                .append("accessAddress", getAccessAddress())
                .append("browser", getBrowser())
                .append("clientId", getClientId())
                .append("createTime", getCreateTime())
                .toString();
    }


}
