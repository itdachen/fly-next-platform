package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.AppInfo;
import com.github.itdachen.admin.sdk.query.AppInfoQuery;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 应用信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-19 21:22:54
 */
public interface IAppInfoMapper extends Mapper<AppInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.appInfoVO
     */
    List<AppInfoVO> list(AppInfoQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.appInfoVo
     */
    AppInfoVO selectAppInfoVO(String id);

    /***
     * 根据应用标识查询
     *
     * @author 王大宸
     * @date 2024/4/20 13:04
     * @param appCode appCode
     * @return com.github.itdachen.admin.sdk.vo.AppInfoVO
     */
    AppInfoVO findAppInfoByAppCode(String appCode);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectAppInfoExpData(AppInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param list java.util.List<com.github.itdachen.admin.entity.AppInfo>
     */
    void batchSave(List<AppInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param list java.util.List<com.github.itdachen.admin.entity.AppInfo>
     */
    void batchUpdate(List<AppInfo> list);

}
