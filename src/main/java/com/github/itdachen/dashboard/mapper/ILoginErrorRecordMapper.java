package com.github.itdachen.dashboard.mapper;

import com.github.itdachen.dashboard.entity.LoginErrorRecord;
import com.github.itdachen.dashboard.sdk.query.LoginErrorRecordQuery;
import com.github.itdachen.dashboard.sdk.vo.LoginErrorRecordVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 登录错误日志 持久层接口
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public interface ILoginErrorRecordMapper extends Mapper<LoginErrorRecord> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @param params params
     * @return com.github.itdachen.dashboard.sdk.vo.loginErrorRecordVo
     */
    List<LoginErrorRecordVO> page(LoginErrorRecordQuery params);
    
    /***
     * 根据登录账号, 查询登录齿白次数
     *
     * @author 王大宸
     * @date 2023/6/30 23:08
     * @param username username
     * @return java.lang.Integer
     */
    Integer findErrTotal(String username);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @param list java.util.List<com.github.itdachen.dashboard.entity.LoginErrorRecord>
     */
    void batchSave(List<LoginErrorRecord> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @param list java.util.List<com.github.itdachen.dashboard.entity.LoginErrorRecord>
     */
    void batchUpdate(List<LoginErrorRecord> list);

}
