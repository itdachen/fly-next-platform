package com.github.itdachen.admin.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 行政区划代码 DTO
 *
 * @author 王大宸
 * @date 2024-05-06 21:18:46
 */
public class AdmAreaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键 */
        private Long id;

        /** 省、直辖市、自治区代码 */
 @NotBlank(message = "省、直辖市、自治区代码不能为空")
        private String provCode;

        /** 城市代码 */
 @NotBlank(message = "城市代码不能为空")
        private String cityCode;

        /** 区县代码 */
 @NotBlank(message = "区县代码不能为空")
        private String countyCode;

        /** 乡镇代码 */
 @NotBlank(message = "乡镇代码不能为空")
        private String townCode;

        /** 街道代码 */
 @NotBlank(message = "街道代码不能为空")
        private String streetCode;

        /** 街道名称 */
 @NotBlank(message = "街道名称不能为空")
        private String streetName;

        /** 城乡街道分类代码 */
 @NotBlank(message = "城乡街道分类代码不能为空")
        private String streetType;

        /** 数据级别：省市区县乡镇街道 */
 @NotBlank(message = "数据级别：省市区县乡镇街道不能为空")
        private String levelType;





            public void setId(Long id) {
                this.id = id;
            }

            public Long getId() {
                return id;
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
                    .append("id", getId())
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
