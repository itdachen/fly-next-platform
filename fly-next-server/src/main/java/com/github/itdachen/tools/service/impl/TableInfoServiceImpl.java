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
import com.github.itdachen.tools.entity.GenComment;
import com.github.itdachen.tools.entity.GenTable;
import com.github.itdachen.tools.entity.TableColumn;
import com.github.itdachen.tools.entity.TableInfo;
import com.github.itdachen.tools.mapper.ITableColumnMapper;
import com.github.itdachen.tools.mapper.ITableInfoMapper;
import com.github.itdachen.tools.sdk.dto.TableColumnDto;
import com.github.itdachen.tools.sdk.dto.TableInfoDto;
import com.github.itdachen.tools.sdk.query.GenTableQuery;
import com.github.itdachen.tools.sdk.query.TableInfoQuery;
import com.github.itdachen.tools.sdk.vo.TableColumnVo;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;
import com.github.itdachen.tools.service.ITableInfoService;
import com.github.itdachen.tools.utils.GenConstants;
import com.github.itdachen.tools.utils.GeneratorUtils;
import com.github.itdachen.tools.utils.VelocityInitializer;
import com.github.itdachen.tools.utils.VelocityUtils;
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
    private final Environment environment;

    public TableInfoServiceImpl(ITableInfoMapper tableInfoMapper,
                                ITableColumnMapper tableColumnMapper,
                                Environment environment) {
        this.tableInfoMapper = tableInfoMapper;
        this.tableColumnMapper = tableColumnMapper;
        this.environment = environment;
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
    public TableData<GenTable> dbList(GenTableQuery query) throws BizException {
        Page<GenTable> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<GenTable> list = tableInfoMapper.dbList(query);
        return new TableData<GenTable>(page.getTotal(), list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GenTable importGenTable(String tableNames) throws BizException {
        if (null == tableNames) {
            return null;
        }
        List<String> strings = new ArrayList<>(Arrays.asList(tableNames.split(",")));
        if (0 == strings.size()) {
            throw new BizException("请选择表");
        }
        List<GenTable> tableList = tableInfoMapper.findTableList(strings);
        if (null == tableList || 0 == tableList.size()) {
            throw new BizException("该表不存在");
        }


        List<GenComment> genComments;
        TableColumn column;
        TableInfo tableInfo;
        List<TableColumn> columns = new ArrayList<>();
        List<TableInfo> tableInfos = new ArrayList<>();
        int index;
        for (GenTable genTable : tableList) {
            tableInfo = new TableInfo();
            EntityUtils.setCreatAndUpdateInfo(tableInfo);
            tableInfo.setTableName(genTable.getTableName());
            tableInfo.setFunctionAuthor(BizContextHandler.getUserName());
            tableInfo.setTableComment(genTable.getTableComment());
            tableInfo.setClassName(GeneratorUtils.tableToJava(genTable.getTableName(), ""));
            tableInfo.setPackageName(GenConstants.PACKAGE_NAME);
            tableInfo.setModuleName(GenConstants.MODULE_NAME);
            tableInfo.setFunctionName(genTable.getTableComment());
            tableInfo.setFunctionAuthor(BizContextHandler.getUserName());
            tableInfo.setGenType("0");
            tableInfo.setTplCategory(GenConstants.TPL_BIZ);
            //  tableInfo.setContextPath(GenConstants.MODULE_NAME);
            tableInfo.setContextPath(ContextPathHandler.contextPath());
            tableInfo.setBusinessName("/" + genTable.getTableName().toLowerCase().replaceAll("_", "/"));
            tableInfo.setMenuId(GenConstants.PARENT_MENU_ID);

            tableInfoMapper.saveTableInfo(tableInfo);

            tableInfos.add(tableInfo);
            /* 字段信息 */
            genComments = tableInfoMapper.findTableColumns(genTable.getTableName());
            index = 1;
            for (GenComment genComment : genComments) {
                column = new TableColumn();
                EntityUtils.setCreatAndUpdateInfo(column);
                column.setTableId(tableInfo.getId());
                column.setColumnName(genComment.getColumnName());
                column.setColumnComment(genComment.getColumnComment());
                column.setColumnType(genComment.getDataType());
                column.setSort(index);
                column.setIsPk("0");
                if ("PRI".equals(genComment.getColumnKey())) {
                    column.setIsPk("1");
                }
                if ("P".equals(genComment.getColumnKey())) {
                    column.setIsPk("1");
                }
                initColumnField(column);

                tableColumnMapper.saveTableColumn(column);

                columns.add(column);
                index++;
            }

        }

//        if (0 < tableInfos.size()) {
//            tableInfoMapper.batchSave(tableInfos);
//            tableColumnMapper.batchSave(columns);
//        }

        return null;
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
        Map<String, String> dataMap = new LinkedHashMap<>();
        TableInfoVo tableInfoVo = tableInfoMapper.findTableInfoVoById(id);
        // 设置主键列信息
        setPkColumn(tableInfoVo);
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
            dataMap.put(template, sw.toString());
        }
        return dataMap;
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


    /***
     * 初始化表类型
     *
     * @author 王大宸
     * @date 2022/8/14 16:04
     * @param column column
     * @return void
     */
    private void initColumnField(TableColumn column) {
        // 默认不需要
        column.setIsList(GenConstants.NOT_REQUIRE);
        column.setIsQuery(GenConstants.NOT_REQUIRE);
        column.setIsDtoVo(GenConstants.NOT_REQUIRE);
        column.setIsForm(GenConstants.NOT_REQUIRE);
        column.setIsRequired(GenConstants.NOT_REQUIRE);

        // 数据类型
        String dataType = getDbType(column.getColumnType());
        String columnName = column.getColumnName();
        // 设置java字段名
        column.setJavaField(GeneratorUtils.toCamelCase(columnName));
        // 设置默认类型
        column.setJavaType(GenConstants.TYPE_STRING);
        column.setQueryType(GenConstants.QUERY_EQ);
        column.setHtmlType(GenConstants.HTML_INPUT);

        if (arraysContains(GenConstants.COLUMNTYPE_STR, dataType)
                || arraysContains(GenConstants.COLUMNTYPE_TEXT, dataType)) {
            // 字符串长度超过500设置为文本域
            Integer columnLength = getColumnLength(column.getColumnType());
            String htmlType = columnLength >= 500 || arraysContains(GenConstants.COLUMNTYPE_TEXT, dataType) ? GenConstants.HTML_TEXTAREA : GenConstants.HTML_INPUT;
            column.setHtmlType(htmlType);
        } else if (arraysContains(GenConstants.COLUMNTYPE_TIME, dataType)) {
            column.setJavaType(GenConstants.TYPE_DATE);
            column.setHtmlType(GenConstants.HTML_DATETIME);
        } else if (arraysContains(GenConstants.COLUMN_TYPE_INTEGER, dataType)) {
            // Integer 类型
            column.setJavaType(GenConstants.TYPE_INTEGER);
        } else if (arraysContains(GenConstants.COLUMN_TYPE_LONG, dataType)) {
            // Long
            column.setJavaType(GenConstants.TYPE_LONG);
        } else if (arraysContains(GenConstants.COLUMN_TYPE_DECIMAL, dataType)) {
            // BigDecimal
            column.setJavaType(GenConstants.TYPE_BIGDECIMAL);
        } else if (arraysContains(GenConstants.COLUMN_TYPE_DOUBLE, dataType)) {
            // Double
            column.setJavaType(GenConstants.TYPE_DOUBLE);
        } else if (arraysContains(GenConstants.COLUMN_TYPE_FLOAT, dataType)) {
            // Float
            column.setJavaType(GenConstants.TYPE_FLOAT);
        } else if (arraysContains(GenConstants.COLUMN_TYPE_BIT, dataType)) {
            // Boolean
            column.setJavaType(GenConstants.TYPE_BOOLEAN);
        }

        // 表单字段
        if (!arraysContains(GenConstants.FIELD_NOT_FORM, columnName)) {
            column.setIsForm(GenConstants.REQUIRE);
        }
        // 必填字段
        if (!arraysContains(GenConstants.COLUMN_NAME_NOT_REQUIRED, columnName)) {
            column.setIsRequired(GenConstants.REQUIRE);
        }
        // 列表字段
        if (!arraysContains(GenConstants.COLUMN_NAME_NOT_LIST, columnName) && "0".equals(column.getIsPk())) {
            column.setIsList(GenConstants.REQUIRE);
        }
        // 查询字段
        if (!arraysContains(GenConstants.COLUMNNAME_NOT_QUERY, columnName) && "0".equals(column.getIsPk())) {
            column.setIsQuery(GenConstants.REQUIRE);
        }
        // dto/vo 字段
        if (!arraysContains(GenConstants.USER_FIELD, columnName)) {
            column.setIsDtoVo(GenConstants.REQUIRE);
        }


        // 查询字段类型
        if (StringUtils.endsWithIgnoreCase(columnName, "name")
                || StringUtils.endsWithIgnoreCase(columnName, "title")) {
            column.setQueryType(GenConstants.QUERY_LIKE);
        }

        // 状态字段设置单选框
        if (StringUtils.endsWithIgnoreCase(columnName, "status")) {
            column.setHtmlType(GenConstants.HTML_RADIO);
        }
        // 类型&性别字段设置下拉框
        else if (StringUtils.endsWithIgnoreCase(columnName, "type")
                || StringUtils.endsWithIgnoreCase(columnName, "sex")) {
            column.setHtmlType(GenConstants.HTML_SELECT);
        }
        // 图片字段设置图片上传控件
        else if (StringUtils.endsWithIgnoreCase(columnName, "image")) {
            column.setHtmlType(GenConstants.HTML_IMAGE_UPLOAD);
        }
        // 文件字段设置文件上传控件
        else if (StringUtils.endsWithIgnoreCase(columnName, "file")) {
            column.setHtmlType(GenConstants.HTML_FILE_UPLOAD);
        }
        // 内容字段设置富文本控件
        else if (StringUtils.endsWithIgnoreCase(columnName, "content")) {
            column.setHtmlType(GenConstants.HTML_EDITOR);
        }
    }

    public static boolean arraysContains(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue.toLowerCase());
    }

    /***
     * 获取字段长度
     *
     * @author 王大宸
     * @date 2022/8/14 16:04
     * @param columnType columnType
     * @return java.lang.Integer
     */
    public static Integer getColumnLength(String columnType) {
        if (StringUtils.indexOf(columnType, "(") > 0) {
            String length = StringUtils.substringBetween(columnType, "(", ")");
            return Integer.valueOf(length);
        } else {
            return 0;
        }
    }

    public static String getDbType(String columnType) {
        if (StringUtils.indexOf(columnType, "(") > 0) {
            return StringUtils.substringBefore(columnType, "(");
        } else {
            return columnType;
        }
    }

    private void generatorCode(String id, ZipOutputStream zip) {
        TableInfoVo tableInfoVo = tableInfoMapper.findTableInfoVoById(id);
        setPkColumn(tableInfoVo);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(tableInfoVo);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(tableInfoVo.getTplCategory());
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
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

    /**
     * 设置主键列信息
     *
     * @param table 业务表信息
     */
    public void setPkColumn(TableInfoVo table) {
        for (TableColumnVo column : table.getColumns()) {
            if (column.isPk()) {
                table.setPkColumn(column);
                break;
            }
        }
        if (StringUtils.isNull(table.getPkColumn())) {
            table.setPkColumn(table.getColumns().get(0));
        }
    }

}
