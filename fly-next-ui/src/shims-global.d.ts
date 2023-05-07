/**
 * axios 返回数据类型定义
 */
import {AxiosRequestConfig} from 'axios'

declare module 'axios' {
    interface AxiosInstance {
        (config: AxiosRequestConfig): Promise<any>
    }

    /**
     * 数据请求格式
     */
    export enum ContentType {
        JSON = 'application/json;charset=UTF-8',
        FORM = 'application/x-www-form-urlencoded;charset=UTF-8',
        UPLOAD = 'multipart/form-data'
    }

    export enum TokenKey {
        TOKEN = 'token',
        ACCESS = 'access'
    }

}
