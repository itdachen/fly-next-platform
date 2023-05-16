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
        <el-form :model="workerIdentity" ref="formRef"
                 :rules="rules" :disabled="isDisabled"
                 size="small" label-width="120px">
          <el-form-item label="身份名称" prop="title" class="mb20">
            <el-input v-model="workerIdentity.title" placeholder="请输入身份名称"/>
          </el-form-item>

          <el-form-item label="部门ID" prop="deptId" class="mb20">
            <el-input v-model="workerIdentity.deptId" placeholder="请输入部门ID"/>
          </el-form-item>

          <el-form-item label="是否有效" class="mb20">
            <el-select v-model='workerIdentity.status' style="width: 160px;">
              <el-option label='有效' value='1'/>
              <el-option label='无效' value='0'/>
            </el-select>
          </el-form-item>

          <el-form-item label="是否主身份标识" prop="isPrimary" class="mb20">
            <el-select v-model='workerIdentity.isPrimary' style="width: 160px;">
              <el-option label='是' value='1'/>
              <el-option label='否' value='0'/>
            </el-select>
          </el-form-item>

          <el-form-item label="备注" prop="remarks" class="mb20">
            <el-input v-model="workerIdentity.remarks" type="textarea" placeholder="请输入备注"/>
          </el-form-item>

        </el-form>
      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefWorkerIdentity">
import {reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialogPopup, {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useWorkerIdentityBuilder, {WorkerIdentity} from '/@/api/admin/model/WorkerIdentityModel';

/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialogPopup();

const {workerIdentity} = useWorkerIdentityBuilder();

/**
 * 表单属性
 */
const {
  formRef,
  resetForm,
  objCopy,
  isDisabled
} = useElementFromComposable();


/**
 * 弹框
 * @param type 弹窗类型
 * @param data 展示的数据
 */
const show = (type: DialogTypeEnum, data?: WorkerIdentity) => {
  //设置弹框的属性
  dialog.height = '250px'
  dialog.width = '800px'
  dialog.title = type + '职工身份';
  /* 清空表单内容 */
  resetForm(formRef.value, workerIdentity);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, workerIdentity)
  }
  if (DialogTypeEnum.SAVE === type || DialogTypeEnum.UPDATE === type) {
    dialog.showSubmit = true
    isDisabled.value = false
  }
  if (DialogTypeEnum.VIEW === type) {
    dialog.showSubmit = false
    isDisabled.value = true
  }
  if (DialogTypeEnum.SAVE === type) {
    workerIdentity.workerId = data?.workerId;
    workerIdentity.status = '1';
    workerIdentity.isPrimary = '0';
  }

  onShow();
}

/**
 * 表单验证
 */
const rules = reactive({
  title: [{required: true, message: '身份名称不能为空', trigger: 'blur'}],
  deptId: [{required: true, message: '部门不能为空', trigger: 'blur'}]
});

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', workerIdentity)
    }
  })
}

defineExpose({
  show,
  onClose
})

</script>

<style scoped lang="scss">

</style>