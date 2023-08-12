import { callGet } from "./calls";

export const loginAPI = {
  getAllUsers: () => callGet("users"),
};
