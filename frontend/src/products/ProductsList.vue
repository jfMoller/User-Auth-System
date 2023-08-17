<template>
  <div class="bg-gray-900 text-white max-h-screen flex items-center justify-center">
    <div>
      <ul class="p-4 mb-4 rounded">
        <li
          class="bg-gray-800 cursor-pointer hover:bg-gray-700 border border-gray-900 m-2 px-2 py-1 rounded"
          v-for="product in products"
          :key="product.id"
        >
          <div class="flex flex-row items-center justify-between">
            <p class="text-l font-bold m-2">{{ product.id + ". " + product.name }}</p>
            <div class="flex space-x-2">
              <button class="py-1 px-3 bg-green-700 hover:bg-green-800 rounded" @click="editProduct(product.id)">
                Edit
              </button>
              <button class="py-1 px-3 bg-red-700 hover:bg-red-800 rounded" @click="deleteProduct(product.id)">
                Delete
              </button>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { API } from "../network/API";

export default {
  async created() {
    await this.getAllProducts();
  },
  methods: {
    ...mapActions(["removeProduct"]),

    async getAllProducts() {
      try {
        const products = await API.getAllProducts();
        this.products = products;
      } catch (error) {
        console.error("Error fetching products:", error);
      }
    },
    async editProduct(productId) {
    },

    async deleteProduct(productId) {
      console.log(productId);
      try {
        await API.deleteProductByID(productId);
        this.removeProduct(productId);
      } catch (error) {
        console.error("Error deleting product:", error);
      }
    },
  },
  data() {
    return {
      products: [],
    };
  },
};
</script>