<template>
    <div class="card">
        <div class="card-header">
            Exam07View
        </div>
        <div class="card-body">
            <div class="card">
                <div class="card-header">
                    Path Variables(Parameter)를 이용해서 전달
                </div>
                <div class="card-body">
                    <li><router-link to="/menu01/exam08view/freeboard/blue">/menu01/exam08view/freeboard/blue</router-link></li>
                    <li><router-link :to="`/menu01/exam08view/${kind1}/${color1}`">/menu01/exam08view/{{kind1}}/{{color1}}</router-link></li>
                    <li><router-link :to="{path:`/menu01/exam08view/${kind2}/${color2}`}">/menu01/exam08view/{{kind2}}/{{color2}}</router-link></li>
                    <li><router-link :to="{path:`/menu01/exam08view`, params:{kind:kind3, color:color3}}">/menu01/exam08view/{{kind3}}/{{color3}}</router-link></li>
                    <li><router-link :to="{name:'menu01_exam08view', params:{kind:kind3, color:color3}}">/menu01/exam08view/{{kind3}}/{{color3}}</router-link></li>
                    <li>
                        <button @click="goUrlWithParams" class="btn btn-info btn-sm mr-2">/menu01/exam08view/{{kind3}}/{{color3}}</button>
                        <a href = "#" @click="goUrlWithParams" class = "btn btn-info btn-sm mr-2">/menu01/exam08view/{{kind3}}/{{color3}} </a>
                    </li>
                </div>
            </div>
        </div>
        <div class="card">
                <div class="card-header">
                    Query String을 이용해서 전달
                </div>
                <div class="card-body">
                    <li><router-link to="/menu01/exam08view?kind=freeboard&color=blue">/menu01/exam08view/freeboard/blue</router-link></li>
                    <li><router-link :to="`/menu01/exam08view?kind=${kind1}&color=${color1}`">/menu01/exam08view?kind={{kind1}}&color={{color1}}</router-link></li>
                    <li><router-link :to="{path:'/menu01/exam08view',query:{kind:kind2, color:color2}}">/menu01/exam08view?kind={{kind2}}&color={{color2}}</router-link></li>
                    <li><router-link :to="{name:'menu01_exam08view', query:{kind:kind3, color:color3}}">/menu01/exam08view?kind={{kind3}}&color={{color3}}</router-link></li>
                    <li>
                        <button @click="goUrlWithQueryString" class="btn btn-info btn-sm mr-2">/menu01/exam08view?kind={{kind3}}&color={{color3}}</button>
                        <a href = "#" @click="goUrlWithQueryString" class = "btn btn-info btn-sm mr-2">/menu01/exam08view?kind={{kind3}}&color={{color3}} </a>
                    </li>
                </div>
            </div>
    </div>
</template>

<script setup>
    import { useRouter} from "vue-router";
    const router = useRouter();

    const kind1 = "notice";
    const color1 = "red";

    const kind2 = "qa";
    const color2 = "green";

    const kind3 = "album";
    const color3 = "blue";

    function goUrlWithParams(){
        router.push(`/menu01/exam08view/${kind3}/${color3}`);
    }

    function goUrlWithQueryString(){
        router.push(`/menu01/exam08view?kind=${kind3}&color=${color3}`);
    }
</script>

<style scoped></style>
