package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.RoleUserDto;
import com.github.itdachen.admin.sdk.query.RoleUserQuery;
import com.github.itdachen.admin.sdk.vo.RoleUserVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 用户角色 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleUserService extends IBizService<RoleUserDto, RoleUserVo, RoleUserQuery, String > {


    List<ZTreeNode> findRoleWithUser(String userId) throws Exception;

}
