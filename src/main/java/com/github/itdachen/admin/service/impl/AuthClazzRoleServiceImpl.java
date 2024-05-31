package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AuthClazzRole;
import com.github.itdachen.admin.sdk.dto.AuthClazzRoleDTO;
import com.github.itdachen.admin.sdk.query.AuthClazzRoleQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzRoleVO;
import com.github.itdachen.admin.mapper.IAuthClazzRoleMapper;
import com.github.itdachen.admin.service.IAuthClazzRoleService;
import com.github.itdachen.admin.convert.AuthClazzRoleConvert;
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
 * 身份岗位管理表 业务实现
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:14
 */
@Service
public class AuthClazzRoleServiceImpl extends BizServiceImpl<IAuthClazzRoleMapper, AuthClazzRole, AuthClazzRoleDTO, AuthClazzRoleVO, AuthClazzRoleQuery, String> implements IAuthClazzRoleService {
    private static final Logger logger = LoggerFactory.getLogger(AuthClazzRoleServiceImpl.class);
    private static final AuthClazzRoleConvert bizConvert = new AuthClazzRoleConvert();

    public AuthClazzRoleServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:14
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.authClazzRoleVo>
     */
    @Override
    public TableData<AuthClazzRoleVO> page(AuthClazzRoleQuery params) throws Exception {
        Page<AuthClazzRoleVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AuthClazzRoleVO> list = bizMapper.list(params);
        return new TableData<AuthClazzRoleVO>(page.getTotal(), list);
    }


    /***
     * 添加
     *
     * @author 王大宸
     * @date 2024/5/15 21:52
     * @param dto dto
     * @return com.github.itdachen.admin.sdk.vo.AuthClazzRoleVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthClazzRoleVO saveInfo(AuthClazzRoleDTO dto) throws Exception {
        bizMapper.removeCheckedRole(BizContextHandler.getTenantId(), dto.getRoleId());

        List<String> clazzIds = new ArrayList<>(Arrays.asList(dto.getClazzId().split(",")));
        if (clazzIds.isEmpty()) {
            return null;
        }

        List<AuthClazzRole> list = new ArrayList<>();
        AuthClazzRole role;
        for (String clazzId : clazzIds) {
            role = new AuthClazzRole();
            role.setId(EntityUtils.getId());
            role.setRoleId(dto.getRoleId());
            role.setClazzId(clazzId);
            role.setTenantId(BizContextHandler.getTenantId());
            list.add(role);
        }

        bizMapper.batchSave(list);
        return null;
    }
}
