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
 * @date 2022-08-24 22:17:02
 */
@Table(name = "sys_dept")
public class Dept implements Serializable {
    private static final long serialVersionUID = 8033683332585957671L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 部门名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 上级id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 是否可删除: 1-可删除;0-不可删
     */
    @Column(name = "is_can_del")
    private String isCanDel;

    /**
     * 负责人
     */
    @Column(name = "person_charge")
    private String personCharge;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人ID
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 更新人ID
     */
    @Column(name = "update_user_id")
    private String updateUserId;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
                .append("name", getName())
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
