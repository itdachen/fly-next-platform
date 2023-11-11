package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.convert.IWorkerIdentityPosttionConvert;
import com.github.itdachen.admin.entity.WorkerIdentityPosition;
import com.github.itdachen.admin.sdk.dto.WorkerIdentityPositionDto;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityPositionVo;
import org.springframework.stereotype.Component;

/**
 * 身份岗位 类型转换
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
@Component
public class WorkerIdentityPosttionConvert implements IWorkerIdentityPosttionConvert {

    @Override
    public WorkerIdentityPosition toJavaObject(WorkerIdentityPositionDto workerIdentityPositionDto) {
        if (null == workerIdentityPositionDto){
            return null;
        }
       WorkerIdentityPosition workerIdentityPosition = new WorkerIdentityPosition();
                    workerIdentityPosition.setId(workerIdentityPositionDto.getId());
                    workerIdentityPosition.setIdentityId(workerIdentityPositionDto.getIdentityId());
                    workerIdentityPosition.setPositionId(workerIdentityPositionDto.getPositionId());
                    workerIdentityPosition.setClientId(workerIdentityPositionDto.getClientId());
        return workerIdentityPosition;
    }


    @Override
    public WorkerIdentityPositionVo toJavaObjectVo(WorkerIdentityPosition workerIdentityPosition) {
        if (null == workerIdentityPosition){
            return null;
        }
        WorkerIdentityPositionVo workerIdentityPositionVo = new WorkerIdentityPositionVo();
                    workerIdentityPositionVo.setId(workerIdentityPosition.getId());
                    workerIdentityPositionVo.setIdentityId(workerIdentityPosition.getIdentityId());
                    workerIdentityPositionVo.setPositionId(workerIdentityPosition.getPositionId());
                    workerIdentityPositionVo.setClientId(workerIdentityPosition.getClientId());
        return workerIdentityPositionVo;
    }

    public WorkerIdentityPosition toJavaObject(WorkerIdentityPositionVo workerIdentityPositionVo) {
        if (null == workerIdentityPositionVo){
            return null;
        }
        WorkerIdentityPosition workerIdentityPosition = new WorkerIdentityPosition();
                    workerIdentityPosition.setId(workerIdentityPositionVo.getId());
                    workerIdentityPosition.setIdentityId(workerIdentityPositionVo.getIdentityId());
                    workerIdentityPosition.setPositionId(workerIdentityPositionVo.getPositionId());
                    workerIdentityPosition.setClientId(workerIdentityPositionVo.getClientId());
        return workerIdentityPosition;
    }

    @Override
    public WorkerIdentityPositionVo toJavaObjectVo(WorkerIdentityPositionDto workerIdentityPositionDto) {
        if (null == workerIdentityPositionDto){
            return null;
        }
        WorkerIdentityPositionVo workerIdentityPositionVo = new WorkerIdentityPositionVo();
                workerIdentityPositionVo.setId(workerIdentityPositionDto.getId());
                workerIdentityPositionVo.setIdentityId(workerIdentityPositionDto.getIdentityId());
                workerIdentityPositionVo.setPositionId(workerIdentityPositionDto.getPositionId());
                workerIdentityPositionVo.setClientId(workerIdentityPositionDto.getClientId());
        return workerIdentityPositionVo;
    }


}