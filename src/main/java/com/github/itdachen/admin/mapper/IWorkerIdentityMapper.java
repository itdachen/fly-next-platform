package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.WorkerIdentity;
import com.github.itdachen.admin.sdk.query.WorkerIdentityQuery;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 职工身份 持久层接口
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
public interface IWorkerIdentityMapper extends Mapper< WorkerIdentity > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-05-16 21:19:44
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.workerIdentityVo
     */
    List< WorkerIdentityVo > page(WorkerIdentityQuery params);



    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-05-16 21:19:44
     * @param list java.util.List<com.github.itdachen.admin.entity.WorkerIdentity>
     */
    void  batchSave(List< WorkerIdentity > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-05-16 21:19:44
     * @param list java.util.List<com.github.itdachen.admin.entity.WorkerIdentity>
     */
    void batchUpdate(List< WorkerIdentity > list);

}
