<template>
    <div class="card">
        <div class = "card-header">
            list Board
        </div>
        <div class="card-body">

            <!-- page처리 시 null을 binding 할 수 없기 때문이다. //setup 구성 전에 dom이 생성 될 수 있기 때문에 에러가 발생할 수도 있다.  -->
            <div v-if="page != null"> 
                <div class = "mb-3">
                    <router-link to="/menu07/board/writeform" class="btn btn-info btn-sm mr-2"> 생성 </router-link>
                </div>
                
                <table class="table table-sm table-striped table-bordered">
                    <thead>
                        <tr>
                        <th class="text-center" style="width:70px">번호</th>
                        <th class="text-center">제목</th>
                        <th class="text-center" style="width:90px">글쓴이</th>
                        <th class="text-center" style="width:120px">날짜</th>
                        <th class="text-center" style="width:70px">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <tr v-for="board in page.boards" :key="board.bno">
                            <td class="text-center">{{board.bno}}</td>
                            <td >
                                <router-link :to = "`/menu07/board/read?bno=${board.bno}&pageNo=${page.pager.pageNo}&hit=true`">
                                    {{board.btitle}}
                                </router-link>
                                
                            </td>
                            <td >{{board.mid}}</td>
                            <td >{{new Date(board.bdate).toLocaleDateString()}}</td>
                            <td >{{board.bhitcount}}</td>
                        </tr>
                        <tr>
                            <td colspan="5" class="text-center">
                                <button @click="changePageNo(1)"    class = "btn btn-outline-primary btn-sm mr-1">처음</button>
                                <button v-if="page.pager.groupNo > 1" @click="changePageNo(page.pager.startPageNo-1)" class = "btn btn-outline-info btn-sm mr-1">이전</button>
                                <!-- <button v-for = "pageNo in range(page.pager.startPageNo, page.pager.endPageNo)" @click="changePageNo(pageNo)" 
                                    :key="pageNo" class = "btn btn-outline-success btn-sm mr-1" :class = "{'btn-outline-success':(page.pager.pageNo!=pageNo), 'btn-danger':(page.pager.pageNo==pageNo)}">{{pageNo}}</button> -->
                                <button v-for = "pageNo in range(page.pager.startPageNo, page.pager.endPageNo)" @click="changePageNo(pageNo)" 
                                    :key="pageNo" :class = "(page.pager.pageNo==pageNo)?'btn-danger':'btn-outline-success'">{{pageNo}}</button>
                                
                                <button v-if="page.pager.groupNo < page.pager.totalGroupNo" @click="changePageNo(page.pager.endPageNo+1)" class = "btn btn-outline-info btn-sm mr-1">다음</button>
                                <button @click="changePageNo(page.pager.totalPageNo)" class = "btn btn-outline-primary btn-sm mr-1">맨끝</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script setup>
    //import {getBoardList} from "@/apis/board";
    import apiBoard from "@/apis/board"; 
    import {ref, watch} from "vue";
    import {useRoute, useRouter } from "vue-router";

    //반응형 속성 선언
    const page = ref(null);
    const route = useRoute();
    const router = useRouter();


    //라우팅시에 전달된 query String에서 pageNo을 읽기
    let pageNo = route.query.pageNo;

    //페이지가 없을 경우 디폴트로 1을 선언한다. 
    if(pageNo === "undefined"){
        pageNo = 1;
    }

    //rest api와 통신하여 페이지에 대한 정보(게시물 목록 + 페이지)를 가져온다. 이때 page라는 반응형 속성에 저장한다. 
    async function getBoardList(pageNo){
        //apis의 function이 비동기 방식이므로 반드시 await으로 호출해야 한다. 
        const result = await apiBoard.getBoardList(pageNo);
        if(result !=null){
            page.value = result;
            console.log(page.value);
        } 
    }
    getBoardList(pageNo);

    function range(start, end){
        const numbers = [];
        for(var i = start; i <= end; i++){
            numbers.push(i);
        }
        return numbers;
    }

    function changePageNo(pageNo){
        router.push(`/menu07/board/list?pageNo=${pageNo}`);
    }

    watch(route, (newUrl, oldUrl) => {
    if(newUrl.path == "/menu07/board/list"){
        if(newUrl.query.pageNo){
        getBoardList(newUrl.query.pageNo);
        }else{
        getBoardList(1);
        }
    }
    });
</script>

<style scoped>

</style>