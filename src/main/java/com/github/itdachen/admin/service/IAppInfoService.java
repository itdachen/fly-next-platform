package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.AppInfoDTO;
import com.github.itdachen.admin.sdk.query.AppInfoQuery;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 应用信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-19 21:22:54
 */
public interface IAppInfoService extends IBizService< AppInfoDTO, AppInfoVO, AppInfoQuery, String > {


    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024/4/20 22:32
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.AppInfoVO>
     */
    List<AppInfoVO> findAppInfoList() throws Exception;

}
