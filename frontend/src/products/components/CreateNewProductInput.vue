<template>
    <div class="flex flex-col justify-center items-center mb-6">
        <p class="text-l font-bold">Create a new product:</p>
        <div class="bg-gray-600 min-w-max border-gray-900 mb-6 px-2 py-1 rounded transition duration-300">
            <div class="flex flex-row items-center justify-between ">
                <div class="flex flex-col items-center">
                    <div class="flex items-center justify-center">
                        <p class="text-l font-bold">Name:</p>
                        <input v-model="productName" @input="event => productName = event.target.value"
                            class="px-2 py-1 rounded mx-2 bg-gray-500" />
                    </div>
                </div>

                <div class="flex space-x-2">
                    <ConditionalButton :isVisibleIf="true" :handle-click="() => handleCreateProduct(productName)"
                        text="Create" customClass="bg-green-600 hover:bg-green-700" />
                </div>

            </div>
        </div>
    </div>
</template>
<script>
import { userAPI } from '../../network/userAPI';
import ConditionalButton from '../../components/ConditionalButton.vue';
export default {
    props: {
        refreshProducts: {
            type: Function,
            required: true
        }
    },

    methods: {
        async handleCreateProduct(productName) {
            console.log(productName)
            await userAPI.createNewProduct(productName);
            this.refreshProducts();
        }
    },
    components: { ConditionalButton },
    data() {
        return {
            productName: ''
        }
    }
}
</script>