package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.PlatformInfo;
import com.github.itdachen.admin.sdk.dto.PlatformInfoDTO;
import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 平台信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
public class PlatformInfoConvert implements IBizConvertMapper<PlatformInfo, PlatformInfoDTO, PlatformInfoVO> {

    @Override
    public PlatformInfo toJavaObject(PlatformInfoDTO platformInfoDTO) {
        if (null == platformInfoDTO){
            return null;
        }
        PlatformInfo platformInfo = new PlatformInfo();
                platformInfo.setId(platformInfoDTO.getId());
                platformInfo.setTitle(platformInfoDTO.getTitle());
                platformInfo.setIconIco(platformInfoDTO.getIconIco());
                platformInfo.setFuncCode(platformInfoDTO.getFuncCode());
                platformInfo.setFuncTitle(platformInfoDTO.getFuncTitle());
                platformInfo.setValidDel(platformInfoDTO.getValidDel());
                platformInfo.setValidFlag(platformInfoDTO.getValidFlag());
                platformInfo.setRemarks(platformInfoDTO.getRemarks());
        return platformInfo;
    }


    @Override
    public PlatformInfoVO toJavaObjectVO(PlatformInfo platformInfo) {
        if (null == platformInfo){
            return null;
        }
            PlatformInfoVO platformInfoVO = new PlatformInfoVO();
                    platformInfoVO.setId(platformInfo.getId());
                    platformInfoVO.setTitle(platformInfo.getTitle());
                    platformInfoVO.setIconIco(platformInfo.getIconIco());
                    platformInfoVO.setFuncCode(platformInfo.getFuncCode());
                    platformInfoVO.setFuncTitle(platformInfo.getFuncTitle());
                    platformInfoVO.setValidDel(platformInfo.getValidDel());
                    platformInfoVO.setValidFlag(platformInfo.getValidFlag());
                    platformInfoVO.setRemarks(platformInfo.getRemarks());
        return platformInfoVO;
    }

    public PlatformInfo toJavaObject(PlatformInfoVO platformInfoVO) {
        if (null == platformInfoVO){
            return null;
        }
        PlatformInfo platformInfo = new PlatformInfo();
                platformInfo.setId(platformInfoVO.getId());
                platformInfo.setTitle(platformInfoVO.getTitle());
                platformInfo.setIconIco(platformInfoVO.getIconIco());
                platformInfo.setFuncCode(platformInfoVO.getFuncCode());
                platformInfo.setFuncTitle(platformInfoVO.getFuncTitle());
                platformInfo.setValidDel(platformInfoVO.getValidDel());
                platformInfo.setValidFlag(platformInfoVO.getValidFlag());
                platformInfo.setRemarks(platformInfoVO.getRemarks());
        return platformInfo;
    }

    public PlatformInfoVO toJavaObjectVO(PlatformInfoDTO platformInfoDTO) {
        if (null == platformInfoDTO){
            return null;
        }
            PlatformInfoVO platformInfoVO = new PlatformInfoVO();
                    platformInfoVO.setId(platformInfoDTO.getId());
                    platformInfoVO.setTitle(platformInfoDTO.getTitle());
                    platformInfoVO.setIconIco(platformInfoDTO.getIconIco());
                    platformInfoVO.setFuncCode(platformInfoDTO.getFuncCode());
                    platformInfoVO.setFuncTitle(platformInfoDTO.getFuncTitle());
                    platformInfoVO.setValidDel(platformInfoDTO.getValidDel());
                    platformInfoVO.setValidFlag(platformInfoDTO.getValidFlag());
                    platformInfoVO.setRemarks(platformInfoDTO.getRemarks());
        return platformInfoVO;
    }


}