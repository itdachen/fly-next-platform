package com.github.itdachen.auth.service;

import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;

import java.util.List;

/**
 * 获取用户身份
 *
 * @author 王大宸
 * @date 2024/5/7 20:59
 */
public interface IAuthUserRoleService {

    List<ZTreeNode> findAuthUserRole(String userId);

    UserInfoDetails findUserRoleDetails(String roleId) throws Exception;

}
