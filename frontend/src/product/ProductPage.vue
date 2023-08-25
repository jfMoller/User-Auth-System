<template>
  <div class="bg-gray-900 text-white min-h-screen flex flex-col items-center justify-center p-5">
    <h1 class="text-4xl font-extrabold mb-6">Welcome to the Product Page</h1>
    <p class="text-lg mb-2">Explore our collection of high-quality products</p>
    <ProductsList />
    <LogoutButton />
  </div>
</template>

<script>
import LogoutButton from '../components/connection/LogoutButton.vue';
import ProductsList from './ProductList.vue';
export default {
  components: { ProductsList, LogoutButton }
};
</script>