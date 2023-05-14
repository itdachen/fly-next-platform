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
      <el-form :model="menuInfo" label-position="right"
               ref="formRef" size="small"
               :rules="rules" :disabled="isDisabled"
               :inline="true" class="demo-form-inline"
               label-width="120px">
        <el-form-item label='类型' prop='type' class="mb20">
          <el-select v-model='menuInfo.type' style="width: 160px;">
            <el-option label='目录' value='dirt'/>
            <el-option label='菜单' value='menu'/>
            <el-option label='地址' value='uri'/>
          </el-select>
        </el-form-item>

        <el-form-item label="标题" prop="title" class="mb20">
          <el-input v-model="menuInfo.title" placeholder="请输入标题"/>
        </el-form-item>

        <el-form-item label="权限编码" prop="code" class="mb20">
          <el-input v-model="menuInfo.code" placeholder="权限编码"/>
        </el-form-item>

        <el-form-item label="资源路径" prop="path" class="mb20">
          <el-input v-model="menuInfo.path" placeholder="请输入资源路径"/>
        </el-form-item>

        <el-form-item label="重定向路径" prop="redirect" class="mb20">
          <el-input v-model="menuInfo.redirect" placeholder="请输入重定向路径"/>
        </el-form-item>

        <el-form-item label="图标" prop="elementIcon" class="mb20">
          <IconSelector placeholder="请输入菜单图标" v-model="menuInfo.elementIcon" style="width: 230px !important;"/>
        </el-form-item>

        <el-form-item label='排序' prop='orderNum' class="mb20">
          <el-input v-model='menuInfo.orderNum'
                    maxlength='3' onkeyup="value=value.replace(/[^\d]/g,'')"
                    placeholder='请输入排序'/>
        </el-form-item>

        <el-form-item label='是否显示' prop='visible' class="mb20">
          <el-select v-model='menuInfo.visible' style="width: 160px;">
            <el-option label='显示' value='1'/>
            <el-option label='不显示' value='0'/>
          </el-select>
        </el-form-item>

        <el-form-item label="组件名称" prop="name" class="mb20">
          <el-input v-model="menuInfo.name" placeholder="请输入组件名称"/>
        </el-form-item>

        <el-form-item label="组件地址" prop="component" class="mb20">
          <el-input v-model="menuInfo.component" placeholder="请输入组件地址"/>
        </el-form-item>

        <el-form-item label="外链地址" prop="link" class="mb20">
          <el-input v-model="menuInfo.link" placeholder="请输入外链地址"/>
        </el-form-item>

        <el-form-item label='菜单是否固定' prop='affix' class="mb20">
          <el-select v-model='menuInfo.affix' style="width: 160px;">
            <el-option label='是' value='1'/>
            <el-option label='否' value='0'/>
          </el-select>
        </el-form-item>

        <el-form-item label='是否内嵌' prop='iframe' class="mb20">
          <el-select v-model='menuInfo.iframe' style="width: 160px;">
            <el-option label='是' value='1'/>
            <el-option label='否' value='0'/>
          </el-select>
        </el-form-item>

        <el-form-item label='是否缓存' prop='keepAlive' class="mb20">
          <el-select v-model='menuInfo.keepAlive' style="width: 160px;">
            <el-option label='是' value='1'/>
            <el-option label='否' value='0'/>
          </el-select>

        </el-form-item>

        <el-form-item label="描述" prop="remarks" class="mb20">
          <el-input v-model="menuInfo.remarks" placeholder="请输入描述"/>
        </el-form-item>
      </el-form>
    </template>
  </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefMenuInfo">
import {defineAsyncComponent, reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialogPopup, {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useMenuInfoBuilder, {MenuInfo} from '/@/api/admin/model/MenuInfoModel';

const IconSelector = defineAsyncComponent(() => import('/@/components/iconSelector/index.vue'));
/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialogPopup();

const {menuInfo} = useMenuInfoBuilder();

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
const show = (type: DialogTypeEnum, data: MenuInfo) => {
  //设置弹框的属性
  dialog.height = '380px';
  dialog.width = '769px';
  dialog.title = type + '菜单管理';
  /* 清空表单内容 */
  resetForm(formRef.value, menuInfo);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, menuInfo)
  }
  if (DialogTypeEnum.SAVE === type || DialogTypeEnum.UPDATE === type) {
    dialog.showSubmit = true;
    isDisabled.value = false;
  }
  if (DialogTypeEnum.VIEW === type) {
    dialog.showSubmit = false;
    isDisabled.value = true;
  }
  if (DialogTypeEnum.SAVE === type) {
    menuInfo.type = 'menu';
    menuInfo.clientId = 'NEXT_APP';
    menuInfo.elementIcon = 'iconfont icon-shouye';
    menuInfo.visible = '1';
    menuInfo.parentId = data?.parentId;
    menuInfo.parentTitle = data?.parentTitle
    menuInfo.orderNum = '99';
    menuInfo.affix = '0';
    menuInfo.iframe = '0';
    menuInfo.keepAlive = '1';
  }

  onShow();
}

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', menuInfo)
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
  code: [{required: true, message: '权限编码不能为空', trigger: 'blur'}],
  title: [{required: true, message: '标题不能为空', trigger: 'blur'}],
  clientId: [{required: true, message: '客户端不能为空', trigger: 'blur'}],
  path: [{required: true, message: '资源路径不能为空', trigger: 'blur'}],
  elementIcon: [{required: true, message: '图标不能为空', trigger: 'blur'}],
  type: [{required: true, message: '类型不能为空', trigger: 'blur'}],
  orderNum: [{required: true, message: '排序不能为空', trigger: 'blur'}],
});
</script>

<style scoped lang="scss">

</style>