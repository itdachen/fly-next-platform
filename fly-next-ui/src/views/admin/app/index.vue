<template>
  <div class="template-container layout-padding">
    <div class="template-container-padding layout-padding-auto layout-padding-view">
      <!-- 表格展示 -->
      <pro-table :data='tableDataVo' :columns='columns' @reloadDate='reloadDate'>
        <template #tableHeader='scope'>
          <div class="system-user-search mb15">
            <el-input size="default" placeholder="请输入应用名称" style="max-width: 180px"
                      v-model='queryParams.appTitle'
                      @keyup.enter='handlerSearch(queryParams)'></el-input>
            <el-button size="default" type="primary" :icon="Search" class="ml10"
                       @click='handlerSearch(queryParams)'> 查询
            </el-button>
            <el-button size="default" type="success" :icon="Plus" class="ml10"
                       @click='handlerSave()'> 新增
            </el-button>
          </div>
        </template>
        <template #status='scope'>
          <el-tag type="success" v-if="'1'===scope.row.status">启用</el-tag>
          <el-tag type="info" v-else>禁用</el-tag>
        </template>
        <!-- 表格操作 -->
        <template #operation='scope'>
          <!--  v-permission="['admin::app:client:view']"        -->
          <el-button size="small"
                     type='primary' plain :icon='View'
                     @click='handlerView(scope.row)'>查看
          </el-button>
          <!-- v-permission="['admin::app:client:update']" -->
          <el-button size="small"
                     type='primary' plain :icon='Edit' color='#626aef'
                     @click='handlerUpdate(scope.row)'>编辑
          </el-button>
          <!-- v-permission="['admin::app:client:delete']"         -->
          <el-button size="small"
                     type='warning' plain :icon='Delete'
                     @click='handlerRemove(scope.row.id, scope.row.appTitle)'>删除
          </el-button>
        </template>
      </pro-table>

    </div>

  </div>
  <RefAppClient ref="refAppClient" @submit="onSubmit"/>
</template>

<script lang='ts' setup name='AppClientManagement'>
import {defineAsyncComponent, onMounted} from 'vue';
import {Search, Edit, View, Delete, Plus} from '@element-plus/icons-vue';
import ProTable from '/@/components/table/index.vue';
import useAppClientComposable from '/@/composables/admin/AppClientComposable';

const RefAppClient = defineAsyncComponent(() => import('./RefAppClient.vue'));

const {
  refAppClient,
  tableDataVo,
  columns,
  queryParams,
  reloadDate,
  handlerSearch,
  loadTableData,
  handlerView,
  handlerSave,
  handlerUpdate,
  handlerRemove,
  onSubmit,
} = useAppClientComposable();

/**
 * 初始化页面时加载
 */
onMounted(() => {
  loadTableData(queryParams);
});

</script>

<style scoped lang="scss">


</style>