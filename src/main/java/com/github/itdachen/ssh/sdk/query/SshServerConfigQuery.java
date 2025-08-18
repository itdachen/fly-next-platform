package com.github.itdachen.ssh.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * SSH 连接 查询参数
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
public class SshServerConfigQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 连接名称 */
            private String sshTitle;

            /** 连接IP */
            private String hostIp;

            /** 有效标志: Y-是;N-否 */
            private String validFlag;



    public SshServerConfigQuery() {
    }

    public SshServerConfigQuery(int page, int limit, String sshTitle, String hostIp, String validFlag) {
        super(page, limit);
            this.sshTitle = sshTitle;
            this.hostIp = hostIp;
            this.validFlag = validFlag;
    }

    public static SshServerConfigQueryBuilder builder() {
        return new SshServerConfigQueryBuilder();
    }

    public static class SshServerConfigQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
            private String sshTitle;
            private String hostIp;
            private String validFlag;

        public SshServerConfigQueryBuilder() {
        }

        public SshServerConfigQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public SshServerConfigQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

            /* 连接名称 */
            public SshServerConfigQueryBuilder sshTitle(String sshTitle) {
                this.sshTitle = sshTitle;
                return this;
            }
            /* 连接IP */
            public SshServerConfigQueryBuilder hostIp(String hostIp) {
                this.hostIp = hostIp;
                return this;
            }
            /* 有效标志: Y-是;N-否 */
            public SshServerConfigQueryBuilder validFlag(String validFlag) {
                this.validFlag = validFlag;
                return this;
            }

        public SshServerConfigQuery build() {
            return new SshServerConfigQuery(page, limit, sshTitle, hostIp, validFlag);
        }

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

        public void setValidFlag(String validFlag) {
            this.validFlag = validFlag;
        }

        public String getValidFlag() {
            return validFlag;
        }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
                    .append("sshTitle", getSshTitle())
                    .append("hostIp", getHostIp())
                    .append("validFlag", getValidFlag())
                .toString();
    }

}
