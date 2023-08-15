import { createStore } from "vuex";

export default createStore({
  state: {
    isAuthenticated: false,
  },
  mutations: {
    setAuthenticated(state, value) {
      state.isAuthenticated = value;
    },
  },
  actions: {
    authenticate({ commit }) {
      commit("setAuthenticated", true);
    },
    disconnect({ commit }) {
      commit("setAuthenticated", false);
    },
  },
  getters: {
    isAuthenticated(state) {
      // Removed "this" and passed "state" as an argument
      console.log(state.isAuthenticated);
      return state.isAuthenticated;
    },
  },
});
