package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.AuthClazzMenu;
import com.github.itdachen.admin.mapper.*;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AuthGrantMenu;
import com.github.itdachen.admin.sdk.dto.AuthGrantMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthGrantMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthGrantMenuVO;
import com.github.itdachen.admin.service.IAuthGrantMenuService;
import com.github.itdachen.admin.convert.AuthGrantMenuConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 权限下发 业务实现
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
@Service
public class AuthGrantMenuServiceImpl extends BizServiceImpl<IAuthGrantMenuMapper, AuthGrantMenu, AuthGrantMenuDTO, AuthGrantMenuVO, AuthGrantMenuQuery, String> implements IAuthGrantMenuService {
    private static final Logger logger = LoggerFactory.getLogger(AuthGrantMenuServiceImpl.class);
    private static final AuthGrantMenuConvert bizConvert = new AuthGrantMenuConvert();

    @Autowired
    private IAppInfoMapper appInfoMapper;
    @Autowired
    private AppInfoProperties appInfoProperties;
    @Autowired
    private IMenuInfoMapper menuInfoMapper;
    @Autowired
    private IElementInfoMapper elementInfoMapper;
    @Autowired
    private IAuthClazzMenuMapper authClazzMenuMapper;
    @Autowired
    private IAuthRoleMenuMapper authRoleMenuMapper;

    public AuthGrantMenuServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.authGrantMenuVo>
     */
    @Override
    public TableData<AuthGrantMenuVO> page(AuthGrantMenuQuery params) throws Exception {
        Page<AuthGrantMenuVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AuthGrantMenuVO> list = bizMapper.list(params);
        return new TableData<AuthGrantMenuVO>(page.getTotal(), list);
    }

    @Override
    public AuthGrantMenuVO saveInfo(AuthGrantMenuDTO dto) throws Exception {

        bizMapper.removeCheckedMenu(dto.getAppId(), BizContextHandler.getTenantId(), dto.getUserId());

        List<String> menuIds = new ArrayList<>(Arrays.asList(dto.getMenuId().split(",")));
        if (menuIds.isEmpty()) {
            return null;
        }
        List<AuthGrantMenu> list = new ArrayList<>();
        AuthGrantMenu clazzMenu;
        for (String menuId : menuIds) {
            if (dto.getAppId().equals(menuId)) {
                continue;
            }
            clazzMenu = new AuthGrantMenu();
            clazzMenu.setId(EntityUtils.getId());
            clazzMenu.setTenantId(BizContextHandler.getTenantId());
            clazzMenu.setAppId(StringUtils.isEmpty(dto.getAppId()) ? "" : dto.getAppId());
            clazzMenu.setUserId(dto.getUserId());
            clazzMenu.setMenuId(menuId);
            list.add(clazzMenu);
        }
        bizMapper.batchSave(list);
        return null;
    }

    /***
     * 获取可下发的菜单树
     *
     * @author 王大宸
     * @date 2024/5/15 22:53
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findTreeData(String clazzId, String appId) throws Exception {
        List<String> checkedMenu = authClazzMenuMapper.findCheckedMenu(BizContextHandler.getTenantId(), clazzId);
        return findMenuTreeData(appId, checkedMenu);
    }


    /***
     * 权限下发时, 获取权限信息
     *
     * @author 王大宸
     * @date 2024/5/28 21:28
     * @param roleId roleId
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findLowerTreeData(String roleId, String appId) throws Exception {
        List<String> checkedMenu = bizMapper.findLowerCheckedMenu(appId, BizContextHandler.getTenantId(), roleId);
        return findMenuTreeData(appId, checkedMenu);
    }

    /***
     * 给用户下方权限时获取权限信息
     *
     * @author 王大宸
     * @date 2024/5/17 16:22
     * @param roleId 用户身份ID
     * @param appId  应用ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findGrantMenuTreeData(String roleId, String appId) throws Exception {
        /* 获取该身份已下发的权限 */
        List<String> checkedMenu = bizMapper.findCheckedMenu(appId, BizContextHandler.getTenantId(), roleId);
        return findMenuTreeData(appId, checkedMenu);
    }

    /***
     * 获取人员特殊授权可使用权限
     *
     * @author 王大宸
     * @date 2024/5/17 16:38
     * @param roleId 用户身份ID
     * @param appId  应用ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findRoleMenuTreeData(String roleId, String appId) throws Exception {
        /* 获取该身份已授权的权限 */
        List<String> checkedMenu = authRoleMenuMapper.findCheckedMenu(appId, BizContextHandler.getTenantId(), roleId);
        return findMenuTreeData(appId, checkedMenu);
    }

    /***
     * 获取可使用的菜单
     *
     * @author 王大宸
     * @date 2024/5/17 16:43
     * @param appId  应用ID
     * @param checkedMenu 之前已经选择的菜单ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    private List<ZTreeNode> findMenuTreeData(String appId, List<String> checkedMenu) {
        List<ZTreeNode> list = new ArrayList<>();
        AppInfoVO appInfoVO = appInfoMapper.selectAppInfoVO(appId);
        list.add(new ZTreeNode.Builder().id(appInfoVO.getId()).name(appInfoVO.getAppTitle()).parentId(ZTreeNode.ROOT_PARENT_ID).open(true).build());
        /* 超级管理员, 查询所有 */
        if (YesOrNotConstant.Y.equals(BizContextHandler.getUserType())) {
            List<ZTreeNode> appMenuTree = findAppMenuTree(checkedMenu, appId);
            list.addAll(appMenuTree);
            return list;
        }
        /* 获取可以授权的菜单ID */
        List<String> grantMenuList = bizMapper.findCheckedMenu(appId, BizContextHandler.getTenantId(), BizContextHandler.getRoleId());
        findUserAuthGrantMenu(list, appId, grantMenuList, checkedMenu);
        return list;
    }


    /***
     * 获取用户可下发的菜单
     *
     * @author 王大宸
     * @date 2024/5/24 16:20
     * @param parentId      上级菜单ID
     * @param grantMenuList 可以授权的菜单ID
     * @param checkedMenu   已经选择的菜单ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    private void findUserAuthGrantMenu(List<ZTreeNode> list, String parentId, List<String> grantMenuList, List<String> checkedMenu) {
        List<ZTreeNode> menuTree = menuInfoMapper.findMenuTree(parentId, grantMenuList);
        for (ZTreeNode zTreeNode : menuTree) {
            if (checkedMenu.contains(zTreeNode.getId())) {
                zTreeNode.setChecked(true);
            }
            if ("menu".equals(zTreeNode.getType())) {
                List<ZTreeNode> elementInfoVTree = elementInfoMapper.findElementInfoVTree(zTreeNode.getId(), grantMenuList);
                for (ZTreeNode treeNode : elementInfoVTree) {
                    if (checkedMenu.contains(treeNode.getId())) {
                        treeNode.setChecked(true);
                    }
                }
                list.addAll(elementInfoVTree);
            }
            list.addAll(menuTree);
            findUserAuthGrantMenu(list, zTreeNode.getId(), grantMenuList, checkedMenu);
        }
    }


    /***
     * 获取应用菜单
     *
     * @author 王大宸
     * @date 2024/5/17 16:24
     * @param checkedMenu 已选中的菜单集合
     * @param appId 应用ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    private List<ZTreeNode> findAppMenuTree(List<String> checkedMenu, String appId) {
        List<ZTreeNode> menuZTree = menuInfoMapper.findMenuZTree(appId);
        List<ZTreeNode> elementInfoAllTree = elementInfoMapper.findElementInfoAllTree();
        menuZTree.addAll(elementInfoAllTree);

        for (ZTreeNode zTreeNode : menuZTree) {
            if (checkedMenu.contains(zTreeNode.getId())) {
                zTreeNode.setChecked(true);
            }
        }

        return menuZTree;
    }


}
