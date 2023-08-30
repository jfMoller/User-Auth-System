<template>
    <div class="loading-icon">
        <div class="spinner"></div>
    </div>
</template>
  
<script>
export default {
};
</script>
  
<style scoped>
.loading-icon {
    display: flex;
    justify-content: center;
    align-items: center;
    height: h-full;
}

.spinner {
    width: 25px;
    height: 25px;
    border: 4px solid rgba(0, 0, 0, 0.222);
    border-top: 4px solid #ffffff;
    border-radius: 50%;
    animation: spin 1s linear infinite;
}

@keyframes spin {
    0% {
        transform: rotate(0deg);
    }

    100% {
        transform: rotate(360deg);
    }
}
</style>