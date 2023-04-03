package com.github.itdachen.tools.mapper;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.tools.entity.GenComment;
import com.github.itdachen.tools.entity.GenTable;
import com.github.itdachen.tools.entity.TableInfo;
import com.github.itdachen.tools.sdk.query.GenTableQuery;
import com.github.itdachen.tools.sdk.query.TableInfoQuery;
import com.github.itdachen.tools.sdk.vo.TableInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码生成业务表 持久层接口
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
public interface ITableInfoMapper {

    /***
     * 查询数据表
     *
     * @author 王大宸
     * @date 2022/8/10 15:32
     * @param params params
     * @return java.util.List<cn.edu.hubu.tools.entity.GenTable>
     */
    List<GenTable> findDbList(TableInfoQuery params);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param params cn.edu.hubu.tools.sdk.query.TableInfoQuery
     * @return java.util.List<cn.edu.hubu.tools.sdk.vo.TableInfoVo>
     */
    List<TableInfoVo> findTableInfoPage(TableInfoQuery params);

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param tableInfo tableInfo
     * @return int int
     */
    int saveTableInfo(TableInfo tableInfo);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要查询数据的id
     * @return cn.edu.hubu.tools.sdk.vo.tableInfoVo
     */
    TableInfoVo getById(String id);

    TableInfoVo findTableInfoVoById(String id);

    List<ZTreeNode> findAppAll();

    List<ZTreeNode> findDirtZTree();

    List<ZTreeNode> dictList();

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param tableInfo tableInfo
     * @return int int
     */
    int updateTableInfo(TableInfo tableInfo);

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int deleteTableInfoById(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param list java.util.List<cn.edu.hubu.tools.entity.TableInfo>
     */
    void batchSave(@Param("list") List<TableInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param list java.util.List<cn.edu.hubu.tools.entity.TableInfo>
     */
    void batchUpdate(List<TableInfo> list);

    /***
     * 查询数据库中原生表
     *
     * @author 王大宸
     * @date 2022/8/14 16:01
     * @param query query
     * @return java.util.List<cn.edu.hubu.tools.entity.GenTable>
     */
    List<GenTable> dbList(GenTableQuery query);

    /***
     * 根据表名, 查询表
     *
     * @author 王大宸
     * @date 2022/8/14 16:01
     * @param list list
     * @return java.util.List<cn.edu.hubu.tools.entity.GenTable>
     */
    List<GenTable> findTableList(List<String> list);
    
    /***
     * 根据表名, 查询列信息
     *
     * @author 王大宸
     * @date 2022/8/14 16:10
     * @param tableName tableName
     * @return java.util.List<cn.edu.hubu.tools.entity.GenComment>
     */
    List<GenComment> findTableColumns(String tableName);


}
