package com.github.itdachen.dashboard.mapper;

import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.sdk.query.LoginRecordQuery;
import com.github.itdachen.dashboard.sdk.vo.LoginRecordVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 登录日志 持久层接口
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public interface ILoginRecordMapper extends Mapper<LoginRecord> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @param params params
     * @return com.github.itdachen.dashboard.sdk.vo.loginRecordVo
     */
    List<LoginRecordVO> page(LoginRecordQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @param list java.util.List<com.github.itdachen.dashboard.entity.LoginRecord>
     */
    void batchSave(List<LoginRecord> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-06-30 22:39:02
     * @param list java.util.List<com.github.itdachen.dashboard.entity.LoginRecord>
     */
    void batchUpdate(List<LoginRecord> list);

}
