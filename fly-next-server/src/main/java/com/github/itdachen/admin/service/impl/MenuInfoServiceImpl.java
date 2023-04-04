package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IMenuInfoMapper;
import com.github.itdachen.admin.service.IMenuInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class MenuInfoServiceImpl extends BizServiceImpl< IMenuInfoMapper, MenuInfo,  MenuInfoVo, MenuInfoQuery, String > implements IMenuInfoService {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:46
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.menuInfoVo>
    */
    @Override
    public TableData<MenuInfoVo> page(MenuInfoQuery params) throws Exception {
        Page<MenuInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<MenuInfoVo> list = bizMapper.page(params);
        return new TableData<MenuInfoVo>(page.getTotal(), list);
    }


}
