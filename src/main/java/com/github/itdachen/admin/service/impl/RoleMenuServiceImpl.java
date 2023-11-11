package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IRoleMenuConvert;
import com.github.itdachen.admin.entity.RoleMenu;
import com.github.itdachen.admin.manager.ILoadUserMenuManager;
import com.github.itdachen.admin.mapper.IElementInfoMapper;
import com.github.itdachen.admin.mapper.IMenuInfoMapper;
import com.github.itdachen.admin.mapper.IRoleMenuMapper;
import com.github.itdachen.admin.sdk.dto.RoleMenuDto;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.query.RoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.admin.service.IRoleMenuService;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.node.TreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
public class RoleMenuServiceImpl extends BizServiceImpl<IRoleMenuMapper, IRoleMenuConvert, RoleMenu, RoleMenuDto, RoleMenuVo, RoleMenuQuery, String> implements IRoleMenuService {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

    private final IMenuInfoMapper menuInfoMapper;
    private final IElementInfoMapper elementMapper;
    private final ILoadUserMenuManager loadUserMenuManager;

    public RoleMenuServiceImpl(IMenuInfoMapper menuInfoMapper,
                               IElementInfoMapper elementMapper,
                               ILoadUserMenuManager loadUserMenuManager) {
        this.menuInfoMapper = menuInfoMapper;
        this.elementMapper = elementMapper;
        this.loadUserMenuManager=loadUserMenuManager;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.roleMenuVo>
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
     * @param roleMenuDto roleMenuDto
     * @return com.itdachen.admin.entity.RoleMenu
     */
    @Override
    public RoleMenuVo save(RoleMenuDto roleMenuDto) throws BizException {
        if (null == roleMenuDto) {
            throw new BizException("添加的角色菜单不能为空");
        }
        bizMapper.delete(RoleMenu.builder()
                .clientId(roleMenuDto.getClientId())
                .roleId(roleMenuDto.getRoleId())
                .build());

        if (StringUtils.isEmpty(roleMenuDto.getMenuId())) {
            return null;
        }

        String menuIds = roleMenuDto.getMenuId();
        List<String> menuList = new ArrayList<>(Arrays.asList(menuIds.split(",")));
        if (0 == menuList.size()) {
            return null;
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
            one.setRoleId(roleMenuDto.getRoleId());
            one.setClientId(roleMenuDto.getClientId());
            list.add(one);
        }
        bizMapper.batchSave(list);
        return null;
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
        return loadUserMenuManager.findMenuWithUser(menuIds, userType, userId);
    }

    /***
     * 获取权限树数据
     *
     * @author 王大宸
     * @date 2023/5/15 21:51
     * @param roleId roleId
     * @return java.util.List<com.github.itdachen.framework.context.node.TreeNode>
     */
    @Override
    public TreeNode<MenuInfoVo, String> roleMenuElTreeData(String roleId) {
        MenuInfoQuery params = MenuInfoQuery.builder()
                .clientId("NEXT_APP")
                .parentId("NEXT_APP")
                .build();
        List<MenuInfoVo> list = menuInfoMapper.page(params);
        if ("NEXT_APP".equals(params.getClientId())) {
            for (MenuInfoVo menuInfoVo : list) {
                menuInfoVo.setChildren(findMenuTree(menuInfoVo.getId()));
            }
        }
        List<String> menuIds = bizMapper.findMenuByRoleId(roleId);
        return new TreeNode<MenuInfoVo, String>(list, menuIds);
    }

    /***
     * 递归获取菜单树
     *
     * @author 王大宸
     * @date 2022/6/23 9:27
     * @param parentId   上级id
     * @return java.util.List<com.itdachen.admin.sdk.vo.SysMenuVo>
     */
    private List<MenuInfoVo> findMenuTree(String parentId) {
        List<MenuInfoVo> menuTree = menuInfoMapper.findMenuInfoByParentId(parentId);
        List<MenuInfoVo> children = null;
        for (MenuInfoVo menuVo : menuTree) {
            if ("uri".equals(menuVo.getType())) {
                continue;
            }
            if ("menu".equals(menuVo.getType())) {
                menuVo.setChildren(elementMapper.findElementInfo(menuVo.getId()));
                continue;
            }
            children = findMenuTree(menuVo.getId());
            if (0 == children.size()) {
                continue;
            }
            menuVo.setChildren(children);
        }
        return menuTree;
    }


}
