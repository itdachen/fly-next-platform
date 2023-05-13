import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {TableInfo, TableInfoQuery} from "/@/api/admin/model/TableInfoModel";

/**
 * 请求路径
 */
const path = '/table/info';

/**
 * 代码生成业务表 接口
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
class TableInfoApi extends HttpRequest<TableInfo, TableInfoQuery, string> {

    constructor() {
        super(path)
    }


}

export default TableInfoApi;