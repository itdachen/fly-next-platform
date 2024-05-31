package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 应用信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-19 21:22:54
 */
public class AppInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 平台ID
     */
    private String platId;

    /**
     * 平台名称
     */
    private String platTitle;

    /**
     * app秘钥
     */
    private String appSecret;

    /**
     * 应用标识
     */
    private String appCode;

    /**
     * 应用名称
     */
    private String appTitle;

    /**
     * 应用类型
     */
    private String typeCode;

    /**
     * 应用类型标题
     */
    private String typeTitle;

    /**
     * 访问地址
     */
    private String askUri;

    /**
     * 图标
     */
    private String iconIco;

    /**
     * 职能代码
     */
    private String funcCode;

    /**
     * 职能名称
     */
    private String funcTitle;

    /**
     * 是否可删除: Y-是;N-否
     */
    private String validDel;

    /**
     * 有效标志: Y-是;N-否
     */
    private String validFlag;


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

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setAskUri(String askUri) {
        this.askUri = askUri;
    }

    public String getAskUri() {
        return askUri;
    }

    public void setIconIco(String iconIco) {
        this.iconIco = iconIco;
    }

    public String getIconIco() {
        return iconIco;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
    }

    public void setValidDel(String validDel) {
        this.validDel = validDel;
    }

    public String getValidDel() {
        return validDel;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("platId", getPlatId())
                .append("platTitle", getPlatTitle())
                .append("appSecret", getAppSecret())
                .append("appCode", getAppCode())
                .append("appTitle", getAppTitle())
                .append("typeCode", getTypeCode())
                .append("typeTitle", getTypeTitle())
                .append("askUri", getAskUri())
                .append("iconIco", getIconIco())
                .append("funcCode", getFuncCode())
                .append("funcTitle", getFuncTitle())
                .append("validDel", getValidDel())
                .append("validFlag", getValidFlag())
                .toString();
    }

}
