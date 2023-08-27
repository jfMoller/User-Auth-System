<template>
  <InputContainer>

    <h2 class="text-white text-xl font-bold mb-4">Login</h2>

    <div class="flex flex-col space-y-3">
      <InputField label="Email:" type="email" @child-event="handleEmailEvent" />

      <InputField label="Password:" type="password" @child-event="handlePasswordEvent" />

      <RouterLinkButton route="/register" text="Register a new account" />

      <LoginButton :email="email" :password="password" />
    </div>
    
  </InputContainer>
</template>

<script>
import LoginButton from '../components/connection/LoginButton.vue';
import RouterLinkButton from '../components/RouterLinkButton.vue';
import InputField from '../components/form/InputField.vue';
import InputContainer from '../components/InputContainer.vue';

export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },

  methods: {
    handleEmailEvent(email) {
      this.email = email;
    },

    handlePasswordEvent(password) {
      this.password = password;
    },
  },

  components: {
    LoginButton,
    RouterLinkButton,
    InputField,
    InputContainer
  },
};
</script>