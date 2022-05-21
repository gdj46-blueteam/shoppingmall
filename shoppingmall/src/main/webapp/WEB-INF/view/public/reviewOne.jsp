<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewOne</title>
</head>
<body>
	<h1>리뷰 상세보기</h1>
	<table border="1">
		<tr>
			<td>reviewNo</td>
			<td>${review.reviewNo}</td>
		</tr>
		
		<tr>
			<td>CustomerId</td>
			<td>${review.customerId} </td>
		</tr>
		
		<tr>
			<td>review</td>
			<td>${review.review} </td>
		</tr>
		
		<tr>
			<td>tourdiyNo</td>
			<td>${review.tourdiyNo} </td>
		</tr>
		
		<tr>
			<td>estimateNo</td>
			<td>${review.estimateNo} </td>
		</tr>
	</table>
</body>
</html>