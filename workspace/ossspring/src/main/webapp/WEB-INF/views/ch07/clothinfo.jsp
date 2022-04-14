<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
     modelattrivute를 이요한 데이터 전달
   </div>
   <div class="card-body">
   
   		<p>cloth kind: ${kind }</p>
   		<p>cloth sex: ${sex }</p>
   		
   </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>