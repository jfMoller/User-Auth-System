import Login from "./LoginPage.vue";
import store from "../store";

const loginRoute = {
  path: "/login",
  component: Login,
  beforeEnter: (to, from, next) => {
    if (store.getters.isAuthenticated) {
      next("/products");
    } else {
      next();
    }
  },
};

export default loginRoute;