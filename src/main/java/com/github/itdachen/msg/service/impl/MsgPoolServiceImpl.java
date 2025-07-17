package com.github.itdachen.msg.service.impl;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.msg.entity.MsgPool;
import com.github.itdachen.msg.sdk.dto.MsgPoolDTO;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import com.github.itdachen.msg.mapper.IMsgPoolMapper;
import com.github.itdachen.msg.service.IMsgPoolService;
import com.github.itdachen.msg.convert.MsgPoolConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 消息池 业务实现
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
@Service
public class MsgPoolServiceImpl extends BizServiceImpl< IMsgPoolMapper, MsgPool, MsgPoolDTO,  MsgPoolVO, MsgPoolQuery, String > implements IMsgPoolService {
    private static final Logger logger = LoggerFactory.getLogger(MsgPoolServiceImpl.class);
    private static final MsgPoolConvert bizConvert = new MsgPoolConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();
    public MsgPoolServiceImpl() {
        super(bizConvert);
            EXP_FIELDS.add("身份名称");
            EXP_FIELDS.add("部门名称");
            EXP_FIELDS.add("消息标题");
            EXP_FIELDS.add("阅读标志");
            EXP_FIELDS.add("阅读时间");
            EXP_FIELDS.add("年份");
            EXP_FIELDS.add("月份");
            EXP_FIELDS.add("创建时间");
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2025-07-11 22:52:18
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.msg.sdk.vo.msgPoolVo>
    */
    @Override
    public TableData< MsgPoolVO > page(MsgPoolQuery params) throws Exception {
        Page< MsgPoolVO > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< MsgPoolVO > list = bizMapper.list(params);
        return new TableData< MsgPoolVO >(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params com.github.itdachen.msg.sdk.query.MsgPoolQuery
     * @return void
     */
    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               MsgPoolQuery params) throws Exception{
        List < LinkedHashMap < String, String > >  list = bizMapper.selectMsgPoolExpData(params);
       WorkBookUtils.export(request, response)
                .params(params)
                .title("消息池")
                .rowNum(true)
                .fields(EXP_FIELDS)
                .data(list)
                .execute();
    }

}
