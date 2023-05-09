<template>
  <el-tree ref="parentTree"
           :data="data"
           :props="defaultProps"
           @node-click="handleNodeClick"
           :node-key="nodeKey"
           default-expand-all
           :highlight-current="true"
           :expand-on-click-node="false">
    <template #default="{ node, data }">
      <div class="custom-tree-container">
            <span v-if="data.children && 0 === data.children.length ">
              <DocumentRemove style="width: 1.3em; height: 1.3em; margin-right: 5px;color: #8c8c8c;"></DocumentRemove>
            </span>
        <!-- 点击展开和关闭 -->
        <span v-else @click.stop="openBtn(data)">
              <component style="width: 1.1em; height: 1.1em; margin-right: 5px;color: #8c8c8c;"
                         :is="data.open ? Plus : Minus"/>
            </span>
        <span>{{ node.label }}</span>
      </div>
    </template>
  </el-tree>
</template>
<script setup lang='ts'>
import {ref} from 'vue'
import {Plus, Minus} from '@element-plus/icons-vue';
import {ElTree} from 'element-plus';

const props = defineProps({
  data: {
    type: Array,
    default: [],
  },
  nodeKey: {
    type: String,
    default: 'id'
  },
  defaultProps: {
    type: Object,
    default: {
      children: 'children',
      label: 'label',
    }
  }
})

//树的ref属性
const parentTree = ref<InstanceType<typeof ElTree>>();

const openBtn = (data: any) => {
  //设置展开或者关闭
  data.open = !data.open;
  if (parentTree.value) {
    parentTree.value.store.nodesMap[data.id].expanded = !data.open;
  }
}


//注册事件
const emit = defineEmits(['treeClick'])

//树的点击事件
const handleNodeClick = (data: any) => {
  emit('treeClick', data)
}


</script>

<style lang="scss">
.el-tree {
  font-size: 12px;
  padding: 2vh 1vw;
  height: 76vh;
  width: 12.4vw;

  .el-tree-node {
    position: relative;
    padding-left: 10px;
  }

  .el-tree-node__children {
    padding-left: 20px;
  }

  .el-tree-node :last-child:before {
    height: 40px;
  }

  .el-tree > .el-tree-node:before {
    border-left: none;
  }

  .el-tree > .el-tree-node:after {
    border-top: none;
  }

  .el-tree-node:before,
  .el-tree-node:after {
    content: "";
    left: -4px;
    position: absolute;
    right: auto;
    border-width: 1px;
  }

  .tree :first-child .el-tree-node:before {
    border-left: none;
  }

  .el-tree-node:before {
    border-left: 1px solid #d9d9d9;
    bottom: 0px;
    height: 100%;
    top: -25px;
    width: 1px;
  }

  .el-tree-node:after {
    border-top: 1px solid #d9d9d9;
    height: 20px;
    top: 14px;
    width: 12px;
  }

  .el-tree-node__expand-icon.is-leaf {
    width: 8px;
  }

  .el-tree-node__content > .el-tree-node__expand-icon {
    display: none;
  }

  .el-tree-node__content {
    line-height: 30px;
    height: 30px;
    padding-left: 10px !important;
  }
}

.el-tree > div {
  &::before {
    display: none;
  }

  &::after {
    display: none;
  }
}

.el-tree-node .is-expanded .is-current .is-focusable::before {
  width: 100%;
}

.el-tree--highlight-current .el-tree-node.is-current > .el-tree-node__content {
  background-color: #faf7f4;
  border-radius: 8px;
}

.el-tree-node__content {
  border-radius: 8px;
}

.el-tree {
  --el-tree-node-hover-bg-color: #faf7f4;
  color: #36375B;
}
</style>
