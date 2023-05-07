/*
 * Description: 微服务客户端(应用管理)
 * Created by 王大宸 on 2023-05-07 10:06:27
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/hooks/biz/BizModel";

/**
 * 应用管理 查询参数
 *
 * @author 王大宸
 * @date 2023-05-07 10:06:27
 */
export interface AppClientQuery extends BizQuery {
    /** 微服务appId */
    appId?: string,
    /** 微服务名称 */
    title?: string,
    /** 是否锁定 */
    locked?: string,
}


/**
 * 应用管理 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-07 10:06:27
 */
export interface AppClient {
    /** 主键唯一标识 */
    id?: string,
    /** 微服务appId */
    appId?: string,
    /** 微服务秘钥 */
    appSecret?: string,
    /** 微服务名称 */
    title?: string,
    /** 服务上下文 */
    contextPath?: string,
    /** 是否锁定 */
    locked?: string,
    /** 数据库连接地址 */
    datasourceUri?: string,
    /** 数据库账号 */
    datasourceUsername?: string,
    /** 数据库密码 */
    datasourcePassword?: string,
    /** 描述 */
    remarks?: string,
}