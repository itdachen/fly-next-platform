<template>
  <div>
    <div class="template-container layout-padding">
      <div class="template-container-padding layout-padding-auto layout-padding-view">
        <!-- 表格展示 -->
        <pro-table :data="tableDataVo" :columns="dbColumns" @reloadDate="reloadDbTableDate">
          <template #tableHeader="scope">
            <div class="system-user-search mb15">
              <el-form label-width="80px" :inline="true">
                <el-input size="default" placeholder="表名称" class="ml10" style="max-width: 180px;"
                          v-model='queryParams.tableName'></el-input>
                <el-button size="default" type="primary" :icon="Search" class="ml10"
                           @click='tapSearchHandler(queryParams)'> 搜索
                </el-button>
                <el-button size="default" type="success" :icon="BottomRight"
                           class="ml10" :disabled="!scope.isSelected"
                           @click='tapBatchImportHandler(scope.ids)'> 导入表
                </el-button>
              </el-form>

            </div>
          </template>
          <!-- 表格操作 -->
          <template #operation="scope">
            <el-button type="danger" size="small" :icon="BottomRight"
                       @click="tapImportHandler(scope.row.id)">导入
            </el-button>

          </template>
        </pro-table>

      </div>

    </div>
  </div>
</template>

<script setup lang="ts" name="RefImportTable">
import {onMounted, reactive} from 'vue';
import {Search, BottomRight} from '@element-plus/icons-vue';
import ProTable from '/@/fly/components/table/index.vue';
import useTableInfoBuilder, {TableInfo, TableInfoQuery} from "/@/api/tools/model/TableInfoModel";
import {TableData} from "axios";
import TableInfoApi from "/@/api/tools/TableInfoApi";
import useDialogPopup from '/@/fly/components/dialog/Dialog';

const tableInfoApi = new TableInfoApi();
const {dialog, onShow, onClose} = useDialogPopup();
const {dbColumns} = useTableInfoBuilder();

/**
 * 实例化查询数据对象
 */
const queryParams = reactive<TableInfoQuery>({
  page: 1,
  limit: 10,
  /** 表名称 */
  tableName: ''
});

/**
 * 分页数据
 */
const tableDataVo = reactive<TableData<TableInfo>>({
  total: 0,
  rows: [],
});

/**
 * 查询
 * @param queryParams
 */
const tapSearchHandler = (queryParams: TableInfoQuery) => {
  loadDbTableData(queryParams);
}

/**
 * 单表导入
 * @param tableName
 */
const tapImportHandler = (tableName: string) => {
  confirmTableNames(tableName);
}

/**
 * 批量导入
 * @param tableNames
 */
const tapBatchImportHandler = (tableNames: string[]) => {
  confirmTableNames(tableNames.join(','))
}

/**
 * 弹框展示(当成组件使用)
 */
const show = () => {
  console.log('RefImportTable show===>')
  //设置弹框的属性
  dialog.height = '90%'
  dialog.width = '95%'
  dialog.title = '导入表';

  dialog.showSubmit = false;
  loadDbTableData(queryParams);
  onShow();
}


/**
 * 初始化页面时加载
 */
// onMounted(() => {
//   loadDbTableData(queryParams);
// })

/**
 * 加载数据库数据列表
 * @param queryParams
 */
const loadDbTableData = (queryParams: TableInfoQuery) => {
  tableInfoApi.findDbTableList(queryParams).then(res => {
    tableDataVo.total = res.data.total;
    tableDataVo.rows = res.data.rows;
  })
}

/**
 * 刷新表格
 * @param queryParams
 */
const reloadDbTableDate = (queryParams: TableInfoQuery) => {
  loadDbTableData(queryParams);
}

//定义事件
const emits = defineEmits(['bindtap'])

/**
 * 提交到父组件
 */
const confirmTableNames = (tableNames: string) => {
  emits('bindtap', tableNames)

}


defineExpose({
  show,
  onClose
})

</script>

<style lang="scss" scoped>

</style>