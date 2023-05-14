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
        <el-form :model="deptInfo" ref="formRef"
                 :rules="rules" :disabled="isDisabled"
                 size="small" label-width="120px">
          <el-form-item label="部门名称" prop="title" class="mb10">
            <el-input v-model="deptInfo.title" placeholder="请输入部门名称"/>
          </el-form-item>

<!--          <el-form-item label="部门类型" prop="deptType" class="mb10">-->
<!--            <el-select v-model="deptInfo.deptType" placeholder="请选择部门类型">-->
<!--              <el-option-->
<!--                  v-for="dict in dict.type.${dictType}"-->
<!--                  :key="dict.value"-->
<!--                  :label="dict.label"-->
<!--                  :value="dict.value"></el-option>-->
<!--            </el-select>-->
<!--          </el-form-item>-->

          <el-form-item label="备注" prop="remarks" class="mb10">
            <el-input v-model="deptInfo.remarks" type="textarea" placeholder="请输入备注"/>
          </el-form-item>

        </el-form>
      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefDeptInfo">
import {reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialogPopup, {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useDeptInfoBuilder, {DeptInfo} from '/@/api/admin/model/DeptInfoModel';

/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialogPopup();

const {deptInfo} = useDeptInfoBuilder();

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
const show = (type: DialogTypeEnum, data?: DeptInfo) => {
  //设置弹框的属性
  dialog.height = '100px'
  dialog.width = '800px'
  dialog.title = type + '部门管理';
  /* 清空表单内容 */
  resetForm(formRef.value, deptInfo);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, deptInfo)
  }
  if (DialogTypeEnum.SAVE === type || DialogTypeEnum.UPDATE === type) {
    dialog.showSubmit = true
    isDisabled.value = false
  }
  if (DialogTypeEnum.VIEW === type) {
    dialog.showSubmit = false
    isDisabled.value = true
  }
  if (DialogTypeEnum.SAVE === type){
    deptInfo.parentId = data?.parentId;
  }

  onShow();
}

/**
 * 表单验证
 */
const rules = reactive({
  title: [{required: true, message: '部门名称不能为空', trigger: 'blur'}],
  parentId: [{required: true, message: '上级id不能为空', trigger: 'blur'}],
  deptType: [{required: true, message: '部门类型不能为空', trigger: 'blur'}],
  isCanDel: [{required: true, message: '是否可删除: 1-可删除;0-不可删不能为空', trigger: 'blur'}],
  personCharge: [{required: true, message: '负责人不能为空', trigger: 'blur'}],
});

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', deptInfo)
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