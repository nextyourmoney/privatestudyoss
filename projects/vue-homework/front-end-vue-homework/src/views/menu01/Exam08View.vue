<template>
    <div class="card">
        <div class="card-header">Exam08View</div>
        <div class="card-body">
            <div>kind:{{ route.params.kind }}</div>
            <div>color:{{ route.params.color }}</div>
            <hr/>
            <div>kind:{{ route.query.kind }}</div>
            <div>color:{{ route.query.color }}</div>
        </div>
    </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { toRaw } from "vue";
const route = useRoute();
console.log(route);

console.log(toRaw(route));

//정보 축약 출력
console.log(JSON.parse(JSON.stringify(route)));

console.log("kind: " + route.params.kind);
console.log("color: " + route.params.color);

console.log("kind: " + route.query.kind);
console.log("color: " + route.query.color);
</script>

<style scoped></style>
