<template>
    <div class="card">
        <div class="card-header">Exam07ComputedProperties</div>
        <div class="card-body">
            <p>ssn1: {{ name }}</p>
            <p>ssn1: {{ ssn1 }}</p>
            <p>ssn2: {{ ssn2 }}</p>
            <p>ssn: {{ ssn1 }}-{{ ssn2.charAt(0) + "******" }}</p>
            <p>ssn: {{ getSsn() }}</p>
            <p>ssn: {{ computedSsn }}</p>
            <hr />
            <button class="btn btn-info btn-sm mr-2" @click="changeName">name 속성 변경</button>
            <button class="btn btn-info btn-sm mr-2" @click="changeSsn2">변경</button>
        </div>
    </div>
</template>

<script setup>
    import { computed, ref } from "vue";
    
    //반응형 속성 선언
    const name = ref("홍킬동");
    const ssn1 = ref("880515");
    const ssn2 = ref("111111")
    const computedSsn = computed(() =>{
        console.log("computed callback 실행")
        const ssn = ssn1.value + "-" + ssn2.value.charAt(0) + "*******";
        return ssn;
    });

    //메소드 선언
    function getSsn(){
        console.log("getssn()선언")
        const ssn = ssn1.value + "-" + ssn2.value.charAt(0) + "*******";
        return ssn;
    }

    function changeName(){
        name.value += "쟝";
    }

    function changeSsn2(){
        ssn2.value += "2";
    }
</script>

