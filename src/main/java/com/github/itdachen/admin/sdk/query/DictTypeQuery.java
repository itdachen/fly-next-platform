package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 数据字典类型 查询参数
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public class DictTypeQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 字典标签 */
            private String dictLabel;

            /** 有效标志 */
            private String validFlag;



    public DictTypeQuery() {
    }

    public DictTypeQuery(int page, int limit, String dictLabel, String validFlag) {
        super(page, limit);
            this.dictLabel = dictLabel;
            this.validFlag = validFlag;
    }

    public static DictTypeQueryBuilder builder() {
        return new DictTypeQueryBuilder();
    }

    public static class DictTypeQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String dictLabel;
            private String validFlag;

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

            /* 字典标签 */
            public DictTypeQueryBuilder dictLabel(String dictLabel) {
                this.dictLabel = dictLabel;
                return this;
            }
            /* 有效标志 */
            public DictTypeQueryBuilder validFlag(String validFlag) {
                this.validFlag = validFlag;
                return this;
            }

        public DictTypeQuery build() {
            return new DictTypeQuery(page, limit, dictLabel, validFlag);
        }

    }



        public void setDictLabel(String dictLabel) {
            this.dictLabel = dictLabel;
        }

        public String getDictLabel() {
            return dictLabel;
        }

        public void setValidFlag(String validFlag) {
            this.validFlag = validFlag;
        }

        public String getValidFlag() {
            return validFlag;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("dictLabel", getDictLabel())
                    .append("validFlag", getValidFlag())
                .toString();
    }

}
