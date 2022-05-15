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
<title>Insert title here</title>
</head>
<body>
	<h1>회원 수정</h1>
	<form method="post" action="<%=request.getContextPath()%>/UpdateCustomerController">
		<table class="table">
			<tr>
				<td>customerId</td>
				<td><input type="text" name="customerId" value="<%=customer.getCustomerId()%>"></td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<tr>	
				<td>customerName</td>
				<td><input type="text" name="customerName" " value="<%=customer.getCustomerName()%>"></td>
			</tr>
			<tr>
				<td>customerGender</td>
				<td>
				<input type='radio' name='customerGender' value='남'>남
				<input type='radio' name='customerGender' value='여'>여
				</td>
			</tr>
			<tr>
				<td>customerAge</td>
				<td>
					<input name="customerAge" type="number" value="<%=customer.getCustomerAge()%>">
				</td>
			</tr>
			<tr>
				<td>customerPhone</td>
				<td>
					<input name="customerPhone" type="text" value="<%=customer.getCustomerPhone()%>">
				</td>
			</tr>
			<tr>
				<td>customerEmail</td>
				<td>
					<input name="customerEmail" type="text" value="<%=customer.getCustomerEmail()%>">
				</td>
			</tr>
			<tr>
				<td>customerCountry</td>
				<td>
					<input name="customerCountry" type="text" value="<%=customer.getCustomerCountry()%>">
				</td>
			</tr>
			<a href="<%=request.getContextPath()%>/SelectCustomerOneController?customerId=<%=customer.getCustomerId()%>">뒤로</a>
			<button type="submit">수정</button>
		</table>
	</form>
</body>
</html>