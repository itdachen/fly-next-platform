package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IRoleUserConvert;
import com.github.itdachen.admin.entity.RoleUser;
import com.github.itdachen.admin.mapper.IRoleUserMapper;
import com.github.itdachen.admin.sdk.dto.RoleUserDto;
import com.github.itdachen.admin.sdk.query.RoleUserQuery;
import com.github.itdachen.admin.sdk.vo.RoleUserVo;
import com.github.itdachen.admin.service.IRoleUserService;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户角色 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class RoleUserServiceImpl extends BizServiceImpl<IRoleUserMapper, IRoleUserConvert, RoleUser, RoleUserDto, RoleUserVo, RoleUserQuery, String> implements IRoleUserService {
    private static final Logger logger = LoggerFactory.getLogger(RoleUserServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:10
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.RoleUserVo>
     */
    @Override
    public TableData<RoleUserVo> page(RoleUserQuery params) throws Exception {
        Page<RoleUserVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<RoleUserVo> list = bizMapper.page(params);
        return new TableData<RoleUserVo>(page.getTotal(), list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleUserVo saveInfo(RoleUserDto roleUserDto) throws BizException {
        if (null == roleUserDto) {
            throw new BizException("用户角色不能为空");
        }
        bizMapper.delete(RoleUser.builder().clientId(roleUserDto.getClientId()).userId(roleUserDto.getUserId()).build());
        if (StringUtils.isEmpty(roleUserDto.getRoleId())) {
            return null;
        }

        List<String> roleList = new ArrayList<>(Arrays.asList(roleUserDto.getRoleId().split(",")));
        if (roleList.isEmpty()) {
            return null;
        }

        RoleUser one = null;
        List<RoleUser> list = new ArrayList<>();
        for (String roleId : roleList) {
            if (ZTreeNode.ROOT_ID.equals(roleId)) {
                continue;
            }
            one = new RoleUser();
            one.setId(EntityUtils.getId());
            one.setUserId(roleUserDto.getUserId());
            one.setRoleId(roleId);
            one.setClientId(roleUserDto.getClientId());
            list.add(one);
        }
        if (!list.isEmpty()) {
            bizMapper.batchSave(list);
        }
        return null;
    }

    @Override
    public List<ZTreeNode> findRoleWithUser(String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            throw new BizException("用户id不能为空");
        }

        List<String> roleIds = bizMapper.findRoleIdByUserId(userId);
        List<ZTreeNode> list = bizMapper.findRoleByDept(BizContextHandler.getDeptId());
        for (ZTreeNode treeNode : list) {
            if (roleIds.contains(treeNode.getId())) {
                treeNode.setChecked(true);
            }
        }
        list.add(new ZTreeNode.Builder()
                .id(ZTreeNode.ROOT_ID)
                .name("请选择角色")
                .parentId("0")
                .open(true)
                .openIcon(ZTreeNode.zTreeBuMenIcon)
                .closeIcon(ZTreeNode.zTreeJiGuoIcon)
                .build());
        return list;
    }


}
