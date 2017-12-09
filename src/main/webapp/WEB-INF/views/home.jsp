<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>학적 조회</h3>

	<p>
		<a href="${pageContext.request.contextPath}/offers">전체 학점 조회</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/typegrade">이수 구분별 학점</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/createoffer">2018년 1학기 수강신청</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/registerhistory">수강신청내역 조회</a>
	</p>
	
	


	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">로그 아웃</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>


</body>
</html>