package com.github.itdachen.tools.service.impl;

import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.tools.entity.TableColumn;
import com.github.itdachen.tools.mapper.ITableColumnMapper;
import com.github.itdachen.tools.sdk.dto.TableColumnDto;
import com.github.itdachen.tools.sdk.query.TableColumnQuery;
import com.github.itdachen.tools.sdk.vo.TableColumnVo;
import com.github.itdachen.tools.service.ITableColumnService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 代码生成业务表字段 serverImpl
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
@Service
public class TableColumnServiceImpl implements ITableColumnService {
    private static final Logger logger = LoggerFactory.getLogger(TableColumnServiceImpl.class);

    private final ITableColumnMapper tableColumnMapper;

    public TableColumnServiceImpl(ITableColumnMapper tableColumnMapper) {
        this.tableColumnMapper = tableColumnMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param params cn.edu.hubu.tools.sdk.query.TableColumnQuery
     * @return cn.edu.hubu.common.framework.core.response.TableData<cn.edu.hubu.tools.sdk.vo.TableColumnVo>
     */
    @Override
    public TableData<TableColumnVo> findTableColumnPage(TableColumnQuery params) throws BizException {
        Page<TableColumnVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<TableColumnVo> list = tableColumnMapper.findTableColumnPage(params);
        return new TableData<TableColumnVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param tableColumnDto tableColumnDto
     * @return cn.edu.hubu.tools.sdk.dto.tableColumn
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TableColumnDto saveTableColumn(TableColumnDto tableColumnDto) throws BizException {
        TableColumn tableColumn = new TableColumn();
        BeanUtils.copyProperties(tableColumnDto, tableColumn);
        EntityUtils.setCreatAndUpdateInfo(tableColumn);
        tableColumnMapper.saveTableColumn(tableColumn);
        tableColumnDto.setId(tableColumn.getId());
        return tableColumnDto;
    }

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param id 需要查询数据的id
     * @return cn.edu.hubu.tools.sdk.vo.TableColumnVo
     */
    @Override
    public TableColumnVo getTableColumnById(String id) throws BizException {
        return tableColumnMapper.getById(id);
    }

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param tableColumnDto tableColumnDto
     * @return cn.edu.hubu.tools.sdk.dto.tableColumn
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TableColumnDto updateTableColumn(TableColumnDto tableColumnDto) throws BizException {
        TableColumn tableColumn = new TableColumn();
        BeanUtils.copyProperties(tableColumnDto, tableColumn);
        EntityUtils.setUpdatedInfo(tableColumn);
        tableColumnMapper.updateTableColumn(tableColumn);
        return tableColumnDto;
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeTableColumn(String id) throws BizException {
           return tableColumnMapper.deleteTableColumnById(id);
    }

}
