import ProductPage from "./ProductPage.vue"
import store from "../store";

const productRoute = {
    path: "/product",
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