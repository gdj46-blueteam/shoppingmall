<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>로그인</h1>
	<form action = "${pageContext.request.contextPath}/LoginController" method="post">
 		 <table class="table table-striped">
			<tr>
				<td>memberId</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>memberPw</td>
			<td><input type="password" name="pw"></td>
			</tr>
		</table>
		<button type="submit">로그인</button>
	</form></body>
</html>