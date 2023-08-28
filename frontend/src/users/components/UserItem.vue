<template>
    <li class="bg-gray-800 min-w-max hover:bg-gray-700 border-gray-900 m-2 px-2 py-2 rounded transition duration-300"
        v-for="user in  users " :key="user.id">


        <div class="text-l font-bold m-2">
            <p>id: {{ user.id }}</p>
            <p>name: {{ user.name }}</p>
            <p>email: {{ user.email }}</p>
            <div class="flex flex-row">
                <p>user_role: </p>
                <div class="pl-1" v-if="!user.isEditing">{{ user.userRole }}</div>
                <select class="pl-1 bg-gray-900 text-white" v-if="user.isEditing" v-model="user.userRole">
                    <option value="ADMIN">ADMIN</option>
                    <option value="USER">USER</option>
                </select>
            </div>
        </div>

        <div class="flex justify-end space-x-2 p-2">
            <MenuButtons :user="user" :users="users" :refreshUsers="refreshUsers" :handleUpdateUserRole="handleUpdateUserRole" />
        </div>
    </li>
</template>
<script>
import MenuButtons from './MenuButtons.vue';
export default {
    async created() {
        await this.refreshUsers();
    },
    props: {
        users: {
            type: Array,
            required: true
        },
        refreshUsers: {
            type: Function,
            required: true
        },
        handleUpdateUserRole: {
            type: Function,
            required: true
        }
    },
    components: { MenuButtons }
}
</script>