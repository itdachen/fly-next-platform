package com.github.itdachen.auth.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * PearAdminLayui 菜单实体类
 *
 * @author 王大宸
 * @date 2024/4/23 23:17
 */
public class PearAdminRoute {


    private String id;

    /**
     * 菜单标题
     */
    private  String title;

    /**
     * 图标
     */
    private  String icon;

    /**
     * 菜单类型: 0-目录; 1-菜单
     */
    private  String type;

    /**
     * 菜单打开类型
     */
    private String openType;

    /**
     * 访问地址
     */
    private String href;

    /**
     * 子菜单
     */
    private List<PearAdminRoute> children = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<PearAdminRoute> getChildren() {
        return children;
    }

    public void setChildren(List<PearAdminRoute> children) {
        this.children = children;
    }
}
