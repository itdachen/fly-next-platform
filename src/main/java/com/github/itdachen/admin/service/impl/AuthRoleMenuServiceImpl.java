package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AuthRoleMenu;
import com.github.itdachen.admin.sdk.dto.AuthRoleMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthRoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthRoleMenuVO;
import com.github.itdachen.admin.mapper.IAuthRoleMenuMapper;
import com.github.itdachen.admin.service.IAuthRoleMenuService;
import com.github.itdachen.admin.convert.AuthRoleMenuConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 人员身份菜单 业务实现
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
@Service
public class AuthRoleMenuServiceImpl extends BizServiceImpl<IAuthRoleMenuMapper, AuthRoleMenu, AuthRoleMenuDTO, AuthRoleMenuVO, AuthRoleMenuQuery, String> implements IAuthRoleMenuService {
    private static final Logger logger = LoggerFactory.getLogger(AuthRoleMenuServiceImpl.class);
    private static final AuthRoleMenuConvert bizConvert = new AuthRoleMenuConvert();

    public AuthRoleMenuServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-05-15 22:13:44
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.authRoleMenuVo>
     */
    @Override
    public TableData<AuthRoleMenuVO> page(AuthRoleMenuQuery params) throws Exception {
        Page<AuthRoleMenuVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AuthRoleMenuVO> list = bizMapper.list(params);
        return new TableData<AuthRoleMenuVO>(page.getTotal(), list);
    }


    /***
    * 新增
    *
    * @author 王大宸
    * @date 2024/5/17 17:05
     * @param authRoleMenuDTO authRoleMenuDTO
    * @return com.github.itdachen.admin.sdk.vo.AuthRoleMenuVO
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthRoleMenuVO saveInfo(AuthRoleMenuDTO authRoleMenuDTO) throws Exception {
        bizMapper.removeCheckedMenu(authRoleMenuDTO.getAppId(), BizContextHandler.getTenantId(), authRoleMenuDTO.getRoleId());

        List<String> menuIds = new ArrayList<>(Arrays.asList(authRoleMenuDTO.getMeniId().split(",")));
        if (menuIds.isEmpty()) {
            return null;
        }

        List<AuthRoleMenu> list = new ArrayList<>();
        AuthRoleMenu roleMenu;
        for (String menuId : menuIds) {
            roleMenu = new AuthRoleMenu();
            roleMenu.setId(EntityUtils.getId());
            roleMenu.setTenantId(BizContextHandler.getTenantId());
            roleMenu.setAppId(authRoleMenuDTO.getAppId());
            roleMenu.setMeniId(menuId);
            roleMenu.setRoleId(authRoleMenuDTO.getRoleId());
            list.add(roleMenu);
        }
        bizMapper.batchSave(list);
        return null;
    }
}
