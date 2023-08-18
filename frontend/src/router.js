import { createRouter, createWebHistory } from "vue-router";
import loginRoute from "./login/loginRoute.js";
import productRoute from "./product/productRoute.js"

const routes = [
  loginRoute,
  productRoute,
  { path: "/:catchAll(.*)", redirect: "/" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
