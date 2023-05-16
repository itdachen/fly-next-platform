/*
 * Description: 员工信息
 * Created by 王大宸 on 2023-05-16 19:37:24
 * Created with IntelliJ Webstorm.
 */

import {BizQuery} from "/@/fly/biz/BizModel";
import {reactive, ref} from "vue";
import {ColumnProps} from '/@/fly/components/table/interface';
import {DialogTypeEnum} from "/@/fly/components/dialog/Dialog";
import {TableData} from "axios";

/**
 * 员工信息 查询参数
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
export interface WorkerInfoQuery extends BizQuery {
    /** 租户标识 */
    tenantId?: string,
    /** 职工编号 */
    workerNo?: string,
    /** 职工姓名 */
    workerName?: string,
    /** 性别 */
    sex?: string,
    /** 电话号码 */
    telephone?: string,
    /** 电子邮箱 */
    email?: string,
    /** 状态: 正常;离职;休假 */
    status?: string,
}


/**
 * 员工信息 向后端传值对象
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
export interface WorkerInfo {
    /** 主键唯一标识 */
    id?: string,
    /** 租户标识 */
    tenantId?: string,
    /** 职工编号 */
    workerNo?: string,
    /** 职工姓名 */
    workerName?: string,
    /** 性别 */
    sex?: string,
    /** 头像 */
    avatar?: string,
    /** 生日 */
    birthday?: string,
    /** 电话号码 */
    telephone?: string,
    /** 电子邮箱 */
    email?: string,
    /** 状态: 正常;离职;休假 */
    status?: string,
    /** 备注 */
    remarks?: string,
    /** 入职日期 */
    entryDay?: string,
    /** 离职日期 */
    departDay?: string
}


/**
 * 初始化方法
 */
export default function useWorkerInfoBuilder() {

    /**
     * 实例化查询数据对象
     */
    const queryParams = reactive<WorkerInfoQuery>({
        page: 1,
        limit: 10,
        /** 租户标识 */
        tenantId: '',
        /** 职工编号 */
        workerNo: '',
        /** 职工姓名 */
        workerName: '',
        /** 性别 */
        sex: '',
        /** 电话号码 */
        telephone: '',
        /** 电子邮箱 */
        email: '',
        /** 状态: 正常;离职;休假 */
        status: ''
    });

    /**
     * 分页数据
     */
    const tableData = reactive<TableData<WorkerInfo>>({
        total: 0,
        rows: [],
    });

    /**
     * 实例化对象
     */
    const workerInfo = reactive<WorkerInfo>({
        /** 主键唯一标识 */
        id: '',
        /** 租户标识 */
        tenantId: '',
        /** 职工编号 */
        workerNo: '',
        /** 职工姓名 */
        workerName: '',
        /** 性别 */
        sex: '',
        /** 头像 */
        avatar: '',
        /** 生日 */
        birthday: '',
        /** 电话号码 */
        telephone: '',
        /** 电子邮箱 */
        email: '',
        /** 状态: 正常;离职;休假 */
        status: '',
        /** 备注 */
        remarks: '',
        /** 入职日期 */
        entryDay: '',
        /** 离职日期 */
        departDay: ''
    });

    /**
     * 分页列表展示项
     */
    const columns: Partial<ColumnProps>[] = [
        {
            prop: "workerNo",
            label: "职工编号",
            align: "center"
        },
        {
            prop: "workerName",
            label: "职工姓名",
            align: "center"
        },
        {
            prop: "sex",
            label: "性别",
            align: "center"
        },
        {
            prop: "avatar",
            label: "头像",
            align: "center",
            image: true
        },
        {
            prop: "telephone",
            label: "电话号码",
            align: "center"
        },
        {
            prop: "status",
            label: "状态",
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
    const refWorkerInfo = ref<{
        show: (type: DialogTypeEnum, data?: WorkerInfo | null) => void,
        onClose: () => void
    }>();

    return {
        queryParams,
        tableData,
        workerInfo,
        columns,
        refWorkerInfo
    }

}