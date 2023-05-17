/*
 * Description: 职工身份
 * Created by 王大宸 on 2023-05-16 21:19:44
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 职工身份 查询参数
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
export interface WorkerIdentityQuery extends BizQuery {
    /** 租户标识 */
    tenantId?: string,
    /** 职工ID */
    workerId?: string,
    /** 身份名称 */
    title?: string,
    /** 部门ID */
    deptId?: string,
    /** 是否有效: 1-有效;0-无效 */
    status?: string,
    /** 是否主身份标识(1-是,0-不是) */
    isPrimary?: string,
}


/**
 * 职工身份 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
export interface WorkerIdentity {
    /** 主键唯一标识(身份ID) */
    id?: string,
    /** 租户标识 */
    tenantId?: string,
    /** 职工ID */
    workerId?: string,
    /** 身份名称 */
    title?: string,
    /** 部门ID */
    deptId?: string,
    deptTitle?: string,
    /** 是否有效: 1-有效;0-无效 */
    status?: string,
    /** 是否主身份标识(1-是,0-不是) */
    isPrimary?: string,
    /** 备注 */
    remarks?: string
}


/**
 * 初始化方法
 */
export default function useWorkerIdentityBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<WorkerIdentityQuery>({
        page: 1,
        limit: 10,
        /** 租户标识 */
        tenantId: '',
        /** 职工ID */
        workerId: '',
        /** 身份名称 */
        title: '',
        /** 部门ID */
        deptId: '',
        /** 是否有效: 1-有效;0-无效 */
        status: '',
        /** 是否主身份标识(1-是,0-不是) */
        isPrimary: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<WorkerIdentity>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const workerIdentity = reactive<WorkerIdentity>({
        /** 主键唯一标识(身份ID) */
        id: '',
        /** 租户标识 */
        tenantId: '',
        /** 职工ID */
        workerId: '',
        /** 身份名称 */
        title: '',
        /** 部门ID */
        deptId: '',
        deptTitle: '',
        /** 是否有效: 1-有效;0-无效 */
        status: '',
        /** 是否主身份标识(1-是,0-不是) */
        isPrimary: '',
        /** 备注 */
        remarks: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "title",
            label: "身份名称",
            align: "center"
        },
        {
            prop: "deptTitle",
            label: "所属部门",
            align: "center"
        },
        {
            prop: "status",
            label: "是否有效",
            align: "center"
        },
        {
            prop: "isPrimary",
            label: "是否主身份标识",
            align: "center"
        },
        {
            prop: "operation",
            label: "操作",
            width: 380,
            align: "center",
            fixed: "right"
        }
    ];

    /**
     *  新增/修改/查看 弹窗
     */
    const refWorkerIdentity = ref<{
        show: (type: DialogTypeEnum, data?: WorkerIdentity | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableData,
        workerIdentity,
        columns,
        refWorkerIdentity
    }

}