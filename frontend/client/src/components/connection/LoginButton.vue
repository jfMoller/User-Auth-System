<template>
  <div>
    <button class="bg-blue-600 hover:bg-blue-700 text-white p-2 w-full rounded-md transition duration-300"
      @click="handleLogin">
      <p v-if="!isLoading">Login</p>
      <LoadingIcon v-if="isLoading" />
    </button>

    <div v-if="loginErrorMessage" class="text-red-500 mt-2">
      {{ loginErrorMessage }}
    </div>
  </div>
</template>
    
<script>
import { userAPI } from "../../network/userAPI";
import LoadingIcon from "../LoadingIcon.vue";
export default {
  props: {
    email: String,
    password: String
  },
  computed: {
    isLoading() {
      return this.$store.getters.isLoading;
    },
    loginErrorMessage() {
      return this.$store.getters.loginMessage;
    },
  },
  data() {
    return {
      response: null
    };
  },
  methods: {
    async handleLogin() {
      this.response = await userAPI.submitLogin(this.email, this.password);
      if (this.response) {
        this.$router.push('/options');
      }
    }
  },
  components: { LoadingIcon }
};
</script>