package com.github.itdachen.tools.service.impl;

import com.github.itdachen.admin.utils.AppClientUtils;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.boot.runner.handler.ContextPathHandler;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.constants.Constants;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.tools.entity.*;
import com.github.itdachen.tools.mapper.ITableColumnMapper;
import com.github.itdachen.tools.mapper.ITableInfoMapper;
import com.github.itdachen.tools.sdk.dto.TableColumnDto;
import com.github.itdachen.tools.sdk.dto.TableInfoDto;
import com.github.itdachen.tools.sdk.query.GenTableQuery;
import com.github.itdachen.tools.sdk.query.TableInfoQuery;
import com.github.itdachen.tools.sdk.vo.TableColumnVo;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;
import com.github.itdachen.tools.service.ITableInfoService;
import com.github.itdachen.tools.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

    public TableInfoServiceImpl(ITableInfoMapper tableInfoMapper,
                                ITableColumnMapper tableColumnMapper) {
        this.tableInfoMapper = tableInfoMapper;
        this.tableColumnMapper = tableColumnMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param params cn.edu.hubu.tools.sdk.query.TableInfoQuery
     * @return cn.edu.hubu.common.framework.core.response.TableData<cn.edu.hubu.tools.sdk.vo.TableInfoVo>
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
     * @date 2022-08-10 15:17:41
     * @param tableInfoDto tableInfoDto
     * @return cn.edu.hubu.tools.sdk.dto.tableInfo
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
     * @date 2022-08-10 15:17:41
     * @param id 需要查询数据的id
     * @return cn.edu.hubu.tools.sdk.vo.TableInfoVo
     */
    @Override
    public TableInfoVo getTableInfoById(String id) throws BizException {
        return tableInfoMapper.findTableInfoVoById(id);
    }

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param tableInfoDto tableInfoDto
     * @return cn.edu.hubu.tools.sdk.dto.tableInfo
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
    public void importGenTable(String tableNames, String uiStyle) throws BizException {
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
        ProtoTableInfo protoTableInfo = TableColumnFieldUtils.pottingTableInfo(tableList, uiStyle);
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
    public byte[] downloadCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            generatorCode(tableName, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
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
    public Map<String, String> previewCode(String id) throws BizException {
        TableInfoVo tableInfoVo = tableInfoMapper.findTableInfoVoById(id);
        return PreviewCodeUtils.previewCode(tableInfoVo);
    }

    /***
     * 获取菜单目录
     *
     * @author 王大宸
     * @date 2022/9/5 13:45
     * @return java.util.List<cn.edu.hubu.framework.context.node.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> dirtZTree() throws BizException {
        List<ZTreeNode> apps = tableInfoMapper.findAppAll();
        apps = AppClientUtils.arrangeAppMenu(ContextPathHandler.contextPath(), apps);
        List<ZTreeNode> zTree = tableInfoMapper.findDirtZTree();
        apps.addAll(zTree);
        return apps;
    }

    /***
     * 数据字典
     *
     * @author 王大宸
     * @date 2022/9/5 14:46
     * @return java.util.List<cn.edu.hubu.framework.context.node.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> dictList() throws BizException {
        return tableInfoMapper.dictList();
    }


    /***
     * 添加字段
     *
     * @author 王大宸
     * @date 2023/2/16 11:27
     * @param tableColumn tableColumn
     * @return cn.edu.hubu.tools.entity.TableColumn
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
     * @date 2023/2/16 14:45
     * @param tableInfo tableInfo
     * @return cn.edu.hubu.tools.entity.TableInfo
     */
    @Override
    public TableInfo saveTable(TableInfo tableInfo) throws BizException {
        EntityUtils.setCreatAndUpdateInfo(tableInfo);
        tableInfo.setFunctionAuthor(BizContextHandler.getUserName());
        tableInfoMapper.saveTableInfo(tableInfo);
        return tableInfo;
    }


    private void generatorCode(String id, ZipOutputStream zip) {
        TableInfoVo tableInfoVo = tableInfoMapper.findTableInfoVoById(id);
        PkColumnUtils.setPkColumn(tableInfoVo);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(tableInfoVo);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(tableInfoVo.getTplCategory());
        StringWriter sw;
        Template tpl;
        for (String template : templates) {
            // 渲染模板
            sw = new StringWriter();
            tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            try {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(VelocityUtils.getFileName(template, tableInfoVo)));
                IOUtils.write(sw.toString(), zip, Constants.UTF8);
                IOUtils.closeQuietly(sw);
                zip.flush();
                zip.closeEntry();
            } catch (IOException e) {
                logger.error("渲染模板失败，表名：" + tableInfoVo.getTableName(), e);
            }
        }
    }


}
