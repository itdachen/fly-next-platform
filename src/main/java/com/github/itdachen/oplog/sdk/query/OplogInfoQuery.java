package com.github.itdachen.oplog.sdk.query;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 操作日志 查询参数
 *
 * @author 王大宸
 * @date 2025-09-09 17:52:15
 */
public class OplogInfoQuery extends BizQuery implements Serializable {
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
     * 乡镇/街道办代码
     */
    private String townCode;

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
     * 日志标题: 用户管理, 菜单管理等
     */
    private String menuTitle;

    /**
     * 操作类型: SAVE,UPDATE,JUMP,REMOVE
     */
    private String opCode;

    /**
     * 操作时间
     */
    private String opTime;

    private String beginOpTime;

    private String endOpTime;

    /**
     * 删除标记:N-未删除;Y-已删除
     */
    private String removeFlag = YesOrNotConstant.N;

    /**
     * 年份
     */
    private String yearly;

    /**
     * 月份
     */
    private String monthly;


    public OplogInfoQuery() {
    }

    public OplogInfoQuery(int page, int limit, String platId, String appId, String tenantId, String provCode, String cityCode, String countyCode, String townCode, String deptId, String deptTitle, String deptParentId, String userId, String nickName, String menuTitle, String opCode, String opTime, String removeFlag, String yearly, String monthly) {
        super(page, limit);
        this.platId = platId;
        this.appId = appId;
        this.tenantId = tenantId;
        this.provCode = provCode;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
        this.townCode = townCode;
        this.deptId = deptId;
        this.deptTitle = deptTitle;
        this.deptParentId = deptParentId;
        this.userId = userId;
        this.nickName = nickName;
        this.menuTitle = menuTitle;
        this.opCode = opCode;
        this.opTime = opTime;
        this.removeFlag = removeFlag;
        this.yearly = yearly;
        this.monthly = monthly;
    }

    public static OplogInfoQueryBuilder builder() {
        return new OplogInfoQueryBuilder();
    }

    public static class OplogInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String platId;
        private String appId;
        private String tenantId;
        private String provCode;
        private String cityCode;
        private String countyCode;
        private String townCode;
        private String deptId;
        private String deptTitle;
        private String deptParentId;
        private String userId;
        private String nickName;
        private String menuTitle;
        private String opCode;
        private String opTime;
        private String removeFlag = YesOrNotConstant.N;
        private String yearly;
        private String monthly;

        public OplogInfoQueryBuilder() {
        }

        public OplogInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public OplogInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 平台ID */
        public OplogInfoQueryBuilder platId(String platId) {
            this.platId = platId;
            return this;
        }

        /* 应用ID */
        public OplogInfoQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /* 租户ID/公司ID */
        public OplogInfoQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 省代码 */
        public OplogInfoQueryBuilder provCode(String provCode) {
            this.provCode = provCode;
            return this;
        }

        /* 市/州代码 */
        public OplogInfoQueryBuilder cityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        /* 区/县代码 */
        public OplogInfoQueryBuilder countyCode(String countyCode) {
            this.countyCode = countyCode;
            return this;
        }

        /* 乡镇/街道办代码 */
        public OplogInfoQueryBuilder townCode(String townCode) {
            this.townCode = townCode;
            return this;
        }

        /* 部门ID */
        public OplogInfoQueryBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 部门名称 */
        public OplogInfoQueryBuilder deptTitle(String deptTitle) {
            this.deptTitle = deptTitle;
            return this;
        }

        /* 上级部门代码 */
        public OplogInfoQueryBuilder deptParentId(String deptParentId) {
            this.deptParentId = deptParentId;
            return this;
        }

        /* 操作人ID */
        public OplogInfoQueryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /* 操作人姓名 */
        public OplogInfoQueryBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        /* 日志标题: 用户管理, 菜单管理等 */
        public OplogInfoQueryBuilder menuTitle(String menuTitle) {
            this.menuTitle = menuTitle;
            return this;
        }

        /* 操作类型: SAVE,UPDATE,JUMP,REMOVE */
        public OplogInfoQueryBuilder opCode(String opCode) {
            this.opCode = opCode;
            return this;
        }

        /* 操作时间 */
        public OplogInfoQueryBuilder opTime(String opTime) {
            this.opTime = opTime;
            return this;
        }

        /* 删除标记:N-未删除;Y-已删除 */
        public OplogInfoQueryBuilder removeFlag(String removeFlag) {
            this.removeFlag = removeFlag;
            return this;
        }

        /* 年份 */
        public OplogInfoQueryBuilder yearly(String yearly) {
            this.yearly = yearly;
            return this;
        }

        /* 月份 */
        public OplogInfoQueryBuilder monthly(String monthly) {
            this.monthly = monthly;
            return this;
        }

        public OplogInfoQuery build() {
            return new OplogInfoQuery(page, limit, platId, appId, tenantId, provCode, cityCode, countyCode, townCode, deptId, deptTitle, deptParentId, userId, nickName, menuTitle, opCode, opTime, removeFlag, yearly, monthly);
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

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getTownCode() {
        return townCode;
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

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getOpTime() {
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
                .append("platId", getPlatId())
                .append("appId", getAppId())
                .append("tenantId", getTenantId())
                .append("provCode", getProvCode())
                .append("cityCode", getCityCode())
                .append("countyCode", getCountyCode())
                .append("townCode", getTownCode())
                .append("deptId", getDeptId())
                .append("deptTitle", getDeptTitle())
                .append("deptParentId", getDeptParentId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("menuTitle", getMenuTitle())
                .append("opCode", getOpCode())
                .append("opTime", getOpTime())
                .append("beginOpTime", getBeginOpTime())
                .append("endOpTime", getEndOpTime())
                .append("removeFlag", getRemoveFlag())
                .append("yearly", getYearly())
                .append("monthly", getMonthly())
                .toString();
    }

}
