/*
 * Description: 代码生成业务表
 * Created by 王大宸 on 2023-05-13 15:03:04
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 代码生成业务表 查询参数
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
export interface TableInfoQuery extends BizQuery {
    /** 表名称 */
    tableName?: string,
    /** UI类型 */
    uiStyle?: string,
    /** 所属客户端 */
    clientId?: string,
    /** 浏览器打开方式 */
    iframe?: string,
    /** 表描述 */
    tableComment?: string,
    /** 实体类名称 */
    className?: string,
    /** 使用的模板（crud单表操作 tree树表操作） */
    tplCategory?: string,
    /** 生成包路径 */
    packageName?: string,
    /** 服务上下文 */
    contextPath?: string,
    /** 生成模块名 */
    moduleName?: string,
    /** 生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user) */
    businessName?: string,
    /** 生成功能名 */
    functionName?: string,
    /** 生成功能作者 */
    functionAuthor?: string,
    /** 上级菜单目录id */
    menuId?: string,
    /** 生成代码方式（0 zip压缩包 1自定义路径） */
    genType?: string,
    /** 生成路径（不填默认项目路径） */
    genPath?: string,
    /** 其它生成选项 */
    options?: string,
}


/**
 * 代码生成业务表 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
export interface TableInfo {
    /** 编号 */
    id?: string,
    /** 表名称 */
    tableName?: string,
    /** UI类型 */
    uiStyle?: string,
    /** 所属客户端 */
    clientId?: string,
    /** 浏览器打开方式 */
    iframe?: string,
    /** 表描述 */
    tableComment?: string,
    /** 实体类名称 */
    className?: string,
    /** 使用的模板（crud单表操作 tree树表操作） */
    tplCategory?: string,
    /** 生成包路径 */
    packageName?: string,
    /** 服务上下文 */
    contextPath?: string,
    /** 生成模块名 */
    moduleName?: string,
    /** 生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user) */
    businessName?: string,
    /** 生成功能名 */
    functionName?: string,
    /** 生成功能作者 */
    functionAuthor?: string,
    /** 上级菜单目录id */
    menuId?: string,
    /** 生成代码方式（0 zip压缩包 1自定义路径） */
    genType?: string,
    /** 生成路径（不填默认项目路径） */
    genPath?: string,
    /** 其它生成选项 */
    options?: string,
    /** 备注 */
    remarks?: string,
    /**  */
    columns?: TableColumn[],
}


/**
 * 代码生成业务表字段 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-13 15:03:04
 */
export interface TableColumn {
    /** 编号 */
    id?: string,
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
    sort?: string
}


/**
 * 初始化方法
 */
export default function useTableInfoBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<TableInfoQuery>({
        page: 1,
        limit: 10,
        /** 表名称 */
        tableName: '',
        /** UI类型 */
        uiStyle: '',
        /** 所属客户端 */
        clientId: '',
        /** 浏览器打开方式 */
        iframe: '',
        /** 表描述 */
        tableComment: '',
        /** 实体类名称 */
        className: '',
        /** 使用的模板（crud单表操作 tree树表操作） */
        tplCategory: '',
        /** 生成包路径 */
        packageName: '',
        /** 服务上下文 */
        contextPath: '',
        /** 生成模块名 */
        moduleName: '',
        /** 生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user) */
        businessName: '',
        /** 生成功能名 */
        functionName: '',
        /** 生成功能作者 */
        functionAuthor: '',
        /** 上级菜单目录id */
        menuId: '',
        /** 生成代码方式（0 zip压缩包 1自定义路径） */
        genType: '',
        /** 生成路径（不填默认项目路径） */
        genPath: '',
        /** 其它生成选项 */
        options: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<TableInfo>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const tableInfo = reactive<TableInfo>({
        /** 编号 */
        id: '',
        /** 表名称 */
        tableName: '',
        /** UI类型 */
        uiStyle: '',
        /** 所属客户端 */
        clientId: '',
        /** 浏览器打开方式 */
        iframe: '',
        /** 表描述 */
        tableComment: '',
        /** 实体类名称 */
        className: '',
        /** 使用的模板（crud单表操作 tree树表操作） */
        tplCategory: '',
        /** 生成包路径 */
        packageName: '',
        /** 服务上下文 */
        contextPath: '',
        /** 生成模块名 */
        moduleName: '',
        /** 生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user) */
        businessName: '',
        /** 生成功能名 */
        functionName: '',
        /** 生成功能作者 */
        functionAuthor: '',
        /** 上级菜单目录id */
        menuId: '',
        /** 生成代码方式（0 zip压缩包 1自定义路径） */
        genType: '',
        /** 生成路径（不填默认项目路径） */
        genPath: '',
        /** 其它生成选项 */
        options: '',
        /** 备注 */
        remarks: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "tableName",
            label: "表名称",
            align: "center"
        },
        {
            prop: "className",
            label: "实体类名称",
            align: "center"
        },
        {
            prop: "packageName",
            label: "生成包路径",
            align: "center"
        },
        {
            prop: "functionName",
            label: "生成功能名",
            align: "center"
        },
        {
            prop: "operation",
            label: "操作",
            width: 350,
            align: "center",
            fixed: "right"
        }
    ];

    /**
     *  新增/修改/查看 弹窗
     */
    const refTableInfo = ref<{
        show: (type: DialogTypeEnum, data?: TableInfo | null) => void,
        onClose: () => void
    }>();

    const refViewTableInfo = ref<{
        show: (type: DialogTypeEnum, data?: TableInfo | null) => void,
        onClose: () => void
    }>();



    return {
        queryParams,
        tableData,
        tableInfo,
        columns,
        refTableInfo,
        refViewTableInfo
    }

}