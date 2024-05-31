package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DeptInfoDTO;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 部门信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public interface IDeptInfoService extends IBizService<DeptInfoDTO, DeptInfoVO, DeptInfoQuery, String> {

    /***
     * 获取部门树信息
     *
     * @author 王大宸
     * @date 2024/4/24 22:32
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findDeptTree() throws Exception;

    /***
     * 获取三级部门信息
     *
     * @author 王大宸
     * @date 2024/5/9 22:56
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findThreeDeptTree() throws Exception;

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;


}
