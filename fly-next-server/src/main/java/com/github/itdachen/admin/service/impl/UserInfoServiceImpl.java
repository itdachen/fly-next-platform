package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.admin.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class UserInfoServiceImpl extends BizServiceImpl< IUserInfoMapper, UserInfo,  UserInfoVo, UserInfoQuery, String > implements IUserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:46
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.userInfoVo>
    */
    @Override
    public TableData<UserInfoVo> page(UserInfoQuery params) throws Exception {
        Page<UserInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<UserInfoVo> list = bizMapper.page(params);
        return new TableData<UserInfoVo>(page.getTotal(), list);
    }


}
