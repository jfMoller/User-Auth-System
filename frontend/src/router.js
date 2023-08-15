import { createRouter, createWebHistory } from 'vue-router';
import Login from './components/Login.vue';
import HomePage from './HomePage.vue'

export const routes = [
  { path: '/', component: Login },
  { path: '/home', component: HomePage},
  { path: '/:catchAll(.*)', redirect: '/' },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;