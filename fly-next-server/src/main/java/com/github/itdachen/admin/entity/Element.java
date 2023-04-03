package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 按钮资源
 *
 * @author 王大宸
 * @date 2022-08-24 20:29:38
 */
@Table(name = "sys_element")
public class Element implements Serializable {
    private static final long serialVersionUID = 1438210343796601007L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 资源关联菜单
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 资源名称: 新增,编辑,删除 ... 等
     */
    @Column(name = "title")
    private String title;

    /**
     * 资源编码: 权限编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 资源类型: button,uri
     */
    @Column(name = "type")
    private String type;

    /**
     * 资源路径, 路径动态参数使用{*}: /admin/user/{*}
     */
    @Column(name = "href")
    private String href;

    /**
     * 视图路径, 路径动态参数使用{*}: /admin/user/{*}
     */
    @Column(name = "path")
    private String path;

    /**
     * 资源请求类型:GET,POST,PUT,DELETE
     */
    @Column(name = "method")
    private String method;

    /**
     * 状态:1-可用,0-禁用
     */
    @Column(name = "visible")
    private String visible;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 描述
     */
    @Column(name = "remark")
    private String remark;

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

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuId() {
        return menuId;
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return visible;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
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
                .append("menuId", getMenuId())
                .append("title", getTitle())
                .append("code", getCode())
                .append("type", getType())
                .append("href", getHref())
                .append("path", getPath())
                .append("method", getMethod())
                .append("visible", getVisible())
                .append("orderNum", getOrderNum())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
