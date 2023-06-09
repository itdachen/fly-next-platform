package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 用户信息 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 主键唯一标识 */
        private String id;


        /** 登录账户 */
        private String username;


        /** 登录密码 */
        private String password;


        /** 姓名 */
        private String name;


        /** 头像 */
        private String avatar;


        /** 出生日期 */
        private String birthday;


        /** 地址 */
        private String address;


        /** 电话号码 */
        private String telephone;


        /** 电子邮箱 */
        private String email;


        /** 部门ID */
        private String departId;


        /** 性别: 数据字典-sys_sex */
        private String sex;


        /** 类型 */
        private String type;


        /** 状态: 数据字典: user_status 0-冻结;1-正常 */
        private String status;


        /** 描述 */
        private String remarks;


        /** 租户id/机构id */
        private String tenantId;


        /** 客户端ID */
        private String clientId;


        /** 是否删除 */
        private String isDel;


        /** 属性1 */
        private String attr1;


        /** 属性2 */
        private String attr2;


        /** 属性3 */
        private String attr3;


        /** 属性4 */
        private String attr4;


        /** 属性5 */
        private String attr5;


        /** 属性6 */
        private String attr6;


        /** 属性7 */
        private String attr7;


        /** 属性8 */
        private String attr8;


        /** 属性9 */
        private String attr9;


        /** 属性10 */
        private String attr10;


    public UserInfoDto() {}

    public UserInfoDto(String id, String username, String password, String name, String avatar, String birthday, String address, String telephone, String email, String departId, String sex, String type, String status, String remarks, String tenantId, String clientId, String isDel, String attr1, String attr2, String attr3, String attr4, String attr5, String attr6, String attr7, String attr8, String attr9, String attr10) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.name = name;
            this.avatar = avatar;
            this.birthday = birthday;
            this.address = address;
            this.telephone = telephone;
            this.email = email;
            this.departId = departId;
            this.sex = sex;
            this.type = type;
            this.status = status;
            this.remarks = remarks;
            this.tenantId = tenantId;
            this.clientId = clientId;
            this.isDel = isDel;
            this.attr1 = attr1;
            this.attr2 = attr2;
            this.attr3 = attr3;
            this.attr4 = attr4;
            this.attr5 = attr5;
            this.attr6 = attr6;
            this.attr7 = attr7;
            this.attr8 = attr8;
            this.attr9 = attr9;
            this.attr10 = attr10;
    }

    public static UserInfoDtoBuilder builder() {
        return new UserInfoDtoBuilder();
    }

    public static class UserInfoDtoBuilder {
            private String id;
            private String username;
            private String password;
            private String name;
            private String avatar;
            private String birthday;
            private String address;
            private String telephone;
            private String email;
            private String departId;
            private String sex;
            private String type;
            private String status;
            private String remarks;
            private String tenantId;
            private String clientId;
            private String isDel;
            private String attr1;
            private String attr2;
            private String attr3;
            private String attr4;
            private String attr5;
            private String attr6;
            private String attr7;
            private String attr8;
            private String attr9;
            private String attr10;

        public UserInfoDtoBuilder() {}

            /* 主键唯一标识 */
            public UserInfoDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 登录账户 */
            public UserInfoDtoBuilder username(String username) {
                this.username = username;
                return this;
            }
            /* 登录密码 */
            public UserInfoDtoBuilder password(String password) {
                this.password = password;
                return this;
            }
            /* 姓名 */
            public UserInfoDtoBuilder name(String name) {
                this.name = name;
                return this;
            }
            /* 头像 */
            public UserInfoDtoBuilder avatar(String avatar) {
                this.avatar = avatar;
                return this;
            }
            /* 出生日期 */
            public UserInfoDtoBuilder birthday(String birthday) {
                this.birthday = birthday;
                return this;
            }
            /* 地址 */
            public UserInfoDtoBuilder address(String address) {
                this.address = address;
                return this;
            }
            /* 电话号码 */
            public UserInfoDtoBuilder telephone(String telephone) {
                this.telephone = telephone;
                return this;
            }
            /* 电子邮箱 */
            public UserInfoDtoBuilder email(String email) {
                this.email = email;
                return this;
            }
            /* 部门ID */
            public UserInfoDtoBuilder departId(String departId) {
                this.departId = departId;
                return this;
            }
            /* 性别: 数据字典-sys_sex */
            public UserInfoDtoBuilder sex(String sex) {
                this.sex = sex;
                return this;
            }
            /* 类型 */
            public UserInfoDtoBuilder type(String type) {
                this.type = type;
                return this;
            }
            /* 状态: 数据字典: user_status 0-冻结;1-正常 */
            public UserInfoDtoBuilder status(String status) {
                this.status = status;
                return this;
            }
            /* 描述 */
            public UserInfoDtoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }
            /* 租户id/机构id */
            public UserInfoDtoBuilder tenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }
            /* 客户端ID */
            public UserInfoDtoBuilder clientId(String clientId) {
                this.clientId = clientId;
                return this;
            }
            /* 是否删除 */
            public UserInfoDtoBuilder isDel(String isDel) {
                this.isDel = isDel;
                return this;
            }
            /* 属性1 */
            public UserInfoDtoBuilder attr1(String attr1) {
                this.attr1 = attr1;
                return this;
            }
            /* 属性2 */
            public UserInfoDtoBuilder attr2(String attr2) {
                this.attr2 = attr2;
                return this;
            }
            /* 属性3 */
            public UserInfoDtoBuilder attr3(String attr3) {
                this.attr3 = attr3;
                return this;
            }
            /* 属性4 */
            public UserInfoDtoBuilder attr4(String attr4) {
                this.attr4 = attr4;
                return this;
            }
            /* 属性5 */
            public UserInfoDtoBuilder attr5(String attr5) {
                this.attr5 = attr5;
                return this;
            }
            /* 属性6 */
            public UserInfoDtoBuilder attr6(String attr6) {
                this.attr6 = attr6;
                return this;
            }
            /* 属性7 */
            public UserInfoDtoBuilder attr7(String attr7) {
                this.attr7 = attr7;
                return this;
            }
            /* 属性8 */
            public UserInfoDtoBuilder attr8(String attr8) {
                this.attr8 = attr8;
                return this;
            }
            /* 属性9 */
            public UserInfoDtoBuilder attr9(String attr9) {
                this.attr9 = attr9;
                return this;
            }
            /* 属性10 */
            public UserInfoDtoBuilder attr10(String attr10) {
                this.attr10 = attr10;
                return this;
            }

        public UserInfoDto build() {
            return new UserInfoDto(id, username, password, name, avatar, birthday, address, telephone, email, departId, sex, type, status, remarks, tenantId, clientId, isDel, attr1, attr2, attr3, attr4, attr5, attr6, attr7, attr8, attr9, attr10);
        }

    }



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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
