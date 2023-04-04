package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
    import java.time.LocalDateTime;



/**
 * 菜单管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Table(name = "sys_menu_info")
public class MenuInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 路径编码,权限编码 */
    @Column(name = "code")
    private String code;

    /** 标题 */
    @Column(name = "title")
    private String title;

    /** 客户端 */
    @Column(name = "client_id")
    private String clientId;

    /** 父级节点 */
    @Column(name = "parent_id")
    private String parentId;

    /** 资源路径,浏览器访问地址 */
    @Column(name = "path")
    private String path;

    /** 重定向路径 */
    @Column(name = "redirect")
    private String redirect;

    /** 图标 */
    @Column(name = "icon")
    private String icon;

    /** 类型:dirt-目录;menu-菜单;uri-外链 */
    @Column(name = "type")
    private String type;

    /** 排序 */
    @Column(name = "order_num")
    private Integer orderNum;

    /** 是否显示:1-显示,0-不显示 */
    @Column(name = "visible")
    private String visible;

    /** 组件名称(路由中的 name 值) */
    @Column(name = "name")
    private String name;

    /** 组件地址(vue中组件的地址) */
    @Column(name = "component")
    private String component;

    /** 外链地址 */
    @Column(name = "link")
    private String link;

    /** 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
    @Column(name = "affix")
    private String affix;

    /** 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
    @Column(name = "iframe")
    private String iframe;

    /** 菜单是否缓存 */
    @Column(name = "keep_alive")
    private String keepAlive;

    /** 描述 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId;


public MenuInfo(){}


public MenuInfo(    String id,     String code,     String title,     String clientId,     String parentId,     String path,     String redirect,     String icon,     String type,     Integer orderNum,     String visible,     String name,     String component,     String link,     String affix,     String iframe,     String keepAlive,     String remarks,     LocalDateTime createTime,     String createUser,     String createUserId,     LocalDateTime updateTime,     String updateUser,     String updateUserId){
            this.id = id;
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
            this.remarks = remarks;
            this.createTime = createTime;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.updateTime = updateTime;
            this.updateUser = updateUser;
            this.updateUserId = updateUserId;
}

public static MenuInfoBuilder builder(){
        return new MenuInfoBuilder();
        }

public static class MenuInfoBuilder {
        private String id;
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
        private String remarks;
        private LocalDateTime createTime;
        private String createUser;
        private String createUserId;
        private LocalDateTime updateTime;
        private String updateUser;
        private String updateUserId;

    public MenuInfoBuilder() {
    }

        /* 主键唯一标识 */
        public MenuInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 路径编码,权限编码 */
        public MenuInfoBuilder code(String code) {
            this.code = code;
            return this;
        }
        /* 标题 */
        public MenuInfoBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 客户端 */
        public MenuInfoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        /* 父级节点 */
        public MenuInfoBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }
        /* 资源路径,浏览器访问地址 */
        public MenuInfoBuilder path(String path) {
            this.path = path;
            return this;
        }
        /* 重定向路径 */
        public MenuInfoBuilder redirect(String redirect) {
            this.redirect = redirect;
            return this;
        }
        /* 图标 */
        public MenuInfoBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }
        /* 类型:dirt-目录;menu-菜单;uri-外链 */
        public MenuInfoBuilder type(String type) {
            this.type = type;
            return this;
        }
        /* 排序 */
        public MenuInfoBuilder orderNum(Integer orderNum) {
            this.orderNum = orderNum;
            return this;
        }
        /* 是否显示:1-显示,0-不显示 */
        public MenuInfoBuilder visible(String visible) {
            this.visible = visible;
            return this;
        }
        /* 组件名称(路由中的 name 值) */
        public MenuInfoBuilder name(String name) {
            this.name = name;
            return this;
        }
        /* 组件地址(vue中组件的地址) */
        public MenuInfoBuilder component(String component) {
            this.component = component;
            return this;
        }
        /* 外链地址 */
        public MenuInfoBuilder link(String link) {
            this.link = link;
            return this;
        }
        /* 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
        public MenuInfoBuilder affix(String affix) {
            this.affix = affix;
            return this;
        }
        /* 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
        public MenuInfoBuilder iframe(String iframe) {
            this.iframe = iframe;
            return this;
        }
        /* 菜单是否缓存 */
        public MenuInfoBuilder keepAlive(String keepAlive) {
            this.keepAlive = keepAlive;
            return this;
        }
        /* 描述 */
        public MenuInfoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 创建时间 */
        public MenuInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人 */
        public MenuInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建人id */
        public MenuInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 更新时间 */
        public MenuInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人 */
        public MenuInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新人id */
        public MenuInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public MenuInfo build() {
        return new MenuInfo(            id, 
            code, 
            title, 
            clientId, 
            parentId, 
            path, 
            redirect, 
            icon, 
            type, 
            orderNum, 
            visible, 
            name, 
            component, 
            link, 
            affix, 
            iframe, 
            keepAlive, 
            remarks, 
            createTime, 
            createUser, 
            createUserId, 
            updateTime, 
            updateUser, 
            updateUserId
);
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

            public void setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setUpdateTime(LocalDateTime updateTime) {
                this.updateTime = updateTime;
            }

            public LocalDateTime getUpdateTime() {
                return updateTime;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUserId() {
                return updateUserId;
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
                    .append("createTime", getCreateTime())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateTime", getUpdateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
