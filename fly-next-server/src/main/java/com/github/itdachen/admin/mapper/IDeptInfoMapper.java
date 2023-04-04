package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 部门管理 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDeptInfoMapper extends Mapper< DeptInfo > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.deptInfoVo
     */
    List< DeptInfoVo > page(DeptInfoQuery params);



    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptInfo>
     */
    void  batchSave(List< DeptInfo > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptInfo>
     */
    void batchUpdate(List< DeptInfo > list);

}
