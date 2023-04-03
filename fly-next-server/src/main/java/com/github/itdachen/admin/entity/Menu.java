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
 * @date 2022-08-24 20:29:38
 */
@Table(name = "sys_menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 4790653574435292977L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 路径编码,权限编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 父级节点
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 资源路径,浏览器访问地址
     */
    @Column(name = "path")
    private String path;

    /**
     * 重定向路径
     */
    @Column(name = "redirect")
    private String redirect;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 类型:dirt-目录;menu-菜单;uri-外链
     */
    @Column(name = "type")
    private String type;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 是否显示:1-显示,0-不显示
     */
    @Column(name = "visible")
    private String visible;

    /**
     * 组件名称(路由中的 name 值)
     */
    @Column(name = "name")
    private String name;

    /**
     * 组件地址(vue中组件的地址)
     */
    @Column(name = "component")
    private String component;

    /**
     * 外链地址
     */
    @Column(name = "link")
    private String link;

    /**
     * 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项
     */
    @Column(name = "affix")
    private String affix;

    /**
     * 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）`
     */
    @Column(name = "iframe")
    private String iframe;

    /**
     * 菜单是否缓存
     */
    @Column(name = "keep_alive")
    private String keepAlive;

    /**
     * 描述
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;


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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
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
                .append("title", getTitle())
                .append("code", getCode())
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
