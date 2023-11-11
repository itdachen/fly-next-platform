package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 字典类型表 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DictTypeDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 字典主键 */
        private String id;


        /** 字典名称 */
        private String dictName;


        /** 字典类型 */
        private String dictType;


        /** 状态,数据字典: dict_data_status */
        private String status;


        /** 备注 */
        private String remarks;


    public DictTypeDto() {}

    public DictTypeDto(String id, String dictName, String dictType, String status, String remarks) {
            this.id = id;
            this.dictName = dictName;
            this.dictType = dictType;
            this.status = status;
            this.remarks = remarks;
    }

    public static DictTypeDtoBuilder builder() {
        return new DictTypeDtoBuilder();
    }

    public static class DictTypeDtoBuilder {
            private String id;
            private String dictName;
            private String dictType;
            private String status;
            private String remarks;

        public DictTypeDtoBuilder() {}

            /* 字典主键 */
            public DictTypeDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 字典名称 */
            public DictTypeDtoBuilder dictName(String dictName) {
                this.dictName = dictName;
                return this;
            }
            /* 字典类型 */
            public DictTypeDtoBuilder dictType(String dictType) {
                this.dictType = dictType;
                return this;
            }
            /* 状态,数据字典: dict_data_status */
            public DictTypeDtoBuilder status(String status) {
                this.status = status;
                return this;
            }
            /* 备注 */
            public DictTypeDtoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }

        public DictTypeDto build() {
            return new DictTypeDto(id, dictName, dictType, status, remarks);
        }

    }



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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
                    .append("dictName", getDictName())
                    .append("dictType", getDictType())
                    .append("status", getStatus())
                    .append("remarks", getRemarks())
                .toString();
    }

}
