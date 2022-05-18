<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>findPw : </td>
			<td>${customer.customerPw }</td>
		</tr>
		<tr>
			<a href="${pageContext.request.contextPath}/LoginController">로그인하러가기</a>
		</tr>
	</table>
</body>
</html>