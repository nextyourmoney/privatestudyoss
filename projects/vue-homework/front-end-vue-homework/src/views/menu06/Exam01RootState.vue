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
                <p>userId 단방향 바인딩: {{store.state.userId}}</p>
                <p>userId 단방향 바인딩: {{$store.getters.getUserId}}</p>
                <p>userId 단방향 바인딩: {{getUserId()}}</p>
                <p>userId 단방향 바인딩: {{computedUserId}}</p>
                <p>userId 양방향 바인딩: <input type="text" v-model="$store.state.userId"/></p>
            </div>
            <hr/>
            <h6>[Root State 변경]</h6>
            <p>userId 변경값 입력:
                <input type = "text" v-model="userId"/>
            </p>
            <div>
                <button @click="changeuserIdByMutaion" class = "btn btn-info btn-sm mr-2">userId 변경(mutation동기 방식)</button>
                <button @click="changeUserIdByAction" class = "btn btn-info btn-sm mr-2">userId 변경(action 비동기 방식) </button>
            </div>
        </div>
    </div>

</template>

<script setup>
import { useStore } from "vuex";
import { computed, ref } from "vue";

const store = useStore();

function getUserId(){
    return store.state.userId;
}

const computedUserId = computed(()=>{
    return store.state.userId;
});

const userId = ref("");

function changeuserIdByMutaion(){
    //commit을 통해서 mutation 호출한다. 
    store.commit("setUserId", userId.value);
}

//비동기 방식 타이머
function changeUserIdByAction(){
    store.dispatch("setUserIdByAsync", {userId:userId.value, duration:3000})
}

</script>

<style scoped>

</style>