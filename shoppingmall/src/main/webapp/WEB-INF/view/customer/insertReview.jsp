<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰 입력</h1>
	<form method="post" action="${pageContext.request.contextPath}/InsertReviewController">
		
		
		<table border="1">
	
		<input type="text" id="reviewNo" name="reviewNo" value="" hidden="hidden">

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
		<button type="button" id="signup">등록</button>
	</form>
</body>
</html>