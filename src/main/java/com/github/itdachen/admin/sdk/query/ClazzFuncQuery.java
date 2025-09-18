package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 岗位职能管理 查询参数
 *
 * @author 王大宸
 * @date 2025-09-18 22:27:28
 */
public class ClazzFuncQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 岗位职能编码, 例如: 001-主管领导岗;002-业务岗
     */
    private String funcCode;

    /**
     * 岗位职能标题, 例如: 001-主管领导岗;002-业务岗
     */
    private String funcTitle;

    /**
     * 有效标志: Y-有效;N-无效
     */
    private String validFlag;

    /**
     * 删除标志:  Y-已删除;N-未删除
     */
    private String removeFlag;


    public ClazzFuncQuery() {
    }

    public ClazzFuncQuery(int page, int limit, String tenantId, String funcCode, String funcTitle, String validFlag, String removeFlag) {
        super(page, limit);
        this.tenantId = tenantId;
        this.funcCode = funcCode;
        this.funcTitle = funcTitle;
        this.validFlag = validFlag;
        this.removeFlag = removeFlag;
    }

    public static ClazzFuncQueryBuilder builder() {
        return new ClazzFuncQueryBuilder();
    }

    public static class ClazzFuncQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String funcCode;
        private String funcTitle;
        private String validFlag;
        private String removeFlag;

        public ClazzFuncQueryBuilder() {
        }

        public ClazzFuncQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public ClazzFuncQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public ClazzFuncQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 岗位职能编码, 例如: 001-主管领导岗;002-业务岗 */
        public ClazzFuncQueryBuilder funcCode(String funcCode) {
            this.funcCode = funcCode;
            return this;
        }

        /* 岗位职能标题, 例如: 001-主管领导岗;002-业务岗 */
        public ClazzFuncQueryBuilder funcTitle(String funcTitle) {
            this.funcTitle = funcTitle;
            return this;
        }

        /* 有效标志: Y-有效;N-无效 */
        public ClazzFuncQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        /* 删除标志:  Y-已删除;N-未删除 */
        public ClazzFuncQueryBuilder removeFlag(String removeFlag) {
            this.removeFlag = removeFlag;
            return this;
        }

        public ClazzFuncQuery build() {
            return new ClazzFuncQuery(page, limit, tenantId, funcCode, funcTitle, validFlag, removeFlag);
        }

    }


    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setRemoveFlag(String removeFlag) {
        this.removeFlag = removeFlag;
    }

    public String getRemoveFlag() {
        return removeFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("page", getPage())
                .append("limit", getLimit())
                .append("tenantId", getTenantId())
                .append("funcCode", getFuncCode())
                .append("funcTitle", getFuncTitle())
                .append("validFlag", getValidFlag())
                .append("removeFlag", getRemoveFlag())
                .toString();
    }

}
