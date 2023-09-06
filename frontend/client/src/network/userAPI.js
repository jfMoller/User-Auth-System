import { callPost, callGet, callPut, callDelete } from "./calls";
import store from "../store";

export const userAPI = {
  submitLogin: async (email, password) => {
    const response = await callPost("/login", {
      email: email,
      password: password,
    });

    if (response.ERROR) {
      store.commit("setLoginErrorMessage", response.message);
    }

    if (response.SUCCESS) {
      store.commit("setLoginErrorMessage", null);
      store.commit("setUserRole", response.userRole);
      sessionStorage.setItem("jwtToken", response.token);

      // Handles server-side authentication by testing if token is valid based on user data
      const isAuthenticated = await callPost("/authenticate", {
        email: email,
        password: password,
      });

      if (isAuthenticated) {
        store.commit("setAuthenticated", true);
        await store.dispatch("authenticate");
        return true;
      } else {
        return false;
      }
    }
  },

  isAuthenticated: (email, password) =>
    callPost("/authenticate", { email: email, password: password }),

  registerAccount: (name, email, password) =>
    callPost("/register", { name: name, email: email, password: password }),

  getAllProducts: () => callGet("/products"),

  updateProduct: (product) => callPut("/products", product),

  createNewProduct: (productName) =>
    callPost("/products", { name: productName }),

  deleteProduct: (productID) => callDelete("/products", productID),
};
