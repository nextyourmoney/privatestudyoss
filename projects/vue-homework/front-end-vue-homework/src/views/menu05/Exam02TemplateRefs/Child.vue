<template>
    <div class="card">
        <div class = "card-header">
            Child
        </div>
        <div class="card-body">
            <p>data: {{data}} </p>

        </div>
    </div>

</template>

<script setup>
    import { ref, defineExpose } from "vue";

    const data = ref(10);

    function method(){
        data.value -= 1;

    }

    defineExpose({
        data,
        method
    });
</script>

<style scoped>

</style>