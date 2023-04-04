import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import axios from "axios";
import VueAxios from "vue-axios";

// 公共样式
import 'element-plus/dist/index.css'
createApp(App).use(store).use(router).use(ElementPlus).use(VueAxios,axios).mount('#app')
