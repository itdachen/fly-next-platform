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
        <el-form :model="tableInfo"
                 ref="formRef"
                 size="small"
                 :rules="rules"
                 :disabled="isDisabled"
                 label-width="120px">
          <el-form-item label="表名称" prop="tableName">
            <el-input v-model="tableInfo.tableName" placeholder="请输入表名称"/>
          </el-form-item>

          <el-form-item label="UI类型" prop="uiStyle">
            <el-input v-model="tableInfo.uiStyle" placeholder="请输入UI类型"/>
          </el-form-item>

          <el-form-item label="所属客户端" prop="clientId">
            <el-input v-model="tableInfo.clientId" placeholder="请输入所属客户端"/>
          </el-form-item>

          <el-form-item label="浏览器打开方式" prop="iframe">
            <el-input v-model="tableInfo.iframe" placeholder="请输入浏览器打开方式"/>
          </el-form-item>

          <el-form-item label="表描述" prop="tableComment">
            <el-input v-model="tableInfo.tableComment" placeholder="请输入表描述"/>
          </el-form-item>

          <el-form-item label="实体类名称" prop="className">
            <el-input v-model="tableInfo.className" placeholder="请输入实体类名称"/>
          </el-form-item>

          <el-form-item label="使用的模板" prop="tplCategory">
            <el-input v-model="tableInfo.tplCategory" placeholder="请输入使用的模板"/>
          </el-form-item>

          <el-form-item label="生成包路径" prop="packageName">
            <el-input v-model="tableInfo.packageName" placeholder="请输入生成包路径"/>
          </el-form-item>

          <el-form-item label="服务上下文" prop="contextPath">
            <el-input v-model="tableInfo.contextPath" placeholder="请输入服务上下文"/>
          </el-form-item>

          <el-form-item label="生成模块名" prop="moduleName">
            <el-input v-model="tableInfo.moduleName" placeholder="请输入生成模块名"/>
          </el-form-item>

          <el-form-item
              label="生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user)"
              prop="businessName">
            <el-input v-model="tableInfo.businessName"
                      placeholder="请输入生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user)"/>
          </el-form-item>

          <el-form-item label="生成功能名" prop="functionName">
            <el-input v-model="tableInfo.functionName" placeholder="请输入生成功能名"/>
          </el-form-item>

          <el-form-item label="生成功能作者" prop="functionAuthor">
            <el-input v-model="tableInfo.functionAuthor" placeholder="请输入生成功能作者"/>
          </el-form-item>

          <el-form-item label="上级菜单目录id" prop="menuId">
            <el-input v-model="tableInfo.menuId" placeholder="请输入上级菜单目录id"/>
          </el-form-item>

          <el-form-item label="生成代码方式" prop="genType">
            <el-input v-model="tableInfo.genType" placeholder="请选择生成代码方式"/>
<!--            <el-select v-model="tableInfo.genType" placeholder="请选择生成代码方式">-->
<!--              <el-option-->
<!--                  v-for="dict in dict.type.log_business_type"-->
<!--                  :key="dict.value"-->
<!--                  :label="dict.label"-->
<!--                  :value="dict.value"></el-option>-->
<!--            </el-select>-->
          </el-form-item>

          <el-form-item label="生成路径" prop="genPath">
            <el-input v-model="tableInfo.genPath" placeholder="请输入生成路径"/>
          </el-form-item>

          <el-form-item label="其它生成选项" prop="options">
            <el-input v-model="tableInfo.options" placeholder="请输入其它生成选项"/>
          </el-form-item>

          <el-form-item label="备注" prop="remarks">
            <el-input v-model="tableInfo.remarks" placeholder="请输入备注"/>
          </el-form-item>

        </el-form>
      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefTableInfo">
import {reactive} from 'vue';
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialog from '/@/fly/components/dialog/DialogPopup';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useTableInfoBuilder, {TableInfo} from '/@/api/tools/model/TableInfoModel';

/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialog();

const {tableInfo} = useTableInfoBuilder();

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
const show = (type: DialogTypeEnum, data?: TableInfo) => {
  //设置弹框的属性
  dialog.height = '500px'
  dialog.width = '800px'
  dialog.title = type + '代码生成业务表';
  /* 清空表单内容 */
  resetForm(formRef.value, tableInfo);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, tableInfo)
  }
  if (DialogTypeEnum.SAVE === type || DialogTypeEnum.UPDATE === type) {
    dialog.showSubmit = true
    isDisabled.value = false
  }
  if (DialogTypeEnum.VIEW === type) {
    dialog.showSubmit = false
    isDisabled.value = true
  }

  onShow();
}

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', tableInfo)
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
  tableName: [{required: true, message: '表名称不能为空', trigger: 'blur'}],
  uiStyle: [{required: true, message: 'UI类型不能为空', trigger: 'blur'}],
  clientId: [{required: true, message: '所属客户端不能为空', trigger: 'blur'}],
  iframe: [{required: true, message: '浏览器打开方式不能为空', trigger: 'blur'}],
  tableComment: [{required: true, message: '表描述不能为空', trigger: 'blur'}],
  className: [{required: true, message: '实体类名称不能为空', trigger: 'blur'}],
  tplCategory: [{required: true, message: '使用的模板（crud单表操作 tree树表操作）不能为空', trigger: 'blur'}],
  packageName: [{required: true, message: '生成包路径不能为空', trigger: 'blur'}],
  contextPath: [{required: true, message: '服务上下文不能为空', trigger: 'blur'}],
  moduleName: [{required: true, message: '生成模块名不能为空', trigger: 'blur'}],
  businessName: [{
    required: true,
    message: '生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user)不能为空',
    trigger: 'blur'
  }],
  functionName: [{required: true, message: '生成功能名不能为空', trigger: 'blur'}],
  functionAuthor: [{required: true, message: '生成功能作者不能为空', trigger: 'blur'}],
  menuId: [{required: true, message: '上级菜单目录id不能为空', trigger: 'blur'}],
  genType: [{required: true, message: '生成代码方式（0 zip压缩包 1自定义路径）不能为空', trigger: 'blur'}],
  genPath: [{required: true, message: '生成路径（不填默认项目路径）不能为空', trigger: 'blur'}],
  options: [{required: true, message: '其它生成选项不能为空', trigger: 'blur'}],
});
</script>

<style scoped lang="scss">

</style>