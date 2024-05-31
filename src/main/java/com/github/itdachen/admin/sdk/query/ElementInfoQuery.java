package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 认证资源信息(按钮信息) 查询参数
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class ElementInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 应用ID/appID
     */
    private String appId;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
    private String validFlag;

    /**
     * 是否需要授权: Y-需要;N-不需要
     */
    private String hasAuth;

    /**
     * 是否需要IP授权: Y-需要;N-不需要
     */
    private String hasIp;


    public ElementInfoQuery() {
    }

    public ElementInfoQuery(int page, int limit, String appId, String menuId, String title, String validFlag, String hasAuth, String hasIp) {
        super(page, limit);
        this.appId = appId;
        this.menuId = menuId;
        this.title = title;
        this.validFlag = validFlag;
        this.hasAuth = hasAuth;
        this.hasIp = hasIp;
    }

    public static ElementInfoQueryBuilder builder() {
        return new ElementInfoQueryBuilder();
    }

    public static class ElementInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String appId;
        private String menuId;
        private String title;
        private String validFlag;
        private String hasAuth;
        private String hasIp;

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

        /* 应用ID/appID */
        public ElementInfoQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 菜单ID */
        public ElementInfoQueryBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 标题 */
        public ElementInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 是否展示/有效标志: Y-有效;N-无效 */
        public ElementInfoQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        /* 是否需要授权: Y-需要;N-不需要 */
        public ElementInfoQueryBuilder hasAuth(String hasAuth) {
            this.hasAuth = hasAuth;
            return this;
        }

        /* 是否需要IP授权: Y-需要;N-不需要 */
        public ElementInfoQueryBuilder hasIp(String hasIp) {
            this.hasIp = hasIp;
            return this;
        }

        public ElementInfoQuery build() {
            return new ElementInfoQuery(page, limit, appId, menuId, title, validFlag, hasAuth, hasIp);
        }

    }


    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
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

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setHasAuth(String hasAuth) {
        this.hasAuth = hasAuth;
    }

    public String getHasAuth() {
        return hasAuth;
    }

    public void setHasIp(String hasIp) {
        this.hasIp = hasIp;
    }

    public String getHasIp() {
        return hasIp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("appId", getAppId())
                .append("menuId", getMenuId())
                .append("title", getTitle())
                .append("validFlag", getValidFlag())
                .append("hasAuth", getHasAuth())
                .append("hasIp", getHasIp())
                .toString();
    }

}
