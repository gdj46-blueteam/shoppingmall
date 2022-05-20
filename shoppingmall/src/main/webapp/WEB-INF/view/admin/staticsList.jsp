<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Statics List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h3>All Statics Search</h3>
	<div>
		<a href="${pageContext.request.contextPath}/SelectAdminListController" class="">관리자페이지로 돌아가기</a> 		
	</div>
	
	<div>
		<form action="${pageContext.request.contextPath}/CountryStaticsController" method="get" class="form-inline">
		<table class="table table-bordered">
		<tr>
			<td><button type="submit" class="btn btn-primary">나라통계 검색</button></td>
			<td><a href="${pageContext.request.contextPath}/GenderStaticsController" class="btn btn-primary">성별통계 검색</a></td>
			<td><a href="${pageContext.request.contextPath}/AgeStaticsController" class="btn btn-primary">나이통계 검색</a></td>
			<td><a href="${pageContext.request.contextPath}/MonthStaticsController" class="btn btn-primary">월별통계 검색</a></td>
			<td><a href="${pageContext.request.contextPath}/AreaStaticsController" class="btn btn-primary">지역통계 검색</a></td>
		</tr>
		</table>
		</form>
		
	</div>
	<table class="table table-bordered small">
		<tr>
			<th>rank</th>
			<th>country</th>
			<th>gender</th>
			<th>age</th>
			<th>month</th>
			<th>area</th>
			<th>count</th>
		</tr>
		<c:forEach var="map" items="${list}">
			<tr>
				<td>${map.rank}</td>
				<td>${map.country}</td>
				<td>${map.gender}</td>
				<td>${map.age}</td>
				<td>${map.month}</td>
				<td>${map.area}</td>
				<td>${map.cnt}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>