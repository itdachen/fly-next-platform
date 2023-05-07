package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: ok-admin 菜单
 * Created by 王大宸 on 2021-01-26 15:16
 * Created with IntelliJ IDEA.
 */
public class OkAdminMenu implements Serializable {
    private static final long serialVersionUID = -6794194573350682589L;

    private String id;

    /**
     * 上级id
     */
    private String parentId;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 字体
     */
    private String fontFamily;

    /**
     * 跳转路径
     */
    private String href;

    /**
     * 图标
     */
    private String icon;

    /**
     * 设置导航页是否关闭(默认true)
     */
    private Boolean isClose;

    /**
     * 设置是否打开
     */
    private Boolean spread;

    /**
     * 是否选中
     */
    private Boolean isCheck;

    /**
     * 打开方式 _blank：覆盖当前窗口
     */
    private String target;

    /**
     * 子导航 参数同上（可嵌套无限个）
     */
    private List<OkAdminMenu> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getClose() {
        return isClose;
    }

    public void setClose(Boolean close) {
        isClose = close;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<OkAdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<OkAdminMenu> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("parentId", getParentId())
                .append("title", getTitle())
                .append("href", getHref())
                .append("fontFamily", getFontFamily())
                .append("icon", getIcon())
                .append("spread", getSpread())
                .append("target", getTarget())
                .append("children", getChildren())
                .toString();
    }

}
