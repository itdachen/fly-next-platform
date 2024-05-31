package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 平台信息 VO
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
public class PlatformInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 平台ID
     */
    private String id;

    /**
     * 平台名称
     */
    private String title;

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

    /**
     * 备注
     */
    private String remarks;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("iconIco", getIconIco())
                .append("funcCode", getFuncCode())
                .append("funcTitle", getFuncTitle())
                .append("validDel", getValidDel())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .toString();
    }

}
