import UserPage from "./UserSPage.vue";
import store from "../store";

const userRoute = {
  path: "/users",
  component: UserPage,
  beforeEnter: (to, from, next) => {
    if (store.getters.isAuthenticated && store.getters.userRole === "ADMIN") {
      next();
    } else {
      next("/login");
    }
  },
};
export default userRoute;
