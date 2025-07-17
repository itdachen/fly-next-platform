package com.github.itdachen.msg.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 消息附件 DTO
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgFileDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键唯一标识 */
        private String id;

        /** 租户ID */
        private String tenantId;

        /** 租户名称 */
 @NotBlank(message = "租户名称不能为空")
        private String tenantTitle;

        /** 平台ID */
 @NotBlank(message = "平台ID不能为空")
        private String platId;

        /** 平台名称 */
 @NotBlank(message = "平台名称不能为空")
        private String platTitle;

        /** 应用ID */
 @NotBlank(message = "应用ID不能为空")
        private String appId;

        /** 应用名称 */
 @NotBlank(message = "应用名称不能为空")
        private String appTitle;

        /** 上传人ID */
 @NotBlank(message = "上传人ID不能为空")
        private String userId;

        /** 上传人昵称 */
 @NotBlank(message = "上传人昵称不能为空")
        private String nickName;

        /** 消息ID */
 @NotBlank(message = "消息ID不能为空")
        private String msgId;

        /** 文件名称 */
 @NotBlank(message = "文件名称不能为空")
        private String fileTitle;

        /** 文件格式 */
 @NotBlank(message = "文件格式不能为空")
        private String fileFormat;

        /** 文件地址 */
 @NotBlank(message = "文件地址不能为空")
        private String fileUrl;

        /** 文件大小 */
 @NotBlank(message = "文件大小不能为空")
        private String fileSize;

        /** 文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传) */
 @NotBlank(message = "文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传)不能为空")
        private String hexMd5;

        /** MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播) */
 @NotBlank(message = "MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播)不能为空")
        private String md5ValidFlag;

        /** 下载标志 */
 @NotBlank(message = "下载标志不能为空")
        private String downloadFlag;

        /** 下载次数 */
 @NotNull(message = "下载次数不能为空")
        private Long downloadTotal;

        /** 第一次下载时间 */
 @NotNull(message = "第一次下载时间不能为空")
        private LocalDateTime downloadFirstTime;

        /** 最后一次下载时间 */
 @NotNull(message = "最后一次下载时间不能为空")
        private LocalDateTime downloadLastTime;

        /** 阅读标志 */
 @NotBlank(message = "阅读标志不能为空")
        private String readFlag;

        /** 阅读时间 */
 @NotNull(message = "阅读时间不能为空")
        private LocalDateTime readTime;

        /** 删除时间 */
 @NotNull(message = "删除时间不能为空")
        private LocalDateTime removeTime;

        /** 删除人ID */
 @NotBlank(message = "删除人ID不能为空")
        private String removeUserId;

        /** 删除人昵称 */
 @NotBlank(message = "删除人昵称不能为空")
        private String removeNickName;

        /** 年份 */
 @NotBlank(message = "年份不能为空")
        private String yearly;

        /** 月份 */
 @NotBlank(message = "月份不能为空")
        private String monthly;





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
            public void setMsgId(String msgId) {
                this.msgId = msgId;
            }

            public String getMsgId() {
                return msgId;
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
                    .append("userId", getUserId())
                    .append("nickName", getNickName())
                    .append("msgId", getMsgId())
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
                    .append("removeTime", getRemoveTime())
                    .append("removeUserId", getRemoveUserId())
                    .append("removeNickName", getRemoveNickName())
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                .toString();
    }

}
