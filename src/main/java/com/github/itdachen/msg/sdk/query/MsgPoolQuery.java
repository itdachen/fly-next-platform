package com.github.itdachen.msg.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 消息池 查询参数
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgPoolQuery extends BizQuery implements Serializable {
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

            /** 省代码 */
            private String provId;

            /** 市/州代码 */
            private String cityId;

            /** 区/县代码 */
            private String countyId;

            /** 部门ID */
            private String deptId;

            /** 消息标题 */
            private String msgTitle;

            /** 阅读标志 */
            private String readFlag;

            /** 删除标志 */
            private String removeFlag;

            /** 年份 */
            private String yearly;

            /** 月份 */
            private String monthly;



    public MsgPoolQuery() {
    }

    public MsgPoolQuery(int page, int limit, String tenantId, String platId, String appId, String userId, String nickName, String provId, String cityId, String countyId, String deptId, String msgTitle, String readFlag, String removeFlag, String yearly, String monthly) {
        super(page, limit);
            this.tenantId = tenantId;
            this.platId = platId;
            this.appId = appId;
            this.userId = userId;
            this.nickName = nickName;
            this.provId = provId;
            this.cityId = cityId;
            this.countyId = countyId;
            this.deptId = deptId;
            this.msgTitle = msgTitle;
            this.readFlag = readFlag;
            this.removeFlag = removeFlag;
            this.yearly = yearly;
            this.monthly = monthly;
    }

    public static MsgPoolQueryBuilder builder() {
        return new MsgPoolQueryBuilder();
    }

    public static class MsgPoolQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String tenantId;
            private String platId;
            private String appId;
            private String userId;
            private String nickName;
            private String provId;
            private String cityId;
            private String countyId;
            private String deptId;
            private String msgTitle;
            private String readFlag;
            private String removeFlag;
            private String yearly;
            private String monthly;

        public MsgPoolQueryBuilder() {
        }

        public MsgPoolQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public MsgPoolQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 租户ID/公司ID */
            public MsgPoolQueryBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 平台ID */
            public MsgPoolQueryBuilder platId(String platId) {
                this.platId = platId;
                return this;
            }
            /* 应用ID */
            public MsgPoolQueryBuilder appId(String appId) {
                this.appId = appId;
                return this;
            }
            /* 用户ID */
            public MsgPoolQueryBuilder userId(String userId) {
                this.userId = userId;
                return this;
            }
            /* 昵称 */
            public MsgPoolQueryBuilder nickName(String nickName) {
                this.nickName = nickName;
                return this;
            }
            /* 省代码 */
            public MsgPoolQueryBuilder provId(String provId) {
                this.provId = provId;
                return this;
            }
            /* 市/州代码 */
            public MsgPoolQueryBuilder cityId(String cityId) {
                this.cityId = cityId;
                return this;
            }
            /* 区/县代码 */
            public MsgPoolQueryBuilder countyId(String countyId) {
                this.countyId = countyId;
                return this;
            }
            /* 部门ID */
            public MsgPoolQueryBuilder deptId(String deptId) {
                this.deptId = deptId;
                return this;
            }
            /* 消息标题 */
            public MsgPoolQueryBuilder msgTitle(String msgTitle) {
                this.msgTitle = msgTitle;
                return this;
            }
            /* 阅读标志 */
            public MsgPoolQueryBuilder readFlag(String readFlag) {
                this.readFlag = readFlag;
                return this;
            }
            /* 删除标志 */
            public MsgPoolQueryBuilder removeFlag(String removeFlag) {
                this.removeFlag = removeFlag;
                return this;
            }
            /* 年份 */
            public MsgPoolQueryBuilder yearly(String yearly) {
                this.yearly = yearly;
                return this;
            }
            /* 月份 */
            public MsgPoolQueryBuilder monthly(String monthly) {
                this.monthly = monthly;
                return this;
            }

        public MsgPoolQuery build() {
            return new MsgPoolQuery(page, limit, tenantId, platId, appId, userId, nickName, provId, cityId, countyId, deptId, msgTitle, readFlag, removeFlag, yearly, monthly);
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

        public void setMsgTitle(String msgTitle) {
            this.msgTitle = msgTitle;
        }

        public String getMsgTitle() {
            return msgTitle;
        }

        public void setReadFlag(String readFlag) {
            this.readFlag = readFlag;
        }

        public String getReadFlag() {
            return readFlag;
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
                    .append("provId", getProvId())
                    .append("cityId", getCityId())
                    .append("countyId", getCountyId())
                    .append("deptId", getDeptId())
                    .append("msgTitle", getMsgTitle())
                    .append("readFlag", getReadFlag())
                    .append("removeFlag", getRemoveFlag())
                    .append("yearly", getYearly())
                    .append("monthly", getMonthly())
                .toString();
    }

}
