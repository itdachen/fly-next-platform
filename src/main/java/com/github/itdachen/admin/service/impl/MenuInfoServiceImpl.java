package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IAppInfoMapper;
import com.github.itdachen.admin.mapper.IElementInfoMapper;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.dto.MenuInfoDTO;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVO;
import com.github.itdachen.admin.mapper.IMenuInfoMapper;
import com.github.itdachen.admin.service.IMenuInfoService;
import com.github.itdachen.admin.convert.MenuInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
@Service
public class MenuInfoServiceImpl extends BizServiceImpl<IMenuInfoMapper, MenuInfo, MenuInfoDTO, MenuInfoVO, MenuInfoQuery, String> implements IMenuInfoService {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoServiceImpl.class);
    private static final MenuInfoConvert bizConvert = new MenuInfoConvert();


    private final AppInfoProperties appInfoProperties;
    private final IAppInfoMapper appInfoMapper;
    private final IElementInfoMapper elementInfoMapper;

    public MenuInfoServiceImpl(IAppInfoMapper appInfoMapper, AppInfoProperties appInfoProperties, IElementInfoMapper elementInfoMapper) {
        super(bizConvert);
        this.appInfoMapper = appInfoMapper;
        this.appInfoProperties = appInfoProperties;
        this.elementInfoMapper = elementInfoMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.menuInfoVo>
     */
    @Override
    public TableData<MenuInfoVO> page(MenuInfoQuery params) throws Exception {
        Page<MenuInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<MenuInfoVO> list = bizMapper.list(params);
        return new TableData<MenuInfoVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/4/22 0:03
     * @param menuInfoDTO menuInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.MenuInfoVO
     */
    @Override
    public MenuInfoVO saveInfo(MenuInfoDTO menuInfoDTO) throws Exception {
        setParentInfo(menuInfoDTO);
        return super.saveInfo(menuInfoDTO);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2024/4/22 0:03
     * @param menuInfoDTO menuInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.MenuInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MenuInfoVO updateInfo(MenuInfoDTO menuInfoDTO) throws Exception {
        MenuInfoVO menuInfoVO = bizMapper.selectMenuInfoVO(menuInfoDTO.getId());
        menuInfoDTO.setAppId(menuInfoVO.getAppId());
        setParentInfo(menuInfoDTO);
        MenuInfo menuInfo = bizConvert.toJavaObject(menuInfoDTO);
        EntityUtils.setUpdatedInfo(menuInfo);
        bizMapper.updateByPrimaryKeySelective(menuInfo);

        /* 更新菜单/按钮名称 */
        bizMapper.updateParentTitle(menuInfoDTO);
        elementInfoMapper.updateMenuTitle(menuInfoDTO);

        return bizConvert.toJavaObjectVO(menuInfoDTO);
    }

    /***
     * 添加上级菜单名称
     *
     * @author 王大宸
     * @date 2024/4/24 21:26
     * @param menuInfoDTO menuInfoDTO
     * @return void
     */
    private void setParentInfo(MenuInfoDTO menuInfoDTO) {
        String parentTitle = "";
        MenuInfoVO menuInfoVO = bizMapper.selectMenuInfoVO(menuInfoDTO.getParentId());
        if (null == menuInfoVO) {
            AppInfoVO appInfoVO = appInfoMapper.selectAppInfoVO(menuInfoDTO.getAppId());
            parentTitle = appInfoVO.getAppTitle();
        } else {
            parentTitle = menuInfoVO.getTitle();
        }
        menuInfoDTO.setParentTitle(parentTitle);
        menuInfoDTO.setAskUri(menuInfoDTO.getPath());
    }

    /***
     * 获取应用菜单树
     *
     * @author 王大宸
     * @date 2024/4/21 21:44
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findAppMenuTree(String appId) throws Exception {
        AppInfoVO appInfoVO = appInfoMapper.selectAppInfoVO(appId);
        List<ZTreeNode> list = new ArrayList<>();
        list.add(new ZTreeNode.Builder()
                .id(appInfoVO.getId())
                .name(appInfoVO.getAppTitle())
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeJiGuoIcon)
                .build());

        List<ZTreeNode> menuZTree = bizMapper.findMenuZTree(appId);
        menuZTree.forEach(item -> {
            item.setOpen(true);
            item.setIconOpen(appInfoProperties.getContextPath() + ZTreeNode.zTreeOpenIcon);
            item.setIconClose(appInfoProperties.getContextPath() + ZTreeNode.zTreeCloseIcon);
        });
        list.addAll(menuZTree);
        return list;
    }

    /***
     * 获取目录树
     *
     * @author 王大宸
     * @date 2024/4/24 20:57
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findAppCatalogTree(String appId) throws Exception {
        AppInfoVO appInfoVO = appInfoMapper.selectAppInfoVO(appId);
        List<ZTreeNode> list = new ArrayList<>();
        list.add(new ZTreeNode.Builder()
                .id(appInfoVO.getId())
                .name(appInfoVO.getAppTitle())
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeJiGuoIcon)
                .build());

        list.addAll(bizMapper.findAppCatalogTree(appId));
        return list;
    }


    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setId(id);
        menuInfo.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(menuInfo);
    }

}
