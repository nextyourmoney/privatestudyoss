<template>
    <div class="card">
        <div class = "card-header">
            ChildC
        </div>
        <div class="card-body">
            <div>
                <p> data1: {{message.data1}} </p>
                <p> data2.value.name1:  {{message.data2.value.name1}}</p>
                <p> data2.value.name2:  {{message.data2.value.name2}}</p>
                <p> data3.name3:  {{message.data3.name3}}</p>
                <p> data3.name4:  {{message.data3.name4}}</p>

            </div>

        </div>
    </div>

</template>

<script setup>
    import { inject } from "vue";

    //조상에서 선언 된 message라는 객체이다. 
    const message = inject("message");

</script>

<style scoped>

</style>