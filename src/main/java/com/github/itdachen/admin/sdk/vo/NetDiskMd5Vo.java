package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 文件MD5 Vo
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public class NetDiskMd5Vo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String id;

    /**
     * 文件MD5编码
     */
    private String md5;

    /**
     * 文件网络路径
     */
    private String realPath;

    /**
     * 文件URL
     */
    private String url;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件格式
     */
    private String fileFormat;


    public NetDiskMd5Vo() {
    }

    public NetDiskMd5Vo(String id, String md5, String realPath, String url, String fileName, Long fileSize, String fileFormat) {
        this.id = id;
        this.md5 = md5;
        this.realPath = realPath;
        this.url = url;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    public static NetDiskMd5VoBuilder builder() {
        return new NetDiskMd5VoBuilder();
    }

    public static class NetDiskMd5VoBuilder {
        private String id;
        private String md5;
        private String realPath;
        private String url;
        private String fileName;
        private Long fileSize;
        private String fileFormat;

        public NetDiskMd5VoBuilder() {
        }

        /*  */
        public NetDiskMd5VoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 文件MD5编码 */
        public NetDiskMd5VoBuilder md5(String md5) {
            this.md5 = md5;
            return this;
        }

        /* 文件网络路径 */
        public NetDiskMd5VoBuilder realPath(String realPath) {
            this.realPath = realPath;
            return this;
        }

        /* 文件URL */
        public NetDiskMd5VoBuilder url(String url) {
            this.url = url;
            return this;
        }

        /* 文件名称 */
        public NetDiskMd5VoBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /* 文件大小 */
        public NetDiskMd5VoBuilder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /* 文件格式 */
        public NetDiskMd5VoBuilder fileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
            return this;
        }

        public NetDiskMd5Vo build() {
            return new NetDiskMd5Vo(id,
                    md5,
                    realPath,
                    url,
                    fileName,
                    fileSize,
                    fileFormat
            );
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMd5() {
        return md5;
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


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("md5", getMd5())
                .append("realPath", getRealPath())
                .append("url", getUrl())
                .append("fileName", getFileName())
                .append("fileSize", getFileSize())
                .append("fileFormat", getFileFormat())
                .toString();
    }

}
