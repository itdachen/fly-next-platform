package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.NetDiskMd5;
import com.github.itdachen.admin.sdk.query.NetDiskMd5Query;
import com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo;

import java.util.List;

/**
 * 文件MD5 mapper
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public interface INetDiskMd5Mapper {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param params com.github.itdachen.admin.sdk.query.NetDiskMd5Query
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo>
     */
    List<NetDiskMd5Vo> findNetDiskMd5Page(NetDiskMd5Query params);

    /***
     * 根据 文件MD5 查询文件信息
     *
     * @author 王大宸
     * @date 2023/4/14 23:27
     * @param md5Hex md5Hex
     * @return com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo
     */
    NetDiskMd5Vo findNetDiskMd5(String md5Hex);

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskMd5 netDiskMd5
     * @return int int
     */
    int saveNetDiskMd5(NetDiskMd5 netDiskMd5);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.netDiskMd5Vo
     */
    NetDiskMd5Vo getById(String id);

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskMd5 netDiskMd5
     * @return int int
     */
    int updateNetDiskMd5(NetDiskMd5 netDiskMd5);

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int deleteNetDiskMd5ById(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param list java.util.List<com.github.itdachen.admin.entity.NetDiskMd5>
     */
    void batchSave(List<NetDiskMd5> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param list java.util.List<com.github.itdachen.admin.entity.NetDiskMd5>
     */
    void batchUpdate(List<NetDiskMd5> list);

}