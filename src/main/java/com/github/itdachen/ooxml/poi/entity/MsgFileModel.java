package com.github.itdachen.ooxml.poi.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 消息文件
 *
 * @author 王大宸
 * @date 2025-07-22 10:49
 */
public class MsgFileModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 租户名称
     */
    private String tenantTitle;

    /**
     * 平台ID
     */
    private String platId;

    /**
     * 平台名称
     */
    private String platTitle;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appTitle;

    /**
     * 上传人ID
     */
    private String userId;

    /**
     * 上传人昵称
     */
    private String nickName;

    /**
     * 消息ID
     */
    private String msgId;

    /**
     * 文件名称
     */
    private String fileTitle;

    /**
     * 文件格式
     */
    private String fileFormat;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传)
     */
    private String hexMd5;

    /**
     * MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播)
     */
    private String md5ValidFlag = "Y";

    /**
     * 年份
     */
    private String yearly;

    /**
     * 月份
     */
    private String monthly;


    public MsgFileModel() {
    }

    public MsgFileModel(String id, String tenantId, String tenantTitle,
                        String platId, String platTitle, String appId, String appTitle,
                        String userId, String nickName, String msgId,
                        String fileTitle, String fileFormat, String fileUrl, String fileSize,
                        String hexMd5, String md5ValidFlag,
                        String yearly, String monthly) {
        this.id = id;
        this.tenantId = tenantId;
        this.tenantTitle = tenantTitle;
        this.platId = platId;
        this.platTitle = platTitle;
        this.appId = appId;
        this.appTitle = appTitle;
        this.userId = userId;
        this.nickName = nickName;
        this.msgId = msgId;
        this.fileTitle = fileTitle;
        this.fileFormat = fileFormat;
        this.fileUrl = fileUrl;
        this.fileSize = fileSize;
        this.hexMd5 = hexMd5;
        this.md5ValidFlag = md5ValidFlag;
        this.yearly = yearly;
        this.monthly = monthly;
    }

    public static MsgInfoFileBuilder builder() {
        return new MsgInfoFileBuilder();
    }

    public static class MsgInfoFileBuilder {
        private String id;
        private String tenantId;
        private String tenantTitle;
        private String platId;
        private String platTitle;
        private String appId;
        private String appTitle;
        private String userId;
        private String nickName;
        private String msgId;
        private String fileTitle;
        private String fileFormat;
        private String fileUrl;
        private String fileSize;
        private String hexMd5;
        private String md5ValidFlag;
        private String yearly;
        private String monthly;

        public MsgInfoFileBuilder() {
        }

        /* 主键唯一标识 */
        public MsgInfoFileBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 租户ID */
        public MsgInfoFileBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 租户名称 */
        public MsgInfoFileBuilder tenantTitle(String tenantTitle) {
            this.tenantTitle = tenantTitle;
            return this;
        }

        /* 平台ID */
        public MsgInfoFileBuilder platId(String platId) {
            this.platId = platId;
            return this;
        }

        /* 平台名称 */
        public MsgInfoFileBuilder platTitle(String platTitle) {
            this.platTitle = platTitle;
            return this;
        }

        /* 应用ID */
        public MsgInfoFileBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 应用名称 */
        public MsgInfoFileBuilder appTitle(String appTitle) {
            this.appTitle = appTitle;
            return this;
        }

        /* 上传人ID */
        public MsgInfoFileBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 上传人昵称 */
        public MsgInfoFileBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        /* 消息ID */
        public MsgInfoFileBuilder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        /* 文件名称 */
        public MsgInfoFileBuilder fileTitle(String fileTitle) {
            this.fileTitle = fileTitle;
            return this;
        }

        /* 文件格式 */
        public MsgInfoFileBuilder fileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
            return this;
        }

        /* 文件地址 */
        public MsgInfoFileBuilder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        /* 文件大小 */
        public MsgInfoFileBuilder fileSize(String fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /* 文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传) */
        public MsgInfoFileBuilder hexMd5(String hexMd5) {
            this.hexMd5 = hexMd5;
            return this;
        }

        /* MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播) */
        public MsgInfoFileBuilder md5ValidFlag(String md5ValidFlag) {
            this.md5ValidFlag = md5ValidFlag;
            return this;
        }


        /* 年份 */
        public MsgInfoFileBuilder yearly(String yearly) {
            this.yearly = yearly;
            return this;
        }

        /* 月份 */
        public MsgInfoFileBuilder monthly(String monthly) {
            this.monthly = monthly;
            return this;
        }

        public MsgFileModel build() {
            return new MsgFileModel(id,
                    tenantId,
                    tenantTitle,
                    platId,
                    platTitle,
                    appId,
                    appTitle,
                    userId,
                    nickName,
                    msgId,
                    fileTitle,
                    fileFormat,
                    fileUrl,
                    fileSize,
                    hexMd5,
                    md5ValidFlag,
                    yearly,
                    monthly
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
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .toString();
    }


}
