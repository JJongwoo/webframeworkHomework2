<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, td{
	border : 1px solid black;
	border-collapse:collapse;
	border-spacing:0;
	text-align:center;
}
</style>
</head>
<body>

	<table>
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세보기</td>
		</tr>
		
		<c:forEach var="totalgrade" items="${grades}">
		<tr>
			<td>${totalgrade.year}</td>
			<td>${totalgrade.semester}</td>
			<td>${totalgrade.credit}</td>
			<td><a href="${pageContext.request.contextPath}/detail">링크</a></td>
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>