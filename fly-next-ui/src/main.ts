import {createApp} from 'vue';
import pinia from '/@/stores/index';
import App from '/@/App.vue';
import router from '/@/router';
import {directive} from '/@/directive/index';
//引入按钮权限
import { permission } from '/@/directive/permission';
import {i18n} from '/@/i18n/index';
import other from '/@/utils/other';

import ElementPlus from 'element-plus';
import '/@/theme/index.scss';
import VueGridLayout from 'vue-grid-layout';


// custom element dark
import '/@/styles/element-dark.scss';
// custom element css
import '/@/styles/element.scss';
// reset style sheet
import '/@/styles/reset.scss';
// CSS common style sheet
import '/@/styles/common.scss';


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
