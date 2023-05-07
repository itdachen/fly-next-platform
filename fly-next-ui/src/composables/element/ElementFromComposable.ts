import {ref} from "vue";
import {ElForm} from "element-plus";

/**
 * 表单操作
 */
export default function useElementFromComposable() {

    /**
     * 表单的ref属性
     */
    const formRef = ref<InstanceType<typeof ElForm>>();


    /**
     * 清空表单
     * @param fromRef  表单的ref属性
     * @param obj      表单绑定的model
     */
    const resetForm = function (fromRef: any, obj: any) {
        //清空数据
        Object.keys(obj).forEach(key => {
            obj[key] = ''
        })
        //清除表单的验证
        if (fromRef) {
            fromRef.resetFields();
            fromRef.clearValidate();
        }
    }

    /**
     * 对象快速复制：obj1复制到obj2
     * @param obj1
     * @param obj2
     */
    const objCopy = function (obj1: any, obj2: any) {
        Object.keys(obj2).forEach(key => {
            obj2[key] = obj1[key]
        })
    }

    /**
     * 是否禁用
     */
    const isDisabled = ref<boolean>(false);

    return {
        formRef,
        resetForm,
        objCopy,
        isDisabled
    }

}