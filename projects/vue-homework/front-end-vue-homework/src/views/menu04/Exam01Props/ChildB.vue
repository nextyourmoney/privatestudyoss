<template>
    <div class="card">
        <div class="card-header">ChildB</div>
        <div class="card-body">
            <p> no: {{no}} </p>
            <p>kind: {{kind}} </p>
        </div>
    </div>
</template>

<script setup>
import {defineProps } from "vue";
defineProps(["no","kind"]);
</script>

<style scoped></style>
