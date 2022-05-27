<template>
    <div class="card">
        <div class="card-header">Exam05View</div>
        <div class="card-body">
            <button @click="goSubA()" class="btn btn-info btn-sm mr-2">SubAComponent</button>
            <button @click="goSubB()" class="btn btn-info btn-sm mr-2">SubAComponent</button>
            <hr/>
            <router-view></router-view>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();

function goSubA() {
    router.push("/menu01/exam05view/subacomponent");
}

function goSubB() {
    router.push("/menu01/exam05view/subbcomponent");
}
</script>

<style scoped></style>
