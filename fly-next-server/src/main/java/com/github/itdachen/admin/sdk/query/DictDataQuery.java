package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 字典数据表 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DictDataQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 字典排序 */
            private Integer dictSort;

            /** 字典标签 */
            private String dictLabel;

            /** 字典键值 */
            private String dictValue;

            /** 字典类型 */
            private String dictType;

            /** 是否默认（Y是 N否） */
            private String isDefault;

            /** 状态,数据字典:dict_data_status */
            private String status;


    public DictDataQuery() {
    }

    public DictDataQuery(int page, int limit, Integer dictSort, String dictLabel, String dictValue, String dictType, String isDefault, String status) {
        super(page, limit);
            this.dictSort = dictSort;
            this.dictLabel = dictLabel;
            this.dictValue = dictValue;
            this.dictType = dictType;
            this.isDefault = isDefault;
            this.status = status;
    }

    public static DictDataQueryBuilder builder() {
        return new DictDataQueryBuilder();
    }

    public static class DictDataQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private Integer dictSort;
            private String dictLabel;
            private String dictValue;
            private String dictType;
            private String isDefault;
            private String status;

        public DictDataQueryBuilder() {
        }

        public DictDataQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DictDataQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 字典排序 */
            public DictDataQueryBuilder dictSort(Integer dictSort) {
                this.dictSort = dictSort;
                return this;
            }
            /* 字典标签 */
            public DictDataQueryBuilder dictLabel(String dictLabel) {
                this.dictLabel = dictLabel;
                return this;
            }
            /* 字典键值 */
            public DictDataQueryBuilder dictValue(String dictValue) {
                this.dictValue = dictValue;
                return this;
            }
            /* 字典类型 */
            public DictDataQueryBuilder dictType(String dictType) {
                this.dictType = dictType;
                return this;
            }
            /* 是否默认（Y是 N否） */
            public DictDataQueryBuilder isDefault(String isDefault) {
                this.isDefault = isDefault;
                return this;
            }
            /* 状态,数据字典:dict_data_status */
            public DictDataQueryBuilder status(String status) {
                this.status = status;
                return this;
            }

        public DictDataQuery build() {
            return new DictDataQuery(page, limit, dictSort, dictLabel, dictValue, dictType, isDefault, status);
        }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("dictSort", getDictSort())
                    .append("dictLabel", getDictLabel())
                    .append("dictValue", getDictValue())
                    .append("dictType", getDictType())
                    .append("isDefault", getIsDefault())
                    .append("status", getStatus())
                .toString();
    }

}
