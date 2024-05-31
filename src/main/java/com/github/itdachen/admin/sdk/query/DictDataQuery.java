package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 数据字典信息表 查询参数
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public class DictDataQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据字典类型ID
     */
    private String typeId;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
    private String validFlag;


    public DictDataQuery() {
    }

    public DictDataQuery(int page, int limit, String typeId, String dictType, String dictLabel, String dictValue, String validFlag) {
        super(page, limit);
        this.typeId = typeId;
        this.dictType = dictType;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
        this.validFlag = validFlag;
    }

    public static DictDataQueryBuilder builder() {
        return new DictDataQueryBuilder();
    }

    public static class DictDataQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String typeId;
        private String dictType;
        private String dictLabel;
        private String dictValue;
        private String validFlag;

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

        /* 数据字典类型ID */
        public DictDataQueryBuilder typeId(String typeId) {
            this.typeId = typeId;
            return this;
        }

        /* 字典类型 */
        public DictDataQueryBuilder dictType(String dictType) {
            this.dictType = dictType;
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

        /* 是否展示/有效标志: Y-有效;N-无效 */
        public DictDataQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        public DictDataQuery build() {
            return new DictDataQuery(page, limit, typeId, dictType, dictLabel, dictValue, validFlag);
        }

    }


    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
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
                .append("typeId", getTypeId())
                .append("dictType", getDictType())
                .append("dictLabel", getDictLabel())
                .append("dictValue", getDictValue())
                .append("validFlag", getValidFlag())
                .toString();
    }

}
