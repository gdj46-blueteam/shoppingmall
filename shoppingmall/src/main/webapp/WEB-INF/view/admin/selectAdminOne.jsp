<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<td>${admin.adminId }</td>
	</tr>
	<tr>
		<td>Pw</td>
		<td>${admin.adminPw	 }</td>
	</tr>
	<tr>
		<td>Phone</td>
		<td>${admin.adminPhone }</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${admin.adminEmail }</td>
	</tr>
	<tr>
		<td>AddressId</td>
		<td>${admin.adminAddressId }</td>
	</tr>
	<tr>
		<td>AddressDetail</td>
		<td>${admin.addressDetail }</td>
	</tr>
	<tr>
		<td>CreateDate</td>
		<td>${admin.createDate }</td>
	</tr>
	<tr>
		<td>authority</td>
		<td>${admin.authority }</td>
	</tr>
	<a href = "${pageContext.request.contextPath}/SelectAdminListController">뒤로</a>
	</table>
</body>
</html>