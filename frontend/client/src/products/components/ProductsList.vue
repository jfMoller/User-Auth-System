<template>
  <div class="bg-gray-900 text-white max-h-max flex items-center justify-center">
    <div>
      <ul class="px-4 mb-4 rounded sm:grid sm:grid-cols-2 lg:grid-cols-3">
        <li v-if="products.length <= 0">
          <p>There are no products available.</p>
        </li>
        <ProductListItem :products="products" :refreshProducts="refreshProducts" />
      </ul>
    </div>
  </div>
</template>

<script>
import ProductListItem from "./ProductListItem.vue";

export default {
  props: {
    products: {
      type: Array,
      required: true
    },
    refreshProducts: {
      type: Function,
      required: true
    }
  },

  components: { ProductListItem }
};
</script>