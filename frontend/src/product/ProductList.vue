<template>
  <div class="bg-gray-900 text-white max-h-max flex items-center justify-center">
    <div>
      <ul class="px-4 mb-4 rounded sm:grid sm:grid-cols-2 lg:grid-cols-3">
        <li v-if="products.length <= 0">
          <p>There are no products available.</p>
        </li>
        <ProductItem :products="products" :refreshProducts="refreshProducts" :handleUpdateProduct="handleUpdateProduct" />
      </ul>
    </div>
  </div>
</template>

<script>
import { API } from "../network/API";
import MenuButtons from "./components/MenuButtons.vue";
import ProductItem from "./components/ProductItem.vue";

export default {
  async created() {
    await this.refreshProducts();
  },
  methods: {

    async refreshProducts() {
      try {
        const products = await API.getAllProducts();
        this.products = products;
      }
      catch (error) {
        console.error("Error updating products:", error);
      }
    },
    async handleUpdateProduct(product) {
      try {
        await API.updateProduct(product);
        this.refreshProducts();
      }
      catch (error) {
        console.error("Error updating product:", error);
      }
    },
  },
  data() {
    return {
      products: [],
    };
  },
  components: { MenuButtons, ProductItem }
};
</script>