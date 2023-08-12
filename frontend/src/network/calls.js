// calls.js
import axios from "axios";

const baseUrl = "http://localhost:8080/api";

export async function callGet(endpoint) {
  return axios.get(`${baseUrl}/${endpoint}`)
    .then((response) => {
      return response.data;
    })
    .catch((error) => {
      console.error("Error fetching data:", error);
    });
}