package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 菜单管理 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class MenuInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    private String id;


    /**
     * 路径编码,权限编码
     */
    private String code;


    /**
     * 标题
     */
    private String title;


    /**
     * 客户端
     */
    private String clientId;


    /**
     * 父级节点
     */
    private String parentId;


    /**
     * 资源路径,浏览器访问地址
     */
    private String path;


    /**
     * 重定向路径
     */
    private String redirect;


    /**
     * Layui图标(JQ)
     */
    private String icon;


    /**
     * ElementUI图标
     */
    private String elementIcon;


    /**
     * LayuiUIVue图标
     */
    private String layuiIcon;


    /**
     * 类型:dirt-目录;menu-菜单;uri-外链
     */
    private String type;


    /**
     * 排序
     */
    private Integer orderNum;


    /**
     * 是否显示:1-显示,0-不显示
     */
    private String visible;


    /**
     * 组件名称(路由中的 name 值)
     */
    private String name;


    /**
     * 组件地址(vue中组件的地址)
     */
    private String component;


    /**
     * 外链地址
     */
    private String link;


    /**
     * 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项
     */
    private String affix;


    /**
     * 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）`
     */
    private String iframe;


    /**
     * 菜单是否缓存
     */
    private String keepAlive;


    /**
     * 描述
     */
    private String remarks;


    public MenuInfoDto() {
    }

    public MenuInfoDto(String id, String code, String title, String clientId, String parentId, String path, String redirect, String icon, String elementIcon, String layuiIcon, String type, Integer orderNum, String visible, String name, String component, String link, String affix, String iframe, String keepAlive, String remarks) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.clientId = clientId;
        this.parentId = parentId;
        this.path = path;
        this.redirect = redirect;
        this.icon = icon;
        this.elementIcon = elementIcon;
        this.layuiIcon = layuiIcon;
        this.type = type;
        this.orderNum = orderNum;
        this.visible = visible;
        this.name = name;
        this.component = component;
        this.link = link;
        this.affix = affix;
        this.iframe = iframe;
        this.keepAlive = keepAlive;
        this.remarks = remarks;
    }

    public static MenuInfoDtoBuilder builder() {
        return new MenuInfoDtoBuilder();
    }

    public static class MenuInfoDtoBuilder {
        private String id;
        private String code;
        private String title;
        private String clientId;
        private String parentId;
        private String path;
        private String redirect;
        private String icon;
        private String elementIcon;
        private String layuiIcon;
        private String type;
        private Integer orderNum;
        private String visible;
        private String name;
        private String component;
        private String link;
        private String affix;
        private String iframe;
        private String keepAlive;
        private String remarks;

        public MenuInfoDtoBuilder() {
        }

        /* 主键唯一标识 */
        public MenuInfoDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 路径编码,权限编码 */
        public MenuInfoDtoBuilder code(String code) {
            this.code = code;
            return this;
        }

        /* 标题 */
        public MenuInfoDtoBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 客户端 */
        public MenuInfoDtoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /* 父级节点 */
        public MenuInfoDtoBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /* 资源路径,浏览器访问地址 */
        public MenuInfoDtoBuilder path(String path) {
            this.path = path;
            return this;
        }

        /* 重定向路径 */
        public MenuInfoDtoBuilder redirect(String redirect) {
            this.redirect = redirect;
            return this;
        }

        /* Layui图标(JQ) */
        public MenuInfoDtoBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        /* ElementUI图标 */
        public MenuInfoDtoBuilder elementIcon(String elementIcon) {
            this.elementIcon = elementIcon;
            return this;
        }

        /* LayuiUIVue图标 */
        public MenuInfoDtoBuilder layuiIcon(String layuiIcon) {
            this.layuiIcon = layuiIcon;
            return this;
        }

        /* 类型:dirt-目录;menu-菜单;uri-外链 */
        public MenuInfoDtoBuilder type(String type) {
            this.type = type;
            return this;
        }

        /* 排序 */
        public MenuInfoDtoBuilder orderNum(Integer orderNum) {
            this.orderNum = orderNum;
            return this;
        }

        /* 是否显示:1-显示,0-不显示 */
        public MenuInfoDtoBuilder visible(String visible) {
            this.visible = visible;
            return this;
        }

        /* 组件名称(路由中的 name 值) */
        public MenuInfoDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        /* 组件地址(vue中组件的地址) */
        public MenuInfoDtoBuilder component(String component) {
            this.component = component;
            return this;
        }

        /* 外链地址 */
        public MenuInfoDtoBuilder link(String link) {
            this.link = link;
            return this;
        }

        /* 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
        public MenuInfoDtoBuilder affix(String affix) {
            this.affix = affix;
            return this;
        }

        /* 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
        public MenuInfoDtoBuilder iframe(String iframe) {
            this.iframe = iframe;
            return this;
        }

        /* 菜单是否缓存 */
        public MenuInfoDtoBuilder keepAlive(String keepAlive) {
            this.keepAlive = keepAlive;
            return this;
        }

        /* 描述 */
        public MenuInfoDtoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public MenuInfoDto build() {
            return new MenuInfoDto(id, code, title, clientId, parentId, path, redirect, icon, elementIcon, layuiIcon, type, orderNum, visible, name, component, link, affix, iframe, keepAlive, remarks);
        }

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setElementIcon(String elementIcon) {
        this.elementIcon = elementIcon;
    }

    public String getElementIcon() {
        return elementIcon;
    }

    public void setLayuiIcon(String layuiIcon) {
        this.layuiIcon = layuiIcon;
    }

    public String getLayuiIcon() {
        return layuiIcon;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return visible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setAffix(String affix) {
        this.affix = affix;
    }

    public String getAffix() {
        return affix;
    }

    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    public String getIframe() {
        return iframe;
    }

    public void setKeepAlive(String keepAlive) {
        this.keepAlive = keepAlive;
    }

    public String getKeepAlive() {
        return keepAlive;
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
                .append("code", getCode())
                .append("title", getTitle())
                .append("clientId", getClientId())
                .append("parentId", getParentId())
                .append("path", getPath())
                .append("redirect", getRedirect())
                .append("icon", getIcon())
                .append("elementIcon", getElementIcon())
                .append("layuiIcon", getLayuiIcon())
                .append("type", getType())
                .append("orderNum", getOrderNum())
                .append("visible", getVisible())
                .append("name", getName())
                .append("component", getComponent())
                .append("link", getLink())
                .append("affix", getAffix())
                .append("iframe", getIframe())
                .append("keepAlive", getKeepAlive())
                .append("remarks", getRemarks())
                .toString();
    }

}
