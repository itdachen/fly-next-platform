package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 身份岗位 查询参数
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
public class WorkerIdentityPositionQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 身份ID */
            private String identityId;

            /** 岗位ID */
            private String positionId;

            /** 客户端 */
            private String clientId;


    public WorkerIdentityPositionQuery() {
    }

    public WorkerIdentityPositionQuery(int page, int limit, String identityId, String positionId, String clientId) {
        super(page, limit);
            this.identityId = identityId;
            this.positionId = positionId;
            this.clientId = clientId;
    }

    public static WorkerIdentityPosttionQueryBuilder builder() {
        return new WorkerIdentityPosttionQueryBuilder();
    }

    public static class WorkerIdentityPosttionQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String identityId;
            private String positionId;
            private String clientId;

        public WorkerIdentityPosttionQueryBuilder() {
        }

        public WorkerIdentityPosttionQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public WorkerIdentityPosttionQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 身份ID */
            public WorkerIdentityPosttionQueryBuilder identityId(String identityId) {
                this.identityId = identityId;
                return this;
            }
            /* 岗位ID */
            public WorkerIdentityPosttionQueryBuilder positionId(String positionId) {
                this.positionId = positionId;
                return this;
            }
            /* 客户端 */
            public WorkerIdentityPosttionQueryBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }

        public WorkerIdentityPositionQuery build() {
            return new WorkerIdentityPositionQuery(page, limit, identityId, positionId, clientId);
        }

    }




        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setPositionId(String positionId) {
            this.positionId = positionId;
        }

        public String getPositionId() {
            return positionId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientId() {
            return clientId;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("identityId", getIdentityId())
                    .append("positionId", getPositionId())
                    .append("clientId", getClientId())
                .toString();
    }

}
