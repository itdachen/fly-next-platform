package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
    import java.time.LocalDateTime;



/**
 * 角色
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Table(name = "sys_role_info")
public class RoleInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键id */
    @Id
    @Column(name = "id")
    private String id;

    /** 部门id */
    @Column(name = "dept_id")
    private String deptId;

    /** 角色名称 */
    @Column(name = "title")
    private String title;

    /** 描述 */
    @Column(name = "remarks")
    private String remarks;

    /** 客户端 */
    @Column(name = "client_id")
    private String clientId;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId;


public RoleInfo(){}


public RoleInfo(    String id,     String deptId,     String title,     String remarks,     String clientId,     LocalDateTime createTime,     String createUser,     String createUserId,     String updateUser,     LocalDateTime updateTime,     String updateUserId){
            this.id = id;
            this.deptId = deptId;
            this.title = title;
            this.remarks = remarks;
            this.clientId = clientId;
            this.createTime = createTime;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.updateUser = updateUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
}

public static RoleInfoBuilder builder(){
        return new RoleInfoBuilder();
        }

public static class RoleInfoBuilder {
        private String id;
        private String deptId;
        private String title;
        private String remarks;
        private String clientId;
        private LocalDateTime createTime;
        private String createUser;
        private String createUserId;
        private String updateUser;
        private LocalDateTime updateTime;
        private String updateUserId;

    public RoleInfoBuilder() {
    }

        /* 主键id */
        public RoleInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 部门id */
        public RoleInfoBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }
        /* 角色名称 */
        public RoleInfoBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 描述 */
        public RoleInfoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 客户端 */
        public RoleInfoBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        /* 创建时间 */
        public RoleInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人 */
        public RoleInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建人id */
        public RoleInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 更新人 */
        public RoleInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新时间 */
        public RoleInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人id */
        public RoleInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public RoleInfo build() {
        return new RoleInfo(            id, 
            deptId, 
            title, 
            remarks, 
            clientId, 
            createTime, 
            createUser, 
            createUserId, 
            updateUser, 
            updateTime, 
            updateUserId
);
    }

}


            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientId() {
                return clientId;
            }

            public void setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateTime(LocalDateTime updateTime) {
                this.updateTime = updateTime;
            }

            public LocalDateTime getUpdateTime() {
                return updateTime;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("deptId", getDeptId())
                    .append("title", getTitle())
                    .append("remarks", getRemarks())
                    .append("clientId", getClientId())
                    .append("createTime", getCreateTime())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateUser", getUpdateUser())
                    .append("updateTime", getUpdateTime())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
