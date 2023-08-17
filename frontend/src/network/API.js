import { callPost, callGet, callDelete } from "./calls";

export const API = {
  submitLogin: (email, password) => callPost("/login", { email: email, password: password }),
  getAllProducts: () => callGet("/products"),
  deleteProductByID: (productID) => callDelete("/products", productID),
};