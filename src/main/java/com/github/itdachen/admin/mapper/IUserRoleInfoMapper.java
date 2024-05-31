package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.UserRoleInfo;
import com.github.itdachen.admin.sdk.query.UserRoleInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserRoleInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 身份信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public interface IUserRoleInfoMapper extends Mapper<UserRoleInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.userRoleInfoVO
     */
    List<UserRoleInfoVO> list(UserRoleInfoQuery params);

    /***
     * 获取根据用户ID主身份信息
     *
     * @author 王大宸
     * @date 2024/4/27 22:05
     * @param userId userId
     * @return com.github.itdachen.admin.sdk.vo.UserRoleInfoVO
     */
    UserRoleInfoVO findRoleFlag(String userId);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.userRoleInfoVo
     */
    UserRoleInfoVO selectUserRoleInfoVO(String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectUserRoleInfoExpData(UserRoleInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param list java.util.List<com.github.itdachen.admin.entity.UserRoleInfo>
     */
    void batchSave(List<UserRoleInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param list java.util.List<com.github.itdachen.admin.entity.UserRoleInfo>
     */
    void batchUpdate(List<UserRoleInfo> list);

}
