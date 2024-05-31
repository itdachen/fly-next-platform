package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.WhiteIpList;
import com.github.itdachen.admin.sdk.query.WhiteIpListQuery;
import com.github.itdachen.admin.sdk.vo.WhiteIpListVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 菜单白名单 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
public interface IWhiteIpListMapper extends Mapper<WhiteIpList> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.whiteIpListVO
     */
    List<WhiteIpListVO> list(WhiteIpListQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.whiteIpListVo
     */
    WhiteIpListVO selectWhiteIpListVO(String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectWhiteIpListExpData(WhiteIpListQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param list java.util.List<com.github.itdachen.admin.entity.WhiteIpList>
     */
    void batchSave(List<WhiteIpList> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param list java.util.List<com.github.itdachen.admin.entity.WhiteIpList>
     */
    void batchUpdate(List<WhiteIpList> list);

}
