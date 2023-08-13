import { callPost } from "./calls";

export const loginAPI = {
  login: (username, password) => callPost("/login", {username, password}),
};
