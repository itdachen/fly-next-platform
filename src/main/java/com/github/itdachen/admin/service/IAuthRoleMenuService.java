package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.AuthRoleMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthRoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthRoleMenuVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 人员身份菜单 业务接口
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
public interface IAuthRoleMenuService extends IBizService< AuthRoleMenuDTO, AuthRoleMenuVO, AuthRoleMenuQuery, String > {

}
