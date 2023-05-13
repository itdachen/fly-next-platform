import {HttpRequest} from "/@/fly/axios/rest/HttpRequest";
import {MenuInfo, MenuInfoQuery} from "/@/api/admin/model/MenuInfoModel";

/**
 * 请求路径
 */
const path = '/admin/menu/info';

/**
 * 菜单管理 接口
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
class MenuInfoApi extends HttpRequest<MenuInfo, MenuInfoQuery, string> {

    constructor() {
        super(path)
    }


}

export default MenuInfoApi;