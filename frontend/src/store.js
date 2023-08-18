import { createStore } from "vuex";

const store = createStore({
  state: {
    isAuthenticated: false,
    isEditing: false,
    isLoading: false,
  },
  mutations: {
    setAuthenticated(state, value) {
      state.isAuthenticated = value;
    },
    setIsEditing(state, value) {
      state.isEditing = value;
    },
    setIsLoading(state, value) {
      state.isLoading = value;
    },
  },
  actions: {
    authenticate({ commit }) {
      commit("setAuthenticated", true);
    },
    disconnect({ commit }) {
      commit("setAuthenticated", false);
    },
    setIsEditing({ commit }, value) {
      commit("setIsEditing", value);
    },
    setIsLoading({ commit }, value) {
      commit("setIsLoading", value);
    },
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    },

    isEditing(state) {
      return state.isEditing;
    },

    isLoading(state) {
      return state.isLoading;
    },
  },
});

export default store;
