package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.RoleMenu;
import com.github.itdachen.admin.sdk.query.RoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 菜单角色 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleMenuService extends IBizService< RoleMenu, RoleMenuVo, RoleMenuQuery, String > {

}
