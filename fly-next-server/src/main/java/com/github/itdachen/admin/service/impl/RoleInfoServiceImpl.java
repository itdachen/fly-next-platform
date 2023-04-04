package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.RoleInfo;
import com.github.itdachen.admin.sdk.query.RoleInfoQuery;
import com.github.itdachen.admin.sdk.vo.RoleInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IRoleInfoMapper;
import com.github.itdachen.admin.service.IRoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class RoleInfoServiceImpl extends BizServiceImpl< IRoleInfoMapper, RoleInfo,  RoleInfoVo, RoleInfoQuery, String > implements IRoleInfoService {
    private static final Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:46
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.roleInfoVo>
    */
    @Override
    public TableData<RoleInfoVo> page(RoleInfoQuery params) throws Exception {
        Page<RoleInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<RoleInfoVo> list = bizMapper.page(params);
        return new TableData<RoleInfoVo>(page.getTotal(), list);
    }

}
