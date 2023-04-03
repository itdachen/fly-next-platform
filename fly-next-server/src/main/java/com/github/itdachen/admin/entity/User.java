package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 用户信息
 *
 * @author 王大宸
 * @date 2022-08-25 22:21:19
 */
@Table(name = "sys_user" )
public class User implements Serializable{
    private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id" )
    private String id;

    /** 登录账户 */
    @Column(name = "username" )
    private String username;

    /** 登录密码 */
    @Column(name = "password" )
    private String password;

    /** 姓名 */
    @Column(name = "name" )
    private String name;

    /** 头像 */
    @Column(name = "avatar" )
    private String avatar;

    /** 出生日期 */
    @Column(name = "birthday" )
    private String birthday;

    /** 地址 */
    @Column(name = "address" )
    private String address;

    /** 电话号码 */
    @Column(name = "telephone" )
    private String telephone;

    /** 电子邮箱 */
    @Column(name = "email" )
    private String email;

    /** 部门ID */
    @Column(name = "depart_id" )
    private String departId;

    /** 性别: 数据字典-sys_sex */
    @Column(name = "sex" )
    private String sex;

    /** 类型 */
    @Column(name = "type" )
    private String type;

    /** 状态: 数据字典: user_status 0-冻结;1-正常 */
    @Column(name = "status" )
    private String status;

    /** 描述 */
    @Column(name = "remarks" )
    private String remarks;

    /** 租户id/机构id */
    @Column(name = "tenant_id" )
    private String tenantId;

    /** 创建时间 */
    @Column(name = "create_time" )
    private LocalDateTime createTime;

    /** 创建人ID */
    @Column(name = "create_user_id" )
    private String createUserId;

    /** 创建人 */
    @Column(name = "create_user" )
    private String createUser;

    /** 更新时间 */
    @Column(name = "update_time" )
    private LocalDateTime updateTime;

    /** 更新人ID */
    @Column(name = "update_user_id" )
    private String updateUserId;

    /** 更新人 */
    @Column(name = "update_user" )
    private String updateUser;

    /** 客户端ID */
    @Column(name = "client_id" )
    private String clientId;

    /** 是否删除 */
    @Column(name = "is_del" )
    private String isDel;

    /** 属性1 */
    @Column(name = "attr1" )
    private String attr1;

    /** 属性2 */
    @Column(name = "attr2" )
    private String attr2;

    /** 属性3 */
    @Column(name = "attr3" )
    private String attr3;

    /** 属性4 */
    @Column(name = "attr4" )
    private String attr4;

    /** 属性5 */
    @Column(name = "attr5" )
    private String attr5;

    /** 属性6 */
    @Column(name = "attr6" )
    private String attr6;

    /** 属性7 */
    @Column(name = "attr7" )
    private String attr7;

    /** 属性8 */
    @Column(name = "attr8" )
    private String attr8;

    /** 属性9 */
    @Column(name = "attr9" )
    private String attr9;

    /** 属性10 */
    @Column(name = "attr10" )
    private String attr10;


    public void setId(String id) {
            this.id = id;
    }

    public String getId() {
            return id;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getUsername() {
            return username;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getPassword() {
            return password;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getName() {
            return name;
    }

    public void setAvatar(String avatar) {
            this.avatar = avatar;
    }

    public String getAvatar() {
            return avatar;
    }

    public void setBirthday(String birthday) {
            this.birthday = birthday;
    }

    public String getBirthday() {
            return birthday;
    }

    public void setAddress(String address) {
            this.address = address;
    }

    public String getAddress() {
            return address;
    }

    public void setTelephone(String telephone) {
            this.telephone = telephone;
    }

    public String getTelephone() {
            return telephone;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getEmail() {
            return email;
    }

    public void setDepartId(String departId) {
            this.departId = departId;
    }

    public String getDepartId() {
            return departId;
    }

    public void setSex(String sex) {
            this.sex = sex;
    }

    public String getSex() {
            return sex;
    }

    public void setType(String type) {
            this.type = type;
    }

    public String getType() {
            return type;
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

    public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
    }

    public String getTenantId() {
            return tenantId;
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

    public void setClientId(String clientId) {
            this.clientId = clientId;
    }

    public String getClientId() {
            return clientId;
    }

    public void setIsDel(String isDel) {
            this.isDel = isDel;
    }

    public String getIsDel() {
            return isDel;
    }

    public void setAttr1(String attr1) {
            this.attr1 = attr1;
    }

    public String getAttr1() {
            return attr1;
    }

    public void setAttr2(String attr2) {
            this.attr2 = attr2;
    }

    public String getAttr2() {
            return attr2;
    }

    public void setAttr3(String attr3) {
            this.attr3 = attr3;
    }

    public String getAttr3() {
            return attr3;
    }

    public void setAttr4(String attr4) {
            this.attr4 = attr4;
    }

    public String getAttr4() {
            return attr4;
    }

    public void setAttr5(String attr5) {
            this.attr5 = attr5;
    }

    public String getAttr5() {
            return attr5;
    }

    public void setAttr6(String attr6) {
            this.attr6 = attr6;
    }

    public String getAttr6() {
            return attr6;
    }

    public void setAttr7(String attr7) {
            this.attr7 = attr7;
    }

    public String getAttr7() {
            return attr7;
    }

    public void setAttr8(String attr8) {
            this.attr8 = attr8;
    }

    public String getAttr8() {
            return attr8;
    }

    public void setAttr9(String attr9) {
            this.attr9 = attr9;
    }

    public String getAttr9() {
            return attr9;
    }

    public void setAttr10(String attr10) {
            this.attr10 = attr10;
    }

    public String getAttr10() {
            return attr10;
    }


    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("name", getName())
            .append("avatar", getAvatar())
            .append("birthday", getBirthday())
            .append("address", getAddress())
            .append("telephone", getTelephone())
            .append("email", getEmail())
            .append("departId", getDepartId())
            .append("sex", getSex())
            .append("type", getType())
            .append("status", getStatus())
            .append("remarks", getRemarks())
            .append("tenantId", getTenantId())
            .append("createTime", getCreateTime())
            .append("createUserId", getCreateUserId())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("updateUserId", getUpdateUserId())
            .append("updateUser", getUpdateUser())
            .append("clientId", getClientId())
            .append("isDel", getIsDel())
            .append("attr1", getAttr1())
            .append("attr2", getAttr2())
            .append("attr3", getAttr3())
            .append("attr4", getAttr4())
            .append("attr5", getAttr5())
            .append("attr6", getAttr6())
            .append("attr7", getAttr7())
            .append("attr8", getAttr8())
            .append("attr9", getAttr9())
            .append("attr10", getAttr10())
        .toString();
    }


}
