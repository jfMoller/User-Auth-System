import { callPost } from "./calls";

export const API = {
  submitLogin: (email, password) => callPost("/login", { email: email, password: password }),
};
