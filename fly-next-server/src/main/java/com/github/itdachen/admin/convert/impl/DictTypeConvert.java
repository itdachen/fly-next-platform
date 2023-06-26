package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.convert.IDictTypeConvert;
import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.dto.DictTypeDto;
import com.github.itdachen.admin.sdk.vo.DictTypeVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:18
 * Created with IntelliJ IDEA.
 */
@Component
public class DictTypeConvert implements IDictTypeConvert {

    @Override
    public DictType toJavaObject(DictTypeDto dictTypeDto) {
        if (null == dictTypeDto) {
            return null;
        }
        DictType dictType = new DictType();
        dictType.setId(dictTypeDto.getId());
        dictType.setDictName(dictTypeDto.getDictName());
        dictType.setDictType(dictTypeDto.getDictType());
        dictType.setStatus(dictTypeDto.getStatus());
        dictType.setRemarks(dictTypeDto.getRemarks());
        return dictType;
    }


    @Override
    public DictTypeVo toJavaObjectVo(DictType dictType) {
        if (null == dictType) {
            return null;
        }
        DictTypeVo dictTypeVo = new DictTypeVo();
        dictTypeVo.setId(dictType.getId());
        dictTypeVo.setDictName(dictType.getDictName());
        dictTypeVo.setDictType(dictType.getDictType());
        dictTypeVo.setStatus(dictType.getStatus());
        dictTypeVo.setRemarks(dictType.getRemarks());
        return dictTypeVo;
    }

    public static DictType toJavaObject(DictTypeVo dictTypeVo) {
        if (null == dictTypeVo) {
            return null;
        }
        DictType dictType = new DictType();
        dictType.setId(dictTypeVo.getId());
        dictType.setDictName(dictTypeVo.getDictName());
        dictType.setDictType(dictTypeVo.getDictType());
        dictType.setStatus(dictTypeVo.getStatus());
        dictType.setRemarks(dictTypeVo.getRemarks());
        return dictType;
    }

    public static DictTypeVo toJavaObjectVo(DictTypeDto dictTypeDto) {
        if (null == dictTypeDto) {
            return null;
        }
        DictTypeVo dictTypeVo = new DictTypeVo();
        dictTypeVo.setId(dictTypeDto.getId());
        dictTypeVo.setDictName(dictTypeDto.getDictName());
        dictTypeVo.setDictType(dictTypeDto.getDictType());
        dictTypeVo.setStatus(dictTypeDto.getStatus());
        dictTypeVo.setRemarks(dictTypeDto.getRemarks());
        return dictTypeVo;
    }

}
