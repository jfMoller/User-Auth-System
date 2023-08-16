import { createRouter, createWebHistory } from "vue-router";
import loginRoute from "./login/LoginRoute";
import homeRoute from "./home/homeRoute";

export const routes = [
  loginRoute,
  homeRoute,
  { path: "/:catchAll(.*)", redirect: "/" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
