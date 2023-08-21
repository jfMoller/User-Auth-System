<template>
    <button class="cursor-pointer bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-md transition duration-300
            disabled:cursor-not-allowed disabled:bg-gray-600 disabled:text-gray-400" @click="registerAccount"
        :disabled="!hasAllRegisterCredentials">Register</button>
</template>
<script>
import { mapGetters } from 'vuex';
import { API } from '../../network/API';

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

    computed: {
        ...mapGetters(["hasAllRegisterCredentials"]),
    },
    methods: {
        
        async registerAccount() {
        const response = await API.registerAccount(this.name, this.email, this.password);
            console.log(response)
        if (response.success) {
                console.log(response)
                this.$router.push('/login');
            }
            else if (response.error) {
                console.log(response.message);
            }
        },
    },
}


</script>