import ProductPage from "./ProductPage.vue"
import store from "../store";

const productRoute = {
    path: "/products",
    component: ProductPage,
    beforeEnter: (to, from, next) => {
      if (store.getters.isAuthenticated) {
        next();
      } else {
        next("/");
      }
    }
}
export default productRoute;