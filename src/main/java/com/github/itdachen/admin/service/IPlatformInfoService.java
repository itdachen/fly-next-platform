package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.PlatformInfoDTO;
import com.github.itdachen.admin.sdk.query.PlatformInfoQuery;
import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 平台信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
public interface IPlatformInfoService extends IBizService<PlatformInfoDTO, PlatformInfoVO, PlatformInfoQuery, String> {

    List<PlatformInfoVO> findPlatformInfoList() throws Exception;

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;


}