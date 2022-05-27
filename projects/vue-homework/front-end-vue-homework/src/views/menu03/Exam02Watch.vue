<template>
    <div class="card">
        <div class="card-header">Exam02Watch</div>
        <div class="card-body">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">UserId</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" v-model="userId" />
                </div>
            </div>
            <hr />
            <form>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" v-model="product.name" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Company</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" v-model="product.company" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Price</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" v-model.number="product.price" />
                    </div>
                </div>
            </form>
            <hr />
            <button @click="handleButton" class="btn btn-info btn-sm">product 객체 변경</button>
        </div>
    </div>
</template>

<script setup>
import { ref, watch } from "vue";

//반응형 속성 선언
const userId = ref(" ");
const product = ref({
    name: "",
    company: "",
    price: 0,
});

//ㅗㅅㄱ성 감시 설정
watch(userId, (newUserId, oldUserId) => {
    console.group("userId 변경 감시");
    console.log("newUserId:", newUserId);
    console.log("oldUserId:", oldUserId);
    console.groupEnd();
});

//객체 타입의 속성 감시 설정
watch(
    product,
    (newProduct, oldProduct) => {
        console.group("userId 변경 감시");
        console.log("newproduct:", newProduct);
        console.log("oldproduct:", oldProduct);
        console.groupEnd();
    },
    { deep: true },
);

//객체 타입의 반응형 속성 일부 감시 설정
watch(
    () => {
        return product.value.name;
    },
    (newName, oldName) => {
        console.group("product 객체의 name 속성 변경 감시");
        console.log("newproduct:", newName);
        console.log("oldproduct:", oldName);
        console.groupEnd();
    },
);

//멀티 반응형 속성 감시 설정
watch([userId, product], ([newUserId, newProduct], [oldUserId, olsdProduct]) => {
    console.group("멀티 반응형 속성 감시");
    console.log("new: ", [newUserId, newProduct]);
    console.log("old: ", [oldUserId, olsdProduct]);
    console.groupEnd();
}, {deep:true});
function handleButton() {
    product.value = {
        name: "",
        company: "",
        price: 0,
    };
}
</script>

<style scoped></style>
