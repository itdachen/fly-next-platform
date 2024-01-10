package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 应用管理 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
public interface IAppClientMapper extends Mapper<AppClient> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.appClientVo
     */
    List<AppClientVo> page(AppClientQuery params);

    AppClientVo findAppClient(String appCode);

    /***
     * 查询所有的应用
     *
     * @author 王大宸
     * @date 2023/4/5 14:29
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findAppAll();

    /***
     * 查询该应用是否有菜单
     *
     * @author 王大宸
     * @date 2023/4/5 14:28
     * @param appCode appCode
     * @return java.lang.Integer
     */
    Integer hasMenu(String appCode);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @param list java.util.List<com.github.itdachen.admin.entity.AppClient>
     */
    void batchSave(List<AppClient> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @param list java.util.List<com.github.itdachen.admin.entity.AppClient>
     */
    void batchUpdate(List<AppClient> list);

}
