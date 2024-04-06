package com.github.itdachen.admin_v1.entity;

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
 * @date 2023-04-04 21:44:47
 */
@Table(name = "sys_element_info")
public class ElementInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 资源关联菜单 */
    @Column(name = "menu_id")
    private String menuId;

    /** 资源名称: 新增,编辑,删除 ... 等 */
    @Column(name = "title")
    private String title;

    /** 资源编码: 权限编码 */
    @Column(name = "code")
    private String code;

    /** 资源类型: button,uri */
    @Column(name = "type")
    private String type;

    /** 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
    @Column(name = "href")
    private String href;

    /** 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
    @Column(name = "path")
    private String path;

    /** 资源请求类型:GET,POST,PUT,DELETE */
    @Column(name = "method")
    private String method;

    /** 排序 */
    @Column(name = "order_num")
    private Integer orderNum;

    /** 状态:1-可用,0-禁用 */
    @Column(name = "visible")
    private String visible;

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


public ElementInfo(){}


public ElementInfo(    String id,     String menuId,     String title,     String code,     String type,     String href,     String path,     String method,     Integer orderNum,     String visible,     String remarks,     LocalDateTime createTime,     String createUser,     String createUserId,     LocalDateTime updateTime,     String updateUser,     String updateUserId){
            this.id = id;
            this.menuId = menuId;
            this.title = title;
            this.code = code;
            this.type = type;
            this.href = href;
            this.path = path;
            this.method = method;
            this.orderNum = orderNum;
            this.visible = visible;
            this.remarks = remarks;
            this.createTime = createTime;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.updateTime = updateTime;
            this.updateUser = updateUser;
            this.updateUserId = updateUserId;
}

public static ElementInfoBuilder builder(){
        return new ElementInfoBuilder();
        }

public static class ElementInfoBuilder {
        private String id;
        private String menuId;
        private String title;
        private String code;
        private String type;
        private String href;
        private String path;
        private String method;
        private Integer orderNum;
        private String visible;
        private String remarks;
        private LocalDateTime createTime;
        private String createUser;
        private String createUserId;
        private LocalDateTime updateTime;
        private String updateUser;
        private String updateUserId;

    public ElementInfoBuilder() {
    }

        /* 主键唯一标识 */
        public ElementInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 资源关联菜单 */
        public ElementInfoBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }
        /* 资源名称: 新增,编辑,删除 ... 等 */
        public ElementInfoBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 资源编码: 权限编码 */
        public ElementInfoBuilder code(String code) {
            this.code = code;
            return this;
        }
        /* 资源类型: button,uri */
        public ElementInfoBuilder type(String type) {
            this.type = type;
            return this;
        }
        /* 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
        public ElementInfoBuilder href(String href) {
            this.href = href;
            return this;
        }
        /* 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
        public ElementInfoBuilder path(String path) {
            this.path = path;
            return this;
        }
        /* 资源请求类型:GET,POST,PUT,DELETE */
        public ElementInfoBuilder method(String method) {
            this.method = method;
            return this;
        }
        /* 排序 */
        public ElementInfoBuilder orderNum(Integer orderNum) {
            this.orderNum = orderNum;
            return this;
        }
        /* 状态:1-可用,0-禁用 */
        public ElementInfoBuilder visible(String visible) {
            this.visible = visible;
            return this;
        }
        /* 描述 */
        public ElementInfoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 创建时间 */
        public ElementInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人 */
        public ElementInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建人id */
        public ElementInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 更新时间 */
        public ElementInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人 */
        public ElementInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新人id */
        public ElementInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public ElementInfo build() {
        return new ElementInfo(            id, 
            menuId, 
            title, 
            code, 
            type, 
            href, 
            path, 
            method, 
            orderNum, 
            visible, 
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
                    .append("menuId", getMenuId())
                    .append("title", getTitle())
                    .append("code", getCode())
                    .append("type", getType())
                    .append("href", getHref())
                    .append("path", getPath())
                    .append("method", getMethod())
                    .append("orderNum", getOrderNum())
                    .append("visible", getVisible())
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
