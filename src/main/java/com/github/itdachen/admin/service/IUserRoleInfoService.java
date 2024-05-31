package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.UserRoleInfoDTO;
import com.github.itdachen.admin.sdk.query.UserRoleInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserRoleInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 身份信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public interface IUserRoleInfoService extends IBizService<UserRoleInfoDTO, UserRoleInfoVO, UserRoleInfoQuery, String> {

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/27 21:27
     * @param id id
     * @param checked checked
     * @return void
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;


    /***
     * 获取部门岗位权限
     *
     * @author 王大宸
     * @date 2024/5/15 20:49
     * @param roleId 人员身份ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> deptClazzTree(String roleId) throws Exception;


}
