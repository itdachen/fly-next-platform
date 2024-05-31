package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 数据字典类型 VO
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public class DictTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 数据字典类型ID */
        private String id;

        /** 字典标签 */
        private String dictLabel;

        /** 字典类型 */
        private String dictType;

        /** 字典排序 */
        private Integer dictSort;

        /** 是否默认 */
        private Boolean isDefault;

        /** 有效标志 */
        private String validFlag;

        /** 备注 */
        private String remarks;



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setDictLabel(String dictLabel) {
                this.dictLabel = dictLabel;
            }

            public String getDictLabel() {
                return dictLabel;
            }

            public void setDictType(String dictType) {
                this.dictType = dictType;
            }

            public String getDictType() {
                return dictType;
            }

            public void setDictSort(Integer dictSort) {
                this.dictSort = dictSort;
            }

            public Integer getDictSort() {
                return dictSort;
            }

            public void setIsDefault(Boolean isDefault) {
                this.isDefault = isDefault;
            }

            public Boolean getIsDefault() {
                return isDefault;
            }

            public void setValidFlag(String validFlag) {
                this.validFlag = validFlag;
            }

            public String getValidFlag() {
                return validFlag;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("dictLabel", getDictLabel())
                    .append("dictType", getDictType())
                    .append("dictSort", getDictSort())
                    .append("isDefault", getIsDefault())
                    .append("validFlag", getValidFlag())
                    .append("remarks", getRemarks())
                .toString();
    }

}
