<template>
  <div>
  <dialog-popup :title='dialog.title'
                :visible='dialog.visible'
                :width='dialog.width'
                :height='dialog.height'
                :showSubmit='dialog.showSubmit'
                @onClose='onClose()'
                @onConfirm='confirm()'>
    <template v-slot:content>
      <el-form :model='appClient'
               ref='formRef'
               :rules='rules'
               size="default"
               :disabled='isDisabled'
               label-width='120px'>

        <el-form-item label='应用名称' prop='appTitle'>
          <el-input v-model='appClient.appTitle' placeholder='请输入应用名称'/>
        </el-form-item>

        <el-form-item label='应用标识' prop='appCode'>
          <el-input v-model='appClient.appCode' placeholder='请输入应用标识'/>
        </el-form-item>

        <el-form-item label='应用类型' prop='appType'>
          <el-input v-model='appClient.appType' placeholder='请输入应用类型'/>
        </el-form-item>

        <el-form-item label='访问地址' prop='askUri'>
          <el-input v-model='appClient.askUri' placeholder='请输入访问地址'/>
        </el-form-item>
        <el-form-item label='图标' prop='icon'>
          <el-input v-model='appClient.icon' placeholder='请输入图标'/>
        </el-form-item>

        <el-form-item label='是否禁用' prop='status'>
          <el-select v-model="appClient.status">
            <el-option label="启用" value="1"/>
            <el-option label="禁用" value="0"/>
          </el-select>
        </el-form-item>

        <el-form-item label='描述' prop='remarks'>
          <el-input v-model='appClient.remarks' type='textarea' maxlength='100' placeholder='描述'/>
        </el-form-item>

      </el-form>
    </template>
  </dialog-popup>
  </div>
</template>

<script setup lang='ts' name='RefAppClient'>
import {reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialog from '/@/fly/components/dialog/DialogPopup';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import {ElForm} from 'element-plus/es';
import useAppClientBuilder, {AppClient} from '/@/api/admin/model/AppClientModel';

/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialog();

const {appClient} = useAppClientBuilder();

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
 * 弹框展示(当成组件使用)
 * @param type
 * @param data
 */
const show = (type: DialogTypeEnum, data?: AppClient) => {
  //设置弹框的属性
  dialog.height = '400px';
  dialog.width = '800px';
  dialog.title = type + '应用';
  /* 清空表单内容 */
  resetForm(formRef.value, appClient);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, appClient);
  }
  if (DialogTypeEnum.SAVE === type || DialogTypeEnum.UPDATE === type) {
    dialog.showSubmit = true;
    isDisabled.value = false;
  }
  if (DialogTypeEnum.VIEW === type) {
    dialog.showSubmit = false;
    isDisabled.value = true;
  }

  onShow();
};

//定义事件
const emits = defineEmits(['submit']);

const confirm = () => {
  formRef.value?.validate(valid => {
    //验证通过，才提交表单
    if (valid) {
      emits('submit', appClient);
    }
  });
};

defineExpose({
  show,
  onClose,
});


/**
 * 表单验证
 */
const rules = reactive({
  appCode: [{required: true, message: '应用标识不能为空', trigger: 'blur'}],
  appType: [{required: true, message: '应用类型不能为空', trigger: 'blur'}],
  appTitle: [{required: true, message: '应用名称不能为空', trigger: 'blur'}]
});

</script>

<style scoped>

</style>