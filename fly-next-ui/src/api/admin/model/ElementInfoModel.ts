/*
 * Description: 按钮资源
 * Created by 王大宸 on 2023-05-08 22:40:36
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 按钮资源 查询参数
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
export interface ElementInfoQuery extends BizQuery {
    /** 客户端 */
    clientId?: string,
    /** 资源关联菜单 */
    menuId?: string,
    /** 资源名称: 新增,编辑,删除 ... 等 */
    title?: string,
    /** 资源类型: button,uri */
    type?: string,
    /** 状态:1-可用,0-禁用 */
    visible?: string,
}


/**
 * 按钮资源 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
export interface ElementInfo {
    /** 主键唯一标识 */
    id?: string,
    /** 客户端 */
    clientId?: string,
    /** 资源关联菜单 */
    menuId?: string,
    /** 资源名称: 新增,编辑,删除 ... 等 */
    title?: string,
    /** 资源编码: 权限编码 */
    code?: string,
    /** 资源类型: button,uri */
    type?: string,
    /** 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
    href?: string,
    /** 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
    path?: string,
    /** 资源请求类型:GET,POST,PUT,DELETE */
    method?: string,
    /** 排序 */
    orderNum?: string,
    /** 状态:1-可用,0-禁用 */
    visible?: string,
    /** 描述 */
    remarks?: string
}


/**
 * 初始化方法
 */
export default function useElementInfoBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<ElementInfoQuery>({
        page: 1,
        limit: 10,
        /** 客户端 */
        clientId: '',
        /** 资源关联菜单 */
        menuId: '',
        /** 资源名称: 新增,编辑,删除 ... 等 */
        title: '',
        /** 资源类型: button,uri */
        type: '',
        /** 状态:1-可用,0-禁用 */
        visible: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<ElementInfo>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const elementInfo = reactive<ElementInfo>({
        /** 主键唯一标识 */
        id: '',
        /** 客户端 */
        clientId: '',
        /** 资源关联菜单 */
        menuId: '',
        /** 资源名称: 新增,编辑,删除 ... 等 */
        title: '',
        /** 资源编码: 权限编码 */
        code: '',
        /** 资源类型: button,uri */
        type: '',
        /** 资源路径, 路径动态参数使用{*}: /admin/user/{*} */
        href: '',
        /** 视图路径, 路径动态参数使用{*}: /admin/user/{*} */
        path: '',
        /** 资源请求类型:GET,POST,PUT,DELETE */
        method: '',
        /** 排序 */
        orderNum: '',
        /** 状态:1-可用,0-禁用 */
        visible: '',
        /** 描述 */
        remarks: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "clientId",
            label: "客户端",
            align: "center"
        },
        {
            prop: "menuId",
            label: "资源关联菜单",
            align: "center"
        },
        {
            prop: "title",
            label: "资源名称: 新增,编辑,删除 ... 等",
            align: "center"
        },
        {
            prop: "code",
            label: "资源编码: 权限编码",
            align: "center"
        },
        {
            prop: "type",
            label: "资源类型: button,uri",
            align: "center"
        },
        {
            prop: "href",
            label: "资源路径, 路径动态参数使用{*}: /admin/user/{*}",
            align: "center"
        },
        {
            prop: "path",
            label: "视图路径, 路径动态参数使用{*}: /admin/user/{*}",
            align: "center"
        },
        {
            prop: "method",
            label: "资源请求类型:GET,POST,PUT,DELETE",
            align: "center"
        },
        {
            prop: "orderNum",
            label: "排序",
            align: "center"
        },
        {
            prop: "visible",
            label: "状态:1-可用,0-禁用",
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
    const refElementInfo = ref<{
        show: (type: DialogTypeEnum, data?: ElementInfo | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableData,
        elementInfo,
        columns,
        refElementInfo
    }

}