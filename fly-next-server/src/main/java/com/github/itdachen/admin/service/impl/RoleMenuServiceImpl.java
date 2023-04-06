package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IAppClientMapper;
import com.github.itdachen.admin.mapper.IPermsAuthMapper;
import com.github.itdachen.admin.utils.LoadUserMenuUtils;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.RoleMenu;
import com.github.itdachen.admin.sdk.query.RoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IRoleMenuMapper;
import com.github.itdachen.admin.service.IRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 菜单角色 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class RoleMenuServiceImpl extends BizServiceImpl<IRoleMenuMapper, RoleMenu, RoleMenuVo, RoleMenuQuery, String> implements IRoleMenuService {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

    private final IAppClientMapper appClientMapper;
    private final IPermsAuthMapper permsAuthMapper;

    public RoleMenuServiceImpl(IAppClientMapper appClientMapper,
                               IPermsAuthMapper permsAuthMapper) {
        this.appClientMapper = appClientMapper;
        this.permsAuthMapper = permsAuthMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.roleMenuVo>
     */
    @Override
    public TableData<RoleMenuVo> page(RoleMenuQuery params) throws Exception {
        Page<RoleMenuVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<RoleMenuVo> list = bizMapper.page(params);
        return new TableData<RoleMenuVo>(page.getTotal(), list);
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022/8/25 22:02
     * @param entity entity
     * @return com.itdachen.admin.entity.RoleMenu
     */
    @Override
    public RoleMenu save(RoleMenu entity) throws BizException {
        if (null == entity) {
            throw new BizException("添加的角色菜单不能为空");
        }
        bizMapper.delete(RoleMenu.builder()
                .clientId(entity.getClientId())
                .roleId(entity.getRoleId())
                .build());

        if (StringUtils.isEmpty(entity.getMenuId())) {
            return entity;
        }

        String menuIds = entity.getMenuId();
        List<String> menuList = new ArrayList<>(Arrays.asList(menuIds.split(",")));
        if (0 == menuList.size()) {
            return entity;
        }

        RoleMenu one = null;
        List<RoleMenu> list = new ArrayList<>();
        for (String menuId : menuList) {
            if (ZTreeNode.ROOT_ID.equals(menuId)) {
                continue;
            }
            one = new RoleMenu();
            one.setId(EntityUtils.getId());
            one.setMenuId(menuId);
            one.setRoleId(entity.getRoleId());
            one.setClientId(entity.getClientId());
            list.add(one);
        }
        bizMapper.batchSave(list);
        return entity;
    }

    /***
     * 获取菜单树
     *
     * @author 王大宸
     * @date 2023/4/5 21:49
     * @param roleId roleId
     * @param userType userType
     * @param userId userId
     * @return java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> roleMenuTreeData(String roleId, String userType, String userId) throws BizException {
        List<String> menuIds = bizMapper.findMenuByRoleId(roleId);
        LoadUserMenuUtils utils = new LoadUserMenuUtils(appClientMapper, permsAuthMapper, bizMapper);
        return utils.findMenuWithUser(menuIds, userType, userId);
    }
}
