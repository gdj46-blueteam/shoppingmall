<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%
	Employee employee = new Employee();
	employee = (Employee)request.getAttribute("employee");
%>
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
		<table class="table table-hover">
			<form method ="post" action="<%=request.getContextPath()%>/DeleteEmpController">
				<tr>
					<td>employeeNo</td>
					<td>
						<input type="text" name="employeeNo" value="${employeeNo}">
					</td>
				</tr>
				<tr>
					<td>employeePw</td>
					<td>
						<input type="password" name="employeePw">
					</td>
				</tr>
				<button type = "submit">삭제</button>
			</form>
			<a href ="<%=request.getContextPath()%>/SelectEmpListController?employeeNo=<%=employee.getEmployeeNo()%>">뒤로가기</a>
		</table>
	</div>
</body>
</html>