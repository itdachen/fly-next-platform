package com.github.itdachen.oplog.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 页面访问日志 查询参数
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
public class OplogPageViewQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 平台ID
     */
    private String platId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 租户ID/公司ID
     */
    private String tenantId;

    /**
     * 省代码
     */
    private String provCode;

    /**
     * 市/州代码
     */
    private String cityCode;

    /**
     * 区/县代码
     */
    private String countyCode;

    /**
     * 乡镇/街道办名称
     */
    private String townName;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptTitle;

    /**
     * 上级部门代码
     */
    private String deptParentId;

    /**
     * 操作人ID
     */
    private String userId;

    /**
     * 操作人姓名
     */
    private String nickName;

    /**
     * 菜单名称
     */
    private String menuTitle;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 操作类型: SAVE,UPDATE,JUMP,REMOVE
     */
    private String opCode;

    /**
     * 操作时间
     */
    private LocalDateTime opTime;

    private String beginOpTime;
    private String endOpTime;

    /**
     * 年份
     */
    private String yearly;

    /**
     * 月份
     */
    private String monthly;


    public OplogPageViewQuery() {
    }

    public OplogPageViewQuery(int page, int limit, String platId, String appId, String tenantId, String provCode, String cityCode, String countyCode, String townName, String deptId, String deptTitle, String deptParentId, String userId, String nickName, String menuTitle, String menuId, String opCode, LocalDateTime opTime, String yearly, String monthly) {
        super(page, limit);
        this.platId = platId;
        this.appId = appId;
        this.tenantId = tenantId;
        this.provCode = provCode;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
        this.townName = townName;
        this.deptId = deptId;
        this.deptTitle = deptTitle;
        this.deptParentId = deptParentId;
        this.userId = userId;
        this.nickName = nickName;
        this.menuTitle = menuTitle;
        this.menuId = menuId;
        this.opCode = opCode;
        this.opTime = opTime;
        this.yearly = yearly;
        this.monthly = monthly;
    }

    public static OplogPageViewQueryBuilder builder() {
        return new OplogPageViewQueryBuilder();
    }

    public static class OplogPageViewQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String platId;
        private String appId;
        private String tenantId;
        private String provCode;
        private String cityCode;
        private String countyCode;
        private String townName;
        private String deptId;
        private String deptTitle;
        private String deptParentId;
        private String userId;
        private String nickName;
        private String menuTitle;
        private String menuId;
        private String opCode;
        private LocalDateTime opTime;
        private String yearly;
        private String monthly;

        public OplogPageViewQueryBuilder() {
        }

        public OplogPageViewQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public OplogPageViewQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 平台ID */
        public OplogPageViewQueryBuilder platId(String platId) {
            this.platId = platId;
            return this;
        }

        /* 应用ID */
        public OplogPageViewQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 租户ID/公司ID */
        public OplogPageViewQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 省代码 */
        public OplogPageViewQueryBuilder provCode(String provCode) {
            this.provCode = provCode;
            return this;
        }

        /* 市/州代码 */
        public OplogPageViewQueryBuilder cityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        /* 区/县代码 */
        public OplogPageViewQueryBuilder countyCode(String countyCode) {
            this.countyCode = countyCode;
            return this;
        }

        /* 乡镇/街道办名称 */
        public OplogPageViewQueryBuilder townName(String townName) {
            this.townName = townName;
            return this;
        }

        /* 部门ID */
        public OplogPageViewQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 部门名称 */
        public OplogPageViewQueryBuilder deptTitle(String deptTitle) {
            this.deptTitle = deptTitle;
            return this;
        }

        /* 上级部门代码 */
        public OplogPageViewQueryBuilder deptParentId(String deptParentId) {
            this.deptParentId = deptParentId;
            return this;
        }

        /* 操作人ID */
        public OplogPageViewQueryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 操作人姓名 */
        public OplogPageViewQueryBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        /* 菜单名称 */
        public OplogPageViewQueryBuilder menuTitle(String menuTitle) {
            this.menuTitle = menuTitle;
            return this;
        }

        /* 菜单ID */
        public OplogPageViewQueryBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        /* 操作类型: SAVE,UPDATE,JUMP,REMOVE */
        public OplogPageViewQueryBuilder opCode(String opCode) {
            this.opCode = opCode;
            return this;
        }

        /* 操作时间 */
        public OplogPageViewQueryBuilder opTime(LocalDateTime opTime) {
            this.opTime = opTime;
            return this;
        }

        /* 年份 */
        public OplogPageViewQueryBuilder yearly(String yearly) {
            this.yearly = yearly;
            return this;
        }

        /* 月份 */
        public OplogPageViewQueryBuilder monthly(String monthly) {
            this.monthly = monthly;
            return this;
        }

        public OplogPageViewQuery build() {
            return new OplogPageViewQuery(page, limit, platId, appId, tenantId, provCode, cityCode, countyCode, townName, deptId, deptTitle, deptParentId, userId, nickName, menuTitle, menuId, opCode, opTime, yearly, monthly);
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

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTownName() {
        return townName;
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

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpTime(LocalDateTime opTime) {
        this.opTime = opTime;
    }

    public LocalDateTime getOpTime() {
        return opTime;
    }

    public String getBeginOpTime() {
        return beginOpTime;
    }

    public void setBeginOpTime(String beginOpTime) {
        this.beginOpTime = beginOpTime;
    }

    public String getEndOpTime() {
        return endOpTime;
    }

    public void setEndOpTime(String endOpTime) {
        this.endOpTime = endOpTime;
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
                .append("platId", getPlatId())
                .append("appId", getAppId())
                .append("tenantId", getTenantId())
                .append("provCode", getProvCode())
                .append("cityCode", getCityCode())
                .append("countyCode", getCountyCode())
                .append("townName", getTownName())
                .append("deptId", getDeptId())
                .append("deptTitle", getDeptTitle())
                .append("deptParentId", getDeptParentId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("menuTitle", getMenuTitle())
                .append("menuId", getMenuId())
                .append("opCode", getOpCode())
                .append("opTime", getOpTime())
                .append("beginOpTime", getBeginOpTime())
                .append("endOpTime", getEndOpTime())
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .toString();
    }

}
