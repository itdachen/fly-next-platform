import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {WorkerIdentity, WorkerIdentityQuery} from "/@/api/admin/model/WorkerIdentityModel";

/**
 * 请求路径
 */
const path = '/admin/worker/identity';

/**
 * 职工身份 接口
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
class WorkerIdentityApi extends HttpRequest<WorkerIdentity, WorkerIdentityQuery, string> {

    constructor() {
        super(path)
    }

    /**
     * 设置身份岗位信息
     * @param data
     */
    saveIdentityPosition(data) {
        return this.http.post(path + '/position', data);
    }


}

export default WorkerIdentityApi;