package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.AuthClazzRoleDTO;
import com.github.itdachen.admin.sdk.query.AuthClazzRoleQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzRoleVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 身份岗位管理表 业务接口
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:14
 */
public interface IAuthClazzRoleService extends IBizService< AuthClazzRoleDTO, AuthClazzRoleVO, AuthClazzRoleQuery, String > {

}
