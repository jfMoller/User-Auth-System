import { callPost } from "./calls";

export const API = {
  submitLogin: async (email, password) => {
    localStorage.removeItem("jwtToken");
    const result = await callPost("/login", {email: email, password: password});
    localStorage.setItem("jwtToken", result);
     }
  
};
