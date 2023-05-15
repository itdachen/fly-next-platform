/*
 * Description: 岗位信息
 * Created by 王大宸 on 2023-05-15 20:13:36
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 岗位信息 查询参数
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
export interface PositionInfoQuery extends BizQuery {
    /** 租户标识 */
    tenantId?: string,
    /** 岗位名称 */
    title?: string,
    /** 所属部门 */
    deptId?: string,
    /** 状态 */
    status?: string,
}


/**
 * 岗位信息 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
export interface PositionInfo {
    /** 主键唯一标识 */
    id?: string,
    /** 租户标识 */
    tenantId?: string,
    /** 岗位名称 */
    title?: string,
    /** 岗位标识 */
    positionCode?: string,
    /** 所属部门 */
    deptId?: string,
    /** 状态 */
    status?: string,
    /** 备注 */
    remarks?: string
}

/**
 * 菜单角色 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-15 21:01:41
 */
export interface RoleMenu {
    /** 数据唯一标识 */
    id?: string,
    /** 用户id */
    roleId?: string,
    /** 菜单id */
    menuId?: string,
    /** 客户端 */
    clientId?: string
}


/**
 * 初始化方法
 */
export default function usePositionInfoBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<PositionInfoQuery>({
        page: 1,
        limit: 10,
        /** 岗位名称 */
        title: '',
        /** 所属部门 */
        deptId: 'root',
        /** 状态 */
        status: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<PositionInfo>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const positionInfo = reactive<PositionInfo>({
        /** 主键唯一标识 */
        id: '',
        /** 租户标识 */
        tenantId: '',
        /** 岗位名称 */
        title: '',
        /** 岗位标识 */
        positionCode: '',
        /** 所属部门 */
        deptId: '',
        /** 状态 */
        status: '',
        /** 备注 */
        remarks: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "title",
            label: "岗位名称",
            align: "center"
        },
        {
            prop: "positionCode",
            label: "岗位标识",
            align: "center"
        },
        {
            prop: "status",
            label: "有效标识",
            align: "center"
        },
        {
            prop: "operation",
            label: "操作",
            width: 450,
            align: "center",
            fixed: "right"
        }
    ];

    /**
     *  新增/修改/查看 弹窗
     */
    const refPositionInfo = ref<{
        show: (type: DialogTypeEnum, data?: PositionInfo | null) => void,
        onClose: () => void
    }>();


    /**
     * 实例化对象
     */
    const roleMenu = reactive<RoleMenu>({
        /** 数据唯一标识 */
        id: '',
        /** 用户id */
        roleId: '',
        /** 菜单id */
        menuId: '',
        /** 客户端 */
        clientId: ''
    });

    return {
        queryParams,
        tableData,
        positionInfo,
        columns,
        refPositionInfo,
        roleMenu
    }

}