package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.AuthClazzMenu;
import com.github.itdachen.admin.sdk.query.AuthClazzMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzMenuVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 岗位菜单 持久层接口
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public interface IAuthClazzMenuMapper extends Mapper<AuthClazzMenu> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.authClazzMenuVO
     */
    List<AuthClazzMenuVO> list(AuthClazzMenuQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.authClazzMenuVo
     */
    AuthClazzMenuVO selectAuthClazzMenuVO(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthClazzMenu>
     */
    void batchSave(List<AuthClazzMenu> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @param list java.util.List<com.github.itdachen.admin.entity.AuthClazzMenu>
     */
    void batchUpdate(List<AuthClazzMenu> list);


    /***
     * 查询已经选择的数据
     *
     * @author 王大宸
     * @date 2024/5/15 21:37
     * @param tenantId tenantId
     * @param clazzCode clazzCode
     * @return java.util.List<java.lang.String>
     */
    List<String> findCheckedMenu(@Param("tenantId") String tenantId, @Param("clazzCode") String clazzCode);


    /***
     * 删除已经选择的数据
     *
     * @author 王大宸
     * @date 2024/5/15 21:58
     * @param tenantId tenantId
     * @param clazzCode clazzCode
     * @return void
     */
    void removeCheckedMenu(@Param("tenantId") String tenantId, @Param("clazzCode") String clazzCode);


}
