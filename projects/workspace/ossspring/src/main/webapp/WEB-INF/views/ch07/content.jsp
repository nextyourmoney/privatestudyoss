<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		hsp 템플릿 엔진
	</div>
	<div class="card-body">
		오늘 날짜: <%=request.getAttribute("strDate")%><br/>
		오늘 날짜: ${strDate} 
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
		객체 저장 범
	</div>
	<div class="card-body">
		<p>requset 범위 객체 값: <%=request.getAttribute("requestScopeValue")%></p>
		<p>session 범위 객체 값: <%=session.getAttribute("sessionScopeValue")%></p> 
		<p>application 범위 객체 값: <%=application.getAttribute("applicationScopeValue")%></p>
		
		<hr/>
		
		<p>	
			<!-- 찾는 범위 request -> session -> application  -->
			request 범위 객체 값: {requestScopeValue }<br/>
			member's name: ${member.name }<br/>
			member's age: ${member.age }<br/>
			member's job: ${member.job }<br/>
			member's city: ${member.city.name }<br/>
		</p>
		
		<hr/>
		
		<p>
			session 범위 객체 값: {sessionScopeValue}<br/>
			member's name: ${member2.name }<br/>
			member's age: ${member2.age }<br/>
			member's job: ${member2.job }<br/>
			member's city: ${member2.city.name }<br/>
		</p>
		
		<hr/>
		
		<p>requset 범위 객체 값: ${requestScopeValue }</p>
		<p>session 범위 객체 값: ${sessionScopeValue }</p>
		<p>application 범위 객체 값: ${applicationScopeValue }</p>
		
		<hr/>
		
		<p>
			application 범위 객체 값: ${applicationScopeValue} <br/>
			방문 카툰이: ${counter}
		</p>
		
		<a href = "requestScopeSave" class = "btn btn-info btn-sm mr-2">request 범위에 객체 저장</a>
		<a href = "sessionScopeSave" class = "btn btn-info btn-sm mr-2">session 범위에 객체 저장</a>
		<a href = "applicationScopeSave" class = "btn btn-info btn-sm mr-2">application 범위에 객체 저장</a>
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
		JSTL(java standard tag library)
	</div>
	<div class="card-body">
		<a href = "useJstl1" class = "btn btn-info btn-sm mr-2">jstl 사용하기</a>
		<a href = "useJstl2" class = "btn btn-info btn-sm mr-2">session 범위에 객체 저장</a>
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
		ModelAndView로 객체 전달
	</div>
	<div class="card-body">
		<a href = "ModelAndViewReturn" class = "btn btn-info btn-sm mr-2">ModelAndViewReturn</a>
		
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
		Model 매게변수로 객체 전달
	</div>
	<div class="card-body">
		<a href = "modelArgument" class = "btn btn-info btn-sm mr-2">Model </a>
		
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
		modelattrivute로 객체 전달
	</div>
	<div class="card-body">
		<a href = "modelAttribute?kind=suit&sex=woman" class = "btn btn-info btn-sm mr-2">modelattrivute로 객체 전달 </a>
		
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
	command(DTO) 객체로 전달
	</div>
	<div class="card-body">
		<a href = "commandObject?kind=suit&sex=woman" class = "btn btn-info btn-sm mr-2">modelattrivute로 객체 전달 </a>
		
	</div>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp" %>