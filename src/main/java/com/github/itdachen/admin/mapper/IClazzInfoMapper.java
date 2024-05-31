package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.ClazzInfo;
import com.github.itdachen.admin.sdk.query.ClazzInfoQuery;
import com.github.itdachen.admin.sdk.vo.ClazzInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 岗位信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
public interface IClazzInfoMapper extends Mapper<ClazzInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.clazzInfoVO
     */
    List<ClazzInfoVO> list(ClazzInfoQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.clazzInfoVo
     */
    ClazzInfoVO selectClazzInfoVO(String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectClazzInfoExpData(ClazzInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param list java.util.List<com.github.itdachen.admin.entity.ClazzInfo>
     */
    void batchSave(List<ClazzInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param list java.util.List<com.github.itdachen.admin.entity.ClazzInfo>
     */
    void batchUpdate(List<ClazzInfo> list);

}
