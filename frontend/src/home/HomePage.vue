<template>
    <InputContainer>

        <div class="flex flex-col space-y-3">
            <ConditionalButton :isVisibleIf="true" :handle-click="() => goToProductsPage()" text="Products"
                customClass="bg-green-600 hover:bg-green-700" />

            <ConditionalButton :isVisibleIf="userRole === 'ADMIN'" :handle-click="() => goToUsersPage()" text="Users"
                customClass="bg-orange-600 hover:bg-orange-700" />

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