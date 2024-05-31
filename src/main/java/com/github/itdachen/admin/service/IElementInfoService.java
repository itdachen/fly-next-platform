package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.ElementInfoDTO;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 认证资源信息(按钮信息) 业务接口
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public interface IElementInfoService extends IBizService< ElementInfoDTO, ElementInfoVO, ElementInfoQuery, String > {


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
