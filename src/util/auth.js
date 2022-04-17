import { auth, authAll } from '@/util'
import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'

export function getToken() {
    return Cookies.get(TokenKey)
}

// 设置浏览器token
export function setToken(token) {
    return Cookies.set(TokenKey, token)
}

export function removeToken() {
    return Cookies.remove(TokenKey)
}

export default {
    install(Vue) {
        Vue.prototype.$auth = auth
        Vue.prototype.$authAll = authAll
        // 注册 v-auth 和 v-auth-all 指令
        Vue.directive('auth', {
            inserted: (el, binding) => {
                if (!auth(binding.value)) {
                    el.remove()
                }
            }
        })
        Vue.directive('auth-all', {
            inserted: (el, binding) => {
                if (!authAll(binding.value)) {
                    el.remove()
                }
            }
        })
    }
}
