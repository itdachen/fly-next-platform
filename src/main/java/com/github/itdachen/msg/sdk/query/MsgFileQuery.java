package com.github.itdachen.msg.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 消息附件 查询参数
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgFileQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 租户ID */
            private String tenantId;

            /** 平台ID */
            private String platId;

            /** 应用ID */
            private String appId;

            /** 上传人ID */
            private String userId;

            /** 上传人昵称 */
            private String nickName;

            /** 消息ID */
            private String msgId;

            /** 文件名称 */
            private String fileTitle;

            /** 文件格式 */
            private String fileFormat;

            /** 文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传) */
            private String hexMd5;

            /** MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播) */
            private String md5ValidFlag;

            /** 下载标志 */
            private String downloadFlag;

            /** 阅读标志 */
            private String readFlag;

            /** 删除标志 */
            private String removeFlag;

            /** 年份 */
            private String yearly;

            /** 月份 */
            private String monthly;



    public MsgFileQuery() {
    }

    public MsgFileQuery(int page, int limit, String tenantId, String platId, String appId, String userId, String nickName, String msgId, String fileTitle, String fileFormat, String hexMd5, String md5ValidFlag, String downloadFlag, String readFlag, String removeFlag, String yearly, String monthly) {
        super(page, limit);
            this.tenantId = tenantId;
            this.platId = platId;
            this.appId = appId;
            this.userId = userId;
            this.nickName = nickName;
            this.msgId = msgId;
            this.fileTitle = fileTitle;
            this.fileFormat = fileFormat;
            this.hexMd5 = hexMd5;
            this.md5ValidFlag = md5ValidFlag;
            this.downloadFlag = downloadFlag;
            this.readFlag = readFlag;
            this.removeFlag = removeFlag;
            this.yearly = yearly;
            this.monthly = monthly;
    }

    public static MsgFileQueryBuilder builder() {
        return new MsgFileQueryBuilder();
    }

    public static class MsgFileQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String tenantId;
            private String platId;
            private String appId;
            private String userId;
            private String nickName;
            private String msgId;
            private String fileTitle;
            private String fileFormat;
            private String hexMd5;
            private String md5ValidFlag;
            private String downloadFlag;
            private String readFlag;
            private String removeFlag;
            private String yearly;
            private String monthly;

        public MsgFileQueryBuilder() {
        }

        public MsgFileQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public MsgFileQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 租户ID */
            public MsgFileQueryBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 平台ID */
            public MsgFileQueryBuilder platId(String platId) {
                this.platId = platId;
                return this;
            }
            /* 应用ID */
            public MsgFileQueryBuilder appId(String appId) {
                this.appId = appId;
                return this;
            }
            /* 上传人ID */
            public MsgFileQueryBuilder userId(String userId) {
                this.userId = userId;
                return this;
            }
            /* 上传人昵称 */
            public MsgFileQueryBuilder nickName(String nickName) {
                this.nickName = nickName;
                return this;
            }
            /* 消息ID */
            public MsgFileQueryBuilder msgId(String msgId) {
                this.msgId = msgId;
                return this;
            }
            /* 文件名称 */
            public MsgFileQueryBuilder fileTitle(String fileTitle) {
                this.fileTitle = fileTitle;
                return this;
            }
            /* 文件格式 */
            public MsgFileQueryBuilder fileFormat(String fileFormat) {
                this.fileFormat = fileFormat;
                return this;
            }
            /* 文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传) */
            public MsgFileQueryBuilder hexMd5(String hexMd5) {
                this.hexMd5 = hexMd5;
                return this;
            }
            /* MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播) */
            public MsgFileQueryBuilder md5ValidFlag(String md5ValidFlag) {
                this.md5ValidFlag = md5ValidFlag;
                return this;
            }
            /* 下载标志 */
            public MsgFileQueryBuilder downloadFlag(String downloadFlag) {
                this.downloadFlag = downloadFlag;
                return this;
            }
            /* 阅读标志 */
            public MsgFileQueryBuilder readFlag(String readFlag) {
                this.readFlag = readFlag;
                return this;
            }
            /* 删除标志 */
            public MsgFileQueryBuilder removeFlag(String removeFlag) {
                this.removeFlag = removeFlag;
                return this;
            }
            /* 年份 */
            public MsgFileQueryBuilder yearly(String yearly) {
                this.yearly = yearly;
                return this;
            }
            /* 月份 */
            public MsgFileQueryBuilder monthly(String monthly) {
                this.monthly = monthly;
                return this;
            }

        public MsgFileQuery build() {
            return new MsgFileQuery(page, limit, tenantId, platId, appId, userId, nickName, msgId, fileTitle, fileFormat, hexMd5, md5ValidFlag, downloadFlag, readFlag, removeFlag, yearly, monthly);
        }

    }



        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setPlatId(String platId) {
            this.platId = platId;
        }

        public String getPlatId() {
            return platId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppId() {
            return appId;
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

        public void setReadFlag(String readFlag) {
            this.readFlag = readFlag;
        }

        public String getReadFlag() {
            return readFlag;
        }

        public void setRemoveFlag(String removeFlag) {
            this.removeFlag = removeFlag;
        }

        public String getRemoveFlag() {
            return removeFlag;
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
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("tenantId", getTenantId())
                    .append("platId", getPlatId())
                    .append("appId", getAppId())
                    .append("userId", getUserId())
                    .append("nickName", getNickName())
                    .append("msgId", getMsgId())
                    .append("fileTitle", getFileTitle())
                    .append("fileFormat", getFileFormat())
                    .append("hexMd5", getHexMd5())
                    .append("md5ValidFlag", getMd5ValidFlag())
                    .append("downloadFlag", getDownloadFlag())
                    .append("readFlag", getReadFlag())
                    .append("removeFlag", getRemoveFlag())
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                .toString();
    }

}
