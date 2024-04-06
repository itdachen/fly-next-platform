package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.MakeUseLog;
import com.github.itdachen.admin_v1.sdk.query.MakeUseLogQuery;
import com.github.itdachen.admin_v1.sdk.vo.MakeUseLogVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 日志表 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:45
 */
public interface IMakeUseLogMapper extends Mapper<MakeUseLog> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:45
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.makeUseLogVo
     */
    List<MakeUseLogVo> page(MakeUseLogQuery params);

}
