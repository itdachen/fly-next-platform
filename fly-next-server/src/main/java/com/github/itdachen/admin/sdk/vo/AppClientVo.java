package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 应用管理 Vo
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
public class AppClientVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 应用标识码
     */
    private String appCode;

    /**
     * 应用类型
     */
    private String appType;

    /**
     * 应用名称
     */
    private String appTitle;

    /**
     * 互联网访问地址
     */
    private String askUri;

    /**
     * 内网访问地址
     */
    private String lanUri;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否启用1-是;0-否
     */
    private String status;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否可删除
     */
    private String canDel;


    public AppClientVo() {
    }

    public AppClientVo(String id, String appCode, String appType, String appTitle, String askUri, String lanUri, String icon, String status, String remarks, String canDel) {
        this.id = id;
        this.appCode = appCode;
        this.appType = appType;
        this.appTitle = appTitle;
        this.askUri = askUri;
        this.lanUri = lanUri;
        this.icon = icon;
        this.status = status;
        this.remarks = remarks;
        this.canDel = canDel;
    }

    public static AppClientVoBuilder builder() {
        return new AppClientVoBuilder();
    }

    public static class AppClientVoBuilder {
        private String id;
        private String appCode;
        private String appType;
        private String appTitle;
        private String askUri;
        private String lanUri;
        private String icon;
        private String status;
        private String remarks;
        private String canDel;

        public AppClientVoBuilder() {
        }

        /* 主键 */
        public AppClientVoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 应用标识码 */
        public AppClientVoBuilder appCode(String appCode) {
            this.appCode = appCode;
            return this;
        }

        /* 应用类型 */
        public AppClientVoBuilder appType(String appType) {
            this.appType = appType;
            return this;
        }

        /* 应用名称 */
        public AppClientVoBuilder appTitle(String appTitle) {
            this.appTitle = appTitle;
            return this;
        }

        /* 互联网访问地址 */
        public AppClientVoBuilder askUri(String askUri) {
            this.askUri = askUri;
            return this;
        }

        /* 内网访问地址 */
        public AppClientVoBuilder lanUri(String lanUri) {
            this.lanUri = lanUri;
            return this;
        }

        /* 图标 */
        public AppClientVoBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        /* 是否启用1-是;0-否 */
        public AppClientVoBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 备注 */
        public AppClientVoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        /* 是否可删除 */
        public AppClientVoBuilder canDel(String canDel) {
            this.canDel = canDel;
            return this;
        }

        public AppClientVo build() {
            return new AppClientVo(id,
                    appCode,
                    appType,
                    appTitle,
                    askUri,
                    lanUri,
                    icon,
                    status,
                    remarks,
                    canDel
            );
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAskUri(String askUri) {
        this.askUri = askUri;
    }

    public String getAskUri() {
        return askUri;
    }

    public void setLanUri(String lanUri) {
        this.lanUri = lanUri;
    }

    public String getLanUri() {
        return lanUri;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCanDel(String canDel) {
        this.canDel = canDel;
    }

    public String getCanDel() {
        return canDel;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("appCode", getAppCode())
                .append("appType", getAppType())
                .append("appTitle", getAppTitle())
                .append("askUri", getAskUri())
                .append("lanUri", getLanUri())
                .append("icon", getIcon())
                .append("status", getStatus())
                .append("remarks", getRemarks())
                .append("canDel", getCanDel())
                .toString();
    }

}
