package com.github.itdachen.tools.mapper;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.code.entity.ProtoColumns;
import com.github.itdachen.framework.code.entity.ProtoTable;
import com.github.itdachen.framework.code.entity.TableInfo;
import com.github.itdachen.framework.code.sdk.query.GenTableQuery;
import com.github.itdachen.framework.code.sdk.query.TableInfoQuery;
import com.github.itdachen.framework.code.sdk.vo.TableInfoVo;
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
     * @date 2023/4/11 21:07
     * @param params params
     * @return java.util.List<com.github.itdachen.framework.code.entity.ProtoTable>
     */
    List<ProtoTable> findDbList(TableInfoQuery params);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:07
     * @param params params
     * @return java.util.List<com.github.itdachen.framework.code.sdk.vo.TableInfoVo>
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
     * @date 2023/4/11 21:07
     * @param id id
     * @return com.github.itdachen.framework.code.sdk.vo.TableInfoVo
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
     * @date 2023/4/11 21:07
     * @param list list
     * @return void
     */
    void batchSave(@Param("list") List<TableInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023/4/11 21:08
     * @param list list
     * @return void
     */
    void batchUpdate(List<TableInfo> list);

    /***
     * 查询数据库中原生表
     *
     * @author 王大宸
     * @date 2023/4/11 21:08
     * @param query query
     * @return java.util.List<com.github.itdachen.framework.code.entity.ProtoTable>
     */
    List<ProtoTable> dbList(GenTableQuery query);

    /***
     * 根据表名, 查询表
     *
     * @author 王大宸
     * @date 2023/4/11 21:08
     * @param list list
     * @return java.util.List<com.github.itdachen.framework.code.entity.ProtoTable>
     */
    List<ProtoTable> findTableList(List<String> list);

    /***
     * 根据表名, 查询列信息
     *
     * @author 王大宸
     * @date 2023/4/11 21:25
     * @param tableName tableName
     * @return java.util.List<com.github.itdachen.framework.code.entity.ProtoColumns>
     */
    List<ProtoColumns> findTableColumns(String tableName);


}
