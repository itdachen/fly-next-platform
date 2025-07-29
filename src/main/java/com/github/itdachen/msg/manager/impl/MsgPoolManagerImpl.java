package com.github.itdachen.msg.manager.impl;

import com.github.itdachen.boot.oplog.ooxml.poi.entity.MsgFileModel;
import com.github.itdachen.boot.oplog.ooxml.poi.entity.MsgModel;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.msg.convert.MsgPoolConvert;
import com.github.itdachen.msg.convert.MsgPoolFileConvert;
import com.github.itdachen.msg.entity.MsgPoolFile;
import com.github.itdachen.msg.entity.MsgPool;
import com.github.itdachen.msg.manager.IMsgPoolManager;
import com.github.itdachen.msg.mapper.IMsgFileMapper;
import com.github.itdachen.msg.mapper.IMsgPoolMapper;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * MsgPoolManagerImpl
 *
 * @author 王大宸
 * @date 2025-07-22 16:38
 */
@Component
public class MsgPoolManagerImpl implements IMsgPoolManager {
    private static final Logger logger = LoggerFactory.getLogger(MsgPoolManagerImpl.class);
    private static final MsgPoolConvert msgPoolConvert = new MsgPoolConvert();
    private static final MsgPoolFileConvert msgPoolFileConvert = new MsgPoolFileConvert();

    private final IMsgFileMapper msgFileMapper;
    private final IMsgPoolMapper msgPoolMapper;

    public MsgPoolManagerImpl(IMsgFileMapper msgFileMapper, IMsgPoolMapper msgPoolMapper) {
        this.msgFileMapper = msgFileMapper;
        this.msgPoolMapper = msgPoolMapper;
    }

    /***
     * 添加消息信息
     *
     * @author 王大宸
     * @date 2025/7/23 14:56
     * @param msgModel msgModel
     * @param userDetails userDetails
     * @return void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsgPoolVO save(MsgModel msgModel, UserInfoDetails userDetails) {
        MsgPool msgPool = toMsgPool(msgModel, userDetails);
        if (null == msgModel) {
            throw new BizException("消息信息不能为空！");
        }

        List<MsgFileModel> files = msgModel.getFiles();
        if (null == files || files.isEmpty()) {
            msgPoolMapper.insertSelective(msgPool);
            return msgPoolConvert.toJavaObjectVO(msgPool);
        }

        List<MsgPoolFileVO> msgPoolFileVOs = new ArrayList<>();
        MsgPoolFile msgPoolFile;
        for (MsgFileModel file : files) {
            msgPoolFile = toMsgFile(file, msgPool);
            msgFileMapper.insertSelective(msgPoolFile);
            msgPoolFileVOs.add(msgPoolFileConvert.toJavaObjectVO(msgPoolFile));
        }

        msgPoolMapper.insertSelective(msgPool);
        //  msgFileMapper.batchSave(msgPoolFiles);


        MsgPoolVO msgPoolVO = msgPoolConvert.toJavaObjectVO(msgPool);
        msgPoolVO.setFiles(msgPoolFileVOs);
        return msgPoolVO;
    }

    /***
     * 追加消息信息
     *
     * @author 王大宸
     * @date 2025/7/23 14:56
     * @param msgModel msgModel
     * @return void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsgPoolVO appendContent(MsgModel msgModel) {
        MsgPool msgPool = msgPoolMapper.selectByPrimaryKey(msgModel.getId());


        String content = msgPool.getContent();
        content = content + "<br>" + msgModel.getContent();
        msgPool.setContent(content);

        List<MsgFileModel> files = msgModel.getFiles();
        if (null == files || files.isEmpty()) {
            msgPoolMapper.updateByPrimaryKeySelective(msgPool);
            return msgPoolConvert.toJavaObjectVO(msgPool);
        }

        /* 添加文件信息 */
        List<MsgPoolFileVO> msgPoolFileVOs = new ArrayList<>();
        MsgPoolFile msgPoolFile;
        for (MsgFileModel file : files) {
            msgPoolFile = toMsgFile(file, msgPool);
            msgFileMapper.insertSelective(msgPoolFile);
            msgPoolFileVOs.add(msgPoolFileConvert.toJavaObjectVO(msgPoolFile));
        }

        msgPoolMapper.updateByPrimaryKeySelective(msgPool);
        MsgPoolVO msgPoolVO = msgPoolConvert.toJavaObjectVO(msgPool);
        msgPoolVO.setFiles(msgPoolFileVOs);
        return msgPoolVO;
    }

    /***
     * 添加消息文件
     *
     * @author 王大宸
     * @date 2025/7/23 14:56
     * @param msgFileModel msgFileModel
     * @return void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsgPoolFileVO saveMsgFile(MsgFileModel msgFileModel) {
        if (null == msgFileModel.getMsgId()) {
            throw new BizException("消息ID不能为空!");
        }
        MsgPool msgPool = msgPoolMapper.selectByPrimaryKey(msgFileModel.getMsgId());
        if (null == msgPool) {
            throw new BizException("消息信息不存在!");
        }

        MsgPoolFile msgFile = toMsgFile(msgFileModel, msgPool);
        if (null == msgFile) {
            throw new BizException("消息文件信息不能为空！");
        }
        msgFileMapper.insertSelective(msgFile);

        return msgPoolFileConvert.toJavaObjectVO(msgFile);
    }


    private MsgPool toMsgPool(MsgModel msgModel, UserInfoDetails userDetails) {
        if (null == msgModel || null == userDetails) {
            return null;
        }
        MsgPool msgPool = new MsgPool();
        msgPool.setId(msgModel.getId());
        msgPool.setTenantId(userDetails.getTenantId());
        msgPool.setTenantTitle(userDetails.getTenantTitle());
        msgPool.setPlatId(userDetails.getPlatId());
        msgPool.setPlatTitle(userDetails.getPlatName());
        msgPool.setAppId(userDetails.getAppId());
        msgPool.setAppTitle(userDetails.getAppName());
        msgPool.setAppVersion(userDetails.getAppVersion());

        /* 人员信息 */
        msgPool.setUserId(userDetails.getId());
        msgPool.setNickName(userDetails.getNickName());
        msgPool.setRoleId(userDetails.getRoleId());
        msgPool.setRoleName(userDetails.getRoleName());
        msgPool.setProvId(userDetails.getProvCode());
        msgPool.setProvTitle(userDetails.getProvName());
        msgPool.setCityId(userDetails.getCityCode());
        msgPool.setCityTitle(userDetails.getCityName());
        msgPool.setCountyId(userDetails.getCountyCode());
        msgPool.setCountyTitle(userDetails.getCountyName());

        /* 所属部门 */
        msgPool.setDeptId(userDetails.getDeptId());
        msgPool.setDeptTitle(userDetails.getDeptTitle());
        msgPool.setDeptLevel(userDetails.getDeptLevel());
        msgPool.setDeptParentId(userDetails.getDeptParentId());

        /* 操作主机 */
        msgPool.setHostIp(msgModel.getHostIp());
        msgPool.setHostAddress(msgModel.getHostAddress());
        msgPool.setHostOs(msgModel.getHostOs());
        msgPool.setHostBrowser(msgModel.getHostBrowser());
        msgPool.setHostUserAgent(msgModel.getHostUserAgent());

        /* 消息信息 */
        msgPool.setMsgType(msgModel.getMsgType());
        msgPool.setMsgTypeTitle(msgModel.getMsgTypeTitle());
        msgPool.setClazzType(msgModel.getClazzType());
        msgPool.setClazzTitle(msgModel.getClazzTitle());
        msgPool.setTitle(msgModel.getTitle());
        msgPool.setContent(msgModel.getContent());
        msgPool.setReadFlag(YesOrNotConstant.N);
        msgPool.setRemoveFlag(YesOrNotConstant.N);

        /* 操作时间 */
        LocalDateTime now = LocalDateTime.now();
        msgPool.setMonthly(String.valueOf(now.getMonthValue()));
        msgPool.setYearly(String.valueOf(now.getYear()));
        msgPool.setCreateTime(now);
        msgPool.setCreateUserId(userDetails.getId());
        msgPool.setCreateUser(userDetails.getNickName());
        msgPool.setUpdateTime(now);
        msgPool.setUpdateUserId(userDetails.getId());
        msgPool.setUpdateUser(userDetails.getNickName());

        msgPool.setId(IdUtils.getId());
        if (null != msgModel.getId()) {
            msgPool.setId(msgModel.getId());
        }

        return msgPool;
    }


    private MsgPoolFile toMsgFile(MsgFileModel msgFileModel, MsgPool msgPool) {
        if (null == msgFileModel) {
            return null;
        }
        MsgPoolFile msgPoolFile = new MsgPoolFile();
        msgPoolFile.setId(msgFileModel.getId());
        msgPoolFile.setTenantId(msgPool.getTenantId());
        msgPoolFile.setTenantTitle(msgPool.getTenantTitle());
        msgPoolFile.setPlatId(msgPool.getPlatId());
        msgPoolFile.setPlatTitle(msgPool.getPlatTitle());
        msgPoolFile.setAppId(msgPool.getAppId());
        msgPoolFile.setAppTitle(msgPool.getAppTitle());
        msgPoolFile.setAppVersion(msgPool.getAppVersion());

        msgPoolFile.setUserId(msgPool.getUserId());
        msgPoolFile.setNickName(msgPool.getNickName());
        msgPoolFile.setRoleId(msgPool.getRoleId());
        msgPoolFile.setRoleName(msgPool.getRoleName());

        msgPoolFile.setProvId(msgPool.getProvId());
        msgPoolFile.setProvTitle(msgPool.getProvTitle());
        msgPoolFile.setCityId(msgPool.getCityId());
        msgPoolFile.setCityTitle(msgPool.getCityTitle());
        msgPoolFile.setCountyId(msgPool.getCountyId());
        msgPoolFile.setCountyTitle(msgPool.getCountyTitle());

        msgPoolFile.setDeptId(msgPool.getDeptId());
        msgPoolFile.setDeptTitle(msgPool.getDeptTitle());
        msgPoolFile.setDeptLevel(msgPool.getDeptLevel());
        msgPoolFile.setDeptParentId(msgPool.getDeptParentId());

        msgPoolFile.setHostIp(msgPool.getHostIp());
        msgPoolFile.setHostAddress(msgPool.getHostAddress());
        msgPoolFile.setHostOs(msgPool.getHostOs());
        msgPoolFile.setHostBrowser(msgPool.getHostBrowser());
        msgPoolFile.setHostUserAgent(msgPool.getHostUserAgent());

        msgPoolFile.setMsgType(msgPool.getMsgType());
        msgPoolFile.setMsgTypeTitle(msgPool.getMsgTypeTitle());
        msgPoolFile.setClazzType(msgPool.getClazzType());
        msgPoolFile.setClazzTitle(msgPool.getClazzTitle());
        msgPoolFile.setMsgId(msgPool.getId());
        msgPoolFile.setMsgTitle(msgFileModel.getMsgTitle());

        msgPoolFile.setFileTitle(msgFileModel.getFileTitle());
        msgPoolFile.setFileFormat(msgFileModel.getFileFormat());
        msgPoolFile.setFileUrl(msgFileModel.getFileUrl());
        msgPoolFile.setFileSize(msgFileModel.getFileSize());
        msgPoolFile.setHexMd5(msgFileModel.getHexMd5());
        msgPoolFile.setMd5ValidFlag(YesOrNotConstant.Y);

        msgPoolFile.setDownloadFlag(YesOrNotConstant.N);
        msgPoolFile.setDownloadTotal(0L);
        msgPoolFile.setDownloadFirstTime(null);
        msgPoolFile.setDownloadLastTime(null);
        msgPoolFile.setReadFlag(YesOrNotConstant.N);
        msgPoolFile.setReadTime(null);
        msgPoolFile.setRemoveFlag(YesOrNotConstant.N);
        msgPoolFile.setRemoveTime(null);
        msgPoolFile.setRemoveUserId(null);
        msgPoolFile.setRemoveNickName(null);


        LocalDateTime now = LocalDateTime.now();
        msgPoolFile.setMonthly(String.valueOf(now.getMonthValue()));
        msgPoolFile.setYearly(String.valueOf(now.getYear()));
        msgPoolFile.setCreateTime(now);
        msgPoolFile.setCreateUserId(msgPool.getId());
        msgPoolFile.setCreateUser(msgPool.getNickName());
        msgPoolFile.setUpdateTime(now);
        msgPoolFile.setUpdateUserId(msgPool.getId());
        msgPoolFile.setUpdateUser(msgPool.getNickName());

        if (null == msgPoolFile.getId()) {
            msgPoolFile.setId(IdUtils.getId());
        }

        return msgPoolFile;
    }


}
