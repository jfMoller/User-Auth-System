import { createRouter, createWebHistory } from "vue-router";
import loginRoute from "./login/loginRoute.js";
import homeRoute from "./home/homeRoute.js";

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
