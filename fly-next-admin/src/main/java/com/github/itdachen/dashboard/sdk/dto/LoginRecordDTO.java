package com.github.itdachen.dashboard.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 登录日志 DTO
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public class LoginRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 访问ID */
        private String id;

        /** 会话id */
 @NotBlank(message = "会话id不能为空")
        private String sessionId;

        /** 客户端 */
 @NotBlank(message = "客户端不能为空")
        private String clientId;

        /** 登陆者姓名 */
 @NotBlank(message = "登陆者姓名不能为空")
        private String nickname;

        /** 登录账号 */
 @NotBlank(message = "登录账号不能为空")
        private String username;

        /** 登录IP地址 */
 @NotBlank(message = "登录IP地址不能为空")
        private String ip;

        /** 登录地点 */
 @NotBlank(message = "登录地点不能为空")
        private String accessAddress;

        /** 浏览器类型 */
 @NotBlank(message = "浏览器类型不能为空")
        private String browser;

        /** 操作系统 */
 @NotBlank(message = "操作系统不能为空")
        private String os;

        /** 登录状态（0成功 1失败） */
 @NotBlank(message = "登录状态（0成功 1失败）不能为空")
        private String status;

        /** 提示消息 */
 @NotBlank(message = "提示消息不能为空")
        private String msg;


    public LoginRecordDTO() {}

    public LoginRecordDTO(String id, String sessionId, String clientId, String nickname, String username, String ip, String accessAddress, String browser, String os, String status, String msg) {
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

    public static LoginRecordDTOBuilder builder() {
        return new LoginRecordDTOBuilder();
    }

    public static class LoginRecordDTOBuilder {
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

        public LoginRecordDTOBuilder() {}

            /* 访问ID */
            public LoginRecordDTOBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 会话id */
            public LoginRecordDTOBuilder sessionId(String sessionId) {
                this.sessionId = sessionId;
                return this;
            }
            /* 客户端 */
            public LoginRecordDTOBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }
            /* 登陆者姓名 */
            public LoginRecordDTOBuilder nickname(String nickname) {
                this.nickname = nickname;
                return this;
            }
            /* 登录账号 */
            public LoginRecordDTOBuilder username(String username) {
                this.username = username;
                return this;
            }
            /* 登录IP地址 */
            public LoginRecordDTOBuilder ip(String ip) {
                this.ip = ip;
                return this;
            }
            /* 登录地点 */
            public LoginRecordDTOBuilder accessAddress(String accessAddress) {
                this.accessAddress = accessAddress;
                return this;
            }
            /* 浏览器类型 */
            public LoginRecordDTOBuilder browser(String browser) {
                this.browser = browser;
                return this;
            }
            /* 操作系统 */
            public LoginRecordDTOBuilder os(String os) {
                this.os = os;
                return this;
            }
            /* 登录状态（0成功 1失败） */
            public LoginRecordDTOBuilder status(String status) {
                this.status = status;
                return this;
            }
            /* 提示消息 */
            public LoginRecordDTOBuilder msg(String msg) {
                this.msg = msg;
                return this;
            }

        public LoginRecordDTO build() {
            return new LoginRecordDTO(id, sessionId, clientId, nickname, username, ip, accessAddress, browser, os, status, msg);
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
                .toString();
    }

}
