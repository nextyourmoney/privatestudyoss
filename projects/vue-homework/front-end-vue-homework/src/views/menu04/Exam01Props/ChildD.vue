<template>
    <div class="card">
        <div class="card-header">ChildD</div>
        <div class="card-body">
            <p>propA: {{propA}}</p>
            <p>propB: {{propB}}</p>
            <p>propC: {{propC}}</p>
            <p>propD: {{propD}}</p>
            <p>propE: {{propE}}</p>
            <p>propF: {{propF.message}}</p>

            <p>
                propG:
                <ul>
                    <li v-for="(item, index) in propG" :key="index">
                        {{item}}
                    </li>
                </ul>
            </p>
            <p>propG: {{propG}}</p>
        </div>
    </div>
</template>

<script setup>
import { defineProps } from "vue";
defineProps({

    propA: String,
    propB: Number,
    propC: [String, Number],
    propD: {
        type: String,
        required: true
    },
    propE: {
        type: Number,
        default: 5
    },
    propF:{
        type: Object,
        default(){
            return {mesage:'Hello'};
        }
    },
    propG: {
        type: Array,
        default(){
            return ['black', 'white'];
        }
    },
    propH: {
        type: Function,
        default(){
            return "default value";
        }
        },
    propI: {
        type: Number,
        validate(value){
            return value > 0;
        }
}
});


</script>

<style scoped></style>
