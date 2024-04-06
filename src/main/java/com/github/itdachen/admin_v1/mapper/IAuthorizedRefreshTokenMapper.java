package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.AuthorizedRefreshToken;
import com.github.itdachen.admin_v1.sdk.query.AuthorizedRefreshTokenQuery;
import com.github.itdachen.admin_v1.sdk.vo.AuthorizedRefreshTokenVo;

import java.util.List;

/**
 * 授权方的刷新令牌 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-16 17:39:59
 */
public interface IAuthorizedRefreshTokenMapper {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-16 17:52:48
     * @param params com.github.itdachen.admin.sdk.query.AuthorizedRefreshTokenQuery
     * @return java.util.List
     */
    List<AuthorizedRefreshTokenVo> findAuthorizedRefreshTokenPage(AuthorizedRefreshTokenQuery params);

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-16 17:52:48
     * @param authorizedRefreshToken authorizedRefreshToken
     * @return int int
     */
    int saveAuthorizedRefreshToken(AuthorizedRefreshToken authorizedRefreshToken);

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023-04-16 17:52:48
     * @param authorizedRefreshToken authorizedRefreshToken
     * @return int int
     */
    int updateAuthorizedRefreshToken(AuthorizedRefreshToken authorizedRefreshToken);

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023-04-16 17:52:48
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int deleteAuthorizedRefreshTokenById(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-16 17:52:48
     * @param list java.util.List
     */
    void batchSave(List<AuthorizedRefreshToken> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-16 17:52:48
     * @param list java.util.List
     */
    void batchUpdate(List<AuthorizedRefreshToken> list);

}
