import { callPost } from "./calls";

export const API = {
  attemptLogin: (email, password) => callPost("/login", {email: email, password: password}),
};
