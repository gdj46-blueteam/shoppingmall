<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%
	Customer customer = (Customer)request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectCustomerOne</title>
</head>
<body>
	<table border="1">
	<h1>MyPage</h1>
	<tr>
		<td>Id</td>
		<td><%=customer.getCustomerId() %></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><%=customer.getCustomerName() %></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><%=customer.getCustomerGender() %></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><%=customer.getCustomerAge() %></td>
	</tr>
	<tr>
		<td>Phone</td>
		<td><%=customer.getCustomerPhone() %></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><%=customer.getCustomerEmail() %></td>
	</tr>
	<tr>
		<td>Country</td>
		<td><%=customer.getCustomerCountry() %></td>
	</tr>
	<tr>
		<td>UpdateDate</td>
		<td><%=customer.getUpdateDate() %></td>
	</tr>
	<tr>
		<td>CreateDate</td>
		<td><%=customer.getCreateDate() %></td>
	</tr>
	<tr>
		<td>authority</td>
		<td><%=customer.getAuthority() %></td>
	</tr>
	<tr>
	<!-- 
	세션에 저장된 authority에 따라 달라지게 합니다.
	+ 세션에 따라 리뷰기능, 견적서 확인 달라지게 하기(회원)
	 -->  
	<%
	// if(세션에 있는 권한이 > 2) {
	%>
	<!-- <a href="<%=request.getContextPath()%>/SelectCustomerOneController">회원목록으로</a> -->
	<%
	// }
	%>
	
	<a href="<%=request.getContextPath()%>/UpdateCustomerController?customerId=<%=customer.getCustomerId() %>&customerName=<%=customer.getCustomerName() %>&customerGender=<%=customer.getCustomerGender() %>&customerAge=<%=customer.getCustomerAge() %>&customerPhone=<%=customer.getCustomerPhone() %>&customerEmail=<%=customer.getCustomerEmail() %>&customerCountry=<%=customer.getCustomerCountry() %>">수정</a>
	<a href="<%=request.getContextPath()%>/DeleteCustomerController?customerId=<%=customer.getCustomerId() %>">삭제</a>
	</tr>
	<!-- 다른 기능들 넣어햐 합니다. -->
	</table>
</body>
</html>