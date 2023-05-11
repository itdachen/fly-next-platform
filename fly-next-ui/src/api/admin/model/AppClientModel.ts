/*
 * Description: 微服务客户端(应用管理)
 * Created by 王大宸 on 2023-05-07 10:06:27
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/hooks/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/components/table/interface';
import {DialogTypeEnum} from "/@/components/dialog/Dialog";
import {TableData} from "/@/hooks/fly/biz/BizModel";

/**
 * 应用管理 查询参数
 *
 * @author 王大宸
 * @date 2023-05-07 10:06:27
 */
export interface AppClientQuery extends BizQuery {
    /** 应用名称 */
    appTitle?: string,
}

/**
 * 应用管理 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-07 10:06:27
 */
export interface AppClient {
    /** 主键唯一标识 */
    id?: string,
    /** 应用标识 */
    appCode?: string,
    /** 应用类型 */
    appType?: string,
    /** 微服务名称 */
    appTitle?: string,
    /** 访问地址 */
    askUri?: string,
    /** 图标 */
    icon?: string,
    /** 状态 */
    status?: string,
    /** 描述 */
    remarks?: string,
}

/**
 * 初始化方法
 */
export default function useAppClientBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<AppClientQuery>({
        page: 1,
        limit: 10,
        appTitle: ''
    });

    /**
     * 分页数据
     */
    const tableDataVo = reactive<TableData<AppClient>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const appClient = reactive<AppClient>({
        /** 主键唯一标识 */
        id: '',
        /** 应用标识 */
        appCode: '',
        /** 应用类型 */
        appType: '',
        /** 微服务名称 */
        appTitle: '',
        /** 访问地址 */
        askUri: '',
        /** 图标 */
        icon: '',
        /** 状态 */
        status: '',
        /** 描述 */
        remarks: '',
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: 'appTitle',
            label: '应用名称',
            align: 'center',
        },
        {
            prop: 'appCode',
            label: '应用标识',
            align: 'center',
            tag: true
        },
        {
            prop: 'icon',
            label: '图标',
            image: true,
            align: 'center',
        },
        {
            prop: 'status',
            label: '是否可用',
            align: 'center',
        },
        {
            prop: 'operation',
            label: '操作',
            width: 350,
            align: 'center',
            fixed: 'right',
        },
    ];

    /**
     *  新增/修改/查看 弹窗
     */
    const refAppClient = ref<{
        show: (type: DialogTypeEnum, data?: AppClient | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableDataVo,
        appClient,
        columns,
        refAppClient
    }

}
