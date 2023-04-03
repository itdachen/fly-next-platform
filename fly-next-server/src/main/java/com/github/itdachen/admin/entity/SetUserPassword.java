package com.github.itdachen.admin.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description: 修改密码
 * Created by 王大宸 on 2022-09-07 16:50
 * Created with IntelliJ IDEA.
 */
public class SetUserPassword implements Serializable {
    private static final long serialVersionUID = 2162253126883872658L;

    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    private String password;

    @NotBlank(message = "确认密码不能为空")
    private String repassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }


    @Override
    public String toString() {
        return "SetUserPassword{" +
                "oldPassword='" + oldPassword + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                '}';
    }

}
