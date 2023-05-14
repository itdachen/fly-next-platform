import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {TableInfo, TableInfoQuery} from "/@/api/admin/model/TableInfoModel";
import * as url from "url";

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

    /**
     * 查询表信息
     * @param id
     */
    findTableInfo(id: string | undefined) {
        return this.http.get(path + '/' + id);
    }

    /**
     * 预览代码
     * @param id
     */
    findPreviewTableInfo(id: string | undefined) {
        return this.http.get(path + '/preview/' + id);
    }

    /**
     * 下载代码
     * @param id
     */
    downloadCode(id) {
        this.http.download({
            url: path + `/code?id=${id}`,
            method: 'GET',
        })
    }

    /**
     * 查询数据库中的表
     */
    findDbTableList(params: any) {
        const url = this.params('/db/list', params);
        return this.http.get(path + url);
    }

    /**
     * 导入表
     * @param tableNames
     */
    importDbTable(tableNames: string) {
        return this.http.post(path + '/import/db?tableNames=' + tableNames, {});
    }


}

export default TableInfoApi;