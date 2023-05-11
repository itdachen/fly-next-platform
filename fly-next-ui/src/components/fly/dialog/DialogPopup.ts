import {reactive} from 'vue';
import {DialogModel} from "/@/components/dialog/Dialog";

/**
 * 弹窗统一封装
 */
export default function dialogPopup() {

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
