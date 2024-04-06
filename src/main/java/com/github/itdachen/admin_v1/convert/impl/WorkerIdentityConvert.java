package com.github.itdachen.admin_v1.convert.impl;

import com.github.itdachen.admin_v1.convert.IWorkerIdentityConvert;
import com.github.itdachen.admin_v1.entity.WorkerIdentity;
import com.github.itdachen.admin_v1.sdk.dto.WorkerIdentityDto;
import com.github.itdachen.admin_v1.sdk.vo.WorkerIdentityVo;
import org.springframework.stereotype.Component;

/**
 * 职工身份 类型转换
 *
 * @author 王大宸
 * @date 2023-05-17 21:20:37
 */
@Component
public class WorkerIdentityConvert implements IWorkerIdentityConvert {

    @Override
    public WorkerIdentity toJavaObject(WorkerIdentityDto workerIdentityDto) {
        if (null == workerIdentityDto){
            return null;
        }
        WorkerIdentity workerIdentity = new WorkerIdentity();
        workerIdentity.setId(workerIdentityDto.getId());
        workerIdentity.setTenantId(workerIdentityDto.getTenantId());
        workerIdentity.setWorkerId(workerIdentityDto.getWorkerId());
        workerIdentity.setTitle(workerIdentityDto.getTitle());
        workerIdentity.setDeptId(workerIdentityDto.getDeptId());
        workerIdentity.setDeptTitle(workerIdentityDto.getDeptTitle());
        workerIdentity.setStatus(workerIdentityDto.getStatus());
        workerIdentity.setIsPrimary(workerIdentityDto.getIsPrimary());
        workerIdentity.setRemarks(workerIdentityDto.getRemarks());
        return workerIdentity;
    }


    @Override
    public WorkerIdentityVo toJavaObjectVo(WorkerIdentity workerIdentity) {
        if (null == workerIdentity){
            return null;
        }
        WorkerIdentityVo workerIdentityVo = new WorkerIdentityVo();
        workerIdentityVo.setId(workerIdentity.getId());
        workerIdentityVo.setTenantId(workerIdentity.getTenantId());
        workerIdentityVo.setWorkerId(workerIdentity.getWorkerId());
        workerIdentityVo.setTitle(workerIdentity.getTitle());
        workerIdentityVo.setDeptId(workerIdentity.getDeptId());
        workerIdentityVo.setDeptTitle(workerIdentity.getDeptTitle());
        workerIdentityVo.setStatus(workerIdentity.getStatus());
        workerIdentityVo.setIsPrimary(workerIdentity.getIsPrimary());
        workerIdentityVo.setRemarks(workerIdentity.getRemarks());
        return workerIdentityVo;
    }

    public WorkerIdentity toJavaObject(WorkerIdentityVo workerIdentityVo) {
        if (null == workerIdentityVo){
            return null;
        }
        WorkerIdentity workerIdentity = new WorkerIdentity();
        workerIdentity.setId(workerIdentityVo.getId());
        workerIdentity.setTenantId(workerIdentityVo.getTenantId());
        workerIdentity.setWorkerId(workerIdentityVo.getWorkerId());
        workerIdentity.setTitle(workerIdentityVo.getTitle());
        workerIdentity.setDeptId(workerIdentityVo.getDeptId());
        workerIdentity.setDeptTitle(workerIdentityVo.getDeptTitle());
        workerIdentity.setStatus(workerIdentityVo.getStatus());
        workerIdentity.setIsPrimary(workerIdentityVo.getIsPrimary());
        workerIdentity.setRemarks(workerIdentityVo.getRemarks());
        return workerIdentity;
    }

    public WorkerIdentityVo toJavaObjectVo(WorkerIdentityDto workerIdentityDto) {
        if (null == workerIdentityDto){
            return null;
        }
        WorkerIdentityVo workerIdentityVo = new WorkerIdentityVo();
        workerIdentityVo.setId(workerIdentityDto.getId());
        workerIdentityVo.setTenantId(workerIdentityDto.getTenantId());
        workerIdentityVo.setWorkerId(workerIdentityDto.getWorkerId());
        workerIdentityVo.setTitle(workerIdentityDto.getTitle());
        workerIdentityVo.setDeptId(workerIdentityDto.getDeptId());
        workerIdentityVo.setDeptTitle(workerIdentityDto.getDeptTitle());
        workerIdentityVo.setStatus(workerIdentityDto.getStatus());
        workerIdentityVo.setIsPrimary(workerIdentityDto.getIsPrimary());
        workerIdentityVo.setRemarks(workerIdentityDto.getRemarks());
        return workerIdentityVo;
    }


}