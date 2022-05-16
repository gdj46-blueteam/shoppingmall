<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>회원가입</h1>
	<table>
		<form method="post" action="<%=request.getContextPath()%>/InsertCustomerController">
			<tr>
				<td>customerId</td>
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<tr>	
				<td>customerName</td>
				<td><input type="text" name="customerName"></td>
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
					<input name="customerAge" type="number">
				</td>
			</tr>
			<tr>
				<td>customerPhone</td>
				<td>
					<input name="customerPhone" type="text" >
				</td>
			</tr>
			<tr>
				<td>customerEmail</td>
				<td>
					<input name="customerEmail" type="text" >
				</td>
			</tr>
			<tr>
				<td>customerCountry</td>
				<td>
					<input name="customerCountry" type="text" >
				</td>
			</tr>
			<button type="submit">가입</button>
		</form>
		<a href="<%=request.getContextPath()%>/LoginController">뒤로</a>
	</table>
</body>
</html>