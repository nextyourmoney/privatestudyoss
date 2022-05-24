<template>
    <div class="card">
        <div class = "card-header">
            Exam01RootState
        </div>
        <div class="card-body">
            <div>
                <h6>[Root State 읽기]</h6>
                <!-- store/index.js에 정의된 store객체이다.  -->
                <p>userId 단방향 바인딩: {{$store.state.userId}}</p>
            </div>
        </div>
    </div>

</template>

<script setup>
import { useStore } from "vuex";
const store = useStore();

</script>

<style scoped>

</style>