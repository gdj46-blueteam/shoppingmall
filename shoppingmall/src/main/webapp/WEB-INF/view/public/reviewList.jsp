<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewList</title>
</head>
<body>
		<h1>리뷰 리스트</h1>
			<table border="1">
				<tr>
					<th>reviewNo</th>		
					<th>review</th>
					<th>customerId</th>					
				</tr>
				<c:forEach var="r" items="${reviewList}">  
				<tr>
					<td>${r.reviewNo}</td>
					<td><a href="${pageContext.request.contextPath}/SelectOneReviewController?reviewNo=${r.reviewNo}">${r.review}</a></td>
					<td>${r.customerId}</td>
				</tr>
				</c:forEach>	
			</table>
			<a href="${pageContext.request.contextPath}/InsertReviewController"><button>리뷰작성</button></a>
</body>
</html>