<template>
  <div class="bg-gray-900 h-screen w-screen flex items-center justify-center">
    <div class="w-80 border border-gray-700 rounded-md flex flex-col text-center p-4">
      <h2 class="text-white text-xl font-bold mb-4">Login</h2>
      <div class="flex flex-col space-y-3">
        <label class="text-left text-white" for="email">Email:</label>
        <input type="text" class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded" id="email"
          v-model="email" />

        <label class="text-left text-white" for="password">Password:</label>
        <input type="password" class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded" id="password"
          v-model="password" />

        <RouterLinkButton route="/register" text="Register a new account" />

        <LoginButton :email="email" :password="password" />
      </div>
    </div>
  </div>
</template>


<script>
import LoginButton from './components/LoginButton.vue';
import RouterLinkButton from '../components/RouterLinkButton.vue';

export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },

  components: {
    LoginButton,
    RouterLinkButton,
  }
};
</script>
