package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.AuthGrantMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthGrantMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthGrantMenuVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 权限下发 业务接口
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public interface IAuthGrantMenuService extends IBizService<AuthGrantMenuDTO, AuthGrantMenuVO, AuthGrantMenuQuery, String> {

    /***
     * 获取可下发的菜单树
     *
     * @author 王大宸
     * @date 2024/5/15 22:53
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findTreeData(String clazzCode, String appId) throws Exception;


    /***
     * 权限下发时, 获取权限信息
     *
     * @author 王大宸
     * @date 2024/5/28 21:28
     * @param roleId roleId
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findLowerTreeData(String roleId, String appId) throws Exception;


    /***
     * 给用户下方权限时获取权限信息
     *
     * @author 王大宸
     * @date 2024/5/17 16:22
     * @param roleId 用户身份ID
     * @param appId  应用ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findGrantMenuTreeData(String roleId, String appId) throws Exception;

    /***
     * 获取人员特殊授权可使用权限
     *
     * @author 王大宸
     * @date 2024/5/17 16:38
     * @param roleId 用户身份ID
     * @param appId  应用ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findRoleMenuTreeData(String roleId, String appId) throws Exception;

}
