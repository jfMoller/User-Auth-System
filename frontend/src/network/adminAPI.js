import { callGet, callPut, callDelete } from "./calls";

export const adminAPI = {
  getAllUsers: () => callGet("/users"),
  updateUserRole: (userID, userEmail, newUserRole) =>
    callPut("/users", {
      userID: userID, userEmail: userEmail, newUserRole: newUserRole }),
  deleteProduct: (userID) => callDelete("/users", userID),
};
