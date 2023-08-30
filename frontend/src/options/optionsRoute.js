import OptionsPage from "./OptionsPage.vue";
import store from "../store";

const optionsRoute = {
  path: "/options",
  component: OptionsPage,
  beforeEnter: (to, from, next) => {
    if (store.getters.isAuthenticated) {
      next();
    } else {
      next("/login");
    }
  },
};

export default optionsRoute;
