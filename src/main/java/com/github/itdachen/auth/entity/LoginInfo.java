package com.github.itdachen.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 登录信息表
 *
 * @author 王大宸
 * @date 2024-05-08 23:14:27
 */
@Table(name = "ta_fly_login_info")
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID(与 ta_fly_user_info 表保持一致)
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 登录账号
     */
    @Column(name = "username")
    private String username;

    /**
     * 登录密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 有效标志: Y-有效;N-无效(与 ta_fly_user_info 表保持一致)
     */
    @Column(name = "valid_flag")
    private String validFlag;

    /**
     * 过期时间(密码过期时间, 有些系统需要定期更新账号的密码)
     */
    @Column(name = "exp_time")
    private LocalDateTime expTime;

    /**
     * 上次更新密码时间
     */
    @Column(name = "last_time")
    private LocalDateTime lastTime;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;


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

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setExpTime(LocalDateTime expTime) {
        this.expTime = expTime;
    }

    public LocalDateTime getExpTime() {
        return expTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("validFlag", getValidFlag())
                .append("expTime", getExpTime())
                .append("lastTime", getLastTime())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }


}
