/**
 * axios 返回数据类型定义
 */
import {AxiosRequestConfig} from 'axios'

declare module 'axios' {
    interface AxiosInstance {
        (config: AxiosRequestConfig): Promise<any>
    }

    /**
     * 后端请求返回数据类型
     */
    interface ServerResponse<T> {
        success: boolean,
        status: number,
        msg: string,
        data: T
    }

    /**
     * table 表格返回数据
     */
    export interface TableData<T> {
        total: number,
        rows: T[]
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
        TOKEN = 'access_token',
        ACCESS = 'access'
    }

}