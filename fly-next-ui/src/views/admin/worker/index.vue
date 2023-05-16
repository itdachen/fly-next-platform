<template>
  <div>
    <div class="template-container layout-padding">
      <div class="template-container-padding layout-padding-auto layout-padding-view">
        <!-- 表格展示 -->
        <pro-table :data="tableData" :columns="columns" @reloadDate="reloadDate">
          <template #tableHeader="scope">
            <div class="system-user-search mb15">
              <el-input size="default" placeholder="职工编号" class="ml10" style="max-width: 180px"
                        v-model='queryParams.workerNo'></el-input>
              <el-input size="default" placeholder="职工姓名" class="ml10" style="max-width: 180px"
                        v-model='queryParams.workerName'></el-input>
              <!-- v-permission="['admin:worker:info:query']" -->
              <el-button size="default" type="primary" :icon="Search" class="ml10"
                         @click='tapSearchHandler(queryParams)'> 搜索
              </el-button>
              <!-- v-permission="['admin:admin:worker:info:save']" -->
              <el-button size="default" type="success" :icon="Plus" class="ml10"
                         @click='tapSaveHandler()'> 新增员工
              </el-button>
            </div>
          </template>
          <template #sex='scope'>
            <div v-if="'1' === scope.row.sex">
              <div class='menu-type'>男</div>
            </div>
            <div v-if="'2' === scope.row.sex">
              <div class='menu-type'>女</div>
            </div>
            <div v-if="'0' === scope.row.sex">
              <div class='menu-type'>未知</div>
            </div>
          </template>
          <template #status="scope">
            <el-tag type="success" v-if="'1'===scope.row.status">正常</el-tag>
            <el-tag type="primary" v-if="'2'===scope.row.status">休假</el-tag>
            <el-tag type="info" v-if="'0'===scope.row.status">离职</el-tag>
          </template>
          <!-- 表格操作 -->
          <template #operation="scope">
            <!-- v-permission="['admin:admin:worker:info:view']" -->
            <el-button type="primary" plain :icon="View"
                       size="small" @click="tapViewHandler(scope.row)">查看
            </el-button>
            <!--  v-permission="['admin:admin:worker:info:update']" -->
            <el-button type="primary" plain :icon="Edit"
                       color="#626aef" size="small"
                       @click="tapUpdateHandler(scope.row)">编辑
            </el-button>
            <el-button type="primary" plain :icon="UserFilled"
                       color="#626aef" size="small"
                       @click="tapAuthorizeHandler(scope.row.id, scope.row.workerName)">员工身份
            </el-button>
            <!--  v-permission="['admin:admin:worker:info:delete']" -->
            <el-button type="warning" plain :icon="Delete"
                       size="small" @click="tapRemoveHandler(scope.row.id, scope.row.workerName)">删除
            </el-button>
          </template>
        </pro-table>

      </div>
    </div>

    <!-- 新增/修改/查看 弹窗 -->
    <RefWorkerInfo ref="refWorkerInfo" @bindtap="tapSubmitHandler"></RefWorkerInfo>

  </div>
</template>

<script setup lang="ts" name="WorkerInfoComponent">
import {defineAsyncComponent, onMounted} from 'vue';
import {Search, Edit, View, Delete, Plus, UserFilled} from '@element-plus/icons-vue';
import ProTable from '/@/fly/components/table/index.vue';
import useWorkerInfoComposable from "/@/composables/admin/WorkerInfoComposable";

const RefWorkerInfo = defineAsyncComponent(() => import('./RefWorkerInfo.vue'));

const {
  refWorkerInfo,
  tableData,
  columns,
  queryParams,
  tapSearchHandler,
  tapSaveHandler,
  tapUpdateHandler,
  tapViewHandler,
  tapRemoveHandler,
  tapSubmitHandler,
  reloadDate,
  loadTableData
} = useWorkerInfoComposable();

/**
 * 初始化页面时加载
 */
onMounted(() => {
  loadTableData(queryParams);
})

</script>

<style lang="scss" scoped>

</style>