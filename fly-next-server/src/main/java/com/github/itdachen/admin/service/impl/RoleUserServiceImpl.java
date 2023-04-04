package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.RoleUser;
import com.github.itdachen.admin.sdk.query.RoleUserQuery;
import com.github.itdachen.admin.sdk.vo.RoleUserVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IRoleUserMapper;
import com.github.itdachen.admin.service.IRoleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class RoleUserServiceImpl extends BizServiceImpl< IRoleUserMapper, RoleUser,  RoleUserVo, RoleUserQuery, String > implements IRoleUserService {
    private static final Logger logger = LoggerFactory.getLogger(RoleUserServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:46
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.roleUserVo>
    */
    @Override
    public TableData<RoleUserVo> page(RoleUserQuery params) throws Exception {
        Page<RoleUserVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<RoleUserVo> list = bizMapper.page(params);
        return new TableData<RoleUserVo>(page.getTotal(), list);
    }


}
