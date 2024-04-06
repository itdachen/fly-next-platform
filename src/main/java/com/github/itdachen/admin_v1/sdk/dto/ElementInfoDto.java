package com.github.itdachen.admin_v1.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 按钮资源 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class ElementInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 主键唯一标识 */
        private String id;


        /** 资源关联菜单 */
        private String menuId;


        /** 资源名称: 新增,编辑,删除 ... 等 */
        private String title;


        /** 资源编码: 权限编码 */
        private String code;


        /** 资源类型: button,uri */
        private String type;


        /** 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
        private String href;


        /** 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
        private String path;


        /** 资源请求类型:GET,POST,PUT,DELETE */
        private String method;


        /** 排序 */
        private Integer orderNum;


        /** 状态:1-可用,0-禁用 */
        private String visible;


        /** 描述 */
        private String remarks;


    public ElementInfoDto() {}

    public ElementInfoDto(String id, String menuId, String title, String code, String type, String href, String path, String method, Integer orderNum, String visible, String remarks) {
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
    }

    public static ElementInfoDtoBuilder builder() {
        return new ElementInfoDtoBuilder();
    }

    public static class ElementInfoDtoBuilder {
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

        public ElementInfoDtoBuilder() {}

            /* 主键唯一标识 */
            public ElementInfoDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 资源关联菜单 */
            public ElementInfoDtoBuilder menuId(String menuId) {
                this.menuId = menuId;
                return this;
            }
            /* 资源名称: 新增,编辑,删除 ... 等 */
            public ElementInfoDtoBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 资源编码: 权限编码 */
            public ElementInfoDtoBuilder code(String code) {
                this.code = code;
                return this;
            }
            /* 资源类型: button,uri */
            public ElementInfoDtoBuilder type(String type) {
                this.type = type;
                return this;
            }
            /* 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
            public ElementInfoDtoBuilder href(String href) {
                this.href = href;
                return this;
            }
            /* 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
            public ElementInfoDtoBuilder path(String path) {
                this.path = path;
                return this;
            }
            /* 资源请求类型:GET,POST,PUT,DELETE */
            public ElementInfoDtoBuilder method(String method) {
                this.method = method;
                return this;
            }
            /* 排序 */
            public ElementInfoDtoBuilder orderNum(Integer orderNum) {
                this.orderNum = orderNum;
                return this;
            }
            /* 状态:1-可用,0-禁用 */
            public ElementInfoDtoBuilder visible(String visible) {
                this.visible = visible;
                return this;
            }
            /* 描述 */
            public ElementInfoDtoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }

        public ElementInfoDto build() {
            return new ElementInfoDto(id, menuId, title, code, type, href, path, method, orderNum, visible, remarks);
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
                .toString();
    }

}
