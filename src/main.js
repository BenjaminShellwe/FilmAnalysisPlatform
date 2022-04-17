import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'

// import echarts from 'echarts'
import * as echarts from 'echarts'
Vue.prototype.$echarts = echarts

import Cookies from 'js-cookie'
Vue.use(ElementUI, {
    size: Cookies.get('size') || 'medium' // set element-ui default size
})

import moment from 'moment'
Vue.prototype.moment = moment

import layer from 'vue-layer'
Vue.prototype.layer = layer(Vue)

import mammoth from 'mammoth'
Vue.prototype.mammoth = mammoth

import clipboard from 'clipboard'
Vue.prototype.clipboard = clipboard

import api from './api'
Vue.prototype.$api = api

import dayjs from 'dayjs'
Vue.prototype.$dayjs = dayjs

import auth from './util/auth'
Vue.use(auth)

import cookies from 'vue-cookies'
Vue.use(cookies)

import VueMeta from 'vue-meta'
Vue.use(VueMeta)

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

import hotkeys from 'hotkeys-js'
Vue.prototype.$hotkeys = hotkeys

import  axios from 'axios'
Vue.prototype.$axios = axios

// 全局组件自动注册
import './components/autoRegister'

// 自动加载 svg 图标
const req = require.context('./assets/icons', false, /\.svg$/)
const requireAll = requireContext => requireContext.keys().map(requireContext)
requireAll(req)

import './assets/styles/reset.scss'

import './mock'

Vue.config.productionTip = false

Vue.prototype.$eventBus = new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
