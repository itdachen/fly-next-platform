package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.convert.IWorkerInfoConvert;
import com.github.itdachen.admin.entity.WorkerInfo;
import com.github.itdachen.admin.sdk.dto.WorkerInfoDto;
import com.github.itdachen.admin.sdk.vo.WorkerInfoVo;
import org.springframework.stereotype.Component;

/**
 * 员工信息 类型转换
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
@Component
public class WorkerInfoConvert implements IWorkerInfoConvert {

    @Override
    public WorkerInfo toJavaObject(WorkerInfoDto workerInfoDto) {
        if (null == workerInfoDto) {
            return null;
        }
        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setId(workerInfoDto.getId());
        workerInfo.setTenantId(workerInfoDto.getTenantId());
        workerInfo.setWorkerNo(workerInfoDto.getWorkerNo());
        workerInfo.setWorkerName(workerInfoDto.getWorkerName());
        workerInfo.setSex(workerInfoDto.getSex());
        workerInfo.setAvatar(workerInfoDto.getAvatar());
        workerInfo.setBirthday(workerInfoDto.getBirthday());
        workerInfo.setTelephone(workerInfoDto.getTelephone());
        workerInfo.setEmail(workerInfoDto.getEmail());
        workerInfo.setStatus(workerInfoDto.getStatus());
        workerInfo.setRemarks(workerInfoDto.getRemarks());
        workerInfo.setEntryDay(workerInfoDto.getEntryDay());
        workerInfo.setDepartDay(workerInfoDto.getDepartDay());
        return workerInfo;
    }


    @Override
    public WorkerInfoVo toJavaObjectVo(WorkerInfo workerInfo) {
        if (null == workerInfo) {
            return null;
        }
        WorkerInfoVo workerInfoVo = new WorkerInfoVo();
        workerInfoVo.setId(workerInfo.getId());
        workerInfoVo.setTenantId(workerInfo.getTenantId());
        workerInfoVo.setWorkerNo(workerInfo.getWorkerNo());
        workerInfoVo.setWorkerName(workerInfo.getWorkerName());
        workerInfoVo.setSex(workerInfo.getSex());
        workerInfoVo.setAvatar(workerInfo.getAvatar());
        workerInfoVo.setBirthday(workerInfo.getBirthday());
        workerInfoVo.setTelephone(workerInfo.getTelephone());
        workerInfoVo.setEmail(workerInfo.getEmail());
        workerInfoVo.setStatus(workerInfo.getStatus());
        workerInfoVo.setRemarks(workerInfo.getRemarks());
        workerInfoVo.setEntryDay(workerInfo.getEntryDay());
        workerInfoVo.setDepartDay(workerInfo.getDepartDay());
        return workerInfoVo;
    }

    public WorkerInfo toJavaObject(WorkerInfoVo workerInfoVo) {
        if (null == workerInfoVo) {
            return null;
        }
        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setId(workerInfoVo.getId());
        workerInfo.setTenantId(workerInfoVo.getTenantId());
        workerInfo.setWorkerNo(workerInfoVo.getWorkerNo());
        workerInfo.setWorkerName(workerInfoVo.getWorkerName());
        workerInfo.setSex(workerInfoVo.getSex());
        workerInfo.setAvatar(workerInfoVo.getAvatar());
        workerInfo.setBirthday(workerInfoVo.getBirthday());
        workerInfo.setTelephone(workerInfoVo.getTelephone());
        workerInfo.setEmail(workerInfoVo.getEmail());
        workerInfo.setStatus(workerInfoVo.getStatus());
        workerInfo.setRemarks(workerInfoVo.getRemarks());
        workerInfo.setEntryDay(workerInfoVo.getEntryDay());
        workerInfo.setDepartDay(workerInfoVo.getDepartDay());
        return workerInfo;
    }

    public WorkerInfoVo toJavaObjectVo(WorkerInfoDto workerInfoDto) {
        if (null == workerInfoDto) {
            return null;
        }
        WorkerInfoVo workerInfoVo = new WorkerInfoVo();
        workerInfoVo.setId(workerInfoDto.getId());
        workerInfoVo.setTenantId(workerInfoDto.getTenantId());
        workerInfoVo.setWorkerNo(workerInfoDto.getWorkerNo());
        workerInfoVo.setWorkerName(workerInfoDto.getWorkerName());
        workerInfoVo.setSex(workerInfoDto.getSex());
        workerInfoVo.setAvatar(workerInfoDto.getAvatar());
        workerInfoVo.setBirthday(workerInfoDto.getBirthday());
        workerInfoVo.setTelephone(workerInfoDto.getTelephone());
        workerInfoVo.setEmail(workerInfoDto.getEmail());
        workerInfoVo.setStatus(workerInfoDto.getStatus());
        workerInfoVo.setRemarks(workerInfoDto.getRemarks());
        workerInfoVo.setEntryDay(workerInfoDto.getEntryDay());
        workerInfoVo.setDepartDay(workerInfoDto.getDepartDay());
        return workerInfoVo;
    }


}