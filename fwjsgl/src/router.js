import Vue from 'vue'
import Router from 'vue-router'
//引入组件
import Journey from './components/Journey'
import Information from './components/Information'

Vue.use(Router);
export default new Router({
    routes: [
        {path: '/', component: Journey},
        {path: '/Journey', component: Journey},
        {path: '/Information', component: Information}
    ],
    mode: 'history'
})