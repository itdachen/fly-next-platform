package com.github.itdachen.msg.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 消息附件
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
@Table(name = "ta_fly_msg_pool_file")
public class MsgPoolFile implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 租户ID/公司ID
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 租户名称/公司名称
     */
    @Column(name = "tenant_title")
    private String tenantTitle;

    /**
     * 平台ID
     */
    @Column(name = "plat_id")
    private String platId;

    /**
     * 平台名称
     */
    @Column(name = "plat_title")
    private String platTitle;

    /**
     * 应用ID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 应用名称
     */
    @Column(name = "app_title")
    private String appTitle;

    /**
     * 应用版本号
     */
    @Column(name = "app_version")
    private String appVersion;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 身份ID
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 身份名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 省代码
     */
    @Column(name = "prov_id")
    private String provId;

    /**
     * 省名称
     */
    @Column(name = "prov_title")
    private String provTitle;

    /**
     * 市/州代码
     */
    @Column(name = "city_id")
    private String cityId;

    /**
     * 市/州名称
     */
    @Column(name = "city_title")
    private String cityTitle;

    /**
     * 区/县代码
     */
    @Column(name = "county_id")
    private String countyId;

    /**
     * 区县名称
     */
    @Column(name = "county_title")
    private String countyTitle;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private String deptId;

    /**
     * 部门名称
     */
    @Column(name = "dept_title")
    private String deptTitle;

    /**
     * 部门等级
     */
    @Column(name = "dept_level")
    private String deptLevel;

    /**
     * 上级部门代码
     */
    @Column(name = "dept_parent_id")
    private String deptParentId;

    /**
     * 操作IP地址
     */
    @Column(name = "host_ip")
    private String hostIp;

    /**
     * 操作地址
     */
    @Column(name = "host_address")
    private String hostAddress;

    /**
     * 操作系统
     */
    @Column(name = "host_os")
    private String hostOs;

    /**
     * 操作浏览器
     */
    @Column(name = "host_browser")
    private String hostBrowser;

    /**
     * 用户代理
     */
    @Column(name = "host_user_agent")
    private String hostUserAgent;

    /**
     * 消息类型
     */
    @Column(name = "msg_type")
    private String msgType;

    /**
     * 消息类型名称
     */
    @Column(name = "msg_type_title")
    private String msgTypeTitle;

    /**
     * 消息分类
     */
    @Column(name = "clazz_type")
    private String clazzType;

    /**
     * 消息分类名称
     */
    @Column(name = "clazz_title")
    private String clazzTitle;

    /**
     * 消息ID
     */
    @Column(name = "msg_id")
    private String msgId;

    /**
     * 消息标题
     */
    @Column(name = "msg_title")
    private String msgTitle;

    /**
     * 文件名称
     */
    @Column(name = "file_title")
    private String fileTitle;

    /**
     * 文件格式
     */
    @Column(name = "file_format")
    private String fileFormat;

    /**
     * 文件地址
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private String fileSize;

    /**
     * 文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传)
     */
    @Column(name = "hex_md5")
    private String hexMd5;

    /**
     * MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播)
     */
    @Column(name = "md5_valid_flag")
    private String md5ValidFlag;

    /**
     * 下载标志
     */
    @Column(name = "download_flag")
    private String downloadFlag;

    /**
     * 下载次数
     */
    @Column(name = "download_total")
    private Long downloadTotal;

    /**
     * 第一次下载时间
     */
    @Column(name = "download_first_time")
    private LocalDateTime downloadFirstTime;

    /**
     * 最后一次下载时间
     */
    @Column(name = "download_last_time")
    private LocalDateTime downloadLastTime;

    /**
     * 阅读标志
     */
    @Column(name = "read_flag")
    private String readFlag;

    /**
     * 阅读时间
     */
    @Column(name = "read_time")
    private LocalDateTime readTime;

    /**
     * 删除标志
     */
    @Column(name = "remove_flag")
    private String removeFlag;

    /**
     * 删除时间
     */
    @Column(name = "remove_time")
    private LocalDateTime removeTime;

    /**
     * 删除人ID
     */
    @Column(name = "remove_user_id")
    private String removeUserId;

    /**
     * 删除人昵称
     */
    @Column(name = "remove_nick_name")
    private String removeNickName;

    /**
     * 年份
     */
    @Column(name = "yearly")
    private String yearly;

    /**
     * 月份
     */
    @Column(name = "monthly")
    private String monthly;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;


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

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgTypeTitle(String msgTypeTitle) {
        this.msgTypeTitle = msgTypeTitle;
    }

    public String getMsgTypeTitle() {
        return msgTypeTitle;
    }

    public void setClazzType(String clazzType) {
        this.clazzType = clazzType;
    }

    public String getClazzType() {
        return clazzType;
    }

    public void setClazzTitle(String clazzTitle) {
        this.clazzTitle = clazzTitle;
    }

    public String getClazzTitle() {
        return clazzTitle;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
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

    public void setHexMd5(String hexMd5) {
        this.hexMd5 = hexMd5;
    }

    public String getHexMd5() {
        return hexMd5;
    }

    public void setMd5ValidFlag(String md5ValidFlag) {
        this.md5ValidFlag = md5ValidFlag;
    }

    public String getMd5ValidFlag() {
        return md5ValidFlag;
    }

    public void setDownloadFlag(String downloadFlag) {
        this.downloadFlag = downloadFlag;
    }

    public String getDownloadFlag() {
        return downloadFlag;
    }

    public void setDownloadTotal(Long downloadTotal) {
        this.downloadTotal = downloadTotal;
    }

    public Long getDownloadTotal() {
        return downloadTotal;
    }

    public void setDownloadFirstTime(LocalDateTime downloadFirstTime) {
        this.downloadFirstTime = downloadFirstTime;
    }

    public LocalDateTime getDownloadFirstTime() {
        return downloadFirstTime;
    }

    public void setDownloadLastTime(LocalDateTime downloadLastTime) {
        this.downloadLastTime = downloadLastTime;
    }

    public LocalDateTime getDownloadLastTime() {
        return downloadLastTime;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadTime(LocalDateTime readTime) {
        this.readTime = readTime;
    }

    public LocalDateTime getReadTime() {
        return readTime;
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

    public void setRemoveNickName(String removeNickName) {
        this.removeNickName = removeNickName;
    }

    public String getRemoveNickName() {
        return removeNickName;
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
                .append("hostIp", getHostIp())
                .append("hostAddress", getHostAddress())
                .append("hostOs", getHostOs())
                .append("hostBrowser", getHostBrowser())
                .append("hostUserAgent", getHostUserAgent())
                .append("msgType", getMsgType())
                .append("msgTypeTitle", getMsgTypeTitle())
                .append("clazzType", getClazzType())
                .append("clazzTitle", getClazzTitle())
                .append("msgId", getMsgId())
                .append("msgTitle", getMsgTitle())
                .append("fileTitle", getFileTitle())
                .append("fileFormat", getFileFormat())
                .append("fileUrl", getFileUrl())
                .append("fileSize", getFileSize())
                .append("hexMd5", getHexMd5())
                .append("md5ValidFlag", getMd5ValidFlag())
                .append("downloadFlag", getDownloadFlag())
                .append("downloadTotal", getDownloadTotal())
                .append("downloadFirstTime", getDownloadFirstTime())
                .append("downloadLastTime", getDownloadLastTime())
                .append("readFlag", getReadFlag())
                .append("readTime", getReadTime())
                .append("removeFlag", getRemoveFlag())
                .append("removeTime", getRemoveTime())
                .append("removeUserId", getRemoveUserId())
                .append("removeNickName", getRemoveNickName())
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
