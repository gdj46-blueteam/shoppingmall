<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form method="post" action="${pageContext.request.contextPath}/DeleteEstimateController">
			<table border="1">

					<tr>
							<td>estimateNo</td>
							<td><input type="text" value="${map.tourDIYNo}" name="tourDIYNo" hidden="hidden"><input type="text" value="${map.estimateNo}" name="estimateNo" ></td>
							
					</tr>
					<tr>
							<td>customerId</td>
							<td>${map.customerId}</td>
					</tr>
					<tr>
							<td>language</td>
							<td>${map.language}</td>
					</tr>
					<tr>
							<td>city</td>
							<td>${map.city}</td>
					</tr>
					<tr>
							<td>employeeName</td>
							<td>${map.employeeName }</td>
					</tr>
					<tr>
							<td>estimatePrice</td>
							<td>${map.estimatePrice }</td>
					</tr>
					<tr>
							<td>tourdiyPeople</td>
							<td>${map.tourDIYPeople}</td>
					</tr>
					<tr>
							<td>tourdiyTerm</td>
							<td>${map.tourDIYTerm}</td>
					</tr>
					<tr>
							<td>tourditStay</td>
							<td>${map.tourDIYStay}</td>
					</tr>
					<tr>
							<td>tourdiyEtc</td>
							<td>${map.tourDIYEtc}</td>
					</tr>
					<tr>
							<td>estimateIng</td>
							<td>${map.estimateIng}</td>
					</tr>
					<tr>
							<td>createDate</td>
							<td>${map.createDate}</td>
					</tr>
	
			</table>
			<button type="submit">삭제</button>
			<a href="${pageContext.request.contextPath}/UpdateEstimateController?estimateNo=${map.estimateNo}&tourDIYNo=${map.tourDIYNo}">수정</a>

		</form>
</body>
</html>