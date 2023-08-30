import { createStore } from "vuex";

const store = createStore({
  state: {
    isAuthenticated: false,
    userRole: String,
    isLoading: false,
    hasAllRegisterCredentials: false,
  },
  mutations: {
    setAuthenticated(state, value) {
      state.isAuthenticated = value;
    },
    setUserRole(state, value) {
      state.userRole = value;
    },
    setIsLoading(state, value) {
      state.isLoading = value;
    },
    setHasAllRegisterCredentials(state, value) {
      state.hasAllRegisterCredentials = value;
    },
  },
  actions: {
    authenticate({ commit }) {
      commit("setAuthenticated", true);
    },
    revokeAuthentication({ commit }) {
      commit("setAuthenticated", false);
    },
    setUserRole({ commit }, value) {
      commit("setUserRole", value);
    },
    setIsLoading({ commit }, value) {
      commit("setIsLoading", value);
    },
    setHasAllRegisterCredentials({ commit }, value) {
      commit("setHasAllRegisterCredentials", value);
    },
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    },

    userRole(state) {
      return state.userRole;
    },

    isLoading(state) {
      return state.isLoading;
    },

    hasAllRegisterCredentials(state) {
      return state.hasAllRegisterCredentials;
    },
  },
});

export default store;
