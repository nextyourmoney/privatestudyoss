<template>
  <div class="card">
    <div class = "card-header">
        Exam03View
    </div>
    <div class="card-body">
        <SubAcomponnet class="mt-3"/>
        <SubBcomponnet class="mt-3"/>
        <SubCcomponnet class="mt-3"/>
        <subDcomponent class="mt-3"/>
    </div>
</div>

</template>

<script setup>
import SubAcomponnet from "@/components/menu01/SubAcomponent.vue";
import SubBcomponnet from "@/components/menu01/SubBcomponent.vue";
import SubCcomponnet from "@/components/menu01/SubCcomponent.vue";
import subDcomponent from "@/views/menu01/Exam03View/SubDcomponent.vue";
</script>

<style scoped>

</style>