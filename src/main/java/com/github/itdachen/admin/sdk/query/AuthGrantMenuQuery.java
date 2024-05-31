package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 权限下发 查询参数
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public class AuthGrantMenuQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 平台ID */
            private String platId;

            /** appID */
            private String appId;

            /** 租户ID */
            private String tenantId;

            /** 用户id */
            private String userId;

            /** 菜单id */
            private String menuId;



    public AuthGrantMenuQuery() {
    }

    public AuthGrantMenuQuery(int page, int limit, String platId, String appId, String tenantId, String userId, String menuId) {
        super(page, limit);
            this.platId = platId;
            this.appId = appId;
            this.tenantId = tenantId;
            this.userId = userId;
            this.menuId = menuId;
    }

    public static AuthGrantMenuQueryBuilder builder() {
        return new AuthGrantMenuQueryBuilder();
    }

    public static class AuthGrantMenuQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String platId;
            private String appId;
            private String tenantId;
            private String userId;
            private String menuId;

        public AuthGrantMenuQueryBuilder() {
        }

        public AuthGrantMenuQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AuthGrantMenuQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 平台ID */
            public AuthGrantMenuQueryBuilder platId(String platId) {
                this.platId = platId;
                return this;
            }
            /* appID */
            public AuthGrantMenuQueryBuilder appId(String appId) {
                this.appId = appId;
                return this;
            }
            /* 租户ID */
            public AuthGrantMenuQueryBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 用户id */
            public AuthGrantMenuQueryBuilder userId(String userId) {
                this.userId = userId;
                return this;
            }
            /* 菜单id */
            public AuthGrantMenuQueryBuilder menuId(String menuId) {
                this.menuId = menuId;
                return this;
            }

        public AuthGrantMenuQuery build() {
            return new AuthGrantMenuQuery(page, limit, platId, appId, tenantId, userId, menuId);
        }

    }



        public void setPlatId(String platId) {
            this.platId = platId;
        }

        public String getPlatId() {
            return platId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppId() {
            return appId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setMenuId(String menuId) {
            this.menuId = menuId;
        }

        public String getMenuId() {
            return menuId;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("platId", getPlatId())
                    .append("appId", getAppId())
                    .append("tenantId", getTenantId())
                    .append("userId", getUserId())
                    .append("menuId", getMenuId())
                .toString();
    }

}
