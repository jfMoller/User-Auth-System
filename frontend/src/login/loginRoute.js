import LoginPage from "./LoginPage.vue";
import store from "../store";

const loginRoute = {
  path: "/login",
  component: LoginPage,
  beforeEnter: (to, from, next) => {
    if (store.getters.isAuthenticated) {
      next("/options");
    } else {
      next();
    }
  },
};

export default loginRoute;
