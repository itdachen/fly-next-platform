package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.dto.ElementInfoDTO;
import com.github.itdachen.admin.sdk.vo.ElementInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 认证资源信息(按钮信息) 类型转换
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class ElementInfoConvert implements IBizConvertMapper< ElementInfo, ElementInfoDTO, ElementInfoVO > {

    @Override
    public ElementInfo toJavaObject(ElementInfoDTO elementInfoDTO) {
        if (null == elementInfoDTO){
            return null;
        }
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setId(elementInfoDTO.getId());
        elementInfo.setAppId(elementInfoDTO.getAppId());
        elementInfo.setMenuId(elementInfoDTO.getMenuId());
        elementInfo.setMenuTitle(elementInfoDTO.getMenuTitle());
        elementInfo.setTitle(elementInfoDTO.getTitle());
        elementInfo.setAuthCode(elementInfoDTO.getAuthCode());
        elementInfo.setType(elementInfoDTO.getType());
        elementInfo.setPageUri(elementInfoDTO.getPageUri());
        elementInfo.setApiUri(elementInfoDTO.getApiUri());
        elementInfo.setHttpMethod(elementInfoDTO.getHttpMethod());
        elementInfo.setOrderNum(elementInfoDTO.getOrderNum());
        elementInfo.setThirdParty(elementInfoDTO.getThirdParty());
        elementInfo.setThirdTitle(elementInfoDTO.getThirdTitle());
        elementInfo.setThirdUri(elementInfoDTO.getThirdUri());
        elementInfo.setAskUri(elementInfoDTO.getAskUri());
        elementInfo.setValidFlag(elementInfoDTO.getValidFlag());
        elementInfo.setHasAuth(elementInfoDTO.getHasAuth());
        elementInfo.setHasIp(elementInfoDTO.getHasIp());
        elementInfo.setRemarks(elementInfoDTO.getRemarks());
        return elementInfo;
    }


    @Override
    public ElementInfoVO toJavaObjectVO(ElementInfo elementInfo) {
        if (null == elementInfo){
            return null;
        }
        ElementInfoVO elementInfoVO = new ElementInfoVO();
        elementInfoVO.setId(elementInfo.getId());
        elementInfoVO.setAppId(elementInfo.getAppId());
        elementInfoVO.setMenuId(elementInfo.getMenuId());
        elementInfoVO.setMenuTitle(elementInfo.getMenuTitle());
        elementInfoVO.setTitle(elementInfo.getTitle());
        elementInfoVO.setAuthCode(elementInfo.getAuthCode());
        elementInfoVO.setType(elementInfo.getType());
        elementInfoVO.setPageUri(elementInfo.getPageUri());
        elementInfoVO.setApiUri(elementInfo.getApiUri());
        elementInfoVO.setHttpMethod(elementInfo.getHttpMethod());
        elementInfoVO.setOrderNum(elementInfo.getOrderNum());
        elementInfoVO.setThirdParty(elementInfo.getThirdParty());
        elementInfoVO.setThirdTitle(elementInfo.getThirdTitle());
        elementInfoVO.setThirdUri(elementInfo.getThirdUri());
        elementInfoVO.setAskUri(elementInfo.getAskUri());
        elementInfoVO.setValidFlag(elementInfo.getValidFlag());
        elementInfoVO.setHasAuth(elementInfo.getHasAuth());
        elementInfoVO.setHasIp(elementInfo.getHasIp());
        elementInfoVO.setRemarks(elementInfo.getRemarks());
        return elementInfoVO;
    }

    public ElementInfo toJavaObject(ElementInfoVO elementInfoVO) {
        if (null == elementInfoVO){
            return null;
        }
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setId(elementInfoVO.getId());
        elementInfo.setAppId(elementInfoVO.getAppId());
        elementInfo.setMenuId(elementInfoVO.getMenuId());
        elementInfo.setMenuTitle(elementInfoVO.getMenuTitle());
        elementInfo.setTitle(elementInfoVO.getTitle());
        elementInfo.setAuthCode(elementInfoVO.getAuthCode());
        elementInfo.setType(elementInfoVO.getType());
        elementInfo.setPageUri(elementInfoVO.getPageUri());
        elementInfo.setApiUri(elementInfoVO.getApiUri());
        elementInfo.setHttpMethod(elementInfoVO.getHttpMethod());
        elementInfo.setOrderNum(elementInfoVO.getOrderNum());
        elementInfo.setThirdParty(elementInfoVO.getThirdParty());
        elementInfo.setThirdTitle(elementInfoVO.getThirdTitle());
        elementInfo.setThirdUri(elementInfoVO.getThirdUri());
        elementInfo.setAskUri(elementInfoVO.getAskUri());
        elementInfo.setValidFlag(elementInfoVO.getValidFlag());
        elementInfo.setHasAuth(elementInfoVO.getHasAuth());
        elementInfo.setHasIp(elementInfoVO.getHasIp());
        elementInfo.setRemarks(elementInfoVO.getRemarks());
        return elementInfo;
    }

    public ElementInfoVO toJavaObjectVO(ElementInfoDTO elementInfoDTO) {
        if (null == elementInfoDTO){
            return null;
        }
        ElementInfoVO elementInfoVO = new ElementInfoVO();
        elementInfoVO.setId(elementInfoDTO.getId());
        elementInfoVO.setAppId(elementInfoDTO.getAppId());
        elementInfoVO.setMenuId(elementInfoDTO.getMenuId());
        elementInfoVO.setMenuTitle(elementInfoDTO.getMenuTitle());
        elementInfoVO.setTitle(elementInfoDTO.getTitle());
        elementInfoVO.setAuthCode(elementInfoDTO.getAuthCode());
        elementInfoVO.setType(elementInfoDTO.getType());
        elementInfoVO.setPageUri(elementInfoDTO.getPageUri());
        elementInfoVO.setApiUri(elementInfoDTO.getApiUri());
        elementInfoVO.setHttpMethod(elementInfoDTO.getHttpMethod());
        elementInfoVO.setOrderNum(elementInfoDTO.getOrderNum());
        elementInfoVO.setThirdParty(elementInfoDTO.getThirdParty());
        elementInfoVO.setThirdTitle(elementInfoDTO.getThirdTitle());
        elementInfoVO.setThirdUri(elementInfoDTO.getThirdUri());
        elementInfoVO.setAskUri(elementInfoDTO.getAskUri());
        elementInfoVO.setValidFlag(elementInfoDTO.getValidFlag());
        elementInfoVO.setHasAuth(elementInfoDTO.getHasAuth());
        elementInfoVO.setHasIp(elementInfoDTO.getHasIp());
        elementInfoVO.setRemarks(elementInfoDTO.getRemarks());
        return elementInfoVO;
    }


}