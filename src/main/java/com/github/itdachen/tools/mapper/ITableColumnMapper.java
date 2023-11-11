package com.github.itdachen.tools.mapper;


import com.github.itdachen.framework.code.entity.TableColumn;
import com.github.itdachen.framework.code.sdk.query.TableColumnQuery;
import com.github.itdachen.framework.code.sdk.vo.TableColumnVo;

import java.util.List;

/**
 * 代码生成业务表字段 mapper
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
public interface ITableColumnMapper {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:08
     * @param params params
     * @return java.util.List<com.github.itdachen.framework.code.sdk.vo.TableColumnVo>
     */
    List<TableColumnVo> findTableColumnPage(TableColumnQuery params);

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param tableColumn tableColumn
     * @return int int
     */
    int saveTableColumn(TableColumn tableColumn);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2023/4/11 21:08
     * @param id id
     * @return com.github.itdachen.framework.code.sdk.vo.TableColumnVo
     */
     TableColumnVo getById(String id);

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param tableColumn tableColumn
     * @return int int
     */
    int updateTableColumn(TableColumn tableColumn);

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int deleteTableColumnById(String id);

    int deleteByTable(String tableId);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023/4/11 21:09
     * @param list list
     * @return void
     */
    void  batchSave(List<TableColumn> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023/4/11 21:25
     * @param list list
     * @return void
     */
    void batchUpdate(List<TableColumn> list);

}