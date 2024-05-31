package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.MenuInfoDTO;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 菜单信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public interface IMenuInfoService extends IBizService< MenuInfoDTO, MenuInfoVO, MenuInfoQuery, String > {

    /***
     * 获取应用菜单树
     *
     * @author 王大宸
     * @date 2024/4/21 21:44
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findAppMenuTree(String appId) throws Exception;

    
    /***
     * 获取目录树
     *
     * @author 王大宸
     * @date 2024/4/24 21:00
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findAppCatalogTree(String appId) throws Exception;

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
