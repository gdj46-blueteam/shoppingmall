<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/DeleteTourController">
			<table border="1">
				<tr>
					<td>tourNo</td>
					<td><input type="text" name="tourNo" value="${tour.tourNo}" readonly="readonly"></td>	
				</tr>
				<tr>
					<td>tourName</td>
					<td>${tour.tourName}</td>	
				</tr>
				<tr>
					<td>tourDescription</td>
					<td>${tour.tourDescription}</td>	
				</tr>
							<tr>
					<td>province</td>
					<td>${tourArea.area}</td>	
				</tr>	
				<tr>
					<td>tourCity</td>
					<td>${tourArea.city}</td>	
				</tr>	
				<tr>
					<td>tourImage</td>
					<td><img src="${pageContext.request.contextPath}/Image/${tourImage.tourImageName}" width="200" height="200"></td>
				</tr>
			</table>
			<button type="submit" >삭제</button>
			<a href="${pageContext.request.contextPath}/UpdateTourController?tourNo=${tour.tourNo}">수정</a>
	</form>
</body>
</html>