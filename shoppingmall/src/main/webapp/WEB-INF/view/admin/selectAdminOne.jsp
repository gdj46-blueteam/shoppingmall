<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%
	Admin admin = (Admin)request.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAdminOne</title>
</head>
<body>
	<table border="1">
	<h1>관리자 상세보기</h1>
	<tr>
		<td>Id</td>
		<td><%=admin.getAdminId() %></td>
	</tr>
	<tr>
		<td>Pw</td>
		<td><%=admin.getAdminPw() %></td>
	</tr>
	<tr>
		<td>Phone</td>
		<td><%=admin.getAdminPhone() %></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><%=admin.getAdminEmail() %></td>
	</tr>
	<tr>
		<td>AddresId</td>
		<td><%=admin.getAdminAddressId() %></td>
	</tr>
	<tr>
		<td>AddressDetail</td>
		<td><%=admin.getAddressDetail() %></td>
	</tr>
	<tr>
		<td>CreateDate</td>
		<td><%=admin.getcreateDate() %></td>
	</tr>
	<tr>
		<td>authority</td>
		<td><%=admin.getauthority() %></td>
	</tr>
	</table>
</body>
</html>