<template>
  <div>
    <div class="template-container layout-padding">
      <div class="template-container-padding layout-padding-auto layout-padding-view">
        <!-- 表格展示 -->
        <pro-table :data="tableData" :columns="columns" @reloadDate="reloadDate">
          <template #tableHeader="scope">
            <div class="system-user-search mb15">
              <el-input size="default" placeholder="表名称" class="ml10" style="max-width: 180px;"
                        v-model='queryParams.tableName'></el-input>
              <el-input size="default" placeholder="生成功能名" class="ml10" style="max-width: 180px;"
                        v-model='queryParams.functionName'></el-input>
<!--   v-permission="['admin:table:info:query']"            -->
              <el-button size="default" type="primary" :icon="Search" class="ml10"

                         @click='tapSearchHandler(queryParams)'> 搜索
              </el-button>
<!-- v-permission="['admin:table:info:save']" -->
              <el-button size="default" type="success" :icon="Plus" class="ml10"

                         @click='tapSaveHandler()'> 新增
              </el-button>
            </div>
          </template>
          <!-- 表格操作 -->
          <template #operation="scope">
<!--  v-permission="['admin:table:info:view']"  -->
            <el-button  type="primary" plain :icon="View" size="small"
                       @click="tapViewHandler(scope.row)">预览
            </el-button>
<!--   v-permission="['admin:table:info:update']"         -->
            <el-button  type="primary" plain :icon="Edit" size="small"
                       color="#626aef"
                       @click="tapUpdateHandler(scope.row)">编辑
            </el-button>
            <el-button  type="primary" plain :icon="Download" size="small"
                        color="#626aef"
                        @click="tapUpdateHandler(scope.row)">下载
            </el-button>
<!--   v-permission="['admin:table:info:delete']"         -->
            <el-button  type="warning" plain :icon="Delete" size="small"
                       @click="tapRemoveHandler(scope.row.id, scope.row.name)">删除
            </el-button>
          </template>
        </pro-table>

      </div>

      <!-- 新增/修改/查看 弹窗 -->
      <RefTableInfo ref="refTableInfo" @bindtap="tapSubmitHandler"></RefTableInfo>

    </div>
  </div>
</template>

<script setup lang="ts" name="TableInfoComponent">
import {defineAsyncComponent, onMounted} from 'vue';
import {Search, Edit, View, Delete, Plus,Download} from '@element-plus/icons-vue';
import ProTable from '/@/fly/components/table/index.vue';
import useTableInfoComposable from "/@/composables/tools/TableInfoComposable";

const RefTableInfo = defineAsyncComponent(() => import('./RefTableInfo.vue'));

const {
  refTableInfo,
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
} = useTableInfoComposable();

/**
 * 初始化页面时加载
 */
onMounted(() => {
  loadTableData(queryParams);
})

</script>

<style lang="scss" scoped>

</style>