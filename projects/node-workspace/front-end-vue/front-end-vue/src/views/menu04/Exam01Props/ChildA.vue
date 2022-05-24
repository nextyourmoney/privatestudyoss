<template>
    <div class="card">
        <div class="card-header">ChildA</div>
        <div class="card-body">
            <div>
              <p>prop1: {{ $attrs.prop1 }}</p>
              <p>prop2: {{ $attrs.prop2 }}</p>
              <p>productNo: {{ $attrs.productNo }}</p>
              <p>productKind: {{ $attrs["product-Kind"] }}</p>
              <p>productPrice: {{ $attrs.productPrice }}</p>
            </div>
            <hr/>
            <div>
                <p>prop1: {{ prop1 }}</p>
                <p>prop2: {{ prop2 }}</p>
                <p>productNo: {{ productNo }}</p>
                <p>productKind: {{product-Kind }}</p>
                <p>productPrice: {{ productPrice }}</p>
            </div>
        </div>
    </div>
</template>

<script setup>
  // import { useAttrs } from "vue";
  // const attrs = useAttrs();
  // console.log(attrs);
import {defineProps} from "vue";
const props = defineProps(["prop1", "prop2", "productNo", "productkind", "productPrice"]);
console.log("prop1: " + props);

</script>

<style scoped></style>
