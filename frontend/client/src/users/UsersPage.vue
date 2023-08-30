<template>
  <div class="bg-gray-900 text-white min-h-screen flex flex-col items-center justify-start p-5">
    <h1 class="text-4xl font-extrabold mb-6">Welcome to the User Page</h1>
    <p class="text-lg mb-2">Explore the current registered users</p>
    <UsersList />
    <LogoutButton />
  </div>
</template>

<script>
import LogoutButton from '../components/connection/LogoutButton.vue';
import UsersList from './components/UsersList.vue';
export default {
  components: { UsersList, LogoutButton }
};
</script>