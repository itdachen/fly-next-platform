package com.github.itdachen.oplog.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDateTime;



/**
 * 导入日志
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
@Table(name = "ta_fly_oplog_poi_imp")
public class OplogPoiImp implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户ID/公司ID */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 租户名称/公司名称 */
    @Column(name = "tenant_title")
    private String tenantTitle;

    /** 平台ID */
    @Column(name = "plat_id")
    private String platId;

    /** 平台名称 */
    @Column(name = "plat_title")
    private String platTitle;

    /** 应用ID */
    @Column(name = "app_id")
    private String appId;

    /** 应用名称 */
    @Column(name = "app_title")
    private String appTitle;

    /** 应用版本号 */
    @Column(name = "app_version")
    private String appVersion;

    /** 用户ID */
    @Column(name = "user_id")
    private String userId;

    /** 昵称 */
    @Column(name = "nick_name")
    private String nickName;

    /** 身份ID */
    @Column(name = "role_id")
    private String roleId;

    /** 身份名称 */
    @Column(name = "role_name")
    private String roleName;

    /** 省代码 */
    @Column(name = "prov_id")
    private String provId;

    /** 省名称 */
    @Column(name = "prov_title")
    private String provTitle;

    /** 市/州代码 */
    @Column(name = "city_id")
    private String cityId;

    /** 市/州名称 */
    @Column(name = "city_title")
    private String cityTitle;

    /** 区/县代码 */
    @Column(name = "county_id")
    private String countyId;

    /** 区/县名称 */
    @Column(name = "county_title")
    private String countyTitle;

    /** 部门ID */
    @Column(name = "dept_id")
    private String deptId;

    /** 部门名称 */
    @Column(name = "dept_title")
    private String deptTitle;

    /** 部门等级 */
    @Column(name = "dept_level")
    private String deptLevel;

    /** 上级部门代码 */
    @Column(name = "dept_parent_id")
    private String deptParentId;

    /** 消息表ID */
    @Column(name = "msg_id")
    private String msgId;

    /** 功能ID/菜单ID(备用) */
    @Column(name = "func_id")
    private String funcId;

    /** 功能名称(备用) */
    @Column(name = "func_title")
    private String funcTitle;

    /** 操作IP地址 */
    @Column(name = "host_ip")
    private String hostIp;

    /** 操作地址 */
    @Column(name = "host_address")
    private String hostAddress;

    /** 操作系统 */
    @Column(name = "host_os")
    private String hostOs;

    /** 操作浏览器 */
    @Column(name = "host_browser")
    private String hostBrowser;

    /** 用户代理 */
    @Column(name = "host_user_agent")
    private String hostUserAgent;

    /** 请求ID */
    @Column(name = "request_id")
    private String requestId;

    /** 请求URI */
    @Column(name = "request_uri")
    private String requestUri;

    /** 请求方式: POST, PUT, GET, DELETE */
    @Column(name = "request_method")
    private String requestMethod;

    /** 请求参数 */
    @Column(name = "request_params")
    private String requestParams;

    /** 数据总量 */
    @Column(name = "data_total")
    private String dataTotal;

    /** 导入文件名称 */
    @Column(name = "file_name")
    private String fileName;

    /** 文件地址 */
    @Column(name = "file_url")
    private String fileUrl;

    /** 文件大小 */
    @Column(name = "file_size")
    private String fileSize;

    /** 文件数量 */
    @Column(name = "file_total")
    private String fileTotal;

    /** 异常信息 */
    @Column(name = "ex_info")
    private String exInfo;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 服务端处理耗时 */
    @Column(name = "execute_time")
    private String executeTime;

    /** 删除标记:N-未删除;Y-已删除 */
    @Column(name = "remove_flag")
    private String removeFlag;

    /** 删除时间 */
    @Column(name = "remove_time")
    private LocalDateTime removeTime;

    /** 删除人ID */
    @Column(name = "remove_user_id")
    private String removeUserId;

    /** 删除人昵称 */
    @Column(name = "remove_user")
    private String removeUser;

    /** 年份 */
    @Column(name = "yearly")
    private String yearly;

    /** 月份 */
    @Column(name = "monthly")
    private String monthly;

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






public OplogPoiImp(){}


public OplogPoiImp(    String id,     String tenantId,     String tenantTitle,     String platId,     String platTitle,     String appId,     String appTitle,     String appVersion,     String userId,     String nickName,     String roleId,     String roleName,     String provId,     String provTitle,     String cityId,     String cityTitle,     String countyId,     String countyTitle,     String deptId,     String deptTitle,     String deptLevel,     String deptParentId,     String msgId,     String funcId,     String funcTitle,     String hostIp,     String hostAddress,     String hostOs,     String hostBrowser,     String hostUserAgent,     String requestId,     String requestUri,     String requestMethod,     String requestParams,     String dataTotal,     String fileName,     String fileUrl,     String fileSize,     String fileTotal,     String exInfo,     String remarks,     String executeTime,     String removeFlag,     LocalDateTime removeTime,     String removeUserId,     String removeUser,     String yearly,     String monthly,     LocalDateTime createTime,     String createUser,     String createUserId,     LocalDateTime updateTime,     String updateUser,     String updateUserId){
            this.id = id;
            this.tenantId = tenantId;
            this.tenantTitle = tenantTitle;
            this.platId = platId;
            this.platTitle = platTitle;
            this.appId = appId;
            this.appTitle = appTitle;
            this.appVersion = appVersion;
            this.userId = userId;
            this.nickName = nickName;
            this.roleId = roleId;
            this.roleName = roleName;
            this.provId = provId;
            this.provTitle = provTitle;
            this.cityId = cityId;
            this.cityTitle = cityTitle;
            this.countyId = countyId;
            this.countyTitle = countyTitle;
            this.deptId = deptId;
            this.deptTitle = deptTitle;
            this.deptLevel = deptLevel;
            this.deptParentId = deptParentId;
            this.msgId = msgId;
            this.funcId = funcId;
            this.funcTitle = funcTitle;
            this.hostIp = hostIp;
            this.hostAddress = hostAddress;
            this.hostOs = hostOs;
            this.hostBrowser = hostBrowser;
            this.hostUserAgent = hostUserAgent;
            this.requestId = requestId;
            this.requestUri = requestUri;
            this.requestMethod = requestMethod;
            this.requestParams = requestParams;
            this.dataTotal = dataTotal;
            this.fileName = fileName;
            this.fileUrl = fileUrl;
            this.fileSize = fileSize;
            this.fileTotal = fileTotal;
            this.exInfo = exInfo;
            this.remarks = remarks;
            this.executeTime = executeTime;
            this.removeFlag = removeFlag;
            this.removeTime = removeTime;
            this.removeUserId = removeUserId;
            this.removeUser = removeUser;
            this.yearly = yearly;
            this.monthly = monthly;
            this.createTime = createTime;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.updateTime = updateTime;
            this.updateUser = updateUser;
            this.updateUserId = updateUserId;
}

public static OplogPoiImpBuilder builder(){
        return new OplogPoiImpBuilder();
        }

public static class OplogPoiImpBuilder {
        private String id;
        private String tenantId;
        private String tenantTitle;
        private String platId;
        private String platTitle;
        private String appId;
        private String appTitle;
        private String appVersion;
        private String userId;
        private String nickName;
        private String roleId;
        private String roleName;
        private String provId;
        private String provTitle;
        private String cityId;
        private String cityTitle;
        private String countyId;
        private String countyTitle;
        private String deptId;
        private String deptTitle;
        private String deptLevel;
        private String deptParentId;
        private String msgId;
        private String funcId;
        private String funcTitle;
        private String hostIp;
        private String hostAddress;
        private String hostOs;
        private String hostBrowser;
        private String hostUserAgent;
        private String requestId;
        private String requestUri;
        private String requestMethod;
        private String requestParams;
        private String dataTotal;
        private String fileName;
        private String fileUrl;
        private String fileSize;
        private String fileTotal;
        private String exInfo;
        private String remarks;
        private String executeTime;
        private String removeFlag;
        private LocalDateTime removeTime;
        private String removeUserId;
        private String removeUser;
        private String yearly;
        private String monthly;
        private LocalDateTime createTime;
        private String createUser;
        private String createUserId;
        private LocalDateTime updateTime;
        private String updateUser;
        private String updateUserId;

    public OplogPoiImpBuilder() {
    }

        /* 主键唯一标识 */
        public OplogPoiImpBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 租户ID/公司ID */
        public OplogPoiImpBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 租户名称/公司名称 */
        public OplogPoiImpBuilder tenantTitle(String tenantTitle) {
            this.tenantTitle = tenantTitle;
            return this;
        }
        /* 平台ID */
        public OplogPoiImpBuilder platId(String platId) {
            this.platId = platId;
            return this;
        }
        /* 平台名称 */
        public OplogPoiImpBuilder platTitle(String platTitle) {
            this.platTitle = platTitle;
            return this;
        }
        /* 应用ID */
        public OplogPoiImpBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }
        /* 应用名称 */
        public OplogPoiImpBuilder appTitle(String appTitle) {
            this.appTitle = appTitle;
            return this;
        }
        /* 应用版本号 */
        public OplogPoiImpBuilder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }
        /* 用户ID */
        public OplogPoiImpBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }
        /* 昵称 */
        public OplogPoiImpBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }
        /* 身份ID */
        public OplogPoiImpBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }
        /* 身份名称 */
        public OplogPoiImpBuilder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }
        /* 省代码 */
        public OplogPoiImpBuilder provId(String provId) {
            this.provId = provId;
            return this;
        }
        /* 省名称 */
        public OplogPoiImpBuilder provTitle(String provTitle) {
            this.provTitle = provTitle;
            return this;
        }
        /* 市/州代码 */
        public OplogPoiImpBuilder cityId(String cityId) {
            this.cityId = cityId;
            return this;
        }
        /* 市/州名称 */
        public OplogPoiImpBuilder cityTitle(String cityTitle) {
            this.cityTitle = cityTitle;
            return this;
        }
        /* 区/县代码 */
        public OplogPoiImpBuilder countyId(String countyId) {
            this.countyId = countyId;
            return this;
        }
        /* 区/县名称 */
        public OplogPoiImpBuilder countyTitle(String countyTitle) {
            this.countyTitle = countyTitle;
            return this;
        }
        /* 部门ID */
        public OplogPoiImpBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }
        /* 部门名称 */
        public OplogPoiImpBuilder deptTitle(String deptTitle) {
            this.deptTitle = deptTitle;
            return this;
        }
        /* 部门等级 */
        public OplogPoiImpBuilder deptLevel(String deptLevel) {
            this.deptLevel = deptLevel;
            return this;
        }
        /* 上级部门代码 */
        public OplogPoiImpBuilder deptParentId(String deptParentId) {
            this.deptParentId = deptParentId;
            return this;
        }
        /* 消息表ID */
        public OplogPoiImpBuilder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }
        /* 功能ID/菜单ID(备用) */
        public OplogPoiImpBuilder funcId(String funcId) {
            this.funcId = funcId;
            return this;
        }
        /* 功能名称(备用) */
        public OplogPoiImpBuilder funcTitle(String funcTitle) {
            this.funcTitle = funcTitle;
            return this;
        }
        /* 操作IP地址 */
        public OplogPoiImpBuilder hostIp(String hostIp) {
            this.hostIp = hostIp;
            return this;
        }
        /* 操作地址 */
        public OplogPoiImpBuilder hostAddress(String hostAddress) {
            this.hostAddress = hostAddress;
            return this;
        }
        /* 操作系统 */
        public OplogPoiImpBuilder hostOs(String hostOs) {
            this.hostOs = hostOs;
            return this;
        }
        /* 操作浏览器 */
        public OplogPoiImpBuilder hostBrowser(String hostBrowser) {
            this.hostBrowser = hostBrowser;
            return this;
        }
        /* 用户代理 */
        public OplogPoiImpBuilder hostUserAgent(String hostUserAgent) {
            this.hostUserAgent = hostUserAgent;
            return this;
        }
        /* 请求ID */
        public OplogPoiImpBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }
        /* 请求URI */
        public OplogPoiImpBuilder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }
        /* 请求方式: POST, PUT, GET, DELETE */
        public OplogPoiImpBuilder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }
        /* 请求参数 */
        public OplogPoiImpBuilder requestParams(String requestParams) {
            this.requestParams = requestParams;
            return this;
        }
        /* 数据总量 */
        public OplogPoiImpBuilder dataTotal(String dataTotal) {
            this.dataTotal = dataTotal;
            return this;
        }
        /* 导入文件名称 */
        public OplogPoiImpBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        /* 文件地址 */
        public OplogPoiImpBuilder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }
        /* 文件大小 */
        public OplogPoiImpBuilder fileSize(String fileSize) {
            this.fileSize = fileSize;
            return this;
        }
        /* 文件数量 */
        public OplogPoiImpBuilder fileTotal(String fileTotal) {
            this.fileTotal = fileTotal;
            return this;
        }
        /* 异常信息 */
        public OplogPoiImpBuilder exInfo(String exInfo) {
            this.exInfo = exInfo;
            return this;
        }
        /* 备注 */
        public OplogPoiImpBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 服务端处理耗时 */
        public OplogPoiImpBuilder executeTime(String executeTime) {
            this.executeTime = executeTime;
            return this;
        }
        /* 删除标记:N-未删除;Y-已删除 */
        public OplogPoiImpBuilder removeFlag(String removeFlag) {
            this.removeFlag = removeFlag;
            return this;
        }
        /* 删除时间 */
        public OplogPoiImpBuilder removeTime(LocalDateTime removeTime) {
            this.removeTime = removeTime;
            return this;
        }
        /* 删除人ID */
        public OplogPoiImpBuilder removeUserId(String removeUserId) {
            this.removeUserId = removeUserId;
            return this;
        }
        /* 删除人昵称 */
        public OplogPoiImpBuilder removeUser(String removeUser) {
            this.removeUser = removeUser;
            return this;
        }
        /* 年份 */
        public OplogPoiImpBuilder yearly(String yearly) {
            this.yearly = yearly;
            return this;
        }
        /* 月份 */
        public OplogPoiImpBuilder monthly(String monthly) {
            this.monthly = monthly;
            return this;
        }
        /* 创建时间 */
        public OplogPoiImpBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人 */
        public OplogPoiImpBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建人id */
        public OplogPoiImpBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 更新时间 */
        public OplogPoiImpBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人 */
        public OplogPoiImpBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新人id */
        public OplogPoiImpBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public OplogPoiImp build() {
        return new OplogPoiImp(            id, 
            tenantId, 
            tenantTitle, 
            platId, 
            platTitle, 
            appId, 
            appTitle, 
            appVersion, 
            userId, 
            nickName, 
            roleId, 
            roleName, 
            provId, 
            provTitle, 
            cityId, 
            cityTitle, 
            countyId, 
            countyTitle, 
            deptId, 
            deptTitle, 
            deptLevel, 
            deptParentId, 
            msgId, 
            funcId, 
            funcTitle, 
            hostIp, 
            hostAddress, 
            hostOs, 
            hostBrowser, 
            hostUserAgent, 
            requestId, 
            requestUri, 
            requestMethod, 
            requestParams, 
            dataTotal, 
            fileName, 
            fileUrl, 
            fileSize, 
            fileTotal, 
            exInfo, 
            remarks, 
            executeTime, 
            removeFlag, 
            removeTime, 
            removeUserId, 
            removeUser, 
            yearly, 
            monthly, 
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

            public void setTenantTitle(String tenantTitle) {
                this.tenantTitle = tenantTitle;
            }

            public String getTenantTitle() {
                return tenantTitle;
            }

            public void setPlatId(String platId) {
                this.platId = platId;
            }

            public String getPlatId() {
                return platId;
            }

            public void setPlatTitle(String platTitle) {
                this.platTitle = platTitle;
            }

            public String getPlatTitle() {
                return platTitle;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

            public String getAppId() {
                return appId;
            }

            public void setAppTitle(String appTitle) {
                this.appTitle = appTitle;
            }

            public String getAppTitle() {
                return appTitle;
            }

            public void setAppVersion(String appVersion) {
                this.appVersion = appVersion;
            }

            public String getAppVersion() {
                return appVersion;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserId() {
                return userId;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getNickName() {
                return nickName;
            }

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

            public String getRoleId() {
                return roleId;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setProvId(String provId) {
                this.provId = provId;
            }

            public String getProvId() {
                return provId;
            }

            public void setProvTitle(String provTitle) {
                this.provTitle = provTitle;
            }

            public String getProvTitle() {
                return provTitle;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityTitle(String cityTitle) {
                this.cityTitle = cityTitle;
            }

            public String getCityTitle() {
                return cityTitle;
            }

            public void setCountyId(String countyId) {
                this.countyId = countyId;
            }

            public String getCountyId() {
                return countyId;
            }

            public void setCountyTitle(String countyTitle) {
                this.countyTitle = countyTitle;
            }

            public String getCountyTitle() {
                return countyTitle;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptTitle(String deptTitle) {
                this.deptTitle = deptTitle;
            }

            public String getDeptTitle() {
                return deptTitle;
            }

            public void setDeptLevel(String deptLevel) {
                this.deptLevel = deptLevel;
            }

            public String getDeptLevel() {
                return deptLevel;
            }

            public void setDeptParentId(String deptParentId) {
                this.deptParentId = deptParentId;
            }

            public String getDeptParentId() {
                return deptParentId;
            }

            public void setMsgId(String msgId) {
                this.msgId = msgId;
            }

            public String getMsgId() {
                return msgId;
            }

            public void setFuncId(String funcId) {
                this.funcId = funcId;
            }

            public String getFuncId() {
                return funcId;
            }

            public void setFuncTitle(String funcTitle) {
                this.funcTitle = funcTitle;
            }

            public String getFuncTitle() {
                return funcTitle;
            }

            public void setHostIp(String hostIp) {
                this.hostIp = hostIp;
            }

            public String getHostIp() {
                return hostIp;
            }

            public void setHostAddress(String hostAddress) {
                this.hostAddress = hostAddress;
            }

            public String getHostAddress() {
                return hostAddress;
            }

            public void setHostOs(String hostOs) {
                this.hostOs = hostOs;
            }

            public String getHostOs() {
                return hostOs;
            }

            public void setHostBrowser(String hostBrowser) {
                this.hostBrowser = hostBrowser;
            }

            public String getHostBrowser() {
                return hostBrowser;
            }

            public void setHostUserAgent(String hostUserAgent) {
                this.hostUserAgent = hostUserAgent;
            }

            public String getHostUserAgent() {
                return hostUserAgent;
            }

            public void setRequestId(String requestId) {
                this.requestId = requestId;
            }

            public String getRequestId() {
                return requestId;
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

            public void setRequestParams(String requestParams) {
                this.requestParams = requestParams;
            }

            public String getRequestParams() {
                return requestParams;
            }

            public void setDataTotal(String dataTotal) {
                this.dataTotal = dataTotal;
            }

            public String getDataTotal() {
                return dataTotal;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileUrl(String fileUrl) {
                this.fileUrl = fileUrl;
            }

            public String getFileUrl() {
                return fileUrl;
            }

            public void setFileSize(String fileSize) {
                this.fileSize = fileSize;
            }

            public String getFileSize() {
                return fileSize;
            }

            public void setFileTotal(String fileTotal) {
                this.fileTotal = fileTotal;
            }

            public String getFileTotal() {
                return fileTotal;
            }

            public void setExInfo(String exInfo) {
                this.exInfo = exInfo;
            }

            public String getExInfo() {
                return exInfo;
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

            public void setRemoveFlag(String removeFlag) {
                this.removeFlag = removeFlag;
            }

            public String getRemoveFlag() {
                return removeFlag;
            }

            public void setRemoveTime(LocalDateTime removeTime) {
                this.removeTime = removeTime;
            }

            public LocalDateTime getRemoveTime() {
                return removeTime;
            }

            public void setRemoveUserId(String removeUserId) {
                this.removeUserId = removeUserId;
            }

            public String getRemoveUserId() {
                return removeUserId;
            }

            public void setRemoveUser(String removeUser) {
                this.removeUser = removeUser;
            }

            public String getRemoveUser() {
                return removeUser;
            }

            public void setYearly(String yearly) {
                this.yearly = yearly;
            }

            public String getYearly() {
                return yearly;
            }

            public void setMonthly(String monthly) {
                this.monthly = monthly;
            }

            public String getMonthly() {
                return monthly;
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
                    .append("tenantTitle", getTenantTitle())
                    .append("platId", getPlatId())
                    .append("platTitle", getPlatTitle())
                    .append("appId", getAppId())
                    .append("appTitle", getAppTitle())
                    .append("appVersion", getAppVersion())
                    .append("userId", getUserId())
                    .append("nickName", getNickName())
                    .append("roleId", getRoleId())
                    .append("roleName", getRoleName())
                    .append("provId", getProvId())
                    .append("provTitle", getProvTitle())
                    .append("cityId", getCityId())
                    .append("cityTitle", getCityTitle())
                    .append("countyId", getCountyId())
                    .append("countyTitle", getCountyTitle())
                    .append("deptId", getDeptId())
                    .append("deptTitle", getDeptTitle())
                    .append("deptLevel", getDeptLevel())
                    .append("deptParentId", getDeptParentId())
                    .append("msgId", getMsgId())
                    .append("funcId", getFuncId())
                    .append("funcTitle", getFuncTitle())
                    .append("hostIp", getHostIp())
                    .append("hostAddress", getHostAddress())
                    .append("hostOs", getHostOs())
                    .append("hostBrowser", getHostBrowser())
                    .append("hostUserAgent", getHostUserAgent())
                    .append("requestId", getRequestId())
                    .append("requestUri", getRequestUri())
                    .append("requestMethod", getRequestMethod())
                    .append("requestParams", getRequestParams())
                    .append("dataTotal", getDataTotal())
                    .append("fileName", getFileName())
                    .append("fileUrl", getFileUrl())
                    .append("fileSize", getFileSize())
                    .append("fileTotal", getFileTotal())
                    .append("exInfo", getExInfo())
                    .append("remarks", getRemarks())
                    .append("executeTime", getExecuteTime())
                    .append("removeFlag", getRemoveFlag())
                    .append("removeTime", getRemoveTime())
                    .append("removeUserId", getRemoveUserId())
                    .append("removeUser", getRemoveUser())
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                    .append("createTime", getCreateTime())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateTime", getUpdateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
