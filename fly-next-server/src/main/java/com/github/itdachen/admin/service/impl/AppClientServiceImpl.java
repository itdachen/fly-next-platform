package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IAppClientConvert;
import com.github.itdachen.admin.convert.impl.AppClientConvert;
import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.mapper.IAppClientMapper;
import com.github.itdachen.admin.sdk.dto.AppClientDto;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.admin.service.IAppClientService;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
@Service
public class AppClientServiceImpl extends BizServiceImpl<IAppClientMapper, IAppClientConvert, AppClient, AppClientDto, AppClientVo, AppClientQuery, String> implements IAppClientService {
    private static final Logger logger = LoggerFactory.getLogger(AppClientServiceImpl.class);
    private static final AppClientConvert bizConvert = new AppClientConvert();

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:25
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.AppClientVo>
     */
    @Override
    public TableData<AppClientVo> page(AppClientQuery params) throws Exception {
        Page<AppClientVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<AppClientVo> list = bizMapper.page(params);
        return new TableData<AppClientVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/5 21:06
     * @param appClientDto appClientDto
     * @return com.github.itdachen.admin.entity.AppClient
     */
    @Override
    public AppClientVo save(AppClientDto appClientDto) throws BizException {
        AppClient appClient = bizConvert.toJavaObject(appClientDto);
        appClient.setCanDel(YesOrNotConstant.YES);
        EntityUtils.setCreatAndUpdateInfo(appClient);
        bizMapper.insertSelective(appClient);
        return bizConvert.toJavaObjectVo(appClient);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2023/4/5 21:08
     * @param appClientDto appClientDto
     * @return com.github.itdachen.admin.entity.AppClient
     */
    @Override
    public AppClientVo update(AppClientDto appClientDto) throws BizException {
        AppClient appClient = bizConvert.toJavaObject(appClientDto);
        AppClient dnAppClient = bizMapper.selectByPrimaryKey(appClient.getId());
        if (YesOrNotConstant.NOT.equals(dnAppClient.getCanDel())) {
            // 不能删除的应用,这里不能修改不能删除其状态和禁用状态
            if (YesOrNotConstant.YES.equals(appClient.getCanDel())
                    || YesOrNotConstant.NOT.equals(appClient.getStatus())) {
                throw new BizException("非法操作");
            }
        }
        EntityUtils.setUpdatedInfo(appClient);
        bizMapper.updateByPrimaryKeySelective(appClient);
        return bizConvert.toJavaObjectVo(appClient);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2023/4/5 21:06
     * @param id id
     * @return int
     */
    @Override
    public int remove(String id) throws BizException {
        AppClient appClient = bizMapper.selectByPrimaryKey(id);
        if (null == appClient) {
            return 0;
        }
        Integer hasMenu = bizMapper.hasMenu(appClient.getAppCode());
        if (null != hasMenu) {
            throw new BizException("该应用已存在菜单,不能删除");
        }
        if (YesOrNotConstant.NOT.equals(appClient.getCanDel())) {
            throw new BizException("该应用不能删除");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 更改状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:05
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.AppClientVo
     */
    @Override
    public void updateStatus(String id, Boolean status) throws BizException {
        AppClient appClient = bizMapper.selectByPrimaryKey(id);
        if (YesOrNotConstant.NOT.equals(appClient.getCanDel())
                && YesOrNotConstant.YES.equals(appClient.getStatus())) {
            throw new BizException("该应用不能被禁用");
        }
        if (status) {
            appClient.setStatus(YesOrNotConstant.YES);
        } else {

            appClient.setStatus(YesOrNotConstant.NOT);
        }
        EntityUtils.setUpdatedInfo(appClient);
        bizMapper.updateByPrimaryKeySelective(appClient);
    }

}
