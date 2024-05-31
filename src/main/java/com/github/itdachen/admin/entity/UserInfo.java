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
 * @date 2024-04-27 20:42:58
 */
@Table(name = "ta_fly_user_info")
public class UserInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 用户ID */
    @Id
    @Column(name = "id")
    private String id;

    /** 租户ID */
    @Column(name = "tenant_id")
    private String tenantId;

    /** 租户名称 */
    @Column(name = "tenant_title")
    private String tenantTitle;

    /** 昵称 */
    @Column(name = "nick_name")
    private String nickName;

    /** 身份证号码 */
    @Column(name = "id_card")
    private String idCard;

    /** 性别 */
    @Column(name = "sex")
    private String sex;

    /** 电话号码 */
    @Column(name = "telephone")
    private String telephone;

    /** 头像 */
    @Column(name = "avatar")
    private String avatar;

    /** 电子邮箱 */
    @Column(name = "e_mail_box")
    private String eMailBox;

    /** 用户类型 */
    @Column(name = "user_type")
    private String userType;

    /** 有效标志 */
    @Column(name = "valid_flag")
    private String validFlag;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新人id */
    @Column(name = "update_user_id")
    private String updateUserId;





            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setTenantId(String tenantId) {
                this.tenantId = tenantId;
            }

            public String getTenantId() {
                return tenantId;
            }

            public void setTenantTitle(String tenantTitle) {
                this.tenantTitle = tenantTitle;
            }

            public String getTenantTitle() {
                return tenantTitle;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getNickName() {
                return nickName;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSex() {
                return sex;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getAvatar() {
                return avatar;
            }

            public void seteMailBox(String eMailBox) {
                this.eMailBox = eMailBox;
            }

            public String geteMailBox() {
                return eMailBox;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getUserType() {
                return userType;
            }

            public void setValidFlag(String validFlag) {
                this.validFlag = validFlag;
            }

            public String getValidFlag() {
                return validFlag;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
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

            public void setUpdateTime(LocalDateTime updateTime) {
                this.updateTime = updateTime;
            }

            public LocalDateTime getUpdateTime() {
                return updateTime;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateUser() {
                return updateUser;
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
                    .append("tenantId", getTenantId())
                    .append("tenantTitle", getTenantTitle())
                    .append("nickName", getNickName())
                    .append("idCard", getIdCard())
                    .append("sex", getSex())
                    .append("telephone", getTelephone())
                    .append("avatar", getAvatar())
                    .append("eMailBox", geteMailBox())
                    .append("userType", getUserType())
                    .append("validFlag", getValidFlag())
                    .append("remarks", getRemarks())
                    .append("createTime", getCreateTime())
                    .append("createUser", getCreateUser())
                    .append("createUserId", getCreateUserId())
                    .append("updateTime", getUpdateTime())
                    .append("updateUser", getUpdateUser())
                    .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
