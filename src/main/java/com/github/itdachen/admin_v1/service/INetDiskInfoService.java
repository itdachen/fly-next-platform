package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.NetDiskInfoDto;
import com.github.itdachen.admin_v1.sdk.query.NetDiskInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.NetDiskInfoVo;
import com.github.itdachen.framework.core.response.TableData;

/**
 * 文件信息表 service
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
public interface INetDiskInfoService {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/17 1:39
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.NetDiskInfoVo>
     */
    TableData< NetDiskInfoVo > findNetDiskInfoPage(NetDiskInfoQuery params) throws Exception;

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskInfoDto netDiskInfoDto
     * @return com.github.itdachen.admin.sdk.dto.netDiskInfo
     */
     NetDiskInfoDto saveNetDiskInfo(NetDiskInfoDto netDiskInfoDto) throws Exception;

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.NetDiskInfoVo
     */
        NetDiskInfoVo getNetDiskInfoById(String id) throws Exception;

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskInfoDto netDiskInfoDto
     * @return com.github.itdachen.admin.sdk.dto.netDiskInfo
     */
        NetDiskInfoDto updateNetDiskInfo(NetDiskInfoDto netDiskInfoDto) throws Exception;

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int removeNetDiskInfo(String id) throws Exception;

}
