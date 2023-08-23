<template>
    <button v-if="isVisibleIf" :class="['py-1', 'px-3', 'rounded', getBgColorClass(), customClass]" @click="handleClick">
        {{ text }}
    </button>
</template>

<script>
export default {
    props: {
        isVisibleIf: {
            type: Boolean,
            required: true
        },
        handleClick: {
            type: Function,
            required: true
        },
        text: {
            type: String,
            required: true
        },
        color: {
            type: String,
            default: "gray"
        },
        customClass: {
            type: String,
            default: ""
        }
    },
    methods: {
        getBgColorClass() {
            return `bg-${this.color}-700 hover:bg-${this.color}-800`;
        }
    }
}
</script>