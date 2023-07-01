package com.github.itdachen.dashboard.convert.impl;

import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.sdk.dto.LoginRecordDTO;
import com.github.itdachen.dashboard.sdk.vo.LoginRecordVO;
import com.github.itdachen.dashboard.convert.ILoginRecordConvert;
import org.springframework.stereotype.Component;

/**
 * 登录日志 类型转换
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
@Component
public class LoginRecordConvertImpl implements ILoginRecordConvert {

    /***
     * DTO 转 Entity
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @return loginRecordDTO loginRecordDTO
     * @return com.github.itdachen.dashboard.entity.LoginRecord;
     */
    @Override
    public LoginRecord toJavaObject(LoginRecordDTO loginRecordDTO) {
        if (null == loginRecordDTO){
            return null;
        }
       LoginRecord loginRecord = new LoginRecord();
                    loginRecord.setId(loginRecordDTO.getId());
                    loginRecord.setSessionId(loginRecordDTO.getSessionId());
                    loginRecord.setClientId(loginRecordDTO.getClientId());
                    loginRecord.setNickname(loginRecordDTO.getNickname());
                    loginRecord.setUsername(loginRecordDTO.getUsername());
                    loginRecord.setIp(loginRecordDTO.getIp());
                    loginRecord.setAccessAddress(loginRecordDTO.getAccessAddress());
                    loginRecord.setBrowser(loginRecordDTO.getBrowser());
                    loginRecord.setOs(loginRecordDTO.getOs());
                    loginRecord.setStatus(loginRecordDTO.getStatus());
                    loginRecord.setMsg(loginRecordDTO.getMsg());
        return loginRecord;
    }

    /***
     * Entity 转 VO
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @return loginRecordVo loginRecordVo
     * @return com.github.itdachen.dashboard.entity.LoginRecord;
     */
    @Override
    public LoginRecordVO toJavaObjectVo(LoginRecord loginRecord) {
        if (null == loginRecord){
            return null;
        }
        LoginRecordVO loginRecordVO = new LoginRecordVO();
                    loginRecordVO.setId(loginRecord.getId());
                    loginRecordVO.setSessionId(loginRecord.getSessionId());
                    loginRecordVO.setClientId(loginRecord.getClientId());
                    loginRecordVO.setNickname(loginRecord.getNickname());
                    loginRecordVO.setUsername(loginRecord.getUsername());
                    loginRecordVO.setIp(loginRecord.getIp());
                    loginRecordVO.setAccessAddress(loginRecord.getAccessAddress());
                    loginRecordVO.setBrowser(loginRecord.getBrowser());
                    loginRecordVO.setOs(loginRecord.getOs());
                    loginRecordVO.setStatus(loginRecord.getStatus());
                    loginRecordVO.setMsg(loginRecord.getMsg());
        return loginRecordVO;
    }

    /***
     *  VO 转 Entity
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @return loginRecordVo loginRecordVo
     * @return com.github.itdachen.dashboard.entity.LoginRecord;
     */
    @Override
    public LoginRecord toJavaObject(LoginRecordVO loginRecordVO) {
        if (null == loginRecordVO){
            return null;
        }
        LoginRecord loginRecord = new LoginRecord();
                    loginRecord.setId(loginRecordVO.getId());
                    loginRecord.setSessionId(loginRecordVO.getSessionId());
                    loginRecord.setClientId(loginRecordVO.getClientId());
                    loginRecord.setNickname(loginRecordVO.getNickname());
                    loginRecord.setUsername(loginRecordVO.getUsername());
                    loginRecord.setIp(loginRecordVO.getIp());
                    loginRecord.setAccessAddress(loginRecordVO.getAccessAddress());
                    loginRecord.setBrowser(loginRecordVO.getBrowser());
                    loginRecord.setOs(loginRecordVO.getOs());
                    loginRecord.setStatus(loginRecordVO.getStatus());
                    loginRecord.setMsg(loginRecordVO.getMsg());
        return loginRecord;
    }

    /***
     * DTO 转 VO
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @return loginRecordDto loginRecordDto
     * @return com.github.itdachen.dashboard.sdk.vo.LoginRecordVo;
     */
    @Override
    public LoginRecordVO toJavaObjectVo(LoginRecordDTO loginRecordDTO) {
        if (null == loginRecordDTO){
            return null;
        }
        LoginRecordVO loginRecordVO = new LoginRecordVO();
                loginRecordVO.setId(loginRecordDTO.getId());
                loginRecordVO.setSessionId(loginRecordDTO.getSessionId());
                loginRecordVO.setClientId(loginRecordDTO.getClientId());
                loginRecordVO.setNickname(loginRecordDTO.getNickname());
                loginRecordVO.setUsername(loginRecordDTO.getUsername());
                loginRecordVO.setIp(loginRecordDTO.getIp());
                loginRecordVO.setAccessAddress(loginRecordDTO.getAccessAddress());
                loginRecordVO.setBrowser(loginRecordDTO.getBrowser());
                loginRecordVO.setOs(loginRecordDTO.getOs());
                loginRecordVO.setStatus(loginRecordDTO.getStatus());
                loginRecordVO.setMsg(loginRecordDTO.getMsg());
        return loginRecordVO;
    }


}