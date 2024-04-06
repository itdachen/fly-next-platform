package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.PositionInfo;
import com.github.itdachen.admin_v1.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.PositionInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 岗位信息 持久层接口
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
public interface IPositionInfoMapper extends Mapper<PositionInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-05-15 20:13:36
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.positionInfoVo
     */
    List<PositionInfoVo> page(PositionInfoQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-05-15 20:13:36
     * @param list java.util.List<com.github.itdachen.admin.entity.PositionInfo>
     */
    void batchSave(List<PositionInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-05-15 20:13:36
     * @param list java.util.List<com.github.itdachen.admin.entity.PositionInfo>
     */
    void batchUpdate(List<PositionInfo> list);

    /***
     * 根据部门查询岗位
     *
     * @author 王大宸
     * @date 2023/5/16 22:48
     * @param deptId deptId
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.PositionInfoVo>
     */
    List<PositionInfoVo> findPositionByDept(String deptId, String status);

}
