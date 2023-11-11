package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.RoleMenuDto;
import com.github.itdachen.admin.sdk.query.RoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.node.TreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 菜单角色 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleMenuService extends IBizService<RoleMenuDto, RoleMenuVo, RoleMenuQuery, String> {

    /***
     * 获取菜单树
     *
     * @author 王大宸
     * @date 2023/4/5 21:48
     * @param roleId roleId
     * @param userType userType
     * @param userId userId
     * @return java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>
     */
    List<ZTreeNode> roleMenuTreeData(String roleId, String userType, String userId) throws BizException;

    /***
     * 获取权限树数据
     *
     * @author 王大宸
     * @date 2023/5/15 21:51
     * @param roleId roleId
     * @return java.util.List<com.github.itdachen.framework.context.node.TreeNode>
     */
    TreeNode<MenuInfoVo, String> roleMenuElTreeData(String roleId);

}
