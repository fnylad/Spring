import { createRouter, createWebHistory } from 'vue-router'
// 登录注册模块
const Premise = () => import("../views/premise/main")
const ApplyLogin = () => import("../views/premise/login/apply_login")

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
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
