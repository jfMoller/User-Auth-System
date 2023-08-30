import axios from "axios";
import store from "../store";

const baseUrl = "http://localhost:8080/api";

const setIsLoading = (boolean) => store.dispatch("setIsLoading", boolean);

export async function callGet(endpoint) {
  setIsLoading(true);
  let result = await axios.request({
    method: "GET",
    url: baseUrl + endpoint,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
  });
  setIsLoading(false);
  return result.data;
}

export async function callPost(endpoint, data) {
  setIsLoading(true);
  let result = await axios.request({
    method: "POST",
    url: baseUrl + endpoint,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
    data: data,
  });
  setIsLoading(false);
  return result.data;
}

export async function callPut(endpoint, data) {
  setIsLoading(true);
  let result = await axios.request({
    method: "PUT",
    url: baseUrl + endpoint,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
    data: data,
  });
  setIsLoading(false);
  return result.data;
}

export async function callDelete(endpoint, id) {
  setIsLoading(true);
  await axios.request({
    method: "DELETE",
    url: baseUrl + endpoint + "/" + id,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
  });
  setIsLoading(false);
}
