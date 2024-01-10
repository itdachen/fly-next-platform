package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IPermsAuthConvert;
import com.github.itdachen.admin.entity.PermsAuth;
import com.github.itdachen.admin.manager.ILoadUserMenuManager;
import com.github.itdachen.admin.mapper.IPermsAuthMapper;
import com.github.itdachen.admin.sdk.dto.PermsAuthDto;
import com.github.itdachen.admin.sdk.query.PermsAuthQuery;
import com.github.itdachen.admin.sdk.vo.PermsAuthVo;
import com.github.itdachen.admin.service.IPermsAuthService;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 权限下发 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class PermsAuthServiceImpl extends BizServiceImpl<IPermsAuthMapper, IPermsAuthConvert, PermsAuth, PermsAuthDto, PermsAuthVo, PermsAuthQuery, String> implements IPermsAuthService {
    private static final Logger logger = LoggerFactory.getLogger(PermsAuthServiceImpl.class);
    private final ILoadUserMenuManager loadUserMenuManager;

    public PermsAuthServiceImpl(ILoadUserMenuManager loadUserMenuManager) {
        this.loadUserMenuManager=loadUserMenuManager;
    }


    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:08
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.PermsAuthVo>
     */
    @Override
    public TableData<PermsAuthVo> page(PermsAuthQuery params) throws Exception {
        Page<PermsAuthVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<PermsAuthVo> list = bizMapper.page(params);
        return new TableData<PermsAuthVo>(page.getTotal(), list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PermsAuthVo saveInfo(PermsAuthDto permsAuthDto) throws BizException {

        bizMapper.delete(PermsAuth.builder()
                .userId(permsAuthDto.getUserId())
                .clientId(permsAuthDto.getClientId())
                .build());

        String menuIds = permsAuthDto.getMenuId();
        List<String> menuList = new ArrayList<>(Arrays.asList(menuIds.split(",")));
        if (menuList.isEmpty()) {
            return null;
        }

        PermsAuth one = null;
        List<PermsAuth> list = new ArrayList<>();
        for (String menuId : menuList) {
            if (ZTreeNode.ROOT_ID.equals(menuId)) {
                continue;
            }
            one = new PermsAuth();
            one.setId(EntityUtils.getId());
            one.setMenuId(menuId);
            one.setUserId(permsAuthDto.getUserId());
            one.setClientId(permsAuthDto.getClientId());
            list.add(one);
        }
        bizMapper.batchSave(list);
        return null;
    }

    /***
     * 获取权限下发菜单树数据
     *
     * @author 王大宸
     * @date 2023/4/5 21:21
     * @param userId   被下发用户id
     * @param userType 当前登录账号用户类型
     * @param currentUserId 当前登录用户账号id
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findMenuWithUser(String userId, String userType, String currentUserId) throws Exception {
        List<String> menuIds = bizMapper.findMenuByUser(userId);
        return loadUserMenuManager.findMenuWithUser(menuIds, userType, currentUserId);
    }


}
