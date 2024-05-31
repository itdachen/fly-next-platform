package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AdmArea;
import com.github.itdachen.admin.sdk.dto.AdmAreaDTO;
import com.github.itdachen.admin.sdk.vo.AdmAreaVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 行政区划代码 类型转换
 *
 * @author 王大宸
 * @date 2024-05-06 21:18:46
 */
public class AdmAreaConvert implements IBizConvertMapper< AdmArea, AdmAreaDTO, AdmAreaVO > {

    @Override
    public AdmArea toJavaObject(AdmAreaDTO admAreaDTO) {
        if (null == admAreaDTO){
            return null;
        }
        AdmArea admArea = new AdmArea();
                admArea.setId(admAreaDTO.getId());
                admArea.setProvCode(admAreaDTO.getProvCode());
                admArea.setCityCode(admAreaDTO.getCityCode());
                admArea.setCountyCode(admAreaDTO.getCountyCode());
                admArea.setTownCode(admAreaDTO.getTownCode());
                admArea.setStreetCode(admAreaDTO.getStreetCode());
                admArea.setStreetName(admAreaDTO.getStreetName());
                admArea.setStreetType(admAreaDTO.getStreetType());
                admArea.setLevelType(admAreaDTO.getLevelType());
        return admArea;
    }


    @Override
    public AdmAreaVO toJavaObjectVO(AdmArea admArea) {
        if (null == admArea){
            return null;
        }
            AdmAreaVO admAreaVO = new AdmAreaVO();
                    admAreaVO.setId(admArea.getId());
                    admAreaVO.setProvCode(admArea.getProvCode());
                    admAreaVO.setCityCode(admArea.getCityCode());
                    admAreaVO.setCountyCode(admArea.getCountyCode());
                    admAreaVO.setTownCode(admArea.getTownCode());
                    admAreaVO.setStreetCode(admArea.getStreetCode());
                    admAreaVO.setStreetName(admArea.getStreetName());
                    admAreaVO.setStreetType(admArea.getStreetType());
                    admAreaVO.setLevelType(admArea.getLevelType());
        return admAreaVO;
    }

    public AdmArea toJavaObject(AdmAreaVO admAreaVO) {
        if (null == admAreaVO){
            return null;
        }
        AdmArea admArea = new AdmArea();
                admArea.setId(admAreaVO.getId());
                admArea.setProvCode(admAreaVO.getProvCode());
                admArea.setCityCode(admAreaVO.getCityCode());
                admArea.setCountyCode(admAreaVO.getCountyCode());
                admArea.setTownCode(admAreaVO.getTownCode());
                admArea.setStreetCode(admAreaVO.getStreetCode());
                admArea.setStreetName(admAreaVO.getStreetName());
                admArea.setStreetType(admAreaVO.getStreetType());
                admArea.setLevelType(admAreaVO.getLevelType());
        return admArea;
    }

    public AdmAreaVO toJavaObjectVO(AdmAreaDTO admAreaDTO) {
        if (null == admAreaDTO){
            return null;
        }
            AdmAreaVO admAreaVO = new AdmAreaVO();
                    admAreaVO.setId(admAreaDTO.getId());
                    admAreaVO.setProvCode(admAreaDTO.getProvCode());
                    admAreaVO.setCityCode(admAreaDTO.getCityCode());
                    admAreaVO.setCountyCode(admAreaDTO.getCountyCode());
                    admAreaVO.setTownCode(admAreaDTO.getTownCode());
                    admAreaVO.setStreetCode(admAreaDTO.getStreetCode());
                    admAreaVO.setStreetName(admAreaDTO.getStreetName());
                    admAreaVO.setStreetType(admAreaDTO.getStreetType());
                    admAreaVO.setLevelType(admAreaDTO.getLevelType());
        return admAreaVO;
    }


}