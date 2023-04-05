package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IAppClientMapper;
import com.github.itdachen.admin.mapper.IElementInfoMapper;
import com.github.itdachen.admin.utils.AppClientUtils;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
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

import java.awt.*;
import java.util.List;

/**
 * 菜单管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class MenuInfoServiceImpl extends BizServiceImpl<IMenuInfoMapper, MenuInfo, MenuInfoVo, MenuInfoQuery, String> implements IMenuInfoService {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoServiceImpl.class);

    private final IAppClientMapper appClientMapper;
    private final IElementInfoMapper elementMapper;

    public MenuInfoServiceImpl(IAppClientMapper appClientMapper,
                               IElementInfoMapper elementMapper) {
        this.appClientMapper = appClientMapper;
        this.elementMapper = elementMapper;
    }


    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.menuInfoVo>
     */
    @Override
    public TableData<MenuInfoVo> page(MenuInfoQuery params) throws Exception {
        Page<MenuInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<MenuInfoVo> list = bizMapper.page(params);
        return new TableData<MenuInfoVo>(page.getTotal(), list);
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

}
