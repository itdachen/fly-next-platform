package com.github.itdachen.admin.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 权限下发 DTO
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public class AuthGrantMenuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** ID */
        private String id;

        /** 平台ID */
 @NotBlank(message = "平台ID不能为空")
        private String platId;

        /** appID */
 @NotBlank(message = "appID不能为空")
        private String appId;

        /** 租户ID */
        private String tenantId;

        /** 用户id */
 @NotBlank(message = "用户id不能为空")
        private String userId;

        /** 菜单id */
 @NotBlank(message = "菜单id不能为空")
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
