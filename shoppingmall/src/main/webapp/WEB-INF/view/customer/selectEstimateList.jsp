<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>견적서목록</h2>
		<form>
			<table border="1">
				<thead>
					<tr>
							<td>estimateNo</td>
							<td>customerId</td>
							<td>language</td>
							<td>city</td>
							<td>employeeName</td>
							<td>estimatePrice</td>
							<td>tourdiyPeople</td>
							<td>tourdiyTerm</td>
							<td>tourditStay</td>
							<td>tourdiyEtc</td>
							<td>createDate</td>
							<td>updateDate</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="map" items = "${list}">
						<tr> 
							<td><a href="${pageContext.request.contextPath}/DeleteEstimateByCustomerController?estimateNo=${map.estimateNo}&tourDIYNo=${map.tourDIYNo}">${map.estimateNo}</a></td>
							<td>${map.customerId}</td>
							<td>${map.language}</td>
							<td>${map.city}</td>
							<td>${map.employeeName }</td>
							<td>${map.estimatePrice }</td>
							<td>${map.tourDIYPeople}</td>
							<td>${map.tourDIYTerm}</td>
							<td>${map.tourDIYStay}</td>
							<td>${map.tourDIYEtc}</td>
							<td>${map.createDate}</td>
							<td>${map.updateDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
</body>
</html>
