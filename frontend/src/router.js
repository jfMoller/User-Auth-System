import { createRouter, createWebHistory } from "vue-router";
import loginRoute from "./login/LoginRoute.vue";
import homeRoute from "./home/HomeRoute.vue";

const routes = [
  loginRoute,
  homeRoute,
  { path: "/:catchAll(.*)", redirect: "/" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
