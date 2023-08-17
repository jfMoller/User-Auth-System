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
        sessionStorage.setItem("jwtToken", response.token);
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
  <div class="bg-gray-100 h-screen w-screen flex items-center justify-center">
    <div class="min-w-max border border-gray-300 rounded-md flex flex-col text-center p-4">
      <h2 class="font-bold min-h-">Login Page</h2>
      <div class="p-4 flex flex-col">
        <div class="flex flex-col py-4">
          <label class="text-left" for="email">Email:</label>
          <input type="text border border-gray-300" id="email" v-model="email" />
        </div>
        <div class="flex flex-col py-4">
          <label class="text-left" for="password">Password:</label>
          <input type="password" id="password" v-model="password" />
        </div>
      </div>
      <button class="my-4 login-button" @click="login">Login</button>
    </div>
  </div>
</template>

<style scoped>
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
