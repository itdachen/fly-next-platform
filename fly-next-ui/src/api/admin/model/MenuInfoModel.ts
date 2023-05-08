/*
 * Description: 菜单管理
 * Created by 王大宸 on 2023-05-08 22:40:36
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/hooks/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/components/table/interface';
import {DialogTypeEnum} from "/@/components/dialog/Dialog";
import {TableData} from "/@/hooks/biz/BizModel";

/**
 * 菜单管理 查询参数
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
export interface MenuInfoQuery extends BizQuery {
    /** 标题 */
    title?: string,
    /** 客户端 */
    clientId?: string,
    /** 父级节点 */
    parentId?: string,
}


/**
 * 菜单管理 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
export interface MenuInfo {
    /** 主键唯一标识 */
    id?: string,
    /** 路径编码,权限编码 */
    code?: string,
    /** 标题 */
    title?: string,
    /** 客户端 */
    clientId?: string,
    /** 父级节点 */
    parentId?: string,
    /** 资源路径,浏览器访问地址 */
    path?: string,
    /** 重定向路径 */
    redirect?: string,
    /** Layui图标(JQ) */
    icon?: string,
    /** ElementUI图标 */
    elementIcon?: string,
    /** LayuiUIVue图标 */
    layuiIcon?: string,
    /** 类型:dirt-目录;menu-菜单;uri-外链 */
    type?: string,
    /** 排序 */
    orderNum?: string,
    /** 是否显示:1-显示,0-不显示 */
    visible?: string,
    /** 组件名称(路由中的 name 值) */
    name?: string,
    /** 组件地址(vue中组件的地址) */
    component?: string,
    /** 外链地址 */
    link?: string,
    /** 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
    affix?: string,
    /** 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
    iframe?: string,
    /** 菜单是否缓存 */
    keepAlive?: string,
    /** 描述 */
    remarks?: string
}


/**
 * 初始化方法
 */
export default function useMenuInfoBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<MenuInfoQuery>({
        page: 1,
        limit: 10,
        /** 标题 */
        title: '',
        /** 客户端 */
        clientId: 'NEXT_APP',
        /** 父级节点 */
        parentId: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<MenuInfo>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const menuInfo = reactive<MenuInfo>({
        /** 主键唯一标识 */
        id: '',
        /** 路径编码,权限编码 */
        code: '',
        /** 标题 */
        title: '',
        /** 客户端 */
        clientId: 'NEXT_APP',
        /** 父级节点 */
        parentId: '',
        /** 资源路径,浏览器访问地址 */
        path: '',
        /** 重定向路径 */
        redirect: '',
        /** Layui图标(JQ) */
        icon: '',
        /** ElementUI图标 */
        elementIcon: '',
        /** LayuiUIVue图标 */
        layuiIcon: '',
        /** 类型:dirt-目录;menu-菜单;uri-外链 */
        type: 'menu',
        /** 排序 */
        orderNum: '',
        /** 是否显示:1-显示,0-不显示 */
        visible: '',
        /** 组件名称(路由中的 name 值) */
        name: '',
        /** 组件地址(vue中组件的地址) */
        component: '',
        /** 外链地址 */
        link: '',
        /** 菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项 */
        affix: '1',
        /** 是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）` */
        iframe: '1',
        /** 菜单是否缓存 */
        keepAlive: '0',
        /** 描述 */
        remarks: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "title",
            label: "标题",
            align: "center"
        },
        {
            prop: "code",
            label: "权限编码",
            align: "center"
        },
        {
            prop: "path",
            label: "资源路径",
            align: "center"
        },
        {
            prop: "type",
            label: "类型",
            align: "center"
        },
        {
            prop: "orderNum",
            label: "排序",
            align: "center"
        },
        {
            prop: "visible",
            label: "是否显示",
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
    const refMenuInfo = ref<{
        show: (type: DialogTypeEnum, data?: MenuInfo | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableData,
        menuInfo,
        columns,
        refMenuInfo
    }

}