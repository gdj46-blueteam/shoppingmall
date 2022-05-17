<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>관광리스트2</h2>
	<form action="${pageContext.request.contextPath}/SelectTourController" method="get">
		<table>
			<thead>
				<tr>
					<td>tourNo</td>
					<td>tourAreaId</td>
					<td>tourName</td>
					<td>tourDescription</td>
					<td>tourImageNo</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "t" items = "${tourList}">
					<tr>
						<td>${t.tourNo}</td>
						<td>${t.tourAreaId}</td>
						<td>${t.tourName}</td>
						<td>${t.tourDescription}</td>
						<td>${t.tourImageNo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>