<template>
  <div class="bg-gray-900 text-white min-h-screen flex flex-col items-center justify-center p-5">
    <h1 class="text-4xl font-extrabold mb-6">Welcome to the Product Page</h1>
    <p class="text-lg mb-2">Explore our collection of high-quality products</p>
    <ProductsList />
    <button
      class="bg-blue-600 hover:bg-blue-700 text-white py-3 px-6 rounded-md transition duration-300"
      @click="handleDisconnect"
    >
      Log Out
    </button>
  </div>
</template>

<script setup>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import ProductsList from './ProductList.vue';

const store = useStore();
const router = useRouter();

async function handleDisconnect() {
  sessionStorage.removeItem("token");
  await store.dispatch('revokeAuthentication');
  router.push('/');
}
</script>

<script>
export default {
  name: 'ProductPage',
};
</script>