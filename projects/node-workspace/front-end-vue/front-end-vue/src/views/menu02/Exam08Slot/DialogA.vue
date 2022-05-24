<template>
    <ModalDialogTemplate style ="width: 500px;">
        <template v-slot:header> 알림 </template>

        <template v-slot:body>
            <p>DialogA 내용이다</p>
        </template>

        <template v-slot:footer>
            <button class="btn btn-info btn-sm" @click="$emit('confirm')">확인</button>
            <button class="btn btn-info btn-sm" @click="$emit('close')">닫기</button>
        </template>
    </ModalDialogTemplate>
</template>

<script setup>
import ModalDialogTemplateVue from "@/components/menu02/ModalDialogTemplate.vue.vue";
</script>

<style scoped></style>
