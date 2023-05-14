import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {DeptInfo, DeptInfoQuery} from "/@/api/admin/model/DeptInfoModel";

/**
 * 请求路径
 */
const path = '/admin/dept/info';

/**
 * 部门管理 接口
 *
 * @author 王大宸
 * @date 2023-05-14 22:03:53
 */
class DeptInfoApi extends HttpRequest<DeptInfo, DeptInfoQuery, string> {

    constructor() {
        super(path)
    }

    /**
     * 获取集合
     */
    list() {
        return this.http.get(path + '/tree');
    }

}

export default DeptInfoApi;