import HomePage from "./HomePage.vue";
import store from "../store";

const homeRoute = {
    path: "/home",
    component: HomePage,
    beforeEnter: (to, from, next) => {
      if (store.getters.isAuthenticated) {
        next();
      } else {
        next("/");
      }
    }
}
export default homeRoute;