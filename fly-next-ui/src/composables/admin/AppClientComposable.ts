import useStringComposable from '/@/utils/string';
import useTable from '/@/components/ProTable/TableComposables';
import {DialogTypeEnum} from '/@/components/dialog/Dialog';
import useAppClientBuilder, {AppClient, AppClientQuery} from '/@/api/admin/model/AppClientModel';
import AppClientApi from '/@/api/admin/AppClientApi';

const appClientApi = new AppClientApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    appClient,
    columns,
    queryParams,
    tableDataVo,
    refAppClient
} = useAppClientBuilder();

/**
 * 应用管理 处理
 *
 * @author 王大宸
 * @date 2022-08-08 10:06:27
 */
export default function useAppClientComposable() {

    /**
     * 搜索处理
     * @author 王大宸
     * @param params
     */
    const handlerSearch = (params: AppClientQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const onSubmit = (data: AppClient) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
            appClientApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refAppClient.value?.onClose();
                loadTableData(queryParams);
            });
        } else {
            appClientApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refAppClient.value?.onClose();
                loadTableData(queryParams);
            });
        }
    };

    /**
     * 删除
     * @author 王大宸
     * @param id 需要删除的时间id
     * @param title 标题
     */
    const handlerRemove = (id: string, title: string) => {
        confirmMsgBox('数据删除后将无法恢复，确定要删除 ' + title + ' 吗?').then(res => {
            appClientApi.remove(id).then(res => {
                successMsg(res.msg);
                loadTableData(queryParams);
            });
        });
    };

    /**
     * 重新加载数据
     * @author 王大宸
     * @param page
     * @param limit
     */
    const reloadDate = (page: number = 1, limit: number = 10) => {
        queryParams.page = page;
        queryParams.limit = limit;
        loadTableData(queryParams);
    };

    /**
     * 加载分页数据
     * @author 王大宸
     * @param params
     */
    const loadTableData = (params: AppClientQuery) => {
        appClientApi.page(params).then(res => {
            tableDataVo.total = res.data.total;
            tableDataVo.rows = res.data.rows;
        });
    };

    /**
     * 新增按钮处理
     * @author 王大宸
     */
    const handlerSave = () => {
        refAppClient.value?.show(DialogTypeEnum.SAVE, null);
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const handlerUpdate = (data: AppClient) => {
        refAppClient.value?.show(DialogTypeEnum.UPDATE, data);
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const handlerView = (data: AppClient) => {
        refAppClient.value?.show(DialogTypeEnum.VIEW, data);
    };

    return {
        refAppClient,
        appClient,
        tableDataVo,
        columns,
        queryParams,
        handlerSave,
        handlerUpdate,
        handlerView,
        reloadDate,
        handlerSearch,
        loadTableData,
        handlerRemove,
        onSubmit
    };

}