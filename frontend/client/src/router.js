import { createRouter, createWebHistory } from "vue-router";
import loginRoute from "./login/LoginRoute.js";
import optionsRoute from "./options/optionsRoute.js";
import registerRoute from "./register/registerRoute.js";
import productRoute from "./products/productRoute.js";
import userRoute from "./users/userRoute.js";

const routes = [
  loginRoute,
  optionsRoute,
  registerRoute,
  productRoute,
  userRoute,
  { path: "/:catchAll(.*)", redirect: "/login" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
