package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
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
public class RoleUserServiceImpl extends BizServiceImpl<IRoleUserMapper, RoleUser, RoleUserVo, RoleUserQuery, String> implements IRoleUserService {
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleUser save(RoleUser entity) throws BizException {
        if (null == entity) {
            throw new BizException("用户角色不能为空");
        }
        bizMapper.delete(RoleUser.builder().clientId(entity.getClientId()).userId(entity.getUserId()).build());
        if (StringUtils.isEmpty(entity.getRoleId())) {
            return entity;
        }

        List<String> roleList = new ArrayList<>(Arrays.asList(entity.getRoleId().split(",")));
        if (0 == roleList.size()) {
            return entity;
        }

        RoleUser one = null;
        List<RoleUser> list = new ArrayList<>();
        for (String roleId : roleList) {
            if (ZTreeNode.ROOT_ID.equals(roleId)) {
                continue;
            }
            one = new RoleUser();
            one.setId(EntityUtils.getId());
            one.setUserId(entity.getUserId());
            one.setRoleId(roleId);
            one.setClientId(entity.getClientId());
            list.add(one);
        }
        if (0 < list.size()) {
            bizMapper.batchSave(list);
        }
        return entity;
    }

    @Override
    public List<ZTreeNode> findRoleWithUser(String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            throw new BizException("用户id不能为空");
        }

        List<String> roleIds = bizMapper.findRoleIdByUserId(userId);
        List<ZTreeNode> list = bizMapper.findRoleByDept(BizContextHandler.getDepartId());
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
