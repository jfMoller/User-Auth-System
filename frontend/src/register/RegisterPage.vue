<template>
    <div class="bg-gray-900 h-screen w-screen flex items-center justify-center">
        <div class="w-80 border border-gray-700 rounded-md flex flex-col text-center p-4">
            <h2 class="text-white text-xl font-bold mb-4">Register Account</h2>
            <div class="flex flex-col space-y-3">

                <label class="text-left text-white" for="email">Name:</label>
                <input type="text" required class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded"
                    id="email" v-model="name" />
                <label class="text-left text-white" for="email">Email:</label>
                <input type="email" required class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded"
                    id="email" v-model="email" />

                <label class="text-left text-white" for="password">Password:</label>
                <input type="password" required class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded"
                    id="password" v-model="password" />

                    <RouterLinkButton route="/login" text="Login" />

                <button class="cursor-pointer bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-md transition duration-300
                    disabled:cursor-not-allowed disabled:bg-gray-600 disabled:text-gray-400" @click="registerAccount"
                    :disabled="!hasAllRegisterCredentials">Register</button>

            </div>

        </div>
    </div>
</template>
  
  
<script>
import { API } from '../network/API';
import { mapGetters, mapActions } from 'vuex';
import RouterLinkButton from '../components/RouterLinkButton.vue';

export default {
    data() {
        return {
            name: "",
            email: "",
            password: "",
        };
    },

    computed: {
        ...mapGetters(["hasAllRegisterCredentials"])
    },

    watch: {
        name(newValue) {
            this.updateHasAllRegisterCredentials();
        },
        email(newValue) {
            this.updateHasAllRegisterCredentials();
        },
        password(newValue) {
            this.updateHasAllRegisterCredentials();
        },
    },

    methods: {
        ...mapActions(["setHasAllRegisterCredentials"]),

        updateHasAllRegisterCredentials() {
            const hasAllCredentials =
                this.name.trim() !== "" &&
                this.email.trim() !== "" &&
                this.password.trim() !== "";
            this.setHasAllRegisterCredentials(hasAllCredentials);
        },

        async registerAccount() {
            await API.registerAccount(this.name, this.email, this.password);
        },
    },

    components: {
        RouterLinkButton,
    }
};
</script>
  