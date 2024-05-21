import { createRouter, createWebHashHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import HomeView from '../views/HomeView.vue'
import Choice1View from '../views/Choice1View.vue'
import Choice2View from '../views/Choice2View.vue'
import Choice3View from '../views/Choice3View.vue'
const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path:'/choice1',
    name:'choice1',
    component: Choice1View
  },
  {
    path:'/choice2',
    name:'choice2',
    component: Choice2View
  },
  {
    path:'/choice3',
    name:'choice3',
    component: Choice3View
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
