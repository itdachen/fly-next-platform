package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.RoleInfoDto;
import com.github.itdachen.admin.sdk.query.RoleInfoQuery;
import com.github.itdachen.admin.sdk.vo.RoleInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 角色 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleInfoService extends IBizService<RoleInfoDto, RoleInfoVo, RoleInfoQuery, String > {



}
