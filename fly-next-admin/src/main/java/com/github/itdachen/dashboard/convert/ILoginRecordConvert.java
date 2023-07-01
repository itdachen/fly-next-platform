package com.github.itdachen.dashboard.convert;

import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.sdk.dto.LoginRecordDTO;
import com.github.itdachen.dashboard.sdk.vo.LoginRecordVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 登录日志 类型转换
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public interface ILoginRecordConvert extends IBizConvertMapper< LoginRecord, LoginRecordDTO, LoginRecordVO > {

    /***
     *  VO 转 Entity
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @return loginRecordVo loginRecordVo
     * @return com.github.itdachen.dashboard.entity.LoginRecord;
     */
    LoginRecord toJavaObject(LoginRecordVO loginRecordVo);

    /***
     * DTO 转 VO
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @return loginRecordDto loginRecordDto
     * @return com.github.itdachen.dashboard.sdk.vo.LoginRecordVo;
     */
    LoginRecordVO toJavaObjectVo(LoginRecordDTO loginRecordDto);


}