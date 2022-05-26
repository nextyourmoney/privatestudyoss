<template>
    <div class="card">
        <div class="card-header">

            Exam08Slot

        </div>
        <div class="card-body">
            <button class = "btn btn-info btn-sm mr-2" @click="dialogA.value = true">show DialogA</button>
        </div>
        <DialogA v-if="dialogA" v-on:confirm="handleConfirm" @close="handleClose"></DialogA>
        <DialogA v-if="dialogA" v-on:confirm="handleConfirm" @close="handleClose"></DialogA> 
    </div>
</template>

<script setup>
    import DialogA from "./DialogA";
    import { ref } from "vue";
    import DialogB from "./DialogB";

    //반응형 속성 선언
    const dialogA = ref(false);
    const dialogB = ref(false);

    //메소드 선언
    function handleConfirm(){
        console.log("hand confirm")
        dialogA.value = false;

    }

    function handleClose(){
        console.log("handle @ anme")
        dialogA.value = false;

    }

 function handlelogin(){
        console.log("handle @ anme")
        dialogA.value = false;

    }



</script>

<style scoped>
    /* .modal-container{
        
    } */
</style>
