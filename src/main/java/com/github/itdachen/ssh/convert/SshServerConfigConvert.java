package com.github.itdachen.ssh.convert;

import com.github.itdachen.ssh.entity.SshServerConfig;
import com.github.itdachen.ssh.sdk.dto.SshServerConfigDTO;
import com.github.itdachen.ssh.sdk.vo.SshServerConfigVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * SSH 连接 类型转换
 *
 * @author 王大宸
 * @date 2025-08-18 22:58:10
 */
public class SshServerConfigConvert implements IBizConvertMapper< SshServerConfig, SshServerConfigDTO, SshServerConfigVO > {

    @Override
    public SshServerConfig toJavaObject(SshServerConfigDTO sshServerConfigDTO) {
        if (null == sshServerConfigDTO){
            return null;
        }
        SshServerConfig sshServerConfig = new SshServerConfig();
                sshServerConfig.setId(sshServerConfigDTO.getId());
                sshServerConfig.setSshTitle(sshServerConfigDTO.getSshTitle());
                sshServerConfig.setHostIp(sshServerConfigDTO.getHostIp());
                sshServerConfig.setHostPort(sshServerConfigDTO.getHostPort());
                sshServerConfig.setHostUsername(sshServerConfigDTO.getHostUsername());
                sshServerConfig.setHostPassword(sshServerConfigDTO.getHostPassword());
                sshServerConfig.setValidFlag(sshServerConfigDTO.getValidFlag());
                sshServerConfig.setRemarks(sshServerConfigDTO.getRemarks());
        return sshServerConfig;
    }


    @Override
    public SshServerConfigVO toJavaObjectVO(SshServerConfig sshServerConfig) {
        if (null == sshServerConfig){
            return null;
        }
            SshServerConfigVO sshServerConfigVO = new SshServerConfigVO();
                    sshServerConfigVO.setId(sshServerConfig.getId());
                    sshServerConfigVO.setSshTitle(sshServerConfig.getSshTitle());
                    sshServerConfigVO.setHostIp(sshServerConfig.getHostIp());
                    sshServerConfigVO.setHostPort(sshServerConfig.getHostPort());
                    sshServerConfigVO.setHostUsername(sshServerConfig.getHostUsername());
                    sshServerConfigVO.setHostPassword(sshServerConfig.getHostPassword());
                    sshServerConfigVO.setValidFlag(sshServerConfig.getValidFlag());
                    sshServerConfigVO.setRemarks(sshServerConfig.getRemarks());
        return sshServerConfigVO;
    }

    public SshServerConfig toJavaObject(SshServerConfigVO sshServerConfigVO) {
        if (null == sshServerConfigVO){
            return null;
        }
        SshServerConfig sshServerConfig = new SshServerConfig();
                sshServerConfig.setId(sshServerConfigVO.getId());
                sshServerConfig.setSshTitle(sshServerConfigVO.getSshTitle());
                sshServerConfig.setHostIp(sshServerConfigVO.getHostIp());
                sshServerConfig.setHostPort(sshServerConfigVO.getHostPort());
                sshServerConfig.setHostUsername(sshServerConfigVO.getHostUsername());
                sshServerConfig.setHostPassword(sshServerConfigVO.getHostPassword());
                sshServerConfig.setValidFlag(sshServerConfigVO.getValidFlag());
                sshServerConfig.setRemarks(sshServerConfigVO.getRemarks());
        return sshServerConfig;
    }

    public SshServerConfigVO toJavaObjectVO(SshServerConfigDTO sshServerConfigDTO) {
        if (null == sshServerConfigDTO){
            return null;
        }
            SshServerConfigVO sshServerConfigVO = new SshServerConfigVO();
                    sshServerConfigVO.setId(sshServerConfigDTO.getId());
                    sshServerConfigVO.setSshTitle(sshServerConfigDTO.getSshTitle());
                    sshServerConfigVO.setHostIp(sshServerConfigDTO.getHostIp());
                    sshServerConfigVO.setHostPort(sshServerConfigDTO.getHostPort());
                    sshServerConfigVO.setHostUsername(sshServerConfigDTO.getHostUsername());
                    sshServerConfigVO.setHostPassword(sshServerConfigDTO.getHostPassword());
                    sshServerConfigVO.setValidFlag(sshServerConfigDTO.getValidFlag());
                    sshServerConfigVO.setRemarks(sshServerConfigDTO.getRemarks());
        return sshServerConfigVO;
    }


}