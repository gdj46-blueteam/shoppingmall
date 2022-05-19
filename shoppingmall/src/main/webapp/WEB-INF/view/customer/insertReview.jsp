<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>reivew</h1>
	<form method="post" action="${pageContext.request.contextPath}/InsertReviewController">
	<td><!-- 사용자ID(히든처리) --></td>
	<td><!-- 옵션ID(히든처리) --></td>
	<td><!-- 견적서ID(히든처리) --></td>
	<td><input type="text" name="review"></td>
	</form>
</body>
</html>