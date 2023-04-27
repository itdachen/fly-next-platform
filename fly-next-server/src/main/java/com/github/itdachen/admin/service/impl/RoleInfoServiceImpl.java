package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.PermsAuthConvert;
import com.github.itdachen.admin.convert.RoleInfoConvert;
import com.github.itdachen.admin.sdk.dto.RoleInfoDto;
import com.github.itdachen.framework.context.BizContextHandler;
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
public class RoleInfoServiceImpl extends BizServiceImpl< RoleInfo, RoleInfoDto,  RoleInfoVo, RoleInfoQuery, String > implements IRoleInfoService {
    private static final Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);
    private static final RoleInfoConvert bizConvert = new RoleInfoConvert();
    private final IRoleInfoMapper bizMapper;

    public RoleInfoServiceImpl(IRoleInfoMapper bizMapper) {
        super(bizMapper, bizConvert);
        this.bizMapper = bizMapper;
    }


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
    public RoleInfoVo save(RoleInfoDto roleInfoDto) throws Exception {
        roleInfoDto.setDeptId(BizContextHandler.getDeptId());
        return super.save(roleInfoDto);
    }

}
