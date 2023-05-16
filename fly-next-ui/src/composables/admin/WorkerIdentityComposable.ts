import useStringComposable from '/@/fly/utils/string';
import useTable from '/@/fly/components/table/TableComposables';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useWorkerIdentityBuilder, {WorkerIdentity, WorkerIdentityQuery} from "/@/api/admin/model/WorkerIdentityModel";
import WorkerIdentityApi from '/@/api/admin/WorkerIdentityApi'
import {ref} from "vue-demi";
import useElTreeComposable from "/@/fly/components/tree/composables/ElTreeComposable";
import PositionInfoApi from "/@/api/admin/PositionInfoApi";
import {toTreeDataArr} from "/@/fly/utils/ArrayUtils";

const positionInfoApi = new PositionInfoApi();
const workerIdentityApi = new WorkerIdentityApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    workerIdentity,
    columns,
    queryParams,
    tableData,
    refWorkerIdentity
} = useWorkerIdentityBuilder();

const {
    refTreePopup,
    elTreeData,
} = useElTreeComposable();


/**
 * 职工身份 处理
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
export default function useWorkerIdentityComposable() {

    const workerId = ref('');

    /**
     * 加载分页数据
     * @author 王大宸
     * @param params
     */
    const loadTableData = (params: WorkerIdentityQuery) => {
        params.workerId = workerId.value;
        workerIdentityApi.page(params).then(res => {
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
        queryParams.workerId = workerId.value;
        loadTableData(queryParams);
    };

    /**
     * 搜索处理
     * @author 王大宸
     * @param params
     */
    const tapSearchHandler = (params: WorkerIdentityQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitHandler = (data: WorkerIdentity) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
            workerIdentityApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refWorkerIdentity.value?.onClose();
                loadTableData(queryParams);
            });
        } else {
            workerIdentityApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refWorkerIdentity.value?.onClose();
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
            workerIdentityApi.remove(id).then(res => {
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
        workerIdentity.workerId = workerId.value;
        refWorkerIdentity.value?.show(DialogTypeEnum.SAVE, workerIdentity);
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateHandler = (data: WorkerIdentity) => {
        refWorkerIdentity.value?.show(DialogTypeEnum.UPDATE, data);
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const tapViewHandler = (data: WorkerIdentity) => {
        refWorkerIdentity.value?.show(DialogTypeEnum.VIEW, data);
    };


    const selectIdentityId = ref('');

    /**
     * 身份岗位设置
     * @param id      身份ID
     * @param deptId  部门ID
     * @param title   身份名称
     */
    const tapIdentityPositionHandler = (id: string, deptId: string, title: string) => {
        selectIdentityId.value = id;
        positionInfoApi.findPositionByDept(deptId, id).then(async res => {
            elTreeData.data = toTreeDataArr(res.data.data, 'deptId');
            elTreeData.checked = res.data.checked;
            refTreePopup.value?.show(elTreeData, '为【 ' + title + ' 】身份授权');
        })
    }

    /**
     * 设置身份岗位信息入库
     * @param positionIds
     */
    const tapSaveIdentityPositionHandler = (positionIds: string) => {
        workerIdentityApi.saveIdentityPosition({
            positionId: positionIds,
            identityId: selectIdentityId.value,
            clientId: 'NEXT_APP'
        }).then(res => {
            successMsg(res.msg);
        })
    }

    return {
        workerId,
        refWorkerIdentity,
        workerIdentity,
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
        refTreePopup,
        elTreeData,
        tapIdentityPositionHandler,
        tapSaveIdentityPositionHandler
    };
}