package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.NetDiskInfo;
import com.github.itdachen.admin_v1.sdk.query.NetDiskInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.NetDiskInfoVo;

import java.util.List;

/**
 * 文件信息表 mapper
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public interface INetDiskInfoMapper {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param params com.github.itdachen.admin.sdk.query.NetDiskInfoQuery
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.NetDiskInfoVo>
     */
    List<NetDiskInfoVo> findNetDiskInfoPage(NetDiskInfoQuery params);

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskInfo netDiskInfo
     * @return int int
     */
    int saveNetDiskInfo(NetDiskInfo netDiskInfo);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.netDiskInfoVo
     */
    NetDiskInfoVo getById(String id);

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskInfo netDiskInfo
     * @return int int
     */
    int updateNetDiskInfo(NetDiskInfo netDiskInfo);

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int deleteNetDiskInfoById(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param list java.util.List<com.github.itdachen.admin.entity.NetDiskInfo>
     */
    void batchSave(List<NetDiskInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param list java.util.List<com.github.itdachen.admin.entity.NetDiskInfo>
     */
    void batchUpdate(List<NetDiskInfo> list);

}