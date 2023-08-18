import { callPost, callGet, callPut, callDelete } from "./calls";

export const API = {
  submitLogin: (email, password) => callPost("/login", { email: email, password: password }),
  getAllProducts: () => callGet("/products"),
  updateProduct: (product) => callPut("/products", product),
  deleteProduct: (productID) => callDelete("/products", productID),
};