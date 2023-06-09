import {TIME_OUT} from "/@/fly/axios/conf/config";
import ApiRequest from "/@/fly/axios/interceptor/AxiosInterceptors";

const httpAxios = new ApiRequest({
    baseURL: "/api",
    timeout: TIME_OUT,
})

export default httpAxios


// import Request from './request'
// import {AxiosResponse} from 'axios'

// import type {RequestConfig} from './request/types'


// 重写返回类型
// interface YWZRequestConfig<T, R> extends RequestConfig<ServerResponse<R>> {
//     data?: T
// }

// const httpAxios = new Request({
//     baseURL: "/api",
//     timeout: TIME_OUT,
//     interceptors: {
//         // 请求拦截器
//         requestInterceptors: config => config,
//         // 响应拦截器
//         responseInterceptors: (result: AxiosResponse) => {
//             return result
//         },
//     },
// })

/**
 * @description: 函数的描述
 * @generic D 请求参数
 * @generic T 响应结构
 * @param {YWZRequestConfig} config 不管是GET还是POST请求都使用data
 * @returns {Promise}
 */
// const ywzRequest = <D = any, T = any>(config: YWZRequestConfig<D, T>) => {
//     const {method = 'GET'} = config
//     if (method === 'get' || method === 'GET') {
//         config.params = config.data
//     }
//     return httpAxios.request<ServerResponse<T>>(config)
// }
// // 取消请求
// export const cancelRequest = (url: string | string[]) => {
//   return request.cancelRequest(url)
// }
// // 取消全部请求
// export const cancelAllRequest = () => {
//   return request.cancelAllRequest()
// }

// export default httpAxios
