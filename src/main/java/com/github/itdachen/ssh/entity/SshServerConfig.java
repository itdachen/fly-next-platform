package com.github.itdachen.ssh.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * SSH 连接
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
@Table(name = "ta_fly_ssh_server_config")
public class SshServerConfig implements Serializable{
private static final long serialVersionUID=1L;

    /** 主键唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 连接名称 */
    @Column(name = "ssh_title")
    private String sshTitle;

    /** 连接IP */
    @Column(name = "host_ip")
    private String hostIp;

    /** 连接端口 */
    @Column(name = "host_port")
    private String hostPort;

    /** 登录账号 */
    @Column(name = "host_username")
    private String hostUsername;

    /** 登录密码(加密后) */
    @Column(name = "host_password")
    private String hostPassword;

    /** 有效标志: Y-是;N-否 */
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

            public void setSshTitle(String sshTitle) {
                this.sshTitle = sshTitle;
            }

            public String getSshTitle() {
                return sshTitle;
            }

            public void setHostIp(String hostIp) {
                this.hostIp = hostIp;
            }

            public String getHostIp() {
                return hostIp;
            }

            public void setHostPort(String hostPort) {
                this.hostPort = hostPort;
            }

            public String getHostPort() {
                return hostPort;
            }

            public void setHostUsername(String hostUsername) {
                this.hostUsername = hostUsername;
            }

            public String getHostUsername() {
                return hostUsername;
            }

            public void setHostPassword(String hostPassword) {
                this.hostPassword = hostPassword;
            }

            public String getHostPassword() {
                return hostPassword;
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
                    .append("sshTitle", getSshTitle())
                    .append("hostIp", getHostIp())
                    .append("hostPort", getHostPort())
                    .append("hostUsername", getHostUsername())
                    .append("hostPassword", getHostPassword())
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
