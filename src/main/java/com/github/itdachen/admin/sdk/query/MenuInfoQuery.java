package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 菜单管理 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class MenuInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 路径编码,权限编码 */
            private String code;

            /** 标题 */
            private String title;

            /** 客户端 */
            private String clientId;

            /** 父级节点 */
            private String parentId;

            /** 资源路径,浏览器访问地址 */
            private String path;

            /** 重定向路径 */
            private String redirect;

            /** 图标 */
            private String icon;

            /** 类型:dirt-目录;menu-菜单;uri-外链 */
            private String type;

            /** 排序 */
            private Integer orderNum;

            /** 是否显示:1-显示,0-不显示 */
            private String visible;

            /** 组件名称(路由中的 name 值) */
            private String name;

            /** 组件地址(vue中组件的地址) */
            private String component;

            /** 外链地址 */
            private String link;

            /** 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
            private String affix;

            /** 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
            private String iframe;

            /** 菜单是否缓存 */
            private String keepAlive;


    public MenuInfoQuery() {
    }

    public MenuInfoQuery(int page, int limit, String code, String title, String clientId, String parentId, String path, String redirect, String icon, String type, Integer orderNum, String visible, String name, String component, String link, String affix, String iframe, String keepAlive) {
        super(page, limit);
            this.code = code;
            this.title = title;
            this.clientId = clientId;
            this.parentId = parentId;
            this.path = path;
            this.redirect = redirect;
            this.icon = icon;
            this.type = type;
            this.orderNum = orderNum;
            this.visible = visible;
            this.name = name;
            this.component = component;
            this.link = link;
            this.affix = affix;
            this.iframe = iframe;
            this.keepAlive = keepAlive;
    }

    public static MenuInfoQueryBuilder builder() {
        return new MenuInfoQueryBuilder();
    }

    public static class MenuInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String code;
            private String title;
            private String clientId;
            private String parentId;
            private String path;
            private String redirect;
            private String icon;
            private String type;
            private Integer orderNum;
            private String visible;
            private String name;
            private String component;
            private String link;
            private String affix;
            private String iframe;
            private String keepAlive;

        public MenuInfoQueryBuilder() {
        }

        public MenuInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public MenuInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 路径编码,权限编码 */
            public MenuInfoQueryBuilder code(String code) {
                this.code = code;
                return this;
            }
            /* 标题 */
            public MenuInfoQueryBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 客户端 */
            public MenuInfoQueryBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }
            /* 父级节点 */
            public MenuInfoQueryBuilder parentId(String parentId) {
                this.parentId = parentId;
                return this;
            }
            /* 资源路径,浏览器访问地址 */
            public MenuInfoQueryBuilder path(String path) {
                this.path = path;
                return this;
            }
            /* 重定向路径 */
            public MenuInfoQueryBuilder redirect(String redirect) {
                this.redirect = redirect;
                return this;
            }
            /* 图标 */
            public MenuInfoQueryBuilder icon(String icon) {
                this.icon = icon;
                return this;
            }
            /* 类型:dirt-目录;menu-菜单;uri-外链 */
            public MenuInfoQueryBuilder type(String type) {
                this.type = type;
                return this;
            }
            /* 排序 */
            public MenuInfoQueryBuilder orderNum(Integer orderNum) {
                this.orderNum = orderNum;
                return this;
            }
            /* 是否显示:1-显示,0-不显示 */
            public MenuInfoQueryBuilder visible(String visible) {
                this.visible = visible;
                return this;
            }
            /* 组件名称(路由中的 name 值) */
            public MenuInfoQueryBuilder name(String name) {
                this.name = name;
                return this;
            }
            /* 组件地址(vue中组件的地址) */
            public MenuInfoQueryBuilder component(String component) {
                this.component = component;
                return this;
            }
            /* 外链地址 */
            public MenuInfoQueryBuilder link(String link) {
                this.link = link;
                return this;
            }
            /* 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
            public MenuInfoQueryBuilder affix(String affix) {
                this.affix = affix;
                return this;
            }
            /* 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
            public MenuInfoQueryBuilder iframe(String iframe) {
                this.iframe = iframe;
                return this;
            }
            /* 菜单是否缓存 */
            public MenuInfoQueryBuilder keepAlive(String keepAlive) {
                this.keepAlive = keepAlive;
                return this;
            }

        public MenuInfoQuery build() {
            return new MenuInfoQuery(page, limit, code, title, clientId, parentId, path, redirect, icon, type, orderNum, visible, name, component, link, affix, iframe, keepAlive);
        }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("code", getCode())
                    .append("title", getTitle())
                    .append("clientId", getClientId())
                    .append("parentId", getParentId())
                    .append("path", getPath())
                    .append("redirect", getRedirect())
                    .append("icon", getIcon())
                    .append("type", getType())
                    .append("orderNum", getOrderNum())
                    .append("visible", getVisible())
                    .append("name", getName())
                    .append("component", getComponent())
                    .append("link", getLink())
                    .append("affix", getAffix())
                    .append("iframe", getIframe())
                    .append("keepAlive", getKeepAlive())
                .toString();
    }

}
