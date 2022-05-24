<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
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
			<td>${map.ReviewNo}</td>
		</tr>
		
		<tr>
			<td>CustomerId</td>
			<td>${map.CustomerId} </td>
		</tr>
		
		<tr>
			<td>review</td>
			<td>${map.review} </td>
		</tr>
		
		<tr>
			<td>EmployeeName</td>
			<td>${map.EmployeeName} </td>
		</tr>
		
		<tr>
			<td>area</td>
			<td>${map.area} </td>
		</tr>
		
		<tr>
			<td>city</td>
			<td>${map.city} </td>
		</tr>
	</table>
</body>
</html>