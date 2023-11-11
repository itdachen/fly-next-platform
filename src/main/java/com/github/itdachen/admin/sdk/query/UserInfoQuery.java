package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 用户信息 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class UserInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 登录账户 */
            private String username;

            /** 姓名 */
            private String name;

            /** 部门ID */
            private String departId;

            /** 租户id/机构id */
            private String tenantId;

            /** 客户端ID */
            private String clientId;


    public UserInfoQuery() {
    }

    public UserInfoQuery(int page, int limit, String username, String name, String departId, String tenantId, String clientId) {
        super(page, limit);
            this.username = username;
            this.name = name;
            this.departId = departId;
            this.tenantId = tenantId;
            this.clientId = clientId;
    }

    public static UserInfoQueryBuilder builder() {
        return new UserInfoQueryBuilder();
    }

    public static class UserInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String username;
            private String name;
            private String departId;
            private String tenantId;
            private String clientId;

        public UserInfoQueryBuilder() {
        }

        public UserInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public UserInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 登录账户 */
            public UserInfoQueryBuilder username(String username) {
                this.username = username;
                return this;
            }
            /* 姓名 */
            public UserInfoQueryBuilder name(String name) {
                this.name = name;
                return this;
            }
            /* 部门ID */
            public UserInfoQueryBuilder departId(String departId) {
                this.departId = departId;
                return this;
            }
            /* 租户id/机构id */
            public UserInfoQueryBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 客户端ID */
            public UserInfoQueryBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }

        public UserInfoQuery build() {
            return new UserInfoQuery(page, limit, username, name, departId, tenantId, clientId);
        }

    }




        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setDepartId(String departId) {
            this.departId = departId;
        }

        public String getDepartId() {
            return departId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getTenantId() {
            return tenantId;
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
                    .append("username", getUsername())
                    .append("name", getName())
                    .append("departId", getDepartId())
                    .append("tenantId", getTenantId())
                    .append("clientId", getClientId())
                .toString();
    }

}
