<template>
    <div class="card">
        <div class = "card-header">
            MountHook
        </div>
        <div class="card-body">

        </div>
    </div>

</template>

<script setup>
    import { onBeforeMount, onMounted, onBeforeUnmount, onUnmounted  } from "vue";

    onBeforeMount(() => {
        console.log("onBeforeMount");
    });

    onMounted(() => {
        console.log("onMounted");
    });

    onBeforeUnmount(()=>{
        console.log("onBeforeUnmount");
    });

    onUnmounted(()=>{
        console.log("onUnmounted");
    });

</script>

<style scoped>

</style>