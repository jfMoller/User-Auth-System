import { createStore } from "vuex";

const store = createStore({
  state: {
    isAuthenticated: false,
    products: [],
  },
  mutations: {
    setAuthenticated(state, value) {
      state.isAuthenticated = value;
    },
    setProducts(state, products) {
      state.products = products;
    },
    removeProduct(state, productID) {
      state.products = state.products.filter(
        (product) => product.id !== productID
      );
    },
  },
  actions: {
    authenticate({ commit }) {
      commit("setAuthenticated", true);
    },
    disconnect({ commit }) {
      commit("setAuthenticated", false);
    },
    setProducts({ commit }, products) {
      commit("setProducts", products);
    },
    removeProduct({ commit }, productID) {
      commit("removeProduct", productID);
    },
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    },

    products(state) {
      return state.products;
    },
  },
});

export default store;
