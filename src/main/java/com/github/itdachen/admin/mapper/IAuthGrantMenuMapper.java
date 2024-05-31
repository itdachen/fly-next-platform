package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.AuthGrantMenu;
import com.github.itdachen.admin.sdk.query.AuthGrantMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthGrantMenuVO;
import com.github.itdachen.framework.context.BizContextHandler;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 权限下发 持久层接口
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public interface IAuthGrantMenuMapper extends Mapper<AuthGrantMenu> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.authGrantMenuVO
     */
    List<AuthGrantMenuVO> list(AuthGrantMenuQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.authGrantMenuVo
     */
    AuthGrantMenuVO selectAuthGrantMenuVO(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthGrantMenu>
     */
    void batchSave(List<AuthGrantMenu> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthGrantMenu>
     */
    void batchUpdate(List<AuthGrantMenu> list);


    List<String> findCheckedMenu(@Param("appId") String appId, @Param("tenantId") String tenantId, @Param("roleId") String roleId);

    void removeCheckedMenu(@Param("appId") String appId, @Param("tenantId") String tenantId, @Param("roleId") String roleId);


    /***
     * 权限下发时, 获取已下放的权限信息
     *
     * @author 王大宸
     * @date 2024/5/28 21:30
     * @param appId appId
     * @param tenantId tenantId
     * @param roleId roleId
     * @return java.util.List<java.lang.String>
     */
    List<String> findLowerCheckedMenu(@Param("appId") String appId, @Param("tenantId") String tenantId, @Param("roleId") String roleId);


}
