<template>
    <div class="flex flex-col">
      <label v-if="label" :for="inputId" class="text-left text-white mb-2">{{ label }}</label>
      <input :type="type" :id="inputId" :value="value" :class="inputClasses" @input="$emit('input', $event.target.value)" />
    </div>
  </template>
  
  <script>
  export default {
    props: {
      label: String,
      type: String,
      id: String,
      value: String,
      inputClass: String,
    },
    computed: {
      inputId() {
        return this.id || `${this.label.toLowerCase()}-input`;
      },
      inputClasses() {
        return "border border-gray-700 bg-gray-800 text-white px-2 py-1 rounded " + this.inputClass;
      },
    },
    methods: {
      updateValue(event) {
        this.$emit('input', event.target.value);
      },
    },
  };
  </script>