package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.RoleMenu;
import com.github.itdachen.admin_v1.sdk.query.RoleMenuQuery;
import com.github.itdachen.admin_v1.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 菜单角色 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleMenuMapper extends Mapper<RoleMenu> {

    void remove(String roleId);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.roleMenuVo
     */
    List<RoleMenuVo> page(RoleMenuQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.RoleMenu>
     */
    void batchSave(List<RoleMenu> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.RoleMenu>
     */
    void batchUpdate(List<RoleMenu> list);


    /***
     * 查询菜单
     *
     * @author 王大宸
     * @date 2023/4/5 21:27
     * @param parentId parentId
     * @param visible visible
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findValidMenu(String parentId, String visible);

    List<ZTreeNode> findValidElement(String menuId, String visible);

    /***
     * 根据角色查询已经授权的菜单
     *
     * @author 王大宸
     * @date 2023/4/5 21:49
     * @param roleId roleId
     * @return java.util.List<java.lang.String>
     */
    List<String> findMenuByRoleId(String roleId);

}
