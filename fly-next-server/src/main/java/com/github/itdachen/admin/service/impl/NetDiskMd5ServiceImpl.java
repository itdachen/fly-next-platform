package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.NetDiskMd5;
import com.github.itdachen.admin.mapper.INetDiskMd5Mapper;
import com.github.itdachen.admin.service.INetDiskMd5Service;
import com.github.itdachen.admin.sdk.dto.NetDiskMd5Dto;
import com.github.itdachen.admin.sdk.query.NetDiskMd5Query;
import com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件MD5 serverImpl
 *
 * @author 王大宸
 * @date 2023-04-14 23:20:54
 */
@Service
public class NetDiskMd5ServiceImpl implements INetDiskMd5Service {
    private static final Logger logger = LoggerFactory.getLogger(NetDiskMd5ServiceImpl.class);

    private final INetDiskMd5Mapper netDiskMd5Mapper;

    public NetDiskMd5ServiceImpl(INetDiskMd5Mapper netDiskMd5Mapper) {
        this.netDiskMd5Mapper = netDiskMd5Mapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/17 1:39
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo>
     */
    @Override
    public TableData<NetDiskMd5Vo> findNetDiskMd5Page(NetDiskMd5Query params) throws Exception {
        Page<NetDiskMd5Vo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<NetDiskMd5Vo> list = netDiskMd5Mapper.findNetDiskMd5Page(params);
        return new TableData<NetDiskMd5Vo>(page.getTotal(), list);
    }

    /***
     * 根据 文件MD5 查询文件信息
     *
     * @author 王大宸
     * @date 2023/4/14 23:27
     * @param md5Hex md5Hex
     * @return com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo
     */
    @Override
    public NetDiskMd5Vo findNetDiskMd5(String md5Hex) {
        return netDiskMd5Mapper.findNetDiskMd5(md5Hex);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskMd5Dto netDiskMd5Dto
     * @return com.github.itdachen.admin.sdk.dto.netDiskMd5
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public NetDiskMd5Dto saveNetDiskMd5(NetDiskMd5Dto netDiskMd5Dto) throws Exception {
        NetDiskMd5 netDiskMd5 = new NetDiskMd5();
        BeanUtils.copyProperties(netDiskMd5Dto, netDiskMd5);
        EntityUtils.setCreatAndUpdateInfo(netDiskMd5);
        netDiskMd5Mapper.saveNetDiskMd5(netDiskMd5);
        netDiskMd5Dto.setId(netDiskMd5.getId());
        return netDiskMd5Dto;
    }

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param id 需要查询数据的id
     * @return com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo
     */
    @Override
    public NetDiskMd5Vo getNetDiskMd5ById(String id) throws Exception {
        return netDiskMd5Mapper.getById(id);
    }

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2023-04-14 23:20:54
     * @param netDiskMd5Dto netDiskMd5Dto
     * @return com.github.itdachen.admin.sdk.dto.netDiskMd5
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public NetDiskMd5Dto updateNetDiskMd5(NetDiskMd5Dto netDiskMd5Dto) throws Exception {
        NetDiskMd5 netDiskMd5 = new NetDiskMd5();
        BeanUtils.copyProperties(netDiskMd5Dto, netDiskMd5);
        EntityUtils.setUpdatedInfo(netDiskMd5);
        netDiskMd5Mapper.updateNetDiskMd5(netDiskMd5);
        return netDiskMd5Dto;
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
    public int removeNetDiskMd5(String id) throws Exception {
        return netDiskMd5Mapper.deleteNetDiskMd5ById(id);
    }

}
