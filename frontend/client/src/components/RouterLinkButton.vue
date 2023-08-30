<template>
    <button class="text-white text-sm py-2 my-2">
        <router-link :to="route" class="hover:underline">{{ text }}</router-link>
    </button>
</template>

<script>
export default {
    props: {
        route: {
            type: String,
            required: true,
        },
        text: {
            type: String,
            required: true,
        }
    }
}

</script>