import axios from "axios";

const baseUrl = "http://localhost:8080/api";

export async function callGet(endpoint) {
  let result = await axios.request({
    method: "GET",
    url: baseUrl + endpoint,
    withCredentials: true,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
  });
  return result.data;
}

export async function callPost(endpoint, data) {
  let result = await axios.request({
    method: "POST",
    url: baseUrl + endpoint,
    withCredentials: true,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
    data: data,
  });
  return result.data;
}
