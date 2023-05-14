<template>

  <div class="left-tree-title">{{ title }}</div>
  <el-tree ref="leftTree"
           :data="data"
           :node-key="nodeKey"
           :props="defaultProps"
           default-expand-all
           @node-click="handleNodeClick"
           :expand-on-click-node="clickExpand">
  </el-tree>

</template>
<script setup lang='ts'>

const props = defineProps({
  title: {
    type: String,
    default: '树数据'
  },
  data: {
    type: Array,
    default: [],
  },
  highlight: {
    type: Boolean,
    default: false
  },
  nodeKey: {
    type: String,
    default: 'id'
  },
  clickExpand: {
    type: Boolean,
    default: true
  },
  defaultProps: {
    type: Object,
    default: {
      children: 'children', //设置树的children
      label: 'title', //设置树的名字属性字段
    }
  }
})

//注册事件
const emits = defineEmits(['treeClick'])

//树的点击事件
const handleNodeClick = (data: any) => {
  emits('treeClick', data)
}


</script>

<style lang="scss" scoped>

.left-tree-title {
  padding-top: 20px;
  text-align: center;
  border-bottom: #dfe6ec 1px solid;
  background-color: #ffffff;
  font-size: 18px;
  padding-bottom: 10px;
  color: #606266;
}

.el-tree {
  padding: 20px;
  --el-tree-node-hover-bg-color: #e8e8e8;
}

</style>