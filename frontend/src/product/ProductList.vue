<template>
  <div class="bg-gray-900 text-white max-h-max flex items-center justify-center">
    <div>
      <ul class="px-4 mb-4 rounded sm:grid sm:grid-cols-2 lg:grid-cols-3">
        <li v-if="products.length <= 0">
          <p>There are no products available.</p>
        </li>

        <li class="bg-gray-800 cursor-pointer min-w-max hover:bg-gray-700 border border-gray-900 m-2 px-2 py-1 rounded"
          v-for="product in  products " :key="product.id">
          <div class="flex flex-row items-center justify-between "
            :class="{ 'py-2': product.isEditing, 'P-0': !product.isEditing }">


            <p v-if="!product.isEditing" class="text-l font-bold m-2">{{ product.id + ". " + product.name }}</p>

            <div class="flex flex-row items-center">
              <p v-if="product.isEditing" class="text-l font-bold">{{ product.id }}</p>
              <input v-if="product.isEditing" v-model="product.name" class="px-2 py-1 rounded mx-2 bg-gray-500" />
            </div>

            <div class="flex space-x-2">

              <ConditionalButton :is-visible-if="!product.isEditing" :handle-click="() => startEditing(product)"
                text="Edit" color="green" />

              <ConditionalButton :is-visible-if="!product.isEditing" :handle-click="() => handleDeleteProduct(product.id)"
                text="Delete" color="red" />

              <ConditionalButton :is-visible-if="!!product.isEditing && product.isEditing !== undefined"
                :handle-click="() => handleUpdateProduct(product)" text="Save" color="blue" />

              <ConditionalButton :is-visible-if="!!product.isEditing && product.isEditing !== undefined"
                :handle-click="() => stopEditing(product)" text="Cancel" color="orange" />

            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import ConditionalButton from "../components/ConditionalButton.vue";
import { API } from "../network/API";

export default {
  async created() {
    await this.updateProducts();
  },
  methods: {
    startEditing(product) {
      this.products.forEach((otherProduct) => {
        if (otherProduct.id !== product.id && otherProduct.isEditing) {
          otherProduct.isEditing = false;
        }
      });
      product.isEditing = true;
    },
    stopEditing(product) {
      product.isEditing = false;
    },
    async updateProducts() {
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
        this.updateProducts();
      }
      catch (error) {
        console.error("Error updating product:", error);
      }
    },
    async handleDeleteProduct(productId) {
      try {
        await API.deleteProduct(productId);
        this.updateProducts();
      }
      catch (error) {
        console.error("Error deleting product:", error);
      }
    },
  },
  data() {
    return {
      products: [],
    };
  },
  components: { ConditionalButton }
};
</script>