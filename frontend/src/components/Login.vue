<script>
import { loginAPI } from '../network/loginAPI';

export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },

  methods: {
    login() {
      // Add your login logic here
      console.log("Logging in...");
      console.log("Username:", this.username);
      console.log("Password:", this.password);

      // Assuming you want to fetch user data after login
      loginAPI.login({ username: this.username, password: this.password })
      .then((loginAttempt) => console.log("Staus: " + loginAttempt))
    },
  },
};
</script>

<template>
  <div class="login-container">
    <h2>Login Page</h2>
    <div class="input-container">
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username" />
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
  width: 300px;
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
  width: 100%;
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
