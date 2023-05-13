<template>
  <el-pagination :currentPage="currentPage"
                 :page-size="pageSize"
                 :total="total"
                 :page-sizes="[10, 25, 50, 100]"
                 @size-change="handleSizeChange"
                 @current-change="handleCurrentChange"
                 layout="total, sizes, prev, pager, next, jumper"
                 prev-text="上一页"
                 next-text="下一页"></el-pagination>
</template>

<script setup lang="ts" name="pagination">

const props = withDefaults(defineProps(), {
  /* 总条数 */
  total: 0,
  /*当前显示的第几页*/
  currentPage: 0,
  /* 每页显示条目个数 */
  pageSize: 0,
  /* 是否显示背景色 */
  background: false,
})


let emits = defineEmits(['handleSizeChange', 'handleCurrentChange'])

/**
 * 修改每页展示多少条
 * @param val 需要展示的条数
 */
const handleSizeChange = (val: number) => {
  emits('handleSizeChange', val)
}

/**
 * 上一页/下一页 按钮 previousNextPage
 * @param val 第多少页
 */
const handleCurrentChange = (val: number) => {
  emits('handleCurrentChange', val)
}

</script>


<style scoped>
/*.table-box .el-pagination {*/
/*  justify-content: flex-start;*/
/*}*/
</style>