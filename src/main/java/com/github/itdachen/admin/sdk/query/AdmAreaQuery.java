package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 行政区划代码 查询参数
 *
 * @author 王大宸
 * @date 2024-05-06 21:18:46
 */
public class AdmAreaQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 省、直辖市、自治区代码 */
            private String provCode;

            /** 城市代码 */
            private String cityCode;

            /** 区县代码 */
            private String countyCode;

            /** 乡镇代码 */
            private String townCode;

            /** 街道代码 */
            private String streetCode;

            /** 街道名称 */
            private String streetName;

            /** 城乡街道分类代码 */
            private String streetType;

            /** 数据级别：省市区县乡镇街道 */
            private String levelType;



    public AdmAreaQuery() {
    }

    public AdmAreaQuery(int page, int limit, String provCode, String cityCode, String countyCode, String townCode, String streetCode, String streetName, String streetType, String levelType) {
        super(page, limit);
            this.provCode = provCode;
            this.cityCode = cityCode;
            this.countyCode = countyCode;
            this.townCode = townCode;
            this.streetCode = streetCode;
            this.streetName = streetName;
            this.streetType = streetType;
            this.levelType = levelType;
    }

    public static AdmAreaQueryBuilder builder() {
        return new AdmAreaQueryBuilder();
    }

    public static class AdmAreaQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String provCode;
            private String cityCode;
            private String countyCode;
            private String townCode;
            private String streetCode;
            private String streetName;
            private String streetType;
            private String levelType;

        public AdmAreaQueryBuilder() {
        }

        public AdmAreaQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public AdmAreaQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 省、直辖市、自治区代码 */
            public AdmAreaQueryBuilder provCode(String provCode) {
                this.provCode = provCode;
                return this;
            }
            /* 城市代码 */
            public AdmAreaQueryBuilder cityCode(String cityCode) {
                this.cityCode = cityCode;
                return this;
            }
            /* 区县代码 */
            public AdmAreaQueryBuilder countyCode(String countyCode) {
                this.countyCode = countyCode;
                return this;
            }
            /* 乡镇代码 */
            public AdmAreaQueryBuilder townCode(String townCode) {
                this.townCode = townCode;
                return this;
            }
            /* 街道代码 */
            public AdmAreaQueryBuilder streetCode(String streetCode) {
                this.streetCode = streetCode;
                return this;
            }
            /* 街道名称 */
            public AdmAreaQueryBuilder streetName(String streetName) {
                this.streetName = streetName;
                return this;
            }
            /* 城乡街道分类代码 */
            public AdmAreaQueryBuilder streetType(String streetType) {
                this.streetType = streetType;
                return this;
            }
            /* 数据级别：省市区县乡镇街道 */
            public AdmAreaQueryBuilder levelType(String levelType) {
                this.levelType = levelType;
                return this;
            }

        public AdmAreaQuery build() {
            return new AdmAreaQuery(page, limit, provCode, cityCode, countyCode, townCode, streetCode, streetName, streetType, levelType);
        }

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

        public void setStreetCode(String streetCode) {
            this.streetCode = streetCode;
        }

        public String getStreetCode() {
            return streetCode;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetType(String streetType) {
            this.streetType = streetType;
        }

        public String getStreetType() {
            return streetType;
        }

        public void setLevelType(String levelType) {
            this.levelType = levelType;
        }

        public String getLevelType() {
            return levelType;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("provCode", getProvCode())
                    .append("cityCode", getCityCode())
                    .append("countyCode", getCountyCode())
                    .append("townCode", getTownCode())
                    .append("streetCode", getStreetCode())
                    .append("streetName", getStreetName())
                    .append("streetType", getStreetType())
                    .append("levelType", getLevelType())
                .toString();
    }

}
