<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
		Customer customer = new Customer();
		customer = (Customer)request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>findId</td>
			<td><%=customer.getCustomerId() %></td>
		</tr>
		<tr>
			<a href="<%=request.getContextPath()%>/LoginController">로그인하러가기</a>
		</tr>
	</table>
</body>
</html>