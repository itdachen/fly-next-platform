package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 身份岗位 Vo
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
public class WorkerIdentityPositionVo implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键唯一标识 */
        private String id;

        /** 身份ID */
        private String identityId;

        /** 岗位ID */
        private String positionId;

        /** 客户端 */
        private String clientId;


    public WorkerIdentityPositionVo() {
    }

    public WorkerIdentityPositionVo(String id, String identityId, String positionId, String clientId) {
            this.id = id;
            this.identityId = identityId;
            this.positionId = positionId;
            this.clientId = clientId;
    }

    public static WorkerIdentityPosttionVoBuilder builder() {
        return new WorkerIdentityPosttionVoBuilder();
    }

    public static class WorkerIdentityPosttionVoBuilder {
            private String id;
            private String identityId;
            private String positionId;
            private String clientId;

        public   WorkerIdentityPosttionVoBuilder() {
        }

            /* 主键唯一标识 */
            public WorkerIdentityPosttionVoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 身份ID */
            public WorkerIdentityPosttionVoBuilder identityId(String identityId) {
                this.identityId = identityId;
                return this;
            }
            /* 岗位ID */
            public WorkerIdentityPosttionVoBuilder positionId(String positionId) {
                this.positionId = positionId;
                return this;
            }
            /* 客户端 */
            public WorkerIdentityPosttionVoBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }

        public WorkerIdentityPositionVo build() {
            return new WorkerIdentityPositionVo(                id,
                identityId, 
                positionId, 
                clientId
);
        }

    }


            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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
                    .append("id", getId())
                    .append("identityId", getIdentityId())
                    .append("positionId", getPositionId())
                    .append("clientId", getClientId())
                .toString();
    }

}
