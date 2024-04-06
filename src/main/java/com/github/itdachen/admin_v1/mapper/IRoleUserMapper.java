package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.RoleUser;
import com.github.itdachen.admin_v1.sdk.query.RoleUserQuery;
import com.github.itdachen.admin_v1.sdk.vo.RoleUserVo;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户角色 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleUserMapper extends Mapper<RoleUser> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.roleUserVo
     */
    List<RoleUserVo> page(RoleUserQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.RoleUser>
     */
    void batchSave(List<RoleUser> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.RoleUser>
     */
    void batchUpdate(List<RoleUser> list);

    void remove(String userId);

    /***
     * 查询已有角色
     *
     * @author 王大宸
     * @date 2023/4/5 21:33
     * @param userId userId
     * @return java.util.List<java.lang.String>
     */
    List<String> findRoleIdByUserId(String userId);

    /***
     * 根据部门查询角色
     *
     * @author 王大宸
     * @date 2023/4/5 21:33
     * @param deptId deptId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findRoleByDept(String deptId);


}
