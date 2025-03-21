package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 用户信息 VO
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 用户ID */
        private String id;

        /** 租户ID */
        private String tenantId;

        /** 租户名称 */
        private String tenantTitle;

        /** 昵称 */
        private String nickName;

        /** 身份证号码 */
        private String idCard;

        /** 性别 */
        private String sex;

        /** 电话号码 */
        private String telephone;

        /** 头像 */
        private String avatar;

        /** 电子邮箱 */
        private String eMailBox;

        /** 用户类型 */
        private String userType;

        /** 有效标志 */
        private String validFlag;

        /** 备注 */
        private String remarks;



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
                .toString();
    }

}
