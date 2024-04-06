package com.github.itdachen.admin_v1.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 身份岗位 请求参数数据
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
public class WorkerIdentityPositionDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 主键唯一标识 */
        private String id;


        /** 身份ID */
        private String identityId;


        /** 岗位ID */
        private String positionId;


        /** 客户端 */
        private String clientId;


    public WorkerIdentityPositionDto() {}

    public WorkerIdentityPositionDto(String id, String identityId, String positionId, String clientId) {
            this.id = id;
            this.identityId = identityId;
            this.positionId = positionId;
            this.clientId = clientId;
    }

    public static WorkerIdentityPosttionDtoBuilder builder() {
        return new WorkerIdentityPosttionDtoBuilder();
    }

    public static class WorkerIdentityPosttionDtoBuilder {
            private String id;
            private String identityId;
            private String positionId;
            private String clientId;

        public WorkerIdentityPosttionDtoBuilder() {}

            /* 主键唯一标识 */
            public WorkerIdentityPosttionDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 身份ID */
            public WorkerIdentityPosttionDtoBuilder identityId(String identityId) {
                this.identityId = identityId;
                return this;
            }
            /* 岗位ID */
            public WorkerIdentityPosttionDtoBuilder positionId(String positionId) {
                this.positionId = positionId;
                return this;
            }
            /* 客户端 */
            public WorkerIdentityPosttionDtoBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }

        public WorkerIdentityPositionDto build() {
            return new WorkerIdentityPositionDto(id, identityId, positionId, clientId);
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
