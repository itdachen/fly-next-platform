package com.github.itdachen.tools.service;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.code.entity.ProtoTable;
import com.github.itdachen.framework.code.entity.TableColumn;
import com.github.itdachen.framework.code.entity.TableInfo;
import com.github.itdachen.framework.code.sdk.dto.TableInfoDto;
import com.github.itdachen.framework.code.sdk.query.GenTableQuery;
import com.github.itdachen.framework.code.sdk.query.TableInfoQuery;
import com.github.itdachen.framework.code.sdk.vo.TableInfoVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;

import javax.servlet.http.HttpServletResponse;
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
     * @date 2023/4/11 21:04
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.framework.code.sdk.vo.TableInfoVo>
     */
    TableData<TableInfoVo> findTableInfoPage(TableInfoQuery params) throws BizException;

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param tableInfoDto tableInfoDto
     * @return com.github.itdachen.framework.code.sdk.dto.TableInfoDto
     */
    TableInfoDto saveTableInfo(TableInfoDto tableInfoDto) throws BizException;

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param id id
     * @return com.github.itdachen.framework.code.sdk.vo.TableInfoVo
     */
    TableInfoVo getTableInfoById(String id) throws BizException;

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param tableInfoDto tableInfoDto
     * @return com.github.itdachen.framework.code.sdk.dto.TableInfoDto
     */
    TableInfoDto updateTableInfo(TableInfoDto tableInfoDto) throws BizException;

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param id id
     * @return int
     */
    int removeTableInfo(String id) throws BizException;

    /***
     * 查询数据库中的表
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param query query
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.framework.code.entity.ProtoTable>
     */
    TableData<ProtoTable> dbList(GenTableQuery query) throws BizException;

    /***
     * 导入表
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param tableName tableName
 * @param uiStyle uiStyle
     * @return void
     */
    void importGenTable(String tableName, String uiStyle) throws BizException;

    /***
     * 生成代码
     *
     * @author 王大宸
     * @date 2022/8/16 22:04
     * @param tableNames tableNames
     * @return byte[]
     */
   void downloadCode(String[] tableNames, HttpServletResponse response)throws Exception ;

    /***
     * 预览代码
     *
     * @author 王大宸
     * @date 2022/8/16 23:51
     * @param id id
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    Map<String, String> previewCode(String id) throws Exception;

    /***
     * 获取菜单目录
     *
     * @author 王大宸
     * @date 2022/9/5 13:45
     * @return java.util.List
     */
    List<ZTreeNode> dirtZTree() throws BizException;

    /***
     * 数据字典
     *
     * @author 王大宸
     * @date 2022/9/5 14:46
     * @return java.util.List
     */
    List<ZTreeNode> dictList() throws BizException;

    /***
     * 获取应用列表
     *
     * @author 王大宸
     * @date 2023/3/1 14:29
     * @return java.util.List
     */
    List<ZTreeNode> appInfoList() throws BizException;

    /***
     * 添加字段
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param tableColumn tableColumn
     * @return com.github.itdachen.framework.code.entity.TableColumn
     */
    TableColumn saveTableColumn(TableColumn tableColumn)throws BizException;

    /***
     * 新增表
     *
     * @author 王大宸
     * @date 2023/4/11 21:05
     * @param tableInfo tableInfo
     * @return com.github.itdachen.framework.code.entity.TableInfo
     */
    TableInfo saveTable(TableInfo tableInfo)throws BizException;


}
