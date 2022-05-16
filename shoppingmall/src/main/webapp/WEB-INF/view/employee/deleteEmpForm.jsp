<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteEmpForm</title>
<!-- 부트스트랩 사용링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form method ="post" action="<%=request.getContextPath()%>/DeleteEmpController">
			<table class="table table-hover">
				<tr>
					<td>employeeNo</td>
					<td>
						<input type="text" name="employeeNo" value="">
					</td>
				</tr>
				<tr>
					<td>employeePw</td>
					<td>
						<input type="password" name="employeePw">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>