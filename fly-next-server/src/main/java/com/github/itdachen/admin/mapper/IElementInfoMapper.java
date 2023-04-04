package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 按钮资源 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IElementInfoMapper extends Mapper< ElementInfo > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.elementInfoVo
     */
    List< ElementInfoVo > page(ElementInfoQuery params);



    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.ElementInfo>
     */
    void  batchSave(List< ElementInfo > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.ElementInfo>
     */
    void batchUpdate(List< ElementInfo > list);

}
