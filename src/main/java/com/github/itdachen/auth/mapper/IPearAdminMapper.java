package com.github.itdachen.auth.mapper;

import com.github.itdachen.auth.entity.PearAdminRoute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * IPearAdminMapper
 *
 * @author 王大宸
 * @date 2024/4/23 23:27
 */
public interface IPearAdminMapper {

    /***
     * 查询所有的菜单
     *
     * @author 王大宸
     * @date 2024/5/23 22:14
     * @param parentId 上级菜单ID
     * @return java.util.List<com.github.itdachen.auth.entity.PearAdminRoute>
     */
    List<PearAdminRoute> findPearAdminMenuAll(String parentId);

    /***
     * 根据菜单ID查询菜单
     *
     * @author 王大宸
     * @date 2024/5/23 22:14
     * @param parentId parentId
     * @param list list
     * @return java.util.List<com.github.itdachen.auth.entity.PearAdminRoute>
     */
    List<PearAdminRoute> findPearAdminMenu(@Param("parentId") String parentId, @Param("list") List<String> list);

}
