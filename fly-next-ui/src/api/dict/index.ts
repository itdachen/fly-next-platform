import { useDictInfo } from '/@/stores/DictDate';
import {storeToRefs} from "pinia";

/**
 * 数据字典
 */
export const DICT_TYPE = {
    USER_TYPE: 'user_type',
    COMMON_STATUS: 'common_status',
    TERMINAL: 'terminal',
    SYSTEM_USER_SEX: 'system_user_sex',
    SYSTEM_MENU_TYPE: 'system_menu_type',
    SYSTEM_ROLE_TYPE: 'system_role_type'
}

const stores = useDictInfo();
const { useDictInfo } = storeToRefs(stores);

export function dictDataArr(dictType: string) {
    useDictInfo.value.dictData;
}

export function getDictLabel(dictType, value) {
    const dict = getDictData(dictType, value);
    return dict ? dict.label : '';
}

export function getDictData(dictType, value) {
    // 获取 dictType 对应的数据字典数组
    const dictDatas = dictDataArr(dictType)
    if (!dictDatas || dictDatas.length === 0) {
        return ''
    }
    // 获取 value 对应的展示名
    value = value + '' // 强制转换成字符串，因为 DictData 小类数值，是字符串
    for (const dictData of dictDatas) {
        if (dictData.value === value) {
            return dictData;
        }
    }
    return undefined
}