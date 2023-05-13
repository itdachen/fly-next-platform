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

        <el-tabs v-model="activeName">
          <el-tab-pane v-for="(value, key) in viewData"
                       :label="key.substring(key.lastIndexOf('/')+1,key.indexOf('.vm'))"
                       :name="key.substring(key.lastIndexOf('/')+1,key.indexOf('.vm'))"
                       :key="key">

            <!--                       v-clipboard:copy="value"
                                 v-clipboard:success="clipboardSuccess(value)"          -->
            <el-link :underline="false"
                     :icon="DocumentCopy"
                     @click="clipboardSuccess(value)"
                     style="float:right">复制
            </el-link>
            <pre><code class="hljs" v-html="highlightedCode(value, key)"></code></pre>
          </el-tab-pane>
        </el-tabs>
      </template>
    </dialog-popup>
  </div>
</template>

<script setup lang="ts" name="RefTableInfo">
import {ref} from 'vue';
import {DocumentCopy} from '@element-plus/icons-vue';
import useClipboard from 'vue-clipboard3'
import DialogPopup from '/@/fly/components/dialog/DialogPopup.vue';
import useDialog from '/@/fly/components/dialog/DialogPopup';
import {DialogTypeEnum} from '/@/fly/components/dialog/Dialog';
import useElementFromComposable from '/@/fly/composables/ElementFromComposable';
import useTableInfoBuilder from '/@/api/tools/model/TableInfoModel';

import hljs from "highlight.js/lib/highlight.js";
import "highlight.js/styles/github-gist.css";

import java from "highlight.js/lib/languages/java.js";
import xml from "highlight.js/lib/languages/xml.js";
import javascript from "highlight.js/lib/languages/javascript.js";
import sql from "highlight.js/lib/languages/sql.js";
import useTable from "/@/fly/components/table/TableComposables";

hljs.registerLanguage("java", java);
hljs.registerLanguage("xml", xml);
hljs.registerLanguage("html", xml);
hljs.registerLanguage("vue", xml);
hljs.registerLanguage("javascript", javascript);
hljs.registerLanguage("ts", javascript);
hljs.registerLanguage("sql", sql);

const {toClipboard} = useClipboard()
const {successMsg} = useTable();
const {dialog, onShow, onClose} = useDialog();
const {tableInfo} = useTableInfoBuilder();

const activeName = ref('dto.java');
const viewData = ref([]);

/**
 * 表单属性
 */
const {
  formRef
} = useElementFromComposable();


/**
 * 弹框展示(当成组件使用)
 * @param type
 * @param data
 */
const show = (type: DialogTypeEnum, data: any[]) => {
  activeName.value = 'dto.java';
  viewData.value = data;
  //设置弹框的属性
  dialog.height = '90%'
  dialog.width = '95%'
  dialog.title = '预览代码';

  dialog.showSubmit = false;

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

/** 高亮显示 */
const highlightedCode = (code: any, key: any) => {
  const vmName = key.substring(key.lastIndexOf("/") + 1, key.indexOf(".vm"));
  var language = vmName.substring(vmName.indexOf(".") + 1, vmName.length);
  const result = hljs.highlight(language, code || "", true);
  return result.value || '&nbsp;';
}

/** 复制代码成功 */
const clipboardSuccess = (value: any) => {
  toClipboard(value);
  successMsg('复制成功');
}

</script>

<style scoped lang="scss">

.code-b {
  background: -webkit-linear-gradient(top right, #3fa4d6, #3cbecb, #37c5c0, #33d5b5);
}

.xml-code {
  padding: 15px;
}

</style>