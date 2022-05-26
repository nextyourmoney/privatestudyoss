<template>
    <div class="card">
        <div class = "card-header">
            Exam04ProvideInject
        </div>
        <div class="card-body">
            <ChildA/>
            <ChildB/>
        </div>
    </div>

</template>

<script setup>
    import { ref, reactive, provide } from "vue";
    import ChildA from "./ChildA.vue";
    import ChildB from "./ChildB"
    
    // 조상이 모든 자손 컴포넌트에게 데이터를 제공, 및 자식은 이용하고자하는 데이터를 주입한다. 
    const data1 = ref("parent-value1");
    const data2 = ref({name1: "parent-value2", name2: "parent-value3"});
    const data3 = reactive({name3: "parent-vlaue3", name4: "parent-value4"});

    // 객체 이름과 데이터 이름이 동일 할 떄는 생략가능하다. 본래 아래 코드의 값은 data1:data1, data2:data2의 형태이다.
    provide("message", {data1, data2, data3})
</script>

<style scoped>

</style>