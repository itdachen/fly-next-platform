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

<!-- scoped -->
<style lang="scss" >

.left-tree-title {
  padding: 20px 20px 10px 10px;
  text-align: left;
  border-bottom: #dfe6ec 1px solid;
  background-color: #ffffff;
  font-size: 18px;
  color: #606266;
  margin-right: 20px;
}

.el-tree {
  padding: 10px 20px 10px 0;
  --el-tree-node-hover-bg-color: #f1f1f1;
}

//使用的地方  不要加scoped
.el-tree-node.is-current > .el-tree-node__content {
  background-color: #cce1fb !important;
  border-radius: 3px;
  padding-right: 20px;
}


</style>