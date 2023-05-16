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
        <el-form :model="workerInfo" ref="formRef"
                 :rules="rules" :disabled="isDisabled"
                 size="small" label-width="120px">
          <el-form-item label="职工编号" prop="workerNo" class="mb20">
            <el-input v-model="workerInfo.workerNo" placeholder="请输入职工编号"/>
          </el-form-item>

          <el-form-item label="职工姓名" prop="workerName" class="mb20">
            <el-input v-model="workerInfo.workerName" placeholder="请输入职工姓名"/>
          </el-form-item>

          <el-form-item label="性别" prop="sex" class="mb20">
            <el-select v-model='workerInfo.sex' style="width: 160px;">
              <el-option label='男' value='1'/>
              <el-option label='女' value='2'/>
              <el-option label='未知' value='0'/>
            </el-select>

          </el-form-item>

          <el-form-item label="头像" prop="avatar" class="mb20">
            <el-upload class="avatar-uploader"
                       :show-file-list="false"
                       accept=".png,.jpg,jpeg"
                       :http-request="avatarUploader">
              <img v-if="imageUrl" :src="imageUrl" class="avatar"/>
              <el-icon v-else class="avatar-uploader-icon">
                <Plus/>
              </el-icon>
            </el-upload>
          </el-form-item>

          <el-form-item label="生日" prop="birthday" class="mb20">
            <el-date-picker v-model="workerInfo.birthday"
                            type="date"
                            placeholder="请选择生日"/>
          </el-form-item>

          <el-form-item label="电话号码" prop="telephone" class="mb20">
            <el-input v-model="workerInfo.telephone" placeholder="请输入电话号码"/>
          </el-form-item>

          <el-form-item label="电子邮箱" prop="email" class="mb20">
            <el-input v-model="workerInfo.email" placeholder="请输入电子邮箱"/>
          </el-form-item>

          <el-form-item label="入职日期" prop="entryDay" class="mb20">
            <!--            <el-input v-model="workerInfo.entryDay" placeholder="请输入入职日期"/>-->

            <el-date-picker v-model="workerInfo.entryDay"
                            type="date"
                            placeholder="请选择入职日期"/>

          </el-form-item>

          <el-form-item label="状态" class="mb20">
            <el-select v-model='workerInfo.status' style="width: 160px;">
              <el-option label='正常' value='1'/>
              <el-option label='休假' value='2'/>
              <el-option label='离职' value='0'/>
            </el-select>
          </el-form-item>

          <el-form-item label="备注" prop="remarks" class="mb20">
            <el-input v-model="workerInfo.remarks" type="textarea" placeholder="请输入备注"/>
          </el-form-item>


          <!--          <el-form-item label="离职日期" prop="departDay" class="mb20">-->
          <!--            <el-input v-model="workerInfo.departDay" placeholder="请输入离职日期"/>-->
          <!--          </el-form-item>-->

        </el-form>
      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefWorkerInfo">
import {reactive, ref} from 'vue';
import {Plus} from '@element-plus/icons-vue';
import type {UploadProps} from 'element-plus'
import {ElMessage} from "element-plus";
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialogPopup, {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useWorkerInfoBuilder, {WorkerInfo} from '/@/api/admin/model/WorkerInfoModel';
import {fileUploader} from "/@/api/oss/OssFileApi";


/**
 * 弹框属性
 */
const {dialog, onShow, onClose} = useDialogPopup();

const {workerInfo} = useWorkerInfoBuilder();

/**
 * 表单属性
 */
const {
  formRef,
  resetForm,
  objCopy,
  isDisabled
} = useElementFromComposable();

const imageUrl = ref('');

/**
 * 弹框
 * @param type 弹窗类型
 * @param data 展示的数据
 */
const show = (type: DialogTypeEnum, data?: WorkerInfo) => {
  //设置弹框的属性
  dialog.height = '500px'
  dialog.width = '800px'
  dialog.title = type + '员工信息';
  /* 清空表单内容 */
  resetForm(formRef.value, workerInfo);
  if (undefined !== data && null !== data) {
    /* 新表单赋值 */
    objCopy(data, workerInfo)
  }
  if (DialogTypeEnum.VIEW === type) {
    dialog.showSubmit = false
    isDisabled.value = true
  }
  if (DialogTypeEnum.SAVE === type) {
    workerInfo.sex = '1';
    workerInfo.status = '1';
    dialog.showSubmit = true
    isDisabled.value = false
  }
  if (DialogTypeEnum.UPDATE === type){
    imageUrl.value = data?.avatar as string;
    dialog.showSubmit = true
    isDisabled.value = false
  }

  onShow();
}



/**
 * 头像上传
 * @param file
 */
const avatarUploader = (file) => {
  fileUploader(file).then(res => {
    workerInfo.avatar = res.data.url;
    imageUrl.value = res.data.url;
  })
}

/**
 * 表单验证
 */
const rules = reactive({
  workerNo: [{required: true, message: '职工编号不能为空', trigger: 'blur'}],
  workerName: [{required: true, message: '职工姓名不能为空', trigger: 'blur'}],
  sex: [{required: true, message: '性别不能为空', trigger: 'blur'}],
  avatar: [{required: true, message: '头像不能为空', trigger: 'blur'}],
  birthday: [{required: true, message: '生日不能为空', trigger: 'blur'}],
  telephone: [{required: true, message: '电话号码不能为空', trigger: 'blur'}],
  email: [{required: true, message: '电子邮箱不能为空', trigger: 'blur'}],
  status: [{required: true, message: '状态不能为空', trigger: 'blur'}],
  entryDay: [{required: true, message: '入职日期不能为空', trigger: 'blur'}],
  departDay: [{required: true, message: '离职日期不能为空', trigger: 'blur'}],
});

//定义事件
const emits = defineEmits(['bindtap'])

const confirm = () => {
  formRef.value?.validate(valid => {
    if (valid) {
      emits('bindtap', workerInfo)
    }
  })
}

defineExpose({
  show,
  onClose
})

</script>

<style scoped lang="scss">
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>