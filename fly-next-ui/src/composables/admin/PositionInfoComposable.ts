import {ref} from 'vue';
import useStringComposable from '/@/fly/utils/string';
import useTable from '/@/fly/components/table/TableComposables';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import usePositionInfoBuilder, {PositionInfo, PositionInfoQuery, RoleMenu} from "/@/api/admin/model/PositionInfoModel";
import PositionInfoApi from '/@/api/admin/PositionInfoApi'
import useDeptInfoBuilder from "/@/api/admin/model/DeptInfoModel";
import {toTreeArr} from "/@/fly/utils/ArrayUtils";
import DeptInfoApi from '/@/api/admin/DeptInfoApi'
import useElTreeComposable from "/@/fly/components/tree/composables/ElTreeComposable";


const deptInfoApi = new DeptInfoApi();
const positionInfoApi = new PositionInfoApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    positionInfo,
    columns,
    queryParams,
    tableData,
    refPositionInfo,
    roleMenu
} = usePositionInfoBuilder();
const {treeData} = useDeptInfoBuilder();

const {
    refTreePopup,
    elTreeData,
} = useElTreeComposable();


/**
 * 岗位信息 处理
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
export default function usePositionInfoComposable() {

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
    const loadTableData = (params: PositionInfoQuery) => {
        positionInfoApi.page(params).then(res => {
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
    const tapSearchHandler = (params: PositionInfoQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitHandler = (data: PositionInfo) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
            positionInfoApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refPositionInfo.value?.onClose();
                loadTableData(queryParams);
            });
        } else {
            positionInfoApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refPositionInfo.value?.onClose();
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
            positionInfoApi.remove(id).then(res => {
                successMsg(res.msg);
                loadTableData(queryParams);
            });
        });
    };


    /**
     * 新增按钮处理
     * @author 王大宸
     */
    const tapSaveHandler = (deptId: string) => {
        positionInfo.deptId = deptId;
        refPositionInfo.value?.show(DialogTypeEnum.SAVE, positionInfo);
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateHandler = (data: PositionInfo) => {
        refPositionInfo.value?.show(DialogTypeEnum.UPDATE, data);
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const tapViewHandler = (data: PositionInfo) => {
        refPositionInfo.value?.show(DialogTypeEnum.VIEW, data);
    };

    const selectPostId = ref('');

    /**
     * 岗位授权弹窗
     * @param postId 岗位ID
     * @param name
     */
    const tapAuthorizeHandler = (postId: string, name: string) => {
        selectPostId.value = postId;
        positionInfoApi.findPositionAuthorize(postId).then(async res => {
            elTreeData.data = res.data.data;
            elTreeData.checked = res.data.checked;
            refTreePopup.value?.show(elTreeData, '为【 ' + name + ' 】岗位授权');
        })
    }

    /**
     * 提交权限
     * @param data
     */
    const tapSaveAuthorizeHandler = (data: string) => {
        roleMenu.roleId = selectPostId.value;
        roleMenu.menuId = data;
        roleMenu.clientId = 'NEXT_APP';
        positionInfoApi.savePositionAuthorize(roleMenu).then(res => {
            successMsg(res.msg);
        })
    }


    return {
        treeData,
        refPositionInfo,
        positionInfo,
        tableData,
        columns,
        queryParams,
        tapSearchHandler,
        tapSaveHandler,
        tapUpdateHandler,
        tapAuthorizeHandler,
        tapViewHandler,
        tapRemoveHandler,
        tapSubmitHandler,
        reloadDate,
        loadTableData,
        loadDeptInfoTree,
        refTreePopup,
        tapSaveAuthorizeHandler
    };
}