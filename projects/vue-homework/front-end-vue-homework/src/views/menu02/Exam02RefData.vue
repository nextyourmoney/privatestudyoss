<template>
    <div class="card">
        <div class="card-header">Example02RefData</div>
        <div class="card-body">
            <p>번호:{{ no }}</p>
            <p>이름:{{ name }}</p>
            <p>회사:{{ company }}</p>
            <p>가격:{{ getPrice() }}</p>
            <p>판매:{{ detail.sale ? "판매" : "품절" }}</p>
            <hr />
            <p v-html="detail.info"></p>
            <hr />
            <p>
                <img src="@/assets/products/minibag-black.png" class="mr-2" height="150" />
                <img :src="require(`@/assets/products/${image}`)" height="150" />
                <span v-if="!detail.sale"> <img src="@/assets/products/soldout.jpg" width="100" /></span>
                <span v-show="true"> <img src="@/assets/products/soldout.jpg" width="100" /></span>
            </p>
            <hr />
            <button @click="changeData" class="btn btn-info btn-sm">데이터 변경</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from "vue";

//컴포넌트 속성 선언
const no = ref(1);
const name = ref("미니백");
const company = ref("에르메스");
const price = ref(3000000);
const image = ref("minibag-black.png");
const detail = {
    info: `
        <div>
            에르메스는 으으음청 비싸고 색도 이쁜가?
        </div>
    `,
    sale: false,
};

function getPrice() {
    return price.value;
}

function changeData() {
    no.value++;
    name.value = "빨간 핸드백";
    price.value += 1000;
    image.value = "minibag-red.png";

    // detail.value.info = "<div>해당 제품의 특징이다.</div>";
    // detail.value.sale = !detail.value.sale;

    detail.value = {
        info:"<div>해당 제품의 특징이다.</div>",
        sale: !detail.value.sale,
    };
}
</script>

<style scoped></style>
