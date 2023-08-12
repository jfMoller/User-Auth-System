<template>
    <div>
      <h2>Login Page</h2>
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username" />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" />
      </div>
      <button @click="login">Login</button>
    </div>
  </template>
  
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
        loginAPI.getAllUsers().then((users) => console.log("Fetched user data:", users))
      },
    },
  };
  </script>
  
  <style scoped>
  /* Add your custom styles here */
  </style>