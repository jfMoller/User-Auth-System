import { createStore } from "vuex";

const store = createStore({
  state: {
    isAuthenticated: false,
    isLoading: false,
  },
  mutations: {
    setAuthenticated(state, value) {
      state.isAuthenticated = value;
    },
    setIsLoading(state, value) {
      state.isLoading = value;
    },
  },
  actions: {
    authenticate({ commit }) {
      commit("setAuthenticated", true);
    },
    revokeAuthentication({ commit }) {
      commit("setAuthenticated", false);
    },
    setIsLoading({ commit }, value) {
      commit("setIsLoading", value);
    },
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    },

    isLoading(state) {
      return state.isLoading;
    },
  },
});

export default store;
