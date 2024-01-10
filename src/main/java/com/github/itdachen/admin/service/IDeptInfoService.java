package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * 部门管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDeptInfoService extends IBizService<DeptInfoDto, DeptInfoVo, DeptInfoQuery, String> {


    /***
     * 获取部门树
     *
     * @author 王大宸
     * @date 2023/4/4 23:46
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> zTree() throws BizException;

    /***
     * 获取集合
     *
     * @author 王大宸
     * @date 2023/5/14 22:24
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.DeptInfoVo>
     */
    List<DeptInfoVo> apiDeptInfoList() throws Exception;

    void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
