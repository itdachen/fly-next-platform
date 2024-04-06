package com.github.itdachen.admin_v1.service.impl;

import com.github.itdachen.admin_v1.convert.IRoleInfoConvert;
import com.github.itdachen.admin_v1.entity.RoleInfo;
import com.github.itdachen.admin_v1.mapper.IRoleInfoMapper;
import com.github.itdachen.admin_v1.sdk.dto.RoleInfoDto;
import com.github.itdachen.admin_v1.sdk.query.RoleInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.RoleInfoVo;
import com.github.itdachen.admin_v1.service.IRoleInfoService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
public class RoleInfoServiceImpl extends BizServiceImpl<IRoleInfoMapper, IRoleInfoConvert, RoleInfo, RoleInfoDto, RoleInfoVo, RoleInfoQuery, String> implements IRoleInfoService {
    private static final Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:07
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.RoleInfoVo>
     */
    @Override
    public TableData<RoleInfoVo> page(RoleInfoQuery params) throws Exception {
        Page<RoleInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<RoleInfoVo> list = bizMapper.page(params);
        return new TableData<RoleInfoVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/5 22:28
     * @param roleInfoDto roleInfoDto
     * @return com.github.itdachen.admin.entity.RoleInfo
     */
    @Override
    public RoleInfoVo saveInfo(RoleInfoDto roleInfoDto) throws Exception {
        roleInfoDto.setDeptId(BizContextHandler.getDeptId());
        return super.saveInfo(roleInfoDto);
    }

}
