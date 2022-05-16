<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert employee Form</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>insert employee</h3>
		<form method="post" action="<%=request.getContextPath()%>/InsertEmpContoller">
			<table class ="table table-hover">
				<%-- <tr>
					<td>employeeNo</td>
					<td>
						<input type ="text" name="employeeNo" readonly ="readonly">
					</td>
				</tr> --%>
				<tr>
					<td>employeePw</td>
					<td>
						<input type ="password" name="employeePw">
					</td>
				</tr>
				<tr>
					<td>employeeSn</td>
					<td>
						<input type ="text" name="employeeSn">
					</td>
				</tr>
				<tr>
					<td>empAddressId</td>
					<td>
						<input type ="text" name="empAddressId">
					</td>
				</tr>
				<tr>
					<td>employeeAddressDetail</td>
					<td>
						<input type ="text" name="employeeAddressDetail">
					</td>
				</tr>
				<tr>
					<td>employeeName</td>
					<td>
						<input type ="text" name="employeeName">
					</td>
				<tr>
					<td>employeeEmail</td>
					<td>
						<input type ="text" name="employeeEmail">
					</td>
				</tr>
				<tr>
					<td>employeePhone</td>
					<td>
						<input type ="text" name="employeePhone">
					</td>
				</tr>
				<tr>
					<td>employeeGender</td>
					<td>
						<input type ="text" name="employeeGender">
					</td>
				</tr>
				<!-- <tr>
					<td>employeeImageNo</td>
					<td>
						<input type ="text" name="employeeImageNo">
					</td>
				</tr> -->
				<tr>
					<td>employeeIntroduce</td>
					<td>
						<input type ="text" name="employeeIntroduce">
					</td>
				</tr>
			</table>
			<button type = "submit">직원등록</button>
		</form>
	</div>
</body>
</html>