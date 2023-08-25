<template>
    <button class="bg-blue-600 hover:bg-blue-700 text-white py-3 px-6 rounded-md transition duration-300"
        @click="handleLogout">
        Log Out
    </button>
</template>

<script setup>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

const store = useStore();
const router = useRouter();

async function handleLogout() {
    sessionStorage.removeItem("token");
    await store.dispatch('revokeAuthentication');
    router.push('/');
}
</script>

<script>
export default {
    name: 'LogoutButton'
}
</script>
