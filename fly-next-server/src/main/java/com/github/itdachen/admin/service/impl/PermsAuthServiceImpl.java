package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.PermsAuth;
import com.github.itdachen.admin.sdk.query.PermsAuthQuery;
import com.github.itdachen.admin.sdk.vo.PermsAuthVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IPermsAuthMapper;
import com.github.itdachen.admin.service.IPermsAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限下发 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class PermsAuthServiceImpl extends BizServiceImpl< IPermsAuthMapper, PermsAuth,  PermsAuthVo, PermsAuthQuery, String > implements IPermsAuthService {
    private static final Logger logger = LoggerFactory.getLogger(PermsAuthServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:46
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.permsAuthVo>
    */
    @Override
    public TableData<PermsAuthVo> page(PermsAuthQuery params) throws Exception {
        Page<PermsAuthVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<PermsAuthVo> list = bizMapper.page(params);
        return new TableData<PermsAuthVo>(page.getTotal(), list);
    }


}
