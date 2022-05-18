<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 수정</h1>
	<form method="post" action="${pageContext.request.contextPath}/UpdateCustomerController">
		<table class="table">
			<tr>
				<td>customerId</td>
				<td><input type="text" name="customerId" value="${customer.customerId }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<tr>	
				<td>customerName</td>
				<td><input type="text" name="customerName" " value="${customer.customerName }"></td>
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
					<input name="customerAge" type="number" value="${customer.customerAge }">
				</td>
			</tr>
			<tr>
				<td>customerPhone</td>
				<td>
					<input name="customerPhone" type="text" value="${customer.customerPhone }>">
				</td>
			</tr>
			<tr>
				<td>customerEmail</td>
				<td>
					<input name="customerEmail" type="text" value="${customer.customerEmail }">
				</td>
			</tr>
			<tr>
				<td>customerCountry</td>
				<td>
					<input name="customerCountry" type="text" value="${customer.customerCountry }">
				</td>
			</tr>
			<a href="${pageContext.request.contextPath}/SelectCustomerOneController?customerId=${customer.customerId }">뒤로</a>
			<button type="submit">수정</button>
		</table>
	</form>
</body>
</html>