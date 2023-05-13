import {createApp} from 'vue';
import pinia from '/@/stores/index';
import App from '/@/App.vue';
import router from '/@/router';
import {directive} from '/@/directive/index';
//引入按钮权限
import { permission } from '/@/fly/directive/permission';
import {i18n} from '/@/i18n/index';
import other from '/@/utils/other';

import ElementPlus from 'element-plus';
import '/@/theme/index.scss';
import VueGridLayout from 'vue-grid-layout';


import '/@/fly/styles/element-dark.scss';
import '/@/fly/styles/element.scss';
import '/@/fly/styles/reset.scss';
import '/@/fly/styles/common.scss';


const app = createApp(App);

directive(app);
other.elSvg(app);
app.directive('permission', permission);
app.use(pinia)
    .use(router)
    .use(ElementPlus)
    .use(i18n)
    .use(VueGridLayout)
    .mount('#app');
