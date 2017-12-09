<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>



<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
	
	<table class="formtable">
		<tr> <td class="label"> 강의코드: </td> <td> <sf:input class="control" type="text" path="classcode"/><br/>
			 </td>
		</tr>
		
		<tr> <td class="label"> 강의명: </td> 
			 <td> <sf:input class="control" type="text" path="classname"/><br/></td> 
		</tr>
		
		<tr> <td class="label"> 강의구분: </td> 
			 <td> <sf:input class="control" type="text" path="type"/><br/></td> 
		</tr>
		
		<tr> <td class="label"> 학점: </td> 
			 <td> <sf:input class="control" type="text" path="credit"/><br/></td> 
		</tr>		
		
		<tr> <td> </td> <td> <input class="control" type="submit" value="수강 신청하기"/> </td> 
		</tr>
		
	</table>

</sf:form>

</body>
</html>