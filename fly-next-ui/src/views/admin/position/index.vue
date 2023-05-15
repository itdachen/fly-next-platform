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
                <el-input size="default" placeholder="岗位名称" class="ml10" style="max-width: 180px"
                          v-model='queryParams.title'></el-input>
                <!-- v-permission="['admin:admin:position:info:query']" -->
                <el-button size="default" type="primary" :icon="Search" class="ml10"
                           @click='tapSearchHandler(queryParams)'> 搜索
                </el-button>
                <!--  v-permission="['admin:admin:position:info:save']" -->
                <el-button size="default" type="success" :icon="Plus" class="ml10"
                           @click='tapAddHandler()'> 新增岗位
                </el-button>
              </div>
            </template>
            <template #status='scope'>
              <el-tag type="success" v-if="'1'===scope.row.status">有效</el-tag>
              <el-tag type="info" v-else>无效</el-tag>
            </template>
            <!-- 表格操作 -->
            <template #operation="scope">
              <!-- v-permission="['admin:admin:position:info:view']" -->
              <el-button type="primary" plain :icon="View"
                         size="small" @click="tapViewHandler(scope.row)">查看
              </el-button>
              <!--  v-permission="['admin:admin:position:info:update']"  -->
              <el-button type="primary" plain :icon="Edit"
                         color="#626aef" size="small"
                         @click="tapUpdateHandler(scope.row)">编辑
              </el-button>
              <el-button type="primary" plain :icon="UserFilled"
                         color="#626aef" size="small"
                         @click="tapAuthorizeHandler(scope.row.id, scope.row.title)">岗位权限
              </el-button>
              <!--  v-permission="['admin:admin:position:info:delete']" -->
              <el-button type="warning" plain :icon="Delete"
                         size="small" @click="tapRemoveHandler(scope.row.id, scope.row.name)">删除
              </el-button>
            </template>
          </pro-table>
        </el-main>
      </div>
    </div>

    <!-- 新增/修改/查看 弹窗 -->
    <RefPositionInfo ref="refPositionInfo" @bindtap="tapSubmitHandler"></RefPositionInfo>

    <!-- 岗位权限弹窗   -->
    <TreePopup ref="refTreePopup"
               :show-checkbox="true"
               @bindtap="tapSaveAuthorizeHandler"></TreePopup>

  </div>
</template>

<script setup lang="ts" name="PositionInfoComponent">
import {defineAsyncComponent, onMounted, ref} from 'vue';
import {Search, Edit, View, Delete, Plus, UserFilled} from '@element-plus/icons-vue';
import LeftTree from '/@/fly/components/tree/LeftTree.vue';
import ProTable from '/@/fly/components/table/index.vue';
import usePositionInfoComposable from "/@/composables/admin/PositionInfoComposable";
import {DeptInfo} from "/@/api/admin/model/DeptInfoModel";
import TreePopup from '/@/fly/components/tree/TreePopup.vue'

const RefPositionInfo = defineAsyncComponent(() => import('./RefPositionInfo.vue'));

const {
  treeData,
  refPositionInfo,
  tableData,
  columns,
  queryParams,
  tapSearchHandler,
  tapSaveHandler,
  tapUpdateHandler,
  tapAuthorizeHandler,
  tapViewHandler,
  tapRemoveHandler,
  tapSubmitHandler,
  reloadDate,
  loadTableData,
  loadDeptInfoTree,
  refTreePopup,
  tapSaveAuthorizeHandler
} = usePositionInfoComposable();

/**
 * 初始化页面时加载
 */
onMounted(() => {
  loadTableData(queryParams);
  loadDeptInfoTree();
})

/**
 * 当前选中的部门
 */
const deptId = ref('root');


/**
 * 树数据点击
 * @param data
 */
const treeClick = (data: DeptInfo) => {
  if (data.id != null) {
    deptId.value = data.id;
  }
  queryParams.deptId = data.id;
  queryParams.page = 1;
  loadTableData(queryParams);
}

/**
 * 新增按钮
 */
const tapAddHandler = () => {
  tapSaveHandler(deptId.value);
}


/**
 * 权限树设置
 */
// const defaultProps = reactive({
//   children: 'children', //设置树的children
//   label: 'title', //设置树的名字属性字段
// })


</script>

<style lang="scss" scoped>
.el-aside {
  width: 350px;
  height: 100vh;
  background-color: #ffffff;
  border-right: 1px solid #dfe6ec;
}
</style>