/*
 * Description: 代码生成业务表字段
 * Created by 王大宸 on 2023-05-13 15:03:04
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 代码生成业务表字段 查询参数
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
export interface TableColumnQuery extends BizQuery {
            /** 归属表编号 */
           tableId?: string,
            /** 列名称 */
           columnName?: string,
            /** 列描述 */
           columnComment?: string,
            /** 列类型 */
           columnType?: string,
            /** JAVA类型 */
           javaType?: string,
            /** JAVA字段名 */
           javaField?: string,
            /** 前端TS类型 */
           tsType?: string,
            /** 是否主键（1是） */
           isPk?: string,
            /** 是否Dto/Vo类字段 */
           isDtoVo?: string,
            /** 是否必填（1是） */
           isRequired?: string,
            /** 是否为表单字段（1是） */
           isForm?: string,
            /** 是否列表字段（1是） */
           isList?: string,
            /** 是否查询字段（1是） */
           isQuery?: string,
            /** 查询方式（等于、不等于、大于、小于、范围） */
           queryType?: string,
            /** 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件） */
           htmlType?: string,
            /** 字典类型 */
           dictType?: string,
            /** 排序 */
           sort?: string,
}


/**
 * 代码生成业务表字段 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
export interface TableColumn {
        /** 编号 */
        id?: string , 
        /** 归属表编号 */
        tableId?: string , 
        /** 列名称 */
        columnName?: string , 
        /** 列描述 */
        columnComment?: string , 
        /** 列类型 */
        columnType?: string , 
        /** JAVA类型 */
        javaType?: string , 
        /** JAVA字段名 */
        javaField?: string , 
        /** 前端TS类型 */
        tsType?: string , 
        /** 是否主键（1是） */
        isPk?: string , 
        /** 是否Dto/Vo类字段 */
        isDtoVo?: string , 
        /** 是否必填（1是） */
        isRequired?: string , 
        /** 是否为表单字段（1是） */
        isForm?: string , 
        /** 是否列表字段（1是） */
        isList?: string , 
        /** 是否查询字段（1是） */
        isQuery?: string , 
        /** 查询方式（等于、不等于、大于、小于、范围） */
        queryType?: string , 
        /** 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件） */
        htmlType?: string , 
        /** 字典类型 */
        dictType?: string , 
        /** 排序 */
        sort?: string 
}


/**
 * 初始化方法
 */
export default function useTableColumnBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<TableColumnQuery>({
        page: 1,
        limit: 10,
            /** 归属表编号 */
           tableId: '' , 
            /** 列名称 */
           columnName: '' , 
            /** 列描述 */
           columnComment: '' , 
            /** 列类型 */
           columnType: '' , 
            /** JAVA类型 */
           javaType: '' , 
            /** JAVA字段名 */
           javaField: '' , 
            /** 前端TS类型 */
           tsType: '' , 
            /** 是否主键（1是） */
           isPk: '' , 
            /** 是否Dto/Vo类字段 */
           isDtoVo: '' , 
            /** 是否必填（1是） */
           isRequired: '' , 
            /** 是否为表单字段（1是） */
           isForm: '' , 
            /** 是否列表字段（1是） */
           isList: '' , 
            /** 是否查询字段（1是） */
           isQuery: '' , 
            /** 查询方式（等于、不等于、大于、小于、范围） */
           queryType: '' , 
            /** 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件） */
           htmlType: '' , 
            /** 字典类型 */
           dictType: '' , 
            /** 排序 */
           sort: '' 
    });

    /**
     * 分页数据
     */
    const tableData = reactive< TableData < TableColumn > > ({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const tableColumn = reactive< TableColumn >({
            /** 编号 */
            id: '' , 
            /** 归属表编号 */
            tableId: '' , 
            /** 列名称 */
            columnName: '' , 
            /** 列描述 */
            columnComment: '' , 
            /** 列类型 */
            columnType: '' , 
            /** JAVA类型 */
            javaType: '' , 
            /** JAVA字段名 */
            javaField: '' , 
            /** 前端TS类型 */
            tsType: '' , 
            /** 是否主键（1是） */
            isPk: '' , 
            /** 是否Dto/Vo类字段 */
            isDtoVo: '' , 
            /** 是否必填（1是） */
            isRequired: '' , 
            /** 是否为表单字段（1是） */
            isForm: '' , 
            /** 是否列表字段（1是） */
            isList: '' , 
            /** 是否查询字段（1是） */
            isQuery: '' , 
            /** 查询方式（等于、不等于、大于、小于、范围） */
            queryType: '' , 
            /** 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件） */
            htmlType: '' , 
            /** 字典类型 */
            dictType: '' , 
            /** 排序 */
            sort: '' 
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
                {
                    prop: "tableId",
                    label: "归属表编号",
                    align: "center"
                },
                {
                    prop: "columnName",
                    label: "列名称",
                    align: "center"
                },
                {
                    prop: "columnComment",
                    label: "列描述",
                    align: "center"
                },
                {
                    prop: "columnType",
                    label: "列类型",
                    align: "center"
                },
                {
                    prop: "javaType",
                    label: "JAVA类型",
                    align: "center"
                },
                {
                    prop: "javaField",
                    label: "JAVA字段名",
                    align: "center"
                },
                {
                    prop: "tsType",
                    label: "前端TS类型",
                    align: "center"
                },
                {
                    prop: "isPk",
                    label: "是否主键（1是）",
                    align: "center"
                },
                {
                    prop: "isDtoVo",
                    label: "是否Dto/Vo类字段",
                    align: "center"
                },
                {
                    prop: "isRequired",
                    label: "是否必填（1是）",
                    align: "center"
                },
                {
                    prop: "isForm",
                    label: "是否为表单字段（1是）",
                    align: "center"
                },
                {
                    prop: "isList",
                    label: "是否列表字段（1是）",
                    align: "center"
                },
                {
                    prop: "isQuery",
                    label: "是否查询字段（1是）",
                    align: "center"
                },
                {
                    prop: "queryType",
                    label: "查询方式（等于、不等于、大于、小于、范围）",
                    align: "center"
                },
                {
                    prop: "htmlType",
                    label: "显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）",
                    align: "center"
                },
                {
                    prop: "dictType",
                    label: "字典类型",
                    align: "center"
                },
                {
                    prop: "sort",
                    label: "排序",
                    align: "center"
                },
        {
            prop: "operation",
            label: "操作",
            width: 250,
            align: "center",
            fixed: "right"
        }
    ];

    /**
     *  新增/修改/查看 弹窗
     */
    const refTableColumn = ref<{
        show: (type: DialogTypeEnum, data?: TableColumn | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableData,
        tableColumn,
        columns,
        refTableColumn
    }

}