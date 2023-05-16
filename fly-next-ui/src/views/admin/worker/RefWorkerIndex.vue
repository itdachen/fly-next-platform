<template>
  <div>
    <dialog-popup :title="dialog.title"
                  :visible="dialog.visible"
                  :width="dialog.width"
                  :height="dialog.height"
                  :showSubmit="dialog.showSubmit"
                  @onClose="onClose()"
                  @onConfirm="confirm()">
      <template v-slot:content>
        <div class="template-container layout-padding">
          <div class="template-container-padding layout-padding-auto layout-padding-view">
            <!-- 表格展示 -->
            <pro-table :data="tableData" :columns="columns" @reloadDate="reloadDate">
              <template #tableHeader="scope">
                <div class="system-user-search mb15">
                  <el-input size="default" placeholder="身份名称" class="ml10" style="max-width: 180px"
                            v-model='queryParams.title'></el-input>
                  <el-button size="default" type="primary" :icon="Search" class="ml10"
                             @click='tapSearchHandler(queryParams)'> 搜索
                  </el-button>
                  <el-button size="default" type="success" :icon="Plus" class="ml10"
                             @click='tapSaveHandler()'> 新增身份信息
                  </el-button>
                </div>
              </template>
              <template #isPrimary='scope'>
                <div v-if="'1' === scope.row.isPrimary">
                  <div class='menu-type'>是</div>
                </div>
                <div v-if="'0' === scope.row.isPrimary">
                  <div class='menu-type'>否</div>
                </div>
              </template>
              <template #status="scope">
                <div v-if="'1' === scope.row.status">
                  <div class='menu-type'>有效</div>
                </div>
                <div v-if="'0' === scope.row.status">
                  <div class='menu-type'>无效</div>
                </div>
              </template>
              <!-- 表格操作 -->
              <template #operation="scope">
                <el-button type="primary" plain :icon="UserFilled"
                           color="#626aef" size="small"
                           @click="tapUpdateHandler(scope.row)">身份岗位
                </el-button>
                <el-button type="primary" plain :icon="Edit"
                           color="#626aef" size="small"
                           @click="tapUpdateHandler(scope.row)">编辑
                </el-button>
                <el-button type="warning" plain :icon="Delete"
                           size="small" @click="tapRemoveHandler(scope.row.id, scope.row.title)">删除
                </el-button>
              </template>
            </pro-table>

          </div>
        </div>

      </template>
    </dialog-popup>

    <!-- 新增/修改/查看 弹窗 -->
    <RefWorkerIdentity ref="refWorkerIdentity" @bindtap="tapSubmitHandler"></RefWorkerIdentity>

  </div>
</template>

<script setup lang="ts" name="RefWorkerIndex">
import {defineAsyncComponent} from 'vue';
import {Search, Edit, Delete, Plus, UserFilled} from '@element-plus/icons-vue';
import ProTable from '/@/fly/components/table/index.vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useWorkerIdentityComposable from "/@/composables/admin/WorkerIdentityComposable";
import useDialogPopup from "/@/fly/components/dialog/Dialog";

const RefWorkerIdentity = defineAsyncComponent(() => import('./RefWorkerIdentity.vue'));

/**
 * 弹框属性
 */
const {dialog, onClose} = useDialogPopup();

const {
  workerId,
  refWorkerIdentity,
  tableData,
  columns,
  queryParams,
  tapSearchHandler,
  tapSaveHandler,
  tapUpdateHandler,
  tapRemoveHandler,
  tapSubmitHandler,
  reloadDate,
  loadTableData
} = useWorkerIdentityComposable();


const show = (id: string, workerName: string) => {
  dialog.height = '90%'
  dialog.width = '95%'
  dialog.title = '【' + workerName + '】身份信息';
  dialog.visible = true;
  dialog.showSubmit = false;
  workerId.value = id;
  queryParams.workerId = id;
  loadTableData(queryParams);
}


defineExpose({
  show,
  onClose
})


</script>

<style lang="scss" scoped>

</style>