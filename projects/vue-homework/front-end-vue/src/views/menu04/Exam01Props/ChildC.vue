<template>
    <div class="card">
        <div class="card-header">ChildB</div>
        <div class="card-body">
            <p> no: {{product.no}} </p>
            <p>kind: {{product.kind}} </p>
        </div>
    </div>
</template>

<script setup>
import {defineProps } from "vue";
defineProps(["product"]);
</script>

<style scoped></style>
