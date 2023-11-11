package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.UserLogin;
import com.github.itdachen.admin.sdk.query.UserLoginQuery;
import com.github.itdachen.admin.sdk.vo.UserLoginVo;

import java.util.List;

/**
 * 第三方登录信息关联(用户登录表) mapper
 *
 * @author 王大宸
 * @date 2023-04-16 17:39:59
 */
public interface IUserLoginMapper {
    
    /***
     * 根据登录账号查询用户信息
     *
     * @author 王大宸
     * @date 2023/4/29 20:28
     * @param username username
     * @return com.github.itdachen.admin.entity.UserLogin
     */
    UserLogin findUserLoginByUsername(String username);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param params com.github.itdachen.admin.sdk.query.UserLoginQuery
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.UserLoginVo>
     */
    List<UserLoginVo> findUserLoginPage(UserLoginQuery params);

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param userLogin userLogin
     * @return int int
     */
    int saveUserLogin(UserLogin userLogin);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.userLoginVo
     */
    UserLoginVo getById(String id);

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param userLogin userLogin
     * @return int int
     */
    int updateUserLogin(UserLogin userLogin);

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int deleteUserLoginById(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param list java.util.List<com.github.itdachen.admin.entity.UserLogin>
     */
    void batchSave(List<UserLogin> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-16 17:39:59
     * @param list java.util.List<com.github.itdachen.admin.entity.UserLogin>
     */
    void batchUpdate(List<UserLogin> list);

}