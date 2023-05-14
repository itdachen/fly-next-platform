<template>
  <div>
    <div class="template-container layout-padding">
      <div class="template-container-padding layout-padding-auto layout-padding-view"
           style="display: flex; flex-direction: row">
        <el-aside>
          <left-tree :data="treeData" :title="'部门树'" :defaultProps="defaultProps"
                     @treeClick="treeClick"></left-tree>
        </el-aside>

        <el-main>
          <!-- 表格展示 -->
          <pro-table :data="tableData" :columns="columns" @reloadDate="reloadDate">
            <template #tableHeader="scope">
              <div class="system-user-search mb15">
                <el-input size="default" placeholder="部门名称" class="ml10" style="max-width: 180px"
                          v-model='queryParams.title'></el-input>
                <!-- v-permission="['admin:dept:info:query']" -->
                <el-button size="default" type="primary" :icon="Search" class="ml10"
                           @click='tapSearchHandler(queryParams)'> 搜索
                </el-button>
                <!-- v-permission="['admin:dept:info:save']" -->
                <el-button size="default" type="success" :icon="Plus" class="ml10"
                           @click='tapAddHandler()'> 新增部门
                </el-button>
              </div>
            </template>
            <!-- 表格操作 -->
            <template #operation="scope">
              <!--      v-permission="['admin:dept:info:view']"       -->
              <el-button type="primary" plain :icon="View"
                         size="small" @click="tapViewHandler(scope.row)">查看
              </el-button>
              <!--    v-permission="['admin:dept:info:update']"        -->
              <el-button type="primary" plain :icon="Edit"
                         color="#626aef" size="small"
                         @click="tapUpdateHandler(scope.row)">编辑
              </el-button>
              <!--      v-permission="['admin:dept:info:delete']"      -->
              <el-button type="warning" plain :icon="Delete"
                         size="small" @click="tapRemoveHandler(scope.row.id, scope.row.title)">删除
              </el-button>
            </template>
          </pro-table>
        </el-main>
      </div>
    </div>


    <!-- 新增/修改/查看 弹窗 -->
    <RefDeptInfo ref="refDeptInfo" @bindtap="tapSubmitHandler"></RefDeptInfo>

  </div>
</template>

<script setup lang="ts" name="DeptInfoComponent">
import {defineAsyncComponent, onMounted, reactive, ref} from 'vue';
import {Search, Edit, View, Delete, Plus} from '@element-plus/icons-vue';
import ProTable from '/@/fly/components/table/index.vue';
import useDeptInfoComposable from "/@/composables/admin/DeptInfoComposable";
import LeftTree from '/@/fly/components/tree/LeftTree.vue';
import {DeptInfo} from "/@/api/admin/model/DeptInfoModel";

const RefDeptInfo = defineAsyncComponent(() => import('./RefDeptInfo.vue'));

const {
  treeData,
  refDeptInfo,
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
  loadTableData,
  loadDeptInfoTree
} = useDeptInfoComposable();

/**
 * 初始化页面时加载
 */
onMounted(() => {
  loadTableData(queryParams);
  loadDeptInfoTree();
})

/**
 * 上级
 */
const parentId = ref('root');

/**
 * 树数据点击
 * @param data
 */
const treeClick = (data: DeptInfo) => {
  if (data.id != null) {
    parentId.value = data.id;
  }
  queryParams.parentId = data.id;
  queryParams.page = 1;
  loadTableData(queryParams);
}

/**
 * 点击新增按钮
 */
const tapAddHandler = () => {
  tapSaveHandler(parentId.value);
}

const defaultProps = reactive({
  children: 'children', //设置树的children
  label: 'title', //设置树的名字属性字段
})


</script>

<style lang="scss" scoped>
.el-aside {
  width: 350px;
  height: 100vh;
  background-color: #ffffff;
  border-right: 1px solid #dfe6ec;
}
</style>