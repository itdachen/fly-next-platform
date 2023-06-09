package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.ElementInfoDto;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 按钮资源 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IElementInfoService extends IBizService<ElementInfoDto, ElementInfoVo, ElementInfoQuery, String> {

    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 22:39
     * @param id id
     * @param status status
     * @return void
     */
    void updateStatus(String id, Boolean status) throws Exception;

}
