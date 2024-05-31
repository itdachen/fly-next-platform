package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.AuthRoleMenu;
import com.github.itdachen.admin.sdk.query.AuthRoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthRoleMenuVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 人员身份菜单 持久层接口
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
public interface IAuthRoleMenuMapper extends Mapper< AuthRoleMenu > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-05-15 22:13:44
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.authRoleMenuVO
     */
    List< AuthRoleMenuVO > list(AuthRoleMenuQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-05-15 22:13:44
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.authRoleMenuVo
     */
        AuthRoleMenuVO selectAuthRoleMenuVO( String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-05-15 22:13:44
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthRoleMenu>
     */
    void  batchSave(List< AuthRoleMenu > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-05-15 22:13:44
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthRoleMenu>
     */
    void batchUpdate(List< AuthRoleMenu > list);


    List<String> findCheckedMenu(@Param("appId") String appId, @Param("tenantId") String tenantId, @Param("roleId") String roleId);

    void removeCheckedMenu(@Param("appId") String appId, @Param("tenantId") String tenantId, @Param("roleId") String roleId);


}
