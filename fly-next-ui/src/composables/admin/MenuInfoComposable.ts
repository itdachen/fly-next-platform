import useStringComposable from '/@/utils/fly/string';
import useTable from '/@/components/ProTable/TableComposables';
import {DialogTypeEnum} from '/@/components/dialog/Dialog';
import useMenuInfoBuilder, {MenuInfo, MenuInfoQuery} from "/@/api/admin/model/MenuInfoModel";
import MenuInfoApi from '/@/api/admin/MenuInfoApi'
import {ElementInfo} from "/@/api/admin/model/ElementInfoModel";
import ElementInfoApi from "/@/api/admin/ElementInfoApi";

const elementInfoApi = new ElementInfoApi();
const menuInfoApi = new MenuInfoApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    menuInfo,
    columns,
    queryParams,
    tableData,
    refMenuInfo,
    elementInfo,
    refElementInfo
} = useMenuInfoBuilder();


/**
 * 菜单管理 处理
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
export default function useMenuInfoComposable() {

    /**
     * 加载分页数据
     * @author 王大宸
     * @param params
     */
    const loadTableData = (params: MenuInfoQuery) => {
        menuInfoApi.page(params).then(res => {
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
    const tapSearchHandler = (params: MenuInfoQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitHandler = (data: MenuInfo) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
            menuInfoApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refMenuInfo.value?.onClose();
                loadTableData(queryParams);
            });
        } else {
            menuInfoApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refMenuInfo.value?.onClose();
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
            menuInfoApi.remove(id).then(res => {
                successMsg(res.msg);
                loadTableData(queryParams);
            });
        });
    };

    /**
     * 新增按钮
     * @param data
     */
    const tapAddHandler = (data: MenuInfo) => {
        if ('menu' === data.type) {
            elementInfo.menuId = data.id;
            elementInfo.visible = '1';
            elementInfo.orderNum = '99'
            tapSaveElementHandler(elementInfo);
        } else {
            menuInfo.parentId = data.id;
            menuInfo.parentTitle = data.title
            tapSaveHandler(menuInfo)
        }
    }

    /**
     * 新增按钮处理
     * @author 王大宸
     */
    const tapSaveHandler = (data: MenuInfo) => {
        refMenuInfo.value?.show(DialogTypeEnum.SAVE, data);
    };


    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateHandler = (data: MenuInfo) => {
        if ('button' === data.type || 'uri' === data.type) {
            tapUpdateElementHandler(data);
        } else {
            refMenuInfo.value?.show(DialogTypeEnum.UPDATE, data);
        }
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const tapViewHandler = (data: MenuInfo) => {
        refMenuInfo.value?.show(DialogTypeEnum.VIEW, data);
    };

    /****  按钮 START  ******************************************************************************************************/


    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitElementHandler = (data: ElementInfo) => {
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
    const tapRemoveElementHandler = (id: string, title: string) => {
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
    const tapSaveElementHandler = (data: ElementInfo) => {
        refElementInfo.value?.show(DialogTypeEnum.SAVE, data);
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateElementHandler = (data: ElementInfo) => {
        refElementInfo.value?.show(DialogTypeEnum.UPDATE, data);
    };

    /****  按钮 END  ******************************************************************************************************/

    return {
        refMenuInfo,
        menuInfo,
        tableData,
        columns,
        queryParams,
        tapSearchHandler,
        tapSaveHandler,
        tapAddHandler,
        tapUpdateHandler,
        tapViewHandler,
        tapRemoveHandler,
        tapSubmitHandler,
        reloadDate,
        loadTableData,

        refElementInfo,
        elementInfo,
        tapSubmitElementHandler,
        tapRemoveElementHandler,
        tapSaveElementHandler,
        tapUpdateElementHandler

    };
}