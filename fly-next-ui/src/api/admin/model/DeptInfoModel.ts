/*
 * Description: 部门管理
 * Created by 王大宸 on 2023-05-14 22:03:53
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 部门管理 查询参数
 *
 * @author 王大宸
 * @date 2023-05-14 22:03:53
 */
export interface DeptInfoQuery extends BizQuery {
    /** 租户标识 */
    tenantId?: string,
    /** 部门名称 */
    title?: string,
    /** 上级id */
    parentId?: string,
    /** 部门类型 */
    deptType?: string,
    /** 是否可删除: 1-可删除;0-不可删 */
    isCanDel?: string,
    /** 负责人 */
    personCharge?: string,
}


/**
 * 部门管理 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-14 22:03:53
 */
export interface DeptInfo {
    /** 主键唯一标识 */
    id?: string,
    /** 租户标识 */
    tenantId?: string,
    /** 部门名称 */
    title?: string,
    /** 上级id */
    parentId?: string,
    /** 部门类型 */
    deptType?: string,
    /** 备注 */
    remarks?: string,
    /** 是否可删除: 1-可删除;0-不可删 */
    isCanDel?: string,
    /** 负责人 */
    personCharge?: string
}


/**
 * 初始化方法
 */
export default function useDeptInfoBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<DeptInfoQuery>({
        page: 1,
        limit: 10,
        /** 租户标识 */
        tenantId: '',
        /** 部门名称 */
        title: '',
        /** 上级id */
        parentId: '',
        /** 部门类型 */
        deptType: '',
        /** 是否可删除: 1-可删除;0-不可删 */
        isCanDel: '',
        /** 负责人 */
        personCharge: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<DeptInfo>>({
        total: 0,
        rows: [],
    });

    /**
     * 树结构数据
     */
    const treeData = ref<DeptInfo[]>([]);

    /**
     * 实例化对象
     */
    const deptInfo = reactive<DeptInfo>({
        /** 主键唯一标识 */
        id: '',
        /** 租户标识 */
        tenantId: '',
        /** 部门名称 */
        title: '',
        /** 上级id */
        parentId: '',
        /** 部门类型 */
        deptType: '',
        /** 备注 */
        remarks: '',
        /** 是否可删除: 1-可删除;0-不可删 */
        isCanDel: '',
        /** 负责人 */
        personCharge: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "title",
            label: "部门名称",
            align: "center"
        },
        // {
        //     prop: "deptType",
        //     label: "部门类型",
        //     align: "center"
        // },
        {
            prop: "remarks",
            label: "备注",
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
    const refDeptInfo = ref<{
        show: (type: DialogTypeEnum, data?: DeptInfo | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableData,
        deptInfo,
        columns,
        refDeptInfo,
        treeData
    }

}