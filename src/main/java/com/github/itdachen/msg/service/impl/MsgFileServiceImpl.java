package com.github.itdachen.msg.service.impl;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.framework.webmvc.poi.WorkBookUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.msg.entity.MsgPoolFile;
import com.github.itdachen.msg.sdk.dto.MsgPoolFileDTO;
import com.github.itdachen.msg.sdk.query.MsgPoolFileQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.msg.mapper.IMsgFileMapper;
import com.github.itdachen.msg.service.IMsgFileService;
import com.github.itdachen.msg.convert.MsgPoolFileConvert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 消息附件 业务实现
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
@Service
public class MsgFileServiceImpl extends BizServiceImpl< IMsgFileMapper, MsgPoolFile, MsgPoolFileDTO, MsgPoolFileVO, MsgPoolFileQuery, String > implements IMsgFileService {
    private static final Logger logger = LoggerFactory.getLogger(MsgFileServiceImpl.class);
    private static final MsgPoolFileConvert bizConvert = new MsgPoolFileConvert();
    private final List<String> EXP_FIELDS = new ArrayList<>();
    public MsgFileServiceImpl() {
        super(bizConvert);
            EXP_FIELDS.add("租户名称");
            EXP_FIELDS.add("平台ID");
            EXP_FIELDS.add("平台名称");
            EXP_FIELDS.add("应用ID");
            EXP_FIELDS.add("应用名称");
            EXP_FIELDS.add("上传人ID");
            EXP_FIELDS.add("上传人昵称");
            EXP_FIELDS.add("消息ID");
            EXP_FIELDS.add("文件名称");
            EXP_FIELDS.add("文件格式");
            EXP_FIELDS.add("文件地址");
            EXP_FIELDS.add("文件大小");
            EXP_FIELDS.add("文件MD5值(对接文件服务, 真多同一个文件同时上传多次的问题, MD5 可以实现秒传)");
            EXP_FIELDS.add("MD5可用标志: Y-可用;N-不可用; 值为 N 时该文件不能被下载(防止一下不适当/不健康的文件传播)");
            EXP_FIELDS.add("下载标志");
            EXP_FIELDS.add("下载次数");
            EXP_FIELDS.add("第一次下载时间");
            EXP_FIELDS.add("最后一次下载时间");
            EXP_FIELDS.add("阅读标志");
            EXP_FIELDS.add("阅读时间");
            EXP_FIELDS.add("删除时间");
            EXP_FIELDS.add("删除人ID");
            EXP_FIELDS.add("删除人昵称");
            EXP_FIELDS.add("年份");
            EXP_FIELDS.add("月份");
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2025-07-11 22:52:18
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.msg.sdk.vo.msgFileVo>
    */
    @Override
    public TableData<MsgPoolFileVO> page(MsgPoolFileQuery params) throws Exception {
        Page<MsgPoolFileVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<MsgPoolFileVO> list = bizMapper.list(params);
        return new TableData<MsgPoolFileVO>(page.getTotal(), list);
    }


    /***
     * 导出
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params com.github.itdachen.msg.sdk.query.MsgFileQuery
     * @return void
     */
    @Override
    public void dataExpToExcel(HttpServletRequest request,
                               HttpServletResponse response,
                               MsgPoolFileQuery params) throws Exception{
        List < LinkedHashMap < String, String > >  list = bizMapper.selectMsgFileExpData(params);
       WorkBookUtils.export(request, response)
                .params(params)
                .title("消息附件")
                .rowNum(true)
                .fields(EXP_FIELDS)
                .data(list)
                .execute();
    }

}
