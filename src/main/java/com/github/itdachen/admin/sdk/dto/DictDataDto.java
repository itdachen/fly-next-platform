package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 字典数据表 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DictDataDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 字典id */
        private String id;


        /** 字典排序 */
        private Integer dictSort;


        /** 字典标签 */
        private String dictLabel;


        /** 字典键值 */
        private String dictValue;


        /** 字典类型 */
        private String dictType;


        /** 样式属性（其他样式扩展） */
        private String cssClass;


        /** 表格回显样式 */
        private String listClass;


        /** 是否默认（Y是 N否） */
        private String isDefault;


        /** 状态,数据字典:dict_data_status */
        private String status;


        /** 备注 */
        private String remarks;


    public DictDataDto() {}

    public DictDataDto(String id, Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status, String remarks) {
            this.id = id;
            this.dictSort = dictSort;
            this.dictLabel = dictLabel;
            this.dictValue = dictValue;
            this.dictType = dictType;
            this.cssClass = cssClass;
            this.listClass = listClass;
            this.isDefault = isDefault;
            this.status = status;
            this.remarks = remarks;
    }

    public static DictDataDtoBuilder builder() {
        return new DictDataDtoBuilder();
    }

    public static class DictDataDtoBuilder {
            private String id;
            private Integer dictSort;
            private String dictLabel;
            private String dictValue;
            private String dictType;
            private String cssClass;
            private String listClass;
            private String isDefault;
            private String status;
            private String remarks;

        public DictDataDtoBuilder() {}

            /* 字典id */
            public DictDataDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 字典排序 */
            public DictDataDtoBuilder dictSort(Integer dictSort) {
                this.dictSort = dictSort;
                return this;
            }
            /* 字典标签 */
            public DictDataDtoBuilder dictLabel(String dictLabel) {
                this.dictLabel = dictLabel;
                return this;
            }
            /* 字典键值 */
            public DictDataDtoBuilder dictValue(String dictValue) {
                this.dictValue = dictValue;
                return this;
            }
            /* 字典类型 */
            public DictDataDtoBuilder dictType(String dictType) {
                this.dictType = dictType;
                return this;
            }
            /* 样式属性（其他样式扩展） */
            public DictDataDtoBuilder cssClass(String cssClass) {
                this.cssClass = cssClass;
                return this;
            }
            /* 表格回显样式 */
            public DictDataDtoBuilder listClass(String listClass) {
                this.listClass = listClass;
                return this;
            }
            /* 是否默认（Y是 N否） */
            public DictDataDtoBuilder isDefault(String isDefault) {
                this.isDefault = isDefault;
                return this;
            }
            /* 状态,数据字典:dict_data_status */
            public DictDataDtoBuilder status(String status) {
                this.status = status;
                return this;
            }
            /* 备注 */
            public DictDataDtoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }

        public DictDataDto build() {
            return new DictDataDto(id, dictSort, dictLabel, dictValue, dictType, cssClass, listClass, isDefault, status, remarks);
        }

    }



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }
            public void setDictSort(Integer dictSort) {
                this.dictSort = dictSort;
            }

            public Integer getDictSort() {
                return dictSort;
            }
            public void setDictLabel(String dictLabel) {
                this.dictLabel = dictLabel;
            }

            public String getDictLabel() {
                return dictLabel;
            }
            public void setDictValue(String dictValue) {
                this.dictValue = dictValue;
            }

            public String getDictValue() {
                return dictValue;
            }
            public void setDictType(String dictType) {
                this.dictType = dictType;
            }

            public String getDictType() {
                return dictType;
            }
            public void setCssClass(String cssClass) {
                this.cssClass = cssClass;
            }

            public String getCssClass() {
                return cssClass;
            }
            public void setListClass(String listClass) {
                this.listClass = listClass;
            }

            public String getListClass() {
                return listClass;
            }
            public void setIsDefault(String isDefault) {
                this.isDefault = isDefault;
            }

            public String getIsDefault() {
                return isDefault;
            }
            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatus() {
                return status;
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
                    .append("dictSort", getDictSort())
                    .append("dictLabel", getDictLabel())
                    .append("dictValue", getDictValue())
                    .append("dictType", getDictType())
                    .append("cssClass", getCssClass())
                    .append("listClass", getListClass())
                    .append("isDefault", getIsDefault())
                    .append("status", getStatus())
                    .append("remarks", getRemarks())
                .toString();
    }

}
