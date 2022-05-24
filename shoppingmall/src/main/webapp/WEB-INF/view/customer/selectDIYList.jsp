<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEstimate</title>
</head>
<body>
	<h2>요구사항확인서목록(고객용)</h2>
	<form>
		<table border="1">

					<tr>
							<td>tourdiyNo</td>
							<td>customerId</td>
							<td>language</td>
							<td>city</td>
							<td>tourdiyPeople</td>
							<td>tourdiyTerm</td>
							<td>tourditStay</td>
							<td>tourdiyEtc</td>
							<td>createDate</td>
							
					</tr>


					<c:forEach var="map" items = "${list}">
						<tr>
							<td>${map.tourDIYNo}</td>
							<td>${map.customerId}</td>
							<td>${map.language}</td>
							<td>${map.city}</td>
							<td>${map.tourDIYPeople}</td>
							<td>${map.tourDIYTerm}</td>
							<td>${map.tourDIYStay}</td>
							<td>${map.tourDIYEtc}</td>
							<td>${map.createDate}</td>
							
						</tr>
					</c:forEach>
		</table>
	</form>
</body>
</html>