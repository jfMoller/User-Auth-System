<template>
  <div class="flex flex-col">
    <label class="text-left text-white">{{ label }}</label>
    <input :type="type"
      :class="['border', 'border-gray-700', 'bg-gray-800', 'text-white', 'px-2', 'py-1', 'rounded', customClass]"
      v-model="userInput" @input="sendMessageToParent" />
  </div>
</template>

<script>
export default {
  props: {
    initialValue: {
      type: String,
      default: "",
    },
    type: {
      type: String,
      default: "text",
    },
    label: String,
    customClass: String,
    required: {
      type: Boolean,
      default: false,
    }
  },
  data() {
    return {
      userInput: this.initialValue,
    };
  },
  methods: {
    sendMessageToParent() {
      this.$emit('child-event', this.userInput);
    },
  },
};
</script>