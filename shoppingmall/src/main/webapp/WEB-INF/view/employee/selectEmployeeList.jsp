<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmployeeList</title>
</head>
<body>
	<h1>직원페이지</h1>
	<ol>
		<li><a href="${pageContext.request.contextPath}/SelectEmpOneController">직원정보</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectEmpMatchingController">배치확인</a></li>
		<li><a href="${pageContext.request.contextPath}/SelectEmpListController">실적확인</a></li>
	</ol>
</body>
</html>