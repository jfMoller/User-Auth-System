import { createRouter, createWebHistory } from "vue-router";
import Login from "./components/Login.vue";
import HomePage from "./HomePage.vue";
import store from "./store";

export const routes = [
  {
    path: "/",
    component: Login,
    beforeEnter: (to, from, next) => {
      if (store.getters.isAuthenticated) {
        next("/home");
      } else {
        next();
      }
    },
  },
  {
    path: "/home",
    component: HomePage,
    beforeEnter: (to, from, next) => {
      if (store.getters.isAuthenticated) {
        next();
      } else {
        next("/");
      }
    },
  },
  { path: "/:catchAll(.*)", redirect: "/" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;