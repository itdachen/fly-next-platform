package com.github.itdachen.dashboard.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 登录日志 查询参数
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public class LoginRecordQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 会话id */
            private String sessionId;

            /** 客户端 */
            private String clientId;

            /** 登陆者姓名 */
            private String nickname;

            /** 登录账号 */
            private String username;

            /** 登录IP地址 */
            private String ip;

            /** 登录地点 */
            private String accessAddress;

            /** 浏览器类型 */
            private String browser;

            /** 操作系统 */
            private String os;

            /** 登录状态（0成功 1失败） */
            private String status;

            /** 提示消息 */
            private String msg;


    public LoginRecordQuery() {
    }

    public LoginRecordQuery(int page, int limit, String sessionId, String clientId, String nickname, String username, String ip, String accessAddress, String browser, String os, String status, String msg) {
        super(page, limit);
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

    public static LoginRecordQueryBuilder builder() {
        return new LoginRecordQueryBuilder();
    }

    public static class LoginRecordQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
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

        public LoginRecordQueryBuilder() {
        }

        public LoginRecordQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public LoginRecordQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 会话id */
            public LoginRecordQueryBuilder sessionId(String sessionId) {
                this.sessionId = sessionId;
                return this;
            }
            /* 客户端 */
            public LoginRecordQueryBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }
            /* 登陆者姓名 */
            public LoginRecordQueryBuilder nickname(String nickname) {
                this.nickname = nickname;
                return this;
            }
            /* 登录账号 */
            public LoginRecordQueryBuilder username(String username) {
                this.username = username;
                return this;
            }
            /* 登录IP地址 */
            public LoginRecordQueryBuilder ip(String ip) {
                this.ip = ip;
                return this;
            }
            /* 登录地点 */
            public LoginRecordQueryBuilder accessAddress(String accessAddress) {
                this.accessAddress = accessAddress;
                return this;
            }
            /* 浏览器类型 */
            public LoginRecordQueryBuilder browser(String browser) {
                this.browser = browser;
                return this;
            }
            /* 操作系统 */
            public LoginRecordQueryBuilder os(String os) {
                this.os = os;
                return this;
            }
            /* 登录状态（0成功 1失败） */
            public LoginRecordQueryBuilder status(String status) {
                this.status = status;
                return this;
            }
            /* 提示消息 */
            public LoginRecordQueryBuilder msg(String msg) {
                this.msg = msg;
                return this;
            }

        public LoginRecordQuery build() {
            return new LoginRecordQuery(page, limit, sessionId, clientId, nickname, username, ip, accessAddress, browser, os, status, msg);
        }

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
        .append("page", getPage())
        .append("limit", getLimit())
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
