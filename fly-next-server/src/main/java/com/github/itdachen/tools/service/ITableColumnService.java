package com.github.itdachen.tools.service;


import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.tools.sdk.dto.TableColumnDto;
import com.github.itdachen.tools.sdk.query.TableColumnQuery;
import com.github.itdachen.tools.sdk.vo.TableColumnVo;

/**
 * 代码生成业务表字段 service
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
public interface ITableColumnService {

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param params cn.edu.hubu.tools.query.TableColumnQuery
     * @return cn.edu.hubu.common.framework.core.response.TableData<cn.edu.hubu.tools.sdk.vo.TableColumnVo>
     */
    TableData<TableColumnVo> findTableColumnPage(TableColumnQuery params) throws BizException;

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param tableColumnDto tableColumnDto
     * @return cn.edu.hubu.tools.sdk.dto.tableColumn
     */
    TableColumnDto saveTableColumn(TableColumnDto tableColumnDto) throws BizException;

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param id 需要查询数据的id
     * @return cn.edu.hubu.tools.sdk.vo.TableColumnVo
     */
    TableColumnVo getTableColumnById(String id) throws BizException;

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param tableColumnDto tableColumnDto
     * @return cn.edu.hubu.tools.sdk.dto.tableColumn
     */
    TableColumnDto updateTableColumn(TableColumnDto tableColumnDto) throws BizException;

    /***
     * 根据id删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:11:50
     * @param id 需要删除数据的id
     * @return int 影响行数
     */
    int removeTableColumn(String id) throws BizException;


}
