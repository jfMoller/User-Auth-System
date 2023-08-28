<template>
    <div>
        <button class="cursor-pointer bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-md transition duration-300
              disabled:cursor-not-allowed disabled:bg-gray-600 disabled:text-gray-400 w-full" @click="registerAccount"
            :disabled="!hasAllRegisterCredentials">Register</button>

        <div v-if="response && response.ERROR" class="text-red-500 mt-2">
            {{ response.message }}
        </div>
    </div>
</template>
  
<script>
import { mapGetters } from 'vuex';
import { userAPI } from '../../network/userAPI';

export default {
    props: {
        name: {
            type: String,
            required: true,
        },
        email: {
            type: String,
            required: true,
        },
        password: {
            type: String,
            required: true,
        }
    },
    data() {
        return {
            response: null
        };
    },
    computed: {
        ...mapGetters(["hasAllRegisterCredentials"]),
    },
    methods: {
        async registerAccount() {
            this.response = await userAPI.registerAccount(this.name, this.email, this.password);
            if (this.response.SUCCESS) {
                this.$router.push('/login');
            }
        },
    },
};
</script>