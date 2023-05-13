import useStringComposable from '/@/fly/utils/string';
import useTable from '/@/fly/components/table/TableComposables';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementInfoBuilder, {ElementInfo, ElementInfoQuery} from "/@/api/admin/model/ElementInfoModel";
import ElementInfoApi from '/@/api/admin/ElementInfoApi'

const elementInfoApi = new ElementInfoApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    elementInfo,
    columns,
    queryParams,
    tableData,
    refElementInfo
} = useElementInfoBuilder();


/**
 * 按钮资源 处理
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
export default function useElementInfoComposable() {

    /**
     * 加载分页数据
     * @author 王大宸
     * @param params
     */
    const loadTableData = (params: ElementInfoQuery) => {
            elementInfoApi.page(params).then(res => {
            tableData.total = res.data.total;
            tableData.rows = res.data.rows;
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
     * 搜索处理
     * @author 王大宸
     * @param params
     */
    const tapSearchHandler = (params: ElementInfoQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitHandler = (data: ElementInfo) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
           elementInfoApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refElementInfo.value?.onClose();
                loadTableData(queryParams);
            });
        } else {
            elementInfoApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refElementInfo.value?.onClose();
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
    const tapRemoveHandler = (id: string, title: string) => {
        confirmMsgBox('数据删除后将无法恢复，确定要删除 ' + title + ' 吗?').then(res => {
           elementInfoApi.remove(id).then(res => {
                successMsg(res.msg);
                loadTableData(queryParams);
            });
        });
    };


    /**
     * 新增按钮处理
     * @author 王大宸
     */
    const tapSaveHandler = () => {
        refElementInfo.value?.show(DialogTypeEnum.SAVE, null);
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateHandler = (data: ElementInfo) => {
        refElementInfo.value?.show(DialogTypeEnum.UPDATE, data);
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const tapViewHandler = (data: ElementInfo) => {
        refElementInfo.value?.show(DialogTypeEnum.VIEW, data);
    };

    return {
        refElementInfo,
        elementInfo,
        tableData,
        columns,
        queryParams,
        tapSearchHandler,
        tapSaveHandler,
        tapUpdateHandler,
        tapViewHandler,
        tapRemoveHandler,
        tapSubmitHandler,
        reloadDate,
        loadTableData
    };
}