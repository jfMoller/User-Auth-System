<template>
    <ConditionalButton :isVisibleIf="!product.isEditing" :handle-click="() => startEditing(product)" text="Edit"
        customClass="bg-blue-600 hover:bg-blue-700" />

    <ConditionalButton :isVisibleIf="!product.isEditing" :handle-click="() => handleDeleteProduct(product.id)" text="Delete"
        customClass="bg-red-600 hover:bg-red-700" />

    <ConditionalButton :isVisibleIf="product.isEditing" :handle-click="() => handleUpdateProduct(product)" text="Save"
        customClass="bg-green-600 hover:bg-green-700" />

    <ConditionalButton :isVisibleIf="product.isEditing" :handle-click="() => stopEditing(product)" text="Cancel"
        customClass="bg-gray-600 hover:bg-gray-700" />
</template>
<script>
import ConditionalButton from '../../components/ConditionalButton.vue';
import { userAPI } from '../../network/userAPI';
export default {
    props: {
        products: {
            type: Array,
            required: true
        },
        product: {
            type: Object,
            required: true,
        },
        refreshProducts: {
            type: Function,
            required: true
        }
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

        async handleUpdateProduct(product) {
            try {
                await userAPI.updateProduct(product);
                this.refreshProducts();
            }
            catch (error) {
                console.error("Error updating product:", error);
            }
        },

        async handleDeleteProduct(productId) {
            try {
                await userAPI.deleteProduct(productId);
                this.refreshProducts();
            }
            catch (error) {
                console.error("Error deleting product:", error);
            }
        },
    },
    components: { ConditionalButton }
}
</script>