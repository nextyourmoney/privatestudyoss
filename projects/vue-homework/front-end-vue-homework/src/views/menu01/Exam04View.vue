<template>
    <div class="card">
        <div class="card-header">Exam04View</div>
        <div class="card-body">
            <div class="card">
                <div class="card-header">화면 이동</div>
                <div class="card-body">
                    <router-link to="/menu01/exam01View" class="btn btn-info btn-sm mr-2">Exam01View</router-link>
                    <router-link :to = "'/menu01/exam01' + 'View'" class="btn btn-info btn-sm mr-2">Exam01View</router-link>
                    <router-link :to = "{path:'/menu01/exam01View'}" class="btn btn-info btn-sm mr-2">Exam01View</router-link>
                    <router-link :to = "{name:'menu01_exam01View'}" class="btn btn-info btn-sm mr-2">Exam01View</router-link>
                </div>
            </div>

            <div class="card mt-3">
                <div class="card-header">자바스크립트로 화면 이동</div>
                <div class="card-body">
                    <button v-on:click="goUrl('exam01view')" class="btn btn-info btn-sm mr-2">Exam01View</button>
                    <button @click="goUrl('exam01view')" class="btn btn-info btn-sm mr-2">Exam02View</button>

                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    //라우터 객체를 얻는 방법1
    //import router from "@/router"

    //라우터 객체를 얻는 방법2
    import {useRouter} from "vue-router";
    const router = useRouter();

    function goUrl(url){
        router.push("/menu01/" + url)
            .then(() => {})
            .catch(()=>{});
    }
</script>

<style scoped></style>
