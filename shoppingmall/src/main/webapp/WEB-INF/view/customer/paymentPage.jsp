<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제</h1>
	<form method="post" action="${pageContext.request.contextPath}/SelectEstimateController">
		<table>
			<tr>
				<td>견적서번호</td>
				<td><input type="number" name = "estimateNo" value="${estimateNo }" readonly="readonly">${estimateNo }</td>
			</tr>
			<tr>
				<td>은행</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text"></td>
			</tr>
		</table>
		<button type="submit">결제</button>
	</form>
</body>
</html>