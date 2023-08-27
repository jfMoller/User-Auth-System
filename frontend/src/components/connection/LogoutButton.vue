<template>
    <button class="bg-blue-600 hover:bg-blue-700 text-white py-3 px-6 rounded-md transition duration-300"
        @click="handleLogout">
        Log Out
    </button>
</template>

<script>
export default {

    methods: {
        async handleLogout() {
            sessionStorage.removeItem("token");
            await this.$store.dispatch('revokeAuthentication');
            this.$router.push('/');
        }
    }
}
</script>
