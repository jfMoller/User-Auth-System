import axios from "axios";

const baseUrl = "http://localhost:8080/api";

export async function callGet(endpoint) {
  let result = await axios.request({
    method: "GET",
    url: baseUrl + endpoint,
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
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
    data: data,
  });
  return result.data;
}

export async function callPut(endpoint, data) {
  let result = await axios.request({
    method: "PUT",
    url: baseUrl + endpoint,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
    data: data,
  });
  return result.data;
}

export async function callDelete(endpoint, id) {
  await axios.request({
    method: "DELETE",
    url: baseUrl + endpoint + "/" + id,
    headers: {
      Token: sessionStorage.getItem("jwtToken"),
    },
  });
}
