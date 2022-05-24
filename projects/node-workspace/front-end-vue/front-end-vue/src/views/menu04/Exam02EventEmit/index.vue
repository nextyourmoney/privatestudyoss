<template>
    <div class="card">
        <div class="card-header">
            Event02EventEmit
        </div>
        <div class="card-body">
            <!-- v-on대신 @을 사용가능하고 자식에서 선언한 이벤트명 child-event-1가 시작되면 handleChildEvent1 메소드를 실행한다.   -->
            <child v-on:child-event-1="handleChildEvent1"
                @child-event-2="handleChildEvent2"
                :counter="counter"
                @increment-event = "counter++"
                @decrement-event = "handleDecrementEvent"/>
            
        </div>
    </div>
</template>

<script setup>
    import Child from "./Child.vue"
    import { ref } from "vue";

    const counter = ref(0);

    function handleChildEvent1(data1){
        console.log("data1:", data1);
    }

    //자식에서 emit(["이벤트명", 데이터])로 전달 된 값들을 사용한다. 
    function handleChildEvent2(data1, data2){
        console.log("data1: ", data1);
        console.log("data2: ", data2);

    }

    function handleDecrementEvent(){
        counter.value--;
    }

</script>

<style scoped></style>
