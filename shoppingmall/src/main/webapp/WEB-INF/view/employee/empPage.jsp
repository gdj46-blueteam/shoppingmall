<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empPage</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>employee List</h3>
		<table class = "table table-bordered">
			
			<c:forEach var="e" items="${list}">
				<tr>
				<td>employeeNo</td>
				<td>${e.employeeNo}</td>
			</tr>	
			<tr>
				<td>employeeName</td>
				<td><a href="${pageContext.request.contextPath}/SelectEmpOneController?employeeNo=${e.employeeNo}">${e.employeeName}</a></td>
			</tr>
				<tr>
				
					<td>employeeImage</td>
					<td><img src="./Image/${e.employeeImageName}" width="200" height="200"></td>
		
					<%-- <td><img alt="직원사진" src="${pageContext.request.contextPath}/image/${e.employeeImageName}" width="100" height="100"></td>  --%>
				</tr>
			</c:forEach>
		</table>
		<div>
		<a href="${pageContext.request.contextPath}/InsertEmpContoller" class=" ">직원 등록</a>
	</div>
	</div>
</body>
</html>