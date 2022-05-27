<template>
    <div class="card">
        <div class = "card-header">
            Exam02CounterState
        </div>
        <div class="card-body">
            <p>userId 단방향 바인딩: {{$store.state.counter.count}}</p>
            <p>userId 단방향 바인딩: {{store.state.counter.count}}</p>
            <p>userId 단방향 바인딩: {{$store.getters["counter/getCount"]}}</p>
            <p>userId 단방향 바인딩: {{getCount()}}</p>
            <p>userId 단방향 바인딩: {{computedCount}}</p>
            <p>userId 양방향 바인딩: <input type="text" v-model="$store.state.counter"/></p>
        
        <hr/>
            <h6>[counter State 변경]</h6>
            <p>증가값 입력:
                <input type = "text" v-model.number="value"/>
            </p>
            <div>
                <button @click="changeCountByMutaion" class = "btn btn-info btn-sm mr-2">userId 변경(mutation동기 방식)</button>
                <button @click="changeCountByAction" class = "btn btn-info btn-sm mr-2">userId 변경(action 비동기 방식) </button>
            </div>
        </div>
    </div>

</template>

<script setup>
    import { useStore } from "vuex";
    import { computed, ref } from "vue";

    const store = useStore();

    function getCount(){
        return store.state.counter.count;
        //return store.getters["counter/getCount"];
    }

    const computedCount = computed(()=>{
        return store.state.counter.count;
        //return store.getters["counter/getCount"];
    });

    const value = ref(1);

    function changeCountByMutaion(){
        store.commit("counter/setCount", value.value);
    }

    function changeCountByAction(){
        store.dispatch("counter/setCountByAsync", {value:value.value, duration:3000})
    }

</script>

<style scoped>

</style>