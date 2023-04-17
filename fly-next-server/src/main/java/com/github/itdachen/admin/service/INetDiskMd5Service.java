package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.NetDiskMd5Dto;
import com.github.itdachen.admin.sdk.query.NetDiskMd5Query;
import com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo;
import com.github.itdachen.framework.core.response.TableData;

/**
 * 文件MD5 service
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public interface INetDiskMd5Service {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/17 1:39
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo>
     */
    TableData<NetDiskMd5Vo> findNetDiskMd5Page(NetDiskMd5Query params) throws Exception;

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
     * @param netDiskMd5Dto netDiskMd5Dto
     * @return com.github.itdachen.admin.sdk.dto.netDiskMd5
     */
    NetDiskMd5Dto saveNetDiskMd5(NetDiskMd5Dto netDiskMd5Dto) throws Exception;

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo
     */
    NetDiskMd5Vo getNetDiskMd5ById(String id) throws Exception;

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskMd5Dto netDiskMd5Dto
     * @return com.github.itdachen.admin.sdk.dto.netDiskMd5
     */
    NetDiskMd5Dto updateNetDiskMd5(NetDiskMd5Dto netDiskMd5Dto) throws Exception;

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int removeNetDiskMd5(String id) throws Exception;

}
