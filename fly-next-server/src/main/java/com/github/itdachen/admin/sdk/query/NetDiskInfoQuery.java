package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 文件信息表 查询参数
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public class NetDiskInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 文件MD5 */
            private String bizMd5;

            /** 真实路径 */
            private String realPath;

            /** 网络路径 */
            private String url;

            /** 文件名称 */
            private String fileName;

            /** 文件大小 */
            private Long fileSize;

            /** 文件格式 */
            private String fileFormat;

            /** 文件类型：1-通用文件;2-头像 */
            private Integer bizType;

            /** 下载量 */
            private Integer downloadCount;


    public NetDiskInfoQuery() {
    }

    public NetDiskInfoQuery(int page, int limit, String bizMd5, String realPath, String url, String fileName, Long fileSize, String fileFormat, Integer bizType, Integer downloadCount) {
        super(page, limit);
            this.bizMd5 = bizMd5;
            this.realPath = realPath;
            this.url = url;
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.fileFormat = fileFormat;
            this.bizType = bizType;
            this.downloadCount = downloadCount;
    }

    public static NetDiskInfoQueryBuilder builder() {
        return new NetDiskInfoQueryBuilder();
    }

    public static class NetDiskInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String bizMd5;
            private String realPath;
            private String url;
            private String fileName;
            private Long fileSize;
            private String fileFormat;
            private Integer bizType;
            private Integer downloadCount;

        public NetDiskInfoQueryBuilder() {
        }

        public NetDiskInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public NetDiskInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 文件MD5 */
            public NetDiskInfoQueryBuilder bizMd5(String bizMd5) {
                this.bizMd5 = bizMd5;
                return this;
            }
            /* 真实路径 */
            public NetDiskInfoQueryBuilder realPath(String realPath) {
                this.realPath = realPath;
                return this;
            }
            /* 网络路径 */
            public NetDiskInfoQueryBuilder url(String url) {
                this.url = url;
                return this;
            }
            /* 文件名称 */
            public NetDiskInfoQueryBuilder fileName(String fileName) {
                this.fileName = fileName;
                return this;
            }
            /* 文件大小 */
            public NetDiskInfoQueryBuilder fileSize(Long fileSize) {
                this.fileSize = fileSize;
                return this;
            }
            /* 文件格式 */
            public NetDiskInfoQueryBuilder fileFormat(String fileFormat) {
                this.fileFormat = fileFormat;
                return this;
            }
            /* 文件类型：1-通用文件;2-头像 */
            public NetDiskInfoQueryBuilder bizType(Integer bizType) {
                this.bizType = bizType;
                return this;
            }
            /* 下载量 */
            public NetDiskInfoQueryBuilder downloadCount(Integer downloadCount) {
                this.downloadCount = downloadCount;
                return this;
            }

        public NetDiskInfoQuery build() {
            return new NetDiskInfoQuery(page, limit, bizMd5, realPath, url, fileName, fileSize, fileFormat, bizType, downloadCount);
        }

    }




        public void setBizMd5(String bizMd5) {
            this.bizMd5 = bizMd5;
        }

        public String getBizMd5() {
            return bizMd5;
        }

        public void setRealPath(String realPath) {
            this.realPath = realPath;
        }

        public String getRealPath() {
            return realPath;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileSize(Long fileSize) {
            this.fileSize = fileSize;
        }

        public Long getFileSize() {
            return fileSize;
        }

        public void setFileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
        }

        public String getFileFormat() {
            return fileFormat;
        }

        public void setBizType(Integer bizType) {
            this.bizType = bizType;
        }

        public Integer getBizType() {
            return bizType;
        }

        public void setDownloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
        }

        public Integer getDownloadCount() {
            return downloadCount;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("bizMd5", getBizMd5())
                    .append("realPath", getRealPath())
                    .append("url", getUrl())
                    .append("fileName", getFileName())
                    .append("fileSize", getFileSize())
                    .append("fileFormat", getFileFormat())
                    .append("bizType", getBizType())
                    .append("downloadCount", getDownloadCount())
                .toString();
    }

}
