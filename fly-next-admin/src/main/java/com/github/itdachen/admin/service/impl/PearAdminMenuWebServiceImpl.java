package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IPearAdminMenuWebMapper;
import com.github.itdachen.admin.service.IPearAdminMenuWebService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.admin.entity.PearAdminMenu;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/07 0:18
 * Created with IntelliJ IDEA.
 */
@Service
public class PearAdminMenuWebServiceImpl implements IPearAdminMenuWebService {
    private final IPearAdminMenuWebMapper pearAdminMenuWebMapper;

    public PearAdminMenuWebServiceImpl(IPearAdminMenuWebMapper pearAdminMenuWebMapper) {
        this.pearAdminMenuWebMapper = pearAdminMenuWebMapper;
    }

    @Override
    public List<PearAdminMenu> findPearAdminMenu(HttpServletRequest request,
                                                 String client) throws Exception {
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(BizContextHandler.getUserType())) {
            return findMenuAll(client);
        }
        return getChildrenMenu(client, BizContextHandler.getUserId());
    }

    private List<PearAdminMenu> findMenuAll(String parentId) {
        List<PearAdminMenu> menus = pearAdminMenuWebMapper.findMenuAll(parentId);
        List<PearAdminMenu> children = new ArrayList<>();
        for (PearAdminMenu map : menus) {
            children = findMenuAll(String.valueOf(map.getId()));
            if (0 == children.size()) {
                continue;
            }
            map.setChildren(children);
        }
        return menus;
    }

    private List<PearAdminMenu> getChildrenMenu(String parentId, String userId) {
        List<PearAdminMenu> menus = pearAdminMenuWebMapper.findChildrenMenu(parentId, userId);
        List<PearAdminMenu> children = new ArrayList<>();
        for (PearAdminMenu map : menus) {
            children = getChildrenMenu(String.valueOf(map.getId()), userId);
            if (0 == children.size()) {
                continue;
            }
            map.setChildren(children);
        }
        return menus;
    }

    private void pearAdminMenuHandler(PearAdminMenu adminMenu){

    }

}
