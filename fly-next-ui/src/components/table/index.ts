import {ElMessage} from 'element-plus'
import {ElMessageBox} from 'element-plus'
import {ColumnProps} from "/@/components/table/interface";


/**
 * 消息提示封装
 */
export default function useTable() {

    const successMsg = (text = '操作成功') => {
        ElMessage({
            type: 'success',
            message: text,
        })
    }

    /**
     * 删除确认
     * @param text 消息
     */
    const confirmMsgBox = (text = '确定删除该数据吗?') => {
        return ElMessageBox.confirm(text, '系统提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
        })
    }


    return {
        successMsg,
        confirmMsgBox
    }

}

