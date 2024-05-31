package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.AuthClazzRole;
import com.github.itdachen.admin.sdk.query.AuthClazzRoleQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzRoleVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 身份岗位管理表 持久层接口
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:14
 */
public interface IAuthClazzRoleMapper extends Mapper<AuthClazzRole> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:14
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.authClazzRoleVO
     */
    List<AuthClazzRoleVO> list(AuthClazzRoleQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:14
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.authClazzRoleVo
     */
    AuthClazzRoleVO selectAuthClazzRoleVO(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:14
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthClazzRole>
     */
    void batchSave(List<AuthClazzRole> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:14
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthClazzRole>
     */
    void batchUpdate(List<AuthClazzRole> list);

    /***
     * 查询已经选择的数据
     *
     * @author 王大宸
     * @date 2024/5/15 21:37
     * @param tenantId tenantId
     * @param roleId roleId
     * @return java.util.List<java.lang.String>
     */
    List<String> findCheckedRole(@Param("tenantId") String tenantId, @Param("roleId") String roleId);


    /***
     * 删除已经选择的数据
     *
     * @author 王大宸
     * @date 2024/5/15 21:58
     * @param tenantId tenantId
     * @param roleId roleId
     * @return void
     */
    void removeCheckedRole(@Param("tenantId") String tenantId, @Param("roleId") String roleId);


}
