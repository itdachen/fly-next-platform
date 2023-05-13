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
        <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
          <el-tab-pane label="基础信息" name="first">
            <el-form :model="tableInfo" ref="formRef" size="small"
                     :rules="rules" :disabled="isDisabled" label-width="120px">
              <el-form-item label="表名称" prop="tableName">
                <el-input v-model="tableInfo.tableName" placeholder="请输入表名称"/>
              </el-form-item>
              <el-form-item label="表描述" prop="tableComment">
                <el-input v-model="tableInfo.tableComment" placeholder="请输入表描述"/>
              </el-form-item>
              <el-form-item label="实体类名称" prop="className">
                <el-input v-model="tableInfo.className" placeholder="请输入实体类名称"/>
              </el-form-item>
              <el-form-item label="Java包路径" prop="packageName">
                <el-input v-model="tableInfo.packageName"
                          placeholder="请输入使用Java包路径, 例如: com.github.itdachen.admin"/>
              </el-form-item>
              <el-form-item label="控制层路径" prop="businessName">
                <el-input v-model="tableInfo.businessName"
                          placeholder="控制层路径, 例如: /admin/user/info"/>
              </el-form-item>
              <el-form-item label="后端模板类型" prop="tplCategory">
                <el-select v-model='tableInfo.tplCategory' style="width: 160px;">
                  <el-option label='biz' value='biz'/>
                  <el-option label='default' value='default'/>
                </el-select>
              </el-form-item>
              <el-form-item label="功能名" prop="functionName">
                <el-input v-model="tableInfo.functionName" placeholder="请输入生成功能名"/>
              </el-form-item>
              <el-form-item label="程序员" prop="functionAuthor">
                <el-input v-model="tableInfo.functionAuthor" placeholder="请输入程序员"/>
              </el-form-item>

              <el-form-item label="备注" prop="remarks">
                <el-input v-model="tableInfo.remarks" placeholder="请输入备注"/>
              </el-form-item>
            </el-form>
          </el-tab-pane>

          <el-tab-pane label="字段设置" name="second">
            <el-table ref="dragTable" :data="columns">
              <el-table-column label="序号" type="index" min-width="5%" class-name="allowDrag"/>
              <el-table-column label="字段列名"
                               prop="columnName"
                               min-width="10%"
                               :show-overflow-tooltip="true"/>
              <el-table-column label="字段描述"
                               prop="columnComment"
                               min-width="10%"
                               :show-overflow-tooltip="true">
                <template #default="scope">
                  <el-input v-model="scope.row.columnComment" placeholder="Please input"/>
                </template>
              </el-table-column>
              <el-table-column label="JAVA类型"
                               prop="javaField"
                               min-width="8%"
                               :show-overflow-tooltip="true">
                <template #default="scope">
                  <el-input v-model="scope.row.javaField" placeholder="Please input"/>
                </template>
              </el-table-column>
              <el-table-column label="Java类型" prop="javaType" min-width="8%">
                <template #default="scope">
                  <el-select v-model="scope.row.javaType">
                    <el-option label="Long" value="Long"/>
                    <el-option label="String" value="String"/>
                    <el-option label="Integer" value="Integer"/>
                    <el-option label="Double" value="Double"/>
                    <el-option label="BigDecimal" value="BigDecimal"/>
                    <el-option label="LocalDateTime" value="LocalDateTime"/>
                    <el-option label="Boolean" value="Boolean"/>
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column label="主键" prop="isPk" min-width="5%">
                <template #default="scope">
                  <el-checkbox true-label="1" false-label="0" v-model="scope.row.isPk"></el-checkbox>
                </template>
              </el-table-column>
              <el-table-column label="DtoVo" prop="isDtoVo" min-width="5%">
                <template #default="scope">
                  <el-checkbox true-label="1" false-label="0" v-model="scope.row.isDtoVo"></el-checkbox>
                </template>
              </el-table-column>
              <el-table-column label="表单字段" prop="isForm" min-width="5%">
                <template #default="scope">
                  <el-checkbox true-label="1" false-label="0" v-model="scope.row.isForm"></el-checkbox>
                </template>
              </el-table-column>
              <el-table-column label="必填" prop="isRequired" min-width="5%">
                <template #default="scope">
                  <el-checkbox true-label="1" false-label="0" v-model="scope.row.isRequired"></el-checkbox>
                </template>
              </el-table-column>
              <el-table-column label="列表字段" prop="isList" min-width="5%">
                <template #default="scope">
                  <el-checkbox true-label="1" false-label="0" v-model="scope.row.isList"></el-checkbox>
                </template>
              </el-table-column>
              <el-table-column label="查询字段" prop="isQuery" min-width="5%">
                <template #default="scope">
                  <el-checkbox true-label="1" false-label="0" v-model="scope.row.isQuery"></el-checkbox>
                </template>
              </el-table-column>
              <el-table-column label="查询方式" prop="queryType" min-width="10%">
                <template #default="scope">
                  <el-select v-model="scope.row.queryType">
                    <el-option label="=" value="EQ"/>
                    <el-option label="!=" value="NE"/>
                    <el-option label=">" value="GT"/>
                    <el-option label=">=" value="GTE"/>
                    <el-option label="<" value="LT"/>
                    <el-option label="<=" value="LTE"/>
                    <el-option label="LIKE" value="LIKE"/>
                    <el-option label="BETWEEN" value="BETWEEN"/>
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column label="显示类型" prop="htmlType" min-width="12%">
                <template #default="scope">
                  <el-select v-model="scope.row.htmlType">
                    <el-option label="文本框" value="input"/>
                    <el-option label="文本域" value="textarea"/>
                    <el-option label="下拉框" value="select"/>
                    <el-option label="单选框" value="radio"/>
                    <el-option label="复选框" value="checkbox"/>
                    <el-option label="日期控件" value="datetime"/>
                    <el-option label="图片上传" value="imageUpload"/>
                    <el-option label="文件上传" value="fileUpload"/>
                    <!--  <el-option label="富文本控件" value="editor"/>-->
                  </el-select>
                </template>
              </el-table-column>
              <!--              <el-table-column label="字典类型" min-width="12%">-->
              <!--                <template slot-scope="scope">-->
              <!--                  <el-select v-model="scope.row.dictType" clearable filterable placeholder="请选择">-->
              <!--                    <el-option-->
              <!--                        v-for="dict in dictOptions"-->
              <!--                        :key="dict.dictType"-->
              <!--                        :label="dict.dictName"-->
              <!--                        :value="dict.dictType">-->
              <!--                      <span style="float: left">{{ dict.dictName }}</span>-->
              <!--                      <span style="float: right; color: #8492a6; font-size: 13px">{{ dict.dictType }}</span>-->
              <!--                    </el-option>-->
              <!--                  </el-select>-->
              <!--                </template>-->
              <!--              </el-table-column>-->
            </el-table>


          </el-tab-pane>
        </el-tabs>


      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefTableInfo">
import {reactive, ref} from 'vue';
import type {TabsPaneContext} from 'element-plus'
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialog from '/@/fly/components/dialog/DialogPopup';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useTableInfoBuilder, {TableInfo} from '/@/api/tools/model/TableInfoModel';

const {dialog, onShow, onClose} = useDialog();
const {tableInfo} = useTableInfoBuilder();

const columns = ref([]);


const activeName = ref('first')
const handleClick = (tab: TabsPaneContext, event: Event) => {
  console.log(tab, event)
}

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
const show = (type: DialogTypeEnum, data: TableInfo) => {
  columns.value = data.columns;
  //设置弹框的属性
  dialog.height = '90%'
  dialog.width = '95%'
  dialog.title = type;
  /* 清空表单内容 */
  resetForm(formRef.value, tableInfo);
  objCopy(data, tableInfo)
  dialog.showSubmit = true
  isDisabled.value = false
  dialog.showSubmit = true
  isDisabled.value = false

  onShow();
}

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  tableInfo.columns = columns;
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
  tplCategory: [{required: true, message: '使用的模板不能为空', trigger: 'blur'}],
  packageName: [{required: true, message: '生成包路径不能为空', trigger: 'blur'}],
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