<script>
import Login from "./LoginPage.vue";
import store from "../store";

const loginRoute = {
  path: "/",
  component: Login,
  beforeEnter: (to, from, next) => {
    if (store.getters.isAuthenticated) {
      next("/home");
    } else {
      next();
    }
  },
};

export default loginRoute;
</script>