package com.github.itdachen.dashboard.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 登录错误日志 VO
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public class LoginErrorRecordVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    private String id;

    /**
     * 错误类型
     */
    private String errorType;

    /**
     * 会话ID(sessionId)
     */
    private String sessionId;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 错误密码
     */
    private String password;

    /**
     * 验证码
     */
    private String verificationCode;

    /**
     * 访问IP
     */
    private String ip;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 访问地址
     */
    private String accessAddress;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 客户端
     */
    private String clientId;


    public LoginErrorRecordVO() {
    }

    public LoginErrorRecordVO(String id, String errorType, String sessionId, String username, String password, String verificationCode, String ip, String message, String requestId, String os, String accessAddress, String browser, String clientId) {
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
    }

    public static LoginErrorRecordVOBuilder builder() {
        return new LoginErrorRecordVOBuilder();
    }

    public static class LoginErrorRecordVOBuilder {
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

        public LoginErrorRecordVOBuilder() {
        }

        /* 主键唯一标识 */
        public LoginErrorRecordVOBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 错误类型 */
        public LoginErrorRecordVOBuilder errorType(String errorType) {
            this.errorType = errorType;
            return this;
        }

        /* 会话ID(sessionId) */
        public LoginErrorRecordVOBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /* 登录账号 */
        public LoginErrorRecordVOBuilder username(String username) {
            this.username = username;
            return this;
        }

        /* 错误密码 */
        public LoginErrorRecordVOBuilder password(String password) {
            this.password = password;
            return this;
        }

        /* 验证码 */
        public LoginErrorRecordVOBuilder verificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        /* 访问IP */
        public LoginErrorRecordVOBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        /* 错误消息 */
        public LoginErrorRecordVOBuilder message(String message) {
            this.message = message;
            return this;
        }

        /* 请求ID */
        public LoginErrorRecordVOBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /* 操作系统 */
        public LoginErrorRecordVOBuilder os(String os) {
            this.os = os;
            return this;
        }

        /* 访问地址 */
        public LoginErrorRecordVOBuilder accessAddress(String accessAddress) {
            this.accessAddress = accessAddress;
            return this;
        }

        /* 浏览器 */
        public LoginErrorRecordVOBuilder browser(String browser) {
            this.browser = browser;
            return this;
        }

        /* 客户端 */
        public LoginErrorRecordVOBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public LoginErrorRecordVO build() {
            return new LoginErrorRecordVO(id,
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
                    clientId
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
                .toString();
    }

}
