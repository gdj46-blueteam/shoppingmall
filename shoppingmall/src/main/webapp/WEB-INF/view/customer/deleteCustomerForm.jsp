<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "vo.*" %>
<%
	//뷰에 입력하기위해 요청값 넣기
	Customer customer = new Customer();
	customer = (Customer)request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteCustomerForm</title>
</head>
<body>
	<table>
		<form method="post" action="<%=request.getContextPath()%>/DeleteCustomerController">
			<tr>
				<td>customerId</td>
				<td><input type="text" name="customerId" value="<%=customer.getCustomerId()%>" readonly = "readonly"></td>
			</tr>
			<tr>
				<td>customerPw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<button type="submit">삭제</button>
		</form>
		<a href="<%=request.getContextPath()%>/SelectCustomerOneController?customerId=<%=customer.getCustomerId()%>">뒤로</a>
	</table>
</body>
</html>