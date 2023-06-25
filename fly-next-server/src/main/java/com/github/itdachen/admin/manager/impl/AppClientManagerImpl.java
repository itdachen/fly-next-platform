package com.github.itdachen.admin.manager.impl;

import com.github.itdachen.admin.manager.IAppClientManager;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.boot.runner.handler.ContextPathHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023-06-25 20:02
 * Created with IntelliJ IDEA.
 */
@Component
public class AppClientManagerImpl implements IAppClientManager {

    @Override
    public List<ZTreeNode> arrangeAppMenu(List<ZTreeNode> apps) {
        return arrangeAppMenu(ContextPathHandler.contextPath(), apps);
    }

    @Override
    public List<ZTreeNode> arrangeAppMenu(String contextPath, List<ZTreeNode> apps) {
        if (null == apps || 0 == apps.size()) {
            apps = new ArrayList<>();
            apps.add(addRootZTreeNode(contextPath, "请选择菜单"));
            return apps;
        }

        apps.forEach(item -> {
            item.setOpen(true);
            item.setIconOpen(contextPath + ZTreeNode.zTreeOpenIcon);
            item.setIconClose(contextPath + ZTreeNode.zTreeCloseIcon);
        });

        if (1 < apps.size()) {
            apps.add(addRootZTreeNode(contextPath, "请选择菜单"));
        }

        return apps;
    }

    @Override
    public ZTreeNode addRootZTreeNode(String contextPath, String rootName) {
        return new ZTreeNode.Builder()
                .id(ZTreeNode.ROOT_ID)
                .name(rootName)
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(contextPath + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(contextPath + ZTreeNode.zTreeJiGuoIcon)
                .build();
    }

}
