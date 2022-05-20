<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>여행상품 수정</h2>
	<form action = "${pageContext.request.contextPath}/UpdateTourController" method="post">
		<table>
			<tr>
				<td>tourNo</td>
				<td><input type="number" name="tourNo" readOnly = "readOnly" value="${tour.tourNo}"></td>
			</tr>
			<tr>
				<td>tourName</td>
				<td><input type="text" name="tourName" value="${tour.tourName }"></td>
			</tr>
			<tr>
				<td>tourDescription</td>
				<td><input type="text" name="tourDescription" value="${tour.tourDescription }"></td>
			</tr>
			<tr>
				<td>province</td>
				<td><input type="text" name = "province" readOnly = "readOnly" value="${tourArea.area}"></td>
			</tr>
			<tr>
				<td>tourCity</td>
				<td><input type="text" name="tourCity" readOnly = "readOnly" value="${tourArea.city}"></td>
			</tr>
			  <tr>
				<td>tourImage</td>
				<td><img src="${pageContext.request.contextPath}/Image/${tourImage.tourImageName}" width="200" height="200"></td>
			</tr>
			<button type="submit">수정</button>
				<a href="${pageContext.request.contextPath}/SelectTourController?tourNo=${tour.tourNo}">목록으로</a>
		</table>
	</form>
</body>
</html>