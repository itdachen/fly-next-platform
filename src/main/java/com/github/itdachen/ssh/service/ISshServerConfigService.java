package com.github.itdachen.ssh.service;

import com.github.itdachen.ssh.sdk.dto.SshServerConfigDTO;
import com.github.itdachen.ssh.sdk.query.SshServerConfigQuery;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * SSH 连接 业务接口
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
public interface ISshServerConfigService extends IBizService< SshServerConfigDTO, SshServerConfigVO, SshServerConfigQuery, String > {

}
