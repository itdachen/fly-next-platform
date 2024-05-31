package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.TenantInfo;
import com.github.itdachen.admin.sdk.dto.TenantInfoDTO;
import com.github.itdachen.admin.sdk.vo.TenantInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 租户/公司信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
public class TenantInfoConvert implements IBizConvertMapper<TenantInfo, TenantInfoDTO, TenantInfoVO> {

    @Override
    public TenantInfo toJavaObject(TenantInfoDTO tenantInfoDTO) {
        if (null == tenantInfoDTO) {
            return null;
        }
        TenantInfo tenantInfo = new TenantInfo();
        tenantInfo.setId(tenantInfoDTO.getId());
        tenantInfo.setParentId(tenantInfoDTO.getParentId());
        tenantInfo.setParentTitle(tenantInfoDTO.getParentTitle());
        tenantInfo.setTypeId(tenantInfoDTO.getTypeId());
        tenantInfo.setTypeTitle(tenantInfoDTO.getTypeTitle());
        tenantInfo.setTitle(tenantInfoDTO.getTitle());
        tenantInfo.setTitleAs(tenantInfoDTO.getTitleAs());
        tenantInfo.setProvId(tenantInfoDTO.getProvId());
        tenantInfo.setProvTitle(tenantInfoDTO.getProvTitle());
        tenantInfo.setCityId(tenantInfoDTO.getCityId());
        tenantInfo.setCityTitle(tenantInfoDTO.getCityTitle());
        tenantInfo.setCountyId(tenantInfoDTO.getCountyId());
        tenantInfo.setCountyTitle(tenantInfoDTO.getCountyTitle());
        tenantInfo.setHomeIcon(tenantInfoDTO.getHomeIcon());
        tenantInfo.setHomeUri(tenantInfoDTO.getHomeUri());
        tenantInfo.setOwnerId(tenantInfoDTO.getOwnerId());
        tenantInfo.setOwnerNickName(tenantInfoDTO.getOwnerNickName());
        tenantInfo.setTelephone(tenantInfoDTO.getTelephone());
        tenantInfo.seteMailBox(tenantInfoDTO.geteMailBox());
        tenantInfo.setFacsimile(tenantInfoDTO.getFacsimile());
        tenantInfo.setFuncCode(tenantInfoDTO.getFuncCode());
        tenantInfo.setValidDel(tenantInfoDTO.getValidDel());
        tenantInfo.setValidFlag(tenantInfoDTO.getValidFlag());
        tenantInfo.setRemarks(tenantInfoDTO.getRemarks());
        return tenantInfo;
    }


    @Override
    public TenantInfoVO toJavaObjectVO(TenantInfo tenantInfo) {
        if (null == tenantInfo) {
            return null;
        }
        TenantInfoVO tenantInfoVO = new TenantInfoVO();
        tenantInfoVO.setId(tenantInfo.getId());
        tenantInfoVO.setParentId(tenantInfo.getParentId());
        tenantInfoVO.setParentTitle(tenantInfo.getParentTitle());
        tenantInfoVO.setTypeId(tenantInfo.getTypeId());
        tenantInfoVO.setTypeTitle(tenantInfo.getTypeTitle());
        tenantInfoVO.setTitle(tenantInfo.getTitle());
        tenantInfoVO.setTitleAs(tenantInfo.getTitleAs());
        tenantInfoVO.setProvId(tenantInfo.getProvId());
        tenantInfoVO.setProvTitle(tenantInfo.getProvTitle());
        tenantInfoVO.setCityId(tenantInfo.getCityId());
        tenantInfoVO.setCityTitle(tenantInfo.getCityTitle());
        tenantInfoVO.setCountyId(tenantInfo.getCountyId());
        tenantInfoVO.setCountyTitle(tenantInfo.getCountyTitle());
        tenantInfoVO.setHomeIcon(tenantInfo.getHomeIcon());
        tenantInfoVO.setHomeUri(tenantInfo.getHomeUri());
        tenantInfoVO.setOwnerId(tenantInfo.getOwnerId());
        tenantInfoVO.setOwnerNickName(tenantInfo.getOwnerNickName());
        tenantInfoVO.setTelephone(tenantInfo.getTelephone());
        tenantInfoVO.seteMailBox(tenantInfo.geteMailBox());
        tenantInfoVO.setFacsimile(tenantInfo.getFacsimile());
        tenantInfoVO.setFuncCode(tenantInfo.getFuncCode());
        tenantInfoVO.setValidDel(tenantInfo.getValidDel());
        tenantInfoVO.setValidFlag(tenantInfo.getValidFlag());
        tenantInfoVO.setRemarks(tenantInfo.getRemarks());
        return tenantInfoVO;
    }

    public TenantInfo toJavaObject(TenantInfoVO tenantInfoVO) {
        if (null == tenantInfoVO) {
            return null;
        }
        TenantInfo tenantInfo = new TenantInfo();
        tenantInfo.setId(tenantInfoVO.getId());
        tenantInfo.setParentId(tenantInfoVO.getParentId());
        tenantInfo.setParentTitle(tenantInfoVO.getParentTitle());
        tenantInfo.setTypeId(tenantInfoVO.getTypeId());
        tenantInfo.setTypeTitle(tenantInfoVO.getTypeTitle());
        tenantInfo.setTitle(tenantInfoVO.getTitle());
        tenantInfo.setTitleAs(tenantInfoVO.getTitleAs());
        tenantInfo.setProvId(tenantInfoVO.getProvId());
        tenantInfo.setProvTitle(tenantInfoVO.getProvTitle());
        tenantInfo.setCityId(tenantInfoVO.getCityId());
        tenantInfo.setCityTitle(tenantInfoVO.getCityTitle());
        tenantInfo.setCountyId(tenantInfoVO.getCountyId());
        tenantInfo.setCountyTitle(tenantInfoVO.getCountyTitle());
        tenantInfo.setHomeIcon(tenantInfoVO.getHomeIcon());
        tenantInfo.setHomeUri(tenantInfoVO.getHomeUri());
        tenantInfo.setOwnerId(tenantInfoVO.getOwnerId());
        tenantInfo.setOwnerNickName(tenantInfoVO.getOwnerNickName());
        tenantInfo.setTelephone(tenantInfoVO.getTelephone());
        tenantInfo.seteMailBox(tenantInfoVO.geteMailBox());
        tenantInfo.setFacsimile(tenantInfoVO.getFacsimile());
        tenantInfo.setFuncCode(tenantInfoVO.getFuncCode());
        tenantInfo.setValidDel(tenantInfoVO.getValidDel());
        tenantInfo.setValidFlag(tenantInfoVO.getValidFlag());
        tenantInfo.setRemarks(tenantInfoVO.getRemarks());
        return tenantInfo;
    }

    public TenantInfoVO toJavaObjectVO(TenantInfoDTO tenantInfoDTO) {
        if (null == tenantInfoDTO) {
            return null;
        }
        TenantInfoVO tenantInfoVO = new TenantInfoVO();
        tenantInfoVO.setId(tenantInfoDTO.getId());
        tenantInfoVO.setParentId(tenantInfoDTO.getParentId());
        tenantInfoVO.setParentTitle(tenantInfoDTO.getParentTitle());
        tenantInfoVO.setTypeId(tenantInfoDTO.getTypeId());
        tenantInfoVO.setTypeTitle(tenantInfoDTO.getTypeTitle());
        tenantInfoVO.setTitle(tenantInfoDTO.getTitle());
        tenantInfoVO.setTitleAs(tenantInfoDTO.getTitleAs());
        tenantInfoVO.setProvId(tenantInfoDTO.getProvId());
        tenantInfoVO.setProvTitle(tenantInfoDTO.getProvTitle());
        tenantInfoVO.setCityId(tenantInfoDTO.getCityId());
        tenantInfoVO.setCityTitle(tenantInfoDTO.getCityTitle());
        tenantInfoVO.setCountyId(tenantInfoDTO.getCountyId());
        tenantInfoVO.setCountyTitle(tenantInfoDTO.getCountyTitle());
        tenantInfoVO.setHomeIcon(tenantInfoDTO.getHomeIcon());
        tenantInfoVO.setHomeUri(tenantInfoDTO.getHomeUri());
        tenantInfoVO.setOwnerId(tenantInfoDTO.getOwnerId());
        tenantInfoVO.setOwnerNickName(tenantInfoDTO.getOwnerNickName());
        tenantInfoVO.setTelephone(tenantInfoDTO.getTelephone());
        tenantInfoVO.seteMailBox(tenantInfoDTO.geteMailBox());
        tenantInfoVO.setFacsimile(tenantInfoDTO.getFacsimile());
        tenantInfoVO.setFuncCode(tenantInfoDTO.getFuncCode());
        tenantInfoVO.setValidDel(tenantInfoDTO.getValidDel());
        tenantInfoVO.setValidFlag(tenantInfoDTO.getValidFlag());
        tenantInfoVO.setRemarks(tenantInfoDTO.getRemarks());
        return tenantInfoVO;
    }

}