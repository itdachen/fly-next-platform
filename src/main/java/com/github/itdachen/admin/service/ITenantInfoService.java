package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.TenantInfoDTO;
import com.github.itdachen.admin.sdk.query.TenantInfoQuery;
import com.github.itdachen.admin.sdk.vo.TenantInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 租户/公司信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
public interface ITenantInfoService extends IBizService< TenantInfoDTO, TenantInfoVO, TenantInfoQuery, String > {


    /***
     * 获取树结构
     *
     * @author 王大宸
     * @date 2024/4/24 23:30
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findTenantTree() throws Exception;

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
