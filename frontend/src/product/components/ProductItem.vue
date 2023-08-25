<template>
    <li class="bg-gray-800 min-w-max hover:bg-gray-700 border-gray-900 m-2 px-2 py-1 rounded transition duration-300"
        v-for="product in  products " :key="product.id">
        <div class="flex flex-row items-center justify-between "
            :class="{ 'py-2': product.isEditing, 'P-0': !product.isEditing }">


            <p v-if="!product.isEditing" class="text-l font-bold m-2">{{ product.id + ". " + product.name }}</p>

            <div class="flex flex-row items-center">
                <p v-if="product.isEditing" class="text-l font-bold">{{ product.id }}</p>
                <input v-if="product.isEditing" v-model="product.name" class="px-2 py-1 rounded mx-2 bg-gray-500" />
            </div>

            <div class="flex space-x-2">
                <MenuButtons :product="product" :products="products" :refreshProducts="refreshProducts"
                    :handleUpdateProduct="handleUpdateProduct" />
            </div>

        </div>
    </li>
</template>
<script>
import MenuButtons from './MenuButtons.vue';
export default {
    async created() {
        await this.refreshProducts();
    },
    props: {
        products: {
            type: Array,
            required: true
        },
        refreshProducts: {
            type: Function,
            required: true
        },
        handleUpdateProduct: {
            type: Function,
            required: true
        }
    },
    components: { MenuButtons }
}
</script>