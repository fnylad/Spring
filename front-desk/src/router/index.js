import { createRouter, createWebHistory } from 'vue-router'
// 登录注册模块
const Premise = () => import("../views/premise/main")
const ApplyLogin = () => import("../views/premise/login/apply_login")
const HireLogin =() => import("../views/premise/login/hire_login")
const ApplyRegister = () =>import('../views/premise/register/apply_register')
const HireRegister =() =>import('../views/premise/register/hire_register')

// 应聘系统主体模块
const ApplySystem = () => import("../views/apply-system/main")
const routes = [
  {
    path: '',
    redirect: '/premise/apply_login'
  },
  {
    path: '/premise',
    component: Premise,
    children: [
      {
        path: 'apply_login',
        component: ApplyLogin
      },
      {
        path:'hire_login',
        component: HireLogin
      },
      {
        path: 'apply_register',
        component: ApplyRegister
      },
      {
        path: 'hire_register',
        component: HireRegister
      },
    ]
  },
  {
    path: '/index',
    component: ApplySystem
  }

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
