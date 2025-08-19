package com.github.itdachen.ssh.webssh;

import java.io.Serializable;

/**
 * SSHServerInfo
 *
 * @author 王大宸
 * @date 2025/8/19 0:04
 */
public class SSHServerInfo implements Serializable {
    private static final long serialVersionUID = 7427038534437653996L;

    /**
     * 连接IP
     */
    private String hostIp;

    /**
     * 连接端口
     */
    private String hostPort = "22";

    /**
     * 登录账号
     */
    private String hostUsername;

    /**
     * 登录密码(加密后)
     */
    private String hostPassword;

    public SSHServerInfo() {
    }


    public SSHServerInfo(String hostIp, String hostPort, String hostUsername, String hostPassword) {
        this.hostIp = hostIp;
        this.hostPort = hostPort;
        this.hostUsername = hostUsername;
        this.hostPassword = hostPassword;
    }


    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getHostUsername() {
        return hostUsername;
    }

    public void setHostUsername(String hostUsername) {
        this.hostUsername = hostUsername;
    }

    public String getHostPassword() {
        return hostPassword;
    }

    public void setHostPassword(String hostPassword) {
        this.hostPassword = hostPassword;
    }
}
