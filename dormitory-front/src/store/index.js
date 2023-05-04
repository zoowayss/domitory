import {createStore} from 'vuex'
// 页面变量
export default createStore({
    state: {
        isLogin: false,
        identity: ''
    },
    mutations: {
        login(state) {
            state.isLogin = true
        }
    },
    actions: {},
    modules: {}
})
