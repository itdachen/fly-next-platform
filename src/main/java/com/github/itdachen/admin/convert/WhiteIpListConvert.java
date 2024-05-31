package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.WhiteIpList;
import com.github.itdachen.admin.sdk.dto.WhiteIpListDTO;
import com.github.itdachen.admin.sdk.vo.WhiteIpListVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 菜单白名单 类型转换
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
public class WhiteIpListConvert implements IBizConvertMapper< WhiteIpList, WhiteIpListDTO, WhiteIpListVO > {

    @Override
    public WhiteIpList toJavaObject(WhiteIpListDTO whiteIpListDTO) {
        if (null == whiteIpListDTO){
            return null;
        }
        WhiteIpList whiteIpList = new WhiteIpList();
                whiteIpList.setId(whiteIpListDTO.getId());
                whiteIpList.setAppId(whiteIpListDTO.getAppId());
                whiteIpList.setIpType(whiteIpListDTO.getIpType());
                whiteIpList.setMenuId(whiteIpListDTO.getMenuId());
                whiteIpList.setMenuTitle(whiteIpListDTO.getMenuTitle());
                whiteIpList.setElementId(whiteIpListDTO.getElementId());
                whiteIpList.setElementTitle(whiteIpListDTO.getElementTitle());
                whiteIpList.setTypeId(whiteIpListDTO.getTypeId());
                whiteIpList.setTypeTitle(whiteIpListDTO.getTypeTitle());
                whiteIpList.setHostIp(whiteIpListDTO.getHostIp());
                whiteIpList.setHostIpValue(whiteIpListDTO.getHostIpValue());
                whiteIpList.setStartIp(whiteIpListDTO.getStartIp());
                whiteIpList.setStartIpValue(whiteIpListDTO.getStartIpValue());
                whiteIpList.setEndIp(whiteIpListDTO.getEndIp());
                whiteIpList.setEndIpValue(whiteIpListDTO.getEndIpValue());
                whiteIpList.setValidFlag(whiteIpListDTO.getValidFlag());
                whiteIpList.setRemarks(whiteIpListDTO.getRemarks());
        return whiteIpList;
    }


    @Override
    public WhiteIpListVO toJavaObjectVO(WhiteIpList whiteIpList) {
        if (null == whiteIpList){
            return null;
        }
            WhiteIpListVO whiteIpListVO = new WhiteIpListVO();
                    whiteIpListVO.setId(whiteIpList.getId());
                    whiteIpListVO.setAppId(whiteIpList.getAppId());
                    whiteIpListVO.setIpType(whiteIpList.getIpType());
                    whiteIpListVO.setMenuId(whiteIpList.getMenuId());
                    whiteIpListVO.setMenuTitle(whiteIpList.getMenuTitle());
                    whiteIpListVO.setElementId(whiteIpList.getElementId());
                    whiteIpListVO.setElementTitle(whiteIpList.getElementTitle());
                    whiteIpListVO.setTypeId(whiteIpList.getTypeId());
                    whiteIpListVO.setTypeTitle(whiteIpList.getTypeTitle());
                    whiteIpListVO.setHostIp(whiteIpList.getHostIp());
                    whiteIpListVO.setHostIpValue(whiteIpList.getHostIpValue());
                    whiteIpListVO.setStartIp(whiteIpList.getStartIp());
                    whiteIpListVO.setStartIpValue(whiteIpList.getStartIpValue());
                    whiteIpListVO.setEndIp(whiteIpList.getEndIp());
                    whiteIpListVO.setEndIpValue(whiteIpList.getEndIpValue());
                    whiteIpListVO.setValidFlag(whiteIpList.getValidFlag());
                    whiteIpListVO.setRemarks(whiteIpList.getRemarks());
        return whiteIpListVO;
    }

    public WhiteIpList toJavaObject(WhiteIpListVO whiteIpListVO) {
        if (null == whiteIpListVO){
            return null;
        }
        WhiteIpList whiteIpList = new WhiteIpList();
                whiteIpList.setId(whiteIpListVO.getId());
                whiteIpList.setAppId(whiteIpListVO.getAppId());
                whiteIpList.setIpType(whiteIpListVO.getIpType());
                whiteIpList.setMenuId(whiteIpListVO.getMenuId());
                whiteIpList.setMenuTitle(whiteIpListVO.getMenuTitle());
                whiteIpList.setElementId(whiteIpListVO.getElementId());
                whiteIpList.setElementTitle(whiteIpListVO.getElementTitle());
                whiteIpList.setTypeId(whiteIpListVO.getTypeId());
                whiteIpList.setTypeTitle(whiteIpListVO.getTypeTitle());
                whiteIpList.setHostIp(whiteIpListVO.getHostIp());
                whiteIpList.setHostIpValue(whiteIpListVO.getHostIpValue());
                whiteIpList.setStartIp(whiteIpListVO.getStartIp());
                whiteIpList.setStartIpValue(whiteIpListVO.getStartIpValue());
                whiteIpList.setEndIp(whiteIpListVO.getEndIp());
                whiteIpList.setEndIpValue(whiteIpListVO.getEndIpValue());
                whiteIpList.setValidFlag(whiteIpListVO.getValidFlag());
                whiteIpList.setRemarks(whiteIpListVO.getRemarks());
        return whiteIpList;
    }

    public WhiteIpListVO toJavaObjectVO(WhiteIpListDTO whiteIpListDTO) {
        if (null == whiteIpListDTO){
            return null;
        }
            WhiteIpListVO whiteIpListVO = new WhiteIpListVO();
                    whiteIpListVO.setId(whiteIpListDTO.getId());
                    whiteIpListVO.setAppId(whiteIpListDTO.getAppId());
                    whiteIpListVO.setIpType(whiteIpListDTO.getIpType());
                    whiteIpListVO.setMenuId(whiteIpListDTO.getMenuId());
                    whiteIpListVO.setMenuTitle(whiteIpListDTO.getMenuTitle());
                    whiteIpListVO.setElementId(whiteIpListDTO.getElementId());
                    whiteIpListVO.setElementTitle(whiteIpListDTO.getElementTitle());
                    whiteIpListVO.setTypeId(whiteIpListDTO.getTypeId());
                    whiteIpListVO.setTypeTitle(whiteIpListDTO.getTypeTitle());
                    whiteIpListVO.setHostIp(whiteIpListDTO.getHostIp());
                    whiteIpListVO.setHostIpValue(whiteIpListDTO.getHostIpValue());
                    whiteIpListVO.setStartIp(whiteIpListDTO.getStartIp());
                    whiteIpListVO.setStartIpValue(whiteIpListDTO.getStartIpValue());
                    whiteIpListVO.setEndIp(whiteIpListDTO.getEndIp());
                    whiteIpListVO.setEndIpValue(whiteIpListDTO.getEndIpValue());
                    whiteIpListVO.setValidFlag(whiteIpListDTO.getValidFlag());
                    whiteIpListVO.setRemarks(whiteIpListDTO.getRemarks());
        return whiteIpListVO;
    }


}