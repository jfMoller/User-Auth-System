<template>
    <button v-if="isVisibleIf" :class="[
        'py-1', 'px-3', 'rounded', 'transition', 'duration-300',
        customClass
    ]" @click="handleClick">
        {{ text }}
    </button>
</template>

<script>
export default {
    props: {
        isVisibleIf: {
            type: Boolean,
            required: true,
            default: false
        },
        handleClick: {
            type: Function,
            required: true
        },
        text: {
            type: String,
            required: true
        },
        customClass: {
            type: String,
            default: ""
        }
    },
}
</script>