package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 部门管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDeptInfoService extends IBizService<DeptInfoDto, DeptInfoVo, DeptInfoQuery, String > {



    /***
     * 获取部门树
     *
     * @author 王大宸
     * @date 2023/4/4 23:46
     * @return java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>
     */
    List<ZTreeNode> zTree() throws BizException;

}
