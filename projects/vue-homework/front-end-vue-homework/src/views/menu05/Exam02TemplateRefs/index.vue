<template>
    <div class="card">
        <div class = "card-header">
            Exam02TemplateRefs
        </div>
        <div class="card-body">
            <div>
                <h6>DOM 요소 참조</h6>
                <p>data: {{data}}</p>
                <button @click="setInputValue" class = "btn btn-info btn-sm mr-2">값 변경</button>
                <input type = "text" ref = "inputTag" name="mid"/>
            </div>

            <hr/>

            <div>
                <!-- 비효율 + 비추천 방식 -->
                <h6>자식 컴포넌트 참조</h6>
                <p>child data: {{(childRef!==null)?childRef.data:""}}</p>
                <p>
                    <button @click="changeChildData" class = "btn btn-info btn-sm mr-2">자식 데이터 변경</button>
                    <button @click="callChildMethod" class = "btn btn-info btn-sm mr-2">자식 메소드 호출</button>
                </p>
                <Child ref="childRef"/>
            </div>
        </div>
    </div>

</template>

<script setup>
    import { ref, onMounted } from "vue";
    import Child from "./Child";
    
    const childRef = ref(null);
    const data = ref("summer");
    const inputTag = ref(null);

    onMounted(() =>{
        console.log(inputTag.value);
        inputTag.value.focus();

        console.log(childRef);
    })

    function setInputValue(){
        inputTag.value.value =  data.value;
    }

    function changeChildData(){
        childRef.value.data += 1;
    }

    function callChildMethod(){
        childRef.value.method();
    }
</script>

<style scoped>

</style>