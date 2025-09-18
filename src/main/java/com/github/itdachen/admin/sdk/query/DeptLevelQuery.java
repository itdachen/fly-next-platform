package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 部门等级 查询参数
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
public class DeptLevelQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 租户ID */
    private String tenantId;

    /** 层级代码 */
    private String levelCode;

    /** 层级名称,例如: 00-总部; 10-省级部门; 20-市州级部门; 30-区县级;40-乡镇级;50-社区/街道/村 */
    private String levelTitle;

    /** 有效标志: Y-是;N-否 */
    private String validFlag;

    /** 删除标志:  Y-已删除;N-未删除 */
    private String removeFlag;



    public DeptLevelQuery() {
    }

    public DeptLevelQuery(int page, int limit, String tenantId, String levelCode, String levelTitle, String validFlag, String removeFlag) {
        super(page, limit);
        this.tenantId = tenantId;
        this.levelCode = levelCode;
        this.levelTitle = levelTitle;
        this.validFlag = validFlag;
        this.removeFlag = removeFlag;
    }

    public static DeptLevelQueryBuilder builder() {
        return new DeptLevelQueryBuilder();
    }

    public static class DeptLevelQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String tenantId;
        private String levelCode;
        private String levelTitle;
        private String validFlag;
        private String removeFlag;

        public DeptLevelQueryBuilder() {
        }

        public DeptLevelQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DeptLevelQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 租户ID */
        public DeptLevelQueryBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        /* 层级代码 */
        public DeptLevelQueryBuilder levelCode(String levelCode) {
            this.levelCode = levelCode;
            return this;
        }
        /* 层级名称,例如: 00-总部; 10-省级部门; 20-市州级部门; 30-区县级;40-乡镇级;50-社区/街道/村 */
        public DeptLevelQueryBuilder levelTitle(String levelTitle) {
            this.levelTitle = levelTitle;
            return this;
        }
        /* 有效标志: Y-是;N-否 */
        public DeptLevelQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }
        /* 删除标志:  Y-已删除;N-未删除 */
        public DeptLevelQueryBuilder removeFlag(String removeFlag) {
            this.removeFlag = removeFlag;
            return this;
        }

        public DeptLevelQuery build() {
            return new DeptLevelQuery(page, limit, tenantId, levelCode, levelTitle, validFlag, removeFlag);
        }

    }



    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelTitle(String levelTitle) {
        this.levelTitle = levelTitle;
    }

    public String getLevelTitle() {
        return levelTitle;
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
                .append("levelCode", getLevelCode())
                .append("levelTitle", getLevelTitle())
                .append("validFlag", getValidFlag())
                .append("removeFlag", getRemoveFlag())
                .toString();
    }

}
