<template>
    <InputContainer>

        <h2 class="text-white text-xl font-bold mb-4">Register Account</h2>

        <div class="flex flex-col space-y-3">
            <InputField label="Name:" type="text" @child-event="handleNameEvent" :required="true" />

            <InputField label="Email:" type="email" @child-event="handleEmailEvent" :required="true" />

            <InputField label="Password:" type="password" @child-event="handlePasswordEvent" :required="true" />

            <RouterLinkButton route="/login" text="Login" />

            <RegisterButton :name="name" :email="email" :password="password" />
        </div>

    </InputContainer>
</template>
  
  
<script>
import { mapActions } from 'vuex';
import InputField from '../components/form/InputField.vue';
import RouterLinkButton from '../components/RouterLinkButton.vue';
import RegisterButton from './components/RegisterButton.vue';
import InputContainer from '../components/InputContainer.vue';

export default {
    data() {
        return {
            name: "",
            email: "",
            password: "",
        };
    },

    watch: {
        name() {
            this.checkCredentials();
        },
        email() {
            this.checkCredentials();
        },
        password() {
            this.checkCredentials();
        },
    },

    methods: {
        ...mapActions(["setHasAllRegisterCredentials"]),

        handleNameEvent(value) {
            this.name = value;
        },

        handleEmailEvent(value) {
            this.email = value;
        },

        handlePasswordEvent(value) {
            this.password = value;
        },

        checkCredentials() {
            const isValidCredentials =
                this.name.trim() !== "" &&
                this.email.trim() !== "" &&
                /^.*@.*\..+[^\.]$/.test(this.email) &&
                this.password.trim() !== "";
            this.setHasAllRegisterCredentials(isValidCredentials);
        },

    },

    components: {
        InputField,
        RouterLinkButton,
        RegisterButton,
        InputContainer
    },
};
</script>


  