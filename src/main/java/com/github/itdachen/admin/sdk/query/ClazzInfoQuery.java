package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 岗位信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
public class ClazzInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 岗位等级
     */
    private String thatLevel;

    /**
     * 岗位类型ID
     */
    private String typeId;

    /**
     * 岗位名称
     */
    private String title;

    /**
     * 有效标志
     */
    private String validFlag;


    public ClazzInfoQuery() {
    }

    public ClazzInfoQuery(int page, int limit, String thatLevel, String typeId, String title, String validFlag) {
        super(page, limit);
        this.thatLevel = thatLevel;
        this.typeId = typeId;
        this.title = title;
        this.validFlag = validFlag;
    }

    public static ClazzInfoQueryBuilder builder() {
        return new ClazzInfoQueryBuilder();
    }

    public static class ClazzInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String thatLevel;
        private String typeId;
        private String title;
        private String validFlag;

        public ClazzInfoQueryBuilder() {
        }

        public ClazzInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public ClazzInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 岗位等级 */
        public ClazzInfoQueryBuilder thatLevel(String thatLevel) {
            this.thatLevel = thatLevel;
            return this;
        }

        /* 岗位类型ID */
        public ClazzInfoQueryBuilder typeId(String typeId) {
            this.typeId = typeId;
            return this;
        }

        /* 岗位名称 */
        public ClazzInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 有效标志 */
        public ClazzInfoQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        public ClazzInfoQuery build() {
            return new ClazzInfoQuery(page, limit, thatLevel, typeId, title, validFlag);
        }

    }


    public void setThatLevel(String thatLevel) {
        this.thatLevel = thatLevel;
    }

    public String getThatLevel() {
        return thatLevel;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
                .append("thatLevel", getThatLevel())
                .append("typeId", getTypeId())
                .append("title", getTitle())
                .append("validFlag", getValidFlag())
                .toString();
    }

}