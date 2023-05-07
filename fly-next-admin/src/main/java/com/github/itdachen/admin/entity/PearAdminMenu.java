package com.github.itdachen.admin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/06 23:53
 * Created with IntelliJ IDEA.
 */
public class PearAdminMenu implements Serializable {
    private static final long serialVersionUID = 8077781086268050048L;

    /**
     * id
     */
    private String id;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 菜单图标 前面需要添加 layui-icon
     */
    private String icon;

    /**
     * 类型: 1-菜单;0-目录
     */
    private String type;

    /**
     * 访问地址
     */
    private String href;

    /**
     * 打开方式
     */
    private String openType;

    /**
     * 子菜单
     */
    private List<PearAdminMenu> children = new ArrayList<>();

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public List<PearAdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<PearAdminMenu> children) {
        this.children = children;
    }
}
