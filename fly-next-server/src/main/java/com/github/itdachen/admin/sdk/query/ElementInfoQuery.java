package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 按钮资源 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class ElementInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

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


    public ElementInfoQuery() {
    }

    public ElementInfoQuery(int page, int limit, String menuId, String title, String code, String type, String href, String path, String method, Integer orderNum, String visible) {
        super(page, limit);
            this.menuId = menuId;
            this.title = title;
            this.code = code;
            this.type = type;
            this.href = href;
            this.path = path;
            this.method = method;
            this.orderNum = orderNum;
            this.visible = visible;
    }

    public static ElementInfoQueryBuilder builder() {
        return new ElementInfoQueryBuilder();
    }

    public static class ElementInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String menuId;
            private String title;
            private String code;
            private String type;
            private String href;
            private String path;
            private String method;
            private Integer orderNum;
            private String visible;

        public ElementInfoQueryBuilder() {
        }

        public ElementInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public ElementInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 资源关联菜单 */
            public ElementInfoQueryBuilder menuId(String menuId) {
                this.menuId = menuId;
                return this;
            }
            /* 资源名称: 新增,编辑,删除 ... 等 */
            public ElementInfoQueryBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 资源编码: 权限编码 */
            public ElementInfoQueryBuilder code(String code) {
                this.code = code;
                return this;
            }
            /* 资源类型: button,uri */
            public ElementInfoQueryBuilder type(String type) {
                this.type = type;
                return this;
            }
            /* 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
            public ElementInfoQueryBuilder href(String href) {
                this.href = href;
                return this;
            }
            /* 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
            public ElementInfoQueryBuilder path(String path) {
                this.path = path;
                return this;
            }
            /* 资源请求类型:GET,POST,PUT,DELETE */
            public ElementInfoQueryBuilder method(String method) {
                this.method = method;
                return this;
            }
            /* 排序 */
            public ElementInfoQueryBuilder orderNum(Integer orderNum) {
                this.orderNum = orderNum;
                return this;
            }
            /* 状态:1-可用,0-禁用 */
            public ElementInfoQueryBuilder visible(String visible) {
                this.visible = visible;
                return this;
            }

        public ElementInfoQuery build() {
            return new ElementInfoQuery(page, limit, menuId, title, code, type, href, path, method, orderNum, visible);
        }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("menuId", getMenuId())
                    .append("title", getTitle())
                    .append("code", getCode())
                    .append("type", getType())
                    .append("href", getHref())
                    .append("path", getPath())
                    .append("method", getMethod())
                    .append("orderNum", getOrderNum())
                    .append("visible", getVisible())
                .toString();
    }

}
