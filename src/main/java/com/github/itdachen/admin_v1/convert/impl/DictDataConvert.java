package com.github.itdachen.admin_v1.convert.impl;

import com.github.itdachen.admin_v1.convert.IDictDataConvert;
import com.github.itdachen.admin_v1.entity.DictData;
import com.github.itdachen.admin_v1.sdk.dto.DictDataDto;
import com.github.itdachen.admin_v1.sdk.vo.DictDataVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:13
 * Created with IntelliJ IDEA.
 */
@Component
public class DictDataConvert implements IDictDataConvert {

    @Override
    public DictData toJavaObject(DictDataDto dictDataDto) {
        if (null == dictDataDto) {
            return null;
        }
        DictData dictData = new DictData();
        dictData.setId(dictDataDto.getId());
        dictData.setDictSort(dictDataDto.getDictSort());
        dictData.setDictLabel(dictDataDto.getDictLabel());
        dictData.setDictValue(dictDataDto.getDictValue());
        dictData.setDictType(dictDataDto.getDictType());
        dictData.setCssClass(dictDataDto.getCssClass());
        dictData.setListClass(dictDataDto.getListClass());
        dictData.setIsDefault(dictDataDto.getIsDefault());
        dictData.setStatus(dictDataDto.getStatus());
        dictData.setRemarks(dictDataDto.getRemarks());
        return dictData;
    }


    @Override
    public DictDataVo toJavaObjectVo(DictData dictData) {
        if (null == dictData) {
            return null;
        }
        DictDataVo dictDataVo = new DictDataVo();
        dictDataVo.setId(dictData.getId());
        dictDataVo.setDictSort(dictData.getDictSort());
        dictDataVo.setDictLabel(dictData.getDictLabel());
        dictDataVo.setDictValue(dictData.getDictValue());
        dictDataVo.setDictType(dictData.getDictType());
        dictDataVo.setCssClass(dictData.getCssClass());
        dictDataVo.setListClass(dictData.getListClass());
        dictDataVo.setIsDefault(dictData.getIsDefault());
        dictDataVo.setStatus(dictData.getStatus());
        dictDataVo.setRemarks(dictData.getRemarks());
        return dictDataVo;
    }

    public static DictData toJavaObject(DictDataVo dictDataVo) {
        if (null == dictDataVo) {
            return null;
        }
        DictData dictData = new DictData();
        dictData.setId(dictDataVo.getId());
        dictData.setDictSort(dictDataVo.getDictSort());
        dictData.setDictLabel(dictDataVo.getDictLabel());
        dictData.setDictValue(dictDataVo.getDictValue());
        dictData.setDictType(dictDataVo.getDictType());
        dictData.setCssClass(dictDataVo.getCssClass());
        dictData.setListClass(dictDataVo.getListClass());
        dictData.setIsDefault(dictDataVo.getIsDefault());
        dictData.setStatus(dictDataVo.getStatus());
        dictData.setRemarks(dictDataVo.getRemarks());
        return dictData;
    }

    public static DictDataVo toJavaObjectVo(DictDataDto dictDataDto) {
        if (null == dictDataDto) {
            return null;
        }
        DictDataVo dictDataVo = new DictDataVo();
        dictDataVo.setId(dictDataDto.getId());
        dictDataVo.setDictSort(dictDataDto.getDictSort());
        dictDataVo.setDictLabel(dictDataDto.getDictLabel());
        dictDataVo.setDictValue(dictDataDto.getDictValue());
        dictDataVo.setDictType(dictDataDto.getDictType());
        dictDataVo.setCssClass(dictDataDto.getCssClass());
        dictDataVo.setListClass(dictDataDto.getListClass());
        dictDataVo.setIsDefault(dictDataDto.getIsDefault());
        dictDataVo.setStatus(dictDataDto.getStatus());
        dictDataVo.setRemarks(dictDataDto.getRemarks());
        return dictDataVo;
    }


}
