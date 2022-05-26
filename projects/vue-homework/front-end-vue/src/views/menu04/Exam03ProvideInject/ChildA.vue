<template>
    <div class="card">
        <div class = "card-header">
            ChildA
        </div>
        <div class="card-body">
            <div>
                <p> data1: {{message.data1}} </p>
                <p> data2.value.name1:  {{message.data2.value.name1}}</p>
                <p> data2.value.name2:  {{message.data2.value.name2}}</p>
                <p> data3.name3:  {{message.data3.name3}}</p>
                <p> data3.name4:  {{message.data3.name4}}</p>

            </div>
            <button @click="chagneData" class = "mt-2 btn btn-info btn-sm"> 데이터 변경 </button>

        </div>
    </div>

</template>

<script setup>
    import { inject } from "vue";

    //조상에서 선언 된 message라는 객체이다. 
    const message = inject("message");

    function chagneData(){
        message.data1.value += "1";
        message.data2.value.name1 += "2";
        message.data2.value.name2 += "3";
        message.data3.name3 += "4";
        message.data3.name4 += "5";
    }

</script>

<style scoped>

</style>