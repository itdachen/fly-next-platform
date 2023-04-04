package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 应用管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
public interface IAppClientService extends IBizService< AppClient, AppClientVo, AppClientQuery, String > {

}
