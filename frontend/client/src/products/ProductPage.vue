<template>
  <div class="bg-gray-900 text-white min-h-screen flex flex-col justify-start items-center p-5">
    <h1 class="text-4xl font-extrabold mb-6">Welcome to the Product Page</h1>
    <p class="text-lg mb-6">Explore our collection of high-quality products</p>
    <CreateNewProductInput :refreshProducts="refreshProducts" />
    <ProductsList :products="products" :refreshProducts="refreshProducts"  />
    <LogoutButton />
  </div>
</template>

<script>
import LogoutButton from '../components/connection/LogoutButton.vue';
import ProductsList from './components/ProductsList.vue';
import CreateNewProductInput from './components/CreateNewProductInput.vue';
import { userAPI } from '../network/userAPI';

export default {
  async created() {
    await this.refreshProducts();
  },
  methods: {

    async refreshProducts() {
      try {
        const products = await userAPI.getAllProducts();
        this.products = products;
      }
      catch (error) {
        console.error("Error updating products:", error);
      }
    },
  },

  data() {
    return {
      products: [],
    };
  },

  components: { ProductsList, LogoutButton, CreateNewProductInput }
};
</script>