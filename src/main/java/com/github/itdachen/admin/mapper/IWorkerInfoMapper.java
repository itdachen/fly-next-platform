package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.WorkerInfo;
import com.github.itdachen.admin.sdk.query.WorkerInfoQuery;
import com.github.itdachen.admin.sdk.vo.WorkerInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 员工信息 持久层接口
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
public interface IWorkerInfoMapper extends Mapper< WorkerInfo > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-05-16 19:37:24
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.workerInfoVo
     */
    List< WorkerInfoVo > page(WorkerInfoQuery params);



    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-05-16 19:37:24
     * @param list java.util.List<com.github.itdachen.admin.entity.WorkerInfo>
     */
    void  batchSave(List< WorkerInfo > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-05-16 19:37:24
     * @param list java.util.List<com.github.itdachen.admin.entity.WorkerInfo>
     */
    void batchUpdate(List< WorkerInfo > list);

}
