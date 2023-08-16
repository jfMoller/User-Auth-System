<template>
  <div class="home-page">
    <h1>Welcome to the Home Page</h1>
    <p>This is the main page of your app.</p>
    <button @click="handleDisconnect">Disconnect</button>
  </div>
</template>

<script setup>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

const store = useStore();
const router = useRouter();

async function handleDisconnect() {
  await store.dispatch('disconnect');
  router.push('/');
}
</script>

<style scoped>
.home-page {
  text-align: center;
  padding: 20px;
}
</style>

<script>
export default {
  name: 'HomePage',
};
</script>