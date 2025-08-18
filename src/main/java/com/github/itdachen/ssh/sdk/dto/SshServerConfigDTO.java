package com.github.itdachen.ssh.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * SSH 连接 DTO
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
public class SshServerConfigDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键唯一标识 */
        private String id;

        /** 连接名称 */
 @NotBlank(message = "连接名称不能为空")
        private String sshTitle;

        /** 连接IP */
 @NotBlank(message = "连接IP不能为空")
        private String hostIp;

        /** 连接端口 */
 @NotBlank(message = "连接端口不能为空")
        private String hostPort;

        /** 登录账号 */
 @NotBlank(message = "登录账号不能为空")
        private String hostUsername;

        /** 登录密码(加密后) */
 @NotBlank(message = "登录密码(加密后)不能为空")
        private String hostPassword;

        /** 有效标志: Y-是;N-否 */
 @NotBlank(message = "有效标志: Y-是;N-否不能为空")
        private String validFlag;

        /** 备注 */
        private String remarks;





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
                .toString();
    }

}
