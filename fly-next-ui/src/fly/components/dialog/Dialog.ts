import {reactive} from "vue";

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


/**
 * 弹窗统一封装
 */
export default function useDialogPopup() {

    //定义弹框属性
    const dialog = reactive<DialogModel>({
        title: '',
        visible: false,
        width: '550px',
        height: '750px',
        showSubmit: true
    })

    //展示
    const onShow = () => {
        dialog.visible = true;
    }

    //关闭
    const onClose = () => {
        dialog.visible = false;
    }

    // 确定
    const onConfirm = () => {
        dialog.visible = false;
    }

    return {
        dialog,
        onShow,
        onClose,
        onConfirm
    }

}

