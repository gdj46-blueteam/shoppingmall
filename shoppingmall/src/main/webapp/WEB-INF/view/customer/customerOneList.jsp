<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectCustomerOne</title>
</head>
<body>
	<table border="1">
	<h1>회원정보</h1>
	<tr>
		<td>Id</td>
		<td>${customer.customerId }</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${customer.customerName }</td>
	</tr>
	<tr>
		<td>Gender</td>
		<td>${customer.customerGender }</td>
	</tr>
	<tr>
		<td>Age</td>
		<td>${customer.customerAge }</td>
	</tr>
	<tr>
		<td>Phone</td>
		<td>${customer.customerPhone }</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${customer.customerEmail }</td>
	</tr>
	<tr>
		<td>Country</td>
		<td>${customer.customerCountry }</td>
	</tr>
	<tr>
		<td>CreateDate</td>
		<td>${customer.createDate }</td>
	</tr>
	<tr>
	<!-- 
	세션에 저장된 authority에 따라 달라지게 합니다.
	+ 세션에 따라 리뷰기능, 견적서 확인 달라지게 하기(회원)
	 -->  
	<%
	// if(세션에 있는 권한이 > 2) {
	%>
	<!-- <a href="${pageContext.request.contextPath}/SelectCustomerOneController">회원목록으로</a> -->
	<%
	// }
	%>
	
	<a href="${pageContext.request.contextPath}/UpdateCustomerController?customerId=${customer.customerId }&customerName=${customer.customerName }&customerGender=${customer.customerGender }&customerAge=${customer.customerAge }&customerPhone=${customer.customerPhone }&customerEmail=${customer.customerEmail }&customerCountry=${customer.customerCountry }">수정</a>
	<a href="${pageContext.request.contextPath}/DeleteCustomerController?customerId=${customer.customerId }">삭제</a>
	</tr>
	<!-- 다른 기능들 넣어햐 합니다. -->
	</table>
</body>
</html>