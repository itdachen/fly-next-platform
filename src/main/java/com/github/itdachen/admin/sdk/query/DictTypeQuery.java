package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 字典类型表 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DictTypeQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 字典名称 */
            private String dictName;

            /** 字典类型 */
            private String dictType;

            /** 状态,数据字典: dict_data_status */
            private String status;


    public DictTypeQuery() {
    }

    public DictTypeQuery(int page, int limit, String dictName, String dictType, String status) {
        super(page, limit);
            this.dictName = dictName;
            this.dictType = dictType;
            this.status = status;
    }

    public static DictTypeQueryBuilder builder() {
        return new DictTypeQueryBuilder();
    }

    public static class DictTypeQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String dictName;
            private String dictType;
            private String status;

        public DictTypeQueryBuilder() {
        }

        public DictTypeQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DictTypeQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 字典名称 */
            public DictTypeQueryBuilder dictName(String dictName) {
                this.dictName = dictName;
                return this;
            }
            /* 字典类型 */
            public DictTypeQueryBuilder dictType(String dictType) {
                this.dictType = dictType;
                return this;
            }
            /* 状态,数据字典: dict_data_status */
            public DictTypeQueryBuilder status(String status) {
                this.status = status;
                return this;
            }

        public DictTypeQuery build() {
            return new DictTypeQuery(page, limit, dictName, dictType, status);
        }

    }




        public void setDictName(String dictName) {
            this.dictName = dictName;
        }

        public String getDictName() {
            return dictName;
        }

        public void setDictType(String dictType) {
            this.dictType = dictType;
        }

        public String getDictType() {
            return dictType;
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
                    .append("dictName", getDictName())
                    .append("dictType", getDictType())
                    .append("status", getStatus())
                .toString();
    }

}
