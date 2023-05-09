/**
 * 数据字典使用存储
 */
export interface Dict {
    dictType: string,
    list: DictDate[]
}

/**
 * 前端数据字典类型
 */
export interface DictDate {
    value: string,
    label: string,
    isDefault: boolean
}

