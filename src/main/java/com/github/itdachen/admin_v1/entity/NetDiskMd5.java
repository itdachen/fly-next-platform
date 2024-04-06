package com.github.itdachen.admin_v1.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件MD5
 *
 * @author 王大宸
 * @date 2023-04-14 23:19:02
 */
public class NetDiskMd5 implements Serializable {
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private String createUserId;

    /**
     * 创建人姓名
     */
    private String createUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     *
     */
    private String updateUserId;

    /**
     * 更新人姓名
     */
    private String updateUser;


    public NetDiskMd5() {
    }

    public NetDiskMd5(String id, String md5, String realPath, String url, String fileName, Long fileSize, String fileFormat, LocalDateTime createTime, String createUserId, String createUser, LocalDateTime updateTime, String updateUserId, String updateUser) {
        this.id = id;
        this.md5 = md5;
        this.realPath = realPath;
        this.url = url;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.updateUser = updateUser;
    }

    public static NetDiskMd5Builder builder() {
        return new NetDiskMd5Builder();
    }

    public static class NetDiskMd5Builder {
        private String id;
        private String md5;
        private String realPath;
        private String url;
        private String fileName;
        private Long fileSize;
        private String fileFormat;
        private LocalDateTime createTime;
        private String createUserId;
        private String createUser;
        private LocalDateTime updateTime;
        private String updateUserId;
        private String updateUser;

        public NetDiskMd5Builder() {
        }

        /*  */
        public NetDiskMd5Builder id(String id) {
            this.id = id;
            return this;
        }

        /* 文件MD5编码 */
        public NetDiskMd5Builder md5(String md5) {
            this.md5 = md5;
            return this;
        }

        /* 文件网络路径 */
        public NetDiskMd5Builder realPath(String realPath) {
            this.realPath = realPath;
            return this;
        }

        /* 文件URL */
        public NetDiskMd5Builder url(String url) {
            this.url = url;
            return this;
        }

        /* 文件名称 */
        public NetDiskMd5Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /* 文件大小 */
        public NetDiskMd5Builder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /* 文件格式 */
        public NetDiskMd5Builder fileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
            return this;
        }

        /* 创建时间 */
        public NetDiskMd5Builder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        /*  */
        public NetDiskMd5Builder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        /* 创建人姓名 */
        public NetDiskMd5Builder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }

        /* 更新时间 */
        public NetDiskMd5Builder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        /*  */
        public NetDiskMd5Builder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

        /* 更新人姓名 */
        public NetDiskMd5Builder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

        public NetDiskMd5 build() {
            return new NetDiskMd5(id,
                    md5,
                    realPath,
                    url,
                    fileName,
                    fileSize,
                    fileFormat,
                    createTime,
                    createUserId,
                    createUser,
                    updateTime,
                    updateUserId,
                    updateUser
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

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
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
                .append("createTime", getCreateTime())
                .append("createUserId", getCreateUserId())
                .append("createUser", getCreateUser())
                .append("updateTime", getUpdateTime())
                .append("updateUserId", getUpdateUserId())
                .append("updateUser", getUpdateUser())
                .toString();
    }


}
