import {defineStore} from 'pinia';
import {DictDataState} from "/@/types/pinia";
import httpAxios from '/@/axios';


/**
 * 数据字典
 */
export const useDictInfo = defineStore('dictData', {
    state: (): DictDataState => ({
        dictData: {}
    }),
    actions: {
        async getDictData(dictType: string) {
            let item = this.dictData[dictType];
            if (undefined !== item && null !== item &&
                'null' !== item && '' !== item) {
                return item;
            }
            httpAxios.get('').then(res => {
                this.dictData[dictType] = res.data;
                return res.data;
            })
        },
    },
});
