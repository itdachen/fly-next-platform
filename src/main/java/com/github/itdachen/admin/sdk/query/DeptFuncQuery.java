package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 部门职能管理 查询参数
 *
 * @author 王大宸
 * @date 2025-09-18 23:03:17
 */
public class DeptFuncQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 租户ID */
            private String tenantId;

            /** 部门职能编码, 例如: 001-销售;002-研发 */
            private String funcCode;

            /** 职能标题 */
            private String title;

            /** 有效标志: Y-有效;N-无效 */
            private String validFlag;

            /** 删除标志:  Y-已删除;N-未删除 */
            private String removeFlag;



    public DeptFuncQuery() {
    }

    public DeptFuncQuery(int page, int limit, String tenantId, String funcCode, String title, String validFlag, String removeFlag) {
        super(page, limit);
            this.tenantId = tenantId;
            this.funcCode = funcCode;
            this.title = title;
            this.validFlag = validFlag;
            this.removeFlag = removeFlag;
    }

    public static DeptFuncQueryBuilder builder() {
        return new DeptFuncQueryBuilder();
    }

    public static class DeptFuncQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String tenantId;
            private String funcCode;
            private String title;
            private String validFlag;
            private String removeFlag;

        public DeptFuncQueryBuilder() {
        }

        public DeptFuncQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DeptFuncQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 租户ID */
            public DeptFuncQueryBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 部门职能编码, 例如: 001-销售;002-研发 */
            public DeptFuncQueryBuilder funcCode(String funcCode) {
                this.funcCode = funcCode;
                return this;
            }
            /* 职能标题 */
            public DeptFuncQueryBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 有效标志: Y-有效;N-无效 */
            public DeptFuncQueryBuilder validFlag(String validFlag) {
                this.validFlag = validFlag;
                return this;
            }
            /* 删除标志:  Y-已删除;N-未删除 */
            public DeptFuncQueryBuilder removeFlag(String removeFlag) {
                this.removeFlag = removeFlag;
                return this;
            }

        public DeptFuncQuery build() {
            return new DeptFuncQuery(page, limit, tenantId, funcCode, title, validFlag, removeFlag);
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
                    .append("title", getTitle())
                    .append("validFlag", getValidFlag())
                    .append("removeFlag", getRemoveFlag())
                .toString();
    }

}
