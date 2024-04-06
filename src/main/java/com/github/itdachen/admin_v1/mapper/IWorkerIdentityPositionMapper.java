package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.WorkerIdentityPosition;
import com.github.itdachen.admin_v1.sdk.query.WorkerIdentityPositionQuery;
import com.github.itdachen.admin_v1.sdk.vo.WorkerIdentityPositionVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 身份岗位 持久层接口
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
public interface IWorkerIdentityPositionMapper extends Mapper<WorkerIdentityPosition> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-05-16 23:12:21
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.workerIdentityPosttionVo
     */
    List<WorkerIdentityPositionVo> page(WorkerIdentityPositionQuery params);

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2023/5/16 23:23
     * @param identityId identityId
     * @param clientId clientId
     * @return void
     */
    void removeIdentityPosition(String identityId, String clientId);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-05-16 23:12:21
     * @param list java.util.List<com.github.itdachen.admin.entity.WorkerIdentityPosttion>
     */
    void batchSave(List<WorkerIdentityPosition> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-05-16 23:12:21
     * @param list java.util.List<com.github.itdachen.admin.entity.WorkerIdentityPosttion>
     */
    void batchUpdate(List<WorkerIdentityPosition> list);

    List<String> findPosition(String identityId);

}
