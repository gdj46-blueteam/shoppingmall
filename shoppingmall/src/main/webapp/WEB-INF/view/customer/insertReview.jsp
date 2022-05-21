<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>inset_Reivew</h1>
	<form method="post" action="${pageContext.request.contextPath}/InsertReviewController">
		<table border="1">
		<tr>
			<th>reviewNo</th>
			<th><input type="text" id="reviewNo" name="reviewNo" value=""></th>
		</tr>
		
		<tr>
			<th>customerId</th>
			<th><input type="text" id="customerId" name="customerId" value="" hidden="hidden"></th>
		</tr>
		
		<tr>
			<th>review</th>
			<th><input type="text" id="review" name="review" value=""></th>
		</tr>
		
		<tr>
			<th>tourdiyNo</th>
			<th><input type="text" id="tourdiyNo" name="tourdiyNo" value=""></th>
		</tr>
		
		<tr>
			<th>estimateNo</th>
			<th><input type="text" id="estimateNo" name="c" value=""></th>
		</tr>
	
		</table>
		<button type="button">등록</button>
	</form>
</body>
</html>