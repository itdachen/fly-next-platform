package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 文件MD5 查询参数
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public class NetDiskMd5Query extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

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


    public NetDiskMd5Query() {
    }

    public NetDiskMd5Query(int page, int limit, String md5, String realPath, String url, String fileName, Long fileSize, String fileFormat) {
        super(page, limit);
        this.md5 = md5;
        this.realPath = realPath;
        this.url = url;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    public static NetDiskMd5QueryBuilder builder() {
        return new NetDiskMd5QueryBuilder();
    }

    public static class NetDiskMd5QueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String md5;
        private String realPath;
        private String url;
        private String fileName;
        private Long fileSize;
        private String fileFormat;

        public NetDiskMd5QueryBuilder() {
        }

        public NetDiskMd5QueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public NetDiskMd5QueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 文件MD5编码 */
        public NetDiskMd5QueryBuilder md5(String md5) {
            this.md5 = md5;
            return this;
        }

        /* 文件网络路径 */
        public NetDiskMd5QueryBuilder realPath(String realPath) {
            this.realPath = realPath;
            return this;
        }

        /* 文件URL */
        public NetDiskMd5QueryBuilder url(String url) {
            this.url = url;
            return this;
        }

        /* 文件名称 */
        public NetDiskMd5QueryBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /* 文件大小 */
        public NetDiskMd5QueryBuilder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /* 文件格式 */
        public NetDiskMd5QueryBuilder fileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
            return this;
        }

        public NetDiskMd5Query build() {
            return new NetDiskMd5Query(page, limit, md5, realPath, url, fileName, fileSize, fileFormat);
        }

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
                .append("page", getPage())
                .append("limit", getLimit())
                .append("md5", getMd5())
                .append("realPath", getRealPath())
                .append("url", getUrl())
                .append("fileName", getFileName())
                .append("fileSize", getFileSize())
                .append("fileFormat", getFileFormat())
                .toString();
    }

}
