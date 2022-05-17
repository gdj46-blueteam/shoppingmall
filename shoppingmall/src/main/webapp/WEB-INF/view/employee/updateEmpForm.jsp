<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmpForm</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>updateEmpForm</h3>
		<form method = "post" action ="<%=request.getContextPath()%>/UpdateEmpController">
			<table class="table">
				<tr>
					<td>employeeNo</td>
					<td>
						<input type ="text" name="employeeNo" value="${employeeNo}" readonly = "readonly">
					</td>
				</tr>
				<tr>
					<td>employeePw</td>
					<td>
						<input type ="text" name="employeePw">
					</td>
				</tr>
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
					<td>employeeIntroduce</td>
					<td>
						<input type ="text" name="employeeIntroduce">
					</td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>