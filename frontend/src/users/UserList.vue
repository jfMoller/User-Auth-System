<template>
  <div class="bg-gray-900 text-white max-h-max flex items-center justify-center">
    <div>
      <ul class="px-4 mb-4 rounded sm:grid sm:grid-cols-2 lg:grid-cols-3">
        <li v-if="users.length <= 0">
          <p>There are no users available.</p>
        </li>
        <UserItem :users="users" :refreshUsers="refreshUsers" />
      </ul>
    </div>
  </div>
</template>

<script>
import { adminAPI } from "../network/adminAPI";
import MenuButtons from "./components/MenuButtons.vue";
import UserItem from "./components/UserItem.vue";

export default {
  async created() {
    await this.refreshUsers();
  },
  methods: {

    async refreshUsers() {
      try {
        const users = await adminAPI.getAllUsers();
        this.users = users;
      }
      catch (error) {
        console.error("Error updating ursers:", error);
      }
    },
  },
  data() {
    return {
      users: [],
    };
  },
  components: { MenuButtons, UserItem }
};
</script>