package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import com.github.itdachen.framework.context.node.TreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 岗位信息 业务接口
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
public interface IPositionInfoService extends IBizService< PositionInfoDto, PositionInfoVo, PositionInfoQuery, String > {
    
    /***
     * 根据部门查询岗位
     *
     * @author 王大宸
     * @date 2023/5/16 22:46
     * @param deptId deptId
     * @return com.github.itdachen.framework.context.node.TreeNode<com.github.itdachen.admin.sdk.vo.MenuInfoVo,java.lang.String>
     */
    TreeNode<PositionInfoVo, String> findPositionByDept(String deptId,String identityId) throws Exception;

}
