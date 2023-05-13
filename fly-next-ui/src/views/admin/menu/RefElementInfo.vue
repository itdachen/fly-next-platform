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
      <el-form :model="elementInfo" ref="formRef"
               :rules="rules" size="small"
               :disabled="isDisabled" label-width="120px">
        <el-form-item label="资源请求类型" prop="method">
          <el-select v-model='elementInfo.method' style="width: 160px;">
            <el-option label='GET' value='GET'/>
            <el-option label='POST' value='POST'/>
            <el-option label='PUT' value='PUT'/>
            <el-option label='DELETE' value='DELETE'/>
          </el-select>
        </el-form-item>
        <el-form-item label="资源名称" prop="title">
          <el-input v-model="elementInfo.title" placeholder="请输入资源名称: 新增,编辑,删除 ... 等"/>
        </el-form-item>

        <el-form-item label="权限编码" prop="code">
          <el-input v-model="elementInfo.code" placeholder="请输入权限编码"/>
        </el-form-item>

        <el-form-item label="资源类型" prop="type">
          <el-select v-model='elementInfo.type' style="width: 160px;">
            <el-option label='按钮' value='button'/>
            <el-option label='链接' value='uri'/>
          </el-select>
        </el-form-item>

        <el-form-item label="资源路径" prop="href">
          <el-input v-model="elementInfo.href" placeholder="请输入资源路径, 路径动态参数使用{*}: /admin/user/{*}"/>
        </el-form-item>

        <el-form-item label="排序" prop="orderNum">
          <el-input v-model="elementInfo.orderNum" placeholder="请输入排序"
                    maxlength='3' onkeyup="value=value.replace(/[^\d]/g,'')"/>
        </el-form-item>

        <el-form-item label="状态" prop="visible">
          <el-select v-model='elementInfo.visible' style="width: 160px;">
            <el-option label='可用' value='1'/>
            <el-option label='禁用' value='0'/>
          </el-select>
        </el-form-item>

        <el-form-item label="描述" prop="remarks">
          <el-input v-model="elementInfo.remarks" placeholder="请输入描述"/>
        </el-form-item>

      </el-form>
    </template>
  </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefElementInfo">
import {reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialog from '/@/fly/components/dialog/DialogPopup';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useMenuInfoInfoBuilder, {ElementInfo} from '/@/api/admin/model/MenuInfoModel';

/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialog();

const {elementInfo} = useMenuInfoInfoBuilder();

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
const show = (type: DialogTypeEnum, data?: ElementInfo) => {
  //设置弹框的属性
  dialog.height = '350px'
  dialog.width = '800px'
  dialog.title = type + '按钮';
  /* 清空表单内容 */
  resetForm(formRef.value, elementInfo);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, elementInfo)
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
    elementInfo.menuId = data?.menuId;
    elementInfo.clientId = 'NEXT_APP';
    elementInfo.type = 'button';
    elementInfo.method = 'GET';
  }

  onShow();
}

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', elementInfo)
    }
  })
}

defineExpose({
  show,
  onClose
})


/**
 * 表单验证
 */
const rules = reactive({
  clientId: [{required: true, message: '客户端不能为空', trigger: 'blur'}],
  menuId: [{required: true, message: '资源关联菜单不能为空', trigger: 'blur'}],
  title: [{required: true, message: '资源名称: 新增,编辑,删除 ... 等不能为空', trigger: 'blur'}],
  code: [{required: true, message: '资源编码: 权限编码不能为空', trigger: 'blur'}],
  type: [{required: true, message: '资源类型: button,uri不能为空', trigger: 'blur'}],
  href: [{required: true, message: '资源路径, 路径动态参数使用{*}: /admin/user/{*}不能为空', trigger: 'blur'}],
  path: [{required: true, message: '视图路径, 路径动态参数使用{*}: /admin/user/{*}不能为空', trigger: 'blur'}],
  method: [{required: true, message: '资源请求类型:GET,POST,PUT,DELETE不能为空', trigger: 'blur'}],
  orderNum: [{required: true, message: '排序不能为空', trigger: 'blur'}],
  visible: [{required: true, message: '状态:1-可用,0-禁用不能为空', trigger: 'blur'}],
});
</script>

<style scoped lang="scss">

</style>