package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.RoleUser;
import com.github.itdachen.admin.sdk.query.RoleUserQuery;
import com.github.itdachen.admin.sdk.vo.RoleUserVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 用户角色 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleUserService extends IBizService< RoleUser, RoleUserVo, RoleUserQuery, String > {

}
