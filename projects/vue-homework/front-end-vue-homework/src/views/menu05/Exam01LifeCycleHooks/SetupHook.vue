<template>
    <div class="card">
        <div class = "card-header">
            SetupHook
        </div>
        <div class="card-body">
            <button @click="handleBtn" class = "btn-info btn-sm btn mr-2">버튼</button>
            <button @click="emitEvent" class = "btn-info btn-sm btn mr-2">이벤트 발생</button>
        </div>
    </div>

</template>

<script>
import { ref } from "vue";
    //이러한 방식의 비추천하는 방식이다. 대신 component방식을 추천
    export default{
        //props 선언 //아래 setup에서 선언 시 재정의가 되기 때문에 값이 없는 것으로 나온다. 
        props: ["prop1"],

        //이벤트 선언 //이벤트 이름 선언
        emits: ["component-event"],

        //setup() 훅 재정의  
        //context는 vue객체가 실행되는 환경변수이다. 
        //vue3의 방식이지만 vue2의 방식을 가진다. 
        setup(props, context){
            console.log("created 상태가 될 떄 실행");
            console.log(props);

            //반응형 속성 선언
            const count = "ref(0)"

            //이벤트 핸들러 선언
            function handleBtn(){
                console.log("handleBtn");
            }

            //이벤트 처리 선언 //이벤트 이므로 값은 부모로 올라간다. //이벤트 이름과 값 전송
            function emitEvent(){
                context.emit("component-event", "value1");
            }

            //return을 선언해야 출력 및 사용이 가능하다. 
            return {
                count, 
                handleBtn,
                emitEvent
            }
        },
    }

</script>

<style scoped>

</style>