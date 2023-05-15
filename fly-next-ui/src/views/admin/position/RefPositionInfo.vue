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
        <el-form :model="positionInfo" ref="formRef"
                 :rules="rules" :disabled="isDisabled"
                  label-width="120px">

          <el-form-item label="岗位名称" prop="title" class="mb20">
            <el-input v-model="positionInfo.title" placeholder="请输入岗位名称"/>
          </el-form-item>

          <el-form-item label="岗位标识" prop="positionCode" class="mb20">
            <el-input v-model="positionInfo.positionCode" placeholder="请输入岗位标识"/>
          </el-form-item>

          <el-form-item label="有效标识" class="mb20">
            <el-select v-model='positionInfo.status' style="width: 160px;">
              <el-option label='有效' value='1'/>
              <el-option label='无效' value='0'/>
            </el-select>

          </el-form-item>

          <el-form-item label="备注" prop="remarks" class="mb20">
            <el-input v-model="positionInfo.remarks" type="textarea" placeholder="请输入备注"/>
          </el-form-item>

        </el-form>
      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefPositionInfo">
import {reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialogPopup, {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import usePositionInfoBuilder, {PositionInfo} from '/@/api/admin/model/PositionInfoModel';

/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialogPopup();

const {positionInfo} = usePositionInfoBuilder();

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
const show = (type: DialogTypeEnum, data?: PositionInfo) => {
  //设置弹框的属性
  dialog.height = '260px'
  dialog.width = '800px'
  dialog.title = type + '岗位信息';
  /* 清空表单内容 */
  resetForm(formRef.value, positionInfo);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, positionInfo)
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
    positionInfo.deptId = data?.deptId;
    positionInfo.status = '1';
  }

  onShow();
}

/**
 * 表单验证
 */
const rules = reactive({
  title: [{required: true, message: '岗位名称不能为空', trigger: 'blur'}],
  positionCode: [{required: true, message: '岗位标识不能为空', trigger: 'blur'}],
  deptId: [{required: true, message: '所属部门不能为空', trigger: 'blur'}],
  status: [{required: true, message: '状态不能为空', trigger: 'blur'}],
});

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', positionInfo)
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