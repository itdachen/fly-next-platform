package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



/**
 * 用户角色
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Table(name = "sys_role_user")
public class RoleUser implements Serializable{
private static final long serialVersionUID=1L;

    /** 数据唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 用户id */
    @Column(name = "user_id")
    private String userId;

    /** 角色id */
    @Column(name = "role_id")
    private String roleId;


public RoleUser(){}


public RoleUser(    String id,     String userId,     String roleId){
            this.id = id;
            this.userId = userId;
            this.roleId = roleId;
}

public static RoleUserBuilder builder(){
        return new RoleUserBuilder();
        }

public static class RoleUserBuilder {
        private String id;
        private String userId;
        private String roleId;

    public RoleUserBuilder() {
    }

        /* 数据唯一标识 */
        public RoleUserBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 用户id */
        public RoleUserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }
        /* 角色id */
        public RoleUserBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

    public RoleUser build() {
        return new RoleUser(            id, 
            userId, 
            roleId
);
    }

}


            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserId() {
                return userId;
            }

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

            public String getRoleId() {
                return roleId;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("userId", getUserId())
                    .append("roleId", getRoleId())
                .toString();
    }


}
