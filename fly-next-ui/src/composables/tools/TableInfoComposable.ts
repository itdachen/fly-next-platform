import useStringComposable from '/@/fly/utils/string';
import useTable from '/@/fly/components/table/TableComposables';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useTableInfoBuilder, {TableInfo, TableInfoQuery} from "/@/api/tools/model/TableInfoModel";
import TableInfoApi from '/@/api/tools/TableInfoApi'

const tableInfoApi = new TableInfoApi();
const {isEmpty} = useStringComposable();
const {successMsg, confirmMsgBox} = useTable();
const {
    tableInfo,
    columns,
    queryParams,
    tableData,
    refTableInfo,
    refViewTableInfo,
    refImportTable
} = useTableInfoBuilder();


/**
 * 代码生成业务表 处理
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
export default function useTableInfoComposable() {

    /**
     * 加载分页数据
     * @author 王大宸
     * @param params
     */
    const loadTableData = (params: TableInfoQuery) => {
        tableInfoApi.page(params).then(res => {
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
    const tapSearchHandler = (params: TableInfoQuery) => {
        params.page = 1;
        loadTableData(params);
    };

    /**
     * 表单提交
     * @author 王大宸
     * @param data 需要提交的参数
     */
    const tapSubmitHandler = (data: TableInfo) => {
        let id: string | undefined = data.id;
        if (isEmpty(id)) {
            tableInfoApi.saveInfo(data).then(res => {
                successMsg(res.msg);
                refTableInfo.value?.onClose();
                loadTableData(queryParams);
            });
        } else {
            tableInfoApi.updateInfo(data, data.id).then(res => {
                successMsg(res.msg);
                refTableInfo.value?.onClose();
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
            tableInfoApi.remove(id).then(res => {
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
        console.log('tapSaveHandler===>')
        refImportTable.value?.show();
    };

    /**
     * 编辑按钮
     * @author 王大宸
     * @param data
     */
    const tapUpdateHandler = (data: TableInfo) => {
        tableInfoApi.findTableInfo(data.id).then(res => {
            refTableInfo.value?.show(DialogTypeEnum.UPDATE, res.data);
        })
    };

    /**
     * 查看按钮处理
     * @author 王大宸
     * @param data
     */
    const tapViewHandler = (data: TableInfo) => {
        tableInfoApi.findPreviewTableInfo(data.id).then(res => {
            refViewTableInfo.value?.show(DialogTypeEnum.VIEW, res.data);
        })
    };

    /**
     * 下载代码
     * @param idStr
     */
    const tapDownloadCodeHandler = (idStr: string) => {
        tableInfoApi.downloadCode(idStr);
    }

    /**
     * 编辑时, 查询数据
     * @param id
     */
    const findTableInfo = (id: string | undefined) => {
        tableInfoApi.findTableInfo(id).then(res => {
            return res.data;
        })
    };

    /**
     * 导入表
     * @param tableNames
     */
    const tapImportTableHandler = (tableNames: string) => {
        tableInfoApi.importDbTable(tableNames).then(res => {
            loadTableData(queryParams);
        })
    }

    /**
     * 获取数据库列表
     * @param params
     */
    // const findDbTableList = (params) => {
    //     tableInfoApi.findDbTableList(params).then(res => {
    //         return res.data;
    //     })
    // }

    return {
        refTableInfo,
        refViewTableInfo,
        refImportTable,
        tableInfo,
        tableData,
        columns,
        queryParams,
        tapSearchHandler,
        tapSaveHandler,
        tapUpdateHandler,
        tapViewHandler,
        tapRemoveHandler,
        tapSubmitHandler,
        tapDownloadCodeHandler,
        tapImportTableHandler,
        reloadDate,
        loadTableData,
        findTableInfo
    };
}