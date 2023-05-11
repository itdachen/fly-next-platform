import {HttpRequest} from '/@/axios/rest/HttpRequest';
import {AppClient, AppClientQuery} from '/@/api/admin/model/AppClientModel';
import {ServerResponse} from '/@/hooks/fly/biz/BizModel';

/**
 * 请求路径
 */
const path = '/admin/app/client';

/**
 * 应用管理 接口
 *
 * @author 王大宸
 * @date 2022-08-08 10:06:27
 */
class AppClientApi extends HttpRequest<AppClient, AppClientQuery, string> {

    constructor() {
        super(path);
    }

    list(): Promise<ServerResponse<AppClient[]>> {
        return this.http.get(path + '/list');
    }


}

export default AppClientApi;