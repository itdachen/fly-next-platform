package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.PlatformInfo;
import com.github.itdachen.admin.sdk.query.PlatformInfoQuery;
import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 平台信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
public interface IPlatformInfoMapper extends Mapper< PlatformInfo > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.platformInfoVO
     */
    List< PlatformInfoVO > list(PlatformInfoQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.platformInfoVo
     */
        PlatformInfoVO selectPlatformInfoVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap< String, String >> selectPlatformInfoExpData(PlatformInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param list java.util.List<com.github.itdachen.admin.entity.PlatformInfo>
     */
    void  batchSave(List< PlatformInfo > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param list java.util.List<com.github.itdachen.admin.entity.PlatformInfo>
     */
    void batchUpdate(List< PlatformInfo > list);

}
