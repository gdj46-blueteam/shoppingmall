<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select Matching</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>배치 확인</h3>
		<table class = "table table-bordered">
			<tr>
				<td>직원 번호</td>
				<td></td>
			</tr>
			<tr>
				<td>직원 이름</td>
				<td></td>
			</tr>
			<tr>
				<td>고객 아이디</td>
				<td></td>
			</tr>
			<tr>
				<td>여행 날짜</td>
				<td></td>
			</tr>	
		</table>
		<div>
		<a href="${pageContext.request.contextPath}/SelectEmpListController" class=" ">직원 목록</a> 		
	</div>
	</div>
</body>
</html>