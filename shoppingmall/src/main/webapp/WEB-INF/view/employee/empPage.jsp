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
			<tr>
				<td>employeeNo</td>
				<td>employeeName</td>
				<td>employeeImageName</td>
			</tr>	
			<c:forEach var="e" items="${list}">
				<tr>
					<td>${e.employeeNo}</td>
					<td><a href="${pageContext.request.contextPath}/SelectEmpOneController?employeeNo=${e.employeeNo}">${e.employeeName}</a></td>
					<td>${e.employeeImageName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>