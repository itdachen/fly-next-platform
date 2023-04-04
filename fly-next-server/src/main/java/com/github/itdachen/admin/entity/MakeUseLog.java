package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
    import java.time.LocalDateTime;



/**
 * 日志表
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:45
 */
@Table(name = "sys_make_use_log")
public class MakeUseLog implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户id */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 服务ID */
    @Column(name = "service_id")
    private String serviceId;

    /** 客户端id: PC端, 微程序, APP等  */
    @Column(name = "client_id")
    private String clientId;

    /** http 请求id */
    @Column(name = "request_id")
    private String requestId;

    /** 日志标题: 用户管理, 菜单管理等 */
    @Column(name = "menu_title")
    private String menuTitle;

    /** 操作类型: 新增, 修改, 删除, 查看 */
    @Column(name = "make_use_type")
    private String makeUseType;

    /** 日志类型: button-按钮, uri-链接 */
    @Column(name = "log_type")
    private String logType;

    /** 操作IP地址 */
    @Column(name = "make_use_ip")
    private String makeUseIp;

    /** 操作地址 */
    @Column(name = "make_use_address")
    private String makeUseAddress;

    /** 操作状态: 成功, 失败, 异常 */
    @Column(name = "make_use_status")
    private String makeUseStatus;

    /** 用户代理 */
    @Column(name = "user_agent")
    private String userAgent;

    /** 请求URI */
    @Column(name = "request_uri")
    private String requestUri;

    /** 操作方式 */
    @Column(name = "request_method")
    private String requestMethod;

    /** 操作提交的数据 */
    @Column(name = "params")
    private String params;

    /** 返回数据 */
    @Column(name = "json_result")
    private String jsonResult;

    /** 删除标记 */
    @Column(name = "del_flag")
    private String delFlag;

    /** 异常信息 */
    @Column(name = "exception")
    private String exception;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 服务端处理耗时 */
    @Column(name = "execute_time")
    private String executeTime;

    /** 返回消息 */
    @Column(name = "msg")
    private String msg;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId;


public MakeUseLog(){}


public MakeUseLog(    String id,     String tenantId,     String serviceId,     String clientId,     String requestId,     String menuTitle,     String makeUseType,     String logType,     String makeUseIp,     String makeUseAddress,     String makeUseStatus,     String userAgent,     String requestUri,     String requestMethod,     String params,     String jsonResult,     String delFlag,     String exception,     String remarks,     String executeTime,     String msg,     LocalDateTime createTime,     String createUser,     String createUserId,     LocalDateTime updateTime,     String updateUser,     String updateUserId){
            this.id = id;
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
            this.remarks = remarks;
            this.executeTime = executeTime;
            this.msg = msg;
            this.createTime = createTime;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.updateTime = updateTime;
            this.updateUser = updateUser;
            this.updateUserId = updateUserId;
}

public static MakeUseLogBuilder builder(){
        return new MakeUseLogBuilder();
        }

public static class MakeUseLogBuilder {
        private String id;
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
        private String remarks;
        private String executeTime;
        private String msg;
        private LocalDateTime createTime;
        private String createUser;
        private String createUserId;
        private LocalDateTime updateTime;
        private String updateUser;
        private String updateUserId;

    public MakeUseLogBuilder() {
    }

        /* 主键唯一标识 */
        public MakeUseLogBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 租户id */
        public MakeUseLogBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 服务ID */
        public MakeUseLogBuilder serviceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }
        /* 客户端id: PC端, 微程序, APP等  */
        public MakeUseLogBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        /* http 请求id */
        public MakeUseLogBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }
        /* 日志标题: 用户管理, 菜单管理等 */
        public MakeUseLogBuilder menuTitle(String menuTitle) {
            this.menuTitle = menuTitle;
            return this;
        }
        /* 操作类型: 新增, 修改, 删除, 查看 */
        public MakeUseLogBuilder makeUseType(String makeUseType) {
            this.makeUseType = makeUseType;
            return this;
        }
        /* 日志类型: button-按钮, uri-链接 */
        public MakeUseLogBuilder logType(String logType) {
            this.logType = logType;
            return this;
        }
        /* 操作IP地址 */
        public MakeUseLogBuilder makeUseIp(String makeUseIp) {
            this.makeUseIp = makeUseIp;
            return this;
        }
        /* 操作地址 */
        public MakeUseLogBuilder makeUseAddress(String makeUseAddress) {
            this.makeUseAddress = makeUseAddress;
            return this;
        }
        /* 操作状态: 成功, 失败, 异常 */
        public MakeUseLogBuilder makeUseStatus(String makeUseStatus) {
            this.makeUseStatus = makeUseStatus;
            return this;
        }
        /* 用户代理 */
        public MakeUseLogBuilder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }
        /* 请求URI */
        public MakeUseLogBuilder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }
        /* 操作方式 */
        public MakeUseLogBuilder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }
        /* 操作提交的数据 */
        public MakeUseLogBuilder params(String params) {
            this.params = params;
            return this;
        }
        /* 返回数据 */
        public MakeUseLogBuilder jsonResult(String jsonResult) {
            this.jsonResult = jsonResult;
            return this;
        }
        /* 删除标记 */
        public MakeUseLogBuilder delFlag(String delFlag) {
            this.delFlag = delFlag;
            return this;
        }
        /* 异常信息 */
        public MakeUseLogBuilder exception(String exception) {
            this.exception = exception;
            return this;
        }
        /* 备注 */
        public MakeUseLogBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 服务端处理耗时 */
        public MakeUseLogBuilder executeTime(String executeTime) {
            this.executeTime = executeTime;
            return this;
        }
        /* 返回消息 */
        public MakeUseLogBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }
        /* 创建时间 */
        public MakeUseLogBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人 */
        public MakeUseLogBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建人id */
        public MakeUseLogBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 更新时间 */
        public MakeUseLogBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人 */
        public MakeUseLogBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新人id */
        public MakeUseLogBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public MakeUseLog build() {
        return new MakeUseLog(            id, 
            tenantId, 
            serviceId, 
            clientId, 
            requestId, 
            menuTitle, 
            makeUseType, 
            logType, 
            makeUseIp, 
            makeUseAddress, 
            makeUseStatus, 
            userAgent, 
            requestUri, 
            requestMethod, 
            params, 
            jsonResult, 
            delFlag, 
            exception, 
            remarks, 
            executeTime, 
            msg, 
            createTime, 
            createUser, 
            createUserId, 
            updateTime, 
            updateUser, 
            updateUserId
);
    }

}


            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
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

            public void setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setUpdateTime(LocalDateTime updateTime) {
                this.updateTime = updateTime;
            }

            public LocalDateTime getUpdateTime() {
                return updateTime;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
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
                    .append("remarks", getRemarks())
                    .append("executeTime", getExecuteTime())
                    .append("msg", getMsg())
                    .append("createTime", getCreateTime())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateTime", getUpdateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
