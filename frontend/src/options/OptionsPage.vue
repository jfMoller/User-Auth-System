<template>
    <InputContainer>
        <h1 class="text-4xl font-extrabold mb-6 text-white">Options</h1>

        <div class="flex flex-col space-y-3">
            <ConditionalButton :isVisibleIf="true" :handle-click="() => goToProductsPage()" text="Products"
                customClass="bg-green-600 hover:bg-green-700 text-white" />

            <ConditionalButton :isVisibleIf="userRole === 'ADMIN'" :handle-click="() => goToUsersPage()" text="Users"
                customClass="bg-indigo-700 hover:bg-indigo-800 text-white" />
            <LogoutButtonVue />
        </div>

    </InputContainer>
</template>
<script>
import InputContainer from '../components/InputContainer.vue';
import ConditionalButton from '../components/ConditionalButton.vue';
import LogoutButtonVue from '../components/connection/LogoutButton.vue';
import { mapGetters } from 'vuex';


export default {
    computed: {
        ...mapGetters(['userRole'])
    },

    methods: {
        goToProductsPage() {
            this.$router.push("/products");
        },
        goToUsersPage() {
            this.$router.push("/users");
        }
    },

    components: {
        InputContainer, ConditionalButton, LogoutButtonVue
    }
}

</script>