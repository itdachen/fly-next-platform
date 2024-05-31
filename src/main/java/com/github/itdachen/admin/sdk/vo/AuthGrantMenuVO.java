package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 权限下发 VO
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public class AuthGrantMenuVO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** ID */
        private String id;

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



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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
                    .append("id", getId())
                    .append("platId", getPlatId())
                    .append("appId", getAppId())
                    .append("tenantId", getTenantId())
                    .append("userId", getUserId())
                    .append("menuId", getMenuId())
                .toString();
    }

}
