package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
    import java.time.LocalDateTime;



/**
 * 部门管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Table(name = "sys_dept_info")
public class DeptInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 部门名称 */
    @Column(name = "title")
    private String title;

    /** 上级id */
    @Column(name = "parent_id")
    private String parentId;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 是否可删除: 1-可删除;0-不可删 */
    @Column(name = "is_can_del")
    private String isCanDel;

    /** 负责人 */
    @Column(name = "person_charge")
    private String personCharge;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人ID */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人ID */
    @Column(name = "update_user_id")
    private String updateUserId;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;


public DeptInfo(){}


public DeptInfo(    String id,     String title,     String parentId,     String remarks,     String isCanDel,     String personCharge,     LocalDateTime createTime,     String createUserId,     String createUser,     LocalDateTime updateTime,     String updateUserId,     String updateUser){
            this.id = id;
            this.title = title;
            this.parentId = parentId;
            this.remarks = remarks;
            this.isCanDel = isCanDel;
            this.personCharge = personCharge;
            this.createTime = createTime;
            this.createUserId = createUserId;
            this.createUser = createUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
            this.updateUser = updateUser;
}

public static DeptInfoBuilder builder(){
        return new DeptInfoBuilder();
        }

public static class DeptInfoBuilder {
        private String id;
        private String title;
        private String parentId;
        private String remarks;
        private String isCanDel;
        private String personCharge;
        private LocalDateTime createTime;
        private String createUserId;
        private String createUser;
        private LocalDateTime updateTime;
        private String updateUserId;
        private String updateUser;

    public DeptInfoBuilder() {
    }

        /* 主键唯一标识 */
        public DeptInfoBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 部门名称 */
        public DeptInfoBuilder title(String title) {
            this.title = title;
            return this;
        }
        /* 上级id */
        public DeptInfoBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }
        /* 备注 */
        public DeptInfoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 是否可删除: 1-可删除;0-不可删 */
        public DeptInfoBuilder isCanDel(String isCanDel) {
            this.isCanDel = isCanDel;
            return this;
        }
        /* 负责人 */
        public DeptInfoBuilder personCharge(String personCharge) {
            this.personCharge = personCharge;
            return this;
        }
        /* 创建时间 */
        public DeptInfoBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 创建人ID */
        public DeptInfoBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建人 */
        public DeptInfoBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 更新时间 */
        public DeptInfoBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新人ID */
        public DeptInfoBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }
        /* 更新人 */
        public DeptInfoBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }

    public DeptInfo build() {
        return new DeptInfo(            id, 
            title, 
            parentId, 
            remarks, 
            isCanDel, 
            personCharge, 
            createTime, 
            createUserId, 
            createUser, 
            updateTime, 
            updateUserId, 
            updateUser
);
    }

}


            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
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

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setIsCanDel(String isCanDel) {
                this.isCanDel = isCanDel;
            }

            public String getIsCanDel() {
                return isCanDel;
            }

            public void setPersonCharge(String personCharge) {
                this.personCharge = personCharge;
            }

            public String getPersonCharge() {
                return personCharge;
            }

            public void setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateUser() {
                return createUser;
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

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateUser() {
                return updateUser;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("title", getTitle())
                    .append("parentId", getParentId())
                    .append("remarks", getRemarks())
                    .append("isCanDel", getIsCanDel())
                    .append("personCharge", getPersonCharge())
                    .append("createTime", getCreateTime())
                    .append("createUserId", getCreateUserId())
                    .append("createUser", getCreateUser())
                    .append("updateTime", getUpdateTime())
                    .append("updateUserId", getUpdateUserId())
                    .append("updateUser", getUpdateUser())
                .toString();
    }


}
