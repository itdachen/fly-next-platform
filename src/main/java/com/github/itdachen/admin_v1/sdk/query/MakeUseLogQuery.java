package com.github.itdachen.admin_v1.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 日志表 查询参数
 *
 * @author 王大宸
 * @date 2023-04-06 22:00:57
 */
public class MakeUseLogQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 租户id */
    private String tenantId;

    /** 服务ID */
    private String serviceId;

    /** 客户端id: PC端, 微程序, APP等  */
    private String clientId;

    /** http 请求id */
    private String requestId;

    /** 日志标题: 用户管理, 菜单管理等 */
    private String menuTitle;

    /** 操作类型: 新增, 修改, 删除, 查看 */
    private String makeUseType;

    /** 日志类型: button-按钮, uri-链接 */
    private String logType;

    /** 操作IP地址 */
    private String makeUseIp;

    /** 操作地址 */
    private String makeUseAddress;

    /** 操作状态: 成功, 失败, 异常 */
    private String makeUseStatus;

    /** 用户代理 */
    private String userAgent;

    /** 请求URI */
    private String requestUri;

    /** 操作方式 */
    private String requestMethod;

    /** 操作提交的数据 */
    private String params;

    /** 返回数据 */
    private String jsonResult;

    /** 删除标记 */
    private String delFlag;

    /** 异常信息 */
    private String exception;

    /** 服务端处理耗时 */
    private String executeTime;

    /** 返回消息 */
    private String msg;


    public MakeUseLogQuery() {
    }

    public MakeUseLogQuery(int page, int limit, String tenantId, String serviceId, String clientId, String requestId, String menuTitle, String makeUseType, String logType, String makeUseIp, String makeUseAddress, String makeUseStatus, String userAgent, String requestUri, String requestMethod, String params, String jsonResult, String delFlag, String exception, String executeTime, String msg) {
        super(page, limit);
        this.tenantId = tenantId;
        this.serviceId = serviceId;
        this.clientId = clientId;
        this.requestId = requestId;
        this.menuTitle = menuTitle;
        this.makeUseType = makeUseType;
        this.logType = logType;
        this.makeUseIp = makeUseIp;
        this.makeUseAddress = makeUseAddress;
        this.makeUseStatus = makeUseStatus;
        this.userAgent = userAgent;
        this.requestUri = requestUri;
        this.requestMethod = requestMethod;
        this.params = params;
        this.jsonResult = jsonResult;
        this.delFlag = delFlag;
        this.exception = exception;
        this.executeTime = executeTime;
        this.msg = msg;
    }

    public static MakeUseLogQueryBuilder builder() {
        return new MakeUseLogQueryBuilder();
    }

    public static class MakeUseLogQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String serviceId;
        private String clientId;
        private String requestId;
        private String menuTitle;
        private String makeUseType;
        private String logType;
        private String makeUseIp;
        private String makeUseAddress;
        private String makeUseStatus;
        private String userAgent;
        private String requestUri;
        private String requestMethod;
        private String params;
        private String jsonResult;
        private String delFlag;
        private String exception;
        private String executeTime;
        private String msg;

        public MakeUseLogQueryBuilder() {
        }

        public MakeUseLogQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public MakeUseLogQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户id */
        public MakeUseLogQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 服务ID */
        public MakeUseLogQueryBuilder serviceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }
        /* 客户端id: PC端, 微程序, APP等  */
        public MakeUseLogQueryBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        /* http 请求id */
        public MakeUseLogQueryBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }
        /* 日志标题: 用户管理, 菜单管理等 */
        public MakeUseLogQueryBuilder menuTitle(String menuTitle) {
            this.menuTitle = menuTitle;
            return this;
        }
        /* 操作类型: 新增, 修改, 删除, 查看 */
        public MakeUseLogQueryBuilder makeUseType(String makeUseType) {
            this.makeUseType = makeUseType;
            return this;
        }
        /* 日志类型: button-按钮, uri-链接 */
        public MakeUseLogQueryBuilder logType(String logType) {
            this.logType = logType;
            return this;
        }
        /* 操作IP地址 */
        public MakeUseLogQueryBuilder makeUseIp(String makeUseIp) {
            this.makeUseIp = makeUseIp;
            return this;
        }
        /* 操作地址 */
        public MakeUseLogQueryBuilder makeUseAddress(String makeUseAddress) {
            this.makeUseAddress = makeUseAddress;
            return this;
        }
        /* 操作状态: 成功, 失败, 异常 */
        public MakeUseLogQueryBuilder makeUseStatus(String makeUseStatus) {
            this.makeUseStatus = makeUseStatus;
            return this;
        }
        /* 用户代理 */
        public MakeUseLogQueryBuilder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }
        /* 请求URI */
        public MakeUseLogQueryBuilder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }
        /* 操作方式 */
        public MakeUseLogQueryBuilder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }
        /* 操作提交的数据 */
        public MakeUseLogQueryBuilder params(String params) {
            this.params = params;
            return this;
        }
        /* 返回数据 */
        public MakeUseLogQueryBuilder jsonResult(String jsonResult) {
            this.jsonResult = jsonResult;
            return this;
        }
        /* 删除标记 */
        public MakeUseLogQueryBuilder delFlag(String delFlag) {
            this.delFlag = delFlag;
            return this;
        }
        /* 异常信息 */
        public MakeUseLogQueryBuilder exception(String exception) {
            this.exception = exception;
            return this;
        }
        /* 服务端处理耗时 */
        public MakeUseLogQueryBuilder executeTime(String executeTime) {
            this.executeTime = executeTime;
            return this;
        }
        /* 返回消息 */
        public MakeUseLogQueryBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public MakeUseLogQuery build() {
            return new MakeUseLogQuery(page, limit, tenantId, serviceId, clientId, requestId, menuTitle, makeUseType, logType, makeUseIp, makeUseAddress, makeUseStatus, userAgent, requestUri, requestMethod, params, jsonResult, delFlag, exception, executeTime, msg);
        }

    }




    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMakeUseType(String makeUseType) {
        this.makeUseType = makeUseType;
    }

    public String getMakeUseType() {
        return makeUseType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogType() {
        return logType;
    }

    public void setMakeUseIp(String makeUseIp) {
        this.makeUseIp = makeUseIp;
    }

    public String getMakeUseIp() {
        return makeUseIp;
    }

    public void setMakeUseAddress(String makeUseAddress) {
        this.makeUseAddress = makeUseAddress;
    }

    public String getMakeUseAddress() {
        return makeUseAddress;
    }

    public void setMakeUseStatus(String makeUseStatus) {
        this.makeUseStatus = makeUseStatus;
    }

    public String getMakeUseStatus() {
        return makeUseStatus;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParams() {
        return params;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getExecuteTime() {
        return executeTime;
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
                .append("tenantId", getTenantId())
                .append("serviceId", getServiceId())
                .append("clientId", getClientId())
                .append("requestId", getRequestId())
                .append("menuTitle", getMenuTitle())
                .append("makeUseType", getMakeUseType())
                .append("logType", getLogType())
                .append("makeUseIp", getMakeUseIp())
                .append("makeUseAddress", getMakeUseAddress())
                .append("makeUseStatus", getMakeUseStatus())
                .append("userAgent", getUserAgent())
                .append("requestUri", getRequestUri())
                .append("requestMethod", getRequestMethod())
                .append("params", getParams())
                .append("jsonResult", getJsonResult())
                .append("delFlag", getDelFlag())
                .append("exception", getException())
                .append("executeTime", getExecuteTime())
                .append("msg", getMsg())
                .toString();
    }

}
