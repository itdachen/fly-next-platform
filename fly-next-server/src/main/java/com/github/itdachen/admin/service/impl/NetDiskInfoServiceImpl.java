package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.NetDiskInfoConvert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.NetDiskInfo;
import com.github.itdachen.admin.mapper.INetDiskInfoMapper;
import com.github.itdachen.admin.service.INetDiskInfoService;
import com.github.itdachen.admin.sdk.dto.NetDiskInfoDto;
import com.github.itdachen.admin.sdk.query.NetDiskInfoQuery;
import com.github.itdachen.admin.sdk.vo.NetDiskInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件信息表 serverImpl
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
@Service
public class NetDiskInfoServiceImpl implements INetDiskInfoService {
    private static final Logger logger = LoggerFactory.getLogger(NetDiskInfoServiceImpl.class);

    private final INetDiskInfoMapper netDiskInfoMapper;

    public NetDiskInfoServiceImpl(INetDiskInfoMapper netDiskInfoMapper) {
        this.netDiskInfoMapper = netDiskInfoMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/17 1:39
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.NetDiskInfoVo>
     */
    @Override
    public TableData< NetDiskInfoVo > findNetDiskInfoPage(NetDiskInfoQuery params) throws Exception {
        Page< NetDiskInfoVo > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< NetDiskInfoVo > list = netDiskInfoMapper.findNetDiskInfoPage(params);
        return new TableData< NetDiskInfoVo >(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskInfoDto netDiskInfoDto
     * @return com.github.itdachen.admin.sdk.dto.netDiskInfo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public NetDiskInfoDto saveNetDiskInfo(NetDiskInfoDto netDiskInfoDto) throws Exception {
        NetDiskInfo netDiskInfo = NetDiskInfoConvert.toJavaObject(netDiskInfoDto);
        BeanUtils.copyProperties(netDiskInfoDto, netDiskInfo);
        EntityUtils.setCreatAndUpdateInfo(netDiskInfo);
        netDiskInfoMapper.saveNetDiskInfo(netDiskInfo);
        netDiskInfoDto.setId(netDiskInfo.getId());
        return netDiskInfoDto;
    }

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.NetDiskInfoVo
     */
    @Override
    public NetDiskInfoVo getNetDiskInfoById(String id) throws Exception {
        return netDiskInfoMapper.getById(id);
    }

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskInfoDto netDiskInfoDto
     * @return com.github.itdachen.admin.sdk.dto.netDiskInfo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public NetDiskInfoDto updateNetDiskInfo(NetDiskInfoDto netDiskInfoDto) throws Exception {
        NetDiskInfo netDiskInfo = NetDiskInfoConvert.toJavaObject(netDiskInfoDto);
        EntityUtils.setUpdatedInfo(netDiskInfo);
        netDiskInfoMapper.updateNetDiskInfo(netDiskInfo);
        return netDiskInfoDto;
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeNetDiskInfo(String id) throws Exception {
           return netDiskInfoMapper.deleteNetDiskInfoById(id);
    }

}
