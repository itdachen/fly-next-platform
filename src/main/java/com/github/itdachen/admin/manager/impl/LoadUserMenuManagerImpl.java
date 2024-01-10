package com.github.itdachen.admin.manager.impl;

import com.github.itdachen.admin.sdk.constants.MenuValidConstant;
import com.github.itdachen.admin.manager.IAppClientManager;
import com.github.itdachen.admin.manager.ILoadUserMenuManager;
import com.github.itdachen.admin.mapper.IAppClientMapper;
import com.github.itdachen.admin.mapper.IPermsAuthMapper;
import com.github.itdachen.admin.mapper.IRoleMenuMapper;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023-06-25 20:08
 * Created with IntelliJ IDEA.
 */
@Component
public class LoadUserMenuManagerImpl implements ILoadUserMenuManager {
    private final IAppClientMapper appClientMapper;
    private final IPermsAuthMapper permsAuthMapper;
    private final IRoleMenuMapper roleMenuMapper;
    private final IAppClientManager appClientManager;

    public LoadUserMenuManagerImpl(IAppClientMapper appClientMapper,
                                   IPermsAuthMapper permsAuthMapper,
                                   IRoleMenuMapper roleMenuMapper,
                                   IAppClientManager appClientManager) {
        this.appClientMapper = appClientMapper;
        this.permsAuthMapper = permsAuthMapper;
        this.roleMenuMapper = roleMenuMapper;
        this.appClientManager = appClientManager;
    }


    @Override
    public List<ZTreeNode> findMenuWithUser(List<String> menuIds, String userType, String userId) {
        List<ZTreeNode> apps, list = new ArrayList<>();
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userType)) {
            apps = appClientMapper.findAppAll();
            if (null == apps || apps.isEmpty()) {
                return null;
            }
            apps = appClientManager.arrangeAppMenu(apps);

            apps.forEach(item -> {
                findValidMenu(list, menuIds, item.getId());
            });
            apps.addAll(list);
            return apps;
        }

        // 这里查询权限下发表中的权限, 先查询应用
        apps = permsAuthMapper.getPermsAuthApp(userId);
        if (1 < apps.size()) {
            apps.add(new ZTreeNode.Builder()
                    .id(ZTreeNode.ROOT_ID)
                    .name("请选择菜单")
                    .parentId(ZTreeNode.ROOT_PARENT_ID)
                    .open(true)
                    .build()
            );
        }
        appClientManager.arrangeAppMenu(apps);
        apps.forEach(item -> {
            item.setOpen(true);
            loadUserMenu(list, menuIds, item.getId(), userId);
        });
        apps.addAll(list);
        return apps;
    }

    /***
     * 加载个人可下发菜单
     *
     * @author 王大宸
     * @date 2022/9/7 17:51
     * @param list list
     * @param menuIds menuIds
     * @param parentId parentId
     * @param userId userId
     * @return void
     */
    private void loadUserMenu(List<ZTreeNode> list,
                              List<String> menuIds,
                              String parentId,
                              String userId) {
        List<ZTreeNode> nodes = permsAuthMapper.permsAuthMenu(parentId, userId);
        List<ZTreeNode> elements = new ArrayList<>();
        for (ZTreeNode node : nodes) {
            if (menuIds.contains(node.getId())) {
                node.setChecked(true);
            }
            list.add(node);
            // 如果是目录,基础查询菜单
            if (MenuValidConstant.DIRT.equals(node.getType())
                    || MenuValidConstant.URI.equals(node.getType())) {
                loadUserMenu(list, menuIds, node.getId(), userId);
                continue;
            }
            // 如果不是目录,查询按钮权限
            elements = permsAuthMapper.permsAuthElement(node.getId(), userId);
            if (0 == elements.size()) {
                continue;
            }

            elements.forEach(item -> {
                if (menuIds.contains(item.getId())) {
                    item.setChecked(true);
                }
            });
            list.addAll(elements);
        }
    }

    /***
     * 递归,查询菜单
     *
     * @author 王大宸
     * @date 2022/8/25 21:15
     * @param list       菜单集合
     * @param menuIds    选中的菜单
     * @param pid        上级菜单id
     * @return void
     */
    private void findValidMenu(List<ZTreeNode> list, List<String> menuIds, String pid) {
        List<ZTreeNode> zTreeNodes = roleMenuMapper.findValidMenu(pid, null);
        List<ZTreeNode> validElement = new ArrayList<>();
        for (ZTreeNode zTreeNode : zTreeNodes) {
            if (menuIds.contains(zTreeNode.getId())) {
                zTreeNode.setChecked(true);
            }
            list.add(zTreeNode);
            // 如果是目录,基础查询菜单
            if (MenuValidConstant.DIRT.equals(zTreeNode.getType())
                    || MenuValidConstant.URI.equals(zTreeNode.getType())) {
                findValidMenu(list, menuIds, zTreeNode.getId());
                continue;
            }
            // 如果不是目录,查询按钮权限
            validElement = roleMenuMapper.findValidElement(zTreeNode.getId(), null);
            if (0 == validElement.size()) {
                continue;
            }

            validElement.forEach(item -> {
                if (menuIds.contains(item.getId())) {
                    item.setChecked(true);
                }
            });
            list.addAll(validElement);
        }
    }

}
