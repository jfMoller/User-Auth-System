<template>
  <div>
    <button @click="fetchUsers">Fetch Users</button>
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.id }} - {{ user.name }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      users: []
    };
  },
  methods: {
    fetchUsers() {
      // Make an HTTP GET request to your Java backend
      axios.get('http://localhost:8080/api/users')
          .then(response => {
            this.users = response.data; // Assuming your backend returns an array of users
            console.log(this.users)
          })
          .catch(error => {
            console.error('Error fetching users:', error);
          });
    }
  }
};
</script>