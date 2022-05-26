<template>
    <div class="card">
        <div class="card-header">Exam05FormBinding</div>
        <div class="card-body">
            <form @submit.prevent="handleSubmit">
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

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Info</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" v-model="product.info"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Madein</label>
                    <div class="col-sm-10">
                        <select class="form-control" v-model="product.madein">
                            <option value="한국" selected>한국</option>
                            <option value="미국">미국</option>
                            <option value="독일">독일</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label pt-0">Colors</label>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" v-model="product.colors" value="black" />
                            <label class="form-check-label">Black</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" v-model="product.colors" value="red" />
                            <label class="form-check-label">Red</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" v-model="product.colors" value="yellow" />
                            <label class="form-check-label">Yellow</label>
                        </div>
                    </div>
                </div>

                <fieldset class="form-group row">
                    <label class="col-sm-2 col-form-label pt-0">Sex</label>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sexRadio" v-model="product.sex" value="man" />
                            <label class="form-check-label">Man</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sexRadio" v-model="product.sex" value="woman" checked />
                            <label class="form-check-label">Woman</label>
                        </div>
                    </div>
                </fieldset>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label pt-0">Sale1</label>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" v-model="product.sale1" />
                            <label class="form-check-label">판매여부</label>
                        </div>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label pt-0">Sale2</label>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" v-model="product.sale2" true-value="yes" false-value="no" />
                            <label class="form-check-label">판매여부</label>
                        </div>
                    </div>
                </div>

                <input type="submit" value="등록" class="btn btn-danger btn-sm mr-3" :disabled="!checkData" />
                <input type="button" value="재작성" class="btn btn-danger btn-sm" @click="handleReset" />
            </form>
        </div>
    </div>
</template>

<script setup>
import { reactive, toRaw, computed } from "vue";
const product = reactive({
    name: "",
    company: "",
    price: "0",
    colors: [],
    info: "",
    madein: "한국",
    sale1: false,
    sale2: "no",
    sex: "woman",
});

function handleSubmit() {
    console.log("handleSubmit() 실행");

    console.log(toRaw(product));
}

const checkData = computed(() => {
    console.log("checkData() 실행");
    var result = product.name !== "" && product.company !== "";
    return result;
});

function handleReset() {
    console.log("handleReset 시작");
    product.name = "";
    product.company = "";
    product.price = 0;
    product.colors = [];
    product.info = "";
    product.madein = "한국";
    product.sale1 = false;
    product.sale2 = "no";
    product.sex = "woman";
}

// function checkData(){
//     console.log("checkData() 실행");
//     var result = product.name !=="" && product.company !== "";
//     return result;
// }
</script>

<style scoped></style>
