package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.sdk.dto.LoginRecordDTO;
import com.github.itdachen.dashboard.sdk.query.LoginRecordQuery;
import com.github.itdachen.dashboard.sdk.vo.LoginRecordVO;
import com.github.itdachen.dashboard.mapper.ILoginRecordMapper;
import com.github.itdachen.dashboard.service.ILoginRecordService;
import com.github.itdachen.dashboard.convert.ILoginRecordConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录日志 业务实现
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
@Service
public class LoginRecordServiceImpl extends BizServiceImpl< ILoginRecordMapper, ILoginRecordConvert, LoginRecord, LoginRecordDTO,  LoginRecordVO, LoginRecordQuery, String > implements ILoginRecordService {
    private static final Logger logger = LoggerFactory.getLogger(LoginRecordServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-06-30 22:39:02
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.dashboard.sdk.vo.loginRecordVo>
    */
    @Override
    public TableData< LoginRecordVO > page(LoginRecordQuery params) throws Exception {
        Page< LoginRecordVO > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< LoginRecordVO > list = bizMapper.page(params);
        return new TableData< LoginRecordVO >(page.getTotal(), list);
    }


}
