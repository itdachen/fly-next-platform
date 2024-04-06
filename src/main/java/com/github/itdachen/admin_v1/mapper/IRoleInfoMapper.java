package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.RoleInfo;
import com.github.itdachen.admin_v1.sdk.query.RoleInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.RoleInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 角色 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IRoleInfoMapper extends Mapper<RoleInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.roleInfoVo
     */
    List<RoleInfoVo> page(RoleInfoQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.RoleInfo>
     */
    void batchSave(List<RoleInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.RoleInfo>
     */
    void batchUpdate(List<RoleInfo> list);

}
