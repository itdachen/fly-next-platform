package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.dto.DictTypeDTO;
import com.github.itdachen.admin.sdk.vo.DictTypeVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 数据字典类型 类型转换
 *
 * @author 王大宸
 * @date 2024-04-21 20:29:55
 */
public class DictTypeConvert implements IBizConvertMapper<DictType, DictTypeDTO, DictTypeVO> {

    @Override
    public DictType toJavaObject(DictTypeDTO dictTypeDTO) {
        if (null == dictTypeDTO) {
            return null;
        }
        DictType dictType = new DictType();
        dictType.setId(dictTypeDTO.getId());
        dictType.setDictLabel(dictTypeDTO.getDictLabel());
        dictType.setDictType(dictTypeDTO.getDictType());
        dictType.setDictSort(dictTypeDTO.getDictSort());
        dictType.setIsDefault(dictTypeDTO.getIsDefault());
        dictType.setValidFlag(dictTypeDTO.getValidFlag());
        dictType.setRemarks(dictTypeDTO.getRemarks());
        return dictType;
    }


    @Override
    public DictTypeVO toJavaObjectVO(DictType dictType) {
        if (null == dictType) {
            return null;
        }
        DictTypeVO dictTypeVO = new DictTypeVO();
        dictTypeVO.setId(dictType.getId());
        dictTypeVO.setDictLabel(dictType.getDictLabel());
        dictTypeVO.setDictType(dictType.getDictType());
        dictTypeVO.setDictSort(dictType.getDictSort());
        dictTypeVO.setIsDefault(dictType.getIsDefault());
        dictTypeVO.setValidFlag(dictType.getValidFlag());
        dictTypeVO.setRemarks(dictType.getRemarks());
        return dictTypeVO;
    }

    public DictType toJavaObject(DictTypeVO dictTypeVO) {
        if (null == dictTypeVO) {
            return null;
        }
        DictType dictType = new DictType();
        dictType.setId(dictTypeVO.getId());
        dictType.setDictLabel(dictTypeVO.getDictLabel());
        dictType.setDictType(dictTypeVO.getDictType());
        dictType.setDictSort(dictTypeVO.getDictSort());
        dictType.setIsDefault(dictTypeVO.getIsDefault());
        dictType.setValidFlag(dictTypeVO.getValidFlag());
        dictType.setRemarks(dictTypeVO.getRemarks());
        return dictType;
    }

    public DictTypeVO toJavaObjectVO(DictTypeDTO dictTypeDTO) {
        if (null == dictTypeDTO) {
            return null;
        }
        DictTypeVO dictTypeVO = new DictTypeVO();
        dictTypeVO.setId(dictTypeDTO.getId());
        dictTypeVO.setDictLabel(dictTypeDTO.getDictLabel());
        dictTypeVO.setDictType(dictTypeDTO.getDictType());
        dictTypeVO.setDictSort(dictTypeDTO.getDictSort());
        dictTypeVO.setIsDefault(dictTypeDTO.getIsDefault());
        dictTypeVO.setValidFlag(dictTypeDTO.getValidFlag());
        dictTypeVO.setRemarks(dictTypeDTO.getRemarks());
        return dictTypeVO;
    }


}