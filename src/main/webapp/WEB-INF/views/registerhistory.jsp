<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
			<td>강의코드</td>
			<td>강의명</td>
			<td>강의구분</td>
			<td>학점</td>
		</tr>
		
		<c:forEach var="offer" items="${offers}">
		<tr>
			<td>${offer.year}</td>
			<td>${offer.semester}</td>
			<td>${offer.classcode}</td>
			<td>${offer.classname}</td>
			<td>${offer.type}</td>
			<td>${offer.credit}</td>
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>