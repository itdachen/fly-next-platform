package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 文件信息表 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public class NetDiskInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /**  */
        private String id;


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


    public NetDiskInfoDto() {}

    public NetDiskInfoDto(String id, String bizMd5, String realPath, String url, String fileName, Long fileSize, String fileFormat, Integer bizType, Integer downloadCount) {
            this.id = id;
            this.bizMd5 = bizMd5;
            this.realPath = realPath;
            this.url = url;
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.fileFormat = fileFormat;
            this.bizType = bizType;
            this.downloadCount = downloadCount;
    }

    public static NetDiskInfoDtoBuilder builder() {
        return new NetDiskInfoDtoBuilder();
    }

    public static class NetDiskInfoDtoBuilder {
            private String id;
            private String bizMd5;
            private String realPath;
            private String url;
            private String fileName;
            private Long fileSize;
            private String fileFormat;
            private Integer bizType;
            private Integer downloadCount;

        public NetDiskInfoDtoBuilder() {}

            /*  */
            public NetDiskInfoDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 文件MD5 */
            public NetDiskInfoDtoBuilder bizMd5(String bizMd5) {
                this.bizMd5 = bizMd5;
                return this;
            }
            /* 真实路径 */
            public NetDiskInfoDtoBuilder realPath(String realPath) {
                this.realPath = realPath;
                return this;
            }
            /* 网络路径 */
            public NetDiskInfoDtoBuilder url(String url) {
                this.url = url;
                return this;
            }
            /* 文件名称 */
            public NetDiskInfoDtoBuilder fileName(String fileName) {
                this.fileName = fileName;
                return this;
            }
            /* 文件大小 */
            public NetDiskInfoDtoBuilder fileSize(Long fileSize) {
                this.fileSize = fileSize;
                return this;
            }
            /* 文件格式 */
            public NetDiskInfoDtoBuilder fileFormat(String fileFormat) {
                this.fileFormat = fileFormat;
                return this;
            }
            /* 文件类型：1-通用文件;2-头像 */
            public NetDiskInfoDtoBuilder bizType(Integer bizType) {
                this.bizType = bizType;
                return this;
            }
            /* 下载量 */
            public NetDiskInfoDtoBuilder downloadCount(Integer downloadCount) {
                this.downloadCount = downloadCount;
                return this;
            }

        public NetDiskInfoDto build() {
            return new NetDiskInfoDto(id, bizMd5, realPath, url, fileName, fileSize, fileFormat, bizType, downloadCount);
        }

    }



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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
                    .append("id", getId())
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
