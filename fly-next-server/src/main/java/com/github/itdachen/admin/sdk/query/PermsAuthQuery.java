package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 权限下发 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class PermsAuthQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    private String userId;

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 客户端
     */
    private String clientId;


    public PermsAuthQuery() {
    }

    public PermsAuthQuery(int page, int limit, String userId, String menuId, String clientId) {
        super(page, limit);
        this.userId = userId;
        this.menuId = menuId;
        this.clientId = clientId;
    }

    public static PermsAuthQueryBuilder builder() {
        return new PermsAuthQueryBuilder();
    }

    public static class PermsAuthQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String userId;
        private String menuId;
        private String clientId;

        public PermsAuthQueryBuilder() {
        }

        public PermsAuthQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public PermsAuthQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 用户id */
        public PermsAuthQueryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 菜单id */
        public PermsAuthQueryBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 客户端 */
        public PermsAuthQueryBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public PermsAuthQuery build() {
            return new PermsAuthQuery(page, limit, userId, menuId, clientId);
        }

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

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("userId", getUserId())
                .append("menuId", getMenuId())
                .append("clientId", getClientId())
                .toString();
    }

}
