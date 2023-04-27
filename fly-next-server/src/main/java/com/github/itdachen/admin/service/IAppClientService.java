package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.dto.AppClientDto;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 应用管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
public interface IAppClientService extends IBizService<AppClientDto, AppClientVo, AppClientQuery, String> {

    /***
     * 更改状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:05
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.AppClientVo
     */
    void updateStatus(String id, Boolean status) throws BizException;

}
