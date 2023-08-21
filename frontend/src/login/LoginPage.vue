<template>
  <div class="bg-gray-900 h-screen w-screen flex items-center justify-center">
    <div class="w-80 border border-gray-700 rounded-md flex flex-col text-center p-4">

      <h2 class="text-white text-xl font-bold mb-4">Login</h2>

      <div class="flex flex-col space-y-3">
        <InputField label="Email:" type="email" @child-event="handleFieldEvent(email)" />

        <InputField label="Password:" type="password" @child-event="handleFieldEvent(password)" />

        <RouterLinkButton route="/register" text="Register a new account" />

        <LoginButton :email="email" :password="password" />
      </div>

    </div>
  </div>
</template>

<script>
import LoginButton from './components/LoginButton.vue';
import RouterLinkButton from '../components/RouterLinkButton.vue';
import InputField from '../components/form/InputField.vue';

export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },

  methods: {
    handleFieldEvent(data, value) {
      this.data = value;
    },
  },

  components: {
    LoginButton,
    RouterLinkButton,
    InputField,
  },
};
</script>