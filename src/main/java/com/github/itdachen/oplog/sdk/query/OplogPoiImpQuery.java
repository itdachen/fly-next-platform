package com.github.itdachen.oplog.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 导入日志 查询参数
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
public class OplogPoiImpQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID/公司ID
     */
    private String tenantId;

    /**
     * 平台ID
     */
    private String platId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用版本号
     */
    private String appVersion;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 身份ID
     */
    private String roleId;

    /**
     * 身份名称
     */
    private String roleName;

    /**
     * 省代码
     */
    private String provId;

    /**
     * 市/州代码
     */
    private String cityId;

    /**
     * 区/县代码
     */
    private String countyId;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptTitle;

    /**
     * 部门等级
     */
    private String deptLevel;

    /**
     * 上级部门代码
     */
    private String deptParentId;

    /**
     * 功能ID/菜单ID(备用)
     */
    private String funcId;

    /**
     * 功能名称(备用)
     */
    private String funcTitle;

    /**
     * 删除标记:N-未删除;Y-已删除
     */
    private String removeFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    public OplogPoiImpQuery() {
    }

    public OplogPoiImpQuery(int page, int limit, String tenantId, String platId, String appId, String appVersion, String userId, String nickName, String roleId, String roleName, String provId, String cityId, String countyId, String deptId, String deptTitle, String deptLevel, String deptParentId, String funcId, String funcTitle, String removeFlag, LocalDateTime createTime) {
        super(page, limit);
        this.tenantId = tenantId;
        this.platId = platId;
        this.appId = appId;
        this.appVersion = appVersion;
        this.userId = userId;
        this.nickName = nickName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.provId = provId;
        this.cityId = cityId;
        this.countyId = countyId;
        this.deptId = deptId;
        this.deptTitle = deptTitle;
        this.deptLevel = deptLevel;
        this.deptParentId = deptParentId;
        this.funcId = funcId;
        this.funcTitle = funcTitle;
        this.removeFlag = removeFlag;
        this.createTime = createTime;
    }

    public static OplogPoiImpQueryBuilder builder() {
        return new OplogPoiImpQueryBuilder();
    }

    public static class OplogPoiImpQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String platId;
        private String appId;
        private String appVersion;
        private String userId;
        private String nickName;
        private String roleId;
        private String roleName;
        private String provId;
        private String cityId;
        private String countyId;
        private String deptId;
        private String deptTitle;
        private String deptLevel;
        private String deptParentId;
        private String funcId;
        private String funcTitle;
        private String removeFlag;
        private LocalDateTime createTime;

        public OplogPoiImpQueryBuilder() {
        }

        public OplogPoiImpQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public OplogPoiImpQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID/公司ID */
        public OplogPoiImpQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 平台ID */
        public OplogPoiImpQueryBuilder platId(String platId) {
            this.platId = platId;
            return this;
        }

        /* 应用ID */
        public OplogPoiImpQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 应用版本号 */
        public OplogPoiImpQueryBuilder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        /* 用户ID */
        public OplogPoiImpQueryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 昵称 */
        public OplogPoiImpQueryBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        /* 身份ID */
        public OplogPoiImpQueryBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        /* 身份名称 */
        public OplogPoiImpQueryBuilder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        /* 省代码 */
        public OplogPoiImpQueryBuilder provId(String provId) {
            this.provId = provId;
            return this;
        }

        /* 市/州代码 */
        public OplogPoiImpQueryBuilder cityId(String cityId) {
            this.cityId = cityId;
            return this;
        }

        /* 区/县代码 */
        public OplogPoiImpQueryBuilder countyId(String countyId) {
            this.countyId = countyId;
            return this;
        }

        /* 部门ID */
        public OplogPoiImpQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 部门名称 */
        public OplogPoiImpQueryBuilder deptTitle(String deptTitle) {
            this.deptTitle = deptTitle;
            return this;
        }

        /* 部门等级 */
        public OplogPoiImpQueryBuilder deptLevel(String deptLevel) {
            this.deptLevel = deptLevel;
            return this;
        }

        /* 上级部门代码 */
        public OplogPoiImpQueryBuilder deptParentId(String deptParentId) {
            this.deptParentId = deptParentId;
            return this;
        }

        /* 功能ID/菜单ID(备用) */
        public OplogPoiImpQueryBuilder funcId(String funcId) {
            this.funcId = funcId;
            return this;
        }

        /* 功能名称(备用) */
        public OplogPoiImpQueryBuilder funcTitle(String funcTitle) {
            this.funcTitle = funcTitle;
            return this;
        }

        /* 删除标记:N-未删除;Y-已删除 */
        public OplogPoiImpQueryBuilder removeFlag(String removeFlag) {
            this.removeFlag = removeFlag;
            return this;
        }

        /* 创建时间 */
        public OplogPoiImpQueryBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        public OplogPoiImpQuery build() {
            return new OplogPoiImpQuery(page, limit, tenantId, platId, appId, appVersion, userId, nickName, roleId, roleName, provId, cityId, countyId, deptId, deptTitle, deptLevel, deptParentId, funcId, funcTitle, removeFlag, createTime);
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

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppVersion() {
        return appVersion;
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

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptParentId(String deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getDeptParentId() {
        return deptParentId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
    }

    public void setRemoveFlag(String removeFlag) {
        this.removeFlag = removeFlag;
    }

    public String getRemoveFlag() {
        return removeFlag;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("platId", getPlatId())
                .append("appId", getAppId())
                .append("appVersion", getAppVersion())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("roleId", getRoleId())
                .append("roleName", getRoleName())
                .append("provId", getProvId())
                .append("cityId", getCityId())
                .append("countyId", getCountyId())
                .append("deptId", getDeptId())
                .append("deptTitle", getDeptTitle())
                .append("deptLevel", getDeptLevel())
                .append("deptParentId", getDeptParentId())
                .append("funcId", getFuncId())
                .append("funcTitle", getFuncTitle())
                .append("removeFlag", getRemoveFlag())
                .append("createTime", getCreateTime())
                .toString();
    }


}
