package com.github.itdachen.tools.service.impl;

import com.github.itdachen.admin.manager.IAppClientManager;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.boot.runner.handler.ContextPathHandler;
import com.github.itdachen.framework.code.CodeHelper;
import com.github.itdachen.framework.code.entity.ProtoTable;
import com.github.itdachen.framework.code.entity.ProtoTableInfo;
import com.github.itdachen.framework.code.entity.TableColumn;
import com.github.itdachen.framework.code.entity.TableInfo;
import com.github.itdachen.framework.code.sdk.dto.TableColumnDto;
import com.github.itdachen.framework.code.sdk.dto.TableInfoDto;
import com.github.itdachen.framework.code.sdk.query.GenTableQuery;
import com.github.itdachen.framework.code.sdk.query.TableInfoQuery;
import com.github.itdachen.framework.code.sdk.vo.TableInfoVo;
import com.github.itdachen.framework.code.utils.TableColumnFieldUtils;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.tools.mapper.ITableColumnMapper;
import com.github.itdachen.tools.mapper.ITableInfoMapper;
import com.github.itdachen.tools.service.ITableInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 代码生成业务表 业务实现
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {
    private static final Logger logger = LoggerFactory.getLogger(TableInfoServiceImpl.class);

    private final ITableInfoMapper tableInfoMapper;
    private final ITableColumnMapper tableColumnMapper;
    private final IAppClientManager appClientManager;

    public TableInfoServiceImpl(ITableInfoMapper tableInfoMapper,
                                ITableColumnMapper tableColumnMapper,
                                IAppClientManager appClientManager) {
        this.tableInfoMapper = tableInfoMapper;
        this.tableColumnMapper = tableColumnMapper;
        this.appClientManager=appClientManager;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:04
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.framework.code.sdk.vo.TableInfoVo>
     */
    @Override
    public TableData<TableInfoVo> findTableInfoPage(TableInfoQuery params) throws BizException {
        Page<TableInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<TableInfoVo> list = tableInfoMapper.findTableInfoPage(params);
        return new TableData<TableInfoVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/11 21:09
     * @param tableInfoDto tableInfoDto
     * @return com.github.itdachen.framework.code.sdk.dto.TableInfoDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TableInfoDto saveTableInfo(TableInfoDto tableInfoDto) throws BizException {
        TableInfo tableInfo = new TableInfo();
        BeanUtils.copyProperties(tableInfoDto, tableInfo);
        EntityUtils.setCreatAndUpdateInfo(tableInfo);
        tableInfoMapper.saveTableInfo(tableInfo);
        tableInfoDto.setId(tableInfo.getId());
        return tableInfoDto;
    }

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023/4/11 21:09
     * @param id id
     * @return com.github.itdachen.framework.code.sdk.vo.TableInfoVo
     */
    @Override
    public TableInfoVo getTableInfoById(String id) throws BizException {
        return tableInfoMapper.findTableInfoVoById(id);
    }

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2023/4/11 21:09
     * @param tableInfoDto tableInfoDto
     * @return com.github.itdachen.framework.code.sdk.dto.TableInfoDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TableInfoDto updateTableInfo(TableInfoDto tableInfoDto) throws BizException {
        TableInfo tableInfo = new TableInfo();
        BeanUtils.copyProperties(tableInfoDto, tableInfo);
        tableInfoMapper.updateTableInfo(tableInfo);

        List<TableColumnDto> columns = tableInfoDto.getColumns();
        TableColumn one;
        for (TableColumnDto column : columns) {
            one = new TableColumn();
            BeanUtils.copyProperties(column, one);
            one.setIsPk("1");
            if ("0".equals(column.getIsPk())) {
                one.setIsPk("0");
            }
            EntityUtils.setUpdatedInfo(one);
            tableColumnMapper.updateTableColumn(one);
        }
        return tableInfoDto;
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeTableInfo(String id) throws BizException {
        tableInfoMapper.deleteTableInfoById(id);
        tableColumnMapper.deleteByTable(id);
        return 1;
    }

    @Override
    public TableData<ProtoTable> dbList(GenTableQuery query) throws BizException {
        Page<ProtoTable> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<ProtoTable> list = tableInfoMapper.dbList(query);
        return new TableData<ProtoTable>(page.getTotal(), list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importGenTable(String tableNames, String clientId, String uiStyle) throws BizException {
        if (null == tableNames) {
            throw new BizException("请选择表");
        }
        List<String> strings = new ArrayList<>(Arrays.asList(tableNames.split(",")));
        if (0 == strings.size()) {
            throw new BizException("请选择表");
        }
        List<ProtoTable> tableList = tableInfoMapper.findTableList(strings);
        if (null == tableList || 0 == tableList.size()) {
            throw new BizException("该表不存在");
        }

        for (ProtoTable protoTable : tableList) {
            protoTable.setColumns(tableInfoMapper.findTableColumns(protoTable.getTableName()));
        }
        ProtoTableInfo protoTableInfo = TableColumnFieldUtils.pottingTableInfo(tableList, clientId, uiStyle);
        if (0 < protoTableInfo.getTableInfos().size()) {
            tableInfoMapper.batchSave(protoTableInfo.getTableInfos());
        }
        if (0 < protoTableInfo.getTableColumns().size()) {
            tableColumnMapper.batchSave(protoTableInfo.getTableColumns());
        }
    }

    /***
     * 生成代码
     *
     * @author 王大宸
     * @date 2022/8/16 22:04
     * @param tableNames tableNames
     * @return byte[]
     */
    @Override
    public void downloadCode(String[] tableNames, HttpServletResponse response) throws Exception {
        List<TableInfoVo> list = new ArrayList<>();
        for (String tableName : tableNames) {
            list.add(tableInfoMapper.findTableInfoVoById(tableName));
        }
        CodeHelper.downloadCode(list, response);
    }

    /***
     * 预览代码
     *
     * @author 王大宸
     * @date 2022/8/16 23:20
     * @param id id
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    @Override
    public Map<String, String> previewCode(String id) throws Exception {
        TableInfoVo tableInfoVo = tableInfoMapper.findTableInfoVoById(id);
        return CodeHelper.previewCode(tableInfoVo);
    }

    /***
     * 获取菜单目录
     *
     * @author 王大宸
     * @date 2022/9/5 13:45
     * @return java.util.List
     */
    @Override
    public List<ZTreeNode> dirtZTree() throws BizException {
        List<ZTreeNode> apps = tableInfoMapper.findAppAll();
        apps = appClientManager.arrangeAppMenu(ContextPathHandler.contextPath(), apps);
        List<ZTreeNode> zTree = tableInfoMapper.findDirtZTree();
        apps.addAll(zTree);
        return apps;
    }

    /***
     * 数据字典
     *
     * @author 王大宸
     * @date 2022/9/5 14:46
     * @return java.util.List
     */
    @Override
    public List<ZTreeNode> dictList() throws BizException {
        return tableInfoMapper.dictList();
    }

    /***
     * 获取应用列表
     *
     * @author 王大宸
     * @date 2023/3/1 14:29
     * @return java.util.List
     */
    @Override
    public List<ZTreeNode> appInfoList() throws BizException {
        return tableInfoMapper.findAppAll();
    }


    /***
     * 添加字段
     *
     * @author 王大宸
     * @date 2023/4/11 21:09
     * @param tableColumn tableColumn
     * @return com.github.itdachen.framework.code.entity.TableColumn
     */
    @Override
    public TableColumn saveTableColumn(TableColumn tableColumn) throws BizException {
        EntityUtils.setCreatAndUpdateInfo(tableColumn);
        tableColumnMapper.saveTableColumn(tableColumn);
        return tableColumn;
    }

    /***
     * 新增表格
     *
     * @author 王大宸
     * @date 2023/4/11 21:25
     * @param tableInfo tableInfo
     * @return com.github.itdachen.framework.code.entity.TableInfo
     */
    @Override
    public TableInfo saveTable(TableInfo tableInfo) throws BizException {
        EntityUtils.setCreatAndUpdateInfo(tableInfo);
        tableInfo.setFunctionAuthor(BizContextHandler.getNickName());
        tableInfoMapper.saveTableInfo(tableInfo);
        return tableInfo;
    }

}
