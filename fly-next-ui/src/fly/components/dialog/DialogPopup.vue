<template>
  <el-dialog :title='title'
             top='10vh'
             :model-value='visible'
             :before-close='onClose'
             :append-to-body='true'
             :close-on-click-modal='false'
             :draggable="true"
             :width='width'>
    <div class='container' :style='{height:height}'>
      <slot name='content'></slot>
    </div>
    <template v-if='showFooter' #footer>
       <span class='dialog-footer'>
         <el-button type="success" size="default" @click='onConfirm' v-if='showSubmit'>确定</el-button>
         <el-button @click='onClose' type="primary" plain size="default">关闭</el-button>
       </span>
    </template>
  </el-dialog>
</template>
<script setup lang='ts'>
const props = defineProps({
  title: {
    type: String,
    default: '表单',
  },
  visible: {
    type: Boolean,
    default: false,
  },
  width: {
    type: String,
    default: '55px',
  },
  height: {
    type: String,
    default: '75px',
  },
  showSubmit: {
    type: Boolean,
    default: true,
  },
  showClose: {
    type: Boolean,
    default: true,
  },
  showFooter: {
    type: Boolean,
    default: true,
  },
});

let emits = defineEmits(['onConfirm', 'onClose']);

//定义弹框的确定
const onConfirm = () => {
  emits('onConfirm');
};

// 取消
const onClose = () => {
  emits('onClose');
};

</script>
<style lang='scss' scope>
.container {
  overflow-x: initial;
  overflow-y: auto;
  padding: 10px 10px;
}

.el-dialog {
  border-top-left-radius: 5px !important;
  border-top-right-radius: 5px !important;

  .el-dialog__header {
    height: 50px;
    padding-top: 15px;
    padding-bottom: 15px;
    border-top-left-radius: 5px !important;
    border-top-right-radius: 5px !important;
    background-color: #ffffff !important;
    border-bottom: 1px solid #e8eaec !important;


    .el-dialog__title {
      color: #111111;
      font-size: 16px;
      font-weight: 400;
    }

    .el-dialog__close {
      color: #111111;
    }
  }

  .el-dialog__body {
    padding: 10px;
  }

  .el-dialog__footer {
    border-top: 1px solid #e8eaec !important;
    padding: 10px 20px 10px 10px;
  }
}
</style>