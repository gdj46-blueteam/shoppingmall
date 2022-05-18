<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectCustomerList</title>
</head>
<body>
	<table border = "1">
	<tr>
		<th>customerId</th>
		<th>customerName</th>
		<th>customerCountry</th>
		<th>customerGender</th>
	</tr>
	<c:forEach var="c" items="${customer}">
		<tr>
			<td>${c.customerId}</td>
			<td><a href="SelectCustomerOneController?customerId=${c.customerId}">${c.customerId}</a></td>
			<td>${c.customerName }</td>
			<td>${c.customerCountry }</td>
			<td>${c.customerGender }</td>
		</tr>
	</c:forEach>
	 </table>
</body>
</html>