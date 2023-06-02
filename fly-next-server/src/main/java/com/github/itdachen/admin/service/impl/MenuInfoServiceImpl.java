package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.MenuInfoConvert;
import com.github.itdachen.admin.mapper.IAppClientMapper;
import com.github.itdachen.admin.mapper.IElementInfoMapper;
import com.github.itdachen.admin.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.admin.utils.AppClientUtils;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.boot.runner.handler.ContextPathHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.core.utils.UuidUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IMenuInfoMapper;
import com.github.itdachen.admin.service.IMenuInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class MenuInfoServiceImpl extends BizServiceImpl<IMenuInfoMapper, MenuInfo, MenuInfoDto, MenuInfoVo, MenuInfoQuery, String> implements IMenuInfoService {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoServiceImpl.class);
    private static final MenuInfoConvert bizConvert = new MenuInfoConvert();
    private final IAppClientMapper appClientMapper;
    private final IElementInfoMapper elementMapper;

    public MenuInfoServiceImpl(IAppClientMapper appClientMapper, IElementInfoMapper elementMapper) {
        super(bizConvert);
        this.appClientMapper = appClientMapper;
        this.elementMapper = elementMapper;
    }


    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.menuInfoVo>
     */
    @Override
    public TableData<MenuInfoVo> page(MenuInfoQuery params) throws Exception {
        Page<MenuInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<MenuInfoVo> list = bizMapper.page(params);
        if ("NEXT_APP".equals(params.getClientId())) {
            for (MenuInfoVo menuInfoVo : list) {
                menuInfoVo.setChildren(findMenuTree(menuInfoVo.getId()));
            }
        }
        return new TableData<MenuInfoVo>(page.getTotal(), list);
    }

    /***
     * 新增, 添加组件名称
     *
     * @author 王大宸
     * @date 2023/4/6 10:42
     * @param menuInfoDto menuInfoDto
     * @return com.github.itdachen.admin.entity.MenuInfo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MenuInfoVo save(MenuInfoDto menuInfoDto) throws Exception {
        if (StringUtils.isEmpty(menuInfoDto.getName())) {
            menuInfoDto.setName("C" + UuidUtils.generateShortUuid() + "Component");
        }
        verifyClient(menuInfoDto);
        return super.save(menuInfoDto);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2023/4/6 10:44
     * @param menuInfoDto menuInfoDto
     * @return com.github.itdachen.admin.entity.MenuInfo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MenuInfoVo update(MenuInfoDto menuInfoDto) throws Exception {
        if (StringUtils.isEmpty(menuInfoDto.getName())) {
            menuInfoDto.setName("C" + UuidUtils.generateShortUuid() + "Component");
        }
        verifyClient(menuInfoDto);
        return super.update(menuInfoDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int remove(String id) throws Exception {
        elementMapper.remove(id);
        return super.remove(id);
    }

    /***
     * 查询菜单树
     *
     * @author 王大宸
     * @date 2023/4/5 14:27
     * @return java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> zTree() {
        List<ZTreeNode> apps = appClientMapper.findAppAll();
        apps = AppClientUtils.arrangeAppMenu(apps);
        List<ZTreeNode> zTree = bizMapper.findZTree();
        apps.addAll(zTree);
        return apps;
    }

    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 14:27
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.MenuInfoVo
     */
    @Override
    public MenuInfoVo updateStatus(String id, Boolean status) throws BizException {
        MenuInfo menu = new MenuInfo();
        menu.setId(id);
        if (status) {
            menu.setVisible(YesOrNotConstant.YES);
        } else {
            menu.setVisible(YesOrNotConstant.NOT);
        }
        EntityUtils.setUpdatedInfo(menu);
        bizMapper.updateByPrimaryKeySelective(menu);
        return null;
    }

    @Override
    public MenuInfoVo findMenuInfoVo(String id) throws Exception {
        return bizMapper.findMenuInfoVo(id);
    }

    /***
     * 获取目录菜单
     *
     * @author 王大宸
     * @date 2023/4/11 9:54
     * @return java.util.List
     */
    @Override
    public List<ZTreeNode> findCatalogZTree() throws BizException {
        List<ZTreeNode> apps = appClientMapper.findAppAll();
        apps = AppClientUtils.arrangeAppMenu(ContextPathHandler.contextPath(), apps);
        apps.addAll(bizMapper.zTreeCatalog());
        return apps;
    }

    /***
     * 查询上级菜单
     *
     * @author 王大宸
     * @date 2023/4/11 10:16
     * @param parentId parentId
     * @return java.lang.String
     */
    @Override
    public String findMenuParentTitle(String parentId) throws BizException {
        MenuInfo menu = bizMapper.selectByPrimaryKey(parentId);
        if (null != menu) {
            return menu.getTitle();
        }
        String parentTitle = "资源目录";
        AppClientVo appClient = appClientMapper.findAppClient(parentTitle);
        if (null != appClient) {
            parentTitle = appClient.getAppTitle();
        }
        return parentTitle;
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
        List<MenuInfoVo> menuTree = bizMapper.findMenuInfoByParentId(parentId);
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
    
    /***
     * 客户端校验
     *
     * @author 王大宸
     * @date 2023/5/30 14:50
     * @param menuInfoDto menuInfoDto
     * @return void
     */
    private void verifyClient(MenuInfoDto menuInfoDto) throws BizException {
        menuInfoDto.setClientId(menuInfoDto.getParentId());
        AppClientVo appClient = appClientMapper.findAppClient(menuInfoDto.getParentId());
        if (null == appClient) {
            MenuInfo menuInfo = bizMapper.selectByPrimaryKey(menuInfoDto.getParentId());
            if (null == menuInfo) {
                throw new BizException("数据错误, 未找到客户端标识");
            }
            menuInfoDto.setClientId(menuInfo.getClientId());
        }
    }


//    private List<MenuInfoVo> findDirtTree(String parentId) {
//        List<MenuInfoVo> list = bizMapper.findDirtTree(parentId, MenuDirtConstant.DIRT);
//        List<MenuInfoVo> children = null;
//        for (MenuInfoVo menuVo : list) {
//            if (MenuDirtConstant.URI.equals(menuVo.getType()) || MenuDirtConstant.MENU.equals(menuVo.getType())) {
//                continue;
//            }
//            children = findDirtTree(menuVo.getId());
//            if (0 == children.size()) {
//                continue;
//            }
//            menuVo.setChildren(children);
//        }
//        return list;
//    }

}
