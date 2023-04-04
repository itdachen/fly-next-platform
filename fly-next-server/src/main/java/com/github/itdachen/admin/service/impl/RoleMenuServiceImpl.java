package com.github.itdachen.admin.service.impl;

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

import java.util.List;

/**
 * 菜单角色 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class RoleMenuServiceImpl extends BizServiceImpl< IRoleMenuMapper, RoleMenu,  RoleMenuVo, RoleMenuQuery, String > implements IRoleMenuService {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

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


}
