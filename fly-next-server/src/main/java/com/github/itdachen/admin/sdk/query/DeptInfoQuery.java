package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 部门管理 查询参数
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DeptInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 部门名称 */
            private String title;

            /** 上级id */
            private String parentId;

            /** 是否可删除: 1-可删除;0-不可删 */
            private String isCanDel;


    public DeptInfoQuery() {
    }

    public DeptInfoQuery(int page, int limit, String title, String parentId, String isCanDel) {
        super(page, limit);
            this.title = title;
            this.parentId = parentId;
            this.isCanDel = isCanDel;
    }

    public static DeptInfoQueryBuilder builder() {
        return new DeptInfoQueryBuilder();
    }

    public static class DeptInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String title;
            private String parentId;
            private String isCanDel;

        public DeptInfoQueryBuilder() {
        }

        public DeptInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DeptInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 部门名称 */
            public DeptInfoQueryBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 上级id */
            public DeptInfoQueryBuilder parentId(String parentId) {
                this.parentId = parentId;
                return this;
            }
            /* 是否可删除: 1-可删除;0-不可删 */
            public DeptInfoQueryBuilder isCanDel(String isCanDel) {
                this.isCanDel = isCanDel;
                return this;
            }

        public DeptInfoQuery build() {
            return new DeptInfoQuery(page, limit, title, parentId, isCanDel);
        }

    }




        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setIsCanDel(String isCanDel) {
            this.isCanDel = isCanDel;
        }

        public String getIsCanDel() {
            return isCanDel;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("title", getTitle())
                    .append("parentId", getParentId())
                    .append("isCanDel", getIsCanDel())
                .toString();
    }

}
