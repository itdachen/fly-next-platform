package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IAppClientMapper;
import com.github.itdachen.admin.service.IAppClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
@Service
public class AppClientServiceImpl extends BizServiceImpl< IAppClientMapper, AppClient,  AppClientVo, AppClientQuery, String > implements IAppClientService {
    private static final Logger logger = LoggerFactory.getLogger(AppClientServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:26:23
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.appClientVo>
    */
    @Override
    public TableData<AppClientVo> page(AppClientQuery params) throws Exception {
        Page<AppClientVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AppClientVo> list = bizMapper.page(params);
        return new TableData<AppClientVo>(page.getTotal(), list);
    }


}
