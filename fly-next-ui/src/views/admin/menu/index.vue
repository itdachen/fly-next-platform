<template>
  <div class="template-container layout-padding">
    <div class="template-container-padding layout-padding-auto layout-padding-view">
      <!-- 表格展示 -->
      <pro-table :data="tableData" :columns="columns" @reloadDate="reloadDate">
        <template #tableHeader="scope">
          <div class="system-user-search mb15">
            <el-input size="default" placeholder="标题" style="max-width: 180px"
                      v-model='queryParams.title'></el-input>
            <!-- v-permission="['admin:admin:menu:info:query']" -->
            <el-button size="default" type="primary" :icon="Search" class="ml10"

                       @click='tapSearchHandler(queryParams)'> 搜索
            </el-button>
            <!--  v-permission="['admin:admin:menu:info:save']"          -->
            <el-button size="default" type="success" :icon="Plus" class="ml10"

                       @click='tapSaveHandler()'> 新增
            </el-button>
          </div>
        </template>
        <template #type='scope'>
          <el-tag type="success" v-if="'dirt'===scope.row.type">目录</el-tag>
          <el-tag type="info" v-if="'menu'===scope.row.type">菜单</el-tag>
          <el-tag type="warning" v-if="'uri'===scope.row.type">地址</el-tag>
        </template>
        <template #visible='scope'>
          <el-tag type="success" v-if="'1'===scope.row.visible">显示</el-tag>
          <el-tag type="info" v-else>不显示</el-tag>
        </template>
        <!-- 表格操作 -->
        <template #operation="scope">
          <!-- v-permission="['admin:admin:menu:info:view']"   -->
          <el-button type="primary" plain :icon="View" size="small"
                     @click="tapViewHandler(scope.row)">查看
          </el-button>
          <!--  v-permission="['admin:admin:menu:info:update']"        -->
          <el-button type="primary" plain :icon="Edit"
                     color="#626aef" size="small"
                     @click="tapUpdateHandler(scope.row)">编辑
          </el-button>
          <!--  v-permission="['admin:admin:menu:info:delete']"  -->
          <el-button type="warning" plain :icon="Delete" size="small"
                     @click="tapRemoveHandler(scope.row.id, scope.row.name)">删除
          </el-button>
        </template>
      </pro-table>

    </div>

    <!-- 新增/修改/查看 弹窗 -->
    <RefMenuInfo ref="refMenuInfo" @bindtap="tapSubmitHandler"></RefMenuInfo>

  </div>
</template>

<script setup lang="ts" name="MenuInfoComponent">
import {defineAsyncComponent, onMounted} from 'vue';
import {Search, Edit, View, Delete, Plus} from '@element-plus/icons-vue';
import ProTable from '/@/components/table/index.vue';
import useMenuInfoComposable from "/@/composables/admin/MenuInfoComposable";

const RefMenuInfo = defineAsyncComponent(() => import('./RefMenuInfo.vue'));

const {
  refMenuInfo,
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
} = useMenuInfoComposable();

/**
 * 初始化页面时加载
 */
onMounted(() => {
  loadTableData(queryParams);
})

</script>

<style lang="scss" scoped>

</style>