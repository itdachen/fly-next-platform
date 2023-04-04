package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 菜单管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IMenuInfoService extends IBizService< MenuInfo, MenuInfoVo, MenuInfoQuery, String > {

}
