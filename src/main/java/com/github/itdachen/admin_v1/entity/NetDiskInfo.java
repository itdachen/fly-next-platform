package com.github.itdachen.admin_v1.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 文件信息表
 *
 * @author 王大宸
 * @date 2023-04-14 23:19:02
 */
@Table(name = "sys_net_disk_info")
public class NetDiskInfo implements Serializable{
private static final long serialVersionUID=1L;

    /**  */
    @Id
    @Column(name = "id")
    private String id;

    /** 文件MD5 */
    @Column(name = "biz_md5")
    private String bizMd5;

    /** 真实路径 */
    @Column(name = "real_path")
    private String realPath;

    /** 网络路径 */
    @Column(name = "url")
    private String url;

    /** 文件名称 */
    @Column(name = "file_name")
    private String fileName;

    /** 文件大小 */
    @Column(name = "file_size")
    private Long fileSize;

    /** 文件格式 */
    @Column(name = "file_format")
    private String fileFormat;

    /** 文件类型：1-通用文件;2-头像 */
    @Column(name = "biz_type")
    private Integer bizType;

    /** 下载量 */
    @Column(name = "download_count")
    private Integer downloadCount;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**  */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 创建人姓名 */
    @Column(name = "create_user")
    private String createUser;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**  */
    @Column(name = "update_user_id")
    private String updateUserId;

    /** 更新人姓名 */
    @Column(name = "update_user")
    private String updateUser;


public NetDiskInfo(){}


public NetDiskInfo(    String id,     String bizMd5,     String realPath,     String url,     String fileName,     Long fileSize,     String fileFormat,     Integer bizType,     Integer downloadCount,     LocalDateTime createTime,     String createUserId,     String createUser,     LocalDateTime updateTime,     String updateUserId,     String updateUser){
            this.id = id;
            this.bizMd5 = bizMd5;
            this.realPath = realPath;
            this.url = url;
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.fileFormat = fileFormat;
            this.bizType = bizType;
            this.downloadCount = downloadCount;
            this.createTime = createTime;
            this.createUserId = createUserId;
            this.createUser = createUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
            this.updateUser = updateUser;
}

public static NetDiskInfoBuilder builder(){
        return new NetDiskInfoBuilder();
        }

public static class NetDiskInfoBuilder {
        private String id;
        private String bizMd5;
        private String realPath;
        private String url;
        private String fileName;
        private Long fileSize;
        private String fileFormat;
        private Integer bizType;
        private Integer downloadCount;
        private LocalDateTime createTime;
        private String createUserId;
        private String createUser;
        private LocalDateTime updateTime;
        private String updateUserId;
        private String updateUser;

    public NetDiskInfoBuilder() {
    }

        /*  */
        public NetDiskInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 文件MD5 */
        public NetDiskInfoBuilder bizMd5(String bizMd5) {
            this.bizMd5 = bizMd5;
            return this;
        }
        /* 真实路径 */
        public NetDiskInfoBuilder realPath(String realPath) {
            this.realPath = realPath;
            return this;
        }
        /* 网络路径 */
        public NetDiskInfoBuilder url(String url) {
            this.url = url;
            return this;
        }
        /* 文件名称 */
        public NetDiskInfoBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        /* 文件大小 */
        public NetDiskInfoBuilder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }
        /* 文件格式 */
        public NetDiskInfoBuilder fileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
            return this;
        }
        /* 文件类型：1-通用文件;2-头像 */
        public NetDiskInfoBuilder bizType(Integer bizType) {
            this.bizType = bizType;
            return this;
        }
        /* 下载量 */
        public NetDiskInfoBuilder downloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
            return this;
        }
        /* 创建时间 */
        public NetDiskInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /*  */
        public NetDiskInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建人姓名 */
        public NetDiskInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 更新时间 */
        public NetDiskInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /*  */
        public NetDiskInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }
        /* 更新人姓名 */
        public NetDiskInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

    public NetDiskInfo build() {
        return new NetDiskInfo(            id, 
            bizMd5, 
            realPath, 
            url, 
            fileName, 
            fileSize, 
            fileFormat, 
            bizType, 
            downloadCount, 
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
                    .append("bizMd5", getBizMd5())
                    .append("realPath", getRealPath())
                    .append("url", getUrl())
                    .append("fileName", getFileName())
                    .append("fileSize", getFileSize())
                    .append("fileFormat", getFileFormat())
                    .append("bizType", getBizType())
                    .append("downloadCount", getDownloadCount())
                    .append("createTime", getCreateTime())
                    .append("createUserId", getCreateUserId())
                    .append("createUser", getCreateUser())
                    .append("updateTime", getUpdateTime())
                    .append("updateUserId", getUpdateUserId())
                    .append("updateUser", getUpdateUser())
                .toString();
    }


}
