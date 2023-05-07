/**
 * 查询参数总类, 所有的都继承他
 */
export interface BizQuery {
    page: number,
    limit: number
}

/**
 * 后端请求返回数据类型
 */
export interface ServerResponse<T> {
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