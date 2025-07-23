package com.github.itdachen.oplog.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 导出日志 查询参数
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
public class OplogPoiExpQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 租户ID/公司ID */
            private String tenantId;

            /** 平台ID */
            private String platId;

            /** 应用ID */
            private String appId;

            /** 用户ID */
            private String userId;

            /** 昵称 */
            private String nickName;

            /** 身份ID */
            private String roleId;

            /** 身份名称 */
            private String roleName;

            /** 省代码 */
            private String provId;

            /** 市/州代码 */
            private String cityId;

            /** 区/县代码 */
            private String countyId;

            /** 部门ID */
            private String deptId;

            /** 部门名称 */
            private String deptTitle;

            /** 上级部门代码 */
            private String deptParentId;

            /** 消息表ID */
            private String msgId;

            /** 功能名称 */
            private String funcTitle;

            /** 服务端处理耗时 */
            private String executeTime;

            /** 删除标记:N-未删除;Y-已删除 */
            private String removeFlag;

            /** 年份 */
            private String yearly;

            /** 月份 */
            private String monthly;



    public OplogPoiExpQuery() {
    }

    public OplogPoiExpQuery(int page, int limit, String tenantId, String platId, String appId, String userId, String nickName, String roleId, String roleName, String provId, String cityId, String countyId, String deptId, String deptTitle, String deptParentId, String msgId, String funcTitle, String executeTime, String removeFlag, String yearly, String monthly) {
        super(page, limit);
            this.tenantId = tenantId;
            this.platId = platId;
            this.appId = appId;
            this.userId = userId;
            this.nickName = nickName;
            this.roleId = roleId;
            this.roleName = roleName;
            this.provId = provId;
            this.cityId = cityId;
            this.countyId = countyId;
            this.deptId = deptId;
            this.deptTitle = deptTitle;
            this.deptParentId = deptParentId;
            this.msgId = msgId;
            this.funcTitle = funcTitle;
            this.executeTime = executeTime;
            this.removeFlag = removeFlag;
            this.yearly = yearly;
            this.monthly = monthly;
    }

    public static OplogPoiExpQueryBuilder builder() {
        return new OplogPoiExpQueryBuilder();
    }

    public static class OplogPoiExpQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String tenantId;
            private String platId;
            private String appId;
            private String userId;
            private String nickName;
            private String roleId;
            private String roleName;
            private String provId;
            private String cityId;
            private String countyId;
            private String deptId;
            private String deptTitle;
            private String deptParentId;
            private String msgId;
            private String funcTitle;
            private String executeTime;
            private String removeFlag;
            private String yearly;
            private String monthly;

        public OplogPoiExpQueryBuilder() {
        }

        public OplogPoiExpQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public OplogPoiExpQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 租户ID/公司ID */
            public OplogPoiExpQueryBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 平台ID */
            public OplogPoiExpQueryBuilder platId(String platId) {
                this.platId = platId;
                return this;
            }
            /* 应用ID */
            public OplogPoiExpQueryBuilder appId(String appId) {
                this.appId = appId;
                return this;
            }
            /* 用户ID */
            public OplogPoiExpQueryBuilder userId(String userId) {
                this.userId = userId;
                return this;
            }
            /* 昵称 */
            public OplogPoiExpQueryBuilder nickName(String nickName) {
                this.nickName = nickName;
                return this;
            }
            /* 身份ID */
            public OplogPoiExpQueryBuilder roleId(String roleId) {
                this.roleId = roleId;
                return this;
            }
            /* 身份名称 */
            public OplogPoiExpQueryBuilder roleName(String roleName) {
                this.roleName = roleName;
                return this;
            }
            /* 省代码 */
            public OplogPoiExpQueryBuilder provId(String provId) {
                this.provId = provId;
                return this;
            }
            /* 市/州代码 */
            public OplogPoiExpQueryBuilder cityId(String cityId) {
                this.cityId = cityId;
                return this;
            }
            /* 区/县代码 */
            public OplogPoiExpQueryBuilder countyId(String countyId) {
                this.countyId = countyId;
                return this;
            }
            /* 部门ID */
            public OplogPoiExpQueryBuilder deptId(String deptId) {
                this.deptId = deptId;
                return this;
            }
            /* 部门名称 */
            public OplogPoiExpQueryBuilder deptTitle(String deptTitle) {
                this.deptTitle = deptTitle;
                return this;
            }
            /* 上级部门代码 */
            public OplogPoiExpQueryBuilder deptParentId(String deptParentId) {
                this.deptParentId = deptParentId;
                return this;
            }
            /* 消息表ID */
            public OplogPoiExpQueryBuilder msgId(String msgId) {
                this.msgId = msgId;
                return this;
            }
            /* 功能名称 */
            public OplogPoiExpQueryBuilder funcTitle(String funcTitle) {
                this.funcTitle = funcTitle;
                return this;
            }
            /* 服务端处理耗时 */
            public OplogPoiExpQueryBuilder executeTime(String executeTime) {
                this.executeTime = executeTime;
                return this;
            }
            /* 删除标记:N-未删除;Y-已删除 */
            public OplogPoiExpQueryBuilder removeFlag(String removeFlag) {
                this.removeFlag = removeFlag;
                return this;
            }
            /* 年份 */
            public OplogPoiExpQueryBuilder yearly(String yearly) {
                this.yearly = yearly;
                return this;
            }
            /* 月份 */
            public OplogPoiExpQueryBuilder monthly(String monthly) {
                this.monthly = monthly;
                return this;
            }

        public OplogPoiExpQuery build() {
            return new OplogPoiExpQuery(page, limit, tenantId, platId, appId, userId, nickName, roleId, roleName, provId, cityId, countyId, deptId, deptTitle, deptParentId, msgId, funcTitle, executeTime, removeFlag, yearly, monthly);
        }

    }



        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getTenantId() {
            return tenantId;
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

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setProvId(String provId) {
            this.provId = provId;
        }

        public String getProvId() {
            return provId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCountyId(String countyId) {
            this.countyId = countyId;
        }

        public String getCountyId() {
            return countyId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptTitle(String deptTitle) {
            this.deptTitle = deptTitle;
        }

        public String getDeptTitle() {
            return deptTitle;
        }

        public void setDeptParentId(String deptParentId) {
            this.deptParentId = deptParentId;
        }

        public String getDeptParentId() {
            return deptParentId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setFuncTitle(String funcTitle) {
            this.funcTitle = funcTitle;
        }

        public String getFuncTitle() {
            return funcTitle;
        }

        public void setExecuteTime(String executeTime) {
            this.executeTime = executeTime;
        }

        public String getExecuteTime() {
            return executeTime;
        }

        public void setRemoveFlag(String removeFlag) {
            this.removeFlag = removeFlag;
        }

        public String getRemoveFlag() {
            return removeFlag;
        }

        public void setYearly(String yearly) {
            this.yearly = yearly;
        }

        public String getYearly() {
            return yearly;
        }

        public void setMonthly(String monthly) {
            this.monthly = monthly;
        }

        public String getMonthly() {
            return monthly;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("tenantId", getTenantId())
                    .append("platId", getPlatId())
                    .append("appId", getAppId())
                    .append("userId", getUserId())
                    .append("nickName", getNickName())
                    .append("roleId", getRoleId())
                    .append("roleName", getRoleName())
                    .append("provId", getProvId())
                    .append("cityId", getCityId())
                    .append("countyId", getCountyId())
                    .append("deptId", getDeptId())
                    .append("deptTitle", getDeptTitle())
                    .append("deptParentId", getDeptParentId())
                    .append("msgId", getMsgId())
                    .append("funcTitle", getFuncTitle())
                    .append("executeTime", getExecuteTime())
                    .append("removeFlag", getRemoveFlag())
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                .toString();
    }

}
