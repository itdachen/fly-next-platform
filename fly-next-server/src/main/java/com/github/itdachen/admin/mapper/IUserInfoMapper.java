package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户信息 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IUserInfoMapper extends Mapper< UserInfo > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.userInfoVo
     */
    List< UserInfoVo > page(UserInfoQuery params);



    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.UserInfo>
     */
    void  batchSave(List< UserInfo > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.UserInfo>
     */
    void batchUpdate(List< UserInfo > list);

}
