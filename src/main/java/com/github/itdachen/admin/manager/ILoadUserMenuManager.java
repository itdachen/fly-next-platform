package com.github.itdachen.admin.manager;

import com.github.itdachen.framework.assets.tree.ZTreeNode;

import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023-06-25 20:06
 * Created with IntelliJ IDEA.
 */
public interface ILoadUserMenuManager {

    /***
     * 加载个人可下发菜单
     *
     * @author 王大宸
     * @date 2022/9/7 17:53
     * @param menuIds  已选中的菜单集合
     * @param userType 用户类型
     * @param userId   当前登录用户id
     * @return java.util.List<com.itdachen.common.node.ZTreeNode>
     */
    List<ZTreeNode> findMenuWithUser(List<String> menuIds,
                                     String userType,
                                     String userId);


}
