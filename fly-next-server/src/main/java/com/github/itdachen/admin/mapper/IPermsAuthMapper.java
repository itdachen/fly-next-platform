package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.PermsAuth;
import com.github.itdachen.admin.sdk.query.PermsAuthQuery;
import com.github.itdachen.admin.sdk.vo.PermsAuthVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限下发 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IPermsAuthMapper extends Mapper<PermsAuth> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.permsAuthVo
     */
    List<PermsAuthVo> page(PermsAuthQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.PermsAuth>
     */
    void batchSave(List<PermsAuth> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.PermsAuth>
     */
    void batchUpdate(List<PermsAuth> list);

    List<String> findMenuByUser(String userId);

    List<ZTreeNode> getPermsAuthApp(String userId);

    List<ZTreeNode> permsAuthMenu(String parentId, String userId);

    List<ZTreeNode> permsAuthElement(String menuId, String userId);

}
