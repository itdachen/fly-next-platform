package com.github.itdachen.admin_v1.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 身份岗位
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
@Table(name = "sys_worker_identity_position")
public class WorkerIdentityPosition implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 身份ID
     */
    @Column(name = "identity_id")
    private String identityId;

    /**
     * 岗位ID
     */
    @Column(name = "position_id")
    private String positionId;

    /**
     * 客户端
     */
    @Column(name = "client_id")
    private String clientId;


    public WorkerIdentityPosition() {
    }


    public WorkerIdentityPosition(String id, String identityId, String positionId, String clientId) {
        this.id = id;
        this.identityId = identityId;
        this.positionId = positionId;
        this.clientId = clientId;
    }

    public static WorkerIdentityPosttionBuilder builder() {
        return new WorkerIdentityPosttionBuilder();
    }

    public static class WorkerIdentityPosttionBuilder {
        private String id;
        private String identityId;
        private String positionId;
        private String clientId;

        public WorkerIdentityPosttionBuilder() {
        }

        /* 主键唯一标识 */
        public WorkerIdentityPosttionBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 身份ID */
        public WorkerIdentityPosttionBuilder identityId(String identityId) {
            this.identityId = identityId;
            return this;
        }

        /* 岗位ID */
        public WorkerIdentityPosttionBuilder positionId(String positionId) {
            this.positionId = positionId;
            return this;
        }

        /* 客户端 */
        public WorkerIdentityPosttionBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public WorkerIdentityPosition build() {
            return new WorkerIdentityPosition(id,
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
