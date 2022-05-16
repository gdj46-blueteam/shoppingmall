<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form method="get" action="<%=request.getContextPath()%>/FindCustomerIdController">
			<tr>customerEmail : </tr>
			<tr><input type="text" name="customerEmail"></tr>
			<button type="submit">찾기</button>
		</form>
	</table>
</body>
</html>