<template>
    <ConditionalButton :isVisibleIf="!user.isEditing" :handle-click="() => startEditing(user)" text="Edit"
        customClass="bg-blue-600 hover:bg-blue-700" />

    <ConditionalButton :isVisibleIf="!user.isEditing" :handle-click="() => handleDeleteUser(user.id)" text="Delete"
        customClass="bg-red-600 hover:bg-red-700" />

    <ConditionalButton :isVisibleIf="user.isEditing" :handle-click="() => handleUpdateUserRole(user)" text="Save"
        customClass="bg-green-600 hover:bg-green-700" />

    <ConditionalButton :isVisibleIf="user.isEditing" :handle-click="() => stopEditing(user)" text="Cancel"
        customClass="bg-gray-600 hover:bg-gray-700" />
</template>
<script>
import ConditionalButton from '../../components/ConditionalButton.vue';
import { adminAPI } from '../../network/adminAPI';
export default {
    props: {
        users: {
            type: Array,
            required: true
        },
        user: {
            type: Object,
            required: true,
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
    methods: {
        startEditing(user) {
            this.users.forEach((otherUser) => {
                if (otherUser.id !== user.id && otherUser.isEditing) {
                    otherUser.isEditing = false;
                }
            });
            user.isEditing = true;
        },
        stopEditing(user) {
            user.isEditing = false;
        },

        async handleDeleteUser(userId) {
            try {
                await adminAPI.deleteUser(userId);
                this.refreshUsers();
            }
            catch (error) {
                console.error("Error deleting user:", error);
            }
        },
    },
    components: { ConditionalButton }
}
</script>