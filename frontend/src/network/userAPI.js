import { callPost, callGet, callPut, callDelete } from "./calls";

export const userAPI = {
  submitLogin: (email, password) => callPost("/login", { email: email, password: password }),
  registerAccount: (name, email, password) => callPost("/register", {name: name, email: email, password: password}),
  getAllProducts: () => callGet("/products"),
  updateProduct: (product) => callPut("/products", product),
  deleteProduct: (productID) => callDelete("/products", productID),
};