<template>

</template>

<script setup lang='ts' name='AppClientManagement'>
import { onMounted } from 'vue';
import { Search, Edit, CirclePlus, View, Delete } from '/@/element-plus/icons';
import ProTable from '/@/components/ProTable/index.vue';
import RefAppClient from './RefAppClient.vue';


/**
 * 初始化页面时加载
 */
onMounted(() => {
  // loadTableData(queryParams);
});

</script>

<style scoped>

</style>