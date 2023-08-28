import UserPage from "./UserPage.vue";
import store from "../store";

const userRoute = {
  path: "/users",
  component: UserPage,
  beforeEnter: (to, from, next) => {
    if (store.getters.isAuthenticated && store.getters.userRole === "ADMIN") {
      next();
    } else {
      next("/");
    }
  },
};
export default userRoute;
