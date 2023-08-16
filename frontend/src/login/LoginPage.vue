<script>
import { API } from '../network/API';
import store from "../store";

export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },

  methods: {
    async login() {
      console.log("Logging in...");
      console.log("Email:", this.email);
      console.log("Password:", this.password);

      const response = await API.submitLogin(this.email, this.password);

      if (response.success) {
        store.commit("setAuthenticated", true);
        sessionStorage.setItem("token", response.token);
        await this.$store.dispatch('authenticate');
        this.$router.push('/home');
      }
      else if (response.error) {
        console.log(response.message);
      }
    },
  },
};
</script>

<template>
  <div class="login-container">
    <h2>Login Page</h2>
    <div class="input-container">
      <label for="email">Email:</label>
      <input type="text" id="email" v-model="email" />
    </div>
    <div class="input-container">
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" />
    </div>
    <button class="login-button" @click="login">Login</button>
  </div>
</template>

<style scoped>
/* Add your custom styles here */
.login-container {
  width: max-content;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.input-container {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input {
 
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

.login-button {
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.login-button:hover {
  background-color: #0056b3;
}
</style>
