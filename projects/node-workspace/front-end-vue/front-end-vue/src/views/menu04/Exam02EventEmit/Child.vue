<template>
    <div class="card">
        <div class = "card-header">
            Child
        </div>
        <div class="card-body">
            <div>
                <h6>[자식에서 부모로]</h6>
                <!-- child-event-1 이벤트를 발생시키고 data1을 전송한다.  -->
                <button @click="$emit('child-event-1', data1)" class ="btn btn-sm btn-info mr-2">child-event-1 emit</button>
                <button @click="handleChildEmit2" class ="btn btn-sm btn-info mr-2">child-event-2 emit</button>
            </div>
            <hr/>
            <div>
                <h6>[자식에서 부모로 그리고 다시 자식으로(Event - > pros)]</h6>
                <!-- child-event-1 이벤트를 발생시키고 data1을 전송한다.  -->
                <button @click="handleIncrementEvent" class ="btn btn-sm btn-info mr-2">handleIncrementEvent emit</button>
                <button @click="handleDecrementEvent" class ="btn btn-sm btn-info mr-2">handleDecrementEvent emit</button>
                <p>Counter: {{counter}}</p>
            </div>

        </div>
    </div>

</template>

<script setup>
    //반응형 속성 선언
    //이벤트 사용을 위해 defineEmits선언
    import { ref, defineEmits, defineProps } from "vue";

    //사용할 이벤트 선언 및 정의
    const props = defineProps(["counter"]);
    const emit = defineEmits(["child-event-2"]);

    const data1 = ref("value1");
    const data2 = ref(100);

    //부모로 전달 메소드 실행 emit은 defineEmits로 사전에 정의 되었고 ["이벤트명"]의 형태이다. 
    function handleChildEmit2(){
        emit("child-event-2", data1.value, data2.value);

    }

    function handleIncrementEvent(){
        emit("increment-evnet");
    }

    function handleDecrementEvent(){
        emit("decrement-event");
    }
    
</script>

<style scoped>

</style>

