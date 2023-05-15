import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {PositionInfo, PositionInfoQuery, RoleMenu} from "/@/api/admin/model/PositionInfoModel";

/**
 * 请求路径
 */
const path = '/admin/position/info';

/**
 * 岗位信息 接口
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
class PositionInfoApi extends HttpRequest<PositionInfo, PositionInfoQuery, string> {

    constructor() {
        super(path)
    }

    /**
     * 获取岗位权限
     * @param postId
     */
    findPositionAuthorize(postId: string) {
        return this.http.get('/admin/role/menu/el/tree/' + postId);
    }

    /**
     * 添加岗位权限
     * @param data
     */
    savePositionAuthorize(data: RoleMenu) {
        return this.http.post('/admin/role/menu', data);
    }


}

export default PositionInfoApi;