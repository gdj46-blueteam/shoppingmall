<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteCustomerForm</title>
</head>
<body>
	<table>
		<form method="post" action="${pageContext.request.contextPath}/DeleteCustomerController">
			<tr>
				<td>customerId</td>
				<td><input type="text" name="customerId" value="${customer.customerId }" readonly = "readonly"></td>
			</tr>
			<tr>
				<td>customerPw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<button type="submit">삭제</button>
		</form>
		<a href="${pageContext.request.contextPath}/SelectCustomerOneController?customerId=${customer.customerId }">뒤로</a>
	</table>
</body>
</html>