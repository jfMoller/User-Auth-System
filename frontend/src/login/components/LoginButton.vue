<template>
    <button class="bg-blue-600 hover:bg-blue-700 text-white p-2 rounded-md transition duration-300"
        @click="handleLogin">Login</button>
</template>
  
<script>
import { API } from "../../network/API";
import store from "../../store";
export default {
    props: {
        email: String,
        password: String
    },
    methods: {
        async handleLogin() {
            console.log("Logging in...");
            console.log("Email:", this.email);
            console.log("Password:", this.password);

            const response = await API.submitLogin(this.email, this.password);

            if (response.success) {
                store.commit("setAuthenticated", true);
                sessionStorage.setItem("jwtToken", response.token);
                await this.$store.dispatch('authenticate');
                this.$router.push('/product');
            }
            else if (response.error) {
                console.log(response.message);
            }
        }
    }
};
</script>