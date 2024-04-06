package com.github.itdachen.admin_v1.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 字典类型表
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Table(name = "sys_dict_type")
public class DictType implements Serializable{
private static final long serialVersionUID=1L;

    /** 字典主键 */
    @Id
    @Column(name = "id")
    private String id;

    /** 字典名称 */
    @Column(name = "dict_name")
    private String dictName;

    /** 字典类型 */
    @Column(name = "dict_type")
    private String dictType;

    /** 状态,数据字典: dict_data_status */
    @Column(name = "status")
    private String status;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建者 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建者ID */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 更新者 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新者ID */
    @Column(name = "update_user_id")
    private String updateUserId;


public DictType(){}


public DictType(    String id,     String dictName,     String dictType,     String status,     String remarks,     String createUser,     String createUserId,     LocalDateTime createTime,     String updateUser,     LocalDateTime updateTime,     String updateUserId){
            this.id = id;
            this.dictName = dictName;
            this.dictType = dictType;
            this.status = status;
            this.remarks = remarks;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.createTime = createTime;
            this.updateUser = updateUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
}

public static DictTypeBuilder builder(){
        return new DictTypeBuilder();
        }

public static class DictTypeBuilder {
        private String id;
        private String dictName;
        private String dictType;
        private String status;
        private String remarks;
        private String createUser;
        private String createUserId;
        private LocalDateTime createTime;
        private String updateUser;
        private LocalDateTime updateTime;
        private String updateUserId;

    public DictTypeBuilder() {
    }

        /* 字典主键 */
        public DictTypeBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 字典名称 */
        public DictTypeBuilder dictName(String dictName) {
            this.dictName = dictName;
            return this;
        }
        /* 字典类型 */
        public DictTypeBuilder dictType(String dictType) {
            this.dictType = dictType;
            return this;
        }
        /* 状态,数据字典: dict_data_status */
        public DictTypeBuilder status(String status) {
            this.status = status;
            return this;
        }
        /* 备注 */
        public DictTypeBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 创建者 */
        public DictTypeBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建者ID */
        public DictTypeBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建时间 */
        public DictTypeBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 更新者 */
        public DictTypeBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新时间 */
        public DictTypeBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新者ID */
        public DictTypeBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public DictType build() {
        return new DictType(            id, 
            dictName, 
            dictType, 
            status, 
            remarks, 
            createUser, 
            createUserId, 
            createTime, 
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

            public void setDictName(String dictName) {
                this.dictName = dictName;
            }

            public String getDictName() {
                return dictName;
            }

            public void setDictType(String dictType) {
                this.dictType = dictType;
            }

            public String getDictType() {
                return dictType;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatus() {
                return status;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
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

            public void setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
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
                    .append("dictName", getDictName())
                    .append("dictType", getDictType())
                    .append("status", getStatus())
                    .append("remarks", getRemarks())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("createTime", getCreateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateTime", getUpdateTime())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
