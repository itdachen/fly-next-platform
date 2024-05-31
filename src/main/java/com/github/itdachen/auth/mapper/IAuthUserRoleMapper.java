package com.github.itdachen.auth.mapper;

import com.github.itdachen.framework.context.tree.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 根据用户ID获取身份信息
 *
 * @author 王大宸
 * @date 2024/5/7 21:04
 */
public interface IAuthUserRoleMapper {

    List<ZTreeNode> findAuthUserRole(@Param("userId") String userId, @Param("tenantId") String tenantId);


}
