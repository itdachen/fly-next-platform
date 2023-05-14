<template>

  <dialog-popup :title="dialog.title"
                :visible="dialog.visible"
                :width="dialog.width"
                :height="dialog.height"
                :showSubmit="dialog.showSubmit"
                @onClose="onClose()"
                @onConfirm="confirm">

    <template v-slot:content>
      <el-tree ref="refTree"
               :data="tree.data"
               node-key="id"
               :props="defaultProps"
               empty-text="暂无数据"
               :show-checkbox="showCheckbox"
               default-expand-all
               :highlight-current="highlight"
               @node-click="handleNodeClick"
               :default-checked-keys="tree.checked"/>
    </template>

  </dialog-popup>

</template>

<script lang="ts" setup name="RadioTree">
import {ref} from "vue";
import DialogPopup from '@/components/dialog/DialogPopup.vue'
import useDialog from "@/components/dialog/DialogPopup";
import useElTreeComposable from "@/components/tree/composables/ElTreeComposable";

//弹框属性
const {dialog, onShow, onClose} = useDialog();

const {refTree, tree, getCheckedNode} = useElTreeComposable();

const props = defineProps({
  // 是否显示多选框
  showCheckbox: {
    type: Boolean,
    default: false
  },
  // 是否显示连接线
  highlight: {
    type: Boolean,
    default: true
  },
  // tree 展示数据属性
  defaultProps: {
    type: Object,
    default: {
      children: 'children', //设置树的children
      label: 'title', //设置树的名字属性字段
    }
  }
})


/**
 * 存储选中的数据
 */
const selectNode = ref({})

/**
 * 树的点击事件
 * @param data 选中的是整个对象(点击标题时有效)
 */
const handleNodeClick = (data: any) => {
  selectNode.value = data;
}


/**
 * 子组件传值给父组件
 * 这里传输整个对象, 方便父组件灵活拓展
 */
const emits = defineEmits(['select'])
const confirm = () => {
  if (props.showCheckbox) {
    // 获取选中的数据
    const checkedIds = refTree.value?.getCheckedKeys(false) || [];
    // 获取半节点ids
    const hlfIds = refTree.value?.getHalfCheckedKeys() || [];
    const ids = checkedIds?.concat(hlfIds).join(',');
    emits('select', ids)
  } else {
    emits('select', selectNode.value)
  }
  // 点击确定按钮的时候, 向父组件传输数据, 关闭弹窗
  onClose();
}

/**
 * 弹窗
 * @param data   展示的数据
 * @param title  弹窗标题
 */
const show = async (data: ElTreeModel, title?: string | undefined) => {
  //设置弹框属性
  dialog.height = '420px';
  dialog.width = '350px';
  dialog.title = title

  tree.data = [];
  tree.checked = [];

  /**
   * 选中的数据, Element 有个坑, 需要选择最后一个, 才能正常回显
   */
  const checkedIds = await getCheckedNode(data.checked, data.data);

  tree.data = data.data;
  tree.checked = checkedIds;

  //显示
  onShow();
}


/**
 * 把弹窗方法暴露出去
 */
defineExpose({
  show
})

</script>

<style scoped lang="scss">
.el-tree {
  padding-top: 20px;
  --el-tree-node-hover-bg-color: #e3e3e3;
}
</style>