/**
 * 弹框属性类型
 */
export type DialogModel = {
    title: string | undefined,
    visible: boolean,
    height: string,
    width: string,
    showSubmit?: boolean
}

/**
 * 弹框标题
 */
export enum DialogTypeEnum {
    SAVE = '新增',
    UPDATE = '编辑',
    VIEW = '查看'
}

