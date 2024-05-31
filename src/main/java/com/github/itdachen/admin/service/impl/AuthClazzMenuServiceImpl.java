package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AuthClazzMenu;
import com.github.itdachen.admin.sdk.dto.AuthClazzMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthClazzMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzMenuVO;
import com.github.itdachen.admin.mapper.IAuthClazzMenuMapper;
import com.github.itdachen.admin.service.IAuthClazzMenuService;
import com.github.itdachen.admin.convert.AuthClazzMenuConvert;
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
 * 岗位菜单 业务实现
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
@Service
public class AuthClazzMenuServiceImpl extends BizServiceImpl<IAuthClazzMenuMapper, AuthClazzMenu, AuthClazzMenuDTO, AuthClazzMenuVO, AuthClazzMenuQuery, String> implements IAuthClazzMenuService {
    private static final Logger logger = LoggerFactory.getLogger(AuthClazzMenuServiceImpl.class);
    private static final AuthClazzMenuConvert bizConvert = new AuthClazzMenuConvert();

    public AuthClazzMenuServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.authClazzMenuVo>
     */
    @Override
    public TableData<AuthClazzMenuVO> page(AuthClazzMenuQuery params) throws Exception {
        Page<AuthClazzMenuVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AuthClazzMenuVO> list = bizMapper.list(params);
        return new TableData<AuthClazzMenuVO>(page.getTotal(), list);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthClazzMenuVO saveInfo(AuthClazzMenuDTO dto) throws Exception {
        bizMapper.removeCheckedMenu(BizContextHandler.getTenantId(), dto.getClazzId());

        List<String> menuIds = new ArrayList<>(Arrays.asList(dto.getMeniId().split(",")));
        if (menuIds.isEmpty()) {
            return null;
        }
        List<AuthClazzMenu> list = new ArrayList<>();
        AuthClazzMenu clazzMenu;
        for (String menuId : menuIds) {
            if (menuId.equals(dto.getAppId())) {
                continue;
            }
            clazzMenu = new AuthClazzMenu();
            clazzMenu.setId(EntityUtils.getId());
            clazzMenu.setTenantId(BizContextHandler.getTenantId());
            clazzMenu.setAppId(StringUtils.isEmpty(dto.getAppId()) ? "" : dto.getAppId());
            clazzMenu.setClazzId(dto.getClazzId());
            clazzMenu.setMeniId(menuId);
            list.add(clazzMenu);
        }
        bizMapper.batchSave(list);
        return null;
    }


}
