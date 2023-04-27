package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.dto.ElementInfoDto;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import com.github.itdachen.framework.webmvc.convert.BizConvert;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:22
 * Created with IntelliJ IDEA.
 */
public class ElementInfoConvert extends BizConvert<ElementInfo, ElementInfoDto, ElementInfoVo> {

    @Override
    public ElementInfo toJavaObject(ElementInfoDto elementInfoDto) {
        if (null == elementInfoDto){
            return null;
        }
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setId(elementInfoDto.getId());
        elementInfo.setMenuId(elementInfoDto.getMenuId());
        elementInfo.setTitle(elementInfoDto.getTitle());
        elementInfo.setCode(elementInfoDto.getCode());
        elementInfo.setType(elementInfoDto.getType());
        elementInfo.setHref(elementInfoDto.getHref());
        elementInfo.setPath(elementInfoDto.getPath());
        elementInfo.setMethod(elementInfoDto.getMethod());
        elementInfo.setOrderNum(elementInfoDto.getOrderNum());
        elementInfo.setVisible(elementInfoDto.getVisible());
        elementInfo.setRemarks(elementInfoDto.getRemarks());
        return elementInfo;
    }


    @Override
    public ElementInfoVo toJavaObjectVo(ElementInfo elementInfo) {
        if (null == elementInfo){
            return null;
        }
        ElementInfoVo elementInfoVo = new ElementInfoVo();
        elementInfoVo.setId(elementInfo.getId());
        elementInfoVo.setMenuId(elementInfo.getMenuId());
        elementInfoVo.setTitle(elementInfo.getTitle());
        elementInfoVo.setCode(elementInfo.getCode());
        elementInfoVo.setType(elementInfo.getType());
        elementInfoVo.setHref(elementInfo.getHref());
        elementInfoVo.setPath(elementInfo.getPath());
        elementInfoVo.setMethod(elementInfo.getMethod());
        elementInfoVo.setOrderNum(elementInfo.getOrderNum());
        elementInfoVo.setVisible(elementInfo.getVisible());
        elementInfoVo.setRemarks(elementInfo.getRemarks());
        return elementInfoVo;
    }

    public static ElementInfo toJavaObject(ElementInfoVo elementInfoVo) {
        if (null == elementInfoVo){
            return null;
        }
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setId(elementInfoVo.getId());
        elementInfo.setMenuId(elementInfoVo.getMenuId());
        elementInfo.setTitle(elementInfoVo.getTitle());
        elementInfo.setCode(elementInfoVo.getCode());
        elementInfo.setType(elementInfoVo.getType());
        elementInfo.setHref(elementInfoVo.getHref());
        elementInfo.setPath(elementInfoVo.getPath());
        elementInfo.setMethod(elementInfoVo.getMethod());
        elementInfo.setOrderNum(elementInfoVo.getOrderNum());
        elementInfo.setVisible(elementInfoVo.getVisible());
        elementInfo.setRemarks(elementInfoVo.getRemarks());
        return elementInfo;
    }

    public static ElementInfoVo toJavaObjectVo(ElementInfoDto elementInfoDto) {
        if (null == elementInfoDto){
            return null;
        }
        ElementInfoVo elementInfoVo = new ElementInfoVo();
        elementInfoVo.setId(elementInfoDto.getId());
        elementInfoVo.setMenuId(elementInfoDto.getMenuId());
        elementInfoVo.setTitle(elementInfoDto.getTitle());
        elementInfoVo.setCode(elementInfoDto.getCode());
        elementInfoVo.setType(elementInfoDto.getType());
        elementInfoVo.setHref(elementInfoDto.getHref());
        elementInfoVo.setPath(elementInfoDto.getPath());
        elementInfoVo.setMethod(elementInfoDto.getMethod());
        elementInfoVo.setOrderNum(elementInfoDto.getOrderNum());
        elementInfoVo.setVisible(elementInfoDto.getVisible());
        elementInfoVo.setRemarks(elementInfoDto.getRemarks());
        return elementInfoVo;
    }

}
