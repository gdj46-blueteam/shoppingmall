<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statics By Gender</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h4 class="text-dark">성별 통계</h4>
	<div>
		<a href="${pageContext.request.contextPath}/StaticsListController" class="">통계 검색창</a> 		
	</div>
	<table class="table table-bordered small">
		<tr>
			<th>gender</th>
			<th>count</th>	
			<th>rank</th>
		</tr>
		<c:forEach var="map" items="${List}">
			<tr>
				<td>${map.gender}</td>
				<td>${map.cnt}</td>
				<td>${map.rank}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>