import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {PositionInfo, PositionInfoQuery, RoleMenu} from "/@/api/admin/model/PositionInfoModel";

/**
 * 请求路径
 */
const path = '/admin/position/info';
const roleMenuPath = '/admin/role/menu';

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
        return this.http.get(roleMenuPath + '/el/tree/' + postId);
    }

    /**
     * 添加岗位权限
     * @param data
     */
    savePositionAuthorize(data: RoleMenu) {
        return this.http.post(roleMenuPath, data);
    }

    /**
     * 根据部门ID查询岗位信息
     * @param deptId 部门ID
     * @param identityId 身份ID
     */
    findPositionByDept(deptId: string | undefined, identityId: string | undefined) {
        return this.http.get(path + '/el/tree/' + deptId + '/identity/' + identityId);
    }


}

export default PositionInfoApi;