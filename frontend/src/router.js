import { createRouter, createWebHistory } from "vue-router";
import loginRoute from "./login/loginRoute.js";
import registerRoute from "./register/registerRoute.js"
import productRoute from "./product/productRoute.js"

const routes = [
  loginRoute,
  registerRoute,
  productRoute,
  { path: "/:catchAll(.*)", redirect: "/" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
