<template>
    <div class="bg-gray-900 h-screen w-screen flex items-center justify-center">
        <div class="w-80 border border-gray-700 rounded-md flex flex-col text-center p-4">
            <h2 class="text-white text-xl font-bold mb-4">Register Account</h2>
            <div class="flex flex-col space-y-4">
                <div class="flex flex-col">
                    <label class="text-left text-white" for="email">Name:</label>
                    <input type="text" class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded" id="email"
                        v-model="name" />
                    <label class="text-left text-white" for="email">Email:</label>
                    <input type="text" class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded" id="email"
                        v-model="email" />


                    <label class="text-left text-white" for="password">Password:</label>
                    <input type="password" class="border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded"
                        id="password" v-model="password" />
                </div>
            </div>
            <button class="mt-6 bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-md transition duration-300"
                @click="registerAccount">Register</button>
        </div>
    </div>
</template>
  
  
<script>
import { API } from '../network/API';


export default {
    data() {
        return {
            name: "",
            email: "",
            password: "",
        };
    },

    methods: {
        async registerAccount() {
            await API.registerAccount(this.name, this.email, this.password);
        },
    },
};
</script>
  