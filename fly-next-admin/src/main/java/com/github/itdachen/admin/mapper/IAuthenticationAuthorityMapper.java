package com.github.itdachen.admin.mapper;


import com.github.itdachen.admin.entity.PermsAuth;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.security.user.LayuiAdminMenu;
import com.github.itdachen.security.user.OkAdminMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限下发 持久层接口
 *
 * @author 王大宸
 * @date 2022-08-24 23:30:59
 */
public interface IAuthenticationAuthorityMapper extends Mapper<PermsAuth> {

    List<LayuiAdminMenu> getChildrenMenu(String parentId, String userId);

    List<LayuiAdminMenu> findMenuAll(String parentId);

    PermissionInfo findHomePage(String parentId);

    /***
     * 获取首页跳转地址
     *
     * @author 王大宸
     * @date 2022/9/6 23:00
     * @param userId userId
     * @return java.lang.String
     */
    PermissionInfo findIndexPath(String parentId, String userId);

    String findMenuPath(String parentId, String userId);

    /***
     * ok-admin 查询所有菜单
     *
     * @author 王大宸
     * @date 2022/10/7 14:03
     * @param parentId parentId
     * @return java.util.List<com.itdachen.auth.core.user.OkAdminMenu>
     */
    List<OkAdminMenu> getOkAdminMenuAll(String parentId);

    List<OkAdminMenu> getOkAdminChildrenMenu(String parentId, String userId);

}
