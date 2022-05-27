<template>
    <ul class="nav flex-column">
        <li class="nav-item">
            <h6 class="text-white">Vue Home</h6>
            <router-link to="/" class="nav-link text-warning">Home</router-link>
            <router-link to="/about" class="nav-link text-warning">Abount</router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu01</h6>
            <router-link to="/menu01/exam01view" class="nav-link text-warning">Exam01View: 뷰 컴포턴트(싱글)</router-link>
            <router-link to="/menu01/exam02view" class="nav-link text-warning">Exam02view: 뷰 컴포턴트(폴더)</router-link>
            <router-link to="/menu01/exam03view" class="nav-link text-warning">Exam03view: 뷰 컴포넌트(공통 및 로컬)</router-link>
            <router-link to="/menu01/exam04view" class="nav-link text-warning">Exam04view: 뷰 이동</router-link>
            <router-link to="/menu01/exam05view" class="nav-link text-warning">Exam05view: 중첩된 라우트</router-link>
            <router-link to="/menu01/exam06view" class="nav-link text-warning">Exam06view: 특정 위치 컴포턴트 배치;</router-link>
            <router-link to="/menu01/exam07view" class="nav-link text-warning">Exam07view: URL데이터 전달;</router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu02</h6>
            <router-link to="/menu02/exam01binding" class="nav-link text-warning">Exam01Binding: 데이터 바인딩</router-link>
            <router-link to="/menu02/exam02refdata" class="nav-link text-warning">exam02refdata: 반응형 데이터</router-link>
            <router-link to="/menu02/exam03reactivedata" class="nav-link text-warning">exam03reactivedata: 반응형 데이터</router-link>
            <router-link to="/menu02/exam04attributebinding" class="nav-link text-warning">exam04exam04attributebinding: 속성 바인딩</router-link>
            <router-link to="/menu02/exam05formbinding" class="nav-link text-warning">exam05formbinding: 폼 파인딩</router-link>
            <router-link to="/menu02/exam06listrendering" class="nav-link text-warning">exam06listrendering: 범위 반복</router-link>
            <router-link to="/menu02/exam07computedbinding" class="nav-link text-warning">exam07computedbinding: 계산된 속성</router-link>
            <router-link to="/menu02/exam08slot" class="nav-link text-warning">exam08slot: 슬롯</router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu03</h6>
            <router-link to="/menu03/exam01eventhandling" class="nav-link text-warning">exam01eventhandling: 이벤트 처리</router-link>
            <router-link to="/menu03/exam02watch" class="nav-link text-warning">exam02Watch: 속성 감시 </router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu04</h6>
            <router-link to="/menu04/exam01props" class="nav-link text-warning">exam01props: 부모에서 자식으로 props 방식</router-link>
            <router-link to="/menu04/exam02eventemit" class="nav-link text-warning">exam02eventemit: 자식에서 부모로 evnet 방식</router-link>
            <router-link to="/menu04/exam03provideinject" class="nav-link text-warning">exam03provideinject: provide / inject</router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu05</h6>
            <router-link to="/menu05/exam01lifecyclehooks" class="nav-link text-warning">Exam01LifeCycleHooks: 부모에서 자식으로 props 방식</router-link>
            <router-link to="/menu05/exam02templaterefs" class="nav-link text-warning">Exam02TemplateRefs: 요소 참조</router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu06</h6>
            <router-link to="/menu06/exam01rootstate" class="nav-link text-warning">exam01rootstate: 루트 상태 읽기 및 변경</router-link>
            <router-link to="/menu06/exam02counterstate" class="nav-link text-warning">exam02counterstate: counter 상태 읽기 및 변경</router-link>
        </li>

        <li class="nav-item">
            <h6 class="text-white">menu07</h6>
            <router-link to="/menu07/exam07asynccontrol" class="nav-link text-warning">exam01AsyncControl: 스피너 보여주기</router-link>
            <router-link to="/menu07/board/list" class="nav-link text-warning">Board List: 게시물 목록</router-link>
        </li>
    </ul>
</template>
