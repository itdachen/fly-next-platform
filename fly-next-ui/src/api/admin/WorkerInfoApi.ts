import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {WorkerInfo, WorkerInfoQuery} from "/@/api/admin/model/WorkerInfoModel";

/**
 * 请求路径
 */
const path = '/admin/worker/info';

/**
 * 员工信息 接口
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
class WorkerInfoApi extends HttpRequest<WorkerInfo, WorkerInfoQuery, string> {

    constructor() {
        super(path)
    }


}

export default WorkerInfoApi;