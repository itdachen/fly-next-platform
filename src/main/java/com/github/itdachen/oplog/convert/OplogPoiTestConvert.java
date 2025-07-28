package com.github.itdachen.oplog.convert;

import com.github.itdachen.oplog.entity.OplogPoiTest;
import com.github.itdachen.oplog.sdk.dto.OplogPoiTestDTO;
import com.github.itdachen.oplog.sdk.vo.OplogPoiTestVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 导入导出测试 类型转换
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
public class OplogPoiTestConvert implements IBizConvertMapper<OplogPoiTest, OplogPoiTestDTO, OplogPoiTestVO> {

    @Override
    public OplogPoiTest toJavaObject(OplogPoiTestDTO oplogPoiTestDTO) {
        if (null == oplogPoiTestDTO) {
            return null;
        }
        OplogPoiTest oplogPoiTest = new OplogPoiTest();
        oplogPoiTest.setId(oplogPoiTestDTO.getId());
        oplogPoiTest.setTenantId(oplogPoiTestDTO.getTenantId());
        oplogPoiTest.setTenantTitle(oplogPoiTestDTO.getTenantTitle());
        oplogPoiTest.setTitle(oplogPoiTestDTO.getTitle());
        oplogPoiTest.setType(oplogPoiTestDTO.getType());
        oplogPoiTest.setHostIp(oplogPoiTestDTO.getHostIp());
        oplogPoiTest.setHostAddress(oplogPoiTestDTO.getHostAddress());
        oplogPoiTest.setHostOs(oplogPoiTestDTO.getHostOs());
        oplogPoiTest.setHostBrowser(oplogPoiTestDTO.getHostBrowser());
        oplogPoiTest.setUserAgent(oplogPoiTestDTO.getUserAgent());
        oplogPoiTest.setRemarks(oplogPoiTestDTO.getRemarks());
        oplogPoiTest.setExecuteTime(oplogPoiTestDTO.getExecuteTime());
        oplogPoiTest.setDelFlag(oplogPoiTestDTO.getDelFlag());
        oplogPoiTest.setYearly(oplogPoiTestDTO.getYearly());
        oplogPoiTest.setMonthly(oplogPoiTestDTO.getMonthly());
        return oplogPoiTest;
    }


    @Override
    public OplogPoiTestVO toJavaObjectVO(OplogPoiTest oplogPoiTest) {
        if (null == oplogPoiTest) {
            return null;
        }
        OplogPoiTestVO oplogPoiTestVO = new OplogPoiTestVO();
        oplogPoiTestVO.setId(oplogPoiTest.getId());
        oplogPoiTestVO.setTenantId(oplogPoiTest.getTenantId());
        oplogPoiTestVO.setTenantTitle(oplogPoiTest.getTenantTitle());
        oplogPoiTestVO.setTitle(oplogPoiTest.getTitle());
        oplogPoiTestVO.setType(oplogPoiTest.getType());
        oplogPoiTestVO.setHostIp(oplogPoiTest.getHostIp());
        oplogPoiTestVO.setHostAddress(oplogPoiTest.getHostAddress());
        oplogPoiTestVO.setHostOs(oplogPoiTest.getHostOs());
        oplogPoiTestVO.setHostBrowser(oplogPoiTest.getHostBrowser());
        oplogPoiTestVO.setUserAgent(oplogPoiTest.getUserAgent());
        oplogPoiTestVO.setRemarks(oplogPoiTest.getRemarks());
        oplogPoiTestVO.setExecuteTime(oplogPoiTest.getExecuteTime());
        oplogPoiTestVO.setDelFlag(oplogPoiTest.getDelFlag());
        oplogPoiTestVO.setYearly(oplogPoiTest.getYearly());
        oplogPoiTestVO.setMonthly(oplogPoiTest.getMonthly());
        oplogPoiTestVO.setCreateTime(oplogPoiTest.getCreateTime());
        return oplogPoiTestVO;
    }

    public OplogPoiTest toJavaObject(OplogPoiTestVO oplogPoiTestVO) {
        if (null == oplogPoiTestVO) {
            return null;
        }
        OplogPoiTest oplogPoiTest = new OplogPoiTest();
        oplogPoiTest.setId(oplogPoiTestVO.getId());
        oplogPoiTest.setTenantId(oplogPoiTestVO.getTenantId());
        oplogPoiTest.setTenantTitle(oplogPoiTestVO.getTenantTitle());
        oplogPoiTest.setTitle(oplogPoiTestVO.getTitle());
        oplogPoiTest.setType(oplogPoiTestVO.getType());
        oplogPoiTest.setHostIp(oplogPoiTestVO.getHostIp());
        oplogPoiTest.setHostAddress(oplogPoiTestVO.getHostAddress());
        oplogPoiTest.setHostOs(oplogPoiTestVO.getHostOs());
        oplogPoiTest.setHostBrowser(oplogPoiTestVO.getHostBrowser());
        oplogPoiTest.setUserAgent(oplogPoiTestVO.getUserAgent());
        oplogPoiTest.setRemarks(oplogPoiTestVO.getRemarks());
        oplogPoiTest.setExecuteTime(oplogPoiTestVO.getExecuteTime());
        oplogPoiTest.setDelFlag(oplogPoiTestVO.getDelFlag());
        oplogPoiTest.setYearly(oplogPoiTestVO.getYearly());
        oplogPoiTest.setMonthly(oplogPoiTestVO.getMonthly());
        oplogPoiTest.setCreateTime(oplogPoiTestVO.getCreateTime());
        return oplogPoiTest;
    }

    public OplogPoiTestVO toJavaObjectVO(OplogPoiTestDTO oplogPoiTestDTO) {
        if (null == oplogPoiTestDTO) {
            return null;
        }
        OplogPoiTestVO oplogPoiTestVO = new OplogPoiTestVO();
        oplogPoiTestVO.setId(oplogPoiTestDTO.getId());
        oplogPoiTestVO.setTenantId(oplogPoiTestDTO.getTenantId());
        oplogPoiTestVO.setTenantTitle(oplogPoiTestDTO.getTenantTitle());
        oplogPoiTestVO.setTitle(oplogPoiTestDTO.getTitle());
        oplogPoiTestVO.setType(oplogPoiTestDTO.getType());
        oplogPoiTestVO.setHostIp(oplogPoiTestDTO.getHostIp());
        oplogPoiTestVO.setHostAddress(oplogPoiTestDTO.getHostAddress());
        oplogPoiTestVO.setHostOs(oplogPoiTestDTO.getHostOs());
        oplogPoiTestVO.setHostBrowser(oplogPoiTestDTO.getHostBrowser());
        oplogPoiTestVO.setUserAgent(oplogPoiTestDTO.getUserAgent());
        oplogPoiTestVO.setRemarks(oplogPoiTestDTO.getRemarks());
        oplogPoiTestVO.setExecuteTime(oplogPoiTestDTO.getExecuteTime());
        oplogPoiTestVO.setDelFlag(oplogPoiTestDTO.getDelFlag());
        oplogPoiTestVO.setYearly(oplogPoiTestDTO.getYearly());
        oplogPoiTestVO.setMonthly(oplogPoiTestDTO.getMonthly());
        return oplogPoiTestVO;
    }


}