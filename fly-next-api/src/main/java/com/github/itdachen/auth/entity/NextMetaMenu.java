package com.github.itdachen.auth.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 菜单
 * Created by 王大宸 on 2023/05/08 20:58
 * Created with IntelliJ IDEA.
 */
public class NextMetaMenu implements Serializable {
    private static final long serialVersionUID = 3839170974048447303L;

    /**
     * 菜单标题（国际化写法）
     */
    private String title;

    private String icon = "iconfont icon-shouye";

    private String parentId;

    // 菜单外链链接
    // 开启外链条件，`1、isLink: true 2、链接地址不为空（meta.isLink） 3、isIframe: false`
    private String isLink = "";

    // 菜单是否隐藏（菜单不显示在界面，但可以进行跳转）
    private Boolean isHide = false;

    // 菜单是否缓存
    private Boolean isKeepAlive = false;

    // 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项
    private Boolean isAffix = false;

    // 是否内嵌
    // 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）`
    private Boolean isIframe = false;

    // 当前路由权限标识，取角色管理。控制路由显示、隐藏。超级管理员：admin 普通角色：common
    // 之前 auth 取用户（角色下有多个用户）
    // 已废弃
    private List<String> roles = new ArrayList<>();


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


}
