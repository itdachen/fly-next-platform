import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {TableColumn, TableColumnQuery} from "/@/api/admin/model/TableColumnModel";

/**
 * 请求路径
 */
const path = '/sys/gen/table/column';

/**
 * 代码生成业务表字段 接口
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
class TableColumnApi extends HttpRequest<TableColumn, TableColumnQuery, string> {

    constructor() {
        super(path)
    }


}

export default TableColumnApi;