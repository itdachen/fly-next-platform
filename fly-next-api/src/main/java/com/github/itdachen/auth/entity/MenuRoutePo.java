package com.github.itdachen.auth.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/08 21:17
 * Created with IntelliJ IDEA.
 */
public class MenuRoutePo implements Serializable {
    private static final long serialVersionUID = 1708407152446144376L;

    private String id;

    private String path;

    private String name;

    private String component;

    private String redirect;

    private String title;
    private String icon;
    private String parentId;

    // 菜单外链链接
    // 开启外链条件，`1、isLink: true 2、链接地址不为空（meta.isLink） 3、isIframe: false`
    private String isLink = "";

    // 菜单是否隐藏（菜单不显示在界面，但可以进行跳转）
    private Boolean isHide = false;

    // 菜单是否缓存
    private Boolean isKeepAlive = true;

    // 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项
    private Boolean isAffix = false;

    // 是否内嵌
    // 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）`
    private Boolean isIframe = false;

    // 当前路由权限标识，取角色管理。控制路由显示、隐藏。超级管理员：admin 普通角色：common
    // 之前 auth 取用户（角色下有多个用户）
    private List<String> roles = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIsLink() {
        return isLink;
    }

    public void setIsLink(String isLink) {
        this.isLink = isLink;
    }

    public Boolean getIsHide() {
        return isHide;
    }

    public void setIsHide(Boolean hide) {
        isHide = hide;
    }

    public Boolean getIsKeepAlive() {
        return isKeepAlive;
    }

    public void setIsKeepAlive(Boolean keepAlive) {
        isKeepAlive = keepAlive;
    }

    public Boolean getIsAffix() {
        return isAffix;
    }

    public void setIsAffix(Boolean affix) {
        isAffix = affix;
    }

    public Boolean getIsIframe() {
        return isIframe;
    }

    public void setIsIframe(Boolean iframe) {
        isIframe = iframe;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

}
