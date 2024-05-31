package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.dto.DictDataDTO;
import com.github.itdachen.admin.sdk.vo.DictDataVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 数据字典信息表 类型转换
 *
 * @author 王大宸
 * @date 2024-04-21 20:29:55
 */
public class DictDataConvert implements IBizConvertMapper< DictData, DictDataDTO, DictDataVO > {

    @Override
    public DictData toJavaObject(DictDataDTO dictDataDTO) {
        if (null == dictDataDTO){
            return null;
        }
        DictData dictData = new DictData();
                dictData.setId(dictDataDTO.getId());
                dictData.setTypeId(dictDataDTO.getTypeId());
                dictData.setTypeLabel(dictDataDTO.getTypeLabel());
                dictData.setDictType(dictDataDTO.getDictType());
                dictData.setDictLabel(dictDataDTO.getDictLabel());
                dictData.setDictValue(dictDataDTO.getDictValue());
                dictData.setIsDefault(dictDataDTO.getIsDefault());
                dictData.setDictSort(dictDataDTO.getDictSort());
                dictData.setValidFlag(dictDataDTO.getValidFlag());
                dictData.setRemarks(dictDataDTO.getRemarks());
        return dictData;
    }


    @Override
    public DictDataVO toJavaObjectVO(DictData dictData) {
        if (null == dictData){
            return null;
        }
            DictDataVO dictDataVO = new DictDataVO();
                    dictDataVO.setId(dictData.getId());
                    dictDataVO.setTypeId(dictData.getTypeId());
                    dictDataVO.setTypeLabel(dictData.getTypeLabel());
                    dictDataVO.setDictType(dictData.getDictType());
                    dictDataVO.setDictLabel(dictData.getDictLabel());
                    dictDataVO.setDictValue(dictData.getDictValue());
                    dictDataVO.setIsDefault(dictData.getIsDefault());
                    dictDataVO.setDictSort(dictData.getDictSort());
                    dictDataVO.setValidFlag(dictData.getValidFlag());
                    dictDataVO.setRemarks(dictData.getRemarks());
        return dictDataVO;
    }

    public DictData toJavaObject(DictDataVO dictDataVO) {
        if (null == dictDataVO){
            return null;
        }
        DictData dictData = new DictData();
                dictData.setId(dictDataVO.getId());
                dictData.setTypeId(dictDataVO.getTypeId());
                dictData.setTypeLabel(dictDataVO.getTypeLabel());
                dictData.setDictType(dictDataVO.getDictType());
                dictData.setDictLabel(dictDataVO.getDictLabel());
                dictData.setDictValue(dictDataVO.getDictValue());
                dictData.setIsDefault(dictDataVO.getIsDefault());
                dictData.setDictSort(dictDataVO.getDictSort());
                dictData.setValidFlag(dictDataVO.getValidFlag());
                dictData.setRemarks(dictDataVO.getRemarks());
        return dictData;
    }

    public DictDataVO toJavaObjectVO(DictDataDTO dictDataDTO) {
        if (null == dictDataDTO){
            return null;
        }
            DictDataVO dictDataVO = new DictDataVO();
                    dictDataVO.setId(dictDataDTO.getId());
                    dictDataVO.setTypeId(dictDataDTO.getTypeId());
                    dictDataVO.setTypeLabel(dictDataDTO.getTypeLabel());
                    dictDataVO.setDictType(dictDataDTO.getDictType());
                    dictDataVO.setDictLabel(dictDataDTO.getDictLabel());
                    dictDataVO.setDictValue(dictDataDTO.getDictValue());
                    dictDataVO.setIsDefault(dictDataDTO.getIsDefault());
                    dictDataVO.setDictSort(dictDataDTO.getDictSort());
                    dictDataVO.setValidFlag(dictDataDTO.getValidFlag());
                    dictDataVO.setRemarks(dictDataDTO.getRemarks());
        return dictDataVO;
    }


}