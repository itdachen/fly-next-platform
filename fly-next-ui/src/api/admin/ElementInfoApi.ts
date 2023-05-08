import {HttpRequest} from "/@/axios/rest/HttpRequest";
import {ElementInfo, ElementInfoQuery} from "/@/api/admin/model/ElementInfoModel";

/**
 * 请求路径
 */
const path = '/admin/element/info';

/**
 * 按钮资源 接口
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
class ElementInfoApi extends HttpRequest<ElementInfo, ElementInfoQuery, string> {

    constructor() {
        super(path)
    }


}

export default ElementInfoApi;