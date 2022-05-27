<template>
    <div class="card">
        <div class = "card-header">
            Exam01AsyncControl
        </div>
        <div class="card-body">
            <div>
                <button @click = "handleBtn1" class = "btn btn-info btn-sm mr-2"> 비동기 작업1 </button>
                <button @click = "handleBtn2" class = "btn btn-info btn-sm mr-2"> 비동기 작업2 </button>
            </div>
            <div v-if = "!loading" class = "mt-3">
                <div> result: {{result}}</div>
            </div >

            <div>
                <div v-if = "loading" class="spinner-border mt-2" role="status"> 
                    <span class="sr-only">Loading...</span>
                </div>
            </div>

        </div>
    </div>
</template>

<script setup>
    import {ref} from "vue";

    const result = ref("");
    const loading = ref(false);

    //방법1
    function handleBtn1(){
        loading.value = true;
        work()
        .then((data) =>{
            result.value = data;
        })
        .catch((error)=>{
            console.log(error);

        })
        .finally(() =>{
            loading.value = false;
        });
    }

    //방법2
    async function handleBtn2(){
        try{
            loading.value = true;
            const data =  await work();
            result.value = data;
        } catch(error){
            console.log("error");
        } finally{
            loading.value = false;
        }
    }

    function work(){
        const promise = new Promise((resolve, reject) =>{
            setTimeout(() => {
                    resolve("value");
                },3000);
            })
            return promise;
    }
</script>

<style scoped>

</style>