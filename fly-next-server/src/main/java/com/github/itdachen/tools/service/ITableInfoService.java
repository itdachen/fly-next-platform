package com.github.itdachen.tools.service;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.tools.entity.GenTable;
import com.github.itdachen.tools.entity.TableColumn;
import com.github.itdachen.tools.entity.TableInfo;
import com.github.itdachen.tools.sdk.dto.TableInfoDto;
import com.github.itdachen.tools.sdk.query.GenTableQuery;
import com.github.itdachen.tools.sdk.query.TableInfoQuery;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;

import java.util.List;
import java.util.Map;

/**
 * 代码生成业务表 业务接口
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
public interface ITableInfoService {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param params cn.edu.hubu.tools.query.TableInfoQuery
     * @return cn.edu.hubu.common.framework.core.response.TableData<cn.edu.hubu.tools.sdk.vo.TableInfoVo>
     */
    TableData<TableInfoVo> findTableInfoPage(TableInfoQuery params) throws BizException;

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param tableInfoDto tableInfoDto
     * @return cn.edu.hubu.tools.sdk.dto.tableInfo
     */
    TableInfoDto saveTableInfo(TableInfoDto tableInfoDto) throws BizException;

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要查询数据的id
     * @return cn.edu.hubu.tools.sdk.vo.TableInfoVo
     */
    TableInfoVo getTableInfoById(String id) throws BizException;

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param tableInfoDto tableInfoDto
     * @return cn.edu.hubu.tools.sdk.dto.tableInfo
     */
    TableInfoDto updateTableInfo(TableInfoDto tableInfoDto) throws BizException;

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int removeTableInfo(String id) throws BizException;

    /***
     * 查询数据库中的表
     *
     * @author 王大宸
     * @date 2022/8/14 15:48
     * @param query query
     * @return cn.edu.hubu.common.framework.core.response.TableData<cn.edu.hubu.tools.entity.GenTable>
     */
    TableData<GenTable> dbList(GenTableQuery query) throws BizException;

    /***
     * 导入表
     *
     * @author 王大宸
     * @date 2022/8/14 15:49
     * @param tableName tableName
     * @return cn.edu.hubu.tools.entity.GenTable
     */
    GenTable importGenTable(String tableName) throws BizException;

    /***
     * 生成代码
     *
     * @author 王大宸
     * @date 2022/8/16 22:04
     * @param tableNames tableNames
     * @return byte[]
     */
    byte[] downloadCode(String[] tableNames);

    /***
     * 预览代码
     *
     * @author 王大宸
     * @date 2022/8/16 23:51
     * @param id id
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    Map<String, String> previewCode(String id) throws BizException;

    /***
     * 获取菜单目录
     *
     * @author 王大宸
     * @date 2022/9/5 13:45
     * @return java.util.List<cn.edu.hubu.framework.context.node.ZTreeNode>
     */
    List<ZTreeNode> dirtZTree() throws BizException;

    /***
     * 数据字典
     *
     * @author 王大宸
     * @date 2022/9/5 14:46
     * @return java.util.List<cn.edu.hubu.framework.context.node.ZTreeNode>
     */
    List<ZTreeNode> dictList() throws BizException;

    /***
     * 添加字段
     *
     * @author 王大宸
     * @date 2023/2/16 11:27
     * @param tableColumn tableColumn
     * @return cn.edu.hubu.tools.entity.TableColumn
     */
    TableColumn saveTableColumn(TableColumn tableColumn)throws BizException;

    /***
     * 新增表格
     *
     * @author 王大宸
     * @date 2023/2/16 14:46
     * @param tableInfo tableInfo
     * @return cn.edu.hubu.tools.entity.TableInfo
     */
    TableInfo saveTable(TableInfo tableInfo)throws BizException;


}
