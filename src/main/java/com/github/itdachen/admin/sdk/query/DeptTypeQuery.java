package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 部门类型管理 查询参数
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public class DeptTypeQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 标题 */
            private String title;

            /** 有效标志: Y-有效;N-无效 */
            private String validFlag;



    public DeptTypeQuery() {
    }

    public DeptTypeQuery(int page, int limit, String title, String validFlag) {
        super(page, limit);
            this.title = title;
            this.validFlag = validFlag;
    }

    public static DeptTypeQueryBuilder builder() {
        return new DeptTypeQueryBuilder();
    }

    public static class DeptTypeQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String title;
            private String validFlag;

        public DeptTypeQueryBuilder() {
        }

        public DeptTypeQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public DeptTypeQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 标题 */
            public DeptTypeQueryBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 有效标志: Y-有效;N-无效 */
            public DeptTypeQueryBuilder validFlag(String validFlag) {
                this.validFlag = validFlag;
                return this;
            }

        public DeptTypeQuery build() {
            return new DeptTypeQuery(page, limit, title, validFlag);
        }

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
                    .append("title", getTitle())
                    .append("validFlag", getValidFlag())
                .toString();
    }

}
