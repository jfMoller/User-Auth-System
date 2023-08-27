<template>
  <div>
    <button class="bg-blue-600 hover:bg-blue-700 text-white p-2 w-full rounded-md transition duration-300"
      @click="handleLogin">Login</button>

    <div v-if="response && response.ERROR" class="text-red-500 mt-2">
      {{ response.message }}
    </div>
  </div>
</template>
    
<script>
import { API } from "../../network/API";
export default {
  props: {
    email: String,
    password: String
  },
  data() {
    return {
      response: null
    };
  },
  methods: {
    async handleLogin() {
      this.response = await API.submitLogin(this.email, this.password);
      if (this.response.SUCCESS) {
        this.$store.commit("setAuthenticated", true);
        sessionStorage.setItem("jwtToken", this.response.token);

        await this.$store.dispatch('authenticate');
        this.$router.push('/products');
      }
    }
  }
};
</script>