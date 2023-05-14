import useStringComposable from '/@/fly/utils/string';
import useTable from '/@/fly/components/table/TableComposables';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useDeptInfoBuilder, {DeptInfo, DeptInfoQuery} from "/@/api/admin/model/DeptInfoModel";
import DeptInfoApi from '/@/api/admin/DeptInfoApi'
import {toTreeArr} from "/@/fly/utils/ArrayUtils";

const deptInfoApi = new DeptInfoApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    deptInfo,
    columns,
    queryParams,
    tableData,
    refDeptInfo,
    treeData
} = useDeptInfoBuilder();


/**
 * 部门管理 处理
 *
 * @author 王大宸
 * @date 2023-05-14 22:03:53
 */
export default function useDeptInfoComposable() {

    /**
     * 获取部门数
     */
    const loadDeptInfoTree = () => {
        deptInfoApi.list().then(res => {
            treeData.value = toTreeArr(res.data);
        })
    };


    /**
     * 加载分页数据
     * @author 王大宸
     * @param params
     */
    const loadTableData = (params: DeptInfoQuery) => {
        deptInfoApi.page(params).then(res => {
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
    const tapSearchHandler = (params: DeptInfoQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitHandler = (data: DeptInfo) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
            deptInfoApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refDeptInfo.value?.onClose();
                loadDeptInfoTree();
                loadTableData(queryParams);
            });
        } else {
            deptInfoApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refDeptInfo.value?.onClose();
                loadDeptInfoTree();
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
            deptInfoApi.remove(id).then(res => {
                successMsg(res.msg);
                loadDeptInfoTree();
                loadTableData(queryParams);
            });
        });
    };


    /**
     * 新增按钮处理
     * @author 王大宸
     */
    const tapSaveHandler = (parentId: string) => {
        deptInfo.parentId = parentId;
        refDeptInfo.value?.show(DialogTypeEnum.SAVE, deptInfo);
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateHandler = (data: DeptInfo) => {
        refDeptInfo.value?.show(DialogTypeEnum.UPDATE, data);
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const tapViewHandler = (data: DeptInfo) => {
        refDeptInfo.value?.show(DialogTypeEnum.VIEW, data);
    };

    return {
        treeData,
        refDeptInfo,
        deptInfo,
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
        loadTableData,
        loadDeptInfoTree
    };
}