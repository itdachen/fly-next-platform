package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.AppClientDto;
import com.github.itdachen.admin_v1.sdk.query.AppClientQuery;
import com.github.itdachen.admin_v1.sdk.vo.AppClientVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

    /***
    * 通用导出
    *
    * @author 王大宸
    * @date 2023/9/21 10:14
    * @return void
    */
    void exportAppClient(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
