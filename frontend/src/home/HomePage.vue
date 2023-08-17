<template>
  <div class="bg-gray-900 text-white min-h-screen flex flex-col items-center justify-center">
    <h1 class="text-3xl font-bold mb-4">Welcome to the Home Page</h1>
    <p class="text-lg mb-6">This is the main page of your app.</p>
    <ProductsList />
    <button class="bg-blue-600 hover:bg-blue-700 text-white py-2 px-4 rounded-md transition duration-300"
      @click="handleDisconnect">Disconnect</button>
  </div>
</template>

<script setup>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import ProductsList from '../products/ProductsList.vue';

const store = useStore();
const router = useRouter();

async function handleDisconnect() {
  sessionStorage.removeItem("token");
  await store.dispatch('disconnect');
  router.push('/');
}
</script>

<script>
export default {
  name: 'HomePage',
};
</script>