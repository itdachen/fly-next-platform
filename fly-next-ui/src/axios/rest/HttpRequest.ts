import {ServerResponse, TableData, BizQuery} from '/@/hooks/fly/biz/BizModel';
import httpAxios from '/@/axios';
import useStringComposable from '/@/utils/fly/string';

const {isEmpty} = useStringComposable();

/**
 * 基于 Restful Api 接口规范, 封装常用请求
 *
 * T: 请求参数对象/响应参数对象
 * Q: 分页查询参数
 * PK: 数据 id 的类型
 */
export class HttpRequest<T, Q extends BizQuery, PK> {

    protected path: string = '';

    protected http = httpAxios;

    /**
     * 构造函数
     * @param path 后端 controller 类上路径
     */
    constructor(path: string) {
        if (isEmpty(path)) {
            console.warn('请检查 path 是否为空');
            path = '';
        }
        this.path = path;
    }

    /**
     * 分页 接口
     * @param params 查询参数对象
     */
    page(params: Q): Promise<ServerResponse<TableData<T>>> {
        return httpAxios.get(this.path + `/page${urlParams(params)}`);
    }

    /**
     * 新增接口
     * @param obj 需要新增的数据
     */
    saveInfo(obj: T): Promise<ServerResponse<T>> {
        return httpAxios.post(this.path, obj);
    }

    /**
     * 更新数据接口
     * @param obj 需要更新的数据
     * @param id  数据id
     */
    updateInfo(obj: T, id: PK | undefined): Promise<ServerResponse<T>> {
        return httpAxios.put(this.path + `/${id}`, obj);
    }

    /**
     * 根据id删除数据接口
     * @param id 需要删除的数据id
     */
    remove(id: PK): Promise<ServerResponse<T>> {
        return httpAxios.delete(this.path + `/${id}`);
    }

    /**
     * 根据id查询
     * @param id 需要查询的数据id
     */
    getById(id: string): Promise<ServerResponse<T>> {
        return httpAxios.get(this.path + `/${id}`);
    }


}

/**
 * 将对象拼接到请求路径上 n = (token: string): void =>
 * @param params
 */
export const urlParams = (params: any): string => {
    let result = '';
    if (null === params || undefined === params) {
        return result;
    }
    let item;
    for (item in params) {
        if (params[item] && String(params[item])) {
            result += `&${item}=${params[item]}`;
        }
    }
    if (result) {
        result = '?' + result.slice(1);
    }
    return result;
};
